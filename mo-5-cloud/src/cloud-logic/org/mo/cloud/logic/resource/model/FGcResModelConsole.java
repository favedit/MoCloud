package org.mo.cloud.logic.resource.model;

import com.cyou.gccloud.data.data.FDataResourceModelLogic;
import com.cyou.gccloud.data.data.FDataResourceModelMeshLogic;
import com.cyou.gccloud.define.enums.core.EGcResource;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.logic.resource.FGcResourceInfo;
import org.mo.cloud.logic.resource.IGcResourceConsole;
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
   // 资源管理器
   @ALink
   protected IGcResourceConsole _resourceConsole;

   // 资源模型网格管理器
   @ALink
   protected IGcResModelMeshConsole _modelMeshConsole;

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
      FGcResourceInfo resource = _resourceConsole.findByGuid(logicContext, resourceGuid);
      if(resource != null){
         long resourceId = resource.ouid();
         model = findByResourceId(logicContext, resourceId);
      }
      return model;
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
                                    FGcResModelInfo model){
      // 检查用户编号
      long userId = model.userId();
      if(userId == 0){
         throw new FFatalError("User id is empty.");
      }
      // 创建资源对象
      FGcResourceInfo resource = _resourceConsole.doPrepare(logicContext);
      resource.setUserId(userId);
      resource.setProjectId(model.projectId());
      resource.setCatalogId(model.catalogId());
      resource.setResourceCd(EGcResource.Model);
      resource.setCode(model.code());
      resource.setLabel(model.label());
      _resourceConsole.doInsert(logicContext, resource);
      // 设置资源信息
      model.setResourceId(resource.ouid());
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
                                    FGcResModelInfo unit){
      long modelId = unit.ouid();
      // 删除网格集合
      FDataResourceModelMeshLogic modelMeshLogic = logicContext.findLogic(FDataResourceModelMeshLogic.class);
      String whereSql = FDataResourceModelMeshLogic.MODEL_ID + "=" + modelId;
      FLogicDataset<FGcResModelMeshInfo> modelMeshDataset = modelMeshLogic.fetchClass(FGcResModelMeshInfo.class, whereSql);
      if(modelMeshDataset != null){
         for(FGcResModelMeshInfo modelMesh : modelMeshDataset){
            _modelMeshConsole.doDelete(logicContext, modelMesh);
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
      if(resourceId > 0){
         _resourceConsole.doDelete(logicContext, resourceId);
      }
      // 返回结果
      return EResult.Success;
   }
}
