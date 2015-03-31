package org.mo.cloud.logic.resource.bitmap;

import com.cyou.gccloud.data.data.FDataResource3dStreamLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>资源位图信息控制台。</T>
//============================================================
public class FGcResBitmapConsole
      extends FAbstractLogicUnitConsole<FDataResource3dStreamLogic, FGcResBitmapInfo>
      implements
         IGcResBitmapConsole
{
   //============================================================
   // <T>构造资源位图信息控制台。</T>
   //============================================================
   public FGcResBitmapConsole(){
      super(FDataResource3dStreamLogic.class, FGcResBitmapInfo.class);
   }
}
