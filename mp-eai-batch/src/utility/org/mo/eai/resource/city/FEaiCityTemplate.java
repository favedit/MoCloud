package org.mo.eai.resource.city;

import org.mo.com.collections.FDataset;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.data.ISqlConnection;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.INamePair;
import org.mo.com.resource.IResource;
import org.mo.com.resource.RResource;
import org.mo.core.aop.RAop;
import org.mo.eai.core.common.EEaiDataConnection;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>城市模板。</T>
//============================================================
public class FEaiCityTemplate
{
   // 资源访问接口
   private final static IResource _resource = RResource.find(FEaiCityTemplate.class);

   // 城市资源集合
   protected FDictionary<FEaiCityResource> _citys = new FDictionary<FEaiCityResource>(FEaiCityResource.class);

   //============================================================
   // <T>获得城市集合。</T>
   //
   // @return 城市集合
   //============================================================
   public FDictionary<FEaiCityResource> citys(){
      return _citys;
   }

   //============================================================
   // <T>获得城市集合。</T>
   //
   // @return 城市集合
   //============================================================
   public FEaiCityResource findCity(String code){
      return _citys.find(code);
   }

   //============================================================
   // <T>解析处理。</T>
   //============================================================
   public void parser(){
      IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
      ISqlConnection connection = databaseConsole.alloc(EEaiDataConnection.DATA);
      FSql sql = _resource.findString(FSql.class, "sql.city");
      FDataset dataset = connection.fetchDataset(sql);
      for(FRow row : dataset){
         FEaiCityResource city = new FEaiCityResource();
         city.setProvinceCode(row.get("province_code"));
         city.setProvinceLabel(row.get("province_label"));
         city.setCode(row.get("code"));
         city.setLabel(row.get("label"));
         city.setLevel(row.getInt("level"));
         city.location().x = row.getDouble("location_longitude");
         city.location().y = row.getDouble("location_latitude");
         _citys.set(city.code(), city);
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeInt32(_citys.count());
      for(INamePair<FEaiCityResource> pair : _citys){
         pair.value().serialize(output);
      }
   }
}
