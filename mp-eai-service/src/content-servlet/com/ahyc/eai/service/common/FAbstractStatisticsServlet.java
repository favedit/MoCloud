package com.ahyc.eai.service.common;

import javax.servlet.http.HttpServletResponse;
import org.mo.com.encoding.REncryption;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.net.EMime;
import org.mo.content.core.system.ISystemInfoConsole;
import org.mo.core.aop.face.ALink;
import org.mo.eng.memorycache.FMemoryChannel;
import org.mo.eng.memorycache.IMemoryCacheConsole;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>理财师信息处理。</T>
//============================================================
public class FAbstractStatisticsServlet
      extends FObject
{
   // 日志输出接口
   // private static ILogger _logger = RLogger.find(FAbstractStatisticsServlet.class);

   @ALink
   protected ISystemInfoConsole _infoConsole;

   @ALink
   protected IMemoryCacheConsole _cacheConsole;

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
   // <T>从缓冲中查找数据流。</T>
   //
   // @param code 代码
   // @return 字节流
   //============================================================
   public FByteStream findCacheStream(String code){
      // 生成代码
      String cacheCode = getClass().getName() + "|" + code;
      // 获取数据流
      byte[] data = null;
      try(FMemoryChannel channel = _cacheConsole.alloc()){
         if(channel != null){
            data = channel.getBytes(cacheCode);
         }
      }catch(Exception e){
         throw new FFatalError(e, "Find cache stream failure.");
      }
      // 创建加密流
      if(data != null){
         FByteStream stream = new FByteStream();
         stream.append(data, 0, data.length);
         return stream;
      }
      return null;
   }

   //============================================================
   // <T>更新数据到缓冲中。</T>
   //
   // @param code 代码
   // @param stream 字节流
   //============================================================
   public void updateCacheStream(String code,
                                 FByteStream stream){
      // 生成代码
      String cacheCode = getClass().getName() + "|" + code;
      // 获取数据流
      byte[] data = stream.toArray();
      try(FMemoryChannel channel = _cacheConsole.alloc()){
         if(channel != null){
            channel.setBytes(cacheCode, data);
         }
      }catch(Exception e){
         throw new FFatalError(e, "Update cache stream failure.");
      }
   }

   //============================================================
   // <T>创建字节流。</T>
   //
   // @return 字节流
   //============================================================
   public FByteStream createStream(IWebContext context){
      // 获得签名
      //int sign = context.parameterAsInteger("sign", 0);
      // 创建加密流
      //FEncryptedStream stream = new FEncryptedStream();
      //stream.setIntSign(sign);
      FByteStream stream = new FByteStream();
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
   public EResult sendStream(IWebContext context,
                             IWebServletRequest request,
                             IWebServletResponse response,
                             FByteStream stream){
      // 获得参数
      int dataLength = stream.length();
      byte[] data = stream.memory();
      //............................................................
      // 数据签名
      int sign = context.parameterAsInteger("sign", 0);
      REncryption.encodeBytes(data, 0, dataLength, sign);
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
