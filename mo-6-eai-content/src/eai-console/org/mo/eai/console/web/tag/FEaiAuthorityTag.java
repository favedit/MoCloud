package org.mo.eai.console.web.tag;

import org.mo.eai.console.web.FEaiSession;

import org.mo.com.lang.RString;
import org.mo.web.tag.common.FAbstractTag;

//============================================================
// <T>权限标签。</T>
//============================================================
public class FEaiAuthorityTag
      extends FAbstractTag
{
   // 角色
   String _role;

   // 模块
   String _module;

   //============================================================
   // <T>设置角色。</T>
   //
   // @param role 角色
   //============================================================
   public void setRole(String role){
      _role = role;
   }

   //============================================================
   // <T>设置模块。</T>
   //
   // @param module 模块
   //============================================================
   public void setModule(String module){
      _module = module;
   }

   //============================================================
   // <T>标签开始处理。</T>
   //============================================================
   @Override
   public int onStart(){
      // 检查会话
      FEaiSession session = (FEaiSession)_context.session();
      if(session == null){
         return SKIP_BODY;
      }
      // 检查角色代码
      if(!RString.isEmpty(_role)){
         if(!_role.equals(session.roleCode())){
            return SKIP_BODY;
         }
      }
      // 检查角色代码
      if(!RString.isEmpty(_module)){
         boolean roleExists = false;
         String roleModules = "|" + session.roleModules() + "|";
         String[] moduleCodes = RString.split(_module, '|');
         for(String moduleCode : moduleCodes){
            if(!RString.isEmpty(moduleCode)){
               if(roleModules.contains("|" + moduleCode + "|")){
                  roleExists = true;
                  break;
               }
            }
         }
         if(!roleExists){
            return SKIP_BODY;
         }
      }
      // 返回成功
      return EVAL_BODY_INCLUDE;
   }

   //============================================================
   // <T>标签结束处理。</T>
   //============================================================
   @Override
   public int onEnd(){
      return EVAL_PAGE;
   }

}
