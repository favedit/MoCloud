package org.mo.content.core.resource.template;

import org.mo.content.engine.core.template.FResTemplateConsole;

import org.mo.cloud.logic.resource.template.FGcResTemplateInfo;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容模板控制台。</T>
//============================================================
public class FCntTemplateConsole
      extends FResTemplateConsole
      implements
         ICntTemplateConsole
{
   //============================================================
   // <T>构造模板控制台。</T>
   //============================================================
   public FCntTemplateConsole(){
   }

   //============================================================
   // <T>根据资源编号删除模型信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param resourceId 资源编号
   // @return 处理结果
   //============================================================
   @Override
   public EResult doDeleteByResourceId(ILogicContext logicContext,
                                       long userId,
                                       long resourceId){
      // 获得模型
      FGcResTemplateInfo templateInfo = findByResourceId(logicContext, resourceId);
      if(templateInfo == null){
         throw new FFatalError("Template is not exists. (resource_id={1})", resourceId);
      }
      // 检查用户
      if(templateInfo.userId() != userId){
         throw new FFatalError("Template user is not same. (model_user_id={1}, session_user_id={2})", templateInfo.userId(), userId);
      }
      // 删除关联资源对象
      doDelete(logicContext, templateInfo);
      return EResult.Success;
   }
}
