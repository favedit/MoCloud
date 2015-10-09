package org.mo.content.face.manage.product.user.signing;

import com.cyou.gccloud.data.data.FDataPersonUserSigningUnit;
import org.mo.com.lang.FObjectId;

public class FSigningPage extends FObjectId {

   // 当前页
   protected int _pageCurrent;

   // 业务资讯数据单元
   protected FDataPersonUserSigningUnit unit;

   public FDataPersonUserSigningUnit getUnit() {
      return unit;
   }

   public void setUnit(FDataPersonUserSigningUnit unit) {
      this.unit = unit;
   }

   public int pageCurrent() {
      return _pageCurrent;
   }

   public void setPageCurrent(int _pageCurrent) {
      this._pageCurrent = _pageCurrent;
   }

}
