package com.ahyc.eai.service.common;

import javax.servlet.http.HttpServletResponse;
import org.mo.com.io.FByteStream;
import org.mo.com.io.FEncryptedStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FObject;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.net.EMime;
import org.mo.content.core.system.ISystemInfoConsole;
import org.mo.core.aop.face.ALink;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>理财师信息处理。</T>
//============================================================
public class FAbstractStatisticsServlet
      extends FObject
{
   @ALink
   protected ISystemInfoConsole _infoConsole;

   //============================================================
   // <T>创建字节流。</T>
   //
   // @return 字节流
   //============================================================
   public FByteStream createStream(IWebContext context){
      // 获得签名
      int sign = context.parameterAsInteger("sign", 0);
      // 创建加密流
      FEncryptedStream stream = new FEncryptedStream();
      stream.setIntSign(sign);
      return stream;
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   public boolean checkParameters(IWebContext context,
                                  IWebServletRequest request,
                                  IWebServletResponse response){
      // 获得参数
      int parameterHash = 0;
      FAttributes parameters = new FAttributes();
      for(IStringPair pair : context.parameters()){
         String name = pair.name();
         if("do".equals(name)){
            continue;
         }
         if("sid".equals(name)){
            continue;
         }
         if("sign".equals(name)){
            parameterHash = RInteger.parse(pair.value());
            continue;
         }
         parameters.set(name, pair.value());
      }
      // 参数排序
      parameters.sortByName();
      // 计算代码
      int token = _infoConsole.token();
      String pack = parameters.joinValue("");
      int hash = RString.calculateHash(pack, token);
      if(parameterHash != hash){
         // 校验错误
         FByteStream stream = new FByteStream();
         stream.write(new String("Sign is invalid.").getBytes());
         sendStream(context, request, response, stream);
         return false;
      }
      return true;
   }

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
