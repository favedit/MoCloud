package org.mo.content.face.mobile;

import org.mo.content.face.base.FBasePage;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>客户信息接口。</P>
//@interface ICustomerAction
//@author hyw
//============================================================
public interface IMobileAction
{
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   String construct(IWebContext context,
                    ILogicContext logicContext,
                    @AContainer(name = "page") FMobilePage Page,
                    @AContainer(name = "basePage") FBasePage basePage);
                    
   //============================================================
   // <T>获取安卓最新版本。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================               
   String getAndroid(IWebContext context,
                     ILogicContext logicContext,
                     @AContainer(name = "page") FMobilePage Page,
                     @AContainer(name = "basePage") FBasePage basePage);
                     
   //============================================================
   // <T>获取ios最新版本。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================            
   String getIos(IWebContext context,
                 ILogicContext logicContext,
                 @AContainer(name = "page") FMobilePage Page,
                 @AContainer(name = "basePage") FBasePage basePage);
                 
}
