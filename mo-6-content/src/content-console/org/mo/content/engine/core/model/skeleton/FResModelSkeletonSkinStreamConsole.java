package org.mo.content.engine.core.model.skeleton;

import org.mo.content.resource.common.FResStream;

import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource.model.skeleton.FGcResModelSkeletonSkinStreamConsole;
import org.mo.cloud.logic.resource.model.skeleton.FGcResModelSkeletonSkinStreamInfo;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型骨骼蒙皮数据流控制台。</T>
//============================================================
public class FResModelSkeletonSkinStreamConsole
      extends FGcResModelSkeletonSkinStreamConsole
      implements
         IResModelSkeletonSkinStreamConsole
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
                                FGcResModelSkeletonSkinStreamInfo streamInfo){
      String guid = streamInfo.guid();
      // 设置属性
      FResStream stream = new FResStream();
      stream.setCode(streamInfo.code());
      stream.setElementDataCd(streamInfo.elementDataCd());
      stream.setElementCount(streamInfo.elementCount());
      stream.setDataStride(streamInfo.dataStride());
      stream.setDataCount(streamInfo.dataCount());
      // 读取数据
      SGcStorage resource = _storageConsole.find(EGcStorageCatalog.ResourceModelSkeletonSkinStream, guid);
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
      FGcResModelSkeletonSkinStreamInfo streamInfo = get(logicContext, streamId);
      return makeStream(logicContext, streamInfo);
   }

   //============================================================
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param streamInfo 数据流信息
   // @param stream 数据流
   // @return 数据流信息
   //============================================================
   @Override
   public FGcResModelSkeletonSkinStreamInfo updateResource(ILogicContext logicContext,
                                                           FGcResModelSkeletonSkinStreamInfo streamInfo,
                                                           FResStream stream){
      // 获得信息
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
      SGcStorage resource = new SGcStorage(EGcStorageCatalog.ResourceModelSkeletonSkinStream, guid);
      resource.setData(stream.data());
      _storageConsole.store(resource);
      // 返回内容
      return streamInfo;
   }
}
