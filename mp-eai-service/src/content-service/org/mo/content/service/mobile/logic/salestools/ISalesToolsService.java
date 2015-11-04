package org.mo.content.service.mobile.logic.salestools;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>新闻信息管理接口。</T>
//============================================================
public interface ISalesToolsService
{
   //============================================================
   // <T>默认逻辑。</T>
   //
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult process(IWebContext context,
                   IWebInput input,
                   IWebOutput output);

   //============================================================
   // <T>根据guid获取销售工具相关信息。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult query(IWebContext context,
                 IWebInput input,
                 IWebOutput output,
                 ILogicContext logicContext);

   //============================================================
   // <T>分页获取销售工具相关信息。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult select(IWebContext context,
                  IWebInput input,
                  IWebOutput output,
                  ILogicContext logicContext);

   // ============================================================
   // <T>标记销售工具已读</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   EResult markRead(IWebContext context,
                    IWebInput input,
                    IWebOutput output,
                    ILogicContext logicContext,
                    IWebSession sessionContext);
}
