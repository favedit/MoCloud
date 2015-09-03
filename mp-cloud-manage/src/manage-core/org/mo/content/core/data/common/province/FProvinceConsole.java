package org.mo.content.core.data.common.province;

import com.cyou.gccloud.data.data.FDataCommonProvinceLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>省份信息控制台。</T>
//============================================================
public class FProvinceConsole
      extends FAbstractLogicUnitConsole<FDataCommonProvinceLogic, FProvinceInfo>
      implements
         IProvinceConsole
{
   // 日志输出接口
   // private static ILogger _logger = RLogger.find(FCountryConsole.class);

   //============================================================
   // <T>构造省份信息控制台。</T>
   //============================================================
   public FProvinceConsole(){
      super(FDataCommonProvinceLogic.class, FProvinceInfo.class);
   }
}
