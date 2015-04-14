package org.mo.content.engine3d.core.model;

import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource.model.FGcResModelMeshStreamConsole;
import org.mo.cloud.logic.resource.model.FGcResModelMeshStreamInfo;
import org.mo.content.resource3d.common.FRs3Stream;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型网格数据流控制台。</T>
//============================================================
public class FRs3ModelMeshStreamConsole
      extends FGcResModelMeshStreamConsole
      implements
         IRs3ModelMeshStreamConsole
{
   //============================================================
   // <T>构建一个数据流。</T>
   //
   // @param logicContext 逻辑环境
   // @param streamInfo 数据流信息
   // @return 数据流
   //============================================================
   @Override
   public FRs3Stream makeStream(ILogicContext logicContext,
                                FGcResModelMeshStreamInfo streamInfo){
      String guid = streamInfo.guid();
      // 设置属性
      FRs3Stream stream = new FRs3Stream();
      stream.setCode(streamInfo.code());
      stream.setElementDataCd(streamInfo.elementDataCd());
      stream.setElementCount(streamInfo.elementCount());
      stream.setDataStride(streamInfo.dataStride());
      stream.setDataCount(streamInfo.dataCount());
      // 读取数据
      SGcStorage resource = _storageConsole.find(EGcStorageCatalog.ResourceModelMeshStream, guid);
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
   public FRs3Stream makeStream(ILogicContext logicContext,
                                long streamId){
      FGcResModelMeshStreamInfo streamInfo = get(logicContext, streamId);
      return makeStream(logicContext, streamInfo);
   }

   //============================================================
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param streamId 数据流编号
   // @param stream 数据流
   // @return 数据流信息
   //============================================================
   @Override
   public FGcResModelMeshStreamInfo updateResource(ILogicContext logicContext,
                                                   long streamId,
                                                   FRs3Stream stream){
      // 获得信息
      FGcResModelMeshStreamInfo streamInfo = get(logicContext, streamId);
      String guid = streamInfo.guid();
      // 设置数据
      streamInfo.setFullCode(stream.fullCode());
      streamInfo.setCode(stream.code());
      streamInfo.setElementDataCd(stream.elementDataCd());
      streamInfo.setElementCount(stream.elementCount());
      streamInfo.setDataStride(stream.dataStride());
      streamInfo.setDataCount(stream.dataCount());
      streamInfo.setDataLength(stream.dataLength());
      doUpdate(logicContext, streamInfo);
      // 存储数据
      SGcStorage resource = new SGcStorage(EGcStorageCatalog.ResourceModelMeshStream, guid);
      resource.setData(stream.data());
      _storageConsole.store(resource);
      // 返回内容
      return streamInfo;
   }
}
