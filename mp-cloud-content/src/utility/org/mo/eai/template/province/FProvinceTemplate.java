package org.mo.eai.template.province;

import org.mo.com.io.FLinesFile;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;

public class FProvinceTemplate
{
   protected String _fileName = "D:/Microbject/MoScript/data/province.csv";

   protected FObjects<FProvinceResource> _provinces = new FObjects<FProvinceResource>(FProvinceResource.class);

   //============================================================
   // <T>解析数据。</T>
   //============================================================
   public void parser(){
      // 打开文件
      FLinesFile file = new FLinesFile();
      file.loadFile(_fileName, "GB2312");
      // 读取所有行
      int count = file.count();
      for(int n = 1; n < count; n++){
         String line = file.line(n);
         if(!RString.isEmpty(line)){
            String[] items = RString.split(line.trim(), ',');
            if(items.length != 4){
               throw new FFatalError("Format is invalid.");
            }
            FProvinceResource province = new FProvinceResource();
            province.setCode(RString.trim(items[0]));
            province.setName(RString.trim(items[1]));
            province.setLabel(RString.trim(items[2]));
            province.setDisplayOrder(RInteger.parse(items[3]));
            _provinces.push(province);
            System.out.println(items[0] + " - " + items[1] + " - " + items[2]);
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
      for(FProvinceResource province : _provinces){
         province.serialize(output);
      }
   }
}
