package org.mo.cloud.logic.data.common.country;

import com.cyou.gccloud.data.data.FDataCommonCountryLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>国家信息控制台。</T>
//============================================================
public class FGcCountryConsole
      extends FAbstractLogicUnitConsole<FDataCommonCountryLogic, FGcCountryInfo>
      implements
         IGcCountryConsole
{
   // 日志输出接口
   // private static ILogger _logger = RLogger.find(FCountryConsole.class);

   //============================================================
   // <T>构造国家信息控制台。</T>
   //============================================================
   public FGcCountryConsole(){
      super(FDataCommonCountryLogic.class, FGcCountryInfo.class);
   }
}
