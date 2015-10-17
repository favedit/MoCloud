package org.mo.content.face.manage.product.user.logger;

import org.mo.com.lang.FObjectId;
import org.mo.content.core.manage.product.user.logger.FDataAccessInfo;

//============================================================
//<P>用户容器</P>
//@class FAccessPage
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================
public class FAccessPage 
      extends 
         FObjectId 
{
   // 当前页
   protected int _pageCurrent;

   protected String result;

   protected FDataAccessInfo unit;

   public String result() {
      return result;
   }

   public void setResult(String result) {
      this.result = result;
   }

   public String unit() {
      return result;
   }

   public void setUnit(FDataAccessInfo unit) {
      this.unit = unit;
   }

   public int pageCurrent() {
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent) {
      this._pageCurrent = _pageCurrent;
   }

}
