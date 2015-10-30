package org.mo.content.service.mobile.logic.person.info;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>登录service接口。</T>
//============================================================
public interface IPersonInfoService {
    // ============================================================
    // <T>默认逻辑。</T>
    // @param context 页面环境
    // @param input 输入配置
    // @param output 输出配置
    // @return 处理结果
    // ============================================================
    EResult process(IWebContext context, IWebInput input, IWebOutput output);

    // ============================================================
    // <T>个人中心</T>
    // @param context 页面环境
    // @param input 输入配置
    // @param output 输出配置
    // @return 处理结果
    // @logicContext 逻辑上下文
    // @sessionContext session上下文
    // ============================================================
    EResult personInfo(IWebContext context, IWebInput input, IWebOutput output,
            ILogicContext logicContext, IWebSession sessionContext);
}
