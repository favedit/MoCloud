package org.ahyc.eai.demo.face;

import java.io.IOException;
import javax.websocket.Session;
import org.ahyc.eai.demo.core.earth.IWebSocketConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>首页。</P>
//
// @author maocy
// @version 150427
//============================================================
public class FTestAction
      implements
         ITestAction
{
   // 日志输出接口
   //private static ILogger _logger = RLogger.find(FTestAction.class);

   @ALink
   protected IWebSocketConsole _demoConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FTestPage page){
      Session[] sessions = _demoConsole.fetch();
      System.out.println("Session count = " + sessions.length);
      for(Session session : sessions){
         try{
            session.getBasicRemote().sendText("Hello World.");
         }catch(IOException e){
            e.printStackTrace();
         }
      }
      // 非法设置
      return "Test";
   }
}
