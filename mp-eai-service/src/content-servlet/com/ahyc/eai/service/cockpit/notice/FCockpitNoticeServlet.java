package com.ahyc.eai.service.cockpit.notice;

import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import java.util.ArrayList;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.mobile.logic.notice.INoticeConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>业绩趋势处理接口。</T>
//============================================================
public class FCockpitNoticeServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitNoticeServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitNoticeServlet.class);

   // 号令逻辑控制台
   @ALink
   protected INoticeConsole _noticeConsole;

   // 资源访问接口
   //   private static IResource _resource = RResource.find(FCockpitWarningServlet.class);

   //============================================================
   // <T>业绩趋势列表</T>
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
      _logger.debug(this, "fetch", "the method named fetch from FCockpitTrendServlet is beginning... ");
      //       检查参数
      if(!checkParameters(context, request, response)){
         return EResult.Failure;
      }
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "fetch";
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
      child1.add("label");
      child1.add("关于规范集团知识产权管理的通知");
      child1.add("user_name");
      child1.add("丁甸");
      child1.add("publish_date");
      child1.add("2015-10-30");
      child1.add("percent");
      child1.add(10);//百分比
      ArrayList<Object> child2 = new ArrayList<Object>();
      child2.add("label");
      child2.add("关于规范集团知识产权管理的通知");
      child2.add("user_name");
      child2.add("丁甸");
      child2.add("publish_date");
      child2.add("2015-10-31");
      child2.add("percent");
      child2.add(20);//百分比
      ArrayList<Object> child3 = new ArrayList<Object>();
      child3.add("label");
      child3.add("关于规范集团知识产权管理的通知");
      child3.add("user_name");
      child3.add("丁甸");
      child3.add("publish_date");
      child3.add("2015-10-31");
      child3.add("percent");
      child3.add(30);
      ArrayList<Object> child4 = new ArrayList<Object>();
      child4.add("label");
      child4.add("关于规范集团知识产权管理的通知");
      child4.add("user_name");
      child4.add("丁甸");
      child4.add("publish_date");
      child4.add("percent");
      child4.add("2015-10-31");
      child4.add(40);//百分比
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
      _logger.debug(this, "process", "Send statistics customer dynamic. (count={1}, data_length={2})", count, dataLength);
      return sendStream(context, request, response, stream);
   }
}
