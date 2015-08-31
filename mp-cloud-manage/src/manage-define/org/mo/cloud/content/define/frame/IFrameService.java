package org.mo.cloud.content.define.frame;

import org.mo.com.lang.EResult;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>内容表单服务接口。</T>
//============================================================
public interface IFrameService
{
   //============================================================
   // <T>查询配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult query(IWebContext context,
                 IWebInput input,
                 IWebOutput output);
}
