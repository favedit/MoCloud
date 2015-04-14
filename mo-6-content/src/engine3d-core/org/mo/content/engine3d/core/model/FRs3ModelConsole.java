package org.mo.content.engine3d.core.model;

import org.mo.com.console.FConsole;

//============================================================
// <T>资源模型控制台。</T>
//============================================================
public class FRs3ModelConsole
      extends FConsole
      implements
         IRs3ModelConsole
{
   //   // 存储管理接口
   //   @ALink
   //   protected IGcStorageConsole _storageConsole;
   //
   //   // 数据流管理接口
   //   @ALink
   //   protected IRs3StreamConsole _streamConsole;
   //
   //   // 网格控制台
   //   @ALink
   //   protected IRs3MeshConsole _meshConsole;
   //
   //   // 骨骼控制台
   //   @ALink
   //   protected IRs3SkeletonConsole _skeletonConsole;
   //
   //   // 动画控制台
   //   @ALink
   //   protected IRs3AnimationConsole _animationConsole;
   //
   //   //============================================================
   //   // <T>根据代码查找模型单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public FDataResource3dModelUnit findByCode(ILogicContext logicContext,
   //                                              String code){
   //      String searchSql = FDataResource3dModelLogic.CODE + "='" + code + "'";
   //      FDataResource3dModelLogic logic = logicContext.findLogic(FDataResource3dModelLogic.class);
   //      FDataResource3dModelUnit unit = logic.search(searchSql);
   //      return unit;
   //   }
   //
   //   //============================================================
   //   // <T>根据代码查找模型网格单元。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param code 代码
   //   // @return 模型网格单元
   //   //============================================================
   //   @Override
   //   public FDataResource3dMeshUnit findMeshByCode(ILogicContext logicContext,
   //                                                 long modelId,
   //                                                 String code){
   //      String whereSql = "(" + FDataResource3dModelMeshLogic.MODEL_ID + "=" + modelId + ") AND (" + FDataResource3dModelMeshLogic.CODE + "='" + code + "')";
   //      FDataResource3dModelMeshLogic modelMeshLogic = logicContext.findLogic(FDataResource3dModelMeshLogic.class);
   //      FDataResource3dModelMeshUnit modelMeshUnit = modelMeshLogic.search(whereSql);
   //      return modelMeshUnit.mesh();
   //   }
   //
   //   //============================================================
   //   // <T>生成资源模型。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 资源模型
   //   //============================================================
   //   @Override
   //   public FRs3Model makeModel(ILogicContext logicContext,
   //                              String guid){
   //      // 获得模型信息
   //      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
   //      FDataResource3dModelUnit modelUnit = modelLogic.findByGuid(guid);
   //      if(modelUnit == null){
   //         return null;
   //      }
   //      long modelId = modelUnit.ouid();
   //      //............................................................
   //      // 生成数据
   //      FRs3Model model = new FRs3Model();
   //      model.setGuid(modelUnit.guid());
   //      model.setCode(modelUnit.code());
   //      // 获得网格信息
   //      FDataResource3dModelMeshLogic meshLogic = logicContext.findLogic(FDataResource3dModelMeshLogic.class);
   //      FLogicDataset<FDataResource3dModelMeshUnit> modelMeshUnits = meshLogic.fetch(FDataResource3dModelMeshLogic.MODEL_ID + "=" + modelId, "`" + FDataResource3dModelMeshLogic.INDEX + "` ASC");
   //      for(FDataResource3dModelMeshUnit modelMeshUnit : modelMeshUnits){
   //         // 查找网格
   //         FDataResource3dMeshUnit meshUnit = modelMeshUnit.mesh();
   //         // 创建资源网格
   //         FRs3ModelMesh mesh = new FRs3ModelMesh();
   //         mesh.loadUnit(meshUnit);
   //         // 获得数据流信息
   //         FDataResource3dMeshStreamLogic meshStreamLogic = logicContext.findLogic(FDataResource3dMeshStreamLogic.class);
   //         FLogicDataset<FDataResource3dMeshStreamUnit> meshStreamUnits = meshStreamLogic.fetch(FDataResource3dMeshStreamLogic.MESH_ID + "=" + meshUnit.ouid());
   //         for(FDataResource3dMeshStreamUnit meshStreamUnit : meshStreamUnits){
   //            // 建立数据流
   //            FRs3Stream stream = _streamConsole.makeStream(logicContext, meshStreamUnit.streamId());
   //            mesh.streams().push(stream);
   //         }
   //         model.meshs().push(mesh);
   //      }
   //      //............................................................
   //      // 获得骨骼集合
   //      FDataResource3dModelSkeletonLogic modelSkeletonLogic = logicContext.findLogic(FDataResource3dModelSkeletonLogic.class);
   //      FLogicDataset<FDataResource3dModelSkeletonUnit> modelSkeletonUnits = modelSkeletonLogic.fetch(FDataResource3dModelSkeletonLogic.MODEL_ID + "=" + modelId);
   //      for(FDataResource3dModelSkeletonUnit modelSkeletonUnit : modelSkeletonUnits){
   //         long skeletonId = modelSkeletonUnit.skeletonId();
   //         // 获得骨骼
   //         FRs3Skeleton skeleton = _skeletonConsole.makeSkeleton(logicContext, modelId, skeletonId);
   //         model.skeletons().push(skeleton);
   //      }
   //      //............................................................
   //      // 获得动画集合
   //      FDataResource3dModelAnimationLogic modelAnimationLogic = logicContext.findLogic(FDataResource3dModelAnimationLogic.class);
   //      FLogicDataset<FDataResource3dModelAnimationUnit> modelAnimationUnits = modelAnimationLogic.fetch(FDataResource3dModelAnimationLogic.MODEL_ID + "=" + modelId);
   //      for(FDataResource3dModelAnimationUnit modelAnimationUnit : modelAnimationUnits){
   //         long animationId = modelAnimationUnit.animationId();
   //         // 获得动画
   //         FRs3Animation animation = _animationConsole.makeAnimation(logicContext, animationId);
   //         model.animations().push(animation);
   //         // 查找动画关联骨骼
   //         FDataResource3dSkeletonAnimationLogic skeletonAnimationLogic = logicContext.findLogic(FDataResource3dSkeletonAnimationLogic.class);
   //         FLogicDataset<FDataResource3dSkeletonAnimationUnit> skeletonAnimationUnits = skeletonAnimationLogic.fetch(FDataResource3dSkeletonAnimationLogic.ANIMATION_ID + "=" + animationId);
   //         if(!skeletonAnimationUnits.isEmpty()){
   //            if(skeletonAnimationUnits.count() > 1){
   //               throw new FFatalError("Animation skeleton is too many.");
   //            }
   //            FDataResource3dSkeletonAnimationUnit skeletonAnimationUnit = skeletonAnimationUnits.first();
   //            FDataResource3dSkeletonUnit skeletonUnit = skeletonAnimationUnit.skeleton();
   //            animation.setSkeletonGuid(skeletonUnit.guid());
   //         }
   //      }
   //      // 返回模型
   //      return model;
   //   }
   //
   //   //============================================================
   //   // <T>生成资源模型数据。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param guid 唯一编号
   //   // @return 资源模型数据
   //   //============================================================
   //   @Override
   //   public byte[] makeModelData(ILogicContext logicContext,
   //                               String guid){
   //      // 查找数据
   //      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.Cache3dModel, guid);
   //      if(findStorage != null){
   //         return findStorage.data();
   //      }
   //      //............................................................
   //      // 生成模型
   //      FRs3Model model = makeModel(logicContext, guid);
   //      // 获得数据
   //      FByteStream stream = new FByteStream();
   //      model.serialize(stream);
   //      // 压缩数据
   //      byte[] data = null;
   //      try(FCompressStream file = new FCompressStream(stream.toArray())){
   //         data = file.toCompressArray(ECompressMode.Lzma);
   //      }
   //      //............................................................
   //      // 存储数据
   //      SGcStorage storage = new SGcStorage(EGcStorageCatalog.Cache3dModel, guid, EMime.Bin.type());
   //      storage.setCode(model.code());
   //      storage.setData(data);
   //      _storageConsole.store(storage);
   //      // 返回数据
   //      return data;
   //   }
   //
   //   //============================================================
   //   // <T>导入模型。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param input 输入流
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public EResult importModel(ILogicContext logicContext,
   //                              String fileName){
   //      // 加载模型资源
   //      FRs3Model model = new FRs3Model();
   //      model.loadFile(fileName);
   //      //............................................................
   //      // 新建模型
   //      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
   //      FDataResource3dModelUnit modelUnit = modelLogic.doPrepare();
   //      modelUnit.setCode(model.code());
   //      modelUnit.setFullCode(model.fullCode());
   //      modelUnit.setLabel(model.label());
   //      modelUnit.setKeywords(model.keywords());
   //      modelLogic.doInsert(modelUnit);
   //      // 新建网格
   //      int meshCount = model.meshs().count();
   //      for(int n = 0; n < meshCount; n++){
   //         FRs3ModelMesh mesh = model.meshs().get(n);
   //         String meshCode = mesh.code();
   //         // 新建模型
   //         FDataResource3dMeshUnit meshUnit = _meshConsole.insert(logicContext, mesh);
   //         // 关联网格和模型
   //         FDataResource3dModelMeshLogic modelMeshLogic = logicContext.findLogic(FDataResource3dModelMeshLogic.class);
   //         FDataResource3dModelMeshUnit modelMeshUnit = modelMeshLogic.doPrepare();
   //         modelMeshUnit.setModelId(modelUnit.ouid());
   //         modelMeshUnit.setMeshId(meshUnit.ouid());
   //         modelMeshUnit.setIndex(n);
   //         modelMeshUnit.setCode(meshCode);
   //         modelMeshLogic.doInsert(modelMeshUnit);
   //      }
   //      return EResult.Success;
   //   }
   //
   //   //============================================================
   //   // <T>导入蒙皮。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param fileName 文件名称
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public EResult importSkeleton(ILogicContext logicContext,
   //                                 String fileName){
   //      // 加载骨骼资源
   //      FRs3Skeleton skeleton = new FRs3Skeleton();
   //      skeleton.importFile(fileName);
   //      //............................................................
   //      // 查找模型
   //      FDataResource3dModelUnit modelUnit = findByCode(logicContext, skeleton.code());
   //      //............................................................
   //      // 新建骨骼
   //      FDataResource3dSkeletonLogic skeletonLogic = logicContext.findLogic(FDataResource3dSkeletonLogic.class);
   //      FDataResource3dSkeletonUnit skeletonUnit = skeletonLogic.doPrepare();
   //      skeleton.saveUnit(skeletonUnit);
   //      skeletonLogic.doInsert(skeletonUnit);
   //      // 关联模型和骨骼
   //      FDataResource3dModelSkeletonLogic modelSkeletonLogic = logicContext.findLogic(FDataResource3dModelSkeletonLogic.class);
   //      FDataResource3dModelSkeletonUnit modelSkeletonUnit = modelSkeletonLogic.doPrepare();
   //      modelSkeletonUnit.setModelId(modelUnit.ouid());
   //      modelSkeletonUnit.setSkeletonId(skeletonUnit.ouid());
   //      modelSkeletonLogic.doInsert(modelSkeletonUnit);
   //      //............................................................
   //      // 新建蒙皮集合
   //      for(FRs3SkeletonSkin skin : skeleton.skins()){
   //         // 查找网格
   //         FDataResource3dMeshUnit meshUnit = findMeshByCode(logicContext, modelUnit.ouid(), skin.code());
   //         // 新建蒙皮
   //         FDataResource3dSkeletonSkinUnit skeletonSkinUnit = _skeletonConsole.insertSkin(logicContext, meshUnit.ouid(), skeletonUnit.ouid(), skin);
   //         // 关联网格和蒙皮
   //         FDataResource3dMeshSkinLogic meshSkinLogic = logicContext.findLogic(FDataResource3dMeshSkinLogic.class);
   //         FDataResource3dMeshSkinUnit meshSkinUnit = meshSkinLogic.doPrepare();
   //         meshSkinUnit.setMeshId(meshUnit.ouid());
   //         meshSkinUnit.setSkeletonId(skeletonUnit.ouid());
   //         meshSkinUnit.setSkeletonSkinId(skeletonSkinUnit.ouid());
   //         meshSkinLogic.doInsert(meshSkinUnit);
   //      }
   //      return EResult.Success;
   //   }
   //
   //   //============================================================
   //   // <T>导入动画。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param fileName 文件名称
   //   // @return 处理结果
   //   //============================================================
   //   @Override
   //   public EResult importAnimation(ILogicContext logicContext,
   //                                  String fileName){
   //      // 加载骨骼资源
   //      FRs3Animation animation = new FRs3Animation();
   //      animation.importFile(fileName);
   //      String modelCode = animation.code();
   //      //............................................................
   //      // 查找模型
   //      FDataResource3dModelUnit modelUnit = findByCode(logicContext, modelCode);
   //      if(modelUnit == null){
   //         throw new FFatalError("Model is not exists. (code={1})", modelCode);
   //      }
   //      long modelId = modelUnit.ouid();
   //      //............................................................
   //      // 新建动画
   //      FDataResource3dAnimationLogic animationLogic = logicContext.findLogic(FDataResource3dAnimationLogic.class);
   //      FDataResource3dAnimationUnit animationUnit = animationLogic.doPrepare();
   //      animation.saveUnit(animationUnit);
   //      animationLogic.doInsert(animationUnit);
   //      // 关联模型和动画
   //      FDataResource3dModelAnimationLogic modelAnimationLogic = logicContext.findLogic(FDataResource3dModelAnimationLogic.class);
   //      FDataResource3dModelAnimationUnit modelAnimationUnit = modelAnimationLogic.doPrepare();
   //      modelAnimationUnit.setModelId(modelId);
   //      modelAnimationUnit.setAnimationId(animationUnit.ouid());
   //      modelAnimationLogic.doInsert(modelAnimationUnit);
   //      //............................................................
   //      // 关联骨骼和动画
   //      FDataResource3dSkeletonUnit skeletonUnit = _skeletonConsole.findByCode(logicContext, modelCode);
   //      if(skeletonUnit != null){
   //         FDataResource3dSkeletonAnimationLogic skeletonAnimationLogic = logicContext.findLogic(FDataResource3dSkeletonAnimationLogic.class);
   //         FDataResource3dSkeletonAnimationUnit skeletonAnimationUnit = skeletonAnimationLogic.doPrepare();
   //         skeletonAnimationUnit.setSkeletonId(skeletonUnit.ouid());
   //         skeletonAnimationUnit.setAnimationId(animationUnit.ouid());
   //         skeletonAnimationLogic.doInsert(skeletonAnimationUnit);
   //      }
   //      //............................................................
   //      // 新建蒙皮集合
   //      for(FRs3Track track : animation.tracks()){
   //         // 新建蒙皮
   //         FDataResource3dTrackUnit trackUnit = _animationConsole.insertTrack(logicContext, track);
   //         // 关联动画和跟踪
   //         FDataResource3dAnimationTrackLogic animationTrackLogic = logicContext.findLogic(FDataResource3dAnimationTrackLogic.class);
   //         FDataResource3dAnimationTrackUnit animationTrackUnit = animationTrackLogic.doPrepare();
   //         animationTrackUnit.setAnimationId(animationUnit.ouid());
   //         animationTrackUnit.setTrackId(trackUnit.ouid());
   //         animationTrackLogic.doInsert(animationTrackUnit);
   //         // 关联网格和跟踪
   //         String meshCode = track.meshCode();
   //         if(!RString.isEmpty(meshCode)){
   //            FDataResource3dMeshUnit meshUnit = findMeshByCode(logicContext, modelId, meshCode);
   //            if(meshUnit == null){
   //               throw new FFatalError("Model mesh is not found. (model={1}, mesh={2})", modelCode, meshCode);
   //            }
   //            FDataResource3dMeshTrackLogic meshTrackLogic = logicContext.findLogic(FDataResource3dMeshTrackLogic.class);
   //            FDataResource3dMeshTrackUnit meshTrackUnit = meshTrackLogic.doPrepare();
   //            meshTrackUnit.setMeshId(meshUnit.ouid());
   //            meshTrackUnit.setTrackId(trackUnit.ouid());
   //            meshTrackLogic.doInsert(meshTrackUnit);
   //         }
   //      }
   //      return EResult.Success;
   //   }
}
