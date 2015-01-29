package org.mo.content.engine3d.core.model;

import com.cyou.gccloud.data.data.FDataResource3dModelLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelStreamLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelStreamUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.com.console.FConsole;
import org.mo.com.io.IDataInput;
import org.mo.com.lang.EResult;
import org.mo.content.resource3d.model.FRs3Model;
import org.mo.content.resource3d.model.FRs3ModelMesh;
import org.mo.content.resource3d.model.FRs3ModelStream;
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
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

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
      // 新建模型
      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
      FDataResource3dModelUnit modelUnit = modelLogic.doPrepare();
      modelUnit.setCode(model.code());
      modelLogic.doInsert(modelUnit);
      // 新建网格
      for(FRs3ModelMesh mesh : model.meshs()){
         FDataResource3dModelMeshLogic meshLogic = logicContext.findLogic(FDataResource3dModelMeshLogic.class);
         FDataResource3dModelMeshUnit meshUnit = meshLogic.doPrepare();
         meshUnit.setCode(mesh.code());
         meshUnit.setModelId(modelUnit.ouid());
         meshLogic.doInsert(meshUnit);
         // 新建数据流
         for(FRs3ModelStream stream : mesh.streams()){
            FDataResource3dModelStreamLogic streamLogic = logicContext.findLogic(FDataResource3dModelStreamLogic.class);
            FDataResource3dModelStreamUnit streamUnit = streamLogic.doPrepare();
            streamUnit.setCode(stream.code());
            streamUnit.setModelId(modelUnit.ouid());
            streamUnit.setMeshId(meshUnit.ouid());
            streamUnit.setElementDataCd(stream.elementDataCd());
            streamUnit.setElementCount(stream.elementCount());
            streamUnit.setDataStride(stream.dataStride());
            streamUnit.setDataCount(stream.dataCount());
            streamUnit.setDataLength(stream.dataLength());
            streamLogic.doInsert(streamUnit);
            // 上传数据
            FDataResource3dModelStreamUnit unit = streamLogic.find(streamUnit.ouid());
            SGcStorage storage = new SGcStorage(EGcStorageCatalog.Resource3dModelStream, unit.createDate(), unit.guid(), unit.gvid(), null);
            storage.setData(stream.data());
            _storageConsole.store(storage);
         }
      }
      return EResult.Success;
   }
}
