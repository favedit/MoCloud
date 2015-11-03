package org.mo.content.face;

import org.mo.com.lang.FFatalError;
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
   // ============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   // ============================================================
   @Override
   public String construct(ISqlContext context,
                           FIndexPage areaPage,
                           IWebContext webContext){
      // System.out.println("*******************----------------->webContext.parameter"
      // + webContext.parameter("guid"));
      throw new FFatalError("findByMemberId memberId is null");
      //      return "Index";
   }
}
