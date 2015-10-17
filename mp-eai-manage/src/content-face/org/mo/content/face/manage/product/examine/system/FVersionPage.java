package org.mo.content.face.manage.product.examine.system;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import com.cyou.gccloud.data.data.FDataSystemVersionUnit;

import org.mo.com.lang.FObjectId;

//============================================================
//<P>版本容器</P>
//@class FVersionPage
//@version 1.0.0
//============================================================

public class FVersionPage 
      extends 
         FObjectId 
{
   // 当前页
   protected int _pageCurrent;

   // 业务资讯数据单元
   protected FDataSystemVersionUnit unit;

   public FDataSystemVersionUnit getUnit() {
      return unit;
   }

   public void setUnit(FDataSystemVersionUnit unit) {
      this.unit = unit;
   }

   public int pageCurrent() {
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent) {
      this._pageCurrent = _pageCurrent;
   }

}
