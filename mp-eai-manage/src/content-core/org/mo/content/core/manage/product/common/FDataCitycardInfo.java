package org.mo.content.core.manage.product.common;

import java.util.Map;

import com.cyou.gccloud.data.data.FDataCommonCityCardUnit;
//============================================================
//<P>城市省份证信息</P>
//@class FDataCitycardInfo
//@version 1.0.0
//============================================================
public class FDataCitycardInfo 
      extends 
         FDataCommonCityCardUnit
{


   //存储城市名称
   private String _cityLabel;
   private Long _provinceId;
   private Long _areaId;
   private Long _countryId;

   public String cityLabel(){
      return _cityLabel;
   }

   public void setCityLabel(String _cityLabel){
      this._cityLabel = _cityLabel;
   }
   
   public Long provinceId(){
      return _provinceId;
   }

   public void setProvinceId(Long _provinceId){
      this._provinceId = _provinceId;
   }
   public Long areaId(){
      return _areaId;
   }

   public void setAreaId(Long _areaId){
      this._areaId = _areaId;
   }
   public Long countryId(){
      return _countryId;
   }

   public void setCountryId(Long _countryId){
      this._countryId = _countryId;
   }

   //============================================================
   // <T>保存对照表。</T>
   // @param map 对照表
   //============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("cityLabel", _cityLabel);
      map.put("provinceId", _provinceId+"");
      map.put("areaId", _areaId+"");
      map.put("countryId", _countryId+"");
   }
}
