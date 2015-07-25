package org.mo.content.face.logger.user;

import com.cyou.gccloud.data.logger.FLoggerPersonUserAccessUnit;
import org.mo.content.core.logger.user.IAccessConsole;
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

   //============================================================
   // <T>用户</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FAccessPage accessPage,
                           FBasePage basePage){
      System.out.println("------------eai.logger----------------construct");
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         accessPage.setPageCurrent(Integer.parseInt(num));
      }else{
         accessPage.setPageCurrent(0);
      }
      FLogicDataset<FLoggerPersonUserAccessUnit> unitlist = _accessConsole.select(logicContext, accessPage.pageCurrent() - 1);
      basePage.setJson(unitlist.toJsonListString());
      return "/eai/common/ajax";
   }
}
