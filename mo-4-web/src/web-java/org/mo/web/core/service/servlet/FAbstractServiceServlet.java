package org.mo.web.core.service.servlet;

import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mo.com.lang.EResult;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RString;
import org.mo.com.lang.RUuid;
import org.mo.com.lang.cultrue.RCulture;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.message.EMessageLevel;
import org.mo.com.text.RDatabaseFormat;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.RAop;
import org.mo.web.core.action.common.FWebCookie;
import org.mo.web.core.common.EWebConstants;
import org.mo.web.core.common.FAbstractHttpServlet;
import org.mo.web.core.service.IServiceConsole;
import org.mo.web.core.service.common.EWebServiceFormat;
import org.mo.web.core.service.common.RWebService;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.common.IWebContentType;
import org.mo.web.protocol.common.IWebHeaderType;
import org.mo.web.protocol.common.IWebServlet;
import org.mo.web.protocol.context.FWebContext;
import org.mo.web.protocol.context.FWebXmlInput;
import org.mo.web.protocol.context.FWebXmlOutput;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>页面处理模块。</T>
// <P>1. 初始化数据，创建全局应用管理对象。</P>
// <P>2. 根据页面请求，执行相应业务处理。</P>
//============================================================
public abstract class FAbstractServiceServlet
      extends FAbstractHttpServlet
      implements
         IWebServlet
{
   // 序列化标识
   private static final long serialVersionUID = 1L;

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FAbstractServiceServlet.class);

   // 服务控制台接口
   protected IServiceConsole _serviceConsole;

   //============================================================
   // <T>初始化网络应用程序。</T>
   //
   // @param config 网络设置对象
   //============================================================
   @Override
   public void initialize(ServletConfig config){
      super.initialize(config);
      _serviceConsole = RAop.find(IServiceConsole.class);
   }

   //============================================================
   // <T>网页请求逻辑对象执行开始。</T>
   //
   // @param httpRequest 页面请求对象
   // @param httpResponse 页面响应对象
   //============================================================
   @Override
   public void process(String type,
                       HttpServletRequest httpRequest,
                       HttpServletResponse httpResponse){
      long beginTick = System.nanoTime();
      String uri = null;
      FWebContext context = null;
      IWebSession session = null;
      FXmlDocument inputDocument = null;
      FXmlDocument outputDocument = null;
      int formatCd = EWebServiceFormat.Xml;
      try{
         String language = _sessionLanguage;
         String encoding = _sessionEncoding;
         InputStream inputStream = httpRequest.getInputStream();
         // 建立会话
         boolean sessionExist = false;
         String sessionCode = null;
         if(_sessionValid){
            sessionCode = findSessionId(httpRequest);
            sessionExist = !RString.isEmpty(sessionCode);
            if(!sessionExist){
               sessionCode = RUuid.makeUniqueIdLower();
            }
            session = _sessionConsole.build(sessionCode);
            if(session != null){
               session.referIncrease();
               // 设置语言编码
               language = session.culture().countryLanguage();
               encoding = session.culture().countryEncoding();
               RCulture.link(session.culture());
            }
         }
         if(_logger.debugAble()){
            _logger.debug(this, "process", "Do{1} begin. (language={2}, charset={3}, uri={4})", type, language, encoding, httpRequest.getRequestURI());
         }
         //............................................................
         // 获取传入内容
         inputDocument = new FXmlDocument();
         inputDocument.setOptionAttributeCareCase(false);
         int contentLength = httpRequest.getContentLength();
         if(contentLength > 0){
            // 按照XML解析
            inputDocument.loadStream(inputStream);
            if(_logger.debugAble()){
               _logger.debugFull(this, "process", "Build input xml.\n{1}", inputDocument.xml());
            }
         }
         //............................................................
         // 建立环境
         context = new FWebContext(session, httpRequest, httpResponse);
         String format = context.parameter(RWebService.PtyFormatCd);
         formatCd = EWebServiceFormat.parse(format);
         if(_logger.debugAble()){
            _logger.debug(this, "process", "Build context: {1}", context.dump());
         }
         _bindConsole.bind(IWebContext.class, context);
         _bindConsole.bind(IWebSession.class, session);
         // 更新输出
         if(formatCd == EWebServiceFormat.Json){
            httpResponse.setContentType(IWebContentType.JSON);
         }else{
            httpResponse.setContentType(IWebContentType.XML);
         }
         httpResponse.setHeader(IWebHeaderType.PRAGMA, IWebHeaderType.NO_CACHE);
         httpResponse.setHeader(IWebHeaderType.CACHE_CONTROL, IWebHeaderType.NO_CACHE);
         httpResponse.setHeader("Access-Control-Allow-Origin", "*");
         httpResponse.setDateHeader(IWebHeaderType.EXPIRES, 1);
         if(!sessionExist){
            context.outputCookies().push(new FWebCookie(EWebConstants.SessionId, sessionCode));
         }
         updateResponse(context, httpRequest, httpResponse);
         //............................................................
         // 设置输出内容
         outputDocument = new FXmlDocument();
         outputDocument.setOptionAttributeCareCase(false);
         outputDocument.setOptionAttributeReturn(false);
         // 查找服务类型
         uri = context.requestUri();
         if(uri.endsWith(".ws")){
            uri = uri.substring(0, uri.length() - 3);
            int find = uri.lastIndexOf('/');
            if(find != -1){
               uri = uri.substring(find + 1);
            }
            // 设置URL参数到输入节点内
            FXmlNode inputNode = inputDocument.root();
            for(IStringPair pair : context.parameters()){
               String paramName = RDatabaseFormat.toJavaClassName(pair.name());
               String paramValue = pair.value();
               if(inputNode.findNode("paramName") == null){
                  inputNode.createNode(paramName, paramValue);
               }
            }
            // 执行逻辑过程
            FWebXmlInput input = new FWebXmlInput(inputNode);
            FXmlNode outputNode = outputDocument.root();
            outputNode.setName("Service");
            // 设置函数
            String action = context.parameter("action");
            if(RString.isEmpty(action)){
               action = input.get("action");
            }
            if(RString.isEmpty(action)){
               action = "process";
            }
            outputNode.set("method", action + "@" + uri);
            // 设置输出
            FWebXmlOutput output = new FWebXmlOutput(outputNode);
            Object resultCd = _serviceConsole.execute(uri, context, input, output);
            if(resultCd != null){
               outputNode.set(RWebService.PtyResultCd, resultCd.toString().toLowerCase());
            }else{
               outputNode.set(RWebService.PtyResultCd, EResult.Failure.toString().toLowerCase());
            }
            EMessageLevel levelCd = context.messages().calculateMaxLevel();
            if((levelCd != EMessageLevel.Debug) && (levelCd != EMessageLevel.Success)){
               outputNode.set(RWebService.PtyMessageCd, levelCd.toString().toLowerCase());
            }
         }
      }catch(Exception e){
         _logger.error(this, "process", e);
      }finally{
         // 释放会话引用
         if(session != null){
            RCulture.unlink();
            session.referDecrease();
         }
         // 清空关联信息
         _bindConsole.clear();
         // 释放输出内容
         if(outputDocument != null){
            try{
               // 输出服务结果
               if(_logger.debugAble()){
                  _logger.debugFull(this, "process", "Build output xml.\n{1}", outputDocument.xml());
               }
               // 转换格式
               OutputStream outputStream = httpResponse.getOutputStream();
               if(formatCd == EWebServiceFormat.Json){
                  byte[] jsonData = RWebService.xml2json(outputDocument);
                  outputStream.write(jsonData);
               }else{
                  // 输出XML格式格式
                  outputDocument.saveStream(outputStream);
               }
            }catch(Exception e){
               _logger.error(this, "process", e);
            }
         }
         long endTick = System.nanoTime();
         if(_logger.debugAble()){
            _logger.debug(this, "process", endTick - beginTick, "Do{1} end. (uri={2})", type, uri);
         }
      }
   }
}
