package org.mo.content.core.resource3d.model;

import com.cyou.gccloud.data.data.FDataResource3dModelLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelStreamLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelStreamUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.io.FByteFile;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.engine3d.resource.model.FRs3Model;
import org.mo.engine3d.resource.model.FRs3ModelMesh;
import org.mo.engine3d.resource.model.FRs3ModelStream;

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
      model.setCode(modelUnit.code());
      // 获得网格信息
      FDataResource3dModelMeshLogic meshLogic = logicContext.findLogic(FDataResource3dModelMeshLogic.class);
      FLogicDataset<FDataResource3dModelMeshUnit> meshUnits = meshLogic.fetch("MODEL_ID=" + modelUnit.ouid());
      for(FDataResource3dModelMeshUnit meshUnit : meshUnits){
         FRs3ModelMesh mesh = new FRs3ModelMesh();
         // 获得数据流信息
         FDataResource3dModelStreamLogic streamLogic = logicContext.findLogic(FDataResource3dModelStreamLogic.class);
         FLogicDataset<FDataResource3dModelStreamUnit> streamUnits = streamLogic.fetch(FDataResource3dModelStreamLogic.MESH_ID + "=" + meshUnit.ouid());
         for(FDataResource3dModelStreamUnit streamUnit : streamUnits){
            String streamGuid = streamUnit.guid();
            String streamGvid = streamUnit.gvid();
            String streamDate = streamUnit.createDate().formatDate();
            // 设置属性
            FRs3ModelStream stream = new FRs3ModelStream();
            stream.setCode(streamUnit.code());
            stream.setElementDataCd(streamUnit.elementDataCd());
            stream.setElementCount(streamUnit.elementCount());
            stream.setDataStride(streamUnit.dataStride());
            stream.setDataCount(streamUnit.dataCount());
            // 读取文件
            String fileName = _storageConsole.makeFileName(EGcStorageCatalog.Resource3dModelStream, streamDate, streamGuid, streamGvid, null);
            try(FByteFile file = new FByteFile(fileName)){
               stream.setData(file.toArray());
            }
            mesh.streams().push(stream);
         }
         model.meshs().push(mesh);
      }
      return model;
   }
}
