package com.ahyc.eai.service.cockpit;

import com.ahyc.eai.core.common.EDatabaseConnection;
import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import org.mo.com.collections.FDataset;
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
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>驾驶舱处理。</T>
//============================================================
public class FCockpitServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitServlet.class);

   // 资源访问接口
   private static IResource _resource = RResource.find(FCockpitServlet.class);

   //============================================================
   // <T>获得数据处理。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public EResult process(IWebContext context,
                          ILogicContext logicContext,
                          IWebServletRequest request,
                          IWebServletResponse response){
      // 检查参数
      if(!checkParameters(context, request, response)){
         return EResult.Failure;
      }
      TDateTime currentDate = RDateTime.currentDateTime();
      //............................................................
      // 获得数据
      FSql modelSql = _resource.findString(FSql.class, "sql.tender.model");
      modelSql.bindDateTime("date", currentDate, "YYYYMMDD");
      ISqlConnection connection = logicContext.activeConnection(EDatabaseConnection.Statistics);
      FDataset modelDataset = connection.fetchDataset(modelSql);
      //............................................................
      FByteStream stream = new FByteStream();
      int count = modelDataset.count();
      stream.writeInt32(count);
      for(FRow modelRow : modelDataset){
         stream.writeString(modelRow.get("TENDER_MODEL"));
         stream.writeDouble(modelRow.getDouble("INVESTMENT_TOTAL"));
      }
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send cockpit process. (current_date={1}, count={2}, data_length={3})", currentDate.format(), count, dataLength);
      //............................................................
      // 发送数据
      return sendStream(context, request, response, stream);
   }
}
