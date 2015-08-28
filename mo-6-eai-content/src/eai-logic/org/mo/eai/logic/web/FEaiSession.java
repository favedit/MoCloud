package org.mo.eai.logic.web;

import org.mo.cloud.core.web.FGcWebSession;
import org.mo.cloud.logic.system.FGcSessionInfo;

//============================================================
// <T>会话信息。</T>
//============================================================
public class FEaiSession
      extends FGcWebSession
{
   // 序列化编号
   private static final long serialVersionUID = 1L;

   // 角色编号
   protected long _roleId;

   // 角色代码
   protected String _roleCode;

   // 角色模块集合
   protected String _roleModules;

   //============================================================
   // <T>获得角色编号。</T>
   //
   // @return 角色编号
   //============================================================
   public long roleId(){
      return _roleId;
   }

   //============================================================
   // <T>获得角色代码。</T>
   //
   // @return 角色代码
   //============================================================
   public String roleCode(){
      return _roleCode;
   }

   //============================================================
   // <T>获得角色模块集合。</T>
   //
   // @return 角色模块集合
   //============================================================
   public String roleModules(){
      return _roleModules;
   }

   //============================================================
   // <T>加载数据单元信息。</T>
   //
   // @param unit 数据单元
   //============================================================
   @Override
   public void loadInfo(FGcSessionInfo info){
      super.loadInfo(info);
      // 加载信息
      _roleId = info.roleId();
      _roleCode = info.roleCode();
      _roleModules = info.roleModules();
   }
}
