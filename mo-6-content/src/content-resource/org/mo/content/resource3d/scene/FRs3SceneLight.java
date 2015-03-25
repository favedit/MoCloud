package org.mo.content.resource3d.scene;

import org.mo.com.io.IDataInput;
import org.mo.content.resource3d.common.FRs3Camera;
import org.mo.content.resource3d.common.FRs3Light;

//============================================================
// <T>场景光源显示。</T>
//============================================================
public class FRs3SceneLight
      extends FRs3Light
{
   // 类型
   protected String _typeCd;

   //============================================================
   // <T>构造场景层。</T>
   //============================================================
   public FRs3SceneLight(){
      _material = new FRs3SceneMaterial();
      _camera = new FRs3Camera();
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      // 读取属性
      _typeCd = input.readString();
      ((FRs3SceneMaterial)_material).importData(input);
      _camera.importData(input);
   }
}
