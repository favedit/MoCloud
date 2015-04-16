package org.mo.cloud.logic.resource.template;

import com.cyou.gccloud.data.data.FDataResourceTemplateLogic;
import com.cyou.gccloud.data.data.FDataResourceTemplateMaterialLogic;
import com.cyou.gccloud.define.enums.core.EGcResource;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.logic.resource.FGcResourceInfo;
import org.mo.cloud.logic.resource.IGcResourceConsole;
import org.mo.com.data.RSql;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模板控制台。</T>
//============================================================
public class FGcResTemplateConsole
      extends FAbstractLogicUnitConsole<FDataResourceTemplateLogic, FGcResTemplateInfo>
      implements
         IGcResTemplateConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 资源管理器
   @ALink
   protected IGcResourceConsole _dataResourceConsole;

   // 资源模板材质管理器
   @ALink
   protected IGcResTemplateMaterialConsole _dataTemplateMaterialConsole;

   //============================================================
   // <T>构造3D资源数据流控制台。</T>
   //============================================================
   public FGcResTemplateConsole(){
      super(FDataResourceTemplateLogic.class, FGcResTemplateInfo.class);
   }

   //============================================================
   // <T>根据资源编号查找模板信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceId 资源编号
   // @return 模板信息
   //============================================================
   @Override
   public FGcResTemplateInfo findByResourceId(ILogicContext logicContext,
                                              long resourceId){
      String whereSql = FDataResourceTemplateLogic.RESOURCE_ID + "=" + resourceId;
      FGcResTemplateInfo templateInfo = search(logicContext, whereSql);
      return templateInfo;
   }

   //============================================================
   // <T>根据资源唯一编号查找模板信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceGuid 资源唯一编号
   // @return 模板信息
   //============================================================
   @Override
   public FGcResTemplateInfo findByResourceGuid(ILogicContext logicContext,
                                                String resourceGuid){
      FGcResTemplateInfo templateInfo = null;
      FGcResourceInfo resource = _dataResourceConsole.findByGuid(logicContext, resourceGuid);
      if(resource != null){
         long resourceId = resource.ouid();
         templateInfo = findByResourceId(logicContext, resourceId);
      }
      return templateInfo;
   }

   //============================================================
   // <T>根据用户编号和项目编号和代码查找模板信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param code 代码
   // @return 模板信息
   //============================================================
   @Override
   public FGcResTemplateInfo findByCode(ILogicContext logicContext,
                                        long userId,
                                        String code){
      String whereSql = "(" + FDataResourceTemplateLogic.USER_ID + "=" + userId + ")";
      whereSql += " AND (" + FDataResourceTemplateLogic.CODE + "='" + RSql.formatValue(code) + "')";
      FGcResTemplateInfo template = search(logicContext, whereSql);
      return template;
   }

   //============================================================
   // <T>根据用户编号和项目编号和代码查找模板信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param projectId 项目编号
   // @param code 代码
   // @return 模板信息
   //============================================================
   @Override
   public FGcResTemplateInfo findByCode(ILogicContext logicContext,
                                        long userId,
                                        long projectId,
                                        String code){
      String whereSql = "(" + FDataResourceTemplateLogic.USER_ID + "=" + userId + ")";
      whereSql += " AND (" + FDataResourceTemplateLogic.PROJECT_ID + "=" + projectId + ")";
      whereSql += " AND (" + FDataResourceTemplateLogic.CODE + "='" + RSql.formatValue(code) + "')";
      FGcResTemplateInfo template = search(logicContext, whereSql);
      return template;
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
                                    FGcResTemplateInfo templateInfo){
      // 检查用户编号
      long userId = templateInfo.userId();
      if(userId == 0){
         throw new FFatalError("User id is empty.");
      }
      // 创建资源对象
      FGcResourceInfo resource = _dataResourceConsole.doPrepare(logicContext);
      resource.setUserId(userId);
      resource.setProjectId(templateInfo.projectId());
      resource.setCatalogId(templateInfo.catalogId());
      resource.setResourceCd(EGcResource.Template);
      resource.setCode(templateInfo.code());
      resource.setLabel(templateInfo.label());
      _dataResourceConsole.doInsert(logicContext, resource);
      // 设置资源信息
      templateInfo.setGuid(resource.guid());
      templateInfo.setResourceId(resource.ouid());
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
   public EResult onDeleteBefore(ILogicContext logicContext,
                                 FGcResTemplateInfo templateInfo){
      long templateId = templateInfo.ouid();
      // 删除模板材质集合
      String whereSql = FDataResourceTemplateMaterialLogic.TEMPLATE_ID + "=" + templateId;
      FLogicDataset<FGcResTemplateMaterialInfo> templateMaterialDataset = _dataTemplateMaterialConsole.fetch(logicContext, whereSql);
      if(templateMaterialDataset != null){
         for(FGcResTemplateMaterialInfo templateMaterialInfo : templateMaterialDataset){
            _dataTemplateMaterialConsole.doDelete(logicContext, templateMaterialInfo);
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
                                   FGcResTemplateInfo templateInfo){
      // 删除关联资源
      long resourceId = templateInfo.resourceId();
      _dataResourceConsole.doDelete(logicContext, resourceId);
      // 返回结果
      return EResult.Success;
   }
}
