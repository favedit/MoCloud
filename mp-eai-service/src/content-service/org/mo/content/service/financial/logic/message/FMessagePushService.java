package org.mo.content.service.financial.logic.message;

import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.financial.logic.message.IMessagePushConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>短信推送服务。</T>
//============================================================
public class FMessagePushService
      extends FObject
      implements
         IMessagePushService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMessagePushService.class);

   // 短信推送控制台
   @ALink
   protected IMessagePushConsole _messagePushConsole;

   // 建周短信发送控制台

   // 会话
   @ALink
   protected IWebSessionConsole _sessionConsole;

   // GcSession会话控制台
   @ALink
   protected IGcSessionConsole _gcSessionConsole;

   // ============================================================
   // <T>默认逻辑。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public EResult process(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      _logger.debug(this, "process", "process begin. ");
      return EResult.Success;
   }

   // ============================================================
   // <T>理财师短信推送</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   // ============================================================
   @Override
   public EResult pushSMS(IWebContext context,
                          IWebSession sessionContext,
                          IWebInput input,
                          IWebOutput output,
                          ILogicContext logicContext){
      _logger.debug(this, "pushSMS ", "pushSMS begin. ");
      FXmlNode linkIdNode = input.config().findNode("linkid");
      FXmlNode loginDateNode = input.config().findNode("logindate");
      String linkIdStr = linkIdNode.text();
      String loginDateStr = loginDateNode.text();
      String linkId = "12";
      String dateTimeStr = new TDateTime(RDateTime.currentDateTime()).toString();
      if(RString.isEmpty(linkIdStr)){
         return EResult.Failure;
      }
      if(RString.isEmpty(loginDateStr)){
         return EResult.Failure;
      }
      _messagePushConsole.pushSMS(linkId, dateTimeStr, logicContext, context, sessionContext);
      return EResult.Success;
   }

}
