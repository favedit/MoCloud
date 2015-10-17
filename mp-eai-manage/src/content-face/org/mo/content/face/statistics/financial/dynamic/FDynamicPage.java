package org.mo.content.face.statistics.financial.dynamic;

import com.cyou.gccloud.data.data.FDataInfoDeviceBrowserUnit;
import org.mo.com.lang.FObjectId;

//============================================================
//<P>用户容器</P>
//
//@class FDynamicPage
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================

public class FDynamicPage
      extends FObjectId
{
   // 当前页
   protected int _pageCurrent;

   protected String result;

   protected FDataInfoDeviceBrowserUnit unit;

   protected String dataInfo;

   public String dataInfo(){
      return dataInfo;
   }

   public void setDataInfo(String dataInfo){
      this.dataInfo = dataInfo;
   }

   public FDataInfoDeviceBrowserUnit unit(){
      return unit;
   }

   public void setUnit(FDataInfoDeviceBrowserUnit unit){
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
