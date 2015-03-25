package org.mo.content.resource3d.scene;

import org.mo.com.io.IDataInput;
import org.mo.content.resource3d.common.FRs3Region;

//============================================================
// <T>资源3D区域。</T>
//============================================================
public class FRs3SceneRegion
      extends FRs3Region
{
   //============================================================
   // <T>构造场景区域。</T>
   //============================================================
   public FRs3SceneRegion(){
      _light = new FRs3SceneLight();
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      // 读取属性
      _color.unserialize(input);
      _camera.importData(input);
      FRs3SceneLight light = (FRs3SceneLight)_light;
      light.importData(input);
   }
}
