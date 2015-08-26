package org.mo.web.core.common;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.IAttributes;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.core.bind.IBindConsole;
import org.mo.web.core.action.common.IWebCookie;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.common.IWebServlet;
import org.mo.web.protocol.context.FWebContext;
import org.mo.web.protocol.context.IWebResponse;

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
   // @param config 网络设置对象
   //============================================================
   @Override
   public void initialize(ServletConfig config){
      _bindConsole = RAop.find(IBindConsole.class);
      _sessionConsole = RAop.find(IWebSessionConsole.class);
      _sessionValid = _sessionConsole.isValid();
      _sessionTimeout = (int)(_sessionConsole.timeout() / 1000);
   }

   //============================================================
   // <T>初始化网络应用程序。</T>
   //
   // @param config 页面设置对象
   //============================================================
   @Override
   public void init(ServletConfig config) throws ServletException{
      super.init(config);
      // 初始化设置
      try{
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
   // <T>响应网页的Post访问请求。</T>
   //
   // @param request 页面请求对象
   // @param response 页面响应对象
   //============================================================
   @Override
   protected void doOptions(HttpServletRequest request,
                            HttpServletResponse response) throws ServletException, IOException{
      process(IWebServlet.METHOD_OPTIONS, request, response);
   }

   //============================================================
   // <T>获得会话信息。</T>
   //
   // @param httpRequest 页面请求对象
   // @return 会话编号
   //============================================================
   public String findSessionId(HttpServletRequest httpRequest){
      String sessionCode = null;
      // 检查有效性
      if(_sessionValid){
         // 从请求信息中获得会话编号
         String url = httpRequest.getQueryString();
         if((url != null) && url.contains("&sid=")){
            sessionCode = RString.mid(url, "&sid=", "&");
         }
         // 从头信息中获得会话编号
         if(RString.isEmpty(sessionCode)){
            sessionCode = httpRequest.getHeader(EWebConstants.SessionId);
         }
         // 从COOKIE中获得会话编号
         if(RString.isEmpty(sessionCode)){
            Cookie[] cookies = httpRequest.getCookies();
            if(cookies != null){
               for(Cookie cookie : cookies){
                  if(EWebConstants.SessionId.equals(cookie.getName())){
                     sessionCode = cookie.getValue();
                  }
               }
            }
         }
      }
      return sessionCode;
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
      // 查找会话编号
      String sessionCode = findSessionId(httpRequest);
      if(!RString.isEmpty(sessionCode)){
         session = _sessionConsole.find(sessionCode);
      }
      //      // 查找会话对象
      //      if(session == null){
      //         // 建立会话内容
      //         session = _sessionConsole.build(sessionCode);
      //         // 设置会话信息
      //         Cookie cookie = new Cookie(EWebConstants.SessionId, session.id());
      //         cookie.setPath("/");
      //         cookie.setMaxAge((int)(_sessionConsole.timeout() / 1000));
      //         httpResponse.addCookie(cookie);
      //      }
      // 绑定会话内容
      if(session != null){
         _bindConsole.bind(IWebSession.class, session);
      }
      return session;
   }

   //============================================================
   // <T>更新输出内容。</T>
   //
   // @param context 页面环境
   // @param httpRequest 页面请求对象
   // @param httpResponse 页面响应对象
   //============================================================
   public void updateResponse(FWebContext context,
                              HttpServletRequest httpRequest,
                              HttpServletResponse httpResponse){
      // 建立输出头信息
      IWebResponse response = context.response();
      FAttributes heads = response.heads();
      if(!heads.isEmpty()){
         int count = heads.count();
         for(int i = 0; i < count; i++){
            String headName = heads.name(i);
            String headValue = heads.value(i);
            httpResponse.setHeader(headName, headValue);
         }
      }
      // 设置默认COOKIE
      if(context.testCookieChanged()){
         IAttributes cookies = context.cookies();
         if(_logger.debugAble()){
            _logger.debug(this, "process", "Set cookies. {cookies={1}}", cookies.dump());
         }
         Cookie cookie = new Cookie("MOCK", cookies.pack().toString());
         cookie.setMaxAge(60 * 60 * 24 * 365);
         httpResponse.addCookie(cookie);
      }
      // 更新输出COOKIE
      if(context.hasOutputCookies()){
         FObjects<IWebCookie> webCookies = context.outputCookies();
         for(IWebCookie webCookie : webCookies){
            String cookieName = webCookie.name();
            String cookieValue = webCookie.value();
            int expiry = webCookie.expiry();
            if(_logger.debugAble()){
               _logger.debug(this, "process", "Set cookie. {name={1}, value={2}, expiry={3}}", cookieName, cookieValue, expiry);
            }
            Cookie cookie = new Cookie(cookieName, cookieValue);
            cookie.setPath("/");
            cookie.setMaxAge(expiry);
            httpResponse.addCookie(cookie);
         }
      }
   }
}
