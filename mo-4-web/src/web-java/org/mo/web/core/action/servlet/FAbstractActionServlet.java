package org.mo.web.core.action.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mo.com.lang.RString;
import org.mo.com.lang.RUuid;
import org.mo.com.lang.cultrue.RCulture;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.web.core.action.IActionConsole;
import org.mo.web.core.action.common.FWebCookie;
import org.mo.web.core.common.EWebConstants;
import org.mo.web.core.common.FAbstractHttpServlet;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.common.IWebServlet;
import org.mo.web.protocol.context.FWebContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>页面处理模块。</T>
// <P>1. 初始化数据，创建全局应用管理对象。</P>
// <P>2. 根据页面请求，执行相应业务处理。</P>
//============================================================
public abstract class FAbstractActionServlet
      extends FAbstractHttpServlet
      implements
         IWebServlet
{
   // 序列化标识
   private static final long serialVersionUID = 1L;

   // 日志输出接口
   private static final ILogger _logger = RLogger.find(FAbstractActionServlet.class);

   // 页面命令管理器
   protected IActionConsole _actionConsole;

   //============================================================
   // <T>初始化网络应用程序。</T>
   //
   // @param config 网络设置对象
   //============================================================
   @Override
   public void initialize(ServletConfig config){
      super.initialize(config);
      _actionConsole = RAop.find(IActionConsole.class);
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
      String redirect = null;
      FWebContext context = null;
      IWebSession session = null;
      Exception exception = null;
      long beginTick = System.nanoTime();
      try{
         String language = _sessionLanguage;
         String encoding = _sessionEncoding;
         // 建立会话
         boolean sessionExist = false;
         String sessionCode = null;
         if(_sessionValid){
            sessionCode = findSessionId(httpRequest);
            sessionExist = !RString.isEmpty(sessionCode);
            if(sessionExist){
               session = _sessionConsole.find(sessionCode);
            }else{
               sessionCode = RUuid.makeUniqueIdLower();
               session = _sessionConsole.build(sessionCode);
            }
            if(session != null){
               session.referIncrease();
               // 设置语言编码
               language = session.culture().countryLanguage();
               encoding = session.culture().countryEncoding();
               RCulture.link(session.culture());
            }
         }
         if(_logger.debugAble()){
            _logger.debug(this, "process", "Do{1} begin. (method={2}, language={3}, charset={4}, uri={5})", type, language, encoding, httpRequest.getRequestURI());
         }
         //............................................................
         // 建立环境
         httpRequest.setCharacterEncoding(encoding);
         context = new FWebContext(session, httpRequest, httpResponse);
         if(_logger.debugAble()){
            _logger.debug(this, "process", "Build context: {1}", context.dump());
         }
         _bindConsole.bind(IWebContext.class, context);
         _bindConsole.bind(IWebSession.class, session);
         //............................................................
         // 逻辑处理
         redirect = process(context);
         // 更新输出
         httpResponse.setContentType("text/html; charset=" + encoding);
         httpResponse.setCharacterEncoding(encoding);
         if(_sessionValid && !sessionExist){
            context.outputCookies().push(new FWebCookie(EWebConstants.SessionId, sessionCode));
         }
         updateResponse(context, httpRequest, httpResponse);
         // 画面转向
         if(!IActionResult.NO_REDIRECT.equals(redirect)){
            String uri = RString.nvl(redirect, context.requestUri());
            if(uri.endsWith(IActionConstant.WEB_ACTION)){
               uri = uri.substring(0, uri.length() - IActionConstant.WEB_ACTION_LEN);
            }else if(uri.endsWith(IActionConstant.WEB_PAGE)){
               uri = uri.substring(0, uri.length() - IActionConstant.WEB_PAGE_LEN);
            }
            if(!uri.endsWith(IActionConstant.JSP_PAGE)){
               uri += IActionConstant.JSP_PAGE;
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(uri);
            if(dispatcher != null){
               // 画面转向
               dispatcher.forward(httpRequest, httpResponse);
               redirect = uri;
            }
         }
      }catch(Exception e){
         exception = e;
      }finally{
         // 释放会话引用
         if(session != null){
            RCulture.unlink();
            session.referDecrease();
         }
         _bindConsole.clear();
         // 执行日志输出
         long endTick = System.nanoTime();
         if(null != exception){
            _logger.error(this, "process", exception);
         }else if(_logger.debugAble()){
            _logger.debug(this, "process", endTick - beginTick, "Do{1} end. (forward={2}）", type, redirect);
         }
      }
   }
}
