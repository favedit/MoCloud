package org.mo.eai.template.city;

import org.mo.com.geom.SDoublePoint3;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RInteger;

//============================================================
// <T>省份数据。</T>
//============================================================
public class FCityResource
      extends FObject
{
   // 省份代码
   protected String _provinceCode;

   // 省份标签
   protected String _provinceLabel;

   // 名称
   protected String _code;

   // 标签
   protected String _label;

   // 级别
   protected int _level;

   // 卡片代码
   protected String _cardCode;

   // 坐标
   protected SDoublePoint3 _location = new SDoublePoint3();

   //============================================================
   // <T>构造省份数据。</T>
   //============================================================
   public FCityResource(){
   }

   //============================================================
   // <T>获得省份代码。</T>
   //
   // @return 省份代码
   //============================================================
   public String provinceCode(){
      return _provinceCode;
   }

   //============================================================
   // <T>设置省份代码。</T>
   //
   // @param provinceCode 省份代码
   //============================================================
   public void setProvinceCode(String provinceCode){
      _provinceCode = provinceCode;
   }

   //============================================================
   // <T>获得省份标签。</T>
   //
   // @return 省份标签
   //============================================================
   public String provinceLabel(){
      return _provinceLabel;
   }

   //============================================================
   // <T>设置省份标签。</T>
   //
   // @param provinceLabel 省份标签
   //============================================================
   public void setProvinceLabel(String provinceLabel){
      _provinceLabel = provinceLabel;
   }

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
   // <T>获得标签。</T>
   //
   // @return 标签
   //============================================================
   public String label(){
      return _label;
   }

   //============================================================
   // <T>设置标签。</T>
   //
   // @param label 标签
   //============================================================
   public void setLabel(String label){
      _label = label;
   }

   //============================================================
   // <T>获得级别。</T>
   //
   // @return 级别
   //============================================================
   public int level(){
      return _level;
   }

   //============================================================
   // <T>设置级别。</T>
   //
   // @param level 级别
   //============================================================
   public void setLevel(int level){
      _level = level;
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
   // <T>获得位置。</T>
   //
   // @return 位置
   //============================================================
   public SDoublePoint3 location(){
      return _location;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeUint16(RInteger.parse(_provinceCode));
      //output.writeUint16(RInteger.parse(_cardCode));
      output.writeUint16(RInteger.parse(_code));
      output.writeString(_label);
      output.writeUint16(_level);
      _location.serializeFloat2(output);
   }
}
