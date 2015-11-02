package org.mo.content.service.financial.marketer.achievements;

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
public class FAchievementsService
      extends FObject
      implements
         IAchievementsService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FAchievementsService.class);

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
      return null;
   }

   // ============================================================
   // <T>获取一个月的业绩</T>
   // @param context 页面环境
   // @sessionContext 会话session上下文
   // @param input 输入配置
   // @param output 输出配置
   // @logicContext 逻辑上下文
   // @return 处理结果
   // ============================================================
   @Override
   public EResult month(IWebContext context,
                        IWebSession sessionContext,
                        IWebInput input,
                        IWebOutput output,
                        ILogicContext logicContext){
      return null;
   }

   // ============================================================
   // <T>获取每一个产品的业绩</T>
   // @param context 页面环境
   // @sessionContext 会话session上下文
   // @param input 输入配置
   // @param output 输出配置
   // @logicContext 逻辑上下文
   // @return 处理结果
   // ============================================================
   @Override
   public EResult fetchProducts(IWebContext context,
                                IWebSession sessionContext,
                                IWebInput input,
                                IWebOutput output,
                                ILogicContext logicContext){
      return null;
   }

}
