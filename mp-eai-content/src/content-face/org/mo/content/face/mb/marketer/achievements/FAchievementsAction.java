package org.mo.content.face.mb.marketer.achievements;

import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>理财师业绩信息。</P>
//
// @author sunhr
// @version 151102
//============================================================
public class FAchievementsAction
      implements
         IAchievementsAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FAchievementsAction.class);

   //session控制台
   @ALink
   protected IWebSessionConsole _sessionConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param page 页面容器
   //============================================================
   @Override
   public String construct(IWebContext context,
                           IWebSession sessionContext,
                           ILogicContext logicContext,
                           FBasePage basePage,
                           FAchievementsPage page){
      _logger.debug(this, "construct", "construct begin. (session = {1})", sessionContext.id());
      basePage.setUrl("/mb/marketer/achievements/index.html");
      return "/apl/Redirector";
   }

}
