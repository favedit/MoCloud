package org.mo.content.core.manage.product.user.signing;

import com.cyou.gccloud.data.data.FDataPersonUserSigningUnit;
import java.util.Map;

public class FDataSigningInfo extends FDataPersonUserSigningUnit {
   // 用户标签名
   protected String _userLabel;

   public String userLabel() {
      return _userLabel;
   }

   public void setUserLabel(String _userLabel) {
      this._userLabel = _userLabel;
   }

   // ============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   // ============================================================
   @Override
   public void saveMap(Map<String, String> map) {
      super.saveMap(map);
      map.put("userLabel", _userLabel);
   }
}
