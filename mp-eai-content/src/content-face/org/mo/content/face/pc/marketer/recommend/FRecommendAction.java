package org.mo.content.face.pc.marketer.recommend;

import com.cyou.gccloud.data.data.FDataFinancialMemberLogic;
import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.financial.member.IDataMemberConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>金融成员信息。</P>
//
// @author sunhr
// @version 150921
//============================================================
public class FRecommendAction
      implements
         IRecommendAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FRecommendAction.class);

   //成员信息控制器
   @ALink
   protected IDataMemberConsole _memberConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           IWebSession sessionContext,
                           ILogicContext logicContext,
                           FBasePage basePage,
                           FRecommendPage page){

      return "";
   }

   //============================================================
   // <T>查询。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String select(IWebContext context,
                        IWebSession sessionContext,
                        ILogicContext logicContext,
                        FBasePage basePage,
                        FRecommendPage page){
      _logger.debug(this, "Select", "Member Select. ");
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         page.setPageCurrent(Integer.parseInt(num));
      }else{
         page.setPageCurrent(0);
      }
      FLogicDataset<FDataFinancialMemberUnit> memberList = _memberConsole.fetch(logicContext, null, FDataFinancialMemberLogic.RECOMMEND_SCORE + " DESC");
      page.setMemberList(memberList);
      return "/marketer/recommend/CustomerList";
   }
}
