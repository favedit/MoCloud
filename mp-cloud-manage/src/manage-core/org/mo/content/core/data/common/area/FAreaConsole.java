package org.mo.content.core.data.common.area;

import com.cyou.gccloud.data.data.FDataCommonAreaLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>地区信息控制台。</T>
//============================================================
public class FAreaConsole
      extends FAbstractLogicUnitConsole<FDataCommonAreaLogic, FAreaInfo>
      implements
         IAreaConsole
{
   // 日志输出接口
   // private static ILogger _logger = RLogger.find(FCountryConsole.class);

   //============================================================
   // <T>构造地区信息控制台。</T>
   //============================================================
   public FAreaConsole(){
      super(FDataCommonAreaLogic.class, FAreaInfo.class);
   }
}
