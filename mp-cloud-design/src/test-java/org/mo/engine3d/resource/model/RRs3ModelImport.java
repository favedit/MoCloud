package org.mo.engine3d.resource.model;

import com.cyou.gccloud.data.data.FDataResource3dModelLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelStreamLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelStreamUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.com.lang.RUuid;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;

public class RRs3ModelImport
{
   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args) throws Exception{
      String configPath = "E:/Microbject/MoCloud";
      RAop.configConsole().defineCollection().attributes().set("application", configPath);
      RAop.initialize(configPath + "/mp-cloud-design/src/config/application-local.xml");

      FRs3Model model = new FRs3Model();
      model.loadFile("E:/Microbject/MoScript/source/assets/model/pvw.show.item.001.msd");

      IGcStorageConsole storageConsole = RAop.find(IGcStorageConsole.class);

      IDatabaseConsole dbConsole = RAop.find(IDatabaseConsole.class);
      try(ILogicContext logicContext = new FLogicContext(dbConsole)){
         // 新建模型
         FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
         FDataResource3dModelUnit modelUnit = modelLogic.doPrepare();
         modelUnit.setCode(model.code());
         modelLogic.doInsert(modelUnit);
         // 新建网格
         for(FRs3ModelMesh mesh : model.meshs()){
            FDataResource3dModelMeshLogic meshLogic = logicContext.findLogic(FDataResource3dModelMeshLogic.class);
            FDataResource3dModelMeshUnit meshUnit = meshLogic.doPrepare();
            meshUnit.setModelId(modelUnit.ouid());
            meshLogic.doInsert(meshUnit);
            // 新建数据流
            for(FRs3ModelStream stream : mesh.streams()){
               FDataResource3dModelStreamLogic streamLogic = logicContext.findLogic(FDataResource3dModelStreamLogic.class);
               FDataResource3dModelStreamUnit streamUnit = streamLogic.doPrepare();
               streamUnit.setGvid(RUuid.makeUuid());
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
               storageConsole.store(storage);
            }
         }
      }catch(Exception e){
         RLogger.find(RRs3ModelImport.class).error(null, "main", e);
      }

      RAop.release();
   }
}
