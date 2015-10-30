package org.mo.content.core.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonCityCardUnit;
import java.util.Map;

//============================================================
//<P>城市省份证信息</P>
//@class FDataCitycardInfo
//@version 1.0.0
//============================================================
public class FDataCitycardInfo
      extends FDataCommonCityCardUnit
{
   //存储城市名称
   private String _cityLabel;

   public String cityLabel(){
      return _cityLabel;
   }

   public void setCityLabel(String _cityLabel){
      this._cityLabel = _cityLabel;
   }

   //============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   //============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("cityLabel", _cityLabel);
      map.put("provinceId", _provinceId + "");
      map.put("areaId", _areaId + "");
      map.put("countryId", _countryId + "");
   }
}
