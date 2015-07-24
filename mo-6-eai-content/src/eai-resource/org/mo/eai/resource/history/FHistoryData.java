package org.mo.eai.resource.history;

import org.mo.com.io.FByteFile;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.INamePair;

//============================================================
// <T>历史数据。</T>
//============================================================
public class FHistoryData
      extends FObject
{
   // 日志输出接口
   //private static ILogger _logger = RLogger.find(FHistoryDateData.class);

   // 投资当天数据
   protected float _investmentDay = 0;

   // 投资总计数据
   protected float _investmentTotal = 0;

   // 省份当天数据最大
   protected float _investmentProvinceDay = 0;

   // 省份总计数据最大
   protected float _investmentProvinceTotal = 0;

   // 城市当天数据最大
   protected float _investmentCityDay = 0;

   // 城市总计数据最大
   protected float _investmentCityTotal = 0;

   // 省份集合
   protected FDictionary<FHistoryProvinceData> _provinces = new FDictionary<FHistoryProvinceData>(FHistoryProvinceData.class);

   // 城市集合
   protected FDictionary<FHistoryCityData> _citys = new FDictionary<FHistoryCityData>(FHistoryCityData.class);

   // 里程碑集合
   protected FObjects<FHistoryMilestoneData> _milestones = new FObjects<FHistoryMilestoneData>(FHistoryMilestoneData.class);

   // 日期数据
   protected FDictionary<FHistoryDateData> _dates = new FDictionary<FHistoryDateData>(FHistoryDateData.class);

   // 非法代码
   protected FAttributes _invalidCodes = new FAttributes();

   //============================================================
   // <T>构造历史数据。</T>
   //============================================================
   public FHistoryData(){
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
   public FDictionary<FHistoryCityData> citys(){
      return _citys;
   }

   //============================================================
   // <T>获得里程碑集合。</T>
   //
   // @return 里程碑集合
   //============================================================
   public FObjects<FHistoryMilestoneData> milestones(){
      return _milestones;
   }

   //============================================================
   // <T>获得日期集合。</T>
   //
   // @return 日期集合
   //============================================================
   public FDictionary<FHistoryDateData> dates(){
      return _dates;
   }

   //============================================================
   // <T>获得非法代码。</T>
   //
   // @return 非法代码
   //============================================================
   public FAttributes invalidCodes(){
      return _invalidCodes;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public FHistoryCityData findCity(String dateValue,
                                    String cityCode){
      // 获得时间
      FHistoryDateData date = _dates.get(dateValue, null);
      if(date != null){
         return date.findCity(cityCode);
      }
      return null;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void push(String dateValue,
                    FHistoryCityData city){
      // 获得时间
      FHistoryDateData date = _dates.get(dateValue, null);
      if(date == null){
         date = new FHistoryDateData();
         date.setHistory(this);
         date.setCode(dateValue);
         _dates.set(dateValue, date);
      }
      // 增加数据
      date.citys().set(String.valueOf(city.code()), city);
   }

   //============================================================
   // <T>计算数据。</T>
   //============================================================
   public void calculate(){
      // 计算天数据
      for(FHistoryDateData date : _dates.toObjects()){
         date.calculate();
      }
      // 计算数据
      _investmentDay = 0;
      _investmentTotal = 0;
      int dateCityCount = 0;
      for(FHistoryDateData date : _dates.toObjects()){
         // 计算省份最大值
         for(FHistoryProvinceData provinceDate : date.provinces().toObjects()){
            String provinceCode = provinceDate.code() + "";
            float investmentDay = provinceDate.investmentDay();
            float investmentTotal = provinceDate.investmentTotal();
            FHistoryProvinceData province = _provinces.get(provinceCode, null);
            if(province == null){
               province = new FHistoryProvinceData();
               province.setCode(provinceDate.code());
               _provinces.set(provinceCode, province);
            }
            if(investmentDay > province.investmentDay()){
               province.setInvestmentDay(investmentDay);
            }
            if(investmentTotal > province.investmentTotal()){
               province.setInvestmentDay(investmentTotal);
            }
            if(investmentDay > _investmentProvinceDay){
               _investmentProvinceDay = investmentDay;
            }
            if(investmentTotal > _investmentProvinceTotal){
               _investmentProvinceTotal = investmentTotal;
            }
         }
         // 计算城市最大值
         if(dateCityCount > date.citys().count()){
            // throw new FFatalError("City error.");
         }
         dateCityCount = date.citys().count();
         //System.out.println(date.code() + " - " + dateCityCount);
         for(INamePair<FHistoryCityData> pair : date.citys()){
            FHistoryCityData cityData = pair.value();
            String cityCode = cityData.code() + "";
            float investmentDay = cityData.investmentDay();
            float investmentTotal = cityData.investmentTotal();
            FHistoryCityData city = _citys.get(cityCode, null);
            if(city == null){
               city = new FHistoryCityData();
               city.setCode(cityData.code());
               _citys.set(cityCode, city);
            }
            if(investmentDay > city.investmentDay()){
               city.setInvestmentDay(investmentDay);
            }
            if(investmentTotal > city.investmentTotal()){
               city.setInvestmentDay(investmentTotal);
            }else{
               throw new FFatalError("Invalid total.");
            }
            if(investmentDay > _investmentCityDay){
               _investmentCityDay = investmentDay;
            }
            if(investmentTotal > _investmentCityTotal){
               _investmentCityTotal = investmentTotal;
            }
         }
         // 计算天最大值
         float investmentDay = date.investmentDay();
         float investmentTotal = date.investmentTotal();
         if(investmentDay > _investmentDay){
            _investmentDay = investmentDay;
         }
         if(investmentTotal > _investmentTotal){
            _investmentTotal = investmentTotal;
         }
      }
      // 显示代码
      //for(String code : _invalidCodes.toObjects()){
      //   _logger.debug(this, "calculate", "Invalid city code. (code={1})", code);
      //}
      // 计算里程碑
      _milestones.push(new FHistoryMilestoneData("20140809", 1000, 19, 19, 2, 48));
      _milestones.push(new FHistoryMilestoneData("20140925", 2000, 66, 47, 4, 97));
      _milestones.push(new FHistoryMilestoneData("20141028", 5000, 99, 33, 6, 143));
      _milestones.push(new FHistoryMilestoneData("20141129", 10000, 131, 32, 9, 215));
      _milestones.push(new FHistoryMilestoneData("20150116", 50000, 179, 48, 71, 2912));
      _milestones.push(new FHistoryMilestoneData("20150206", 100000, 200, 21, 87, 5028));
      _milestones.push(new FHistoryMilestoneData("20150310", 200000, 232, 32, 120, 10249));
      _milestones.push(new FHistoryMilestoneData("20150512", 500000, 295, 63, 259, 17023));
      _milestones.push(new FHistoryMilestoneData("20150625", 1000000, 339, 44, 405, 23029));
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      // 写入属性
      output.writeFloat(_investmentDay);
      output.writeFloat(_investmentTotal);
      output.writeFloat(_investmentProvinceDay);
      output.writeFloat(_investmentProvinceTotal);
      output.writeFloat(_investmentCityDay);
      output.writeFloat(_investmentCityTotal);
      // 写入省份数据
      int provinceCount = _provinces.count();
      output.writeInt32(provinceCount);
      for(FHistoryProvinceData province : _provinces.toObjects()){
         province.serialize(output);
      }
      // 写入城市数据
      int cityCount = _citys.count();
      output.writeInt32(cityCount);
      for(FHistoryCityData city : _citys.toObjects()){
         city.serialize(output);
      }
      // 写入里程碑数据
      int milestoneCount = _milestones.count();
      output.writeInt32(milestoneCount);
      for(FHistoryMilestoneData milestone : _milestones){
         milestone.serialize(output);
      }
      // 写入日期数据
      int dayCount = _dates.count();
      output.writeInt32(dayCount);
      for(FHistoryDateData date : _dates.toObjects()){
         // System.out.println(date.code() + " - " + (int)(date.investmentTotal() / 10000));
         date.serialize(output);
      }
   }

   //============================================================
   // <T>保存序列化数据到文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void serializeFile(String fileName){
      FByteFile file = new FByteFile();
      serialize(file);
      file.saveToFile(fileName);
   }
}
