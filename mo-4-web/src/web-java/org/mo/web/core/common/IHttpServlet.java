package org.mo.web.core.common;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//============================================================
// <T>页面处理接口。</T>
//============================================================
public interface IHttpServlet
{
   // 获得方法
   String METHOD_GET = "Get";

   // 提交方法
   String METHOD_POST = "Post";

   //============================================================
   // <T>初始化数据，创建全局应用管理对象。</T>
   //
   // @param config 页面设置对象
   //============================================================
   void initialize(ServletConfig config);

   //============================================================
   // <T>网页请求逻辑对象执行开始。</T>
   //
   // @param httpRequest 页面请求对象
   // @param httpResponse 页面响应对象
   //============================================================
   void process(String type,
                HttpServletRequest httpRequest,
                HttpServletResponse httpResponse);
}
