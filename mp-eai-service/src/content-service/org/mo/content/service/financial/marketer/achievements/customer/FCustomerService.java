package org.mo.content.service.financial.marketer.achievements.customer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;
import org.mo.cloud.core.message.FGcErrorMessage;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.financial.customer.FDataCustomerInfo;
import org.mo.content.core.financial.customer.IDataCustomerConsole;
import org.mo.content.core.financial.marketer.IDataMarketerConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>理财师客户服务。</T>
//============================================================
public class FCustomerService
      extends FObject
      implements
         ICustomerService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCustomerService.class);

   // GcSession会话控制器
   @ALink
   protected IGcSessionConsole _gcSessionConsole;

   // 理财师控制器
   @ALink
   protected IDataMarketerConsole _marketerConsole;

   // 理财师客户控制器
   @ALink
   protected IDataCustomerConsole _customerConsole;

   // ============================================================
   // <T>默认逻辑。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public EResult process(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      return null;
   }

   // ============================================================
   // <T>获取所有客户</T>
   // @param context 页面环境
   // @sessionContext 会话session上下文
   // @param input 输入配置
   // @param output 输出配置
   // @logicContext 逻辑上下文
   // @return 处理结果
   // ============================================================
   @Override
   public EResult fetch(IWebContext context,
                        IWebSession sessionContext,
                        IWebInput input,
                        IWebOutput output,
                        ILogicContext logicContext){
      String session_code = context.parameter("session_code");
      int pageSize = 10;
      int pageNumber = 0;
      _logger.debug(this, "Fetch", "Fetch achievements customer list begin. (session={1})", session_code);
      // 获取session验证,获取理财师
      FDataFinancialMarketerUnit marketer = checkMarketerBySession(context, logicContext, session_code);
      if(marketer == null){
         return EResult.Failure;
      }
      pageSize = context.parameterAsInteger("page_size");
      pageNumber = context.parameterAsInteger("page_nubmer");
      FLogicDataset<FDataCustomerInfo> MCList = _customerConsole.fetchByMarketerId(logicContext, marketer.ouid(), pageNumber, pageSize);
      FXmlNode customerList = output.config().createNode("customer_list");
      if(MCList.count() < 1){
         customerList.setText("0");
         return EResult.Success;
      }
      for(FDataCustomerInfo info : MCList){
         FXmlNode customer = customerList.createNode();
         customer.createNode("picture", RString.isEmpty(info.iconUrl()) ? "0" : info.iconUrl());
         customer.createNode("name", RString.isEmpty(info.label()) ? "0" : info.label());
         customer.createNode("investment_total", RString.parse(info.investmentTotal()));
         customer.createNode("redemption_total", RString.parse(info.redemptionTotal()));
         customer.createNode("netinvestment_total", RString.parse(info.netinvestment()));
         String lastLoginDate = RString.parse(info.lastLoginDate());
         customer.createNode("last_login_date", RString.isEmpty(lastLoginDate) ? "0" : lastLoginDate);
      }
      return EResult.Success;
   }

   // ============================================================
   // <T>根据名称获取所匹配的客户</T>
   // @param context 页面环境
   // @sessionContext 会话session上下文
   // @param input 输入配置
   // @param output 输出配置
   // @logicContext 逻辑上下文
   // @return 处理结果
   // ============================================================
   @Override
   public EResult fetchByName(IWebContext context,
                              IWebSession sessionContext,
                              IWebInput input,
                              IWebOutput output,
                              ILogicContext logicContext){
      String session_code = context.parameter("session_code");
      String name = context.parameter("name");
      _logger.debug(this, "FetchByName", "FetchByName achievements fetch customer by name begin. (session={1})", session_code);
      // 获取session验证,获取理财师
      FDataFinancialMarketerUnit marketer = checkMarketerBySession(context, logicContext, session_code);
      if(marketer == null){
         return EResult.Failure;
      }

      FXmlNode customerList = output.config().createNode("customer_list");
      for(int i = 0; i < 4; i++){
         FXmlNode customer = customerList.createNode();
         customer.createNode("picture", "图片");
         customer.createNode("name", "张三");
         customer.createNode("investment_total", "20000050");
         customer.createNode("redemption_total", "2000000");
         customer.createNode("netinvestment_total", "1000000");
         customer.createNode("last_login_date", "2015-11-05");
      }
      return EResult.Success;
   }

   // ============================================================
   // <T>根据唯一码获取客户信息</T>
   // @param context 页面环境
   // @sessionContext 会话session上下文
   // @param input 输入配置
   // @param output 输出配置
   // @logicContext 逻辑上下文
   // @return 处理结果
   // ============================================================
   @Override
   public EResult findInfo(IWebContext context,
                           IWebSession sessionContext,
                           IWebInput input,
                           IWebOutput output,
                           ILogicContext logicContext){
      String session_code = context.parameter("session_code");
      String guid = context.parameter("guid");
      _logger.debug(this, "FindInfo", "FindInfo achievements find customer info begin. (session={1})", session_code);
      // 获取session验证,获取理财师
      FDataFinancialMarketerUnit marketer = checkMarketerBySession(context, logicContext, session_code);
      if(marketer == null){
         return EResult.Failure;
      }
      output.config().createNode("picture", "图片");
      output.config().createNode("name", "张三");
      output.config().createNode("gender", "男");
      output.config().createNode("investment_total", "20000050");
      output.config().createNode("investment_count", "10");
      output.config().createNode("redemption_total", "2000000");
      output.config().createNode("redemption_count", "20");
      output.config().createNode("netinvestment_total", "1000000");
      return EResult.Success;
   }

   // ============================================================
   // <T>根据唯一码获取客户所投资的产品</T>
   // @param context 页面环境
   // @sessionContext 会话session上下文
   // @param input 输入配置
   // @param output 输出配置
   // @logicContext 逻辑上下文
   // @return 处理结果
   // ============================================================
   @Override
   public EResult fetchProducts(IWebContext context,
                                IWebSession sessionContext,
                                IWebInput input,
                                IWebOutput output,
                                ILogicContext logicContext){
      String session_code = context.parameter("session_code");
      String guid = context.parameter("guid");
      _logger.debug(this, "FetchProducts", "FetchProducts achievements fetch customer product investment begin. (session={1})", session_code);
      // 获取session验证,获取理财师
      FDataFinancialMarketerUnit marketer = checkMarketerBySession(context, logicContext, session_code);
      if(marketer == null){
         return EResult.Failure;
      }
      FXmlNode customerList = output.config().createNode("product_list");
      for(int i = 0; i < 4; i++){
         FXmlNode customer = customerList.createNode();
         customer.createNode("name", "e租财富");
         customer.createNode("rate", "14.6");
         customer.createNode("investment_total", "100000");
         customer.createNode("redemption_total", "500000");
         customer.createNode("netinvestment_total", "500000");
         customer.createNode("last_login_date", "2015-11-05");
      }
      return EResult.Success;
   }

   // ============================================================
   // <T>根据唯一码获取客户的所有行为</T>
   // @param context 页面环境
   // @sessionContext 会话session上下文
   // @param input 输入配置
   // @param output 输出配置
   // @logicContext 逻辑上下文
   // @return 处理结果
   // ============================================================
   @Override
   public EResult fetchActions(IWebContext context,
                               IWebSession sessionContext,
                               IWebInput input,
                               IWebOutput output,
                               ILogicContext logicContext){
      String session_code = context.parameter("session_code");
      String guid = context.parameter("guid");
      _logger.debug(this, "FetchActions", "FetchActions achievements fetch customer actions begin. (session={1})", session_code);
      // 获取session验证,获取理财师
      FDataFinancialMarketerUnit marketer = checkMarketerBySession(context, logicContext, session_code);
      if(marketer == null){
         return EResult.Failure;
      }
      FXmlNode customerList = output.config().createNode("action_list");
      for(int i = 0; i < 4; i++){
         FXmlNode customer = customerList.createNode();
         customer.createNode("date", "2015-11-20 12:20:11");
         customer.createNode("content", "赎回金额100000");
      }
      return EResult.Success;
   }

   // ============================================================
   // <T>根据seesion获取理财师</T>
   // @param context 页面环境
   // @logicContext 逻辑上下文
   // @sessionCode 会话session
   // @return 处理结果
   // ============================================================
   private FDataFinancialMarketerUnit checkMarketerBySession(IWebContext context,
                                                             ILogicContext logicContext,
                                                             String sessionCode){
      FGcSessionInfo sessionInfo = _gcSessionConsole.findBySessionCode(logicContext, "eai.mobile", "0", sessionCode);
      if(sessionInfo == null){// session不存在
         context.messages().push(new FGcErrorMessage(sessionCode, "session不存在", sessionCode));
         _logger.debug(this, "Achievements", "Marketer achievements check session, session is not exists. (session_code={1})", sessionCode);
         return null;
      }
      //获取理财师
      FDataFinancialMarketerUnit marketer = _marketerConsole.findByUserId(logicContext, sessionInfo.userId());
      if(marketer == null){// 当前用户不是理财师
         context.messages().push(new FGcErrorMessage(RString.parse(sessionInfo.userId()), "当前用户还不是理财师不存在", RString.parse(sessionInfo.userId())));
         _logger.debug(this, "Achievements", "Marketer achievements check marketer, this user is not marketer. (userId={1})", RString.parse(sessionInfo.userId()));
         return null;
      }
      return marketer;
   }
}
