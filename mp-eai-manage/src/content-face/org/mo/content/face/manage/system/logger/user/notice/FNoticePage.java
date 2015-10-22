package org.mo.content.face.manage.system.logger.user.notice;

import org.mo.com.lang.FObjectId;
import org.mo.content.core.manage.system.logger.user.notice.FDataNoticeInfo;

//============================================================
//<P>公告日志容器</P>
//@class FNoticeloggerPage
//@version 1.0.0
//============================================================
public class FNoticePage 
      extends 
         FObjectId 
{
   // 当前页
   protected int _pageCurrent;

   protected String result;

   protected FDataNoticeInfo unit;

   public String result() {
      return result;
   }

   public void setResult(String result) {
      this.result = result;
   }

   public String unit() {
      return result;
   }

   public void setUnit(FDataNoticeInfo unit) {
      this.unit = unit;
   }

   public int pageCurrent() {
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent) {
      this._pageCurrent = _pageCurrent;
   }

}
