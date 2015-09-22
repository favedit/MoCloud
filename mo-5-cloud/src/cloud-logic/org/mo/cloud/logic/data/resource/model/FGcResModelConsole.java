package org.mo.cloud.logic.data.resource.model;

import com.cyou.gccloud.data.data.FDataResourceModelAnimationLogic;
import com.cyou.gccloud.data.data.FDataResourceModelLogic;
import com.cyou.gccloud.data.data.FDataResourceModelMeshLogic;
import com.cyou.gccloud.data.data.FDataResourceModelSkeletonLogic;
import com.cyou.gccloud.define.enums.core.EGcResource;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.logic.data.resource.FGcResourceInfo;
import org.mo.cloud.logic.data.resource.IGcResourceConsole;
import org.mo.cloud.logic.data.resource.model.animation.FGcResModelAnimationInfo;
import org.mo.cloud.logic.data.resource.model.animation.IGcResModelAnimationConsole;
import org.mo.cloud.logic.data.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.data.resource.model.mesh.IGcResModelMeshConsole;
import org.mo.cloud.logic.data.resource.model.skeleton.FGcResModelSkeletonInfo;
import org.mo.cloud.logic.data.resource.model.skeleton.IGcResModelSkeletonConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源位图信息控制台。</T>
//============================================================
public class FGcResModelConsole
      extends FAbstractLogicUnitConsole<FDataResourceModelLogic, FGcResModelInfo>
      implements
         IGcResModelConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 资源管理器
   @ALink
   protected IGcResourceConsole _dataResourceConsole;

   // 资源模型网格控制台
   @ALink
   protected IGcResModelMeshConsole _dataModelMeshConsole;

   // 资源模型骨骼控制台
   @ALink
   protected IGcResModelSkeletonConsole _dataModelSkeletonConsole;

   // 资源模型动画控制台
   @ALink
   protected IGcResModelAnimationConsole _dataModelAnimationConsole;

   //============================================================
   // <T>构造资源位图信息控制台。</T>
   //============================================================
   public FGcResModelConsole(){
      super(FDataResourceModelLogic.class, FGcResModelInfo.class);
   }

   //============================================================
   // <T>根据资源编号查找位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceId 资源编号
   // @return 位图信息
   //============================================================
   @Override
   public FGcResModelInfo findByResourceId(ILogicContext logicContext,
                                           long resourceId){
      String whereSql = FDataResourceModelLogic.RESOURCE_ID + "=" + resourceId;
      FGcResModelInfo model = search(logicContext, whereSql);
      return model;
   }

   //============================================================
   // <T>根据资源唯一编号查找位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceGuid 资源唯一编号
   // @return 位图信息
   //============================================================
   @Override
   public FGcResModelInfo findByResourceGuid(ILogicContext logicContext,
                                             String resourceGuid){
      FGcResModelInfo model = null;
      FGcResourceInfo resource = _dataResourceConsole.findByGuid(logicContext, resourceGuid);
      if(resource != null){
         long resourceId = resource.ouid();
         model = findByResourceId(logicContext, resourceId);
      }
      return model;
   }

   //============================================================
   // <T>根据代码查找模型单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   @Override
   public FGcResModelInfo findByCode(ILogicContext logicContext,
                                     String code){
      String searchSql = FDataResourceModelLogic.CODE + "='" + code + "'";
      FGcResModelInfo modelInfo = search(logicContext, searchSql);
      return modelInfo;
   }

   //============================================================
   // <T>根据用户和代码查找模型单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param code 代码
   // @return 处理结果
   //============================================================
   @Override
   public FGcResModelInfo findByUserCode(ILogicContext logicContext,
                                         long userId,
                                         String code){
      String searchSql = "(" + FDataResourceModelLogic.USER_ID + "=" + userId + ") AND (" + FDataResourceModelLogic.CODE + "='" + code + "')";
      FGcResModelInfo modelInfo = search(logicContext, searchSql);
      return modelInfo;
   }

   //============================================================
   // <T>新建记录前处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @param oldUnit 原始数据单元
   // @return 处理结果
   //============================================================
   @Override
   protected EResult onInsertBefore(ILogicContext logicContext,
                                    FGcResModelInfo modelInfo){
      // 检查用户编号
      long userId = modelInfo.userId();
      if(userId == 0){
         throw new FFatalError("User id is empty.");
      }
      // 创建资源对象
      FGcResourceInfo resource = _dataResourceConsole.doPrepare(logicContext);
      resource.setGuid(modelInfo.guid());
      resource.setUserId(userId);
      resource.setProjectId(modelInfo.projectId());
      resource.setCatalogId(modelInfo.catalogId());
      resource.setResourceCd(EGcResource.Model);
      resource.setCode(modelInfo.code());
      resource.setLabel(modelInfo.label());
      _dataResourceConsole.doInsert(logicContext, resource);
      // 设置资源信息
      modelInfo.setResourceId(resource.ouid());
      return EResult.Success;
   }

   //============================================================
   // <T>删除记录前处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   protected EResult onDeleteBefore(ILogicContext logicContext,
                                    FGcResModelInfo modelInfo){
      long modelId = modelInfo.ouid();
      long resourceId = modelInfo.resourceId();
      // 删除缓冲数据
      FGcResourceInfo resourceInfo = _dataResourceConsole.get(logicContext, resourceId);
      String resourceGuid = resourceInfo.guid();
      _storageConsole.delete(EGcStorageCatalog.CacheResourceModel, resourceGuid);
      // 删除动画集合
      String animationWhereSql = FDataResourceModelAnimationLogic.MODEL_ID + "=" + modelId;
      FLogicDataset<FGcResModelAnimationInfo> animationDataset = _dataModelAnimationConsole.fetch(logicContext, animationWhereSql);
      if(animationDataset != null){
         for(FGcResModelAnimationInfo animation : animationDataset){
            _dataModelAnimationConsole.doDelete(logicContext, animation);
         }
      }
      // 删除骨骼集合
      String skeletonWhereSql = FDataResourceModelSkeletonLogic.MODEL_ID + "=" + modelId;
      FLogicDataset<FGcResModelSkeletonInfo> skeletonDataset = _dataModelSkeletonConsole.fetch(logicContext, skeletonWhereSql);
      if(skeletonDataset != null){
         for(FGcResModelSkeletonInfo skeletonInfo : skeletonDataset){
            _dataModelSkeletonConsole.doDelete(logicContext, skeletonInfo);
         }
      }
      // 删除网格集合
      String meshWhereSql = FDataResourceModelMeshLogic.MODEL_ID + "=" + modelId;
      FLogicDataset<FGcResModelMeshInfo> modelMeshDataset = _dataModelMeshConsole.fetch(logicContext, meshWhereSql);
      if(modelMeshDataset != null){
         for(FGcResModelMeshInfo mesh : modelMeshDataset){
            _dataModelMeshConsole.doDelete(logicContext, mesh);
         }
      }
      // 返回结果
      return EResult.Success;
   }

   //============================================================
   // <T>删除记录后处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   protected EResult onDeleteAfter(ILogicContext logicContext,
                                   FGcResModelInfo unit){
      // 删除关联资源
      long resourceId = unit.resourceId();
      _dataResourceConsole.doDelete(logicContext, resourceId);
      // 返回结果
      return EResult.Success;
   }
}
