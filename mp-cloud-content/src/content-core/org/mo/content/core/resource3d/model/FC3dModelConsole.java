package org.mo.content.core.resource3d.model;

import com.cyou.gccloud.data.data.FDataResource3dMeshStreamLogic;
import com.cyou.gccloud.data.data.FDataResource3dMeshStreamUnit;
import com.cyou.gccloud.data.data.FDataResource3dMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
import com.cyou.gccloud.data.data.FDataResource3dStreamUnit;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.content.resource3d.model.FRs3Model;
import org.mo.content.resource3d.model.FRs3ModelMesh;
import org.mo.content.resource3d.model.FRs3ModelStream;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>模型控制台。</T>
//============================================================
public class FC3dModelConsole
      implements
         IC3dModelConsole
{
   // 存储管理接口
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param version 版本
   //============================================================
   @Override
   public FRs3Model makeModel(ILogicContext logicContext,
                              String code,
                              String version){
      FRs3Model model = new FRs3Model();
      // 获得模型信息
      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
      FDataResource3dModelUnit modelUnit = modelLogic.findByGuid(code);
      if(modelUnit == null){
         return null;
      }
      model.setGuid(modelUnit.guid());
      model.setCode(modelUnit.code());
      // 获得网格信息
      FDataResource3dModelMeshLogic meshLogic = logicContext.findLogic(FDataResource3dModelMeshLogic.class);
      FLogicDataset<FDataResource3dModelMeshUnit> modelMeshUnits = meshLogic.fetch("MODEL_ID=" + modelUnit.ouid());
      for(FDataResource3dModelMeshUnit modelMeshUnit : modelMeshUnits){
         // 查找网格
         FDataResource3dMeshUnit meshUnit = modelMeshUnit.mesh();
         // 创建资源网格
         FRs3ModelMesh mesh = new FRs3ModelMesh();
         mesh.setGuid(meshUnit.guid());
         // 获得数据流信息
         FDataResource3dMeshStreamLogic meshStreamLogic = logicContext.findLogic(FDataResource3dMeshStreamLogic.class);
         FLogicDataset<FDataResource3dMeshStreamUnit> meshStreamUnits = meshStreamLogic.fetch(FDataResource3dMeshStreamLogic.MESH_ID + "=" + meshUnit.ouid());
         for(FDataResource3dMeshStreamUnit meshStreamUnit : meshStreamUnits){
            // 查找数据流
            FDataResource3dStreamUnit streamUnit = meshStreamUnit.stream();
            // 设置属性
            FRs3ModelStream stream = new FRs3ModelStream();
            stream.setCode(streamUnit.code());
            stream.setElementDataCd(streamUnit.elementDataCd());
            stream.setElementCount(streamUnit.elementCount());
            stream.setDataStride(streamUnit.dataStride());
            stream.setDataCount(streamUnit.dataCount());
            // 读取文件
            SGcStorage resource = _storageConsole.find(EGcStorageCatalog.Resource3dStream, streamUnit.guid());
            stream.setData(resource.data());
            mesh.streams().push(stream);
         }
         model.meshs().push(mesh);
      }
      return model;
   }
}
