package org.mo.content.engine.core.model;

import org.mo.cloud.core.storage.mongo.EGcStorageMongoCatalog;
import org.mo.cloud.core.storage.mongo.SGcMongoStorage;

import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.resource.model.skeleton.FGcResModelSkeletonInfo;
import org.mo.cloud.logic.data.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.data.resource.model.mesh.FGcResModelMeshStreamInfo;
import org.mo.cloud.logic.data.resource.model.animation.FGcResModelAnimationInfo;
import org.mo.cloud.logic.data.resource.model.animation.FGcResModelAnimationTrackInfo;
import org.mo.cloud.logic.data.resource.model.FGcResModelConsole;
import org.mo.cloud.logic.data.resource.model.FGcResModelInfo;
import com.cyou.gccloud.data.data.FDataResourceModelAnimationLogic;
import com.cyou.gccloud.data.data.FDataResourceModelSkeletonLogic;
import com.cyou.gccloud.data.data.FDataResourceModelUnit;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.content.engine.core.model.animation.IResModelAnimationConsole;
import org.mo.content.engine.core.model.animation.IResModelAnimationTrackConsole;
import org.mo.content.engine.core.model.skeleton.IResModelSkeletonConsole;
import org.mo.content.engine.core.model.skeleton.IResModelSkeletonSkinStreamConsole;
import org.mo.content.geom.mesh.FGeomMesh;
import org.mo.content.geom.mesh.FGeomModel;
import org.mo.content.mime.obj.FObjFile;
import org.mo.content.mime.phy.FPlyFile;
import org.mo.content.mime.stl.FStlFile;
import org.mo.content.resource.common.FResAnimation;
import org.mo.content.resource.common.FResSkeleton;
import org.mo.content.resource.common.FResSkeletonSkin;
import org.mo.content.resource.common.FResStream;
import org.mo.content.resource.common.FResTrack;
import org.mo.content.resource.model.FResModel;
import org.mo.content.resource.model.FResModelMesh;
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
   public FResModel makeModel(ILogicContext logicContext,
                              FGcResModelInfo modelInfo){
      // 获得模型信息
      if(modelInfo == null){
         throw new FFatalError("Model is empty.");
      }
      long modelId = modelInfo.ouid();
      //............................................................
      // 生成数据
      FResModel model = new FResModel();
      model.loadUnit(modelInfo);
      // 获得网格信息
      FLogicDataset<FGcResModelMeshInfo> meshInfos = _meshConsole.fetchByModelId(logicContext, modelId);
      for(FGcResModelMeshInfo meshInfo : meshInfos){
         long meshId = meshInfo.ouid();
         // 创建资源网格
         FResModelMesh mesh = new FResModelMesh();
         mesh.loadUnit(meshInfo);
         // 获得数据流信息
         FLogicDataset<FGcResModelMeshStreamInfo> streamInfos = _meshStreamConsole.fetchByMeshId(logicContext, meshId);
         for(FGcResModelMeshStreamInfo streamInfo : streamInfos){
            // 建立数据流
            FResStream stream = _meshStreamConsole.makeStream(logicContext, streamInfo);
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
         FResSkeleton skeleton = _skeletonConsole.makeSkeleton(logicContext, modelId, skeletonId);
         model.pushSkeleton(skeleton);
      }
      //............................................................
      // 获得动画集合
      FLogicDataset<FGcResModelAnimationInfo> animationInfos = _animationConsole.fetch(logicContext, FDataResourceModelAnimationLogic.MODEL_ID + "=" + modelId);
      for(FGcResModelAnimationInfo animationInfo : animationInfos){
         long animationId = animationInfo.ouid();
         // 获得动画
         FResAnimation animation = _animationConsole.makeAnimation(logicContext, animationId);
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
      SGcMongoStorage findStorage = _storageConsole.find(EGcStorageMongoCatalog.CacheResourceModel, guid);
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
      FResModel model = makeModel(logicContext, modelInfo);
      // 获得数据
      FByteStream stream = new FByteStream();
      model.serialize(stream);
      // 压缩数据
      byte[] data = null;
      try(FCompressStream compressStream = new FCompressStream(stream.memory(), 0, stream.length())){
         data = compressStream.toCompressArray(ECompressMode.Lzma, RInteger.SIZE_2M);
      }
      //............................................................
      // 存储数据
      SGcMongoStorage storage = new SGcMongoStorage(EGcStorageMongoCatalog.CacheResourceModel, guid);
      storage.setCode(model.code());
      storage.setData(data);
      _storageConsole.store(storage);
      // 返回数据
      return data;
   }

   //============================================================
   // <T>新建模型信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param model 模型数据
   // @return 模型信息
   //============================================================
   @Override
   public FGcResModelInfo insertResource(ILogicContext logicContext,
                                         FGcSessionInfo session,
                                         FResModel model){
      // 获得参数
      long userId = session.userId();
      long projectId = session.projectId();
      //............................................................
      // 新建模型
      FGcResModelInfo modelInfo = doPrepare(logicContext);
      modelInfo.setUserId(userId);
      modelInfo.setProjectId(projectId);
      model.saveUnit(modelInfo);
      doInsert(logicContext, modelInfo);
      //............................................................
      // 更新所有网格信息
      int meshCount = model.meshs().count();
      for(int n = 0; n < meshCount; n++){
         FResModelMesh mesh = model.meshs().get(n);
         _meshConsole.importResource(logicContext, session, modelInfo, mesh);
      }
      return modelInfo;
   }

   //============================================================
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param model 模型
   // @return 模型信息
   //============================================================
   @Override
   public EResult updateResource(ILogicContext logicContext,
                                 FGcSessionInfo session,
                                 FGcResModelInfo modelInfo,
                                 FResModel model){
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
      // 删除未使用的网格信息
      FLogicDataset<FGcResModelMeshInfo> meshInfos = _meshConsole.fetchByModelId(logicContext, modelId);
      if(meshInfos != null){
         for(FGcResModelMeshInfo meshInfo : meshInfos){
            String meshCode = meshInfo.code();
            FResModelMesh mesh = model.findMeshByCode(meshCode);
            if(mesh == null){
               _meshConsole.doDelete(logicContext, meshInfo);
            }
         }
      }
      //............................................................
      // 更新所有网格信息
      int meshCount = model.meshs().count();
      for(int n = 0; n < meshCount; n++){
         FResModelMesh mesh = model.meshs().get(n);
         _meshConsole.importResource(logicContext, session, modelInfo, mesh);
      }
      // 更新网格
      model.saveUnit(modelInfo);
      doUpdate(logicContext, modelInfo);
      //............................................................
      // 废弃临时数据
      _storageConsole.delete(EGcStorageMongoCatalog.CacheResourceModel, modelGuid);
      //............................................................
      return EResult.Success;
   }

   //============================================================
   // <T>更新PLY资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param file 文件
   // @return 处理结果
   //============================================================
   @Override
   public EResult updateResourcePly(ILogicContext logicContext,
                                    FGcSessionInfo session,
                                    FGcResModelInfo modelInfo,
                                    FPlyFile file){
      // 加载网格
      FResModelMesh mesh = new FResModelMesh();
      file.buildMesh(mesh);
      // 创建模型
      FResModel model = new FResModel();
      model.pushMesh(mesh);
      //............................................................
      // 新建模型
      return updateResource(logicContext, session, modelInfo, model);
   }

   //============================================================
   // <T>更新OBJ资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param file 文件
   // @return 处理结果
   //============================================================
   @Override
   public EResult updateResourceObj(ILogicContext logicContext,
                                    FGcSessionInfo session,
                                    FGcResModelInfo modelInfo,
                                    FObjFile file){
      // 加载模型资源
      FResModel model = new FResModel();
      FGeomModel geomModel = file.CreateGeomModel();
      for(FGeomMesh geomMesh : geomModel.meshs()){
         FResModelMesh mesh = new FResModelMesh();
         mesh.loadGeometry(geomMesh);
         model.pushMesh(mesh);
      }
      //............................................................
      // 新建模型
      updateResource(logicContext, session, modelInfo, model);
      return EResult.Success;
   }

   //============================================================
   // <T>更新STL资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param modelInfo 模型信息
   // @param file 文件
   // @return 处理结果
   //============================================================
   @Override
   public EResult updateResourceStl(ILogicContext logicContext,
                                    FGcSessionInfo session,
                                    FGcResModelInfo modelInfo,
                                    FStlFile file){
      // 加载模型资源
      FResModel model = new FResModel();
      FGeomModel geomModel = file.CreateGeomModel();
      for(FGeomMesh geomMesh : geomModel.meshs()){
         FResModelMesh mesh = new FResModelMesh();
         mesh.loadGeometry(geomMesh);
         model.pushMesh(mesh);
      }
      //............................................................
      // 新建模型
      updateResource(logicContext, session, modelInfo, model);
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
      // 加载模型资源
      FResModel model = new FResModel();
      model.loadFile(fileName);
      //............................................................
      // 获得参数
      long userId = session.userId();
      String code = model.code();
      //............................................................
      // 导入模型信息
      FGcResModelInfo modelInfo = findByUserCode(logicContext, userId, code);
      if(modelInfo == null){
         modelInfo = insertResource(logicContext, session, model);
      }else{
         updateResource(logicContext, session, modelInfo, model);
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
      FResSkeleton skeleton = new FResSkeleton();
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
      for(FResSkeletonSkin skin : skeleton.skins()){
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
      FResAnimation animation = new FResAnimation();
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
      for(FResTrack track : animation.tracks()){
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
