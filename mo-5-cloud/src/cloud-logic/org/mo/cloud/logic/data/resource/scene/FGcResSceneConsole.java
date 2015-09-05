package org.mo.cloud.logic.data.resource.scene;

import org.mo.cloud.logic.data.resource.FGcResourceInfo;
import org.mo.cloud.logic.data.resource.IGcResourceConsole;

import com.cyou.gccloud.data.data.FDataResourceSceneLogic;
import com.cyou.gccloud.data.data.FDataResourceTemplateLogic;
import com.cyou.gccloud.define.enums.core.EGcResource;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.data.RSql;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源场景控制台。</T>
//============================================================
public class FGcResSceneConsole
      extends FAbstractLogicUnitConsole<FDataResourceSceneLogic, FGcResSceneInfo>
      implements
         IGcResSceneConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 资源管理器
   @ALink
   protected IGcResourceConsole _dataResourceConsole;

   //============================================================
   // <T>构造3D资源数据流控制台。</T>
   //============================================================
   public FGcResSceneConsole(){
      super(FDataResourceSceneLogic.class, FGcResSceneInfo.class);
   }

   //============================================================
   // <T>根据资源编号查找场景信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceId 资源编号
   // @return 场景信息
   //============================================================
   @Override
   public FGcResSceneInfo findByResourceId(ILogicContext logicContext,
                                           long resourceId){
      String whereSql = FDataResourceTemplateLogic.RESOURCE_ID + "=" + resourceId;
      FGcResSceneInfo sceneInfo = search(logicContext, whereSql);
      return sceneInfo;
   }

   //============================================================
   // <T>根据资源唯一编号查找场景信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceGuid 资源唯一编号
   // @return 场景信息
   //============================================================
   @Override
   public FGcResSceneInfo findByResourceGuid(ILogicContext logicContext,
                                             String resourceGuid){
      FGcResSceneInfo sceneInfo = null;
      FGcResourceInfo resource = _dataResourceConsole.findByGuid(logicContext, resourceGuid);
      if(resource != null){
         long resourceId = resource.ouid();
         sceneInfo = findByResourceId(logicContext, resourceId);
      }
      return sceneInfo;
   }

   //============================================================
   // <T>根据用户编号和代码查找场景信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 场景代码
   // @return 场景信息
   //============================================================
   @Override
   public FGcResSceneInfo findByCode(ILogicContext logicContext,
                                     String code){
      String whereSql = FDataResourceSceneLogic.CODE + "='" + RSql.formatValue(code) + "'";
      FGcResSceneInfo sceneInfo = search(logicContext, whereSql);
      return sceneInfo;
   }

   //============================================================
   // <T>根据用户编号和代码查找场景信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param code 场景代码
   // @return 场景信息
   //============================================================
   @Override
   public FGcResSceneInfo findByUserCode(ILogicContext logicContext,
                                         long userId,
                                         String code){
      String whereSql = "(" + FDataResourceSceneLogic.USER_ID + "=" + userId + ")";
      whereSql += " AND (" + FDataResourceSceneLogic.CODE + "='" + RSql.formatValue(code) + "')";
      FGcResSceneInfo sceneInfo = search(logicContext, whereSql);
      return sceneInfo;
   }

   //============================================================
   // <T>根据用户编号和项目编号和代码查找场景信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param projectId 项目编号
   // @param code 场景代码
   // @return 场景信息
   //============================================================
   @Override
   public FGcResSceneInfo findByUserCode(ILogicContext logicContext,
                                         long userId,
                                         long projectId,
                                         String code){
      String whereSql = "(" + FDataResourceSceneLogic.USER_ID + "=" + userId + ")";
      whereSql += " AND (" + FDataResourceSceneLogic.PROJECT_ID + "=" + projectId + ")";
      whereSql += " AND (" + FDataResourceSceneLogic.CODE + "='" + RSql.formatValue(code) + "')";
      FGcResSceneInfo scene = search(logicContext, whereSql);
      return scene;
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
                                    FGcResSceneInfo sceneInfo){
      // 检查用户编号
      long userId = sceneInfo.userId();
      if(userId == 0){
         throw new FFatalError("User id is empty.");
      }
      // 创建资源对象
      FGcResourceInfo resource = _dataResourceConsole.doPrepare(logicContext);
      resource.setGuid(sceneInfo.guid());
      resource.setUserId(userId);
      resource.setProjectId(sceneInfo.projectId());
      resource.setCatalogId(sceneInfo.catalogId());
      resource.setResourceCd(EGcResource.Scene);
      resource.setCode(sceneInfo.code());
      resource.setLabel(sceneInfo.label());
      _dataResourceConsole.doInsert(logicContext, resource);
      // 设置资源信息
      sceneInfo.setResourceId(resource.ouid());
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
                                   FGcResSceneInfo sceneInfo){
      // 删除关联资源
      long resourceId = sceneInfo.resourceId();
      _dataResourceConsole.doDelete(logicContext, resourceId);
      // 返回结果
      return EResult.Success;
   }
}
