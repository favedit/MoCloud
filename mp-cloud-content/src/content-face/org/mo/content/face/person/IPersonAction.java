package org.mo.content.face.person;

import org.mo.com.data.ASqlConnect;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.common.ISqlContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>用户逻辑接口</P>
//
//@class IPersonAction
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================

public interface IPersonAction
{
   String construct(ISqlContext context,
                    @AContainer(name = "personPage") FPersonPage personPage);

   // ============================================================
   // <T>注册</T>
   //
   // @param context 上下文
   // @param logicContext 数据库连接
   // @param personPage 容器
   // @return 要跳转页面
   // ============================================================
   String register(IWebContext context,
                   @ASqlConnect(name = "GCDATA") ILogicContext logicContext,
                   @AContainer(name = "personPage") FPersonPage personPage);
}
