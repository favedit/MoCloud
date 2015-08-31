package org.mo.eai.logic.web;

import org.mo.com.lang.EResult;
import org.mo.com.lang.RString;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.common.FWebAccessRule;
import org.mo.web.core.face.AWebAuthority;
import org.mo.web.core.face.AWebRole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>网站权限访问规则。</T>
//============================================================
public class FEaiAccessRule
      extends FWebAccessRule
{
   //============================================================
   // <T>检查会话是否有效。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param input 输入信息
   // @param output 输出信息
   // @return 处理结果
   //============================================================
   @Override
   public EResult checkSession(IWebContext context,
                               ILogicContext logicContext){
      FEaiSession session = (FEaiSession)context.session();
      if(session == null){
         return EResult.Failure;
      }
      // 绑定数据
      bindConsole().bind(FEaiSession.class, session);
      return EResult.Success;
   }

   //============================================================
   // <T>检查会话是否登录。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param input 输入信息
   // @param output 输出信息
   // @return 处理结果
   //============================================================
   @Override
   public EResult checkLogin(IWebContext context,
                             ILogicContext logicContext){
      FEaiSession session = (FEaiSession)context.session();
      // 会话不存在
      if(session == null){
         return EResult.Failure;
      }
      // 会话用户未登录
      long userId = session.userId();
      if(userId == 0){
         return EResult.Failure;
      }
      // 绑定会话数据
      bindConsole().bind(FEaiSession.class, session);
      return EResult.Success;
   }

   //============================================================
   // <T>检查角色是否有权限。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param authority 权限
   // @param output 输出信息
   // @return 处理结果
   //============================================================
   @Override
   public EResult checkAuthority(IWebContext context,
                                 ILogicContext logicContext,
                                 AWebRole role,
                                 AWebAuthority authority){
      FEaiSession session = (FEaiSession)context.session();
      // 会话不存在
      if(session == null){
         return EResult.Failure;
      }
      String storeRoleCode = session.roleCode();
      // 效验角色
      if(role != null){
         // 登录用户角色是否正确
         String roleCode = role.value();
         if(!roleCode.equals(storeRoleCode)){
            return EResult.Failure;
         }
      }
      // 效验模块
      boolean moduleFlag = false;
      if(authority != null){
         String[] modules = RString.split(authority.value(), '|');
         String[] storeRoleModules = session.roleModuleCodes();
         int modulesLength = modules.length;
         int storeRoleModulesLength = storeRoleModules.length;
         if(storeRoleModulesLength != 0){
            for(int i = 0; i < modulesLength; i++){
               String module = modules[i];
               for(int j = 0; j < storeRoleModulesLength; j++){
                  String storerolemodule = storeRoleModules[j];
                  if(module.equals(storerolemodule)){
                     moduleFlag = true;
                     break;
                  }
               }
               if(moduleFlag){
                  break;
               }
            }
         }
      }
      if(!moduleFlag){
         return EResult.Failure;
      }

      return EResult.Success;
   }
}
