package org.mo.cloud.logic.resource;

import com.cyou.gccloud.data.data.FDataResourceResourceLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>资源信息控制台。</T>
//============================================================
public class FGcResourceConsole
      extends FAbstractLogicUnitConsole<FDataResourceResourceLogic, FGcResourceInfo>
      implements
         IGcResourceConsole
{
   //============================================================
   // <T>构造资源信息控制台。</T>
   //============================================================
   public FGcResourceConsole(){
      super(FDataResourceResourceLogic.class, FGcResourceInfo.class);
   }
}
