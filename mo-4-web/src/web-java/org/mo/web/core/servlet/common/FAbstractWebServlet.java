package org.mo.web.core.servlet.common;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mo.com.lang.cultrue.RCulture;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.core.bind.IBindConsole;
import org.mo.web.core.servlet.IWebServletConsole;
import org.mo.web.core.servlet.IWebServletConstant;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.common.IWebServlet;
import org.mo.web.protocol.context.FWebContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>页面处理虚类。</T>
// <P>1. 初始化数据，创建全局应用管理对象。</P>
// <P>2. 根据页面请求，执行相应业务处理。</P>
//============================================================
public abstract class FAbstractWebServlet
      extends HttpServlet
{
   // 序列化编号
   private static final long serialVersionUID = 1L;

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FAbstractWebServlet.class);

   // 绑定控制台
   protected IBindConsole _bindConsole;

   // 网页会话控制台
   protected IWebSessionConsole _sessionConsole;

   // 网页处理控制台
   protected IWebServletConsole _servletConsole;

   // 会话允许
   protected boolean _sessionVaild;

   //============================================================
   // <T>响应网页的Get请求。</T>
   //
   // @param request 网络请求对象
   // @param response 网络响应对象
   //============================================================
   @Override
   protected void doGet(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException{
      process(IWebServlet.METHOD_GET, request, response);
   }

   //============================================================
   // <T>响应网页的Post请求。</T>
   //
   // @param request 网络请求对象
   // @param response 网络响应对象
   //============================================================
   @Override
   protected void doPost(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException{
      process(IWebServlet.METHOD_POST, request, response);
   }

   //============================================================
   // <T>初始化网络应用程序。</T>
   //
   // @param config 网络设置对象
   //============================================================
   public void initialize(ServletConfig config){
   }

   //============================================================
   // <T>初始化网络应用程序。</T>
   //
   // @param config 网络设置对象
   //============================================================
   @Override
   public void init(ServletConfig config) throws ServletException{
      super.init(config);
      try{
         _bindConsole = RAop.find(IBindConsole.class);
         _sessionConsole = RAop.find(IWebSessionConsole.class);
         _servletConsole = RAop.find(IWebServletConsole.class);
         _sessionVaild = _sessionConsole.isValid();
         initialize(config);
      }catch(Exception e){
         _logger.error(this, "init", e);
      }
   }

   //============================================================
   // <T>网页请求逻辑对象执行开始。</T>
   //
   // @param name 名称
   // @param context 环境
   // @param request 请求
   // @param response 应答
   //============================================================
   public abstract void process(String name,
                                IWebContext context,
                                IWebServletRequest request,
                                IWebServletResponse response);

   //============================================================
   // <T>网页请求逻辑对象执行开始。</T>
   //
   // @param httpRequest 网络请求对象
   // @param httpResponse 网络响应对象
   //============================================================
   public void process(String type,
                       HttpServletRequest httpRequest,
                       HttpServletResponse httpResponse){
      String redirect = null;
      FWebContext context = null;
      IWebSession session = null;
      long startTime = System.currentTimeMillis();
      try{
         String language = "cn";
         String encoding = "utf-8";
         // 建立会话
         if(_sessionVaild){
            session = _sessionConsole.build(httpRequest.getSession().getId());
            session.referIncrease();
            // 设置语言编码
            language = session.culture().countryLanguage();
            encoding = session.culture().countryEncoding();
            RCulture.link(session.culture());
         }
         if(_logger.debugAble()){
            _logger.debug(this, "process", "Do{1} Begin - [{2}] (lang={3}, charset={4})", type, httpRequest.getRequestURI(), language, encoding);
         }
         // Build context
         httpRequest.setCharacterEncoding(encoding);
         context = new FWebContext(session, httpRequest, httpResponse);
         httpResponse.setCharacterEncoding(encoding);
         if(_logger.debugAble()){
            _logger.debug(this, "process", "Build context: {1}", context.dump());
         }
         _bindConsole.bind(IWebContext.class, context);
         if(session != null){
            _bindConsole.bind(IWebSession.class, session);
         }
         // 查找服务类型
         boolean process = false;
         String uri = context.requestUri();
         if(uri.startsWith(IWebServletConstant.WEB_SERVLET_URL)){
            uri = uri.substring(IWebServletConstant.WEB_SERVLET_URL_LEN);
            process = true;
         }else if(uri.endsWith(IWebServletConstant.WEB_SERVLET)){
            uri = uri.substring(0, uri.length() - 3);
            int find = uri.lastIndexOf('/');
            if(find != -1){
               uri = uri.substring(find + 1);
            }
            process = true;
         }
         // 执行逻辑过程
         if(process){
            FWebServletRequest webRequest = new FWebServletRequest(httpRequest);
            FWebServletResponse webResponse = new FWebServletResponse(httpResponse);
            process(uri, context, webRequest, webResponse);
            httpResponse.flushBuffer();
         }
      }catch(Exception e){
         _logger.error(this, "process", e);
      }finally{
         if(session != null){
            session.referDecrease();
         }
         try{
            RCulture.unlink();
            _bindConsole.clear();
         }catch(Exception e){
            _logger.error(this, "process", e);
         }
         long endTime = System.currentTimeMillis();
         if(_logger.debugAble()){
            _logger.debug(this, "process", "Do{1} End - [{2}ms] {3}", type, endTime - startTime, redirect);
         }
      }
   }
}
