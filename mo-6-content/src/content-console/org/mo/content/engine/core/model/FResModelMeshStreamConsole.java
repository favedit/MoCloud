package org.mo.content.engine.core.model;

import org.mo.cloud.core.storage.mongo.EGcStorageMongoCatalog;
import org.mo.cloud.core.storage.mongo.SGcMongoStorage;

import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.data.resource.model.mesh.FGcResModelMeshStreamConsole;
import org.mo.cloud.logic.data.resource.model.mesh.FGcResModelMeshStreamInfo;
import org.mo.cloud.logic.data.resource.model.FGcResModelInfo;
import org.mo.content.resource.common.FResStream;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型网格数据流控制台。</T>
//============================================================
public class FResModelMeshStreamConsole
      extends FGcResModelMeshStreamConsole
      implements
         IResModelMeshStreamConsole
{
   //============================================================
   // <T>构建一个数据流。</T>
   //
   // @param logicContext 逻辑环境
   // @param streamInfo 数据流信息
   // @return 数据流
   //============================================================
   @Override
   public FResStream makeStream(ILogicContext logicContext,
                                FGcResModelMeshStreamInfo streamInfo){
      String guid = streamInfo.guid();
      // 设置属性
      FResStream stream = new FResStream();
      stream.setCode(streamInfo.code());
      stream.setElementDataCd(streamInfo.elementDataCd());
      stream.setElementCount(streamInfo.elementCount());
      stream.setDataStride(streamInfo.dataStride());
      stream.setDataCount(streamInfo.dataCount());
      // 读取数据
      SGcMongoStorage resource = _storageConsole.find(EGcStorageMongoCatalog.ResourceModelMeshStream, guid);
      stream.setData(resource.data());
      return stream;
   }

   //============================================================
   // <T>构建一个数据流。</T>
   //
   // @param logicContext 逻辑环境
   // @param streamId 数据流编号
   // @return 数据流
   //============================================================
   @Override
   public FResStream makeStream(ILogicContext logicContext,
                                long streamId){
      FGcResModelMeshStreamInfo streamInfo = get(logicContext, streamId);
      return makeStream(logicContext, streamInfo);
   }

   //============================================================
   // <T>新建资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param meshInfo 网格信息
   // @param stream 数据流
   // @return 数据流信息
   //============================================================
   @Override
   public FGcResModelMeshStreamInfo insertResource(ILogicContext logicContext,
                                                   FGcSessionInfo session,
                                                   FGcResModelInfo modelInfo,
                                                   FGcResModelMeshInfo meshInfo,
                                                   FResStream stream){
      // 获得信息
      long userId = session.userId();
      long projectId = session.projectId();
      long modelId = modelInfo.ouid();
      long meshId = meshInfo.ouid();
      //............................................................
      // 新建信息
      FGcResModelMeshStreamInfo streamInfo = doPrepare(logicContext);
      streamInfo.setUserId(userId);
      streamInfo.setProjectId(projectId);
      streamInfo.setModelId(modelId);
      streamInfo.setMeshId(meshId);
      stream.saveUnit(streamInfo);
      doInsert(logicContext, streamInfo);
      //............................................................
      // 存储数据
      String guid = streamInfo.guid();
      SGcMongoStorage resource = new SGcMongoStorage(EGcStorageMongoCatalog.ResourceModelMeshStream, guid);
      resource.setData(stream.data());
      _storageConsole.store(resource);
      //............................................................
      // 返回内容
      return streamInfo;
   }

   //============================================================
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param meshInfo 网格信息
   // @param streamInfo 数据流信息
   // @param stream 数据流
   // @return 数据流信息
   //============================================================
   @Override
   public FGcResModelMeshStreamInfo updateResource(ILogicContext logicContext,
                                                   FGcSessionInfo session,
                                                   FGcResModelInfo modelInfo,
                                                   FGcResModelMeshInfo meshInfo,
                                                   FGcResModelMeshStreamInfo streamInfo,
                                                   FResStream stream){
      // 设置信息
      stream.saveUnit(streamInfo);
      doUpdate(logicContext, streamInfo);
      //............................................................
      // 存储数据
      String guid = streamInfo.guid();
      SGcMongoStorage resource = new SGcMongoStorage(EGcStorageMongoCatalog.ResourceModelMeshStream, guid);
      resource.setData(stream.data());
      _storageConsole.store(resource);
      //............................................................
      // 返回内容
      return streamInfo;
   }

   //============================================================
   // <T>导入资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param modelInfo 模型信息
   // @param meshInfo 网格信息
   // @param stream 数据流
   // @return 数据流信息
   //============================================================
   @Override
   public FGcResModelMeshStreamInfo importResource(ILogicContext logicContext,
                                                   FGcSessionInfo session,
                                                   FGcResModelInfo modelInfo,
                                                   FGcResModelMeshInfo meshInfo,
                                                   FResStream stream){
      // 获得信息
      long userId = session.userId();
      long modelId = modelInfo.ouid();
      long meshId = meshInfo.ouid();
      String code = stream.code();
      // 设置数据
      FGcResModelMeshStreamInfo streamInfo = findByCode(logicContext, userId, modelId, meshId, code);
      if(streamInfo == null){
         insertResource(logicContext, session, modelInfo, meshInfo, stream);
      }else{
         updateResource(logicContext, session, modelInfo, meshInfo, streamInfo, stream);
      }
      // 返回内容
      return streamInfo;
   }
}
