package org.mo.content.core.manage.product.user.logger;

import com.cyou.gccloud.data.logger.FLoggerPersonUserAccessUnit;
import java.util.Map;

public class FDataAccessInfo extends FLoggerPersonUserAccessUnit {

   // 状态字符串
   protected String _beginDateStr;
   // 字符串
   protected String _endDateStr;

   public String beginDateStr() {
      return _beginDateStr;
   }

   public void setBeginDateStr(String _beginDateStr) {
      this._beginDateStr = _beginDateStr;
   }

   public String endDateStr() {
      return _endDateStr;
   }

   public void setEndDateStr(String _endDateStr) {
      this._endDateStr = _endDateStr;
   }

   // ============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   // ============================================================
   @Override
   public void saveMap(Map<String, String> map) {
      super.saveMap(map);
      map.put("beginDateStr", _beginDateStr);
      map.put("endDateStr", _endDateStr);
   }
}
