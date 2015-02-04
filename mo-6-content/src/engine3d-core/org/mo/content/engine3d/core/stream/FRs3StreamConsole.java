package org.mo.content.engine3d.core.stream;

import com.cyou.gccloud.data.data.FDataResource3dStreamLogic;
import com.cyou.gccloud.data.data.FDataResource3dStreamUnit;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.com.console.FConsole;
import org.mo.com.net.EMime;
import org.mo.content.resource3d.model.FRs3ModelStream;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源数据流控制台。</T>
//============================================================
public class FRs3StreamConsole
      extends FConsole
      implements
         IRs3StreamConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>新建一个数据流。</T>
   //
   // @param logicContext 逻辑环境
   // @param stream 数据流
   // @return 数据流单元
   //============================================================
   @Override
   public FDataResource3dStreamUnit insert(ILogicContext logicContext,
                                           FRs3ModelStream stream){
      FDataResource3dStreamLogic streamLogic = logicContext.findLogic(FDataResource3dStreamLogic.class);
      // 设置数据
      FDataResource3dStreamUnit streamUnit = streamLogic.doPrepare();
      streamUnit.setFullCode(stream.fullCode());
      streamUnit.setCode(stream.code());
      streamUnit.setElementDataCd(stream.elementDataCd());
      streamUnit.setElementCount(stream.elementCount());
      streamUnit.setDataStride(stream.dataStride());
      streamUnit.setDataCount(stream.dataCount());
      streamUnit.setDataLength(stream.dataLength());
      streamLogic.doInsert(streamUnit);
      // 存储数据
      SGcStorage resource = new SGcStorage(EGcStorageCatalog.Resource3dStream, streamUnit.guid(), EMime.Bin.type());
      resource.setData(stream.data());
      _storageConsole.store(resource);
      // 返回内容
      return streamLogic.find(streamUnit.ouid());
   }
}
