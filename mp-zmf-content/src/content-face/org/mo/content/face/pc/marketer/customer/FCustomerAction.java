package org.mo.content.face.pc.marketer.customer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerCustomerUnit;
import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.define.enums.common.EGcActive;
import org.mo.cloud.core.web.FGcWebSession;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.financial.customer.FDataFinancialCustomerInfo;
import org.mo.content.core.financial.customer.ICustomerConsole;
import org.mo.content.core.financial.marketer.IDataMarketerConsole;
import org.mo.content.core.financial.marketer.customer.IDataMarketerCustomerConsole;
import org.mo.content.core.manage.person.user.IUserConsole;
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
         ICustomerAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCustomerAction.class);

   //session控制台
   @ALink
   protected IWebSessionConsole _sessionConsole;

   //用户控制台
   @ALink
   protected IUserConsole _userConsole;

   //理财师信息控制器
   @ALink
   protected IDataMarketerConsole _marketerConsole;

   // 客户信息控制器
   @ALink
   protected ICustomerConsole _customerConsole;

   // 理财师客户控制器
   @ALink
   protected IDataMarketerCustomerConsole _marketerCustomerConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param page 页面容器
   //============================================================
   @Override
   public String construct(IWebContext context,
                           IWebSession sessionContext,
                           ILogicContext logicContext,
                           FCustomerPage page){
      FGcWebSession session = (FGcWebSession)sessionContext;
      _logger.debug(this, "construct", "construct default begin.(session={1})", session.id());
      FDataPersonUserUnit user = _userConsole.find(logicContext, session.userId());
      long marketerId = 0;
      if(user != null){
         FDataFinancialMarketerUnit marketer = _marketerConsole.findByUserId(logicContext, user.ouid());
         if(marketer == null){
            _logger.debug(this, "construct", "construct this user is not marketer.(user={1})", user.ouid());
            return "/apl/message/LogicFatal";
         }
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
      int pageTotal = _customerConsole.getPageCount(logicContext, marketerId);
      page.setPageTotal(pageTotal);
      // 第0页
      if(page.pageCurrent() == 0){
         page.setPageCurrent(1);
      }
      // 最后一页
      if(pageTotal < page.pageCurrent()){
         page.setPageCurrent(pageTotal);
      }
      FLogicDataset<FDataFinancialCustomerInfo> customerList = _customerConsole.selectByMarketerId(logicContext, marketerId);
      page.setCustomerList(customerList);
      _logger.debug(this, "construct", "construct Select finish. (marketerMemberList = {1})", customerList);
      return "/pc/marketer/customer/CustomerList";
   }

   //============================================================
   // <T>短信提醒设置。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param page 页面容器
   //============================================================
   @Override
   public String settingsSMS(IWebContext context,
                             IWebSession sessionContext,
                             ILogicContext logicContext,
                             FCustomerPage page){
      FGcWebSession session = (FGcWebSession)sessionContext;
      _logger.debug(this, "SettingsSMS", "SettingsSMS begin.(session={1})", session.id());
      FDataPersonUserUnit user = _userConsole.find(logicContext, session.userId());
      long marketerId = 0;
      if(user != null){
         FDataFinancialMarketerUnit marketer = _marketerConsole.findByUserId(logicContext, user.ouid());
         marketerId = marketer.ouid();
         page.setLabel(user.label());
      }
      _logger.debug(this, "SettingsSMS", "find user finish.(user={1},marketer={2})", user.ouid(), marketerId);
      // 目前只做登录提醒
      long customer = context.parameterAsLong("customer");
      Integer selected = context.parameterAsInteger("setting");
      System.out.println(customer + "----" + selected);
      // 是否存在（理财师、客户、提醒状态）
      FDataFinancialMarketerCustomerUnit marketerCustomer = _marketerCustomerConsole.findBeenSet(logicContext, marketerId, customer);
      if(marketerCustomer == null){
         FDataFinancialMarketerCustomerUnit mCustomer = _marketerCustomerConsole.doPrepare(logicContext);
         mCustomer.setMarketerId(marketerId);
         mCustomer.setCustomerId(customer);
         mCustomer.setSmsContactCd(selected);
         mCustomer.setActiveCd(EGcActive.Active);
         _marketerCustomerConsole.doInsert(logicContext, mCustomer);
      }else{//如果存在，修改短信发送行为。
         marketerCustomer.setSmsContactCd(selected);
         _marketerCustomerConsole.doUpdate(logicContext, marketerCustomer);
      }
      return "/pc/marketer/customer/CustomerList";
   }

   //============================================================
   // <T>获取客户信息。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param page 页面容器
   //============================================================
   @Override
   public String customerInfo(IWebContext context,
                              IWebSession sessionContext,
                              ILogicContext logicContext,
                              FCustomerPage page){
      // 根据客户获取客户的所有信息
      long customer = context.parameterAsLong("customer");
      FDataFinancialCustomerInfo customerInfo = _customerConsole.findInfo(logicContext, customer);
      page.setCustomerInfo(customerInfo);
      return "/pc/marketer/customer/CustomerInfo";
   }
}
