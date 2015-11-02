package org.mo.content.service.financial.marketer.achievements.customer;

import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>短信推送服务。</T>
//============================================================
public class FCustomerService
      extends FObject
      implements
         ICustomerService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCustomerService.class);

   @Override
   public EResult process(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      // TODO Auto-generated method stub
      return null;
   }

   // ============================================================
   // <T>获取一个月内的客户数量</T>
   // @param context 页面环境
   // @sessionContext 会话session上下文
   // @param input 输入配置
   // @param output 输出配置
   // @logicContext 逻辑上下文
   // @return 处理结果
   // ============================================================
   @Override
   public EResult fetchCount(IWebContext context,
                             IWebSession sessionContext,
                             IWebInput input,
                             IWebOutput output,
                             ILogicContext logicContext){
      // TODO Auto-generated method stub
      return null;
   }

   // ============================================================
   // <T>获取所有客户的行为</T>
   // @param context 页面环境
   // @sessionContext 会话session上下文
   // @param input 输入配置
   // @param output 输出配置
   // @logicContext 逻辑上下文
   // @return 处理结果
   // ============================================================
   @Override
   public EResult fetchActions(IWebContext context,
                               IWebSession sessionContext,
                               IWebInput input,
                               IWebOutput output,
                               ILogicContext logicContext){
      // TODO Auto-generated method stub
      return null;
   }

}
