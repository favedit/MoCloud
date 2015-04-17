package org.mo.cloud.logic.resource.template;

import com.cyou.gccloud.data.data.FDataResourceTemplateMaterialLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.logic.resource.IGcResourceConsole;
import org.mo.cloud.logic.resource.material.IGcResMaterialConsole;
import org.mo.com.data.RSql;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模板材质控制台。</T>
//============================================================
public class FGcResTemplateMaterialConsole
      extends FAbstractLogicUnitConsole<FDataResourceTemplateMaterialLogic, FGcResTemplateMaterialInfo>
      implements
         IGcResTemplateMaterialConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 资源管理器
   @ALink
   protected IGcResourceConsole _dataResourceConsole;

   // 资源材质管理器
   @ALink
   protected IGcResMaterialConsole _dataMaterialConsole;

   //============================================================
   // <T>构造资源模板材质控制台。</T>
   //============================================================
   public FGcResTemplateMaterialConsole(){
      super(FDataResourceTemplateMaterialLogic.class, FGcResTemplateMaterialInfo.class);
   }

   //============================================================
   // <T>根据用户编号和模板编号和代码查找模板信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param templateId 模板编号
   // @param code 代码
   // @return 模板信息
   //============================================================
   @Override
   public FGcResTemplateMaterialInfo findByCode(ILogicContext logicContext,
                                                long userId,
                                                long templateId,
                                                String code){
      String whereSql = "(" + FDataResourceTemplateMaterialLogic.USER_ID + "=" + userId + ")";
      whereSql += " AND (" + FDataResourceTemplateMaterialLogic.TEMPLATE_ID + "=" + templateId + ")";
      whereSql += " AND (" + FDataResourceTemplateMaterialLogic.CODE + "='" + RSql.formatValue(code) + "')";
      FGcResTemplateMaterialInfo templateMaterialInfo = search(logicContext, whereSql);
      return templateMaterialInfo;
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
                                   FGcResTemplateMaterialInfo templateMaterialInfo){
      // 删除关联材质
      long materialId = templateMaterialInfo.materialId();
      _dataMaterialConsole.doDelete(logicContext, materialId);
      // 返回结果
      return EResult.Success;
   }
}
