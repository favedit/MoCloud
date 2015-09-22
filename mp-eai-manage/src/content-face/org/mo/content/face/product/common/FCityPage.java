package org.mo.content.face.product.common;

import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import org.mo.com.lang.FObjectId;

//============================================================
//<P>城市信息容器</P>
//@class FCityPage
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public class FCityPage
      extends FObjectId
{
   // 当前页
   protected int _pageCurrent;

   //页面处理信息结果
   protected String result;

   //城市实体类
   protected FDataCommonCityUnit unit;

   public FDataCommonCityUnit unit(){
      return unit;
   }

   public void setUnit(FDataCommonCityUnit unit){
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
