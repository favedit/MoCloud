package org.mo.cloud.logic.resource.model.skeleton;

import com.cyou.gccloud.data.data.FDataResourceModelSkeletonLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型骨骼控制台。</T>
//============================================================
public class FGcResModelSkeletonConsole
      extends FAbstractLogicUnitConsole<FDataResourceModelSkeletonLogic, FGcResModelSkeletonInfo>
      implements
         IGcResModelSkeletonConsole
{
   //============================================================
   // <T>构造资源模型骨骼控制台。</T>
   //============================================================
   public FGcResModelSkeletonConsole(){
      super(FDataResourceModelSkeletonLogic.class, FGcResModelSkeletonInfo.class);
   }

   //============================================================
   // <T>根据代码查找骨骼单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   @Override
   public FGcResModelSkeletonInfo findByCode(ILogicContext logicContext,
                                             String code){
      String searchSql = FDataResourceModelSkeletonLogic.CODE + "='" + code + "'";
      FGcResModelSkeletonInfo skeletonInfo = search(logicContext, searchSql);
      return skeletonInfo;
   }
}
