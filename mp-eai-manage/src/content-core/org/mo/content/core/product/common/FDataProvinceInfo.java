package org.mo.content.core.product.common;

import com.cyou.gccloud.data.data.FDataCommonProvinceUnit;
import java.util.Map;
import org.mo.core.aop.face.ASourceMachine;

@ASourceMachine
public class FDataProvinceInfo
      extends FDataCommonProvinceUnit
{
   // 存储国家名称
   private String _countryLabel;

   //存储区域名称
   private String _areaLabel;

   public String areaLabel(){
      return _areaLabel;
   }

   public void setAreaLabel(String _areaLabel){
      this._areaLabel = _areaLabel;
   }

   public String countryLabel(){
      return _countryLabel;
   }

   public void setCountryLabel(String _countryLabel){
      this._countryLabel = _countryLabel;
   }

   //============================================================
   // <T>保存对照表。</T>
   //
   // @param map 对照表
   //============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("countryLabel", _countryLabel);
      map.put("areaLabel", _areaLabel);
   }
}
