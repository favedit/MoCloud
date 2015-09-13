package com.ahyc.eai.service.financial.department;

import com.ahyc.eai.core.common.IDepartmentConsole;
import com.ahyc.eai.core.common.IProvinceConsole;
import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import com.cyou.gccloud.data.data.FDataCommonProvinceUnit;
import com.cyou.gccloud.data.data.FDataFinancialDepartmentUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialPhaseLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialPhaseUnit;
import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
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
public class FStatisticsMarketerServlet
      extends FAbstractStatisticsServlet
      implements
         IStatisticsMarketerServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FStatisticsMarketerServlet.class);

   // 日志输出接口
   private static IResource _resource = RResource.find(FStatisticsMarketerServlet.class);

   @ALink
   protected static IDepartmentConsole _departmentConsole;

   @ALink
   protected static IProvinceConsole _provinceConsole;

   //============================================================
   // <T>获得理财师组织数据。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult organization(IWebContext context,
                               ILogicContext logicContext,
                               IWebServletRequest request,
                               IWebServletResponse response){
      // 检查参数
      if(!checkParameters(context, request, response)){
         return EResult.Failure;
      }
      // 分公司资源
      FDictionary<FDataFinancialDepartmentUnit> departments = new FDictionary<FDataFinancialDepartmentUnit>(FDataFinancialDepartmentUnit.class);
      FLogicDataset<FDataFinancialDepartmentUnit> departmentDataset = _departmentConsole.fetch(logicContext, null);
      if(departmentDataset != null){
         for(FDataFinancialDepartmentUnit unit : departmentDataset){
            if(unit.linkId() != 0){
               departments.set(RLong.toString(unit.linkId()), unit);
            }
         }
      }
      // 省份资源
      FDictionary<FDataCommonProvinceUnit> provinces = new FDictionary<FDataCommonProvinceUnit>(FDataCommonProvinceUnit.class);
      FLogicDataset<FDataCommonProvinceUnit> provinceDataset = _provinceConsole.fetch(logicContext, null);
      if(provinceDataset != null){
         for(FDataCommonProvinceUnit unit : provinceDataset){
            provinces.set(RLong.toString(unit.ouid()), unit);
         }
      }
      //............................................................
      // 从缓冲中查找数据
      TDateTime currentDate = RDateTime.currentDateTime();
      String dateSource = currentDate.format("YYYYMMDDHH24MI00");
      String cacheCode = "organization|" + dateSource;
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      // 设置输出流
      FByteStream stream = createStream(context);
      ISqlConnection connection = logicContext.activeConnection("statistics");
      // 输出级别2的部门数据
      FSql level2Sql = _resource.findString(FSql.class, "sql.organization.level2");
      FDataset level2Dataset = connection.fetchDataset(level2Sql);
      int level2Count = level2Dataset.count();
      stream.writeInt32(level2Count);
      for(FRow row : level2Dataset){
         stream.writeUint32(row.getInt("id"));
         stream.writeString(row.get("label"));
         stream.writeUint32(row.getInt("marketer_count"));
         stream.writeDouble(row.getDouble("investment_total"));
         stream.writeDouble(row.getDouble("redemption_total"));
         stream.writeDouble(row.getDouble("netinvestment_total"));
         stream.writeDouble(0);
      }
      // 输出级别4的部门数据
      FSql level4Sql = _resource.findString(FSql.class, "sql.organization.level4");
      FDataset level4Dataset = connection.fetchDataset(level4Sql);
      int level4Count = level4Dataset.count();
      stream.writeInt32(level4Count);
      for(FRow row : level4Dataset){
         // 获取省份代码
         int provinceCode = 0;
         long linkId = row.getLong("id");
         FDataFinancialDepartmentUnit departmentUnit = departments.find(RLong.toString(linkId));
         if(departmentUnit != null){
            FDataCommonProvinceUnit province = provinces.find(RInteger.toString((departmentUnit.provinceId())));
            if(province != null){
               provinceCode = RInteger.parse(province.code());
            }
         }
         //............................................................
         stream.writeUint16(provinceCode);
         stream.writeUint32(linkId);
         stream.writeString(row.get("parent_label"));
         stream.writeString(row.get("label"));
         stream.writeUint32(row.getInt("marketer_count"));
         stream.writeDouble(row.getDouble("investment_total"));
         stream.writeDouble(row.getDouble("redemption_total"));
         stream.writeDouble(row.getDouble("netinvestment_total"));
         stream.writeDouble(0);
      }
      //释放资源
      departments.clear();
      provinces.clear();
      // 输出理财师分布数据
      FSql areaSql = _resource.findString(FSql.class, "sql.organization.area");
      FDataset areaDataset = connection.fetchDataset(areaSql);
      int areaCount = 0;
      for(FRow row : areaDataset){
         String card = row.get("marketer_card");
         if(!RString.isEmpty(card)){
            if(card.length() == 4){
               areaCount++;
            }
         }
      }
      stream.writeInt32(areaCount);
      for(FRow row : areaDataset){
         String card = row.get("marketer_card");
         if(!RString.isEmpty(card)){
            if(card.length() == 4){
               stream.writeUint32(row.getInt("marketer_card"));
               stream.writeUint32(row.getInt("marketer_count"));
               stream.writeDouble(row.getDouble("investment_total"));
               stream.writeDouble(row.getDouble("redemption_total"));
               stream.writeDouble(row.getDouble("netinvestment_total"));
               stream.writeDouble(0);
            }
         }
      }
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "organization", "Send marketer organization. (level2_count={1}, level4_count={2}, area_count={3}, data_length={4})", level2Count, level4Count, areaCount, dataLength);
      return sendStream(context, request, response, stream);
   }

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
      if(RString.isEmpty(beginSource) || RString.isEmpty(endSource)){
         throw new FFatalError("Parameter is invalid.");
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
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      // 设置输出流
      FByteStream stream = createStream(context);
      ISqlConnection connection = logicContext.activeConnection("statistics");
      // 输出当日合计数据
      FSql statisticsSql = _resource.findString(FSql.class, "sql.dynamic.sum");
      statisticsSql.bindString("date", endDate.format("YYYYMMDD"));
      FRow statisticsRow = connection.find(statisticsSql);
      stream.writeDouble(statisticsRow.getDouble("investment_count"));
      stream.writeDouble(statisticsRow.getDouble("investment_total"));
      stream.writeDouble(statisticsRow.getDouble("redemption_count"));
      stream.writeDouble(statisticsRow.getDouble("redemption_total"));
      stream.writeDouble(statisticsRow.getDouble("netinvestment_count"));
      stream.writeDouble(statisticsRow.getDouble("netinvestment_total"));
      stream.writeDouble(statisticsRow.getDouble("interest_count"));
      stream.writeDouble(statisticsRow.getDouble("interest_total"));
      stream.writeDouble(statisticsRow.getDouble("performance_count"));
      stream.writeDouble(statisticsRow.getDouble("performance_total"));
      stream.writeInt32(statisticsRow.getInt("customer_count"));
      stream.writeInt32(statisticsRow.getInt("customer_total"));
      //............................................................
      // 输出日排行数据
      FSql rankDaySql = _resource.findString(FSql.class, "sql.dynamic.rank.day");
      rankDaySql.bindString("date", endDate.format("YYYYMMDD"));
      FDataset rankDayDataset = connection.fetchDataset(rankDaySql);
      stream.writeInt32(rankDayDataset.count());
      for(FRow row : rankDayDataset){
         stream.writeString(row.get("department_label"));
         stream.writeString(row.get("marketer_label"));
         stream.writeDouble(row.getDouble("investment_total"));
         stream.writeDouble(row.getDouble("redemption_total"));
         stream.writeDouble(row.getDouble("netinvestment_total"));
         stream.writeDouble(row.getDouble("interest_total"));
         stream.writeDouble(row.getDouble("performance_total"));
         stream.writeInt32(row.getInt("customer_count"));
         stream.writeInt32(row.getInt("customer_total"));
      }
      //............................................................
      // 输出周排行数据
      FSql rankWeekSql = _resource.findString(FSql.class, "sql.dynamic.rank.week");
      rankWeekSql.bindString("date", endDate.format("YYYYMMWK"));
      FDataset rankWeekDataset = connection.fetchDataset(rankWeekSql);
      stream.writeInt32(rankWeekDataset.count());
      for(FRow row : rankWeekDataset){
         stream.writeString(row.get("department_label"));
         stream.writeString(row.get("marketer_label"));
         stream.writeDouble(row.getDouble("investment_total"));
         stream.writeDouble(row.getDouble("redemption_total"));
         stream.writeDouble(row.getDouble("netinvestment_total"));
         stream.writeDouble(row.getDouble("interest_total"));
         stream.writeDouble(row.getDouble("performance_total"));
         stream.writeInt32(row.getInt("customer_count"));
         stream.writeInt32(row.getInt("customer_total"));
      }
      //............................................................
      // 输出月排行数据
      FSql rankMonthSql = _resource.findString(FSql.class, "sql.dynamic.rank.month");
      rankMonthSql.bindString("date", endDate.format("YYYYMM01"));
      FDataset rankMonthDataset = connection.fetchDataset(rankMonthSql);
      stream.writeInt32(rankMonthDataset.count());
      for(FRow row : rankMonthDataset){
         stream.writeString(row.get("department_label"));
         stream.writeString(row.get("marketer_label"));
         stream.writeDouble(row.getDouble("investment_total"));
         stream.writeDouble(row.getDouble("redemption_total"));
         stream.writeDouble(row.getDouble("netinvestment_total"));
         stream.writeDouble(row.getDouble("interest_total"));
         stream.writeDouble(row.getDouble("performance_total"));
         stream.writeInt32(row.getInt("customer_count"));
         stream.writeInt32(row.getInt("customer_total"));
      }
      //............................................................
      // 输出即时数据
      FStatisticsFinancialDynamicLogic dynamicLogic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
      String whereSql = "CUSTOMER_ACTION_DATE >= STR_TO_DATE('{1}','%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE < STR_TO_DATE('{2}','%Y%m%d%H%i%s')";
      FLogicDataset<FStatisticsFinancialDynamicUnit> dynamicDataset = dynamicLogic.fetch(RString.format(whereSql, beginDate.format(), endDate.format()), "CUSTOMER_ACTION_DATE");
      int count = dynamicDataset.count();
      stream.writeInt32(count);
      for(FStatisticsFinancialDynamicUnit dynamicUnit : dynamicDataset){
         stream.writeString(dynamicUnit.customerActionDate().format());
         stream.writeString(dynamicUnit.departmentLabel());
         stream.writeString(dynamicUnit.marketerLabel());
         stream.writeString(RString.left(dynamicUnit.customerLabel(), 1));
         stream.writeString(RString.left(dynamicUnit.customerCard(), 4));
         stream.writeString(RString.right(dynamicUnit.customerPhone(), 4));
         stream.writeUint8((byte)dynamicUnit.customerActionCd());
         stream.writeDouble(dynamicUnit.customerActionAmount());
         stream.writeDouble(dynamicUnit.customerActionInterest());
      }
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send statistics marketer dynamic. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
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
      if((dateSpan < 0) && (dateSpan > 1000 * 3600 * 24 * 7)){
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
      String phaseWhereSql = "RECORD_DATE > STR_TO_DATE('{1}','%Y%m%d%H%i%s') AND RECORD_DATE <= STR_TO_DATE('{2}','%Y%m%d%H%i%s')";
      FLogicDataset<FStatisticsFinancialPhaseUnit> phaseDataset = phaseLogic.fetch(RString.format(phaseWhereSql, beginDate.format(), endDate.format()), "RECORD_DATE ASC");
      // 计算阶段统计
      double investmentTotal = 0;
      double redemptionTotal = 0;
      double netinvestmentTotal = 0;
      double interestTotal = 0;
      double performanceTotal = 0;
      for(FStatisticsFinancialPhaseUnit phaseUnit : phaseDataset){
         investmentTotal += phaseUnit.investment();
         redemptionTotal += phaseUnit.redemption();
         netinvestmentTotal += phaseUnit.netinvestment();
         interestTotal += phaseUnit.interest();
         performanceTotal += phaseUnit.performance();
      }
      stream.writeDouble(investmentTotal);
      stream.writeDouble(redemptionTotal);
      stream.writeDouble(netinvestmentTotal);
      stream.writeDouble(interestTotal);
      stream.writeDouble(performanceTotal);
      // 输出数据集合
      int count = phaseDataset.count();
      stream.writeInt32(count);
      for(FStatisticsFinancialPhaseUnit phaseUnit : phaseDataset){
         stream.writeString(phaseUnit.recordDate().format());
         stream.writeDouble(phaseUnit.investment());
         stream.writeDouble(phaseUnit.redemption());
         stream.writeDouble(phaseUnit.netinvestment());
         stream.writeDouble(phaseUnit.interest());
         stream.writeDouble(phaseUnit.performance());
      }
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send statistics marketer trend. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
      return sendStream(context, request, response, stream);
   }
}
