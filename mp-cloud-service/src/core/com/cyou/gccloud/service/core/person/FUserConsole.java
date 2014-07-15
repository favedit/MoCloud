package com.cyou.gccloud.service.core.person;

import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;
import org.mo.eng.template.ITemplateConsole;

//============================================================
// <T>游戏实例控制台。</T>
//============================================================
public class FUserConsole
      implements
         IUserConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FUserConsole.class);

   @ALink
   private ITemplateConsole _templateConsole;

   //============================================================
   // <T>游戏实例控制台。</T>
   //============================================================
   public FUserConsole(){
   }

   @Override
   public void register(){
      _logger.debug(this, "register", "register");
      // TODO Auto-generated method stub

   }

   @Override
   public void login(){
      // TODO Auto-generated method stub

   }

   @Override
   public void logout(){
      // TODO Auto-generated method stub

   }
}
