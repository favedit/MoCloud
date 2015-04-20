package org.mo.content.resource3d.common;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.scene.FRs3SceneDisplay;

//============================================================
// <T>场景层。</T>
//============================================================
public class FRs3DisplayLayer
      extends FRs3DisplayContainer
{
   // 变换类型
   protected String _transformCd;

   // 类型名称
   protected String _typeCd;

   //============================================================
   // <T>构造场景层。</T>
   //============================================================
   public FRs3DisplayLayer(){
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
         case "Sprite":
            return new FRs3Sprite();
      }
      throw new FFatalError("Invalid config type. (type_name={1})", typeName);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 输出属性
      output.writeString(_typeCd);
      output.writeString(_transformCd);
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 读取属性
      _typeCd = xconfig.get("type_cd", _typeCd);
      _transformCd = xconfig.get("transform_cd", _transformCd);
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      super.saveConfig(xconfig);
      // 存储属性
      xconfig.set("type_cd", _typeCd);
      xconfig.set("transform_cd", _transformCd);
   }

   //============================================================
   // <T>从配置节点中合并数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void mergeConfig(FXmlNode xconfig){
      super.mergeConfig(xconfig);
      // 读取属性
      _typeCd = xconfig.get("type_cd", _typeCd);
      _transformCd = xconfig.get("transform_cd", _transformCd);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
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
