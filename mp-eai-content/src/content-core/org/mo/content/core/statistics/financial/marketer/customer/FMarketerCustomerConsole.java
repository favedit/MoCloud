package org.mo.content.core.statistics.financial.marketer.customer;

import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerCustomerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialMarketerCustomerUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<P>理财师客户关系控制台。</P>
//
//@author sunhr
//@version 151106
//============================================================
public class FMarketerCustomerConsole
      extends FAbstractLogicUnitConsole<FStatisticsFinancialMarketerCustomerLogic, FStatisticsFinancialMarketerCustomerUnit>
      implements
         IMarketerCustomerConsole
{

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMarketerCustomerConsole.class);

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FMarketerCustomerConsole(){
      super(FStatisticsFinancialMarketerCustomerLogic.class, FStatisticsFinancialMarketerCustomerUnit.class);
   }

   //============================================================
   // <T>根据理财师编号获取理财师客户关系数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param marketerId 理财师编号
   // @return 数据集合
   //============================================================
   @Override
   public FLogicDataset<FStatisticsFinancialMarketerCustomerUnit> fetchByMarketerId(ILogicContext logicContext,
                                                                                    long marketerId){
      if(marketerId == 0){
         throw new FFatalError("marketer id can not be empty!");
      }
      FStatisticsFinancialMarketerCustomerLogic logic = logicContext.findLogic(FStatisticsFinancialMarketerCustomerLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FStatisticsFinancialMarketerCustomerLogic.MARKETER_ID + " = ");
      whereSql.append(marketerId);
      _logger.debug(this, "FetchByMarketerId", "FetchByMarketerId create sql finish. (whereSql={1})", whereSql);
      FLogicDataset<FStatisticsFinancialMarketerCustomerUnit> MCList = logic.fetch(whereSql);
      return MCList;
   }
}
