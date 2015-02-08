package org.mo.content.face.resource3d.scene;

import org.mo.com.io.FByteStream;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.resource3d.scene.IC3dSceneConsole;
import org.mo.content.resource3d.scene.FRs3Scene;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理。</T>
//============================================================
public class FSceneServlet
      extends FObject
      implements
         ISceneServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FSceneServlet.class);

   // 数据缓冲大小
   protected static int BufferLength = 1024 * 64;

   // 资源模型接口
   @ALink
   protected IC3dSceneConsole _sceneConsole;

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
      String guid = context.parameter("guid");
      String code = context.parameter("code");
      if(RString.isEmpty(guid) && RString.isEmpty(code)){
         throw new FFatalError("Scene is empty.");
      }
      // 生成模型
      FRs3Scene scene = _sceneConsole.makeScene(logicContext, guid, code);
      // 存储为数组
      FByteStream stream = new FByteStream();
      scene.serialize(stream);
      // 发送数据
      _logger.debug(this, "process", "Send data. (length={1})", stream.length());
      response.write(stream.memory(), 0, stream.length());
   }
}
