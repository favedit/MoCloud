package org.mo.content.service.person;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>人员账号服务接口。</T>
//============================================================
public interface IAccountService
{
   //============================================================
   // <T>登录数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult login(IWebContext context,
                 ILogicContext logicContext,
                 IWebInput input,
                 IWebOutput output);
}
