package org.mo.content.core.manage.product.user.logger;

import com.cyou.gccloud.data.logger.FLoggerPersonUserAccessLogic;
import com.cyou.gccloud.data.logger.FLoggerPersonUserAccessUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号控制台。</T>
//============================================================
public class FAccessConsole extends FAbstractLogicUnitConsole<FLoggerPersonUserAccessLogic, FLoggerPersonUserAccessUnit>implements IAccessConsole {
   // 每页条数
   static final int _pageSize = 20;

   // ============================================================
   // <T>构造设备控制台。</T>
   // ============================================================
   public FAccessConsole() {
      super(FLoggerPersonUserAccessLogic.class, FLoggerPersonUserAccessUnit.class);
   }

   @Override
   public FLogicDataset<FLoggerPersonUserAccessUnit> select(ILogicContext logicContext, int pageNum, int pageSize) {
      if (0 > pageNum) {
         pageNum = 0;
      }
      String orderBy = String.format("%s %s", FLoggerPersonUserAccessLogic.UPDATE_DATE, "DESC");
      FLoggerPersonUserAccessLogic logic = new FLoggerPersonUserAccessLogic(logicContext);
      FLogicDataset<FLoggerPersonUserAccessUnit> unitlist = logic.fetchClass(FLoggerPersonUserAccessUnit.class, null, orderBy, pageSize, pageNum);
      return unitlist;
   }

   @Override
   public FLogicDataset<FLoggerPersonUserAccessUnit> selectByDateandMessage(ILogicContext logicContext, String beginDateStr, String endDateStr, String logicMessage, int pageNum, int pageSize) {
      if (0 > pageNum) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      whereSql.append(" 1=1 ");
      if (!RString.isEmpty(logicMessage)) {
         whereSql.append(" and ");
         whereSql.append(FLoggerPersonUserAccessLogic.LOGIC_MESSAGE + " LIKE '%{logicMessage}%'");
         whereSql.bind("logicMessage", RString.parse(logicMessage));
      }
      if (!RString.isEmpty(beginDateStr)) {
         whereSql.append(" and ");
         whereSql.append(FLoggerPersonUserAccessLogic.CREATE_DATE + " >= '{beginDateStr}'");
         whereSql.bind("beginDateStr", RString.parse(beginDateStr));
      }
      if (!RString.isEmpty(endDateStr)) {
         whereSql.append(" and ");
         whereSql.append(FLoggerPersonUserAccessLogic.CREATE_DATE + " <= '{endDateStr}'");
         whereSql.bind("endDateStr", RString.parse(endDateStr));
      }
      FLoggerPersonUserAccessLogic logic = new FLoggerPersonUserAccessLogic(logicContext);
      FLogicDataset<FLoggerPersonUserAccessUnit> unitlist = logic.fetchClass(FLoggerPersonUserAccessUnit.class, whereSql.toString(), "UPDATE_DATE DESC", pageSize, pageNum);
      return unitlist;
   }
}
