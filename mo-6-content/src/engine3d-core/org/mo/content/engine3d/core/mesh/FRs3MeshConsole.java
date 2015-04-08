package org.mo.content.engine3d.core.mesh;

import com.cyou.gccloud.data.data.FDataResource3dMeshLogic;
import com.cyou.gccloud.data.data.FDataResource3dMeshStreamLogic;
import com.cyou.gccloud.data.data.FDataResource3dMeshStreamUnit;
import com.cyou.gccloud.data.data.FDataResource3dMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dStreamUnit;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource3d.mesh.FGcRs3MeshInfo;
import org.mo.cloud.logic.resource3d.mesh.FGcRs3MeshStreamInfo;
import org.mo.cloud.logic.resource3d.mesh.IGcRs3MeshConsole;
import org.mo.cloud.logic.resource3d.mesh.IGcRs3MeshStreamConsole;
import org.mo.com.console.FConsole;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.net.EMime;
import org.mo.content.engine3d.core.stream.IRs3StreamConsole;
import org.mo.content.geom.mesh.FGeomModel;
import org.mo.content.mime.obj.FObjFile;
import org.mo.content.mime.phy.FPlyFile;
import org.mo.content.resource3d.common.FRs3Stream;
import org.mo.content.resource3d.mesh.FRs3Mesh;
import org.mo.content.resource3d.model.FRs3ModelMesh;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.mime.compress.ECompressMode;
import org.mo.mime.compress.FCompressStream;

