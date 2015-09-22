package org.mo.content.face.product.financial.product;

import com.cyou.gccloud.data.data.FDataFinancialProductUnit;
import org.mo.com.lang.FObjectId;

//============================================================
//<P>产品信息容器</P>
//@class FProductPage
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public class FProductPage
      extends FObjectId
{
   // 当前页
   protected int _pageCurrent;

   //页面处理结果信息
   protected String result;

   //金融产品实体类
   protected FDataFinancialProductUnit unit;

   public FDataFinancialProductUnit unit(){
      return unit;
   }

   public void setUnit(FDataFinancialProductUnit unit){
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
