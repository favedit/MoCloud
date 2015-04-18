package org.mo.content.engine3d.core.model;

import com.cyou.gccloud.data.data.FDataResourceModelAnimationLogic;
import com.cyou.gccloud.data.data.FDataResourceModelSkeletonLogic;
import com.cyou.gccloud.data.data.FDataResourceModelUnit;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.cloud.logic.resource.FGcResourceInfo;
import org.mo.cloud.logic.resource.model.FGcResModelConsole;
import org.mo.cloud.logic.resource.model.FGcResModelInfo;
import org.mo.cloud.logic.resource.model.animation.FGcResModelAnimationInfo;
import org.mo.cloud.logic.resource.model.animation.FGcResModelAnimationTrackInfo;
import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshStreamInfo;
import org.mo.cloud.logic.resource.model.skeleton.FGcResModelSkeletonInfo;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.content.engine3d.core.model.animation.IResModelAnimationConsole;
import org.mo.content.engine3d.core.model.animation.IResModelAnimationTrackConsole;
import org.mo.content.engine3d.core.model.skeleton.IResModelSkeletonConsole;
import org.mo.content.engine3d.core.model.skeleton.IResModelSkeletonSkinStreamConsole;
import org.mo.content.geom.mesh.FGeomMesh;
import org.mo.content.geom.mesh.FGeomModel;
import org.mo.content.mime.obj.FObjFile;
import org.mo.content.mime.phy.FPlyFile;
import org.mo.content.mime.stl.FStlFile;
import org.mo.content.resource3d.common.FRs3Animation;
import org.mo.content.resource3d.common.FRs3Skeleton;
import org.mo.content.resource3d.common.FRs3SkeletonSkin;
import org.mo.content.resource3d.common.FRs3Stream;
import org.mo.content.resource3d.common.FRs3Track;
import org.mo.content.resource3d.model.FRs3Model;
import org.mo.content.resource3d.model.FRs3ModelMesh;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.mime.compress.ECompressMode;
import org.mo.mime.compress.FCompressStream;

