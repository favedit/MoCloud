package org.mo.content.core.manage.product.system.version;

import com.cyou.gccloud.data.data.FDataSystemVersionUnit;
import java.util.Map;

public class FDataVersionInfo extends FDataSystemVersionUnit {
   // 状态字符串
   protected String _statusCdStr;
   // 字符串
   protected String _forceCdStr;
   // 应用字符串
   protected String _applicationLabel;
   // 版本号字符串
   protected String _numberStr;

   public String statusCdStr() {
      return _statusCdStr;
   }

   public void setStatusCdStr(String _statusCdStr) {
      this._statusCdStr = _statusCdStr;
   }

   public String forceCdStr() {
      return _forceCdStr;
   }

   public void setForceCdStr(String _forceCdStr) {
      this._forceCdStr = _forceCdStr;
   }

   public String numberStr() {
      return _numberStr;
   }

   public void setNumberStr(String _numberStr) {
      this._numberStr = _numberStr;
   }

   public String applicationLabel() {
      return _applicationLabel;
   }

   public void setApplicationLabel(String _applicationLabel) {
      this._applicationLabel = _applicationLabel;
   }

   // ============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   // ============================================================
   @Override
   public void saveMap(Map<String, String> map) {
      super.saveMap(map);
      map.put("statusCdStr", _statusCdStr);
      map.put("forceCdStr", _forceCdStr);
      map.put("applicationLabel", _applicationLabel);
      map.put("numberStr", _numberStr);
   }
}
