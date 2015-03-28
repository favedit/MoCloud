package org.mo.web.core.action.common;

import org.mo.com.lang.FObject;

//============================================================
// <T>COOKIE。</T>
//============================================================
public class FWebCookie
      extends FObject
      implements
         IWebCookie
{
   // 名称
   protected String _name;

   // 内容
   protected String _value;

   //============================================================
   // <T>构造COOKIE。</T>
   //============================================================
   public FWebCookie(){
   }

   //============================================================
   // <T>构造COOKIE。</T>
   //
   // @param name 名称
   // @param value 内容
   //============================================================
   public FWebCookie(String name,
                     String value){
      _name = name;
      _value = value;
   }

   //============================================================
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================
   @Override
   public String name(){
      return _name;
   }

   //============================================================
   // <T>获得内容。</T>
   //
   // @return 内容
   //============================================================
   @Override
   public String value(){
      return _value;
   }
}
