package org.mo.content.resource.common;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>场景显示。</T>
//============================================================
public class FResProjection
      extends FResObject
{
   // 夹角
   protected float _angle = 45;

   // 近平面距离
   protected float _znear = 0.1f;

   // 远平面距离
   protected float _zfar = 200f;

   //============================================================
   // <T>构造场景层。</T>
   //============================================================
   public FResProjection(){
      _typeName = "Projection";
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
      if(_angle <= 0){
         _angle = 45;
      }
      output.writeFloat(_angle);
      if(_znear <= 0){
         _znear = 0.1f;
      }
      output.writeFloat(_znear);
      if(_zfar <= 0){
         _zfar = 200f;
      }
      output.writeFloat(_zfar);
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
      _angle = xconfig.getFloat("angle");
      _znear = xconfig.getFloat("znear");
      _zfar = xconfig.getFloat("zfar");
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
      xconfig.set("angle", _angle);
      xconfig.set("znear", _znear);
      xconfig.set("zfar", _zfar);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      // 读取属性
      _angle = input.readFloat();
      _znear = input.readFloat();
      _zfar = input.readFloat();
   }
}
