package com.ahyc.eai.service.cockpit.performance;

import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import java.util.ArrayList;
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
// <T>e租宝财富端本月业绩接口.</T>
//============================================================
public class FCockpitPerformanceServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitPerformanceServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitPerformanceServlet.class);

   // 资源访问接口
   //   private static IResource _resource = RResource.find(FCockpitWarningServlet.class);

   //============================================================
   // <T>e租宝财富端本月业绩列表</T>
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
      _logger.debug(this, "fetch", "the method named fetch from FCockpitPerformanceServlet is beginning... ");
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
      ArrayList<ArrayList<Object>> parent = new ArrayList<ArrayList<Object>>();
      ArrayList<Object> child1 = new ArrayList<Object>();
      child1.add("一诺财富");
      child1.add("300万到3600元");
      child1.add(1);
      ArrayList<Object> child2 = new ArrayList<Object>();
      child2.add("上海钰申");
      child2.add("300万到3600元");
      child2.add(2);
      ArrayList<Object> child3 = new ArrayList<Object>();
      child3.add("钰诚荣泰(安徽)");
      child3.add("300万到3600元");
      child3.add(3);
      ArrayList<Object> child4 = new ArrayList<Object>();
      child4.add("上海仁立");
      child4.add("300万到3600元");
      child4.add(4);
      parent.add(child1);
      parent.add(child2);
      parent.add(child3);
      parent.add(child4);
      int count = parent.size();
      stream.writeInt32(count);
      for(ArrayList<Object> list : parent){
         for(Object obj : list){
            if(obj instanceof String){
               stream.writeString((String)obj);
            }
            if(obj instanceof Integer){
               stream.writeInt32((Integer)obj);
            }
         }
      }
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send statistics customer dynamic. (begin_date={1}, end_date={2}, count={3}, data_length={4})", beginDate.format(), endDate.format(), count, dataLength);
      return sendStream(context, request, response, stream);
   }

}
