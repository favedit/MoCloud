package org.mo.content.resource3d.scene;

import org.mo.com.io.IDataInput;
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
