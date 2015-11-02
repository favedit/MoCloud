package org.mo.content.core.manage.product.financial.product;

import java.util.Map;

import com.cyou.gccloud.data.data.FDataFinancialProductUnit;

public class FDataProductInfo
      extends 
         FDataFinancialProductUnit
{

   private String _makeUrl;

   public String makeUrl(){
      return _makeUrl;
   }

   public void setMakeUrl(String _makeUrl){
      this._makeUrl = _makeUrl;
   }

   // ============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   // ============================================================
   @Override
   public void saveMap(Map<String, String> map) {
      super.saveMap(map);
      map.put("makeUrl", _makeUrl);
   }
}
