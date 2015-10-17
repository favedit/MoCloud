package org.mo.content.face.person;

import org.mo.com.lang.FObjectId;

//============================================================
//<P>用户容器</P>
//
//@class FProvincePage
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================

public class FAccountPage
      extends 
         FObjectId
{
   // 当前页
   protected int _pageCurrent;

   protected String result;

   public String result(){
      return result;
   }

   public void setResult(String result){
      this.result = result;
   }

   public int pageCurrent(){
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent){
      this._pageCurrent = _pageCurrent;
   }

}
