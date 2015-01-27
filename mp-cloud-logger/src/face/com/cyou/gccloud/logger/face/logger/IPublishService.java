package com.cyou.gccloud.logger.face.logger;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>日志处理控制台接口。</T>
//============================================================
public interface IPublishService
{
   //============================================================
   // <T>日志处理接口。</T>
   //
   // @param context 网页环境
   // @param logicContext 逻辑环境
   // @param input 网页输入
   // @param output 网页输出
   //============================================================
   EResult process(IWebContext context,
                   ILogicContext logicContext,
                   IWebInput input,
                   IWebOutput output);
}
