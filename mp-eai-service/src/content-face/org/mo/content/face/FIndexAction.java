package org.mo.content.face;

import org.mo.content.face.service.news.FNewsPage;
import org.mo.eng.data.common.ISqlContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>首页。</P>
//
// @author maocy
// @version 150427
//============================================================
public class FIndexAction
      implements
         IIndexAction
{
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(ISqlContext context,
                           FIndexPage areaPage,
                           IWebContext webContext){
      //      System.out.println("*******************----------------->webContext.parameter" + webContext.parameter("guid"));
      return "/service/news/News.wa?do=getNewInfo";
   }

   @Override
   public String getNewsInfo(IWebContext webContext,
                             FIndexPage areaPage,
                             FNewsPage page){

      page.setResult(webContext.parameter("guid"));
      System.out.println(page.result() + "--------------------------");
      return "/service/news/News.wa?do=getNewInfo";
   }
}
