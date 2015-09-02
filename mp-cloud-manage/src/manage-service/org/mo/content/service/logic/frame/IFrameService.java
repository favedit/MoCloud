package org.mo.content.service.logic.frame;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>人员账号服务接口。</T>
//============================================================
public interface IFrameService
{
   //============================================================
   // <T>获取数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult fetch(IWebContext context,
                 ILogicContext logicContext,
                 IWebInput input,
                 IWebOutput output);

   //============================================================
   // <T>获取详细处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult detail(IWebContext context,
                  ILogicContext logicContext,
                  IWebInput input,
                  IWebOutput output);

   //============================================================
   // <T>保存数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult save(IWebContext context,
                ILogicContext logicContext,
                IWebInput input,
                IWebOutput output);
}