//============================================================
// <T>资源数据流控制台。</T>
//============================================================
public class FRs3MeshConsole
      extends FConsole
      implements
         IRs3MeshConsole
{
   // 存储管理接口
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 存储控制台
   @ALink
   protected IRs3StreamConsole _streamConsole;

   // 数据网格控制台
   @ALink
   protected IGcRs3MeshConsole _dataMeshConsole;

   // 数据网格数据流控制台
   @ALink
   protected IGcRs3MeshStreamConsole _dataMeshStreamConsole;

   //============================================================
   // <T>根据代码查找网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 网格单元
   //============================================================
   @Override
   public FDataResource3dMeshUnit findByGuid(ILogicContext logicContext,
                                             String guid){
      FDataResource3dMeshLogic logic = logicContext.findLogic(FDataResource3dMeshLogic.class);
      FDataResource3dMeshUnit unit = logic.findByGuid(guid);
      return unit;
   }

   //============================================================
   // <T>根据代码查找网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 网格单元
   //============================================================
   @Override
   public FDataResource3dMeshUnit findByCode(ILogicContext logicContext,
                                             String code){
      String searchSql = FDataResource3dMeshLogic.CODE + "='" + code + "'";
      FDataResource3dMeshLogic logic = logicContext.findLogic(FDataResource3dMeshLogic.class);
      FDataResource3dMeshUnit unit = logic.search(searchSql);
      return unit;
   }

   //============================================================
   // <T>新建一个网格。</T>
   //
   // @param logicContext 逻辑环境
   // @param mesh 网格
   // @return 网格单元
   //============================================================
   @Override
   public FDataResource3dMeshUnit insert(ILogicContext logicContext,
                                         FRs3ModelMesh mesh){
      // 新建模型
      FDataResource3dMeshLogic meshLogic = logicContext.findLogic(FDataResource3dMeshLogic.class);
      FDataResource3dMeshUnit meshUnit = meshLogic.doPrepare();
      mesh.saveUnit(meshUnit);
      meshLogic.doInsert(meshUnit);
      // 新建数据流
      int streamCount = mesh.streams().count();
      for(int n = 0; n < streamCount; n++){
         FRs3Stream stream = mesh.streams().get(n);
         // 新建数据流
         FDataResource3dStreamUnit streamUnit = _streamConsole.insert(logicContext, stream);
         // 建立网格和数据流关联
         FDataResource3dMeshStreamLogic meshStreamLogic = logicContext.findLogic(FDataResource3dMeshStreamLogic.class);
         FDataResource3dMeshStreamUnit meshStreamUnit = meshStreamLogic.doPrepare();
         meshStreamUnit.setMeshId(meshUnit.ouid());
         meshStreamUnit.setStreamId(streamUnit.ouid());
         meshStreamUnit.setIndex(n);
         meshStreamUnit.setCode(stream.code());
         meshStreamLogic.doInsert(meshStreamUnit);
      }
      // 返回网格单元
      return meshLogic.find(meshUnit.ouid());
   }

   //============================================================
   // <T>更新网格。</T>
   //
   // @param logicContext 逻辑环境
   // @param mesh 网格
   //============================================================
   @Override
   public FDataResource3dMeshUnit update(ILogicContext logicContext,
                                         long meshId,
                                         FRs3Mesh mesh){
      // 检查网格存在性
      FGcRs3MeshInfo meshInfo = _dataMeshConsole.find(logicContext, meshId);
      if(meshInfo == null){
         throw new FFatalError("Mesh is not exists. (mesh_id={1})", meshId);
      }
      String meshGuid = meshInfo.guid();
      //............................................................
      // 删除不存在的数据流
      FLogicDataset<FGcRs3MeshStreamInfo> meshStreams = _dataMeshStreamConsole.fetchByMeshId(logicContext, meshId);
      for(FGcRs3MeshStreamInfo meshStream : meshStreams){
         String streamCode = meshStream.code();
         FRs3Stream stream = mesh.findStream(streamCode);
         if(stream != null){
            int index = mesh.streams().indexOf(stream);
            if(meshStream.index() != index){
               meshStream.setIndex(index);
               _dataMeshStreamConsole.doUpdate(logicContext, meshStream);
            }
         }else{
            _dataMeshStreamConsole.doDelete(logicContext, meshStream);
         }
      }
      //............................................................
      // 更新所有数据流
      int streamCount = mesh.streams().count();
      for(int n = 0; n < streamCount; n++){
         FRs3Stream stream = mesh.streams().get(n);
         String streamCode = stream.code();
         FGcRs3MeshStreamInfo meshStream = _dataMeshStreamConsole.findByCode(logicContext, meshId, streamCode);
         if(meshStream == null){
            FDataResource3dStreamUnit streamUnit = _streamConsole.insert(logicContext, stream);
            // 建立数据关联
            FGcRs3MeshStreamInfo meshStreamInfo = _dataMeshStreamConsole.doPrepare(logicContext);
            meshStreamInfo.setMeshId(meshId);
            meshStreamInfo.setStreamId(streamUnit.ouid());
            meshStreamInfo.setIndex(n);
            meshStreamInfo.setCode(streamCode);
            _dataMeshStreamConsole.doInsert(logicContext, meshStreamInfo);
         }else{
            stream.setOuid(meshStream.streamId());
            _streamConsole.update(logicContext, stream);
         }
      }
      // 更新网格
      mesh.saveUnit(meshInfo);
      _dataMeshConsole.doUpdate(logicContext, meshInfo);
      //............................................................
      // 废弃临时数据
      _storageConsole.delete(EGcStorageCatalog.Cache3dMesh, meshGuid);
      //............................................................
      // 返回网格单元
      return meshInfo;
   }

   //============================================================
   // <T>更新网格。</T>
   //
   // @param logicContext 逻辑环境
   // @param mesh 网格
   //============================================================
   @Override
   public FDataResource3dMeshUnit updateMesh(ILogicContext logicContext,
                                             FRs3Mesh mesh){
      // 检查参数
      String guid = mesh.guid();
      if(RString.isEmpty(guid)){
         throw new FFatalError("Mesh guid is null.");
      }
      // 查找数据
      FDataResource3dMeshLogic meshLogic = logicContext.findLogic(FDataResource3dMeshLogic.class);
      FDataResource3dMeshUnit meshUnit = meshLogic.findByGuid(guid);
      if(meshUnit == null){
         throw new FFatalError("Mesh is not exists. (guid={1}})", meshUnit);
      }
      // 创建场景
      mesh.saveUnit(meshUnit);
      // 更新数据
      meshLogic.doUpdate(meshUnit);
      //............................................................
      // 废弃临时数据
      _storageConsole.delete(EGcStorageCatalog.Cache3dMesh, guid);
      // 返回网格单元
      return meshLogic.find(meshUnit.ouid());
   }

   //============================================================
   // <T>生成资源网格。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 资源网格
   //============================================================
   @Override
   public FRs3Mesh makeMesh(ILogicContext logicContext,
                            String guid){
      // 获得模型信息
      FDataResource3dMeshLogic meshLogic = logicContext.findLogic(FDataResource3dMeshLogic.class);
      FDataResource3dMeshUnit meshUnit = meshLogic.findByGuid(guid);
      if(meshUnit == null){
         return null;
      }
      FRs3Mesh mesh = new FRs3Mesh();
      mesh.loadUnit(meshUnit);
      //............................................................
      // 创建资源网格
      // 获得数据流信息
      FDataResource3dMeshStreamLogic meshStreamLogic = logicContext.findLogic(FDataResource3dMeshStreamLogic.class);
      FLogicDataset<FDataResource3dMeshStreamUnit> meshStreamUnits = meshStreamLogic.fetch(FDataResource3dMeshStreamLogic.MESH_ID + "=" + meshUnit.ouid());
      for(FDataResource3dMeshStreamUnit meshStreamUnit : meshStreamUnits){
         // 建立数据流
         FRs3Stream stream = _streamConsole.makeStream(logicContext, meshStreamUnit.streamId());
         mesh.streams().push(stream);
      }
      // 返回网格
      return mesh;
   }

   //============================================================
   // <T>生成资源网格数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 资源网格数据
   //============================================================
   @Override
   public byte[] makeMeshData(ILogicContext logicContext,
                              String guid){
      // 查找数据
      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.Cache3dMesh, guid);
      if(findStorage != null){
         return findStorage.data();
      }
      //............................................................
      // 生成模型
      FRs3Mesh mesh = makeMesh(logicContext, guid);
      // 获得数据
      FByteStream stream = new FByteStream();
      mesh.serialize(stream);
      // 压缩数据
      byte[] data = null;
      try(FCompressStream file = new FCompressStream(stream.toArray())){
         data = file.toCompressArray(ECompressMode.Lzma);
      }
      //............................................................
      // 存储数据
      SGcStorage storage = new SGcStorage(EGcStorageCatalog.Cache3dMesh, guid, EMime.Bin.type());
      storage.setCode(mesh.code());
      storage.setData(data);
      _storageConsole.store(storage);
      // 返回数据
      return data;
   }

   //============================================================
   // <T>导入PLY模型。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   @Override
   public EResult importMeshPly(ILogicContext logicContext,
                                String code,
                                String fileName){
      // 删除已经存在的数据网格
      FGcRs3MeshInfo findMeshUnit = _dataMeshConsole.findByCode(logicContext, code);
      if(findMeshUnit != null){
         _dataMeshConsole.doDelete(logicContext, findMeshUnit);
      }
      //............................................................
      // 加载模型资源
      FRs3Mesh mesh = new FRs3Mesh();
      // 导入数据流
      FPlyFile file = new FPlyFile(fileName);
      file.buildMesh(mesh);
      //............................................................
      // 新建模型
      FDataResource3dMeshLogic meshLogic = logicContext.findLogic(FDataResource3dMeshLogic.class);
      FDataResource3dMeshUnit meshUnit = meshLogic.doPrepare();
      meshUnit.setCode(code);
      meshLogic.doInsert(meshUnit);
      // 新建数据流
      int streamCount = mesh.streams().count();
      for(int n = 0; n < streamCount; n++){
         FRs3Stream stream = mesh.streams().get(n);
         // 新建数据流
         FDataResource3dStreamUnit streamUnit = _streamConsole.insert(logicContext, stream);
         // 建立网格和数据流关联
         FDataResource3dMeshStreamLogic meshStreamLogic = logicContext.findLogic(FDataResource3dMeshStreamLogic.class);
         FDataResource3dMeshStreamUnit meshStreamUnit = meshStreamLogic.doPrepare();
         meshStreamUnit.setMeshId(meshUnit.ouid());
         meshStreamUnit.setStreamId(streamUnit.ouid());
         meshStreamUnit.setIndex(n);
         meshStreamUnit.setCode(stream.code());
         meshStreamLogic.doInsert(meshStreamUnit);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>导入PLY模型。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @param file 文件
   // @return 处理结果
   //============================================================
   @Override
   public EResult importMeshPly(ILogicContext logicContext,
                                String guid,
                                FPlyFile file){
      // 删除已经存在的数据网格
      FGcRs3MeshInfo meshInfo = _dataMeshConsole.findByGuid(logicContext, guid);
      if(meshInfo == null){
         throw new FFatalError("Mesh is not exists.");
      }
      //............................................................
      // 加载模型资源
      FRs3Mesh mesh = new FRs3Mesh();
      mesh.loadUnit(meshInfo);
      file.buildMesh(mesh);
      //............................................................
      // 新建模型
      update(logicContext, meshInfo.ouid(), mesh);
      return EResult.Success;
   }

   //============================================================
   // <T>导入OBJ模型。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @param file 文件
   // @return 处理结果
   //============================================================
   @Override
   public EResult importMeshObj(ILogicContext logicContext,
                                String guid,
                                FObjFile file){
      // 删除已经存在的数据网格
      FGcRs3MeshInfo meshInfo = _dataMeshConsole.findByGuid(logicContext, guid);
      if(meshInfo == null){
         throw new FFatalError("Mesh is not exists.");
      }
      //............................................................
      // 加载模型资源
      FGeomModel geoModel = file.CreateGeomModel();
      FRs3Mesh mesh = new FRs3Mesh(geoModel.meshs().first());
      mesh.loadUnit(meshInfo);
      //............................................................
      // 新建模型
      update(logicContext, meshInfo.ouid(), mesh);
      return EResult.Success;
   }
}
