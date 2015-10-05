package org.ahyc.eai.demo.face;

import org.ahyc.eai.demo.core.socket.FWebSocketSession;
import org.ahyc.eai.demo.core.socket.IWebSocketConsole;
import org.mo.com.lang.RString;
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
   protected IWebSocketConsole _socketConsole;

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
      String selectTag = RString.nvl(context.parameter("tag"));
      String rotate = RString.nvl(context.parameter("rotate"));
      String message = "";
      if(RString.isNotEmpty(selectTag)){
         message += "tag=" + selectTag;
      }
      if(RString.isNotEmpty(rotate)){
         message += "rotate=" + rotate;
      }
      FWebSocketSession[] sessions = _socketConsole.fetch();
      System.out.println("Session count = " + sessions.length);
      for(FWebSocketSession session : sessions){
         session.sendMessage(message);
      }
      // 非法设置
      return "Test";
   }
}
