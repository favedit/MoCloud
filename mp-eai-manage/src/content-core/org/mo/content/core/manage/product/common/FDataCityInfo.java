package org.mo.content.core.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import java.util.Map;
import org.mo.core.aop.face.ASourceMachine;
//============================================================
//<P>城市信息</P>
//@class FDataCityInfo
//@version 1.0.0
//============================================================
@ASourceMachine
public class FDataCityInfo
      extends 
         FDataCommonCityUnit
{
   // 存储国家名称
   private String _countryLabel;

   //存储区域名称
   private String _areaLabel;

   //存储省会名称
   private String _provinceLabel;

   public String areaLabel(){
      return _areaLabel;
   }

   public void setAreaLabel(String _areaLabel){
      this._areaLabel = _areaLabel;
   }

   public String provinceLabel(){
      return _provinceLabel;
   }

   public void setProvinceLabel(String _provinceLabel){
      this._provinceLabel = _provinceLabel;
   }

   public String countryLabel(){
      return _countryLabel;
   }

   public void setCountryLabel(String _countryLabel){
      this._countryLabel = _countryLabel;
   }

   //============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   //============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("countryLabel", _countryLabel);
      map.put("areaLabel", _areaLabel);
      map.put("provinceLabel", _provinceLabel);
   }
}
