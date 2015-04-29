package org.mo.content.engine.core.model.skeleton;

import com.cyou.gccloud.data.data.FDataResourceModelSkeletonSkinLogic;
import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.resource.model.skeleton.FGcResModelSkeletonConsole;
import org.mo.cloud.logic.resource.model.skeleton.FGcResModelSkeletonInfo;
import org.mo.cloud.logic.resource.model.skeleton.FGcResModelSkeletonSkinInfo;
import org.mo.cloud.logic.resource.model.skeleton.FGcResModelSkeletonSkinStreamInfo;
import org.mo.com.lang.FFatalError;
import org.mo.content.engine.core.model.IResModelMeshConsole;
import org.mo.content.resource.common.FResSkeleton;
import org.mo.content.resource.common.FResSkeletonSkin;
import org.mo.content.resource.common.FResStream;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型骨骼控制台。</T>
//============================================================
public class FResModelSkeletonConsole
      extends FGcResModelSkeletonConsole
      implements
         IResModelSkeletonConsole
{
   // 数据流控制台
   @ALink
   protected IResModelMeshConsole _modelMeshConsole;

   // 数据流控制台
   @ALink
   protected IResModelSkeletonSkinConsole _skeletonSkinConsole;

   // 数据流控制台
   @ALink
   protected IResModelSkeletonSkinStreamConsole _skeletonSkinStreamConsole;

   //============================================================
   // <T>新建一个蒙皮。</T>
   //
   // @param logicContext 逻辑环境
   // @param skeletonId 骨骼编号
   // @param skin 蒙皮
   // @return 蒙皮单元
   //============================================================
   @Override
   public FGcResModelSkeletonSkinInfo insertSkin(ILogicContext logicContext,
                                                 FGcResModelMeshInfo meshInfo,
                                                 FGcResModelSkeletonInfo skeletonInfo,
                                                 FResSkeletonSkin skin){
      long userId = meshInfo.userId();
      long projectId = meshInfo.projectId();
      long modelId = meshInfo.modelId();
      long meshId = meshInfo.ouid();
      long skeletonId = skeletonInfo.ouid();
      // 新建跟踪
      FGcResModelSkeletonSkinInfo skinInfo = _skeletonSkinConsole.doPrepare(logicContext);
      skinInfo.setUserId(userId);
      skinInfo.setProjectId(projectId);
      skinInfo.setModelId(modelId);
      skinInfo.setMeshId(meshId);
      skinInfo.setSkeletonId(skeletonId);
      skin.saveUnit(skinInfo);
      _skeletonSkinConsole.doInsert(logicContext, skinInfo);
      // 新建数据流集合
      int streamCount = skin.streams().count();
      for(int n = 0; n < streamCount; n++){
         FResStream stream = skin.streams().get(n);
         // 新建蒙皮数据流
         FGcResModelSkeletonSkinStreamInfo streamInfo = _skeletonSkinStreamConsole.doPrepare(logicContext);
         streamInfo.setUserId(userId);
         streamInfo.setProjectId(projectId);
         streamInfo.setModelId(modelId);
         streamInfo.setMeshId(meshId);
         streamInfo.setSkeletonId(skeletonId);
         streamInfo.setSkinId(skinInfo.ouid());
         streamInfo.setSortIndex(n);
         _skeletonSkinStreamConsole.doInsert(logicContext, streamInfo);
         // 更新蒙皮数据
         _skeletonSkinStreamConsole.updateResource(logicContext, streamInfo, stream);
      }
      // 返回骨骼皮肤单元
      return skinInfo;
   }

   //============================================================
   // <T>构建蒙皮处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 蒙皮
   //============================================================
   @Override
   public FResSkeleton makeSkeleton(ILogicContext logicContext,
                                    long modelId,
                                    long skeletonId){
      FResSkeleton skeleton = new FResSkeleton();
      // 获得骨骼信息
      FGcResModelSkeletonInfo skeletonInfo = find(logicContext, skeletonId);
      if(skeletonInfo == null){
         return null;
      }
      skeleton.loadUnit(skeletonInfo);
      // 获得蒙皮集合
      FLogicDataset<FGcResModelSkeletonSkinInfo> skinInfos = _skeletonSkinConsole.fetch(logicContext, FDataResourceModelSkeletonSkinLogic.SKELETON_ID + "=" + skeletonId);
      for(FGcResModelSkeletonSkinInfo skinInfo : skinInfos){
         long skinId = skinInfo.ouid();
         // 创建蒙皮
         FResSkeletonSkin skin = new FResSkeletonSkin();
         skin.loadUnit(skinInfo);
         // 查找网格唯一编号
         FGcResModelMeshInfo meshInfo = _modelMeshConsole.find(logicContext, skinInfo.meshId());
         skin.setMeshGuid(meshInfo.guid());
         //............................................................
         // 查询网格的蒙皮数据
         FLogicDataset<FGcResModelSkeletonSkinStreamInfo> streamInfos = _skeletonSkinStreamConsole.fetchStreams(logicContext, skinId);
         if(streamInfos.isEmpty()){
            throw new FFatalError("Skin stream is not exists. (skin_id={1})", skinId);
         }
         // 构建数据流
         for(FGcResModelSkeletonSkinStreamInfo streamInfo : streamInfos){
            FResStream stream = _skeletonSkinStreamConsole.makeStream(logicContext, streamInfo);
            skin.pushStream(stream);
         }
         skeleton.pushSkin(skin);
      }
      return skeleton;
   }
}
