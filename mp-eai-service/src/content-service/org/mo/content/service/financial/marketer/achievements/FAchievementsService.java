package org.mo.content.service.financial.marketer.achievements;

import com.cyou.gccloud.data.data.FDataFinancialCustomerTenderUnit;
import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import com.cyou.gccloud.define.enums.financial.EGcFinancialCustomerAction;
import org.mo.cloud.core.message.FGcErrorMessage;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.financial.customer.FDataCustomerProductInfo;
import org.mo.content.core.financial.customer.IDataCustomerConsole;
import org.mo.content.core.financial.customer.tender.IDataCustomerTenderConsole;
import org.mo.content.core.financial.marketer.IDataMarketerConsole;
import org.mo.content.core.statistics.financial.dynamic.IStatisticsDynamicConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
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

   // 客户投资产品控制器
   @ALink
   protected IDataCustomerTenderConsole _customerTenderConsole;

   // 理财师客户投资控制器
   @ALink
   protected IDataCustomerConsole _customerConsole;

   // 客户业务动态控制器
   @ALink
   protected IStatisticsDynamicConsole _dynamicConsole;

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
      FXmlNode achievementsTotal = output.config().createNode("achievements_total");
      achievementsTotal.createNode("investment_total", RString.parse(marketer.customerInvestmentTotal()));
      achievementsTotal.createNode("investment_count", RString.parse(marketer.customerInvestmentCount()));
      achievementsTotal.createNode("redemption_total", RString.parse(marketer.customerRedemptionTotal()));
      achievementsTotal.createNode("redemption_count", RString.parse(marketer.customerRedemptionCount()));
      achievementsTotal.createNode("netinvestment_total", RString.parse(marketer.customerNetinvestmentTotal()));
      // 获取前30天的投资情况

      FXmlNode achievementsForMonth = output.config().createNode("achievements_first30_days");
      int first30Days = 31;
      String time = null;
      TDateTime nowTime = null;
      double investmentDay = 0;
      double redemptionDay = 0;
      double netinvestmentDay = 0;
      for(int i = 1; i < first30Days; i++){
         investmentDay = 0;
         redemptionDay = 0;
         netinvestmentDay = 0;
         nowTime = new TDateTime(RDateTime.currentDateTime());
         nowTime.addDay(-(first30Days - i));
         time = nowTime.format("yyyy-mm-dd");
         //获取 指定日期的数据
         FLogicDataset<FDataFinancialCustomerTenderUnit> customerInvestmentDay = _customerTenderConsole.fetchByDay(logicContext, time);
         if(customerInvestmentDay != null){
            for(FDataFinancialCustomerTenderUnit unit : customerInvestmentDay){
               if(unit != null){
                  investmentDay += unit.investment();
                  redemptionDay += unit.redemption();
                  netinvestmentDay += unit.netinvestment();
               }
            }
         }
         FXmlNode month = achievementsForMonth.createNode("day" + i);
         month.createNode("date", time);
         month.createNode("investment_day", RString.parse(investmentDay));
         month.createNode("redemption_day", RString.parse(redemptionDay));
         month.createNode("netinvestment_day", RString.parse(netinvestmentDay));
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
      _logger.debug(this, "FetchCount", "Marketer achievements fetch count begin. (session={1})", session_code);
      // 获取session验证,获取理财师
      FDataFinancialMarketerUnit marketer = checkMarketerBySession(context, logicContext, session_code);
      if(marketer == null){
         return EResult.Failure;
      }
      // 获取客户总数
      output.config().createNode("count_total", RString.parse(marketer.customerInvestmentTotal()));
      // 获取前30天的投资情况
      FXmlNode achievementsForMonth = output.config().createNode("first30_days");
      int first30Days = 31;
      String time = null;
      TDateTime nowTime = null;
      int count = 0;
      for(int i = 1; i < first30Days; i++){
         count = 0;
         nowTime = new TDateTime(RDateTime.currentDateTime());
         nowTime.addDay(-(first30Days - i));
         time = nowTime.format("yyyy-mm-dd");

      }
      return EResult.Success;
   }

   // ============================================================
   // <T>获取所有客户的金融行为</T>
   // @param context 页面环境
   // @sessionContext 会话session上下文
   // @param input 输入配置
   // @param output 输出配置
   // @logicContext 逻辑上下文
   // @return 处理结果
   // ============================================================
   @Override
   public EResult fetchBusinessActions(IWebContext context,
                                       IWebSession sessionContext,
                                       IWebInput input,
                                       IWebOutput output,
                                       ILogicContext logicContext){
      String session_code = context.parameter("session_code");
      _logger.debug(this, "FetchActions", "Marketer achievements fetch actions begin. (session={1})", session_code);
      // 获取session验证,获取理财师
      FDataFinancialMarketerUnit marketer = checkMarketerBySession(context, logicContext, session_code);
      if(marketer == null){
         return EResult.Failure;
      }
      FLogicDataset<FStatisticsFinancialDynamicUnit> dynmicList = _dynamicConsole.fetchByMarketerId(logicContext, marketer.statisticsId());
      FXmlNode ActionList = output.config().createNode("action_list");
      if(dynmicList.count() < 1){
         ActionList.setText("0");
         return EResult.Success;
      }
      for(FStatisticsFinancialDynamicUnit unit : dynmicList){
         FXmlNode action = ActionList.createNode();
         action.createNode("customer_name", unit.customerLabel());
         action.createNode("action_date", RString.parse(unit.customerActionDate()));
         // 拼接内容
         StringBuffer content = new StringBuffer();
         content.append(EGcFinancialCustomerAction.formatLabel(unit.customerActionCd()));
         content.append(unit.customerActionAmount());
         content.append("元。");
         action.createNode("action_content", content.toString());
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
      _logger.debug(this, "FetchProducts", "Marketer achievements fetch products begin. (session={1})", session_code);
      // 获取session验证,获取理财师
      FDataFinancialMarketerUnit marketer = checkMarketerBySession(context, logicContext, session_code);
      if(marketer == null){
         return EResult.Failure;
      }

      FXmlNode products = output.config().createNode("product_list");
      FLogicDataset<FDataCustomerProductInfo> mcList = _customerConsole.fetchProductInvestmentByMarketerId(logicContext, marketer.ouid());
      if(mcList.count() < 1){
         products.setText("0");
         return EResult.Success;
      }
      double occupancy = 0;
      double occupancy_total = 0;
      for(FDataCustomerProductInfo unit : mcList){
         occupancy_total += unit.investmentTotal();

      }
      for(FDataCustomerProductInfo unit : mcList){
         // 为空的话，直接抛弃本条数据。
         if(RString.isEmpty(unit.label())){
            continue;
         }
         occupancy = (unit.investmentTotal() / occupancy_total) * 100;
         FXmlNode product = products.createNode();
         product.createNode("product_name", unit.label());
         product.createNode("product_rate", RString.parse(unit.rate()));
         product.createNode("investment_total", RString.parse(unit.investmentTotal()));
         product.createNode("product_occupancy", RString.parse(occupancy));
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
         context.messages().push(new FGcErrorMessage(RString.parse(sessionInfo.userId()), "当前用户还不是理财师", RString.parse(sessionInfo.userId())));
         _logger.debug(this, "Achievements", "Marketer achievements check marketer, this user is not marketer. (userId={1})", RString.parse(sessionInfo.userId()));
         return null;
      }
      return marketer;
   }
}
