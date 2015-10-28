package org.mo.content.face.manage.product.common;

import org.mo.com.lang.FObjectId;
import org.mo.content.core.manage.product.common.FDataCitycardInfo;

//============================================================
//<P>城市身份对照容器</P>
//@class FCitycardPage
//@version 1.0.0
//============================================================
public class FCitycardPage 
      extends 
         FObjectId 
{

// 当前页
   protected int _pageCurrent;

   // 页面处理结果信息
   protected String result;

   // 区域实体类
   protected FDataCitycardInfo unit;

   protected String dataInfo;

   public String dataInfo() {
      return dataInfo;
   }

   public void setDataInfo(String dataInfo) {
      this.dataInfo = dataInfo;
   }

   public FDataCitycardInfo unit() {
      return unit;
   }

   public void setUnit(FDataCitycardInfo unit) {
      this.unit = unit;
   }

   public String result() {
      return result;
   }

   public void setResult(String result) {
      this.result = result;
   }

   public int pageCurrent() {
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent) {
      this._pageCurrent = _pageCurrent;
   }

}
