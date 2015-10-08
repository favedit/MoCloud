package org.mo.content.face.manage.product.common.configration;

import com.cyou.gccloud.data.data.FDataCommonConfigurationUnit;
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

   //页面处理结果信息
   protected String result;

   //配置信息实体类
   protected FDataCommonConfigurationUnit unit;

   public FDataCommonConfigurationUnit unit(){
      return unit;
   }

   public void setUnit(FDataCommonConfigurationUnit unit){
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
