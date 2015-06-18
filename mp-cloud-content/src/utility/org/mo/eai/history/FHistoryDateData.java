package org.mo.eai.history;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;
import org.mo.com.lang.FObjects;

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
   public void serialize(IDataOutput output){
      output.writeString(_code);
      output.writeInt32(_citys.count());
      for(FHistoryCityData city : _citys){
         city.serialize(output);
      }
   }
}
