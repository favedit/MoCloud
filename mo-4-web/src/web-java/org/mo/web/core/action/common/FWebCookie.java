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

   // 期限
   protected int _expiry = -1;

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
   // <T>构造COOKIE。</T>
   //
   // @param name 名称
   // @param value 内容
   // @param expiry 期限
   //============================================================
   public FWebCookie(String name,
                     String value,
                     int expiry){
      _name = name;
      _value = value;
      _expiry = expiry;
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

   //============================================================
   // <T>获得期限。</T>
   //
   // @return 期限
   //============================================================
   @Override
   public int expiry(){
      return _expiry;
   }
}
