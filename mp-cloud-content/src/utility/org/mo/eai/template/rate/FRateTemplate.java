package org.mo.eai.template.rate;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;

//============================================================
// <T>城市模板。</T>
//============================================================
public class FRateTemplate
{
   // 文件名称
   protected String _fileName = "D:/Microbject/MoScript/data/rate.png";

   protected FObjects<FRateResource> _rates = new FObjects<FRateResource>(FRateResource.class);

   //============================================================
   // <T>解析处理。</T>
   //============================================================
   public void parser(){
      // 增加比率1
      FRateResource rate01 = new FRateResource();
      rate01.parser("D:/Microbject/MoScript/data/rate01.png");
      _rates.push(rate01);
      // 增加比率2
      FRateResource rate02 = new FRateResource();
      rate02.parser("D:/Microbject/MoScript/data/rate02.png");
      _rates.push(rate02);
      // 增加比率3
      FRateResource rate03 = new FRateResource();
      rate03.parser("D:/Microbject/MoScript/data/rate03.png");
      _rates.push(rate03);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      int count = _rates.count();
      output.writeInt32(count);
      for(FRateResource rate : _rates){
         rate.serialize(output);
      }
   }

   //============================================================
   // <T>解析处理。</T>
   //============================================================
   public static void main(String args[]){
      FRateTemplate template = new FRateTemplate();
      template.parser();
   }
}
