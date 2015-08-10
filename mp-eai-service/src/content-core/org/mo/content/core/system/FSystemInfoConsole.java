package org.mo.content.core.system;

import org.mo.cloud.logic.system.IGcSessionConsole;
import org.mo.core.aop.face.ALink;

//============================================================
// <T>人员账号控制台。</T>
//============================================================
public class FSystemInfoConsole
      implements
         ISystemInfoConsole
{
   // 会话控制台
   @ALink
   protected IGcSessionConsole _sessionConsole;

   //============================================================
   // <T>获得令牌。</T>
   //
   // @return 令牌
   //============================================================
   @Override
   public int token(){
      return 1;
   }
}
