package org.mo.content.face.manage.product.examine.business.news;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import org.mo.com.lang.FObjectId;

//============================================================
//<P>新闻容器</P>
//@class FNewsPage
//@author AnjoyTian
//@version 1.0.0
//============================================================

public class FNewsPage extends FObjectId {
   // 当前页
   protected int _pageCurrent;

   // 业务资讯数据单元
   protected FDataLogicNewsUnit unit;

   public FDataLogicNewsUnit getUnit() {
      return unit;
   }

   public void setUnit(FDataLogicNewsUnit unit) {
      this.unit = unit;
   }

   public int pageCurrent() {
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent) {
      this._pageCurrent = _pageCurrent;
   }

}
