package org.mo.content.face.pc.marketer.recommend;

import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.cloud.core.web.FGcWebSession;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.financial.marketer.IDataMarketerConsole;
import org.mo.content.core.financial.member.FDataFinancialMemberInfo;
import org.mo.content.core.financial.member.IDataMemberConsole;
import org.mo.content.core.manage.person.user.IUserConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
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

   //session控制台
   @ALink
   protected IWebSessionConsole _sessionConsole;

   //用户控制台
   @ALink
   protected IUserConsole _userConsole;

   //理财师控制台
   @ALink
   protected IDataMarketerConsole _marketerConsole;

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
      FGcWebSession session = (FGcWebSession)sessionContext;
      _logger.debug(this, "construct", "construct default begin.(session={1})", session);
      FDataPersonUserUnit user = _userConsole.find(logicContext, session.userId());
      if(user != null){
         page.setLabel(user.label());
      }
      FDataFinancialMarketerUnit marketer = _marketerConsole.findByUserId(logicContext, user.ouid());
      if(marketer == null){
         return "/apl/message/LogicFatal";
      }
      _logger.debug(this, "construct", "construct findByUserid marketer.(marketer={1})", marketer.ouid());
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         page.setPageCurrent(Integer.parseInt(num));
      }else{
         page.setPageCurrent(0);
      }
      //分页处理
      int pageTotal = _memberConsole.getPageCount(logicContext);
      _logger.debug(this, "construct", "construct getMemeberPageTotal.(pageTotal={1})", pageTotal);
      page.setPageTotal(pageTotal);
      // 第0页
      if(page.pageCurrent() == 0){
         page.setPageCurrent(1);
      }
      // 最后一页
      if(pageTotal < page.pageCurrent()){
         page.setPageCurrent(pageTotal);
      }
      FLogicDataset<FDataFinancialMemberInfo> memberList = _memberConsole.select(logicContext, marketer.ouid(), page.pageCurrent() - 1);
      page.setMemberList(memberList);
      _logger.debug(this, "Select", "Member Select finish. (memberList = {1})", memberList);

      return "/pc/marketer/recommend/MemberList";
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
      //      if(null != context.parameter("page")){
      //         String num = context.parameter("page");
      //         page.setPageCurrent(Integer.parseInt(num));
      //      }else{
      //         page.setPageCurrent(0);
      //      }
      //      FLogicDataset<FDataFinancialMemberInfo> memberList = _memberConsole.select(logicContext, page.pageCurrent() - 1);
      //      page.setMemberList(memberList);
      //      _logger.debug(this, "Select", "Member Select finish. (memberList = {1})", memberList);
      return "/pc/marketer/recommend/MemberList";
   }

   //============================================================
   // <T>关注逻辑处理。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param basePage 公用容器
   // @param page 页面
   //============================================================
   @Override
   public String follow(IWebContext context,
                        IWebSession sessionContext,
                        ILogicContext logicContext,
                        FBasePage basePage,
                        FRecommendPage page){
      FGcWebSession session = (FGcWebSession)sessionContext;
      _logger.debug(this, "construct", "construct default begin.(session={1})", session);
      FDataPersonUserUnit user = _userConsole.find(logicContext, session.userId());
      FDataFinancialMarketerUnit marketerUnit = _marketerConsole.findByUserId(logicContext, user.ouid());
      if(marketerUnit == null){
         page.setMessage("false");
         return "/apl/ajax";
      }
      String guid = context.parameter("id");
      if(RString.isEmpty(guid)){
         page.setMessage("false");
         return "/apl/ajax";
      }
      EResult result = _memberConsole.follow(logicContext, marketerUnit.ouid(), guid);
      if(result.equals(EResult.Failure)){
         page.setMessage("false");
         return "/apl/ajax";
      }
      //成功
      page.setMessage("true");
      return "/apl/ajax";
   }

   //============================================================
   // <T>获取成员信息。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param basePage 公用容器
   // @param page 页面
   //============================================================
   @Override
   public String memberInfo(IWebContext context,
                            IWebSession sessionContext,
                            ILogicContext logicContext,
                            FBasePage basePage,
                            FRecommendPage page){
      String guid = context.parameter("id");
      if(RString.isEmpty(guid)){
         return "/apl/message/LogicFatal";
      }
      FGcWebSession session = (FGcWebSession)sessionContext;
      _logger.debug(this, "memberInfo", "memberInfo default begin.(session={1})", session);
      FDataPersonUserUnit user = _userConsole.find(logicContext, session.userId());
      if(user != null){
         page.setLabel(user.label());
      }

      FDataFinancialMarketerUnit marketer = _marketerConsole.findByUserId(logicContext, user.ouid());
      if(marketer == null){
         return "/apl/message/LogicFatal";
      }

      FDataFinancialMemberInfo unit = _memberConsole.findInfoByGuid(logicContext, marketer.ouid(), guid);

      if(unit == null){
         return "/apl/message/LogicFatal";
      }
      page.setMember(unit);
      return "/pc/marketer/recommend/MemberInfo";
   }
}
