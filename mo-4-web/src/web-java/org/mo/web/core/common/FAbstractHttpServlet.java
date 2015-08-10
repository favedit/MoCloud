package org.mo.web.core.common;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.core.bind.IBindConsole;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.common.IWebServlet;

//============================================================
// <T>网络处理。</T>
//============================================================
public abstract class FAbstractHttpServlet
      extends HttpServlet
      implements
         IHttpServlet
{
   // 序列化标识
   private static final long serialVersionUID = 1L;

   // 日志输出接口
   private static final ILogger _logger = RLogger.find(FAbstractHttpServlet.class);

   // 数据绑定管理器
   protected IBindConsole _bindConsole;

   // 页面会话管理器
   protected IWebSessionConsole _sessionConsole;

   // 会话允许
   protected boolean _sessionValid;

   // 页面会话超时
   protected int _sessionTimeout;

   // 会话语言
   protected String _sessionLanguage = "cn";

   // 会话编码
   protected String _sessionEncoding = "utf-8";

   //============================================================
   // <T>初始化网络应用程序。</T>
   //
   // @param config 页面设置对象
   //============================================================
   @Override
   public void init(ServletConfig config) throws ServletException{
      super.init(config);
      // 设置关联
      _bindConsole = RAop.find(IBindConsole.class);
      _sessionConsole = RAop.find(IWebSessionConsole.class);
      _sessionValid = _sessionConsole.isValid();
      _sessionTimeout = (int)(_sessionConsole.timeout() / 1000);
      try{
         // 初始化设置
         initialize(config);
      }catch(Exception e){
         _logger.error(this, "init", e);
      }
   }

   //============================================================
   // <T>响应网页的Get访问请求。</T>
   //
   // @param request 页面请求对象
   // @param response 页面响应对象
   //============================================================
   @Override
   protected void doGet(HttpServletRequest request,
                        HttpServletResponse response) throws ServletException, IOException{
      process(IWebServlet.METHOD_GET, request, response);
   }

   //============================================================
   // <T>响应网页的Post访问请求。</T>
   //
   // @param request 页面请求对象
   // @param response 页面响应对象
   //============================================================
   @Override
   protected void doPost(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException{
      process(IWebServlet.METHOD_POST, request, response);
   }

   //============================================================
   // <T>生成会话信息。</T>
   //
   // @param httpRequest 页面请求对象
   // @param httpResponse 页面响应对象
   //============================================================
   public IWebSession makeSession(HttpServletRequest httpRequest,
                                  HttpServletResponse httpResponse){
      IWebSession session = null;
      // 建立会话
      if(_sessionValid){
         // 获得会话编号
         String sessionCode = httpRequest.getHeader(EWebConstants.SessionId);
         if(RString.isEmpty(sessionCode)){
            HttpSession httpSession = httpRequest.getSession();
            sessionCode = httpSession.getId();
            int inactiveInterval = httpSession.getMaxInactiveInterval();
            if(inactiveInterval != _sessionTimeout){
               httpSession.setMaxInactiveInterval(_sessionTimeout);
            }
         }
         session = _sessionConsole.find(sessionCode);
         if(session == null){
            // 建立会话内容
            session = _sessionConsole.build(sessionCode);
            // 设置会话信息
            Cookie cookie = new Cookie(EWebConstants.SessionId, session.id());
            cookie.setPath("/");
            cookie.setMaxAge((int)(_sessionConsole.timeout() / 1000));
            httpResponse.addCookie(cookie);
         }
         // 绑定会话内容
         _bindConsole.bind(IWebSession.class, session);
      }
      return session;
   }
}
