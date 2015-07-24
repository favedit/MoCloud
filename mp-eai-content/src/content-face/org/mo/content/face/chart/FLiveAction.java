package org.mo.content.face.chart;

//============================================================
// <P>首页。</P>
//
// @author maocy
// @version 150427
//============================================================
public class FLiveAction
      implements
         ILiveAction
{
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(FLivePage page){
      return "Login";
   }

   @Override
   public String login(FLivePage page){
      return "Live";
   }
}
