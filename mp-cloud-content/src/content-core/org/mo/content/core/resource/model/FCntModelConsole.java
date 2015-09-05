package org.mo.content.core.resource.model;

import org.mo.cloud.logic.data.resource.model.FGcResModelInfo;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.content.engine.core.model.FResModelConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容模型控制台。</T>
//============================================================
public class FCntModelConsole
      extends FResModelConsole
      implements
         ICntModelConsole
{
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
      FGcResModelInfo model = findByResourceId(logicContext, resourceId);
      if(model == null){
         throw new FFatalError("Model is not exists. (resource_id={1})", resourceId);
      }
      // 检查用户
      if(model.userId() != userId){
         throw new FFatalError("Model user is not same. (model_user_id={1}, session_user_id={2})", model.userId(), userId);
      }
      // 删除关联资源对象
      doDelete(logicContext, model);
      return EResult.Success;
   }
}
