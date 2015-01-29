package org.mo.content.face.resource3d.scene;

import org.mo.content.resource3d.model.FRs3Model;

import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.resource3d.model.IC3dModelConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理。</T>
//============================================================
public class FStorageServlet
      extends FObject
      implements
         IStorageServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FStorageServlet.class);

   // 数据缓冲大小
   protected static int BufferLength = 1024 * 64;

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
      String code = context.parameter("code");
      if(RString.isEmpty(code)){
         throw new FFatalError("Model code is empty.");
      }
      // 检查版本
      String version = context.parameter("version");
      if(RString.isEmpty(version)){
         throw new FFatalError("Model version is empty.");
      }
      // 生成模型
      FRs3Model model = _modelConsole.makeModel(logicContext, code, version);
      // 存储为数组
      FByteStream stream = new FByteStream();
      model.serialize(stream);
      // 发送数据
      _logger.debug(this, "process", "Send data. (length={1})", stream.length());
      response.write(stream.memory(), 0, stream.length());
   }
}
