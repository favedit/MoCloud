package org.mo.content.resource3d.scene;

import org.mo.com.io.IDataInput;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.common.FRs3DisplayLayer;
import org.mo.content.resource3d.common.FRs3Object;

//============================================================
// <T>场景层。</T>
//============================================================
public class FRs3SceneLayer
      extends FRs3DisplayLayer
{
   //============================================================
   // <T>构造场景层。</T>
   //============================================================
   public FRs3SceneLayer(){
      _typeName = "SceneLayer";
   }

   //============================================================
   // <T>创建子对象。</T>
   //
   // @param xconfig 配置信息
   // @return 子对象
   //============================================================
   @Override
   public FRs3Object createChild(FXmlNode xconfig){
      String typeName = xconfig.name();
      switch(typeName){
         case "SceneDisplay":
            return new FRs3SceneDisplay();
      }
      return super.createChild(xconfig);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   @Override
   public void importData(IDataInput input){
      // 读取属性
      _code = input.readString();
      _typeCd = input.readString();
      // 读取显示集合
      int displayCount = input.readInt32();
      for(int n = 0; n < displayCount; n++){
         FRs3SceneDisplay display = new FRs3SceneDisplay();
         display.importData(input);
         pushDisplay(display);
      }
   }
}
