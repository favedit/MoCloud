package org.mo.web.core.servlet.common;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.HttpServletRequest;
import org.mo.com.lang.FFatalError;

//============================================================
// <T>网页请求。</T>
//============================================================
public class FWebServletRequest
      implements
         IWebServletRequest
{
   // 请求内容
   private final HttpServletRequest _request;

   //============================================================
   // <T>构造网页请求。</T>
   //
   // @param request 请求
   //============================================================
   public FWebServletRequest(HttpServletRequest request){
      _request = request;
   }

   //============================================================
   // <T>获得输出流。</T>
   //
   // @return 输出流
   //============================================================
   @Override
   public InputStream inputStream(){
      try{
         return _request.getInputStream();
      }catch(IOException e){
         throw new FFatalError(e);
      }
   }
}
