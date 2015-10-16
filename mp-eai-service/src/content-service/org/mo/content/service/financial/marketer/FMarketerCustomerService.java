package org.mo.content.service.financial.marketer;

import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.mobile.IVersionConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>版本更新服务。</T>
//============================================================
public class FMarketerCustomerService
      extends FObject
      implements
         IMarketerCustomerService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMarketerCustomerService.class);

   //版本更新逻辑控制台
   @ALink
   protected IVersionConsole _versionConsole;

   //WebSession会话控制台
   @ALink
   protected IWebSessionConsole _sessionConsole;

   //GcSession会话控制台
   @ALink
   protected IGcSessionConsole _gcSessionConsole;

   //============================================================
   // <T>默认逻辑。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult process(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      _logger.debug(this, "process", "process begin. ");
      return EResult.Success;
   }

   //============================================================
   // @连接服务器查看版本是否有更新
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public EResult getMarketer(IWebContext context,
                              IWebSession sessionContext,
                              IWebInput input,
                              IWebOutput output,
                              ILogicContext logicContext){

      return EResult.Success;
   }

   //============================================================
   // @断开与服务器的连接
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext 会话session上下文
   //============================================================
   @Override
   public EResult disconnect(IWebContext context,
                             IWebSession sessionContext,
                             IWebInput input,
                             IWebOutput output,
                             ILogicContext logicContext){
      //获取会话id
      FXmlNode inputNode = input.config();
      FXmlNode inputSessionCodeNode = inputNode.findNode("SessionCode");
      String sessionCodeNodeStr = inputSessionCodeNode.text();
      _versionConsole.disconnect(context, sessionCodeNodeStr, logicContext, sessionContext, _sessionConsole);
      return EResult.Success;
   }
}
