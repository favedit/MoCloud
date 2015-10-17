package org.mo.content.face.manage.product.business.news;

import org.mo.com.lang.FObjectId;
import org.mo.content.core.manage.product.business.news.FDataNewsInfo;

//============================================================
//<P>新闻容器</P>
//@class FNewsPage
//@version 1.0.0
//============================================================

public class FNewsPage extends FObjectId {
   // 当前页
   protected int _pageCurrent;

   // 页面信息处理结果
   protected String result;

   // 业务资讯数据单元
   protected FDataNewsInfo unit;

   public FDataNewsInfo getUnit() {
      return unit;
   }

   public void setUnit(FDataNewsInfo unit) {
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
