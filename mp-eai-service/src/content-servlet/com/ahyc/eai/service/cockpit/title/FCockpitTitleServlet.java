package com.ahyc.eai.service.cockpit.title;

import com.ahyc.eai.service.cockpit.warning.FCockpitWarningServlet;
import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.core.common.EEaiDataConnection;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>实时数据处理。</T>
//============================================================
public class FCockpitTitleServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitTitleServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitTitleServlet.class);

   // 资源访问接口
   private static IResource _resource = RResource.find(FCockpitWarningServlet.class);

   //============================================================
   // <T>实时数据</T>
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
      //       检查参数
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
      ISqlConnection connection = logicContext.activeConnection(EEaiDataConnection.STATISTICS);
      // 输出当日合计数据
      FSql sql = _resource.findString(FSql.class, "sql.title");
      sql.bindString("month", currentDate.format("YYYYMM01"));
      FRow row = connection.find(sql);
      double investmentAmount = row.getDouble("investment_amount");
      double investmentTotal = row.getDouble("investment_total");
      //............................................................
      // 投资总额
      stream.writeDouble(investmentTotal);
      // 当月投资
      stream.writeDouble(investmentAmount);
      // 集团现有员工
      stream.writeInt32(92800);
      // 现有理财师
      stream.writeInt32(70000);
      // 现有子公司
      stream.writeInt32(45);
      // 现有财富端分公司
      stream.writeInt32(250);
      // 分布职场数量
      stream.writeInt32(485);
      // 待办事项
      stream.writeInt32(8);
      // 消息通知
      stream.writeInt32(5);
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
