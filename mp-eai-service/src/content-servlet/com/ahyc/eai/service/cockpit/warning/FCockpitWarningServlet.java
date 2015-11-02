package com.ahyc.eai.service.cockpit.warning;

import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import java.util.ArrayList;
import java.util.HashSet;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>阈值预警处理。</T>
//============================================================
public class FCockpitWarningServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitWarningServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitWarningServlet.class);

   // 资源访问接口
   //   private static IResource _resource = RResource.find(FCockpitWarningServlet.class);

   //============================================================
   // <T>阈值预警列表</T>
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult fetch(IWebContext context,
                        ILogicContext logicContext,
                        IWebServletRequest request,
                        IWebServletResponse response){
      _logger.debug(this, "fetch", "the method named fetch from FCockpitWarningServlet is beginning... ");
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
      long span = endDate.get() - beginDate.get();
      if((span < 0) && (span > 1000 * 600)){
         throw new FFatalError("Parameter span is invalid.");
      }
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "fetch|" + beginSource + "-" + endSource;
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      //      TDateTime currentDate = RDateTime.currentDateTime();
      // 设置输出流
      FByteStream stream = createStream(context);
      //      ISqlConnection connection = logicContext.activeConnection("statistics");
      //............................................................
      HashSet<ArrayList<String>> parent = new HashSet<ArrayList<String>>();
      ArrayList<String> child1 = new ArrayList<String>();
      child1.add("DA4B7F30C1C34A3CA231744C3BF1DD41");
      child1.add("北京第七分公司本月离职率已达10%");
      ArrayList<String> child2 = new ArrayList<String>();
      child2.add("DA4B7F30C1C34A3CA231744C3BF1DD42");
      child2.add("上海璟益本月任务还有60%没有完成.");
      ArrayList<String> child3 = new ArrayList<String>();
      child3.add("DA4B7F30C1C34A3CA231744C3BF1DD43");
      child3.add("10月28日e租宝赎回总额超过3亿元.");
      parent.add(child1);
      parent.add(child2);
      parent.add(child3);
      for(ArrayList<String> list : parent){
         for(String string : list){
            stream.writeString(string);
         }
      }
      int count = parent.size();
      stream.writeInt32(count);
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send statistics customer dynamic. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
      return sendStream(context, request, response, stream);
   }

   //============================================================
   // <T>根据guid获取阈值预警详情</T>
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult find(IWebContext context,
                       ILogicContext logicContext,
                       IWebServletRequest request,
                       IWebServletResponse response){
      _logger.debug(this, "fetch", "the method named find from FCockpitWarningServlet is beginning... ");
      // 检查参数
      if(!checkParameters(context, request, response)){
         return EResult.Failure;
      }
      //      String warningGuid = context.parameter("guid");
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "find";
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      //      TDateTime currentDate = RDateTime.currentDateTime();
      // 设置输出流
      FByteStream stream = createStream(context);
      //      ISqlConnection connection = logicContext.activeConnection("statistics");
      //............................................................
      stream.writeString("本条阈值预警详情....");
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send statistics customer dynamic. (data_length={1})", dataLength);
      return sendStream(context, request, response, stream);
   }
}