package org.mo.eai.database;

import com.cyou.gccloud.data.data.FDataCommonAreaLogic;
import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import com.cyou.gccloud.data.data.FDataCommonCityCardLogic;
import com.cyou.gccloud.data.data.FDataCommonCityCardUnit;
import com.cyou.gccloud.data.data.FDataCommonCityLogic;
import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import com.cyou.gccloud.data.data.FDataCommonCountryLogic;
import com.cyou.gccloud.data.data.FDataCommonCountryUnit;
import com.cyou.gccloud.data.data.FDataCommonProvinceLogic;
import com.cyou.gccloud.data.data.FDataCommonProvinceUnit;
import org.mo.com.lang.FAttributes;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.logging.ELoggerLevel;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>资源导出器。</T>
//============================================================
public class REaiDatabaseExportor
{

   public static String CONNECTION_IMPORT = "test.data";

   // 国家单元集合
   protected static FObjects<FDataCommonCountryUnit> _countryUnits = new FObjects<FDataCommonCountryUnit>(FDataCommonCountryUnit.class);

   // 地区单元集合
   protected static FObjects<FDataCommonAreaUnit> _areaUnits = new FObjects<FDataCommonAreaUnit>(FDataCommonAreaUnit.class);

   // 省份单元集合
   protected static FObjects<FDataCommonProvinceUnit> _provinceUnits = new FObjects<FDataCommonProvinceUnit>(FDataCommonProvinceUnit.class);

   // 城市单元集合
   protected static FObjects<FDataCommonCityUnit> _cityUnits = new FObjects<FDataCommonCityUnit>(FDataCommonCityUnit.class);

   // 城市卡片单元集合
   protected static FObjects<FDataCommonCityCardUnit> _cityCardUnits = new FObjects<FDataCommonCityCardUnit>(FDataCommonCityCardUnit.class);

   public static int indexOfCountry(FDataCommonCountryUnit unit){
      int index = _countryUnits.indexOf(unit);
      if(index == -1){
         throw new FFatalError("Unknown country.");
      }
      return index + 1;
   }

   public static int indexOfCountryId(long id){
      if(id > 0){
         for(FDataCommonCountryUnit unit : _countryUnits){
            if(unit.ouid() == id){
               return indexOfCountry(unit);
            }
         }
         throw new FFatalError("Unknown country.");
      }
      return 0;
   }

   public static int indexOfArea(FDataCommonAreaUnit unit){
      int index = _areaUnits.indexOf(unit);
      if(index == -1){
         throw new FFatalError("Unknown area.");
      }
      return index + 1;
   }

   public static int indexOfAreaId(long id){
      if(id > 0){
         for(FDataCommonAreaUnit unit : _areaUnits){
            if(unit.ouid() == id){
               return indexOfArea(unit);
            }
         }
         throw new FFatalError("Unknown area.");
      }
      return 0;
   }

   public static int indexOfProvince(FDataCommonProvinceUnit unit){
      int index = _provinceUnits.indexOf(unit);
      if(index == -1){
         throw new FFatalError("Unknown province.");
      }
      return index + 1;
   }

   public static int indexOfProvinceId(long id){
      if(id > 0){
         for(FDataCommonProvinceUnit unit : _provinceUnits){
            if(unit.ouid() == id){
               return indexOfProvince(unit);
            }
         }
         throw new FFatalError("Unknown province.");
      }
      return 0;
   }

   public static int indexOfCity(FDataCommonCityUnit unit){
      int index = _cityUnits.indexOf(unit);
      if(index == -1){
         throw new FFatalError("Unknown city.");
      }
      return index + 1;
   }

   public static int indexOfCityId(long id){
      if(id > 0){
         for(FDataCommonCityUnit unit : _cityUnits){
            if(unit.ouid() == id){
               return indexOfCity(unit);
            }
         }
         throw new FFatalError("Unknown city.");
      }
      return 0;
   }

   public static int indexOfCityCard(FDataCommonCityCardUnit unit){
      int index = _cityCardUnits.indexOf(unit);
      if(index == -1){
         throw new FFatalError("Unknown city.");
      }
      return index + 1;
   }

