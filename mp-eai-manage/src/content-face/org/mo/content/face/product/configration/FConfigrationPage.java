package org.mo.content.face.product.configration;

import org.mo.com.lang.FObjectId;

//============================================================
//<P>配置信息容器</P>
//
//@class FConfigrationPage
//@author Sunhr
//@Date 2015.09.09  
//@version 1.0.0
//============================================================

public class FConfigrationPage
      extends FObjectId
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
