package org.mo.content.resource.scene;

import org.mo.com.io.IDataInput;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource.common.FResDisplayLayer;
import org.mo.content.resource.common.FResObject;

//============================================================
// <T>场景层。</T>
//============================================================
public class FResSceneLayer
      extends FResDisplayLayer
{
   //============================================================
   // <T>构造场景层。</T>
   //============================================================
   public FResSceneLayer(){
      _typeName = "SceneLayer";
   }

   //============================================================
   // <T>创建子对象。</T>
   //
   // @param xconfig 配置信息
   // @return 子对象
   //============================================================
   @Override
   public FResObject createChild(FXmlNode xconfig){
      String typeName = xconfig.name();
      switch(typeName){
         case "SceneDisplay":
            return new FResSceneDisplay();
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
         FResSceneDisplay display = new FResSceneDisplay();
         display.importData(input);
         pushDisplay(display);
      }
   }
}
