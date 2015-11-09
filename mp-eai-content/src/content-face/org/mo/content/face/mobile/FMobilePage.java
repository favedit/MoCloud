package org.mo.content.face.mobile;

import org.mo.com.lang.FObjectId;

//============================================================
//<P客户信息容器</P>
//@class FCustomerPage
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public class FMobilePage
      extends FObjectId
{
   protected String _downloadUrl;
   
   public String downloadUrl(){
      return _downloadUrl;
   }
   
   public void setDownloadUrl(String _downloadUrl){
      this._downloadUrl = _downloadUrl;
   }
   
}
