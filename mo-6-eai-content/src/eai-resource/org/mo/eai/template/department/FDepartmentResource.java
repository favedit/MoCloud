package org.mo.eai.template.department;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;

//============================================================
// <T>部门数据。</T>
//============================================================
public class FDepartmentResource
      extends FObject
{
   // 名称
   protected String _code;

   // 标签
   protected String _label;

   // 全称
   protected String _fullLabel;

   //============================================================
   // <T>构造部门数据。</T>
   //============================================================
   public FDepartmentResource(){
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
   // <T>获得全称。</T>
   //
   // @return 全称
   //============================================================
   public String fullLabel(){
      return _fullLabel;
   }

   //============================================================
   // <T>设置全称。</T>
   //
   // @param fullLabel 全称
   //============================================================
   public void setFullLabel(String fullLabel){
      _fullLabel = fullLabel;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeString(_label);
      output.writeString(_fullLabel);
   }
}
