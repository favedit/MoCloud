package org.mo.content.face.resource3d.scene;

import com.cyou.gccloud.data.data.FDataResource3dSceneThemeUnit;
import com.cyou.gccloud.data.data.FDataResource3dSceneUnit;
import javax.servlet.http.HttpServletResponse;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.EMime;
import org.mo.content.core.resource3d.scene.IC3dSceneConsole;
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

   // 缓冲时间
   protected static long CacheTimeout = 3600 * 24 * 7 * 4;

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
      String themeCode = RString.nvl(context.parameter("theme"), "general");
      if(RString.isEmpty(guid) && RString.isEmpty(code)){
         throw new FFatalError("Scene is empty.");
      }
      //............................................................
      // 查找场景
      byte[] sceneData = null;
      FDataResource3dSceneUnit sceneUnit = _sceneConsole.findSceneUnit(logicContext, guid, code);
      if(sceneUnit != null){
         // 查找主题
         FDataResource3dSceneThemeUnit themeUnit = _sceneConsole.findThemeUnit(logicContext, sceneUnit.ouid(), themeCode);
         if(themeUnit != null){
            // 生成数据
            sceneData = _sceneConsole.makeThemeData(logicContext, themeUnit.guid());
         }
      }
      //............................................................
      // 生成数据
      FByteStream stream = new FByteStream();
      if(sceneData == null){
         String info = RString.format("Scene is not exists. (guid={1}, code={2}, theme={3})", guid, code, themeCode);
         stream.writeInt32(EResult.Failure.value());
         stream.writeString(info);
      }else{
         stream.writeInt32(EResult.Success.value());
         stream.write(sceneData, 0, sceneData.length);
      }
      int dataLength = stream.length();
      byte[] data = stream.memory();
      //............................................................
      // 发送数据
      _logger.debug(this, "process", "Send scene theme data. (guid={1}, code={2}, theme={3}, length={4})", guid, code, themeCode, dataLength);
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
