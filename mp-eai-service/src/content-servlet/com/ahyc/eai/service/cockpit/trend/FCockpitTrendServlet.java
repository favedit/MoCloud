package com.ahyc.eai.service.cockpit.trend;

import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import java.text.DecimalFormat;
import java.util.ArrayList;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>业绩趋势处理接口。</T>
//============================================================
public class FCockpitTrendServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitTrendServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitTrendServlet.class);

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
      // 获得当前时间
      TDateTime currentDate = RDateTime.currentDateTime();
      //............................................................
      //............................................................
      // 从缓冲中查找数据
      String cacheCode = "dynamic|" + currentDate.format("YYYYMMDDHH24MI");
      FByteStream cacheStream = findCacheStream(cacheCode);
      if(cacheStream != null){
         return sendStream(context, request, response, cacheStream);
      }
      //............................................................
      //      TDateTime currentDate = RDateTime.currentDateTime();
      // 设置输出流
      FByteStream stream = createStream(context);
      FByteStream dataStream = createStream(context);
      //      ISqlConnection connection = logicContext.activeConnection("statistics");
      //............................................................
      ArrayList<Double[]> parent = new ArrayList<Double[]>();
      Double[] child0 = new Double[31];
      Double[] child1 = new Double[31];
      Double[] child2 = new Double[31];
      Double[] child3 = new Double[31];
      Double[] child4 = new Double[31];
      Double[] child5 = new Double[31];
      parent.add(child0);
      parent.add(child1);
      parent.add(child2);
      parent.add(child3);
      parent.add(child4);
      parent.add(child5);
      for(Double[] doubles : parent){
         for(int i = 0; i < doubles.length; i++){
            doubles[i] = Double.parseDouble(new DecimalFormat("#").format(Math.random() * 100000));
         }
      }
      int count = parent.size();
      dataStream.writeInt32(count);//本月加上月一共六条曲线
      dataStream.writeString("current_investment");//当月投资
      dataStream.writeInt32(child0.length);//投资天数
      int c0 = child0.length;
      for(int i = 0; i < c0; i++){
         dataStream.writeDouble(child0[i]);//每天投资额
      }
      dataStream.writeString("current_redemption");//当月赎回
      dataStream.writeInt32(child1.length);//赎回天数
      int c1 = child1.length;
      for(int i = 0; i < c1; i++){
         dataStream.writeDouble(child1[i]);//每天赎回额
      }
      dataStream.writeString("current_netinvestment");//当月净投
      dataStream.writeInt32(child2.length);//净投天数
      int c2 = child2.length;
      for(int i = 0; i < c2; i++){
         dataStream.writeDouble(child2[i]);//每天净投额
      }

      dataStream.writeString("last_investment");//上月投资
      dataStream.writeInt32(child3.length);//投资天数
      int c3 = child3.length;
      for(int i = 0; i < c3; i++){
         dataStream.writeDouble(child3[i]);//每天投资额
      }
      dataStream.writeString("last_redemption");//上月赎回
      dataStream.writeInt32(child4.length);//赎回天数
      int c4 = child4.length;
      for(int i = 0; i < c4; i++){
         dataStream.writeDouble(child4[i]);//每天赎回额
      }
      dataStream.writeString("last_netinvestment");//上月净投
      dataStream.writeInt32(child5.length);//净投天数
      int c5 = child5.length;
      for(int i = 0; i < c5; i++){
         dataStream.writeDouble(child5[i]);//每天净投额
      }
      stream.write(dataStream.memory(), 0, dataStream.position());
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
