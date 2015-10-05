package org.ahyc.eai.demo.core.input;

import org.ahyc.eai.demo.core.socket.IWebSocketConsole;

import org.mo.com.console.FConsole;
import org.mo.core.aop.face.ALink;

//============================================================
// <T>输入控制台。</T>
//============================================================
public class FEaiInputConsole
      extends FConsole
      implements
         IEaiInputConsole
{
   @ALink
   protected IWebSocketConsole _socketConsole;

   @Override
   public void input(){
   }

   public void sendMessage(){
   }
}
