package org.mo.content.engine3d.core.animation;

import com.cyou.gccloud.data.data.FDataResource3dTrackLogic;
import com.cyou.gccloud.data.data.FDataResource3dTrackUnit;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.com.console.FConsole;
import org.mo.com.net.EMime;
import org.mo.content.resource3d.common.FRs3Track;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台。</T>
//============================================================
public class FRs3AnimationConsole
      extends FConsole
      implements
         IRs3AnimationConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>新建一个跟踪。</T>
   //
   // @param logicContext 逻辑环境
   // @param track 跟踪
   // @return 跟踪单元
   //============================================================
   @Override
   public FDataResource3dTrackUnit insertTrack(ILogicContext logicContext,
                                               FRs3Track track){
      // 新建跟踪
      FDataResource3dTrackLogic trackLogic = logicContext.findLogic(FDataResource3dTrackLogic.class);
      FDataResource3dTrackUnit trackUnit = trackLogic.doPrepare();
      trackLogic.doInsert(trackUnit);
      // 存储数据
      SGcStorage resource = new SGcStorage(EGcStorageCatalog.Resource3dTrack, trackUnit.guid(), EMime.Bin.type());
      resource.setData(track.toArray());
      _storageConsole.store(resource);
      // 返回跟踪单元
      return trackLogic.find(trackUnit.ouid());
   }

   //============================================================
   // <T>构建一个跟踪。</T>
   //
   // @param logicContext 逻辑环境
   // @param trackId 跟踪编号
   // @return 跟踪
   //============================================================
   @Override
   public FRs3Track makeTrack(ILogicContext logicContext,
                              long trackId){
      // 获得跟踪单元
      FDataResource3dTrackLogic trackLogic = logicContext.findLogic(FDataResource3dTrackLogic.class);
      FDataResource3dTrackUnit trackUnit = trackLogic.find(trackId);
      // 设置属性
      FRs3Track track = new FRs3Track();
      track.loadUnit(trackUnit);
      // 读取数据
      SGcStorage resource = _storageConsole.find(EGcStorageCatalog.Resource3dTrack, trackUnit.guid());
      track.setData(resource.data());
      return track;
   }
}
