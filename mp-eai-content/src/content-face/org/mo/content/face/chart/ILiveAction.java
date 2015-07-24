package org.mo.content.face.chart;

import org.mo.web.core.container.AContainer;

//============================================================
// <P>首页接口。</P>
//
// @author maocy
// @version 150427
//============================================================
public interface ILiveAction
{
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   String construct(@AContainer(name = "page") FLivePage page);

   //============================================================
   // <T>登录逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   String login(@AContainer(name = "page") FLivePage page);
}
