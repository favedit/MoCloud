package com.ahyc.eai.service.cockpit.achievement;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>驾驶舱业绩处理接口。</T>
//============================================================
public interface ICockpitAchievementServlet
{
   //============================================================
   // <T>获得统计动态数据。</T>
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
