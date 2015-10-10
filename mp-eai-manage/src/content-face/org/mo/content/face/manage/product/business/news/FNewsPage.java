package org.mo.content.face.manage.product.business.news;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;

import org.mo.com.lang.FObjectId;

//============================================================
//<P>理财师信息容器</P>
//@class FMarketerPage
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public class FNewsPage
      extends FObjectId
{
   // 当前页
   protected int _pageCurrent;

   //页面信息处理结果
   protected String result;
   
   //业务资讯数据单元
   protected FDataLogicNewsUnit unit;

   public FDataLogicNewsUnit getUnit() {
      return unit;
   }

   public void setUnit(FDataLogicNewsUnit unit) {
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
