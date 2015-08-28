package org.mo.eai.logic.session;

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

   // 用户编号
   protected long _roleId;

   // 用户信息
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
      _roleModules = info.roleModules();
   }
}
