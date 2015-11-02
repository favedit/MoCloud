package org.mo.content.service.financial.marketer.achievements.customer;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>版本更新服务</T>
//============================================================
public interface ICustomerService
{
   // ============================================================
   // <T>默认逻辑。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   EResult process(IWebContext context,
                   IWebInput input,
                   IWebOutput output);

   // ============================================================
   // <T>获取一个月客户数量</T>
   // @param context 页面环境
   // @sessionContext 会话session上下文
   // @param input 输入配置
   // @param output 输出配置
   // @logicContext 逻辑上下文
   // @return 处理结果
   // ============================================================
   public EResult fetchCount(IWebContext context,
                             IWebSession sessionContext,
                             IWebInput input,
                             IWebOutput output,
                             ILogicContext logicContext);

   // ============================================================
   // <T>获取所有客户的行为</T>
   // @param context 页面环境
   // @sessionContext 会话session上下文
   // @param input 输入配置
   // @param output 输出配置
   // @logicContext 逻辑上下文
   // @return 处理结果
   // ============================================================
   public EResult fetchActions(IWebContext context,
                               IWebSession sessionContext,
                               IWebInput input,
                               IWebOutput output,
                               ILogicContext logicContext);
}
