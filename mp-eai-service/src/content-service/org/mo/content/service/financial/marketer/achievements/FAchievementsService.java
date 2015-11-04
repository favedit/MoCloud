package org.mo.content.service.financial.marketer.achievements;

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
import org.mo.content.core.financial.marketer.IDataMarketerConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>理财师业绩服务。</T>
//============================================================
public class FAchievementsService
      extends FObject
      implements
         IAchievementsService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FAchievementsService.class);

   // GcSession会话控制器
   @ALink
   protected IGcSessionConsole _gcSessionConsole;

   // 理财师控制器
   @ALink
   protected IDataMarketerConsole _marketerConsole;

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
   // <T>获取一个月的业绩</T>
   // @param context 页面环境
   // @sessionContext 会话session上下文
   // @param input 输入配置
   // @param output 输出配置
   // @logicContext 逻辑上下文
   // @return 处理结果
   // ============================================================
   @Override
   public EResult month(IWebContext context,
                        IWebSession sessionContext,
                        IWebInput input,
                        IWebOutput output,
                        ILogicContext logicContext){
      String session_code = context.parameter("session_code");
      _logger.debug(this, "Month", "Marketer achievements first30 days begin. (session={1})", session_code);
      // 获取session验证,获取理财师
      FDataFinancialMarketerUnit marketer = checkMarketerBySession(context, logicContext, session_code);
      if(marketer == null){
         return EResult.Failure;
      }
      // 获取投资总额、赎回总额、净投总额
      FXmlNode achievementsTotal = output.config().createNode("AchievementsTotal");
      achievementsTotal.createNode("investment_total", RString.parse(marketer.customerInvestmentTotal()));
      achievementsTotal.createNode("investment_count", RString.parse(marketer.customerInvestmentCount()));
      achievementsTotal.createNode("redemption_total", RString.parse(marketer.customerRedemptionTotal()));
      achievementsTotal.createNode("redemption_count", RString.parse(marketer.customerRedemptionCount()));
      achievementsTotal.createNode("netinvestment_total", RString.parse(marketer.customerNetinvestmentTotal()));
      // 获取前30天的投资情况
      FXmlNode achievementsForMonth = output.config().createNode("AchievementsFirst30Days");
      int first30Days = 31;
      for(int i = 1; i < first30Days; i++){
         FXmlNode month = achievementsForMonth.createNode("day" + i);
         month.createNode("date", "2015-10-20");
         month.createNode("investment_day", "123.00");
         month.createNode("redemption_day", "123.23");
         month.createNode("netinvestment_day", "123.25");
      }
      return EResult.Success;
   }

   // ============================================================
   // <T>获取一个月内的客户数量</T>
   // @param context 页面环境
   // @sessionContext 会话session上下文
   // @param input 输入配置
   // @param output 输出配置
   // @logicContext 逻辑上下文
   // @return 处理结果
   // ============================================================
   @Override
   public EResult fetchCount(IWebContext context,
                             IWebSession sessionContext,
                             IWebInput input,
                             IWebOutput output,
                             ILogicContext logicContext){
      String session_code = context.parameter("session_code");
      _logger.debug(this, "Month", "Marketer achievements first30 days begin. (session={1})", session_code);
      // 获取session验证,获取理财师
      FDataFinancialMarketerUnit marketer = checkMarketerBySession(context, logicContext, session_code);
      if(marketer == null){
         return EResult.Failure;
      }
      // 获取客户总数
      FXmlNode achievementsTotal = output.config().createNode("CountTotal");
      achievementsTotal.createNode("total", RString.parse(marketer.customerInvestmentTotal()));
      // 获取前30天的投资情况
      FXmlNode achievementsForMonth = output.config().createNode("First30Days");
      int first30Days = 31;
      for(int i = 1; i < first30Days; i++){
         FXmlNode month = achievementsForMonth.createNode("day" + i);
         month.createNode("date", "2015-10-20");
         month.createNode("count", "2");
      }
      return EResult.Success;
   }

   // ============================================================
   // <T>获取所有客户的行为</T>
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
      _logger.debug(this, "Month", "Marketer achievements first30 days begin. (session={1})", session_code);
      // 获取session验证,获取理财师
      FDataFinancialMarketerUnit marketer = checkMarketerBySession(context, logicContext, session_code);
      if(marketer == null){
         return EResult.Failure;
      }
      FXmlNode ActionList = output.config().createNode("ActionList");
      for(int i = 0; i < 5; i++){
         FXmlNode action = ActionList.createNode();
         action.createNode("customer_name", "张三" + i);
         action.createNode("action_date", "2015-10-30");
         action.createNode("action_content", "登录系统...");
      }
      return EResult.Success;
   }

   // ============================================================
   // <T>获取每一个产品的业绩</T>
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
      _logger.debug(this, "Month", "Marketer achievements fetch products begin. (session={1})", session_code);
      // 获取session验证,获取理财师
      FDataFinancialMarketerUnit marketer = checkMarketerBySession(context, logicContext, session_code);
      if(marketer == null){
         return EResult.Failure;
      }
      for(int i = 0; i < 8; i++){
         FXmlNode month = output.config().createNode("products");
         month.createNode("product_name", "e租财富");
         month.createNode("product_rate", "12");
         month.createNode("investment_total", "20000050");
         month.createNode("product_occupancy", "12");
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
         _logger.debug(this, "Month", "Marketer achievements first30 days, session is not exists. (session_code={1})", sessionCode);
         return null;
      }
      //获取理财师
      FDataFinancialMarketerUnit marketer = _marketerConsole.findByUserId(logicContext, sessionInfo.userId());
      if(marketer == null){// 当前用户不是理财师
         context.messages().push(new FGcErrorMessage(RString.parse(sessionInfo.userId()), "当前用户还不是理财师不存在", RString.parse(sessionInfo.userId())));
         _logger.debug(this, "Month", "Marketer achievements first30 days, this user is not marketer. (userId={1})", RString.parse(sessionInfo.userId()));
         return null;
      }
      return marketer;
   }
}
