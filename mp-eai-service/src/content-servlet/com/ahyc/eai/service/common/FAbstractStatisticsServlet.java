package com.ahyc.eai.service.common;

import javax.servlet.http.HttpServletResponse;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.net.EMime;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>理财师信息处理。</T>
//============================================================
public class FAbstractStatisticsServlet
      extends FObject
{
   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   public EResult sendStream(IWebContext context,
                             IWebServletRequest request,
                             IWebServletResponse response,
                             FByteStream stream){
      // 获得参数
      int dataLength = stream.length();
      byte[] data = stream.memory();
      //............................................................
      // 发送数据
      response.setCharacterEncoding("utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.setHeader("Cache-Control", "max-age=0");
      response.addHeader("Access-Control-Allow-Origin", "*");
      response.addHeader("Last-Modified", System.currentTimeMillis());
      response.addHeader("Expires", System.currentTimeMillis());
      response.setContentType(EMime.Bin.mime());
      response.setContentLength(dataLength);
      response.write(data, 0, dataLength);
      return EResult.Success;
   }
}
