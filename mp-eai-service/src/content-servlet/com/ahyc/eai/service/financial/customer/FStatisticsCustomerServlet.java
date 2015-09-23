package com.ahyc.eai.service.financial.customer;

import com.ahyc.eai.core.common.EDatabaseConnection;
import com.ahyc.eai.core.financial.FFinancialTenderModel;
import com.ahyc.eai.core.financial.IFinancialConsole;
import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
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
   // <T>逻辑处理。</T>
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
         stream.writeString(RString.left(row.get("customer_card"), 4));
         stream.writeString(RString.right(row.get("customer_phone"), 4));
         stream.writeDouble(RDouble.roundHalf(row.getDouble("investment_total"), 2));
      }
      //............................................................
      // 输出即时数据[倒序获得，正序写入]
      //FStatisticsFinancialCustomerLogic customerLogic = logicContext.findLogic(FStatisticsFinancialCustomerLogic.class);
      FStatisticsFinancialDynamicLogic dynamicLogic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
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
         FStatisticsFinancialDynamicUnit dynamicUnit = dynamicDataset.at(n);
         //TDateTime investmentDate = dynamicUnit.customerActionDate();
         double investmentAmount = dynamicUnit.customerActionAmount();
         //         // 查找用户信息
         //         long customerId = dynamicUnit.customerId();
         //         FStatisticsFinancialCustomerUnit customerUnit = customerLogic.find(customerId);
         //         boolean investmentFirst = false;
         //         int investmentNumber = 0;
         //         if(customerUnit != null){
         //            if(customerUnit.investmentFirstDate().equals(investmentDate)){
         //               investmentFirst = true;
         //               investmentNumber = customerUnit.investmentNumber();
         //            }
         //         }
         // 计算投资年化盈利
         double investmentGain = 0;
         String investmentTenderLabel = null;
         FFinancialTenderModel tenderModel = _financialConsole.findTenderModel(dynamicUnit.tenderModel());
         if(tenderModel != null){
            investmentTenderLabel = tenderModel.label();
            investmentGain = tenderModel.calculateYearGain(investmentAmount, currentDate);
         }
         // 计算银行
         double investmentBankGain = investmentAmount * annualizedRate;
         // 输出内容
         stream.writeString(dynamicUnit.customerActionDate().format());
         stream.writeString(RString.left(dynamicUnit.customerLabel(), 1));
         stream.writeString(RString.left(dynamicUnit.customerCard(), 4));
         stream.writeString(RString.right(dynamicUnit.customerPhone(), 4));
         stream.writeBoolean(false);
         stream.writeUint16(0);
         //         stream.writeBoolean(investmentFirst);
         //         stream.writeUint16(investmentNumber);
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
      _logger.debug(this, "process", "Send statistics customer dynamic. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
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
      _logger.debug(this, "process", "Send statistics customer trend. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
      return sendStream(context, request, response, stream);
   }

   //============================================================
   // <T>获得投资产品动态数据。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult tenderDynamic(IWebContext context,
                                ILogicContext logicContext,
                                IWebServletRequest request,
                                IWebServletResponse response){
      return null;
   }

   //============================================================
   // <T>获得省份分析数据数据。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult province(IWebContext context,
                           ILogicContext logicContext,
                           IWebServletRequest request,
                           IWebServletResponse response){
      // 检查参数
      if(!checkParameters(context, request, response)){
         return EResult.Failure;
      }
      // 检查参数
      String beginSource = context.parameter("begin");
      if(RString.isEmpty(beginSource)){
         beginSource = "20140101000000";
      }else if(beginSource.length() != 14){
         throw new FFatalError("Parameter begin date is invalid.");
      }
      String endSource = context.parameter("end");
      if(RString.isEmpty(endSource)){
         endSource = RDateTime.format();
      }else if(endSource.length() != 14){
         throw new FFatalError("Parameter begin date is invalid.");
      }
      TDateTime beginDate = new TDateTime(beginSource);
      TDateTime endDate = new TDateTime(endSource);
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "province|" + beginSource + "-" + endSource;
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      // 设置输出流
      FByteStream stream = createStream(context);
      ISqlConnection connection = logicContext.activeConnection(EDatabaseConnection.Statistics);
      // 输出排行数据
      FSql sql = _resource.findString(FSql.class, "sql.customer.province");
      sql.bindDateTime("begin_date", beginDate);
      sql.bindDateTime("end_date", endDate);
      FDataset dataset = connection.fetchDataset(sql);
      // 写入总数
      int customerTotal = 0;
      double investmentTotal = 0;
      for(FRow row : dataset){
         customerTotal += row.getInteger("customer_count");
         investmentTotal += row.getDouble("investment_total");
      }
      double investmentAvg = investmentTotal / customerTotal;
      stream.writeDouble(RDouble.roundHalf(investmentTotal, 2));
      stream.writeUint32(customerTotal);
      stream.writeDouble(RDouble.roundHalf(investmentAvg, 2));
      // 写入详细
      int count = dataset.count();
      stream.writeInt32(count);
      for(FRow row : dataset){
         String provinceCode = row.get("province_code");
         stream.writeString(provinceCode);
         stream.writeString(provinceCode);
         stream.writeDouble(RDouble.roundHalf(row.getDouble("investment_total"), 2));
         stream.writeInt32(row.getInteger("customer_count"));
         stream.writeDouble(RDouble.roundHalf(row.getDouble("investment_avg"), 2));
      }
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send statistics customer province. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
      return sendStream(context, request, response, stream);
   }

   //============================================================
   // <T>获得年龄分析数据数据。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult age(IWebContext context,
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
      if((beginSource.length() != 14) || (endSource.length() != 14)){
         throw new FFatalError("Parameter length is invalid.");
      }
      // 限制查询范围最大10分钟
      TDateTime beginDate = new TDateTime(beginSource);
      TDateTime endDate = new TDateTime(endSource);
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "age|" + beginSource + "-" + endSource;
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      // 设置输出流
      FByteStream stream = createStream(context);
      ISqlConnection connection = logicContext.activeConnection(EDatabaseConnection.Statistics);
      // 输出排行数据
      FSql sql = _resource.findString(FSql.class, "sql.customer.province");
      sql.bindInteger("year", endDate.year());
      sql.bindDateTime("begin_date", beginDate);
      sql.bindDateTime("end_date", endDate);
      FDataset dataset = connection.fetchDataset(sql);
      int count = dataset.count();
      // 写入总数
      //      int customerTotal = 0;
      //      for(FRow row : dataset){
      //         customerTotal += row.getInteger("customer_count");
      //      }
      //      stream.writeUint32(customerTotal);
      // 写入详细
      stream.writeInt32(count);
      for(FRow row : dataset){
         stream.writeInt32(row.getInteger("customer_age"));
         stream.writeInt32(row.getInteger("customer_year"));
         stream.writeInt32(row.getInteger("customer_count"));
         stream.writeInt32(row.getInteger("male_count"));
         stream.writeInt32(row.getInteger("female_count"));
         stream.writeDouble(RDouble.roundHalf(row.getDouble("investment_total"), 2));
         stream.writeDouble(RDouble.roundHalf(row.getDouble("investment_avg"), 2));
      }
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send statistics customer age. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
      return sendStream(context, request, response, stream);
   }
}
