package org.mo.content.face.logger.browser;

import com.cyou.gccloud.data.logger.FLoggerInfoBrowserAccessUnit;
import org.mo.content.core.logger.browser.IAccessConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>人员账号逻辑。</T>
//
// @author sunhr
// @version 150328
//============================================================
public class FAccessAction
      implements
         IAccessAction
{
   //用户控制台
   @ALink
   protected IAccessConsole _accessConsole;

   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FBasePage basePage){
      return "/eai/logger/BrowserAccessList";
   }

   @Override
   public String select(IWebContext context,
                        ILogicContext logicContext,
                        FAccessPage accessPage,
                        FBasePage basePage){
      System.out.println("------------eai.logger.browser.access----------------construct");
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         accessPage.setPageCurrent(Integer.parseInt(num));
      }else{
         accessPage.setPageCurrent(0);
      }
      FLogicDataset<FLoggerInfoBrowserAccessUnit> unitlist = _accessConsole.select(logicContext, accessPage.pageCurrent() - 1);
      basePage.setJson(unitlist.toJsonListString());
      return "/eai/common/ajax";
   }
}
