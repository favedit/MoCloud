package org.mo.content.face.manage.statistics.user.login;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>人员账号逻辑接口。</T>
//
// @author sunhr
// @version 150328
//============================================================
public interface IAccessAction 
{

   // ============================================================
   // <T>构造器</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String construct(IWebContext context, 
                    ILogicContext logicContext, 
                    @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String select(IWebContext context, 
                 ILogicContext logicContext, 
                 @AContainer(name = "accessPage") FAccessPage accessPage, 
                 @AContainer(name = "basePage") FBasePage basePage);

   // ============================================================
   // <T>根据时间段查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String selectByDate(IWebContext context, 
                       ILogicContext logicContext, 
                       @AContainer(name = "accessPage") FAccessPage accessPage, 
                       @AContainer(name = "basePage") FBasePage basePage);
   // ============================================================
   // <T>根据自然日查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   String selectByDay(IWebContext context, 
                      ILogicContext logicContext, 
                      @AContainer(name = "accessPage") FAccessPage accessPage, 
                      @AContainer(name = "basePage") FBasePage basePage);

}
