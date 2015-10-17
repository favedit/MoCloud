package org.mo.content.core.manage.product.common.configration.rule;

import java.util.Map;

import com.cyou.gccloud.data.data.FDataControlRuleUnit;
//============================================================
//<P>规则配置信息</P>
//@class FDataRuleInfo
//@version 1.0.0
//============================================================
public class FDataRuleInfo extends FDataControlRuleUnit {

   //规则状态字符串
   private String _ruleCdStr;

   public String getRuleCdStr() {
      return _ruleCdStr;
   }
   public void setRuleCdStr(String _ruleCdStr) {
      this._ruleCdStr=_ruleCdStr;
   }
   //============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   //============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("ruleCdStr", _ruleCdStr);
   }
}
