package org.mo.content.face.manage.product.system.application;

import org.mo.com.lang.FObjectId;

import com.cyou.gccloud.data.data.FDataSystemApplicationUnit;
//============================================================
//<P>应用容器</P>
//@class FApplicationPage
//@version 1.0.0
//============================================================
public class FApplicationPage 
      extends 
         FObjectId 
{
   // 当前页
   protected int _pageCurrent;

   //页面信息处理结果
   protected String result;
   
   //业务资讯数据单元
   protected FDataSystemApplicationUnit unit;

   public FDataSystemApplicationUnit getUnit() {
      return unit;
   }

   public void setUnit(FDataSystemApplicationUnit unit) {
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
