package org.mo.content.core.resource3d.model;

import com.cyou.gccloud.data.data.FDataResource3dMeshStreamLogic;
import com.cyou.gccloud.data.data.FDataResource3dMeshStreamUnit;
import com.cyou.gccloud.data.data.FDataResource3dMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelAnimationLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelAnimationUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelMeshUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelSkeletonLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelSkeletonUnit;
import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.content.core.resource3d.animation.IC3dAnimationConsole;
import org.mo.content.core.resource3d.skeleton.IC3dSkeletonConsole;
import org.mo.content.engine3d.core.stream.IRs3StreamConsole;
import org.mo.content.resource3d.common.FRs3Animation;
import org.mo.content.resource3d.common.FRs3Skeleton;
import org.mo.content.resource3d.common.FRs3Stream;
import org.mo.content.resource3d.model.FRs3Model;
import org.mo.content.resource3d.model.FRs3ModelMesh;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>模型控制台。</T>
//============================================================
public class FC3dModelConsole
      implements
         IC3dModelConsole
{
   // 存储管理接口
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 数据流管理接口
   @ALink
   protected IRs3StreamConsole _streamConsole;

   // 骨骼管理接口
   @ALink
   protected IC3dSkeletonConsole _skeletonConsole;

   // 动画管理接口
   @ALink
   protected IC3dAnimationConsole _animationConsole;

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param version 版本
   //============================================================
   @Override
   public FRs3Model makeModel(ILogicContext logicContext,
                              String code,
                              String version){
      FRs3Model model = new FRs3Model();
      // 获得模型信息
      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
      FDataResource3dModelUnit modelUnit = modelLogic.findByGuid(code);
      if(modelUnit == null){
         return null;
      }
      long modelId = modelUnit.ouid();
      model.setGuid(modelUnit.guid());
      model.setCode(modelUnit.code());
      // 获得网格信息
      FDataResource3dModelMeshLogic meshLogic = logicContext.findLogic(FDataResource3dModelMeshLogic.class);
      FLogicDataset<FDataResource3dModelMeshUnit> modelMeshUnits = meshLogic.fetch(FDataResource3dModelMeshLogic.MODEL_ID + "=" + modelId);
      for(FDataResource3dModelMeshUnit modelMeshUnit : modelMeshUnits){
         // 查找网格
         FDataResource3dMeshUnit meshUnit = modelMeshUnit.mesh();
         // 创建资源网格
         FRs3ModelMesh mesh = new FRs3ModelMesh();
         mesh.setGuid(meshUnit.guid());
         // 获得数据流信息
         FDataResource3dMeshStreamLogic meshStreamLogic = logicContext.findLogic(FDataResource3dMeshStreamLogic.class);
         FLogicDataset<FDataResource3dMeshStreamUnit> meshStreamUnits = meshStreamLogic.fetch(FDataResource3dMeshStreamLogic.MESH_ID + "=" + meshUnit.ouid());
         for(FDataResource3dMeshStreamUnit meshStreamUnit : meshStreamUnits){
            // 建立数据流
            FRs3Stream stream = _streamConsole.makeStream(logicContext, meshStreamUnit.streamId());
            mesh.streams().push(stream);
         }
         //         // 获得跟踪信息
         //         FDataResource3dMeshTrackLogic meshTrackLogic = logicContext.findLogic(FDataResource3dMeshTrackLogic.class);
         //         FLogicDataset<FDataResource3dMeshTrackUnit> meshTrackUnits = meshTrackLogic.fetch(FDataResource3dMeshTrackLogic.MESH_ID + "=" + meshUnit.ouid());
         //         for(FDataResource3dMeshTrackUnit meshTrackUnit : meshTrackUnits){
         //            // 查找数据流
         //            FDataResource3dTrackUnit trackUnit = meshTrackUnit.track();
         //            // 设置属性
         //            FRs3Track track = new FRs3Track();
         //            // 读取文件
         //            SGcStorage resource = _storageConsole.find(EGcStorageCatalog.Resource3dTrack, trackUnit.guid());
         //            track.setData(resource.data());
         //            mesh.tracks().push(track);
         //         }
         model.meshs().push(mesh);
      }
      //............................................................
      // 获得骨骼集合
      FDataResource3dModelSkeletonLogic modelSkeletonLogic = logicContext.findLogic(FDataResource3dModelSkeletonLogic.class);
      FLogicDataset<FDataResource3dModelSkeletonUnit> modelSkeletonUnits = modelSkeletonLogic.fetch(FDataResource3dModelSkeletonLogic.MODEL_ID + "=" + modelId);
      for(FDataResource3dModelSkeletonUnit modelSkeletonUnit : modelSkeletonUnits){
         long skeletonId = modelSkeletonUnit.skeletonId();
         // 获得骨骼
         FRs3Skeleton skeleton = _skeletonConsole.makeSkeleton(logicContext, modelId, skeletonId);
         model.skeletons().push(skeleton);
      }
      //............................................................
      // 获得动画集合
      FDataResource3dModelAnimationLogic modelAnimationLogic = logicContext.findLogic(FDataResource3dModelAnimationLogic.class);
      FLogicDataset<FDataResource3dModelAnimationUnit> modelAnimationUnits = modelAnimationLogic.fetch(FDataResource3dModelAnimationLogic.MODEL_ID + "=" + modelId);
      for(FDataResource3dModelAnimationUnit modelAnimationUnit : modelAnimationUnits){
         long animationId = modelAnimationUnit.animationId();
         // 获得动画
         FRs3Animation animation = _animationConsole.makeAnimation(logicContext, animationId);
         model.animations().push(animation);
      }
      return model;
   }
}
