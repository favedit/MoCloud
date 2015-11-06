package com.ahyc.eai.service.cockpit.projectmanage;

import com.ahyc.eai.core.cockpit.projectmanage.IProjectManageConsole;
import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>驾驶舱业绩处理。</T>
//============================================================
public class FCockpitProjectManageServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitProjectManageServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitProjectManageServlet.class);

   // 资源访问接口
   //   private static IResource _resource = RResource.find(FCockpitProjectManageServlet.class);

   // 金融控制台
   @ALink
   protected IProjectManageConsole _projectManageConsole;

   //============================================================
   // <T>获得统计动态数据。</T>
   //
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
      // 检查参数
      if(!checkParameters(context, request, response)){
         return EResult.Failure;
      }
      //............................................................
      // 获得当前时间
      TDateTime currentDate = RDateTime.currentDateTime();
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "dynamic|" + currentDate.format("YYYYMMDDHH24MI");
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      // 设置输出流
      FByteStream stream = createStream(context);
      _projectManageConsole.fetch();
      //      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.STATISTICS);
      // 写入数据
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send dynamic. (date={1}, data_length={2})", currentDate.format(), dataLength);
      return sendStream(context, request, response, stream);
   }
}
