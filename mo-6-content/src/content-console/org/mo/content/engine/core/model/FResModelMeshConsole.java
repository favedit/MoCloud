package org.mo.content.engine.core.model;

import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.logic.resource.model.FGcResModelInfo;
import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshConsole;
import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshStreamInfo;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.lang.FFatalError;
import org.mo.content.resource.common.FResStream;
import org.mo.content.resource.model.FResModelMesh;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
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

   //============================================================
   // <T>新建资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param mesh 网格数据
   // @return 网格信息
   //============================================================
   @Override
   public FGcResModelMeshInfo insertResource(ILogicContext logicContext,
                                             FGcSessionInfo session,
                                             FGcResModelInfo modelInfo,
                                             FResModelMesh mesh){
      // 获得参数
      long userId = session.userId();
      long projectId = session.projectId();
      long modelId = modelInfo.ouid();
      //............................................................
      // 新建网格
      FGcResModelMeshInfo meshInfo = doPrepare(logicContext);
      meshInfo.setUserId(userId);
      meshInfo.setProjectId(projectId);
      meshInfo.setModelId(modelId);
      mesh.saveUnit(meshInfo);
      doInsert(logicContext, meshInfo);
      //............................................................
      // 新建数据流集合
      int streamCount = mesh.streams().count();
      for(int n = 0; n < streamCount; n++){
         FResStream stream = mesh.streams().get(n);
         _streamConsole.insertResource(logicContext, session, modelInfo, meshInfo, stream);
      }
      //............................................................
      // 返回网格信息
      return meshInfo;
   }

   //============================================================
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param meshInfo 网格信息
   // @param mesh 网格数据
   // @return 网格信息
   //============================================================
   @Override
   public FGcResModelMeshInfo updateResource(ILogicContext logicContext,
                                             FGcSessionInfo session,
                                             FGcResModelInfo modelInfo,
                                             FGcResModelMeshInfo meshInfo,
                                             FResModelMesh mesh){
      // 获得网格信息
      if(meshInfo == null){
         throw new FFatalError("Mesh info is empty.");
      }
      long meshId = meshInfo.ouid();
      String meshGuid = meshInfo.guid();
      //............................................................
      // 删除未使用的数据流信息
      FLogicDataset<FGcResModelMeshStreamInfo> streamInfos = _streamConsole.fetchByMeshId(logicContext, meshId);
      if(streamInfos != null){
         for(FGcResModelMeshStreamInfo streamInfo : streamInfos){
            String streamCode = streamInfo.code();
            FResStream stream = mesh.findStream(streamCode);
            if(stream == null){
               _streamConsole.doDelete(logicContext, streamInfo);
            }
         }
      }
      //............................................................
      // 新建数据流集合
      int streamCount = mesh.streams().count();
      for(int n = 0; n < streamCount; n++){
         FResStream stream = mesh.streams().get(n);
         _streamConsole.importResource(logicContext, session, modelInfo, meshInfo, stream);
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

   //============================================================
   // <T>导入资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param mesh 网格数据
   // @return 网格信息
   //============================================================
   @Override
   public FGcResModelMeshInfo importResource(ILogicContext logicContext,
                                             FGcSessionInfo session,
                                             FGcResModelInfo modelInfo,
                                             FResModelMesh mesh){
      // 获得参数
      long userId = session.userId();
      long modelId = modelInfo.ouid();
      String code = mesh.code();
      //............................................................
      // 查找网格信息
      FGcResModelMeshInfo meshInfo = findByUserModelCode(logicContext, userId, modelId, code);
      if(meshInfo == null){
         // 新建网格信息
         insertResource(logicContext, session, modelInfo, mesh);
      }else{
         // 更新网格信息
         updateResource(logicContext, session, modelInfo, meshInfo, mesh);
      }
      //............................................................
      // 返回网格单元
      return meshInfo;
   }

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
