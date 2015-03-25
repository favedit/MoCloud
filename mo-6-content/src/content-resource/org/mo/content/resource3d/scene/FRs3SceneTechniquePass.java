package org.mo.content.resource3d.scene;

import org.mo.com.io.IDataInput;
import org.mo.content.resource3d.common.FRs3TechniquePass;

//============================================================
// <T>场景技术过程。</T>
//============================================================
public class FRs3SceneTechniquePass
      extends FRs3TechniquePass
{
   //============================================================
   // <T>构造场景技术过程。</T>
   //============================================================
   public FRs3SceneTechniquePass(){
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      // 读取属性
      _code = input.readString();
      _targetSize.unserialize(input);
   }
}
