package org.mo.content.engine3d.core.model;

import com.cyou.gccloud.data.data.FDataResource3dAnimationLogic;
import com.cyou.gccloud.data.data.FDataResource3dAnimationTrackLogic;
import com.cyou.gccloud.data.data.FDataResource3dAnimationTrackUnit;
import com.cyou.gccloud.data.data.FDataResource3dAnimationUnit;
import com.cyou.gccloud.data.data.FDataResource3dMeshSkinLogic;
import com.cyou.gccloud.data.data.FDataResource3dMeshSkinUnit;
import com.cyou.gccloud.data.data.FDataResource3dMeshTrackLogic;
import com.cyou.gccloud.data.data.FDataResource3dMeshTrackUnit;
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
import com.cyou.gccloud.data.data.FDataResource3dSkeletonLogic;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonSkinUnit;
import com.cyou.gccloud.data.data.FDataResource3dSkeletonUnit;
import com.cyou.gccloud.data.data.FDataResource3dTrackUnit;
import org.mo.com.console.FConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.content.engine3d.core.animation.IRs3AnimationConsole;
import org.mo.content.engine3d.core.mesh.IRs3MeshConsole;
import org.mo.content.engine3d.core.skeleton.IRs3SkeletonConsole;
import org.mo.content.resource3d.common.FRs3Animation;
import org.mo.content.resource3d.common.FRs3Skeleton;
import org.mo.content.resource3d.common.FRs3SkeletonSkin;
import org.mo.content.resource3d.common.FRs3Track;
import org.mo.content.resource3d.model.FRs3Model;
import org.mo.content.resource3d.model.FRs3ModelMesh;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台。</T>
//============================================================
public class FRs3ModelConsole
      extends FConsole
      implements
         IRs3ModelConsole
{
   // 网格控制台
   @ALink
   protected IRs3MeshConsole _meshConsole;

   // 骨骼控制台
   @ALink
   protected IRs3SkeletonConsole _skeletonConsole;

   // 动画控制台
   @ALink
   protected IRs3AnimationConsole _animationConsole;

   //============================================================
   // <T>根据代码查找模型单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   @Override
   public FDataResource3dModelUnit findByCode(ILogicContext logicContext,
                                              String code){
      String searchSql = FDataResource3dModelLogic.CODE + "='" + code + "'";
      FDataResource3dModelLogic logic = logicContext.findLogic(FDataResource3dModelLogic.class);
      FDataResource3dModelUnit unit = logic.search(searchSql);
      return unit;
   }

   //============================================================
   // <T>根据代码查找模型网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 模型网格单元
   //============================================================
   @Override
   public FDataResource3dMeshUnit findMeshByCode(ILogicContext logicContext,
                                                 long modelId,
                                                 String code){
      String whereSql = "(" + FDataResource3dModelMeshLogic.MODEL_ID + "=" + modelId + ") AND (" + FDataResource3dModelMeshLogic.CODE + "='" + code + "')";
      FDataResource3dModelMeshLogic modelMeshLogic = logicContext.findLogic(FDataResource3dModelMeshLogic.class);
      FDataResource3dModelMeshUnit modelMeshUnit = modelMeshLogic.search(whereSql);
      return modelMeshUnit.mesh();
   }

   //============================================================
   // <T>导入模型。</T>
   //
   // @param logicContext 逻辑环境
   // @param input 输入流
   // @return 处理结果
   //============================================================
   @Override
   public EResult importModel(ILogicContext logicContext,
                              String fileName){
      // 加载模型资源
      FRs3Model model = new FRs3Model();
      model.loadFile(fileName);
      //............................................................
      // 新建模型
      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
      FDataResource3dModelUnit modelUnit = modelLogic.doPrepare();
      modelUnit.setCode(model.code());
      modelUnit.setFullCode(model.fullCode());
      modelUnit.setLabel(model.label());
      modelUnit.setKeywords(model.keywords());
      modelLogic.doInsert(modelUnit);
      // 新建网格
      int meshCount = model.meshs().count();
      for(int n = 0; n < meshCount; n++){
         FRs3ModelMesh mesh = model.meshs().get(n);
         String meshCode = mesh.code();
         // 新建模型
         FDataResource3dMeshUnit meshUnit = _meshConsole.insert(logicContext, mesh);
         // 关联网格和模型
         FDataResource3dModelMeshLogic modelMeshLogic = logicContext.findLogic(FDataResource3dModelMeshLogic.class);
         FDataResource3dModelMeshUnit modelMeshUnit = modelMeshLogic.doPrepare();
         modelMeshUnit.setModelId(modelUnit.ouid());
         modelMeshUnit.setMeshId(meshUnit.ouid());
         modelMeshUnit.setIndex(n);
         modelMeshUnit.setCode(meshCode);
         modelMeshLogic.doInsert(modelMeshUnit);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>导入蒙皮。</T>
   //
   // @param logicContext 逻辑环境
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   @Override
   public EResult importSkeleton(ILogicContext logicContext,
                                 String fileName){
      // 加载骨骼资源
      FRs3Skeleton skeleton = new FRs3Skeleton();
      skeleton.importFile(fileName);
      //............................................................
      // 查找模型
      FDataResource3dModelUnit modelUnit = findByCode(logicContext, skeleton.code());
      //............................................................
      // 新建骨骼
      FDataResource3dSkeletonLogic skeletonLogic = logicContext.findLogic(FDataResource3dSkeletonLogic.class);
      FDataResource3dSkeletonUnit skeletonUnit = skeletonLogic.doPrepare();
      skeleton.saveUnit(skeletonUnit);
      skeletonLogic.doInsert(skeletonUnit);
      // 关联模型和骨骼
      FDataResource3dModelSkeletonLogic modelSkeletonLogic = logicContext.findLogic(FDataResource3dModelSkeletonLogic.class);
      FDataResource3dModelSkeletonUnit modelSkeletonUnit = modelSkeletonLogic.doPrepare();
      modelSkeletonUnit.setModelId(modelUnit.ouid());
      modelSkeletonUnit.setSkeletonId(skeletonUnit.ouid());
      modelSkeletonLogic.doInsert(modelSkeletonUnit);
      //............................................................
      // 新建蒙皮集合
      for(FRs3SkeletonSkin skin : skeleton.skins()){
         // 查找网格
         FDataResource3dMeshUnit meshUnit = findMeshByCode(logicContext, modelUnit.ouid(), skin.code());
         // 新建蒙皮
         FDataResource3dSkeletonSkinUnit skeletonSkinUnit = _skeletonConsole.insertSkin(logicContext, meshUnit.ouid(), skeletonUnit.ouid(), skin);
         // 关联网格和蒙皮
         FDataResource3dMeshSkinLogic meshSkinLogic = logicContext.findLogic(FDataResource3dMeshSkinLogic.class);
         FDataResource3dMeshSkinUnit meshSkinUnit = meshSkinLogic.doPrepare();
         meshSkinUnit.setMeshId(meshUnit.ouid());
         meshSkinUnit.setSkeletonId(skeletonUnit.ouid());
         meshSkinUnit.setSkeletonSkinId(skeletonSkinUnit.ouid());
         meshSkinLogic.doInsert(meshSkinUnit);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>导入动画。</T>
   //
   // @param logicContext 逻辑环境
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   @Override
   public EResult importAnimation(ILogicContext logicContext,
                                  String fileName){
      // 加载骨骼资源
      FRs3Animation animation = new FRs3Animation();
      animation.importFile(fileName);
      String modelCode = animation.code();
      //............................................................
      // 查找模型
      FDataResource3dModelUnit modelUnit = findByCode(logicContext, modelCode);
      if(modelUnit == null){
         throw new FFatalError("Model is not exists. (code={1})", modelCode);
      }
      long modelId = modelUnit.ouid();
      //............................................................
      // 新建动画
      FDataResource3dAnimationLogic animationLogic = logicContext.findLogic(FDataResource3dAnimationLogic.class);
      FDataResource3dAnimationUnit animationUnit = animationLogic.doPrepare();
      animation.saveUnit(animationUnit);
      animationLogic.doInsert(animationUnit);
      // 关联模型和动画
      FDataResource3dModelAnimationLogic modelAnimationLogic = logicContext.findLogic(FDataResource3dModelAnimationLogic.class);
      FDataResource3dModelAnimationUnit modelAnimationUnit = modelAnimationLogic.doPrepare();
      modelAnimationUnit.setModelId(modelId);
      modelAnimationUnit.setAnimationId(animationUnit.ouid());
      modelAnimationLogic.doInsert(modelAnimationUnit);
      //............................................................
      // 关联骨骼和动画
      FDataResource3dSkeletonUnit skeletonUnit = _skeletonConsole.findByCode(logicContext, modelCode);
      if(skeletonUnit != null){
         FDataResource3dSkeletonAnimationLogic skeletonAnimationLogic = logicContext.findLogic(FDataResource3dSkeletonAnimationLogic.class);
         FDataResource3dSkeletonAnimationUnit skeletonAnimationUnit = skeletonAnimationLogic.doPrepare();
         skeletonAnimationUnit.setSkeletonId(skeletonUnit.ouid());
         skeletonAnimationUnit.setAnimationId(animationUnit.ouid());
         skeletonAnimationLogic.doInsert(skeletonAnimationUnit);
      }
      //............................................................
      // 新建蒙皮集合
      for(FRs3Track track : animation.tracks()){
         // 新建蒙皮
         FDataResource3dTrackUnit trackUnit = _animationConsole.insertTrack(logicContext, track);
         // 关联动画和跟踪
         FDataResource3dAnimationTrackLogic animationTrackLogic = logicContext.findLogic(FDataResource3dAnimationTrackLogic.class);
         FDataResource3dAnimationTrackUnit animationTrackUnit = animationTrackLogic.doPrepare();
         animationTrackUnit.setAnimationId(animationUnit.ouid());
         animationTrackUnit.setTrackId(trackUnit.ouid());
         animationTrackLogic.doInsert(animationTrackUnit);
         // 关联网格和跟踪
         String meshCode = track.meshCode();
         if(!RString.isEmpty(meshCode)){
            FDataResource3dMeshUnit meshUnit = findMeshByCode(logicContext, modelId, meshCode);
            if(meshUnit == null){
               throw new FFatalError("Model mesh is not found. (model={1}, mesh={2})", modelCode, meshCode);
            }
            FDataResource3dMeshTrackLogic meshTrackLogic = logicContext.findLogic(FDataResource3dMeshTrackLogic.class);
            FDataResource3dMeshTrackUnit meshTrackUnit = meshTrackLogic.doPrepare();
            meshTrackUnit.setMeshId(meshUnit.ouid());
            meshTrackUnit.setTrackId(trackUnit.ouid());
            meshTrackLogic.doInsert(meshTrackUnit);
         }
      }
      return EResult.Success;
   }
}
