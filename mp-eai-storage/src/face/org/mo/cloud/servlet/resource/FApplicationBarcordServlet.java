package org.mo.cloud.servlet.resource;

import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理。</T>
//============================================================
public class FApplicationBarcordServlet
      extends FObject
      implements
         IApplicationBarcordServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FApplicationBarcordServlet.class);

   // 路径
   //private static String _urlPrefix = "http://gc.17173.com/application/showGame.php?code=";

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   @Override
   public void process(IWebContext context,
                       IWebServletRequest request,
                       IWebServletResponse response){
      try{
         //         FZxing fzxing = new FZxing();
         //         String code = context.parameter("code");
         //         String url = _urlPrefix + code;
         //         BufferedImage bufferedImage = fzxing.encode(url);
         //
         //         ByteArrayOutputStream outStream = new ByteArrayOutputStream();
         //         ImageIO.write(bufferedImage, "jpg", outStream);
         //         byte[] byteBuffer = outStream.toByteArray();
         //
         //         response.setCharacterEncoding("utf-8");
         //         response.setContentType(EMime.Jpg.mime());
         //         response.setContentLength(byteBuffer.length);
         //         response.write(byteBuffer);
      }catch(Exception e){
         _logger.error(this, "process", e.getMessage());
         e.printStackTrace();
      }
   }
}
