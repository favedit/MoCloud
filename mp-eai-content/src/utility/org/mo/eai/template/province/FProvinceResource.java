package org.mo.eai.template.province;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RInteger;

//============================================================
// <T>省份数据。</T>
//============================================================
public class FProvinceResource
      extends FObject
{
   // 代码
   protected String _code;

   // 名称
   protected String _name;

   // 标签
   protected String _label;

   // 类型
   protected String _typeCd;

   // 显示顺序
   protected int _displayOrder;

   //============================================================
   // <T>构造省份数据。</T>
   //============================================================
   public FProvinceResource(){
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
   // <T>获得类型。</T>
   //
   // @return 类型
   //============================================================
   public String typeCd(){
      return _typeCd;
   }

   //============================================================
   // <T>设置类型。</T>
   //
   // @param typeCd 类型
   //============================================================
   public void setTypeCd(String typeCd){
      _typeCd = typeCd;
   }

   //============================================================
   // <T>获得显示顺序。</T>
   //
   // @return 显示顺序
   //============================================================
   public int displayOrder(){
      return _displayOrder;
   }

   //============================================================
   // <T>设置显示顺序。</T>
   //
   // @param displayOrder 显示顺序
   //============================================================
   public void setDisplayOrder(int displayOrder){
      _displayOrder = displayOrder;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeUint16(RInteger.parse(_code));
      output.writeString(_name);
      output.writeString(_label);
      output.writeString(_typeCd);
      output.writeUint16(_displayOrder);
   }
}
