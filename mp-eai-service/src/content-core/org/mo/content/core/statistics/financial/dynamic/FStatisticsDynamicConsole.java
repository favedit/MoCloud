package org.mo.content.core.statistics.financial.dynamic;

import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<P>理财师客户业务动态控制台。</P>
//
//@author sunhr
//@version 151108
//============================================================
public class FStatisticsDynamicConsole
      extends FAbstractLogicUnitConsole<FStatisticsFinancialDynamicLogic, FStatisticsFinancialDynamicUnit>
      implements
         IStatisticsDynamicConsole
{

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FStatisticsDynamicConsole.class);

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FStatisticsDynamicConsole(){
      super(FStatisticsFinancialDynamicLogic.class, FStatisticsFinancialDynamicUnit.class);
   }

   //============================================================
   // <T>根据理财师编号获取客户金融业务动态数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param marketerId 理财师编号
   // @return 数据集合
   //============================================================
   @Override
   public FLogicDataset<FStatisticsFinancialDynamicUnit> fetchByMarketerId(ILogicContext logicContext,
                                                                           long marketerId){
      if(marketerId == 0){
         throw new FFatalError("marketer id can not be empty!");
      }
      FStatisticsFinancialDynamicLogic logic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FStatisticsFinancialDynamicLogic.MARKETER_ID + " = ");
      whereSql.append(marketerId);
      _logger.debug(this, "FetchByMarketerId", "FetchByMarketerId create sql finish. (whereSql={1})", whereSql);
      FLogicDataset<FStatisticsFinancialDynamicUnit> dList = logic.fetch(whereSql);
      return dList;
   }
}
