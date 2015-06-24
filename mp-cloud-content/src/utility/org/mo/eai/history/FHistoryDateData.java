package org.mo.eai.history;

import java.util.Arrays;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RInteger;
import org.mo.eai.template.city.FCityResource;
import org.mo.eai.template.city.FCityTemplate;

//============================================================
// <T>历史日期数据。</T>
//============================================================
public class FHistoryDateData
      extends FObject
{
   // 代码
   protected String _code;

   // 城市集合
   protected FObjects<FHistoryCityData> _citys = new FObjects<FHistoryCityData>(FHistoryCityData.class);

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
   public String code(){
      return _code;
   }

   //============================================================
   // <T>设置代码。</T>
   //
   // @param code 代码
   //============================================================
   public void setCode(String code){
      _code = code;
   }

   //============================================================
   // <T>获得城市集合。</T>
   //
   // @return 城市集合
   //============================================================
   public FObjects<FHistoryCityData> citys(){
      return _citys;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output,
                         FCityTemplate template){
      FDictionary<FHistoryProvinceData> provinces = new FDictionary<FHistoryProvinceData>(FHistoryProvinceData.class);
      // 计算数据
      float investmentDay = 0;
      float investmentTotal = 0;
      for(FHistoryCityData city : _citys){
         String code = city.code() + "";
         FCityResource cityResource = null;
         if(code.length() > 1){
            cityResource = template.cards().get(code, null);
            if(cityResource == null){
               String cityCode = code.substring(0, 2);
               cityResource = template.cards().get(cityCode, null);
            }
         }
         if(cityResource != null){
            String provinceCode = cityResource.provinceCode();
            FHistoryProvinceData province = provinces.get(provinceCode, null);
            if(province == null){
               province = new FHistoryProvinceData();
               province.setCode(RInteger.parse(provinceCode));
               provinces.set(provinceCode, province);
            }
            province.setInvestmentDay(province.investmentDay() + city.investmentDay());
            province.setInvestmentTotal(province.investmentTotal() + city.investmentTotal());
         }else{
            System.out.println("Invalid city code: " + code);
            //throw new FFatalError("Invalid city code.");
         }
         investmentDay += city.investmentDay();
         investmentTotal += city.investmentTotal();
      }
      // 写入数据
      output.writeString(_code);
      output.writeFloat(investmentDay);
      output.writeFloat(investmentTotal);
      output.writeInt32(provinces.count());
      FHistoryProvinceData[] provinceArray = provinces.toObjects();
      Arrays.sort(provinceArray);
      for(FHistoryProvinceData province : provinceArray){
         province.serialize(output);
      }
      output.writeInt32(_citys.count());
      for(FHistoryCityData city : _citys){
         city.serialize(output);
      }
   }
}
