package org.mo.content.core.manage.product.user.signing;

import com.cyou.gccloud.data.data.FDataPersonUserSigningLogic;
import com.cyou.gccloud.data.data.FDataPersonUserSigningUnit;
import com.cyou.gccloud.data.logger.FLoggerPersonUserAccessLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<P>签到控制台</P>
//@class FSigningConsole
//@version 1.0.0
//============================================================
public class FSigningConsole 
      extends 
         FAbstractLogicUnitConsole<FDataPersonUserSigningLogic, FDataPersonUserSigningUnit>
      implements 
         ISigningConsole 
{

   // 每页条数
   static final int _pageSize = 20;

   // ============================================================
   // <T>构造新闻控制台。</T>
   // ============================================================
   public FSigningConsole() {
      super(FDataPersonUserSigningLogic.class, FDataPersonUserSigningUnit.class);
   }

   // ============================================================
   // <T>获得分页数据列表bySomerow</T>
   // @param logicContext 链接对象
   // @param moduleUnit 查询条件
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataSigningInfo> select(ILogicContext logicContext, 
                                                 FDataSigningInfo unit, 
                                                 int pageNum, 
                                                 int pageSize) {
      if (pageNum < 0) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      if (unit.userId() > 0l) {
         whereSql.append(FDataPersonUserSigningLogic.USER_ID + " = '{userId}'");
         whereSql.bind("userId", RLong.parse(unit.userId()) + "");
      }
      FDataPersonUserSigningLogic logic = logicContext.findLogic(FDataPersonUserSigningLogic.class);
      FLogicDataset<FDataSigningInfo> moduleList = logic.fetchClass(FDataSigningInfo.class, null, whereSql.toString(), null, pageSize, pageNum);
      for (FDataSigningInfo info : moduleList) {
         info.setUserLabel(info.user().label());
      }
      return moduleList;
   }

   // ============================================================
   // <T>根据搜索条件时间段查询分页数据</T>
   // @param logicContext 链接对象
   // @param pageNum 页码
   // @param pageSize 页大小
   // @return 数据集合
   // ============================================================
   @Override
   public FLogicDataset<FDataSigningInfo> selectByDate(ILogicContext logicContext, 
                                                       String beginDateStr, 
                                                       String endDateStr, 
                                                       int pageNum, 
                                                       int pageSize) {
      if (0 > pageNum) {
         pageNum = 0;
      }
      FSql whereSql = new FSql();
      whereSql.append(" 1=1 ");
      if (!RString.isEmpty(beginDateStr)) {
         whereSql.append(" and ");
         whereSql.append(FDataPersonUserSigningLogic.CREATE_DATE + " >= '{beginDateStr}'");
         whereSql.bind("beginDateStr", RString.parse(beginDateStr));
      }
      if (!RString.isEmpty(endDateStr)) {
         whereSql.append(" and ");
         whereSql.append(FDataPersonUserSigningLogic.CREATE_DATE + " <= '{endDateStr}'");
         whereSql.bind("endDateStr", RString.parse(endDateStr));
      }
      String orderBy = String.format("%s %s", FLoggerPersonUserAccessLogic.UPDATE_DATE, "DESC");
      FDataPersonUserSigningLogic logic = new FDataPersonUserSigningLogic(logicContext);
      FLogicDataset<FDataSigningInfo> unitlist = logic.fetchClass(FDataSigningInfo.class, whereSql.toString(), orderBy, pageSize, pageNum);
      for (FDataSigningInfo info : unitlist) {
         info.setUserLabel(info.user().label());
      }
      return unitlist;
   }
}
