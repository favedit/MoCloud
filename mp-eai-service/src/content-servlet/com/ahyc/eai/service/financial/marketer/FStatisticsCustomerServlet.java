package com.ahyc.eai.service.financial.marketer;

import com.ahyc.eai.core.common.REaiPersonCard;
import com.ahyc.eai.core.financial.FFinancialTenderModel;
import com.ahyc.eai.core.financial.IFinancialConsole;
import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialCustomerUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialPhaseLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialPhaseUnit;
import org.mo.cloud.logic.data.common.configuration.IGcConfigurationConsole;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RDouble;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.core.common.EEaiDataConnection;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>理财师信息处理。</T>
//============================================================
public class FStatisticsCustomerServlet
      extends FAbstractStatisticsServlet
      implements
         IStatisticsCustomerServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FStatisticsCustomerServlet.class);

   // 资源访问接口
   private static IResource _resource = RResource.find(FStatisticsCustomerServlet.class);

   // 配置控制台
   @ALink
   protected IGcConfigurationConsole _configurationConsole;

   // 金融控制台
   @ALink
   protected IFinancialConsole _financialConsole;

   //============================================================
   // <T>获得投资类型集合。</T>
   //
   // @param logicContext 逻辑环境
   // @return 投资类型集合
   //============================================================
   public FDictionary<Double> fetchModels(ILogicContext logicContext){
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.STATISTICS);
      FSql sql = _resource.findString(FSql.class, "sql.dynamic.tender.model");
      FDictionary<Double> models = new FDictionary<Double>(Double.class);
      FDataset dataset = connection.fetchDataset(sql);
      for(FRow row : dataset){
         String tenderModel = row.get("tender_model");
         double investmentTotal = row.getDouble("investment_total");
         if(!RString.isEmpty(tenderModel)){
            models.set(tenderModel, new Double(investmentTotal));
         }
      }
      return models;
   }

   //============================================================
   // <T>获得实时动态数据。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult dynamic(IWebContext context,
                          ILogicContext logicContext,
                          IWebServletRequest request,
                          IWebServletResponse response){
      // 检查参数
      if(!checkParameters(context, request, response)){
         return EResult.Failure;
      }
      // 检查参数
      String beginSource = context.parameter("begin");
      String endSource = context.parameter("end");
      boolean first = context.parameterAsBoolean("first");
      if(RString.isEmpty(beginSource) || RString.isEmpty(endSource)){
         throw new FFatalError("Parameter is invalid.");
      }
      if((beginSource.length() != 14) || (endSource.length() != 14)){
         throw new FFatalError("Parameter length is invalid.");
      }
      // 限制查询范围最大10分钟
      TDateTime beginDate = new TDateTime(beginSource);
      TDateTime endDate = new TDateTime(endSource);
      long span = endDate.get() - beginDate.get();
      if((span < 0) && (span > 1000 * 600)){
         throw new FFatalError("Parameter span is invalid.");
      }
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "dynamic|" + beginSource + "-" + endSource;
      if(!first){
         FByteStream cacheStream = findCacheStream(cacheCode);
         if(cacheStream != null){
            return sendStream(context, request, response, cacheStream);
         }
      }
      //............................................................
      TDateTime currentDate = RDateTime.currentDateTime();
      // 设置输出流
      FByteStream stream = createStream(context);
      ISqlConnection connection = logicContext.activeConnection("statistics");
      // 获得银行年化利率
      float annualizedRate = _configurationConsole.getParameterAsFloat(logicContext, "eai.financial.bank.annualized.rate");
      // 输出当日合计数据
      FSql sumSql = _resource.findString(FSql.class, "sql.dynamic.sum");
      sumSql.bindDateTime("date", endDate, "YYYYMMDD");
      FRow sumRow = connection.find(sumSql);
      stream.writeDouble(RDouble.roundHalf(sumRow.getDouble("investment_count"), 2));
      stream.writeDouble(RDouble.roundHalf(sumRow.getDouble("investment_total"), 2));
      stream.writeInt32(sumRow.getInt("customer_count"));
      stream.writeInt32(sumRow.getInt("customer_total"));
      //............................................................
      // 输出排行数据
      FSql rankSql = _resource.findString(FSql.class, "sql.dynamic.rank");
      rankSql.bindDateTime("date", endDate, "YYYYMMDD");
      FDataset rankDataset = connection.fetchDataset(rankSql);
      int rankCount = rankDataset.count();
      stream.writeInt32(rankCount);
      for(FRow row : rankDataset){
         stream.writeString(RString.left(row.get("customer_label"), 1));
         stream.writeString(REaiPersonCard.makeCityCard(row.get("customer_card")));
         stream.writeString(RString.right(row.get("customer_phone"), 4));
         stream.writeDouble(RDouble.roundHalf(row.getDouble("investment_total"), 2));
      }
      //............................................................
      // 输出投资人数
      // FSql countSql = _resource.findString(FSql.class, "sql.dynamic.investment.count");
      // FRow countRow = connection.find(countSql);
      // stream.writeInt32(countRow.getInt("investment_1w"));
      // stream.writeInt32(countRow.getInt("investment_10w"));
      // stream.writeInt32(countRow.getInt("investment_50w"));
      // stream.writeInt32(countRow.getInt("investment_100w"));
      // stream.writeInt32(countRow.getInt("investment_500w"));
      // stream.writeInt32(countRow.getInt("investment_1000w"));
      stream.writeInt32(0);
      stream.writeInt32(0);
      stream.writeInt32(0);
      stream.writeInt32(0);
      stream.writeInt32(0);
      stream.writeInt32(0);
      //............................................................
      // 输出即时数据[倒序获得，正序写入]
      FStatisticsFinancialDynamicLogic dynamicLogic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
      FStatisticsFinancialCustomerLogic customerLogic = logicContext.findLogic(FStatisticsFinancialCustomerLogic.class);
      FLogicDataset<FStatisticsFinancialDynamicUnit> dynamicDataset = null;
      FSql whereSql = new FSql();
      whereSql.append("CUSTOMER_ACTION_CD=1 AND CUSTOMER_ACTION_DATE >= STR_TO_DATE({begin_date},'%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE < STR_TO_DATE({end_date},'%Y%m%d%H%i%s')");
      if(first){
         whereSql.bindDateTime("begin_date", beginDate, "YYYYMMDD000000");
         whereSql.bindDateTime("end_date", endDate);
         dynamicDataset = dynamicLogic.fetch(whereSql, "CUSTOMER_ACTION_DATE DESC", 30, 0);
      }else{
         whereSql.bindDateTime("begin_date", beginDate);
         whereSql.bindDateTime("end_date", endDate);
         dynamicDataset = dynamicLogic.fetch(whereSql, "CUSTOMER_ACTION_DATE DESC");
      }
      int count = dynamicDataset.count();
      stream.writeInt32(count);
      for(int n = count - 1; n >= 0; n--){
         FStatisticsFinancialDynamicUnit dynamicUnit = dynamicDataset.get(n);
         TDateTime investmentDate = dynamicUnit.customerActionDate();
         double investmentAmount = dynamicUnit.customerActionAmount();
         // 查找用户信息
         boolean investmentFirst = false;
         int investmentNumber = 0;
         long customerId = dynamicUnit.customerId();
         FStatisticsFinancialCustomerUnit customerUnit = customerLogic.find(customerId);
         if(customerUnit != null){
            if(customerUnit.investmentFirstDate().equals(investmentDate)){
               investmentFirst = true;
               investmentNumber = customerUnit.investmentNumber();
            }
         }
         // 计算投资年化盈利
         double investmentGain = 0;
         String investmentTenderPriorLabel = null;
         String investmentTenderPriorCode = dynamicUnit.tenderPriorModel();
         FFinancialTenderModel tenderPriorModel = _financialConsole.findTenderModel(investmentTenderPriorCode);
         if(tenderPriorModel != null){
            investmentTenderPriorLabel = tenderPriorModel.label();
         }
         String investmentTenderCode = dynamicUnit.tenderModel();
         String investmentTenderLabel = null;
         FFinancialTenderModel tenderModel = _financialConsole.findTenderModel(investmentTenderCode);
         if(tenderModel != null){
            investmentTenderLabel = tenderModel.label();
            investmentGain = tenderModel.calculateYearGain(investmentAmount, currentDate);
         }
         double investmentBankGain = investmentAmount * annualizedRate;
         // 输出内容
         stream.writeString(dynamicUnit.customerActionDate().format());
         stream.writeString(RString.left(dynamicUnit.customerLabel(), 1));
         stream.writeString(REaiPersonCard.makeCityCard(dynamicUnit.customerCard()));
         stream.writeString(RString.right(dynamicUnit.customerPhone(), 4));
         stream.writeBoolean(investmentFirst);
         stream.writeUint16(investmentNumber);
         stream.writeBoolean(dynamicUnit.tenderChanged());
         stream.writeString(investmentTenderPriorCode);
         stream.writeString(investmentTenderPriorLabel);
         stream.writeString(investmentTenderCode);
         stream.writeString(investmentTenderLabel);
         stream.writeDouble(RDouble.roundHalf(investmentAmount, 2));
         stream.writeDouble(RDouble.roundHalf(investmentGain, 2));
         stream.writeDouble(RDouble.roundHalf(investmentBankGain, 2));
      }
      //............................................................
      // 保存数据到缓冲中
      if(!first){
         updateCacheStream(cacheCode, stream);
      }
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send marketer customer dynamic. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
      return sendStream(context, request, response, stream);
   }

   //============================================================
   // <T>获得投资产品数据。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult tender(IWebContext context,
                         ILogicContext logicContext,
                         IWebServletRequest request,
                         IWebServletResponse response){
      // 检查参数
      if(!checkParameters(context, request, response)){
         return EResult.Failure;
      }
      //............................................................
      TDateTime currentDateTime = RDateTime.currentDateTime();
      currentDateTime.truncateMinute();
      // 从缓冲中查找数据
      String cacheCode = "info|" + currentDateTime.format();
      //............................................................
      // 设置输出流
      FByteStream stream = createStream(context);
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.STATISTICS);
      ISqlConnection connectionEzubo = logicContext.activeConnection(EEaiDataConnection.EZUBAO);
      //............................................................
      // 获得模式数据
      FDictionary<Double> models = fetchModels(logicContext);
      //............................................................
      // 输出排行数据
      FSql infoSql = _resource.findString(FSql.class, "sql.dynamic.tender");
      FDataset infoDataset = connectionEzubo.fetchDataset(infoSql);
      int infoCount = infoDataset.count();
      stream.writeInt32(infoCount);
      for(FRow row : infoDataset){
         long tenderLinkId = row.getLong("id");
         String tenderCode = row.get("borrow_model");
         double investmentTotal = 0;
         // 获得项目信息
         String tenderLabel = null;
         float tenderRate = 0;
         FFinancialTenderModel tenderModel = _financialConsole.findTenderModel(tenderCode);
         if(tenderModel != null){
            tenderLabel = tenderModel.label();
            tenderRate = tenderModel.rate();
         }
         Double investmentTotalValue = models.get(tenderCode, null);
         if(investmentTotalValue != null){
            investmentTotal = investmentTotalValue.doubleValue();
         }
         // 获得项目当日投资
         FSql daySql = _resource.findString(FSql.class, "sql.tender.tender.day");
         daySql.bindLong("link_id", tenderLinkId);
         daySql.bindDateTime("date", currentDateTime, "YYYYMMDD");
         double investmentDay = connection.executeDouble(daySql);
         // 写入行数据
         stream.writeString(tenderCode);
         stream.writeString(tenderLabel);
         stream.writeFloat(tenderRate);
         stream.writeDouble(RDouble.roundHalf(row.getDouble("has_borrow"), 2));
         stream.writeDouble(RDouble.roundHalf(row.getDouble("borrow_money"), 2));
         stream.writeDouble(RDouble.roundHalf(investmentDay, 2));
         stream.writeDouble(RDouble.roundHalf(investmentTotal, 2));
      }
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send statistics tender info. (date={1}, count={2}, data_length={3})", currentDateTime.format(), infoCount, dataLength);
      return sendStream(context, request, response, stream);
   }

   //============================================================
   // <T>上传处理。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult trend(IWebContext context,
                        ILogicContext logicContext,
                        IWebServletRequest request,
                        IWebServletResponse response){
      // 检查参数
      if(!checkParameters(context, request, response)){
         return EResult.Failure;
      }
      // 检查参数
      String beginSource = context.parameter("begin");
      String endSource = context.parameter("end");
      if(RString.isEmpty(beginSource) || RString.isEmpty(endSource)){
         throw new FFatalError("Parameter is invalid.");
      }
      // 限制查询范围最大10分钟
      TDateTime beginDate = new TDateTime(beginSource);
      TDateTime endDate = new TDateTime(endSource);
      long dateSpan = endDate.get() - beginDate.get();
      if((dateSpan < 0) || (dateSpan > 1000 * 3600 * 24 * 7)){
         throw new FFatalError("Parameter span is invalid.");
      }
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "trend|" + beginSource + "-" + endSource;
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      // 设置输出流
      FByteStream stream = createStream(context);
      // 输出总计数据
      FStatisticsFinancialPhaseLogic phaseLogic = logicContext.findLogic(FStatisticsFinancialPhaseLogic.class);
      FSql phaseWhereSql = new FSql();
      phaseWhereSql.append("RECORD_DATE > STR_TO_DATE({begin_date},'%Y%m%d%H%i%s') AND RECORD_DATE <= STR_TO_DATE({end_date},'%Y%m%d%H%i%s')");
      phaseWhereSql.bindDateTime("begin_date", beginDate);
      phaseWhereSql.bindDateTime("end_date", endDate);
      FLogicDataset<FStatisticsFinancialPhaseUnit> phaseDataset = phaseLogic.fetch(phaseWhereSql, "RECORD_DATE ASC");
      // 计算阶段统计
      double investmentTotal = 0;
      int customerTotal = 0;
      for(FStatisticsFinancialPhaseUnit phaseUnit : phaseDataset){
         investmentTotal += phaseUnit.investment();
         customerTotal += phaseUnit.customerCount();
      }
      stream.writeDouble(RDouble.roundHalf(investmentTotal, 2));
      stream.writeUint32(customerTotal);
      // 输出数据集合
      int count = phaseDataset.count();
      stream.writeInt32(count);
      for(FStatisticsFinancialPhaseUnit phaseUnit : phaseDataset){
         stream.writeString(phaseUnit.recordDate().format());
         stream.writeDouble(RDouble.roundHalf(phaseUnit.investment(), 2));
         stream.writeUint32(phaseUnit.customerCount());
      }
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send marketer customer trend. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
      return sendStream(context, request, response, stream);
   }
}
