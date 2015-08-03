package org.mo.content.service.info.device;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>信息设备数据服务接口。</T>
//============================================================
public interface IDeviceService
{
   //============================================================
   // <T>登录信息处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult access(IWebContext context,
                  ILogicContext logicContext,
                  IWebInput input,
                  IWebOutput output);
}
