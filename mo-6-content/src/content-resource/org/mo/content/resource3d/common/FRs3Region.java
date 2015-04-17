package org.mo.content.resource3d.common;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.xml.FXmlNode;
import org.mo.content.geom.common.SFloatColor4;

//============================================================
// <T>资源3D区域。</T>
//============================================================
public class FRs3Region
      extends FRs3Object
{
   // 移动速度
   protected float _moveSpeed = 35.0f;

   // 旋转按键速度
   protected float _rotationKeySpeed = 2.5f;

   // 旋转鼠标速度
   protected float _rotationMouseSpeed = 0.0035f;

   // 颜色
   protected SFloatColor4 _color = new SFloatColor4();

   // 材质（Space内默认材质）
   protected FRs3Material _material = new FRs3Material();

   // 相机
   protected FRs3Camera _camera = new FRs3Camera();

   // 光源
   protected FRs3Light _light = new FRs3Light();

   //============================================================
   // <T>构造场景区域。</T>
   //============================================================
   public FRs3Region(){
      _typeName = "Region";
   }

   //============================================================
   // <T>获得材质。</T>
   //
   // @return 材质
   //============================================================
   public FRs3Material material(){
      return _material;
   }

   //============================================================
   // <T>获得相机。</T>
   //
   // @return 相机
   //============================================================
   public FRs3Camera camera(){
      return _camera;
   }

   //============================================================
   // <T>获得光源。</T>
   //
   // @return 光源
   //============================================================
   public FRs3Light light(){
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
      _color.serialize(output);
      output.writeFloat(_moveSpeed);
      output.writeFloat(_rotationKeySpeed);
      output.writeFloat(_rotationMouseSpeed);
      // 存储材质
      _material.serialize(output);
      // 存储相机
      _camera.serialize(output);
      // 存储光源
      _light.serialize(output);
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      // 读取属性
      _guid = xconfig.get("guid");
      _color.parse(xconfig.get("color"));
      _moveSpeed = xconfig.getFloat("move_speed", _moveSpeed);
      _rotationKeySpeed = xconfig.getFloat("rotation_key_speed", _rotationKeySpeed);
      _rotationMouseSpeed = xconfig.getFloat("rotation_mouse_speed", _rotationMouseSpeed);
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Material")){
            _material.loadConfig(xnode);
         }else if(xnode.isName("Camera")){
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
   @Override
   public void saveConfig(FXmlNode xconfig){
      // 存储属性
      xconfig.set("guid", makeGuid());
      xconfig.set("color", _color);
      xconfig.set("move_speed", _moveSpeed);
      xconfig.set("rotation_key_speed", _rotationKeySpeed);
      xconfig.set("rotation_mouse_speed", _rotationMouseSpeed);
      // 存储材质
      _material.saveConfig(xconfig.createNode("Material"));
      // 存储相机
      _camera.saveConfig(xconfig.createNode("Camera"));
      // 存储光源
      _light.saveConfig(xconfig.createNode("Light"));
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void mergeConfig(FXmlNode xconfig){
      super.mergeConfig(xconfig);
      // 读取属性
      _color.parse(xconfig.get("color"));
      _moveSpeed = xconfig.getFloat("move_speed", _moveSpeed);
      _rotationKeySpeed = xconfig.getFloat("rotation_key_speed", _rotationKeySpeed);
      _rotationMouseSpeed = xconfig.getFloat("rotation_mouse_speed", _rotationMouseSpeed);
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Material")){
            _material.mergeConfig(xnode);
         }else if(xnode.isName("Camera")){
            _camera.mergeConfig(xnode);
         }else if(xnode.isName("Light")){
            _light.mergeConfig(xnode);
         }else{
            throw new FFatalError("Invalid config node.");
         }
      }
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
