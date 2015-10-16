package org.mo.content.face.manage.product.business.truetime;

import org.mo.com.lang.FObjectId;
import org.mo.content.core.manage.product.business.truetime.FDataTruetimeInfo;

//============================================================
//<P>实时数据容器</P>
//@class FTruetimePage
//@version 1.0.0
//============================================================
public class FTruetimePage extends FObjectId {

   // 当前页
   protected int _pageCurrent;

   // 页面信息处理结果
   protected String result;

   // 业务资讯数据单元
   protected FDataTruetimeInfo unit;

   public FDataTruetimeInfo getUnit() {
      return unit;
   }

   public void setUnit(FDataTruetimeInfo unit) {
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
