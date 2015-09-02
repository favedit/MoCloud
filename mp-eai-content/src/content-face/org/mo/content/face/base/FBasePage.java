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

   public String url(){
      return _url;
   }

   public void setUrl(String _url){
      this._url = _url;
   }

}
