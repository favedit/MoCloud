package org.mo.eai.console.financial;

import org.mo.data.logic.ILogicContext;

//============================================================
// <T>金融理财师控制台接口。</T>
//============================================================
public interface IFinancialMarketerConsole
{
   //============================================================
   // <T>根据理登录名称查找理财师信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param passport 登录名称
   // @return 理财师信息
   //============================================================
   FFinancialMarketerInfo findInfo(ILogicContext logicContext,
                                   String passport);
}
