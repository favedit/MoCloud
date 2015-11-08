package com.ahyc.eai.service.cockpit.wisdom;

import com.ahyc.eai.service.common.FAbstractStatisticsServlet;
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
public class FCockpitWisdomServlet
      extends FAbstractStatisticsServlet
      implements
         ICockpitWisdomServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCockpitWisdomServlet.class);

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
      Integer[] child0 = new Integer[12];//1-12月每月的投资赎回人数
      Double[] child1 = new Double[12];//1-12月所有员工的每月月末投资
      Integer[] child2 = new Integer[12];//1-12月每月固定时间投资赎回的人数
      Integer[] child3 = new Integer[12];//1-12月每月理财师投资业绩与绩效业绩的百分比
      Integer[] child4 = new Integer[12];//1-12月,分公司每月的人员流动性
      for(int i = 0; i < child0.length; i++){
         child0[i] = (int)(Math.random() * 100000);
      }
      for(int i = 0; i < child1.length; i++){
         child1[i] = (Math.random() * 100000);
      }
      for(int i = 0; i < child2.length; i++){
         child2[i] = (int)(Math.random() * 100000);
      }
      for(int i = 0; i < child3.length; i++){
         child3[i] = (int)(Math.random() * 100);
      }
      for(int i = 0; i < child4.length; i++){
         child4[i] = (int)(Math.random() * 100);
      }
      int count = 5;
      dataStream.writeInt32(count);//5条智慧标题
      dataStream.writeString("同一账号反复投资/赎回");//第一条曲线的智慧标题
      int c0 = child0.length;
      for(int i = 0; i < c0; i++){
         dataStream.writeInt32(child0[i]);//1-12月每月投资/赎回的人数
      }
      dataStream.writeString("所有员工的月末投资");//第二条曲线的智慧标题
      int c1 = child1.length;
      for(int i = 0; i < c1; i++){
         dataStream.writeDouble(child1[i]);//1-12月每月投资/赎回的人数
      }
      dataStream.writeString("每月固定时间内投资/赎回");//第三条曲线的智慧标题
      int c2 = child2.length;
      dataStream.writeString("15 24:00");//每月15号的24点整
      for(int i = 0; i < c2; i++){
         dataStream.writeDouble(child2[i]);//1-12月每月固定时间投资赎回的人数
      }

      dataStream.writeString("理财师投资业绩/绩效业绩");//第四条曲线的智慧标题
      int c3 = child3.length;
      for(int i = 0; i < c3; i++){
         dataStream.writeInt32(child3[i]);//1-12月每月理财师投资业绩与绩效业绩的百分比
      }
      dataStream.writeString("分公司的人员流动性");//第五条曲线的智慧标题
      int c4 = child4.length;
      for(int i = 0; i < c4; i++){
         dataStream.writeInt32(child4[i]);//1-12月,分公司每月的人员流动性
      }
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
