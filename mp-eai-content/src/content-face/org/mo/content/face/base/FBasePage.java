package org.mo.content.face.base;

import org.mo.com.lang.FObjectId;

//============================================================
//<P>公共容器</P>
//
//@class FBasePage
//@author Sunhr
//@Date 2014.9.19
//@version 1.0.0
//============================================================
public class FBasePage
      extends FObjectId
{
   //路径
   protected String _url;

   // 消息
   protected String _message;

   public String message(){
      return _message;
   }

   public void setMessage(String _message){
      this._message = _message;
   }

   public String url(){
      return _url;
   }

   public void setUrl(String _url){
      this._url = _url;
   }

}
