package org.mo.content.face.manage.product.business.notice;

import org.mo.com.lang.FObjectId;
import org.mo.content.core.manage.product.business.notice.FDataNoticeInfo;

//============================================================
//<P>公告容器</P>
//@class FNoticePage
//@version 1.0.0
//============================================================

public class FNoticePage 
      extends 
         FObjectId 
{
   // 当前页
   protected int _pageCurrent;

   // 页面信息处理结果
   protected String result;

   // 业务资讯数据单元
   protected FDataNoticeInfo unit;

   public FDataNoticeInfo getUnit() {
      return unit;
   }

   public void setUnit(FDataNoticeInfo unit) {
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
