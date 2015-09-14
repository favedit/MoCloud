package com.ahyc.eai.service.financial.department;

import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicLogic;
import com.cyou.gccloud.data.statistics.FStatisticsFinancialDynamicUnit;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>理财师信息处理。</T>
//============================================================
public class FStatisticsDepartmentServlet
      extends FAbstractStatisticsServlet
      implements
         IStatisticsDepartmentServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FStatisticsDepartmentServlet.class);

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
      // 获得当日排行榜3名数据
      //............................................................
      // 获得指定时间段内的数据
      FStatisticsFinancialDynamicLogic dynamicLogic = logicContext.findLogic(FStatisticsFinancialDynamicLogic.class);
      String whereSql = "CUSTOMER_ACTION_DATE >= STR_TO_DATE('{1}','%Y%m%d%H%i%s') AND CUSTOMER_ACTION_DATE < STR_TO_DATE('{2}','%Y%m%d%H%i%s')";
      FLogicDataset<FStatisticsFinancialDynamicUnit> dynamicDataset = dynamicLogic.fetch(RString.format(whereSql, beginDate.format(), endDate.format()), "CUSTOMER_ACTION_DATE");
      FByteStream stream = new FByteStream();
      int count = dynamicDataset.count();
      stream.writeInt32(count);
      for(FStatisticsFinancialDynamicUnit dynamicUnit : dynamicDataset){
         stream.writeString(dynamicUnit.departmentLabel());
         stream.writeString(dynamicUnit.marketerLabel());
         stream.writeInt32(dynamicUnit.customerActionCd());
         stream.writeString(dynamicUnit.customerLabel());
         stream.writeString(RString.left(dynamicUnit.customerCard(), 4));
         stream.writeString(RString.right(dynamicUnit.customerPhone(), 4));
      }
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send statistics marketer dynamic. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
      //............................................................
      // 发送数据
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
      String beginSource = context.parameter("begin_date");
      String endSource = context.parameter("end_date");
      //String span = context.parameter("span");
      if(RString.isEmpty(beginSource) || RString.isEmpty(endSource)){
         throw new FFatalError("Parameter is invalid.");
      }
      // 限制查询范围最大10分钟
      TDateTime beginDate = new TDateTime(beginSource);
      TDateTime endDate = new TDateTime(endSource);
      long dateSpan = endDate.get() - beginDate.get();
      if((dateSpan < 0) || (dateSpan > 1000 * 3600 * 24)){
         throw new FFatalError("Parameter span is invalid.");
      }
      //............................................................
      FByteStream stream = new FByteStream();
      //............................................................
      // 发送数据
      return sendStream(context, request, response, stream);
   }
}
