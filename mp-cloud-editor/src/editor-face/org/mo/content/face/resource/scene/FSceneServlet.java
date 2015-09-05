package org.mo.content.face.resource.scene;

import org.mo.cloud.logic.data.system.FGcSessionInfo;

import org.mo.cloud.logic.data.resource.scene.FGcResSceneInfo;
import javax.servlet.http.HttpServletResponse;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.EMime;
import org.mo.content.core.resource.scene.ICntSceneConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>场景数据处理。</T>
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
   protected ICntSceneConsole _sceneConsole;

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param request 页面请求
   // @param response 页面应答
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
      //............................................................
      // 获得场景信息
      if(RString.isEmpty(guid)){
         FGcResSceneInfo sceneInfo = _sceneConsole.findByCode(logicContext, code);
         if(sceneInfo != null){
            guid = sceneInfo.guid();
         }
      }
      if(RString.isEmpty(guid)){
         throw new FFatalError("process", "Scene is not exists. (guid={1}, code={2})", guid, code);
      }
      //............................................................
      // 生成数据
      byte[] data = _sceneConsole.makeSceneData(logicContext, guid);
      if(data == null){
         throw new FFatalError("process", "Scene is not exists. (guid={1}, code={2})", guid, code);
      }
      int dataLength = data.length;
      //............................................................
      // 发送数据
      _logger.debug(this, "process", "Send scene data. (guid={1}, code={2}, length={3})", guid, code, dataLength);
      response.setCharacterEncoding("utf-8");
      response.setStatus(HttpServletResponse.SC_OK);
      response.setHeader("Cache-Control", "max-age=" + CacheTimeout);
      response.addHeader("Last-Modified", System.currentTimeMillis());
      response.addHeader("Expires", System.currentTimeMillis() + CacheTimeout * 1000);
      response.setContentType(EMime.Bin.mime());
      response.setContentLength(dataLength);
      response.write(data, 0, dataLength);
   }

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param request 页面请求
   // @param response 页面应答
   //============================================================
   @Override
   public void query(IWebContext context,
                     ILogicContext logicContext,
                     FGcSessionInfo session,
                     IWebServletRequest request,
                     IWebServletResponse response){
      // 检查参数
      String guid = context.parameter("guid");
      String code = context.parameter("code");
      if(RString.isEmpty(guid) && RString.isEmpty(code)){
         throw new FFatalError("Scene is empty.");
      }
      //............................................................
      // 获得场景信息
      if(RString.isEmpty(guid)){
         FGcResSceneInfo sceneInfo = _sceneConsole.findByUserCode(logicContext, session.userId(), code);
         if(sceneInfo != null){
            guid = sceneInfo.guid();
         }
      }
      if(RString.isEmpty(guid)){
         throw new FFatalError("process", "Scene is not exists. (guid={1}, code={2})", guid, code);
      }
      //............................................................
      // 生成数据
      byte[] data = _sceneConsole.makeSceneData(logicContext, guid);
      if(data == null){
         throw new FFatalError("process", "Scene is not exists. (guid={1}, code={2})", guid, code);
      }
      int dataLength = data.length;
      //............................................................
      // 发送数据
      _logger.debug(this, "process", "Send scene data. (guid={1}, code={2}, length={3})", guid, code, dataLength);
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
