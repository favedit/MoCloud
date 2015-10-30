package org.mo.eai.resource.province;

import com.cyou.gccloud.data.data.FDataCommonProvinceLogic;
import com.cyou.gccloud.data.data.FDataCommonProvinceUnit;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.data.logic.FLogicDataset;
import org.mo.eai.resource.REaiResourceExportor;

//============================================================
// <T>省份模板。</T>
//============================================================
public class FEaiProvinceTemplate
{
   // 省份集合
   protected FObjects<FEaiProvinceResource> _provinces = new FObjects<FEaiProvinceResource>(FEaiProvinceResource.class);

   //============================================================
   // <T>获得省份集合。</T>
   //
   // @return 省份集合
   //============================================================
   public FObjects<FEaiProvinceResource> provinces(){
      return _provinces;
   }

   //============================================================
   // <T>根据代码查找省份。</T>
   //
   // @param code 代码
   // @return 省份
   //============================================================
   public FEaiProvinceResource findByCode(String code){
      for(FEaiProvinceResource province : _provinces){
         if(code.equals(province.code())){
            return province;
         }
      }
      throw new FFatalError("Province is not exists.");
   }

   //============================================================
   // <T>根据名称查找省份。</T>
   //
   // @param name 名称
   // @return 省份
   //============================================================
   public FEaiProvinceResource findByName(String name){
      for(FEaiProvinceResource province : _provinces){
         if(name.equals(province.name())){
            return province;
         }
      }
      throw new FFatalError("Province is not exists.");
   }

   //============================================================
   // <T>根据标签查找省份。</T>
   //
   // @param label 标签
   // @return 省份
   //============================================================
   public FEaiProvinceResource findByLabel(String label){
      for(FEaiProvinceResource province : _provinces){
         if(label.equals(province.label())){
            return province;
         }
      }
      throw new FFatalError("Province is not exists.");
   }

   //============================================================
   // <T>解析数据。</T>
   //============================================================
   public void parser(){
      FDataCommonProvinceLogic logic = REaiResourceExportor.logicContext.findLogic(FDataCommonProvinceLogic.class);
      FLogicDataset<FDataCommonProvinceUnit> units = logic.fetchAll();
      // 读取所有行
      for(FDataCommonProvinceUnit unit : units){
         FEaiProvinceResource province = new FEaiProvinceResource();
         province.setCode(unit.code());
         //province.setName(unit.n RString.trim(items[1]));
         province.setLabel(unit.label());
         //province.setTypeCd(uni RString.trim(items[3]));
         province.setDisplayOrder(unit.displayOrder());
         _provinces.push(province);
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeInt32(_provinces.count());
      for(FEaiProvinceResource province : _provinces){
         province.serialize(output);
      }
   }
}
