package org.mo.eai.resource.card;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;

//============================================================
// <T>卡片数据。</T>
//============================================================
public class FEaiCardResource
      extends FObject
{
   // 名称
   protected String _cardCode;

   // 标签
   protected String _cityCode;

   //============================================================
   // <T>构造省份数据。</T>
   //============================================================
   public FEaiCardResource(){
   }

   //============================================================
   // <T>获得卡片代码。</T>
   //
   // @return 卡片代码
   //============================================================
   public String cardCode(){
      return _cardCode;
   }

   //============================================================
   // <T>设置卡片代码。</T>
   //
   // @param cardCode 卡片代码
   //============================================================
   public void setCardCode(String cardCode){
      _cardCode = cardCode;
   }

   //============================================================
   // <T>获得城市代码。</T>
   //
   // @return 城市代码
   //============================================================
   public String cityCode(){
      return _cityCode;
   }

   //============================================================
   // <T>设置城市代码。</T>
   //
   // @param cityCode 城市代码
   //============================================================
   public void setCityCode(String cityCode){
      _cityCode = cityCode;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      //      output.writeUint16(RInteger.parse(_cardCode));
      //      output.writeUint16(RInteger.parse(_cityCode));
      output.writeString(_cardCode);
      output.writeString(_cityCode);
   }
}
