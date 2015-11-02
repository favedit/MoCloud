package org.mo.content.face.manage.product.financial.product;

import org.mo.com.lang.FObjectId;
import org.mo.content.core.manage.product.financial.product.FDataProductInfo;

//============================================================
//<P>产品信息容器</P>
//@class FProductPage
//@version 1.0.0
//============================================================
public class FProductPage
      extends 
         FObjectId
{
   // 当前页
   protected int _pageCurrent;

   //页面处理结果信息
   protected String result;

   //金融产品实体类
   protected FDataProductInfo unit;

   public FDataProductInfo unit(){
      return unit;
   }

   public void setUnit(FDataProductInfo unit){
      this.unit = unit;
   }

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
