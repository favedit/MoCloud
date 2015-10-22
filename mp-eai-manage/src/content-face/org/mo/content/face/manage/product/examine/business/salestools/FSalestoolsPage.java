package org.mo.content.face.manage.product.examine.business.salestools;

import org.mo.com.lang.FObjectId;
import org.mo.content.core.manage.product.examine.business.salestools.FDataSalestoolsInfo;

//============================================================
//<P>销售工具信息容器</P>
//@class FSalestoolsPage
//@version 1.0.0
//============================================================
public class FSalestoolsPage 
      extends 
         FObjectId 
{

   // 当前页
   protected int _pageCurrent;

   // 页面信息处理结果
   protected String result;

   // 业务资讯数据单元
   protected FDataSalestoolsInfo unit;

   public FDataSalestoolsInfo getUnit() {
      return unit;
   }

   public void setUnit(FDataSalestoolsInfo unit) {
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
