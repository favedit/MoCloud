package org.mo.cloud.logic.resource.bitmap;

import com.cyou.gccloud.data.data.FDataResourceBitmapImageLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>资源位图图像控制台。</T>
//============================================================
public class FGcResBitmapImageConsole
      extends FAbstractLogicUnitConsole<FDataResourceBitmapImageLogic, FGcResBitmapImageInfo>
      implements
         IGcResBitmapImageConsole
{
   //============================================================
   // <T>构造资源位图图像控制台。</T>
   //============================================================
   public FGcResBitmapImageConsole(){
      super(FDataResourceBitmapImageLogic.class, FGcResBitmapImageInfo.class);
   }
}
