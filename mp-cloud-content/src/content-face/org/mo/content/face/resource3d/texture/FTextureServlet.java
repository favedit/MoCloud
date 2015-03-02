package org.mo.content.face.resource3d.texture;

import javax.servlet.http.HttpServletResponse;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.EMime;
import org.mo.content.engine3d.core.texture.FRs3Texture;
import org.mo.content.engine3d.core.texture.IRs3TextureConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>纹理数据。</T>
//============================================================
public class FTextureServlet
      extends FObject
      implements
         ITextureServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FTextureServlet.class);

   // 缓冲时间
   protected static long CacheTimeout = 3600 * 24 * 7 * 4;

   // 纹理位图接口
   @ALink
   protected IRs3TextureConsole _textureConsole;

   //============================================================
   // <T>逻辑处理。</T>
   // <P>catalog:分类</P>
   // <P>date:日期</P>
   // <P>code:代码</P>
   // <P>version:版本</P>
   // <P>type:类型，没有的话，存储为 bin</P>
   // <P>size:大小</P>
   // <P>存储位置：\{catalog}\{date:yyyymmdd}\{code}\{version}.{type}</P>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void process(IWebContext context,
                       ILogicContext logicContext,
                       IWebServletRequest request,
                       IWebServletResponse response){
      // 检查代码
      String guid = context.parameter("guid");
      if(RString.isEmpty(guid)){
         throw new FFatalError("Model code is empty.");
      }
      // 获得数据
      FRs3Texture texture = _textureConsole.makeTexture(logicContext, guid);
      FByteStream stream = new FByteStream();
      if(texture == null){
         String info = RString.format("Texture is not exists. (guid={1})", guid);
         stream.writeInt32(EResult.Failure.value());
         stream.writeString(info);
      }else{
         stream.writeInt32(EResult.Success.value());
         texture.serialize(stream);
      }
      int dataLength = stream.length();
      byte[] data = stream.memory();
      // 发送数据
      _logger.debug(this, "process", "Send data. (length={1})", dataLength);
      response.setCharacterEncoding("utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.setHeader("Cache-Control", "max-age=" + CacheTimeout);
      response.addHeader("Last-Modified", System.currentTimeMillis());
      response.addHeader("Expires", System.currentTimeMillis() + CacheTimeout * 1000);
      response.setContentType(EMime.Bin.mime());
      response.setContentLength(dataLength);
      response.write(data, 0, dataLength);
   }
}
