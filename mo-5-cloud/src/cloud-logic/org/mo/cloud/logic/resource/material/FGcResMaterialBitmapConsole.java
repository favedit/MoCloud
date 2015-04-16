package org.mo.cloud.logic.resource.material;

import com.cyou.gccloud.data.data.FDataResourceMaterialBitmapLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>资源材质信息控制台。</T>
//============================================================
public class FGcResMaterialBitmapConsole
      extends FAbstractLogicUnitConsole<FDataResourceMaterialBitmapLogic, FGcResMaterialBitmapInfo>
      implements
         IGcResMaterialBitmapConsole
{
   //============================================================
   // <T>构造资源位图信息控制台。</T>
   //============================================================
   public FGcResMaterialBitmapConsole(){
      super(FDataResourceMaterialBitmapLogic.class, FGcResMaterialBitmapInfo.class);
   }
}
