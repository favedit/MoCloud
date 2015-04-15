package org.mo.cloud.logic.resource.model.skeleton;

import com.cyou.gccloud.data.data.FDataResourceModelSkeletonSkinLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>资源模型骨骼蒙皮控制台。</T>
//============================================================
public class FGcResModelSkeletonSkinConsole
      extends FAbstractLogicUnitConsole<FDataResourceModelSkeletonSkinLogic, FGcResModelSkeletonSkinInfo>
      implements
         IGcResModelSkeletonSkinConsole
{
   //============================================================
   // <T>构造资源模型骨骼蒙皮控制台。</T>
   //============================================================
   public FGcResModelSkeletonSkinConsole(){
      super(FDataResourceModelSkeletonSkinLogic.class, FGcResModelSkeletonSkinInfo.class);
   }
}
