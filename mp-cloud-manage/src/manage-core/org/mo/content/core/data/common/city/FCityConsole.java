package org.mo.content.core.data.common.city;

import com.cyou.gccloud.data.data.FDataCommonCityLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>城市信息控制台。</T>
//============================================================
public class FCityConsole
      extends FAbstractLogicUnitConsole<FDataCommonCityLogic, FCityInfo>
      implements
         ICityConsole
{
   // 日志输出接口
   // private static ILogger _logger = RLogger.find(FCountryConsole.class);

   //============================================================
   // <T>构造城市信息控制台。</T>
   //============================================================
   public FCityConsole(){
      super(FDataCommonCityLogic.class, FCityInfo.class);
   }
}
