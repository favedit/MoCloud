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
import com.cyou.gccloud.data.data.FDataResource3dSkeletonAnimationLogic;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonAnimationUnit;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonUnit;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.FFatalError;
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
   // @param guid 唯一编号
   //============================================================
   @Override
   public FRs3Model makeModel(ILogicContext logicContext,
                              String guid){
      // 获得模型信息
      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
      FDataResource3dModelUnit modelUnit = modelLogic.findByGuid(guid);
      if(modelUnit == null){
         return null;
      }
      long modelId = modelUnit.ouid();
      //............................................................
      // 生成数据
      FRs3Model model = new FRs3Model();
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
         mesh.loadUnit(meshUnit);
         // 获得数据流信息
         FDataResource3dMeshStreamLogic meshStreamLogic = logicContext.findLogic(FDataResource3dMeshStreamLogic.class);
         FLogicDataset<FDataResource3dMeshStreamUnit> meshStreamUnits = meshStreamLogic.fetch(FDataResource3dMeshStreamLogic.MESH_ID + "=" + meshUnit.ouid());
         for(FDataResource3dMeshStreamUnit meshStreamUnit : meshStreamUnits){
            // 建立数据流
            FRs3Stream stream = _streamConsole.makeStream(logicContext, meshStreamUnit.streamId());
            mesh.streams().push(stream);
         }
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
         // 查找动画关联骨骼
         FDataResource3dSkeletonAnimationLogic skeletonAnimationLogic = logicContext.findLogic(FDataResource3dSkeletonAnimationLogic.class);
         FLogicDataset<FDataResource3dSkeletonAnimationUnit> skeletonAnimationUnits = skeletonAnimationLogic.fetch(FDataResource3dSkeletonAnimationLogic.ANIMATION_ID + "=" + animationId);
         if(!skeletonAnimationUnits.isEmpty()){
            if(skeletonAnimationUnits.count() > 1){
               throw new FFatalError("Animation skeleton is too many.");
            }
            FDataResource3dSkeletonAnimationUnit skeletonAnimationUnit = skeletonAnimationUnits.first();
            FDataResource3dSkeletonUnit skeletonUnit = skeletonAnimationUnit.skeleton();
            animation.setSkeletonGuid(skeletonUnit.guid());
         }
      }
      // 返回模型
      return model;
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   //============================================================
   @Override
   public byte[] makeModelData(ILogicContext logicContext,
                               String guid){
      //............................................................
      // 查找数据
      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.Resource3dModel, guid);
      if(findStorage != null){
         return findStorage.data();
      }
      //............................................................
      // 生成模型
      FRs3Model model = makeModel(logicContext, guid);
      // 获得数据
      FByteStream stream = new FByteStream();
      model.serialize(stream);
      byte[] data = stream.toArray();
      // 存储数据
      SGcStorage storage = new SGcStorage(EGcStorageCatalog.Resource3dModel, guid, "bin");
      storage.setCode(model.code());
      storage.setData(data);
      _storageConsole.store(storage);
      // 返回数据
      return data;
   }
}
