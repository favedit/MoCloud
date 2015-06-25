package org.mo.eai.history;

import java.util.Arrays;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RInteger;
import org.mo.eai.RTemplateExport;
import org.mo.eai.template.city.FCityResource;
import org.mo.eai.template.city.FCityTemplate;

//============================================================
// <T>历史日期数据。</T>
//============================================================
public class FHistoryDateData
      extends FObject
{
   // 日志输出接口
   // private static ILogger _logger = RLogger.find(FHistoryDateData.class);

   // 历史数据
   protected FHistoryData _history;

   // 代码
   protected String _code;

   // 投资当天数据
   protected float _investmentDay = 0;

   // 投资总计数据
   protected float _investmentTotal = 0;

   // 省份集合
   protected FDictionary<FHistoryProvinceData> _provinces = new FDictionary<FHistoryProvinceData>(FHistoryProvinceData.class);

   // 城市集合
   protected FObjects<FHistoryCityData> _citys = new FObjects<FHistoryCityData>(FHistoryCityData.class);

   //============================================================
   // <T>构造历史日期数据。</T>
   //============================================================
   public FHistoryDateData(){
   }

   //============================================================
   // <T>获得历史。</T>
   //
   // @return 历史
   //============================================================
   public FHistoryData history(){
      return _history;
   }

   //============================================================
   // <T>设置历史。</T>
   //
   // @param history 历史
   //============================================================
   public void setHistory(FHistoryData history){
      _history = history;
   }

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
   // <T>获得日投资额。</T>
   //
   // @return 日投资额
   //============================================================
   public float investmentDay(){
      return _investmentDay;
   }

   //============================================================
   // <T>设置日投资额。</T>
   //
   // @param investmentDay 日投资额
   //============================================================
   public void setInvestmentDay(float investmentDay){
      _investmentDay = investmentDay;
   }

   //============================================================
   // <T>获得总投资额。</T>
   //
   // @return 总投资额
   //============================================================
   public float investmentTotal(){
      return _investmentTotal;
   }

   //============================================================
   // <T>设置总投资额。</T>
   //
   // @param investmentTotal 总投资额
   //============================================================
   public void setInvestmentTotal(float investmentTotal){
      _investmentTotal = investmentTotal;
   }

   //============================================================
   // <T>获得省份集合。</T>
   //
   // @return 省份集合
   //============================================================
   public FDictionary<FHistoryProvinceData> provinces(){
      return _provinces;
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
   // <T>计算数据。</T>
   //============================================================
   public void calculate(){
      FCityTemplate cityTemplate = RTemplateExport.cityTemplate();
      FDictionary<FCityResource> cards = cityTemplate.cards();
      // 计算数据
      _investmentDay = 0;
      _investmentTotal = 0;
      for(FHistoryCityData city : _citys){
         String code = city.code() + "";
         FCityResource cityResource = null;
         if(code.length() > 1){
            cityResource = cards.get(code, null);
            // 查找城市
            if(cityResource == null){
               String cityCode = code.substring(0, 2);
               cityResource = cards.get(cityCode, null);
            }
            // 查找省会
            if(cityResource == null){
               String cityCode = code.substring(0, 2) + "01";
               cityResource = cards.get(cityCode, null);
            }
         }
         if(cityResource != null){
            String provinceCode = cityResource.provinceCode();
            FHistoryProvinceData province = _provinces.get(provinceCode, null);
            if(province == null){
               province = new FHistoryProvinceData();
               province.setCode(RInteger.parse(provinceCode));
               _provinces.set(provinceCode, province);
            }
            province.setInvestmentDay(province.investmentDay() + city.investmentDay());
            province.setInvestmentTotal(province.investmentTotal() + city.investmentTotal());
         }else{
            _history.invalidCodes().set(code, code);
            //_logger.debug(this, "calculate", "Invalid city code. (code={1})", code);
         }
         _investmentDay += city.investmentDay();
         _investmentTotal += city.investmentTotal();
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      // 写入数据
      output.writeString(_code);
      output.writeFloat(_investmentDay);
      output.writeFloat(_investmentTotal);
      output.writeInt32(_provinces.count());
      // 写入省份数据
      FHistoryProvinceData[] provinceArray = _provinces.toObjects();
      Arrays.sort(provinceArray);
      for(FHistoryProvinceData province : provinceArray){
         province.serialize(output);
      }
      // 写入城市数据
      output.writeInt32(_citys.count());
      for(FHistoryCityData city : _citys){
         city.serialize(output);
      }
   }
}
