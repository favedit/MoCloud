package org.mo.content.core.manage.system.logger.user.notice;

import com.cyou.gccloud.data.logger.FLoggerPersonUserNoticeLogic;
import com.cyou.gccloud.data.logger.FLoggerPersonUserNoticeUnit;

import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>公告日志控制台。</T>
//============================================================
public class FNoticeConsole 
      extends 
         FAbstractLogicUnitConsole<FLoggerPersonUserNoticeLogic, FLoggerPersonUserNoticeUnit>
      implements 
         INoticeConsole 
{
   // 每页条数
   static final int _pageSize = 20;

   // ============================================================
   // <T>构造公告日志控制台。</T>
   // ============================================================
   public FNoticeConsole() {
      super(FLoggerPersonUserNoticeLogic.class, FLoggerPersonUserNoticeUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FLoggerPersonUserNoticeUnit> select(ILogicContext logicContext, 
                                                            int pageNum, 
                                                            int pageSize) {
      if (0 > pageNum) {
         pageNum = 0;
      }
      String orderBy = String.format("%s %s", FLoggerPersonUserNoticeLogic.UPDATE_DATE, "DESC");
      FLoggerPersonUserNoticeLogic logic = new FLoggerPersonUserNoticeLogic(logicContext);
      FLogicDataset<FLoggerPersonUserNoticeUnit> unitlist = logic.fetchClass(FLoggerPersonUserNoticeUnit.class, null, orderBy, pageSize, pageNum);
      return unitlist;
   }

   // ============================================================
   // <T>根据时间段和操作信息查询数据</T>
   // @param logicContext 链接对象
   // @param unit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @param beginDateStr 开始时间
   // @param endDateStr 结束时间
   // @param activeCd 是否激活
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FLoggerPersonUserNoticeUnit> selectByDateandMessage(ILogicContext logicContext, 
                                                                            String beginDateStr, 
                                                                            String endDateStr, 
                                                                            int activeCd, 
                                                                            int pageNum, 
                                                                            int pageSize) {
      if (0 > pageNum) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      whereSql.append(" 1=1 ");
      if (!RString.isEmpty(activeCd+"")) {
         whereSql.append(" and ");
         whereSql.append(FLoggerPersonUserNoticeLogic.ACTIVE_CD + " = '{activeCd}'");
         whereSql.bind("activeCd", RString.parse(activeCd));
      }
      if (!RString.isEmpty(beginDateStr)) {
         whereSql.append(" and ");
         whereSql.append(FLoggerPersonUserNoticeLogic.CREATE_DATE + " >= '{beginDateStr}'");
         whereSql.bind("beginDateStr", RString.parse(beginDateStr));
      }
      if (!RString.isEmpty(endDateStr)) {
         whereSql.append(" and ");
         whereSql.append(FLoggerPersonUserNoticeLogic.CREATE_DATE + " <= '{endDateStr}'");
         whereSql.bind("endDateStr", RString.parse(endDateStr));
      }
      String orderBy = String.format("%s %s", FLoggerPersonUserNoticeLogic.UPDATE_DATE, "DESC");
      FLoggerPersonUserNoticeLogic logic = new FLoggerPersonUserNoticeLogic(logicContext);
      FLogicDataset<FLoggerPersonUserNoticeUnit> unitlist = logic.fetchClass(FLoggerPersonUserNoticeUnit.class, whereSql.toString(), orderBy, pageSize, pageNum);
      return unitlist;
   }
}