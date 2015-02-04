package org.mo.content.engine3d.core.model;

import com.cyou.gccloud.data.data.FDataResource3dMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
import org.mo.com.console.FConsole;
import org.mo.com.io.IDataInput;
import org.mo.com.lang.EResult;
import org.mo.content.engine3d.core.mesh.IRs3MeshConsole;
import org.mo.content.resource3d.model.FRs3Model;
import org.mo.content.resource3d.model.FRs3ModelMesh;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台。</T>
//============================================================
public class FRs3ModelConsole
      extends FConsole
      implements
         IRs3ModelConsole
{
   // 网格控制台
   @ALink
   protected IRs3MeshConsole _meshConsole;

   //============================================================
   // <T>根据代码查找模型单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   @Override
   public FDataResource3dModelUnit findByCode(ILogicContext logicContext,
                                              String code){
      String searchSql = FDataResource3dModelLogic.CODE + "='" + code + "'";
      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
      FDataResource3dModelUnit modelUnit = modelLogic.search(searchSql);
      return modelUnit;
   }

   //============================================================
   // <T>导入模型。</T>
   //
   // @param logicContext 逻辑环境
   // @param input 输入流
   // @return 处理结果
   //============================================================
   @Override
   public EResult importModel(ILogicContext logicContext,
                              IDataInput input){
      // 加载模型资源
      FRs3Model model = new FRs3Model();
      model.loadStream(input);
      //............................................................
      // 新建模型
      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
      FDataResource3dModelUnit modelUnit = modelLogic.doPrepare();
      modelUnit.setCode(model.code());
      modelLogic.doInsert(modelUnit);
      // 新建网格
      for(FRs3ModelMesh mesh : model.meshs()){
         // 新建模型
         FDataResource3dMeshUnit meshUnit = _meshConsole.insert(logicContext, mesh);
         // 关联网格和模型
         FDataResource3dModelMeshLogic modelMeshLogic = logicContext.findLogic(FDataResource3dModelMeshLogic.class);
         FDataResource3dModelMeshUnit modelMeshUnit = modelMeshLogic.doPrepare();
         modelMeshUnit.setModelId(modelUnit.ouid());
         modelMeshUnit.setMeshId(meshUnit.ouid());
         modelMeshLogic.doInsert(modelMeshUnit);
      }
      return EResult.Success;
   }
}
