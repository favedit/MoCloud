package org.mo.content.face.manage.product.examine.business.truetime;

import com.cyou.gccloud.data.data.FDataLogicTruetimeUnit;
import org.mo.com.lang.FObjectId;

//============================================================
//<P>实时数据容器</P>
//@class FNewsPage
//============================================================
public class FTruetimePage 
      extends 
         FObjectId 
{

   // 当前页
   protected int _pageCurrent;

   // 业务资讯数据单元
   protected FDataLogicTruetimeUnit unit;

   public FDataLogicTruetimeUnit getUnit() {
      return unit;
   }

   public void setUnit(FDataLogicTruetimeUnit unit) {
      this.unit = unit;
   }

   public int pageCurrent() {
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent) {
      this._pageCurrent = _pageCurrent;
   }
}
