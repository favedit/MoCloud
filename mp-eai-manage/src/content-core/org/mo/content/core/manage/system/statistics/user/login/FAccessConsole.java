package org.mo.content.core.manage.system.statistics.user.login;

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
public class FAccessConsole 
      extends 
         FAbstractLogicUnitConsole<FLoggerPersonUserAccessLogic, FLoggerPersonUserAccessUnit>
      implements 
         IAccessConsole 
{
   // 每页条数
   static final int _pageSize = 20;

   // ============================================================
   // <T>构造设备控制台。</T>
   // ============================================================
   public FAccessConsole() {
      super(FLoggerPersonUserAccessLogic.class, FLoggerPersonUserAccessUnit.class);
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
   public FLogicDataset<FLoggerPersonUserAccessUnit> select(ILogicContext logicContext, 
                                                            int pageNum, 
                                                            int pageSize) {
      if (0 > pageNum) {
         pageNum = 0;
      }
      String orderBy = String.format("%s %s", FLoggerPersonUserAccessLogic.UPDATE_DATE, "DESC");
      FLoggerPersonUserAccessLogic logic = new FLoggerPersonUserAccessLogic(logicContext);
      FLogicDataset<FLoggerPersonUserAccessUnit> unitlist = logic.fetchClass(FLoggerPersonUserAccessUnit.class, null, orderBy, pageSize, pageNum);
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
   // @param logicMessage 操作信息
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FLoggerPersonUserAccessUnit> selectByDateandMessage(ILogicContext logicContext, 
                                                                            String beginDateStr, 
                                                                            String endDateStr, 
                                                                            String logicMessage,
                                                                            String passport,
                                                                            int pageNum, 
                                                                            int pageSize) {
      if (0 > pageNum) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      whereSql.append(" 1=1 ");
      if (!RString.isEmpty(passport)) {
         whereSql.append(" and ");
         whereSql.append(FLoggerPersonUserAccessLogic.PASSPORT + " LIKE '%{passport}%'");
         whereSql.bind("passport", RString.parse(passport));
      }
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
      String orderBy = String.format("%s %s", FLoggerPersonUserAccessLogic.UPDATE_DATE, "DESC");
      FLoggerPersonUserAccessLogic logic = new FLoggerPersonUserAccessLogic(logicContext);
      FLogicDataset<FLoggerPersonUserAccessUnit> unitlist = logic.fetchClass(FLoggerPersonUserAccessUnit.class, whereSql.toString(), orderBy, pageSize, pageNum);
      return unitlist;
   }
   
   // ============================================================
   // <T>查询一天登录成功或失败的数量数据</T>
   // @param logicContext 链接对象
   // @param beginDateStr 开始时间
   // @param endDateStr 结束时间
   // @param logicMessage 操作信息
   // @return 数据集合
   // ============================================================
   @Override
   public Integer getLoginCountByDateandMessage(ILogicContext logicContext, 
                                                String startTimeStr, 
                                                String endTimeStr, 
                                                String logicMessage){
      FSql whereSql = new FSql();
      whereSql.append(FLoggerPersonUserAccessLogic.CREATE_DATE + " >= '{startTimeStr}'");
      whereSql.bind("startTimeStr", RString.parse(startTimeStr));
      whereSql.append(" and ");
      whereSql.append(FLoggerPersonUserAccessLogic.CREATE_DATE + " <= '{endTimeStr}'");
      whereSql.bind("endTimeStr", RString.parse(endTimeStr));
      whereSql.append(" and ");
      whereSql.append(FLoggerPersonUserAccessLogic.LOGIC_MESSAGE + " LIKE '%{logicMessage}%'");
      whereSql.bind("logicMessage", RString.parse(logicMessage));
      FLoggerPersonUserAccessLogic logic = new FLoggerPersonUserAccessLogic(logicContext);
      FLogicDataset<FLoggerPersonUserAccessUnit> unitlist = logic.fetchClass(FLoggerPersonUserAccessUnit.class, whereSql.toString());
      return unitlist.count();
   }
}
