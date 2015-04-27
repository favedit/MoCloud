package org.mo.content.engine.core.model;

import org.mo.content.resource.model.FResModelMesh;

import org.mo.content.resource.common.FResStream;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshConsole;
import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshStreamInfo;
import org.mo.com.lang.FFatalError;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型网格控制台。</T>
//============================================================
public class FResModelMeshConsole
      extends FGcResModelMeshConsole
      implements
         IResModelMeshConsole
{
   // 存储管理接口
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 数据网格数据流控制台
   @ALink
   protected IResModelMeshStreamConsole _streamConsole;

   //   //============================================================
   //   // <T>根据代码查找网格单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 网格单元
   //   //============================================================
   //   @Override
   //   public FDataResource3dMeshUnit findByGuid(ILogicContext logicContext,
   //                                             String guid){
   //      FDataResource3dMeshLogic logic = logicContext.findLogic(FDataResource3dMeshLogic.class);
   //      FDataResource3dMeshUnit unit = logic.findByGuid(guid);
   //      return unit;
   //   }
   //
   //   //============================================================
   //   // <T>根据代码查找网格单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @return 网格单元
   //   //============================================================
   //   @Override
   //   public FDataResource3dMeshUnit findByCode(ILogicContext logicContext,
   //                                             String code){
   //      String searchSql = FDataResource3dMeshLogic.CODE + "='" + code + "'";
   //      FDataResource3dMeshLogic logic = logicContext.findLogic(FDataResource3dMeshLogic.class);
   //      FDataResource3dMeshUnit unit = logic.search(searchSql);
   //      return unit;
   //   }
   //
   //   //============================================================
   //   // <T>新建一个网格。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param mesh 网格
   //   // @return 网格单元
   //   //============================================================
   //   @Override
   //   public FDataResource3dMeshUnit insert(ILogicContext logicContext,
   //                                         FRs3ModelMesh mesh){
   //      // 新建模型
   //      FDataResource3dMeshLogic meshLogic = logicContext.findLogic(FDataResource3dMeshLogic.class);
   //      FDataResource3dMeshUnit meshUnit = meshLogic.doPrepare();
   //      mesh.saveUnit(meshUnit);
   //      meshLogic.doInsert(meshUnit);
   //      // 新建数据流
   //      int streamCount = mesh.streams().count();
   //      for(int n = 0; n < streamCount; n++){
   //         FRs3Stream stream = mesh.streams().get(n);
   //         // 新建数据流
   //         FDataResource3dStreamUnit streamUnit = _streamConsole.insert(logicContext, stream);
   //         // 建立网格和数据流关联
   //         FDataResource3dMeshStreamLogic meshStreamLogic = logicContext.findLogic(FDataResource3dMeshStreamLogic.class);
   //         FDataResource3dMeshStreamUnit meshStreamUnit = meshStreamLogic.doPrepare();
   //         meshStreamUnit.setMeshId(meshUnit.ouid());
   //         meshStreamUnit.setStreamId(streamUnit.ouid());
   //         meshStreamUnit.setIndex(n);
   //         meshStreamUnit.setCode(stream.code());
   //         meshStreamLogic.doInsert(meshStreamUnit);
   //      }
   //      // 返回网格单元
   //      return meshLogic.find(meshUnit.ouid());
   //   }
   //

   //============================================================
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param meshInfo 网格信息
   // @param mesh 网格数据
   // @return 网格信息
   //============================================================
   @Override
   public FGcResModelMeshInfo updateResource(ILogicContext logicContext,
                                             FGcResModelMeshInfo meshInfo,
                                             FResModelMesh mesh){
      // 获得网格信息
      if(meshInfo == null){
         throw new FFatalError("Mesh info is empty.");
      }
      long modelId = meshInfo.modelId();
      long meshId = meshInfo.ouid();
      String meshGuid = meshInfo.guid();
      //............................................................
      // 删除不存在的数据流
      _streamConsole.doDeleteByMeshId(logicContext, meshId);
      //............................................................
      // 更新所有数据流
      int streamCount = mesh.streams().count();
      for(int n = 0; n < streamCount; n++){
         FResStream stream = mesh.streams().get(n);
         // 新建数据流
         FGcResModelMeshStreamInfo streamInfo = _streamConsole.doPrepare(logicContext);
         streamInfo.setUserId(meshInfo.userId());
         streamInfo.setProjectId(meshInfo.projectId());
         streamInfo.setModelId(modelId);
         streamInfo.setMeshId(meshId);
         streamInfo.setSortIndex(n);
         _streamConsole.doInsert(logicContext, streamInfo);
         // 更新资源
         _streamConsole.updateResource(logicContext, streamInfo, stream);
      }
      // 更新网格
      mesh.saveUnit(meshInfo);
      doUpdate(logicContext, meshInfo);
      //............................................................
      // 废弃临时数据
      _storageConsole.delete(EGcStorageCatalog.CacheResourceMesh, meshGuid);
      //............................................................
      // 返回网格单元
      return meshInfo;
   }
   //
   //   //============================================================
   //   // <T>更新网格。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param mesh 网格
   //   //============================================================
   //   @Override
   //   public FDataResource3dMeshUnit updateMesh(ILogicContext logicContext,
   //                                             FRs3Mesh mesh){
   //      // 检查参数
   //      String guid = mesh.guid();
   //      if(RString.isEmpty(guid)){
   //         throw new FFatalError("Mesh guid is null.");
   //      }
   //      // 查找数据
   //      FDataResource3dMeshLogic meshLogic = logicContext.findLogic(FDataResource3dMeshLogic.class);
   //      FDataResource3dMeshUnit meshUnit = meshLogic.findByGuid(guid);
   //      if(meshUnit == null){
   //         throw new FFatalError("Mesh is not exists. (guid={1}})", meshUnit);
   //      }
   //      // 创建场景
   //      mesh.saveUnit(meshUnit);
   //      // 更新数据
   //      meshLogic.doUpdate(meshUnit);
   //      //............................................................
   //      // 废弃临时数据
   //      _storageConsole.delete(EGcStorageCatalog.Cache3dMesh, guid);
   //      // 返回网格单元
   //      return meshLogic.find(meshUnit.ouid());
   //   }
   //
   //   //============================================================
   //   // <T>生成资源网格。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 资源网格
   //   //============================================================
   //   @Override
   //   public FRs3Mesh makeMesh(ILogicContext logicContext,
   //                            String guid){
   //      // 获得模型信息
   //      FDataResource3dMeshLogic meshLogic = logicContext.findLogic(FDataResource3dMeshLogic.class);
   //      FDataResource3dMeshUnit meshUnit = meshLogic.findByGuid(guid);
   //      if(meshUnit == null){
   //         return null;
   //      }
   //      FRs3Mesh mesh = new FRs3Mesh();
   //      mesh.loadUnit(meshUnit);
   //      //............................................................
   //      // 创建资源网格
   //      // 获得数据流信息
   //      FDataResource3dMeshStreamLogic meshStreamLogic = logicContext.findLogic(FDataResource3dMeshStreamLogic.class);
   //      FLogicDataset<FDataResource3dMeshStreamUnit> meshStreamUnits = meshStreamLogic.fetch(FDataResource3dMeshStreamLogic.MESH_ID + "=" + meshUnit.ouid());
   //      for(FDataResource3dMeshStreamUnit meshStreamUnit : meshStreamUnits){
   //         // 建立数据流
   //         FRs3Stream stream = _streamConsole.makeStream(logicContext, meshStreamUnit.streamId());
   //         mesh.streams().push(stream);
   //      }
   //      // 返回网格
   //      return mesh;
   //   }
   //
   //   //============================================================
   //   // <T>生成资源网格数据。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 资源网格数据
   //   //============================================================
   //   @Override
   //   public byte[] makeMeshData(ILogicContext logicContext,
   //                              String guid){
   //      // 查找数据
   //      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.Cache3dMesh, guid);
   //      if(findStorage != null){
   //         return findStorage.data();
   //      }
   //      //............................................................
   //      // 生成模型
   //      FRs3Mesh mesh = makeMesh(logicContext, guid);
   //      // 获得数据
   //      FByteStream stream = new FByteStream();
   //      mesh.serialize(stream);
   //      // 压缩数据
   //      byte[] data = null;
   //      try(FCompressStream file = new FCompressStream(stream.toArray())){
   //         data = file.toCompressArray(ECompressMode.Lzma);
   //      }
   //      //............................................................
   //      // 存储数据
   //      SGcStorage storage = new SGcStorage(EGcStorageCatalog.Cache3dMesh, guid, EMime.Bin.type());
   //      storage.setCode(mesh.code());
   //      storage.setData(data);
   //      _storageConsole.store(storage);
   //      // 返回数据
   //      return data;
   //   }
   //
   //   //============================================================
   //   // <T>导入PLY模型。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @param fileName 文件名称
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public EResult importMeshPly(ILogicContext logicContext,
   //                                String code,
   //                                String fileName){
   //      // 删除已经存在的数据网格
   //      FGcRs3MeshInfo findMeshUnit = _dataMeshConsole.findByCode(logicContext, code);
   //      if(findMeshUnit != null){
   //         _dataMeshConsole.doDelete(logicContext, findMeshUnit);
   //      }
   //      //............................................................
   //      // 加载模型资源
   //      FRs3Mesh mesh = new FRs3Mesh();
   //      // 导入数据流
   //      FPlyFile file = new FPlyFile(fileName);
   //      file.buildMesh(mesh);
   //      //............................................................
   //      // 新建模型
   //      FDataResource3dMeshLogic meshLogic = logicContext.findLogic(FDataResource3dMeshLogic.class);
   //      FDataResource3dMeshUnit meshUnit = meshLogic.doPrepare();
   //      meshUnit.setCode(code);
   //      meshLogic.doInsert(meshUnit);
   //      // 新建数据流
   //      int streamCount = mesh.streams().count();
   //      for(int n = 0; n < streamCount; n++){
   //         FRs3Stream stream = mesh.streams().get(n);
   //         // 新建数据流
   //         FDataResource3dStreamUnit streamUnit = _streamConsole.insert(logicContext, stream);
   //         // 建立网格和数据流关联
   //         FDataResource3dMeshStreamLogic meshStreamLogic = logicContext.findLogic(FDataResource3dMeshStreamLogic.class);
   //         FDataResource3dMeshStreamUnit meshStreamUnit = meshStreamLogic.doPrepare();
   //         meshStreamUnit.setMeshId(meshUnit.ouid());
   //         meshStreamUnit.setStreamId(streamUnit.ouid());
   //         meshStreamUnit.setIndex(n);
   //         meshStreamUnit.setCode(stream.code());
   //         meshStreamLogic.doInsert(meshStreamUnit);
   //      }
   //      return EResult.Success;
   //   }
}
