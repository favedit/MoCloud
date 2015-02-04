package org.mo.content.engine3d.core.model;

import com.cyou.gccloud.data.data.FDataResource3dMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshUnit;
import org.mo.com.console.FConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台。</T>
//============================================================
public class FRs3ModelMeshConsole
      extends FConsole
      implements
         IRs3ModelMeshConsole
{
   //============================================================
   // <T>根据代码查找模型网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 模型网格单元
   //============================================================
   @Override
   public FDataResource3dMeshUnit findMeshByCode(ILogicContext logicContext,
                                                 long modelId,
                                                 String code){
      String whereSql = FDataResource3dModelMeshLogic.MODEL_ID + "=" + modelId;
      FDataResource3dModelMeshLogic meshLogic = logicContext.findLogic(FDataResource3dModelMeshLogic.class);
      FLogicDataset<FDataResource3dModelMeshUnit> dataset = meshLogic.fetch(whereSql);
      for(FDataResource3dModelMeshUnit modelMeshUnit : dataset){
         FDataResource3dMeshUnit meshUnit = modelMeshUnit.mesh();
         String meshCode = meshUnit.code();
         if(meshCode.equals(code)){
            return meshUnit;
         }
      }
      return null;
   }
}
