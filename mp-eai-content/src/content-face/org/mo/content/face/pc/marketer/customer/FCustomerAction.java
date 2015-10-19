package org.mo.content.face.pc.marketer.customer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerMemberUnit;
import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;
import com.cyou.gccloud.data.data.FDataFinancialMemberUnit;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.define.enums.financial.EGcFinancialMemberRelation;
import org.mo.cloud.core.web.FGcWebSession;
import org.mo.com.lang.EResult;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.financial.marketer.IDataMarketerConsole;
import org.mo.content.core.financial.marketer.member.FDataFinancialMarketerMemberInfo;
import org.mo.content.core.financial.marketer.member.IDataMarketerMemberConsole;
import org.mo.content.core.financial.member.IDataMemberConsole;
import org.mo.content.core.manage.person.user.IUserConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.content.face.pc.marketer.member.FFollowedPage;
import org.mo.content.face.pc.marketer.member.IFollowedAction;
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
public class FCustomerAction
      implements
         IFollowedAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCustomerAction.class);

   //session控制台
   @ALink
   protected IWebSessionConsole _sessionConsole;

   //用户控制台
   @ALink
   protected IUserConsole _userConsole;

   // 成员控制器
   @ALink
   protected IDataMemberConsole _memberConsole;

   //理财师信息控制器
   @ALink
   protected IDataMarketerConsole _marketerConsole;

   //理财师成员控制器
   @ALink
   protected IDataMarketerMemberConsole _marketerMemberConsole;

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
                           FFollowedPage page){
      System.out.println("--------------------------------------------------");
      FGcWebSession session = (FGcWebSession)sessionContext;

      _logger.debug(this, "construct", "construct default begin.(session={1})", session);
      FDataPersonUserUnit user = _userConsole.find(logicContext, session.userId());
      long marketerId = 0;
      if(user != null){
         FDataFinancialMarketerUnit marketer = _marketerConsole.findByUserId(logicContext, user.ouid());
         marketerId = marketer.ouid();
         page.setLabel(user.label());
      }
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         page.setPageCurrent(Integer.parseInt(num));
      }else{
         page.setPageCurrent(0);
      }
      //分页处理
      int pageTotal = _marketerMemberConsole.getPageCount(logicContext, marketerId);
      page.setPageTotal(pageTotal);
      // 第0页
      if(page.pageCurrent() == 0){
         page.setPageCurrent(1);
      }
      // 最后一页
      if(pageTotal < page.pageCurrent()){
         page.setPageCurrent(pageTotal);
      }
      FLogicDataset<FDataFinancialMarketerMemberInfo> marketerMemberList = _marketerMemberConsole.selectFollowedByMarketerId(logicContext, marketerId, page.pageCurrent() - 1);
      page.setMarketerMemberList(marketerMemberList);
      _logger.debug(this, "construct", "construct Select finish. (marketerMemberList = {1})", marketerMemberList.count());
      return "/pc/marketer/customer/CustomerList";
   }

   //============================================================
   // <T>解除关系逻辑处理。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param basePage 公共容器
   // @param page 页面容器
   //============================================================
   @Override
   public String removeRelation(IWebContext context,
                                IWebSession sessionContext,
                                ILogicContext logicContext,
                                FBasePage basePage,
                                FFollowedPage page){
      String guid = context.parameter("id");
      int feedbackCd = context.parameterAsInteger("feedbackCd");
      String feedbackNote = context.parameter("feedbackNote");
      _logger.debug(this, "RemoveRelation", "RemoveRelation begin.(guid={1},feedbackCd={2},feedbackNote={3})", guid, feedbackCd, feedbackNote);
      if(guid.isEmpty() || feedbackCd == 0){
         page.setMessage("false");
         return "/apl/ajax";
      }
      // 获取成员信息
      FDataFinancialMemberUnit member = _memberConsole.findByGuid(logicContext, guid);
      if(member == null){
         page.setMessage("false");
         return "/apl/ajax";
      }
      // 根据成员编号获取理财师信息      
      FDataFinancialMarketerMemberUnit marketerMember = _marketerMemberConsole.findByMemberId(logicContext, member.ouid());
      if(marketerMember == null){
         _logger.debug(this, "RemoveRelation", "RemoveRelation find marketer member is null.(guid={1})", guid);
         page.setMessage("false");
         return "/apl/ajax";
      }
      marketerMember.setRelationCd(EGcFinancialMemberRelation.Unknown);
      marketerMember.setFeedbackCd(feedbackCd);
      marketerMember.setFeedbackNote(feedbackNote);
      EResult result = _marketerMemberConsole.doUpdate(logicContext, marketerMember);
      if(result.equals(EResult.Failure)){
         _logger.debug(this, "RemoveRelation", "RemoveRelation update marketer member is failure.(guid={1})", guid);
         page.setMessage("false");
         return "/apl/ajax";
      }
      _logger.debug(this, "RemoveRelation", "RemoveRelation success.(guid={1})", guid);
      page.setMessage("true");
      return "/apl/ajax";
   }
}
