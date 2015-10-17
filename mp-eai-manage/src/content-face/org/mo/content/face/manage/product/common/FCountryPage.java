package org.mo.content.face.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonCountryUnit;
import org.mo.com.lang.FObjectId;

//============================================================
//<P>国家信息容器</P>
//@class FCountryPage
//@version 1.0.0
//============================================================
public class FCountryPage
      extends 
         FObjectId
{
   // 当前页
   protected int _pageCurrent;

   //页面处理结果信息
   protected String result;

   //国家实体类
   protected FDataCommonCountryUnit unit;

   protected String dataInfo;

   public String dataInfo(){
      return dataInfo;
   }

   public void setDataInfo(String dataInfo){
      this.dataInfo = dataInfo;
   }

   public FDataCommonCountryUnit unit(){
      return unit;
   }

   public void setUnit(FDataCommonCountryUnit unit){
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
