package org.mo.content.face.product.common;

import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import org.mo.com.lang.FObjectId;

//============================================================
//<P>区域信息容器</P>
//@class FAreaPage
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================

public class FAreaPage
      extends FObjectId
{
   // 当前页
   protected int _pageCurrent;

   //页面处理结果信息
   protected String result;

   //区域实体类
   protected FDataCommonAreaUnit unit;

   protected String dataInfo;

   public String dataInfo(){
      return dataInfo;
   }

   public void setDataInfo(String dataInfo){
      this.dataInfo = dataInfo;
   }

   public FDataCommonAreaUnit unit(){
      return unit;
   }

   public void setUnit(FDataCommonAreaUnit unit){
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
