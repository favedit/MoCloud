package org.mo.eai.history;

import org.mo.com.io.FByteFile;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FObject;
import org.mo.eai.template.city.FCityTemplate;

//============================================================
// <T>历史数据。</T>
//============================================================
public class FHistoryData
      extends FObject
{
   // 日期数据
   protected FDictionary<FHistoryDateData> _dates = new FDictionary<FHistoryDateData>(FHistoryDateData.class);

   //============================================================
   // <T>获得日期集合。</T>
   //
   // @return 日期集合
   //============================================================
   public FDictionary<FHistoryDateData> dates(){
      return _dates;
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
         date.setCode(dateValue);
         _dates.set(dateValue, date);
      }
      // 增加数据
      date.citys().push(city);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output,
                         FCityTemplate template){
      output.writeInt32(_dates.count());
      for(FHistoryDateData date : _dates.toObjects()){
         date.serialize(output, template);
      }
   }

   //============================================================
   // <T>保存序列化数据到文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void serializeFile(String fileName,
                             FCityTemplate template){
      FByteFile file = new FByteFile();
      serialize(file, template);
      file.saveToFile(fileName);
   }
}
