package org.mo.content.service.mobile.logic.attendance;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>打卡接口。</T>
//============================================================
public interface IClickService
{
   //============================================================
   // <T>默认逻辑。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult process(IWebContext context,
                   IWebInput input,
                   IWebOutput output);

   //============================================================
   // <T>打卡服务接口。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult sign(IWebContext context,
                IWebSession sessionContext,
                IWebInput input,
                IWebOutput output,
                ILogicContext logicContext);
}