   //============================================================
   // <T>主函数。</T>
   //============================================================
   public static void main(String[] args){
      // 设置属性
      FAttributes attributes = RAop.configConsole().defineCollection().attributes();
      attributes.set("application", "D:/Microbject/MoCloud");
      // 加载配置
      RAop.initialize("D:/Microbject/MoCloud/mp-eai-batch/src/config/application-work.xml");
      IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
      try(FLogicContext context = new FLogicContext(databaseConsole)){
         // 读取国家集合
         FDataCommonCountryLogic countryLogic = context.findLogic(FDataCommonCountryLogic.class);
         FLogicDataset<FDataCommonCountryUnit> countryUnits = countryLogic.fetchAll();
         System.out.println("Fetch country = " + countryUnits.count());
         for(FDataCommonCountryUnit countryUnit : countryUnits){
            _countryUnits.push(countryUnit);
         }
         // 读取地区集合
         FDataCommonAreaLogic areaLogic = context.findLogic(FDataCommonAreaLogic.class);
         FLogicDataset<FDataCommonAreaUnit> areaUnits = areaLogic.fetchAll();
         System.out.println("Fetch area = " + areaUnits.count());
         for(FDataCommonAreaUnit areaUnit : areaUnits){
            _areaUnits.push(areaUnit);
         }
         // 读取省份集合
         FDataCommonProvinceLogic provinceLogic = context.findLogic(FDataCommonProvinceLogic.class);
         FLogicDataset<FDataCommonProvinceUnit> provinceUnits = provinceLogic.fetchAll();
         System.out.println("Fetch province = " + provinceUnits.count());
         for(FDataCommonProvinceUnit provinceUnit : provinceUnits){
            _provinceUnits.push(provinceUnit);
         }
         // 读取城市集合
         FDataCommonCityLogic cityLogic = context.findLogic(FDataCommonCityLogic.class);
         FLogicDataset<FDataCommonCityUnit> cityUnits = cityLogic.fetchAll();
         System.out.println("Fetch city = " + cityUnits.count());
         for(FDataCommonCityUnit cityUnit : cityUnits){
            _cityUnits.push(cityUnit);
         }
         // 读取城市卡片集合
         FDataCommonCityCardLogic cityCardLogic = context.findLogic(FDataCommonCityCardLogic.class);
         FLogicDataset<FDataCommonCityCardUnit> cityCardUnits = cityCardLogic.fetchAll();
         System.out.println("Fetch city card = " + cityCardUnits.count());
         for(FDataCommonCityCardUnit cityCardUnit : cityCardUnits){
            _cityCardUnits.push(cityCardUnit);
         }
         //............................................................
         // 导入国家
         FDataCommonCountryLogic importCountryLogic = context.findLogic(FDataCommonCountryLogic.class, CONNECTION_IMPORT);
         for(FDataCommonCountryUnit countryUnit : _countryUnits){
            int countryIndex = indexOfCountry(countryUnit);
            // 新建记录
            FDataCommonCountryUnit unit = countryUnit.clone();
            unit.setOuid(countryIndex);
            unit.setOvld(true);
            importCountryLogic.doInsert(unit);
         }
         // 导入区域
         FDataCommonAreaLogic importAreaLogic = context.findLogic(FDataCommonAreaLogic.class, CONNECTION_IMPORT);
         for(FDataCommonAreaUnit areaUnit : _areaUnits){
            int countryIndex = indexOfCountryId(areaUnit.countryId());
            int areaIndex = indexOfArea(areaUnit);
            // 新建记录
            FDataCommonAreaUnit unit = areaUnit.clone();
            unit.setOuid(areaIndex);
            unit.setOvld(true);
            unit.setCountryId(countryIndex);
            importAreaLogic.doInsert(unit);
         }
         // 导入省份
         FDataCommonProvinceLogic importProvinceLogic = context.findLogic(FDataCommonProvinceLogic.class, CONNECTION_IMPORT);
         for(FDataCommonProvinceUnit provinceUnit : _provinceUnits){
            int countryIndex = indexOfCountryId(provinceUnit.countryId());
            int areaIndex = indexOfAreaId(provinceUnit.areaId());
            int provinceIndex = indexOfProvince(provinceUnit);
            // 新建记录
            FDataCommonProvinceUnit unit = provinceUnit.clone();
            unit.setOuid(provinceIndex);
            unit.setOvld(true);
            unit.setCountryId(countryIndex);
            unit.setAreaId(areaIndex);
            importProvinceLogic.doInsert(unit);
         }
         // 导入城市
         FDataCommonCityLogic importCityLogic = context.findLogic(FDataCommonCityLogic.class, CONNECTION_IMPORT);
         for(FDataCommonCityUnit cityUnit : _cityUnits){
            int countryIndex = indexOfCountryId(cityUnit.countryId());
            int areaIndex = indexOfAreaId(cityUnit.areaId());
            int provinceIndex = indexOfProvinceId(cityUnit.provinceId());
            int cityIndex = indexOfCity(cityUnit);
            // 新建记录
            FDataCommonCityUnit unit = cityUnit.clone();
            unit.setOuid(cityIndex);
            unit.setOvld(true);
            unit.setCountryId(countryIndex);
            unit.setAreaId(areaIndex);
            unit.setProvinceId(provinceIndex);
            importCityLogic.doInsert(unit);
         }
         // 导入城市卡片
         FDataCommonCityCardLogic importCityCardLogic = context.findLogic(FDataCommonCityCardLogic.class, CONNECTION_IMPORT);
         for(FDataCommonCityCardUnit cityCardUnit : _cityCardUnits){
            int cityIndex = indexOfCityId(cityCardUnit.cityId());
            int cityCardIndex = indexOfCityCard(cityCardUnit);
            // 新建记录
            FDataCommonCityCardUnit unit = cityCardUnit.clone();
            unit.setOuid(cityCardIndex);
            unit.setOvld(true);
            unit.setCityId(cityIndex);
            importCityCardLogic.doInsert(unit);
         }
      }catch(Exception exception){
         RLogger.find(REaiDatabaseExportor.class).error(null, "main", exception);
      }
      // 设置日志
      RLogger.setFlags(ELoggerLevel.NO_DEBUG.value());
      // 结束处理
      RAop.release();
   }
}
