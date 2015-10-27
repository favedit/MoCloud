package org.mo.eai.resource.province;

import org.mo.com.io.FLinesFile;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.eai.RResourceConfiguration;

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
      String fileName = RResourceConfiguration.HomeData + "/province.csv";
      // 打开文件
      FLinesFile file = new FLinesFile();
      file.loadFile(fileName, "GB2312");
      // 读取所有行
      int count = file.count();
      for(int n = 1; n < count; n++){
         String line = file.line(n);
         if(!RString.isEmpty(line)){
            String[] items = RString.split(line.trim(), ',');
            if(items.length != 5){
               throw new FFatalError("Format is invalid.");
            }
            FEaiProvinceResource province = new FEaiProvinceResource();
            province.setCode(RString.trim(items[0]));
            province.setName(RString.trim(items[1]));
            province.setLabel(RString.trim(items[2]));
            province.setTypeCd(RString.trim(items[3]));
            province.setDisplayOrder(RInteger.parse(items[4]));
            _provinces.push(province);
            System.out.println(items[0] + " - " + items[1] + " - " + items[2] + " - " + items[3]);
         }
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
