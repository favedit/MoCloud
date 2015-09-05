package org.mo.content.face.resource.template;

import javax.servlet.http.HttpServletResponse;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.logic.data.resource.template.FGcResTemplateInfo;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.EMime;
import org.mo.content.engine.core.template.IResTemplateConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>上传处理。</T>
//============================================================
public class FTemplateServlet
      extends FObject
      implements
         ITemplateServlet
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FTemplateServlet.class);

   // 缓冲时间
   protected static long CacheTimeout = 3600 * 24 * 7 * 4;

   // 存储管理接口
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 资源模板接口
   @ALink
   protected IResTemplateConsole _templateConsole;

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
      // 获得参数
      String guid = context.parameter("guid");
      String code = context.parameter("code");
      // 检查编号和代码，必须存在一个
      if(RString.isEmpty(guid) && RString.isEmpty(code)){
         throw new FFatalError("Template guid and code is empty.");
      }
      // 获得唯一编号
      if(RString.isEmpty(guid)){
         FGcResTemplateInfo templateInfo = _templateConsole.findByCode(logicContext, code);
         guid = templateInfo.guid();
      }
      //............................................................
      // 生成数据
      byte[] data = _templateConsole.makeTemplateData(logicContext, guid);
      if(data == null){
         throw new FFatalError("process", "Template is not exists. (guid={1}, code={2})", guid, code);
      }
      int dataLength = data.length;
      //............................................................
      // 发送数据
      _logger.debug(this, "process", "Send template data. (length={1})", dataLength);
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
      // 获得参数
      long userId = session.userId();
      String guid = context.parameter("guid");
      String code = context.parameter("code");
      // 检查编号和代码，必须存在一个
      if(RString.isEmpty(guid) && RString.isEmpty(code)){
         throw new FFatalError("Template guid and code is empty.");
      }
      // 获得唯一编号
      if(RString.isEmpty(guid)){
         FGcResTemplateInfo templateInfo = _templateConsole.findByUserCode(logicContext, userId, code);
         guid = templateInfo.guid();
      }
      //............................................................
      // 生成数据
      byte[] data = _templateConsole.makeTemplateData(logicContext, guid);
      if(data == null){
         throw new FFatalError("process", "Template is not exists. (guid={1}, code={2})", guid, code);
      }
      int dataLength = data.length;
      //............................................................
      // 发送数据
      _logger.debug(this, "process", "Send template data. (length={1})", dataLength);
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
