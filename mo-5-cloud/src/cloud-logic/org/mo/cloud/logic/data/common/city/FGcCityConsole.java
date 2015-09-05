package org.mo.cloud.logic.data.common.city;

import com.cyou.gccloud.data.data.FDataCommonCityLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>城市信息控制台。</T>
//============================================================
public class FGcCityConsole
      extends FAbstractLogicUnitConsole<FDataCommonCityLogic, FGcCityInfo>
      implements
         IGcCityConsole
{
   // 日志输出接口
   // private static ILogger _logger = RLogger.find(FCountryConsole.class);

   //============================================================
   // <T>构造城市信息控制台。</T>
   //============================================================
   public FGcCityConsole(){
      super(FDataCommonCityLogic.class, FGcCityInfo.class);
   }
}
