package org.mo.content.resource3d.scene;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.common.FRs3Object;
import org.mo.content.resource3d.common.SFloatColor4;

//============================================================
// <T>场景区域。</T>
//============================================================
public class FRs3SceneRegion
      extends FRs3Object
{
   // 颜色
   protected SFloatColor4 _color = new SFloatColor4();

   // 相机
   protected FRs3SceneCamera _camera = new FRs3SceneCamera();

   // 光源
   protected FRs3SceneLight _light = new FRs3SceneLight();

   //============================================================
   // <T>构造场景区域。</T>
   //============================================================
   public FRs3SceneRegion(){
   }

   //============================================================
   // <T>获得相机。</T>
   //
   // @return 相机
   //============================================================
   public FRs3SceneCamera camera(){
      return _camera;
   }

   //============================================================
   // <T>获得光源。</T>
   //
   // @return 光源
   //============================================================
   public FRs3SceneLight light(){
      return _light;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 存储属性
      _camera.serialize(output);
      _light.serialize(output);
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      // 读取属性
      _guid = xconfig.get("guid");
      _color.parse(xconfig.get("color"));
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Camera")){
            _camera.loadConfig(xnode);
         }else if(xnode.isName("Light")){
            _light.loadConfig(xnode);
         }else{
            throw new FFatalError("Invalid config node.");
         }
      }
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      // 存储属性
      xconfig.set("guid", makeGuid());
      xconfig.set("color", _color);
      _camera.saveConfig(xconfig.createNode("Camera"));
      _light.saveConfig(xconfig.createNode("Light"));
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
      _light.importData(input);
   }
}
