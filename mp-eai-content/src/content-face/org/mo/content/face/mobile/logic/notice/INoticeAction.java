package org.mo.content.face.mobile.logic.notice;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>客户信息接口。</P>
//@interface ICustomerAction
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================
public interface INoticeAction {
    // ============================================================
    // <T>默认逻辑处理。</T>
    // @param context 页面环境
    // @param page 页面
    // ============================================================
    public String construct(IWebContext context, ILogicContext logicContext,
            @AContainer(name = "page") FNoticePage Page,
            @AContainer(name = "basePage") FBasePage page);

    // ============================================================
    // <T>根据guid获取通告</T>
    // @通告
    // @param context 网络环境
    // @param logicContext 逻辑环境
    // @param page 容器
    // @return 页面
    // ============================================================
    public String getInfo(IWebContext context, ILogicContext logicContext,
            @AContainer(name = "page") FNoticePage Page,
            @AContainer(name = "basePage") FBasePage basePage);

    // ============================================================
    // <T>标记已读接口。</T>
    // @param context 页面环境
    // @param input 输入配置
    // @param output 输出配置
    // @return 处理结果
    // ============================================================
    public String markRead(IWebContext context, IWebSession sessionContext,
            ILogicContext logicContext,
            @AContainer(name = "page") FNoticePage Page,
            @AContainer(name = "basePage") FBasePage basePage);
}
