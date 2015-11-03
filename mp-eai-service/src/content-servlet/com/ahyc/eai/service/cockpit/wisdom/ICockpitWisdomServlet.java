package com.ahyc.eai.service.cockpit.wisdom;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>理财师信息处理接口。</T>
//============================================================
public interface ICockpitWisdomServlet
{

   //============================================================
   // <T>e租宝财富端本月业绩列表</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   EResult fetch(IWebContext context,
                 ILogicContext logicContext,
                 IWebServletRequest request,
                 IWebServletResponse response);
}
