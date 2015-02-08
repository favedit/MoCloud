package org.mo.content.face.resource3d.model;

import javax.servlet.http.HttpServletResponse;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.EMime;
import org.mo.content.core.resource3d.model.IC3dModelConsole;
import org.mo.content.resource3d.model.FRs3Model;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理。</T>
//============================================================
public class FModelServlet
      extends FObject
      implements
         IModelServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FModelServlet.class);

   // 数据缓冲大小
   protected static int BufferLength = 1024 * 64;

   // 缓冲时间
   protected static long CacheTimeout = 3600 * 24 * 7 * 4;

   // 存储管理接口
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 资源模型接口
   @ALink
   protected IC3dModelConsole _modelConsole;

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
      String code = context.parameter("code");
      String version = context.parameter("version");
      // 检查参数
      if(RString.isEmpty(code)){
         throw new FFatalError("Model code is empty.");
      }
      // 生成数据
      FRs3Model model = _modelConsole.makeModel(logicContext, code, version);
      FByteStream stream = new FByteStream();
      if(model == null){
         String info = RString.format("Template is not exists. (guid={1}, code={2}, version={3})", guid, code, version);
         stream.writeInt32(EResult.Failure.value());
         stream.writeString(info);
      }else{
         stream.writeInt32(EResult.Success.value());
         model.serialize(stream);
      }
      int dataLength = stream.length();
      // 发送数据
      _logger.debug(this, "process", "Send model data. (length={1})", dataLength);
      response.setCharacterEncoding("utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.setHeader("Cache-Control", "max-age=" + CacheTimeout);
      response.addHeader("Last-Modified", System.currentTimeMillis());
      response.addHeader("Expires", System.currentTimeMillis() + CacheTimeout * 1000);
      response.setContentType(EMime.Bin.mime());
      response.setContentLength(dataLength);
      response.write(stream.memory(), 0, dataLength);
   }
}
