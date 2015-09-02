package org.mo.content.core.data.common.country;

import com.cyou.gccloud.data.data.FDataCommonCountryLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>国家信息控制台。</T>
//============================================================
public class FCountryConsole
      extends FAbstractLogicUnitConsole<FDataCommonCountryLogic, FCountryInfo>
      implements
         ICountryConsole
{
   // 日志输出接口
   // private static ILogger _logger = RLogger.find(FCountryConsole.class);

   //============================================================
   // <T>构造国家信息控制台。</T>
   //============================================================
   public FCountryConsole(){
      super(FDataCommonCountryLogic.class, FCountryInfo.class);
   }
}
