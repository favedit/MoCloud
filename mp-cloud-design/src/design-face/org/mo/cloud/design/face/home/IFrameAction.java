package org.mo.cloud.design.face.home;

import org.mo.cloud.design.face.base.FBasePage;
import org.mo.com.data.ASqlConnect;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

public interface IFrameAction
{
   //============================================================
   // <T>默认跳转</T>
   //
   // @param context 环境
   // @param page 容器
   // @return 处理结果
   //============================================================
   String construct(IWebContext context,
                    @ASqlConnect(name = "CD_DATA") ILogicContext logicContext,
                    @AContainer(name = "basePage") FBasePage basePage);

}
