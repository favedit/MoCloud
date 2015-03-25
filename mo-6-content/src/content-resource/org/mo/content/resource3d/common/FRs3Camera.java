package org.mo.content.resource3d.common;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>场景显示。</T>
//============================================================
public class FRs3Camera
      extends FRs3Object
{
   // 类型
   protected String _typeCd;

   // 位置
   protected SFloatPoint3 _position = new SFloatPoint3();

   // 方向
   protected SFloatVector3 _direction = new SFloatVector3();

   // 投影
   protected FRs3Projection _projection = new FRs3Projection();

   //============================================================
   // <T>构造场景层。</T>
   //============================================================
   public FRs3Camera(){
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
      output.writeString(_typeCd);
      _position.serialize(output);
      _direction.serialize(output);
      // 存储投影
      _projection.serialize(output);
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
      _typeCd = xconfig.get("type_cd");
      _position.parse(xconfig.get("position"));
      _direction.parse(xconfig.get("direction"));
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Projection")){
            _projection.loadConfig(xnode);
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
      xconfig.set("type_cd", _typeCd);
      xconfig.set("position", _position);
      xconfig.set("direction", _direction);
      _projection.saveConfig(xconfig.createNode("Projection"));
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void mergeConfig(FXmlNode xconfig){
      super.mergeConfig(xconfig);
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Projection")){
            _projection.mergeConfig(xnode);
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
      _typeCd = input.readString();
      _position.unserialize(input);
      _direction.unserialize(input);
      _projection.importData(input);
   }
}
