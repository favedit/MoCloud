package com.ahyc.eai.service.financial.tender;

import org.mo.com.lang.EResult;
import org.mo.com.lang.FDictionary;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.servlet.common.IWebServletRequest;
import org.mo.web.core.servlet.common.IWebServletResponse;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>理财师信息处理接口。</T>
//============================================================
public interface IStatisticsTenderServlet
{
   //============================================================
   // <T>获得投资类型集合。</T>
   //
   // @param logicContext 逻辑环境
   // @return 投资类型集合
   //============================================================
   FDictionary<Double> fetchModels(ILogicContext logicContext);

   //============================================================
   // <T>获得投资产品数据。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   EResult info(IWebContext context,
                ILogicContext logicContext,
                IWebServletRequest request,
                IWebServletResponse response);

   //============================================================
   // <T>获得投资产品动态数据。</T>
   //
   // @param context 环境
   // @param logicContext 逻辑环境
   // @param request 请求
   // @param response 应答
   //============================================================
   EResult dynamic(IWebContext context,
                   ILogicContext logicContext,
                   IWebServletRequest request,
                   IWebServletResponse response);
}
