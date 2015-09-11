package org.mo.content.face.product.department;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>接口。</P>
//
// @author sunhr
// @version 150718
//============================================================
public interface IDepartmentAction
{
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   String construct(IWebContext context,
                    ILogicContext logicContext,
                    @AContainer(name = "basePage") FBasePage page);

   //============================================================
   // <T></T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   String select(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "devicePage") FDepartmentPage devicePage,
                 @AContainer(name = "basePage") FBasePage basePage);

   //============================================================
   // <T></T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   String updateBefore(IWebContext context,
                       ILogicContext logicContext,
                       @AContainer(name = "devicePage") FDepartmentPage devicePage,
                       @AContainer(name = "basePage") FBasePage basePage);

   String putMobileInfo(IWebContext context,
                        ILogicContext logicContext,
                        @AContainer(name = "page") FDepartmentPage page);

   String expend(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "page") FDepartmentPage page,
                 @AContainer(name = "basePage") FBasePage basePage);
}
