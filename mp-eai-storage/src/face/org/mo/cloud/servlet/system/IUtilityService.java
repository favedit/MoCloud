package org.mo.cloud.servlet.system;

import org.mo.com.lang.EResult;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>服务器工具接口。</T>
//============================================================
public interface IUtilityService
{
   //============================================================
   // <T>服务器运行信息查询。</T>
   //
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult info(IWebContext context,
                IWebInput input,
                IWebOutput output);
}