//============================================================
// <T>资源模型控制台。</T>
//============================================================
public class FResModelConsole
      extends FGcResModelConsole
      implements
         IResModelConsole
{
   // 资源模型网格控制台
   @ALink
   protected IResModelMeshConsole _meshConsole;

   // 数据流管理接口
   @ALink
   protected IResModelMeshStreamConsole _meshStreamConsole;

   // 资源模型网格控制台
   @ALink
   protected IResModelAnimationConsole _animationConsole;

   // 资源模型网格控制台
   @ALink
   protected IResModelAnimationTrackConsole _animationTrackConsole;

   // 资源模型网格控制台
   @ALink
   protected IResModelSkeletonConsole _skeletonConsole;

   // 资源模型网格控制台
   @ALink
   protected IResModelSkeletonSkinStreamConsole _skeletonSkinStreamConsole;

   //============================================================
   // <T>生成资源模型。</T>
   //
   // @param logicContext 逻辑环境
   // @param modelInfo 模型信息
   // @return 资源模型
   //============================================================
   @Override
   public FRs3Model makeModel(ILogicContext logicContext,
                              FGcResModelInfo modelInfo){
      // 获得模型信息
      if(modelInfo == null){
         throw new FFatalError("Model is empty.");
      }
      long modelId = modelInfo.ouid();
      //............................................................
      // 生成数据
      FRs3Model model = new FRs3Model();
      model.loadUnit(modelInfo);
      // 获得网格信息
      FLogicDataset<FGcResModelMeshInfo> meshInfos = _meshConsole.fetchByModelId(logicContext, modelId);
      for(FGcResModelMeshInfo meshInfo : meshInfos){
         long meshId = meshInfo.ouid();
         // 创建资源网格
         FRs3ModelMesh mesh = new FRs3ModelMesh();
         mesh.loadUnit(meshInfo);
         // 获得数据流信息
         FLogicDataset<FGcResModelMeshStreamInfo> streamInfos = _meshStreamConsole.fetchByMeshId(logicContext, meshId);
         for(FGcResModelMeshStreamInfo streamInfo : streamInfos){
            // 建立数据流
            FRs3Stream stream = _meshStreamConsole.makeStream(logicContext, streamInfo);
            mesh.pushStream(stream);
         }
         model.pushMesh(mesh);
      }
      //............................................................
      // 获得骨骼集合
      FLogicDataset<FGcResModelSkeletonInfo> skeletonInfos = _skeletonConsole.fetch(logicContext, FDataResourceModelSkeletonLogic.MODEL_ID + "=" + modelId);
      for(FGcResModelSkeletonInfo skeletonInfo : skeletonInfos){
         long skeletonId = skeletonInfo.ouid();
         // 生成骨骼数据
         FRs3Skeleton skeleton = _skeletonConsole.makeSkeleton(logicContext, modelId, skeletonId);
         model.pushSkeleton(skeleton);
      }
      //............................................................
      // 获得动画集合
      FLogicDataset<FGcResModelAnimationInfo> animationInfos = _animationConsole.fetch(logicContext, FDataResourceModelAnimationLogic.MODEL_ID + "=" + modelId);
      for(FGcResModelAnimationInfo animationInfo : animationInfos){
         long animationId = animationInfo.ouid();
         // 获得动画
         FRs3Animation animation = _animationConsole.makeAnimation(logicContext, animationId);
         model.pushAnimation(animation);
      }
      // 返回模型
      return model;
   }

   //============================================================
   // <T>生成资源模型数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 资源唯一编号
   // @return 资源模型数据
   //============================================================
   @Override
   public byte[] makeModelData(ILogicContext logicContext,
                               String guid){
      // 查找数据
      SGcStorage findStorage = _storageConsole.find(EGcStorageCatalog.CacheResourceModel, guid);
      if(findStorage != null){
         return findStorage.data();
      }
      // 获得唯一编号
      FGcResModelInfo modelInfo = findByResourceGuid(logicContext, guid);
      if(modelInfo == null){
         throw new FFatalError("Model is not exist. (guid={1})", guid);
      }
      //............................................................
      // 生成模型
      FRs3Model model = makeModel(logicContext, modelInfo);
      // 获得数据
      FByteStream stream = new FByteStream();
      model.serialize(stream);
      // 压缩数据
      byte[] data = null;
      try(FCompressStream compressStream = new FCompressStream(stream.memory(), 0, stream.length())){
         data = compressStream.toCompressArray(ECompressMode.Lzma);
      }
      //............................................................
      // 存储数据
      SGcStorage storage = new SGcStorage(EGcStorageCatalog.CacheResourceModel, guid);
      storage.setCode(model.code());
      storage.setData(data);
      _storageConsole.store(storage);
      // 返回数据
      return data;
   }

   //============================================================
   // <T>更新模型信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param model 模型
   // @return 模型信息
   //============================================================
   @Override
   public FGcResModelInfo updateModel(ILogicContext logicContext,
                                      FRs3Model model){
      // 检查参数
      String guid = model.guid();
      if(RString.isEmpty(guid)){
         throw new FFatalError("Model guid is null.");
      }
      // 查找数据
      FGcResModelInfo modelInfo = findByGuid(logicContext, guid);
      if(modelInfo == null){
         throw new FFatalError("Mesh is not exists. (guid={1}})", guid);
      }
      long resourceId = modelInfo.resourceId();
      // 创建场景
      model.saveUnit(modelInfo);
      // 更新数据
      doUpdate(logicContext, modelInfo);
      //............................................................
      // 废弃临时数据
      FGcResourceInfo resource = _dataResourceConsole.get(logicContext, resourceId);
      _storageConsole.delete(EGcStorageCatalog.CacheResourceModel, resource.guid());
      _dataResourceConsole.doUpdate(logicContext, resource);
      // 返回网格单元
      return modelInfo;
   }

   //============================================================
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param modelInfo 模型信息
   // @param model 模型
   // @return 模型信息
   //============================================================
   @Override
   public EResult updateResource(ILogicContext logicContext,
                                 FGcResModelInfo modelInfo,
                                 FRs3Model model){
      // 检查参数
      if(modelInfo == null){
         throw new FFatalError("Model info is empty.");
      }
      if(model == null){
         throw new FFatalError("Model is empty.");
      }
      long modelId = modelInfo.ouid();
      String modelGuid = modelInfo.guid();
      model.loadUnit(modelInfo);
      //............................................................
      // 删除模型内所有网格
      _meshConsole.doDeleteByModelId(logicContext, modelId);
      //............................................................
      // 更新所有数据流
      // 新建所有网格信息
      int meshCount = model.meshs().count();
      for(int n = 0; n < meshCount; n++){
         FRs3ModelMesh modelMesh = model.meshs().get(n);
         // 新建网格信息
         FGcResModelMeshInfo meshInfo = _meshConsole.doPrepare(logicContext);
         meshInfo.setModelId(modelId);
         modelMesh.setGuid(meshInfo.guid());
         modelMesh.saveUnit(meshInfo);
         _meshConsole.doInsert(logicContext, meshInfo);
         // 更新网格数据
         _meshConsole.updateResource(logicContext, meshInfo, modelMesh);
      }
      // 更新网格
      model.saveUnit(modelInfo);
      doUpdate(logicContext, modelInfo);
      //............................................................
      // 废弃临时数据
      _storageConsole.delete(EGcStorageCatalog.CacheResourceModel, modelGuid);
      //............................................................
      return EResult.Success;
   }

   //============================================================
   // <T>更新PLY资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param modelInfo 模型信息
   // @param file 文件
   // @return 处理结果
   //============================================================
   @Override
   public EResult updateResourcePly(ILogicContext logicContext,
                                    FGcResModelInfo modelInfo,
                                    FPlyFile file){
      // 加载网格
      FRs3ModelMesh mesh = new FRs3ModelMesh();
      file.buildMesh(mesh);
      // 创建模型
      FRs3Model model = new FRs3Model();
      model.pushMesh(mesh);
      //............................................................
      // 新建模型
      return updateResource(logicContext, modelInfo, model);
   }

   //============================================================
   // <T>更新OBJ资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param modelInfo 模型信息
   // @param file 文件
   // @return 处理结果
   //============================================================
   @Override
   public EResult updateResourceObj(ILogicContext logicContext,
                                    FGcResModelInfo modelInfo,
                                    FObjFile file){
      // 加载模型资源
      FRs3Model model = new FRs3Model();
      FGeomModel geomModel = file.CreateGeomModel();
      for(FGeomMesh geomMesh : geomModel.meshs()){
         FRs3ModelMesh mesh = new FRs3ModelMesh();
         mesh.loadGeometry(geomMesh);
         model.pushMesh(mesh);
      }
      //............................................................
      // 新建模型
      updateResource(logicContext, modelInfo, model);
      return EResult.Success;
   }

   //============================================================
   // <T>更新STL资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param modelInfo 模型信息
   // @param file 文件
   // @return 处理结果
   //============================================================
   @Override
   public EResult updateResourceStl(ILogicContext logicContext,
                                    FGcResModelInfo modelInfo,
                                    FStlFile file){
      // 加载模型资源
      FRs3Model model = new FRs3Model();
      FGeomModel geomModel = file.CreateGeomModel();
      for(FGeomMesh geomMesh : geomModel.meshs()){
         FRs3ModelMesh mesh = new FRs3ModelMesh();
         mesh.loadGeometry(geomMesh);
         model.pushMesh(mesh);
      }
      //............................................................
      // 新建模型
      updateResource(logicContext, modelInfo, model);
      return EResult.Success;
   }

   //============================================================
   // <T>导入模型。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 输入流
   // @return 处理结果
   //============================================================
   @Override
   public EResult importModel(ILogicContext logicContext,
                              FGcSessionInfo session,
                              String fileName){
      long userId = session.userId();
      long projectId = session.projectId();
      // 加载模型资源
      FRs3Model model = new FRs3Model();
      model.loadFile(fileName);
      //............................................................
      // 新建模型
      FGcResModelInfo modelInfo = doPrepare(logicContext);
      modelInfo.setUserId(userId);
      modelInfo.setProjectId(projectId);
      modelInfo.setFullCode(model.fullCode());
      modelInfo.setCode(model.code());
      modelInfo.setLabel(model.label());
      modelInfo.setKeywords(model.keywords());
      doInsert(logicContext, modelInfo);
      //............................................................
      // 新建网格集合
      int meshCount = model.meshs().count();
      for(int n = 0; n < meshCount; n++){
         FRs3ModelMesh mesh = model.meshs().get(n);
         String meshCode = mesh.code();
         // 新建网格
         FGcResModelMeshInfo meshInfo = _meshConsole.doPrepare(logicContext);
         meshInfo.setUserId(userId);
         meshInfo.setProjectId(projectId);
         meshInfo.setModelId(modelInfo.ouid());
         meshInfo.setSortIndex(n);
         meshInfo.setCode(meshCode);
         _meshConsole.doInsert(logicContext, meshInfo);
         // 更新网格数据
         _meshConsole.updateResource(logicContext, meshInfo, mesh);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>导入蒙皮。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   @Override
   public EResult importSkeleton(ILogicContext logicContext,
                                 FGcSessionInfo session,
                                 String fileName){
      // 加载骨骼资源
      FRs3Skeleton skeleton = new FRs3Skeleton();
      skeleton.importFile(fileName);
      String skeletonCode = skeleton.code();
      //............................................................
      // 查找模型信息
      FDataResourceModelUnit modelInfo = findByCode(logicContext, skeletonCode);
      long modelId = modelInfo.ouid();
      //............................................................
      // 新建骨骼信息
      FGcResModelSkeletonInfo skeletonInfo = _skeletonConsole.doPrepare(logicContext);
      skeletonInfo.setUserId(session.userId());
      skeletonInfo.setProjectId(session.projectId());
      skeletonInfo.setModelId(modelInfo.ouid());
      skeleton.saveUnit(skeletonInfo);
      _skeletonConsole.doInsert(logicContext, skeletonInfo);
      //............................................................
      // 新建蒙皮集合
      for(FRs3SkeletonSkin skin : skeleton.skins()){
         // 查找网格
         FGcResModelMeshInfo meshInfo = _meshConsole.findByModelCode(logicContext, modelId, skin.code());
         // 新建蒙皮
         _skeletonConsole.insertSkin(logicContext, meshInfo, skeletonInfo, skin);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>导入动画。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   @Override
   public EResult importAnimation(ILogicContext logicContext,
                                  FGcSessionInfo session,
                                  String fileName){
      // 加载骨骼资源
      FRs3Animation animation = new FRs3Animation();
      animation.importFile(fileName);
      String modelCode = animation.code();
      //............................................................
      // 查找模型信息
      FGcResModelInfo modelInfo = findByCode(logicContext, modelCode);
      if(modelInfo == null){
         throw new FFatalError("Model is not exists. (code={1})", modelCode);
      }
      long modelId = modelInfo.ouid();
      //............................................................
      // 查找骨骼信息
      long skeletonId = 0;
      FGcResModelSkeletonInfo skeletonInfo = _skeletonConsole.findByCode(logicContext, modelCode);
      if(skeletonInfo != null){
         skeletonId = skeletonInfo.ouid();
      }
      //............................................................
      // 新建动画信息
      FGcResModelAnimationInfo animationInfo = _animationConsole.doPrepare(logicContext);
      animationInfo.setUserId(session.userId());
      animationInfo.setProjectId(session.projectId());
      animationInfo.setModelId(modelId);
      animationInfo.setSkeletonId(skeletonId);
      animation.saveUnit(animationInfo);
      _animationConsole.doInsert(logicContext, animationInfo);
      long animationId = animationInfo.ouid();
      //............................................................
      // 新建蒙皮集合
      for(FRs3Track track : animation.tracks()){
         // 查找关联网格信息
         long meshId = 0;
         String meshCode = track.meshCode();
         if(!RString.isEmpty(meshCode)){
            FGcResModelMeshInfo meshInfo = _meshConsole.findByModelCode(logicContext, modelId, meshCode);
            if(meshInfo == null){
               throw new FFatalError("Model mesh is not found. (model={1}, mesh={2})", modelCode, meshCode);
            }
            meshId = meshInfo.ouid();
         }
         // 新建轨迹信息
         FGcResModelAnimationTrackInfo trackInfo = _animationTrackConsole.doPrepare(logicContext);
         trackInfo.setUserId(session.userId());
         trackInfo.setProjectId(session.projectId());
         trackInfo.setModelId(modelId);
         trackInfo.setMeshId(meshId);
         trackInfo.setSkeletonId(skeletonId);
         trackInfo.setAnimationId(animationId);
         _animationTrackConsole.doInsert(logicContext, trackInfo);
         // 更新轨迹数据
         _animationTrackConsole.updateResource(logicContext, trackInfo, track);
      }
      return EResult.Success;
   }
}
