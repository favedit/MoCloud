package org.mo.content.resource.common;

import org.mo.com.geom.SIntSize2;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>场景技术过程。</T>
//============================================================
public class FResTechniquePass
      extends FResObject
{
   // 目标尺寸
   protected SIntSize2 _targetSize = new SIntSize2();

   //============================================================
   // <T>构造场景技术过程。</T>
   //============================================================
   public FResTechniquePass(){
      _typeName = "TechniquePass";
   }

   //============================================================
   // <T>获得目标尺寸。</T>
   //
   // @param SIntSize2 目标尺寸
   //============================================================
   public SIntSize2 targetSize(){
      return _targetSize;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      _targetSize.serialize16(output);
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
      _code = xconfig.get("code");
      _targetSize.parse(xconfig.get("target_size"));
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
      xconfig.set("code", _code);
      xconfig.set("target_size", _targetSize);
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
