package org.mo.content.face;

import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>首页接口。</P>
//
// @author maocy
// @version 150427
//============================================================
public interface IIndexAction
{
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   //============================================================
   String construct(IWebContext context);
}
