package org.mo.content.resource3d.scene;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.content.resource3d.common.FRs3Material;

//============================================================
// <T>场景显示。</T>
//============================================================
public class FRs3SceneMaterial
      extends FRs3Material
{
   //============================================================
   // <T>构造场景层。</T>
   //============================================================
   public FRs3SceneMaterial(){
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      // 存储属性
      output.writeString(_code);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      // 读取属性
      _code = input.readString();
      _label = input.readString();
   }
}
