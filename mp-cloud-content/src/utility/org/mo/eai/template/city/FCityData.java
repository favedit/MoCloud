package org.mo.eai.template.city;

import org.mo.com.geom.SDoublePoint3;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;

//============================================================
// <T>省份数据。</T>
//============================================================
public class FCityData
      extends FObject
{
   // 省份名称
   protected String _provinceName;

   // 省份代码
   protected String _provinceCode;

   // 名称
   protected String _name;

   // 名称
   protected String _code;

   // 坐标
   protected SDoublePoint3 _location = new SDoublePoint3();

   //============================================================
   // <T>构造省份数据。</T>
   //============================================================
   public FCityData(){
   }

   //============================================================
   // <T>获得省份名称。</T>
   //
   // @return 省份名称
   //============================================================
   public String provinceName(){
      return _provinceName;
   }

   //============================================================
   // <T>设置省份名称。</T>
   //
   // @param provinceName 省份名称
   //============================================================
   public void setProvinceName(String provinceName){
      _provinceName = provinceName;
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
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================
   public String name(){
      return _name;
   }

   //============================================================
   // <T>设置名称。</T>
   //
   // @param name 名称
   //============================================================
   public void setName(String name){
      _name = name;
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
      output.writeString(_provinceCode);
      output.writeString(_provinceName);
      output.writeString(_code);
      output.writeString(_name);
      _location.serializeFloat3(output);
   }
}
