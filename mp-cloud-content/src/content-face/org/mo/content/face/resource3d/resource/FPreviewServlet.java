package org.mo.content.face.resource3d.resource;

import javax.servlet.http.HttpServletResponse;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.EMime;
import org.mo.content.core.resource3d.texture.IC3dBitmapConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理。</T>
//============================================================
public class FPreviewServlet
      extends FObject
      implements
         IPreviewServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FPreviewServlet.class);

   // 缓冲时间
   protected static long CacheTimeout = 3600 * 24 * 7 * 4;

   // 数据缓冲大小
   protected static int BufferLength = 1024 * 64;

   // 资源模型接口
   @ALink
   protected IC3dBitmapConsole _bitmapConsole;

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
      // 检查参数
      String typeCd = context.parameter("type_cd");
      String guid = context.parameter("guid");
      if(RString.isEmpty(typeCd) || RString.isEmpty(guid)){
         throw new FFatalError("Parameter is invalid.");
      }
      //............................................................
      // 查找场景
      byte[] data = new byte[0];
      switch(typeCd){
         case "picture":
            data = _bitmapConsole.makeData(logicContext, guid);
            break;
      }
      int dataLength = data.length;
      //............................................................
      // 发送数据
      _logger.debug(this, "process", "Send resource preview data. (type_cd={1}, guid={2}, length={3})", typeCd, guid, dataLength);
      response.setCharacterEncoding("utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.setHeader("Cache-Control", "max-age=" + CacheTimeout);
      response.addHeader("Last-Modified", System.currentTimeMillis());
      response.addHeader("Expires", System.currentTimeMillis() + CacheTimeout * 1000);
      response.setContentType(EMime.Jpg.mime());
      response.setContentLength(dataLength);
      response.write(data, 0, dataLength);
   }
}
