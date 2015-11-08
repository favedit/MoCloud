package com.ahyc.eai.service.cockpit.forecast;

import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
import java.util.ArrayList;
import java.util.List;
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
// <T>智慧柯南接口.</T>
//============================================================
public class FCockpitForecastServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitForecastServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitForecastServlet.class);

   // 资源访问接口
   //   private static IResource _resource = RResource.find(FCockpitWarningServlet.class);

   //============================================================
   // <T>智慧柯南列表</T>
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
      //检查参数
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
      FByteStream dataStream = createStream(context);
      List<ForecastUnit> lists = new ArrayList<ForecastUnit>();
      ForecastUnit unit0 = new ForecastUnit();
      unit0.setLabel("同一账号反复投资/赎回");
      Double[] arr0 = new Double[12];
      for(int i = 0; i < arr0.length; i++){
         arr0[i] = Math.random() * 100;
      }
      unit0.setMonths(arr0);

      ForecastUnit unit1 = new ForecastUnit();
      unit1.setLabel("所有员工的月末投资");
      Double[] arr1 = new Double[12];
      for(int i = 0; i < arr1.length; i++){
         arr1[i] = Math.random() * 10000;
      }
      unit1.setMonths(arr1);

      lists.add(unit0);
      lists.add(unit1);
      int count = lists.size();
      dataStream.writeInt32(count);
      for(ForecastUnit forecastUnit : lists){
         dataStream.writeString(forecastUnit.getLabel());
         Object[] months = forecastUnit.getMonths();
         dataStream.writeInt32(months.length);
         for(int i = 0; i < months.length; i++){
            dataStream.writeDouble((double)months[i]);
         }
      }
      //      dataStream.writeInt32(arr0[i]);//1-12月每月投资/赎回的人数
      //      dataStream.writeString("同一账号反复投资/赎回");//第一条曲线的智慧标题
      //
      //      dataStream.writeString("所有员工的月末投资");//第二条曲线的智慧标题
      //      int c1 = child1.length;
      //      for(int i = 0; i < c1; i++){
      //         dataStream.writeDouble(child1[i]);//1-12月每月投资/赎回的人数
      //      }
      //      dataStream.writeString("每月固定时间内投资/赎回");//第三条曲线的智慧标题
      //      int c2 = child2.length;
      //      dataStream.writeString("15 24:00");//每月15号的24点整
      //      for(int i = 0; i < c2; i++){
      //         dataStream.writeDouble(child2[i]);//1-12月每月固定时间投资赎回的人数
      //      }
      //
      //      dataStream.writeString("理财师投资业绩/绩效业绩");//第四条曲线的智慧标题
      //      int c3 = child3.length;
      //      for(int i = 0; i < c3; i++){
      //         dataStream.writeInt32(child3[i]);//1-12月每月理财师投资业绩与绩效业绩的百分比
      //      }
      //      dataStream.writeString("分公司的人员流动性");//第五条曲线的智慧标题
      //      int c4 = child4.length;
      //      for(int i = 0; i < c4; i++){
      //         dataStream.writeInt32(child4[i]);//1-12月,分公司每月的人员流动性
      //      }
      //写入数据
      stream.write(dataStream.memory(), 0, dataStream.position());
      //............................................................
      // 保存数据到缓冲中
      updateCacheStream(cacheCode, stream);
      //............................................................
      // 发送数据
      int dataLength = stream.length();
      _logger.debug(this, "process", "Send data notice dynamic. (count={1}, data_length={2})", count, dataLength);
      return sendStream(context, request, response, stream);
   }
}
