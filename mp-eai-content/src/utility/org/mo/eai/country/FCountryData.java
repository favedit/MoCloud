package org.mo.eai.country;

import org.mo.com.io.FByteFile;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.generic.TDumpInfo;

//============================================================
// <T>国家数据。</T>
//============================================================
public class FCountryData
      extends FObject
{
   // 省份集合
   protected FObjects<FProvinceData> _provinces = new FObjects<FProvinceData>(FProvinceData.class);

   //============================================================
   // <T>构造国家数据。</T>
   //============================================================
   public FCountryData(){
   }

   //============================================================
   // <T>获得省份集合。</T>
   //
   // @return 省份集合
   //============================================================
   public FObjects<FProvinceData> provinces(){
      return _provinces;
   }

   //============================================================
   // <T>增加一个省份。</T>
   //
   // @param province 省份
   //============================================================
   public void pushBoundary(FProvinceData province){
      _provinces.push(province);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeInt32(_provinces.count());
      for(FProvinceData province : _provinces){
         province.serialize(output);
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

   //============================================================
   // <T>生成运行信息。</T>
   //
   // @param info 运行信息
   // @return 运行信息
   //============================================================
   @Override
   public TDumpInfo dump(TDumpInfo info){
      for(FProvinceData province : _provinces){
         province.dump(info);
         info.appendLine();
      }
      return info;
   }
}
