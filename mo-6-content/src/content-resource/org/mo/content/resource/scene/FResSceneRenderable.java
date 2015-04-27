package org.mo.content.resource.scene;

import org.mo.content.resource.common.FResRenderable;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>场景渲染。</T>
//============================================================
public class FResSceneRenderable
      extends FResRenderable
{
   //============================================================
   // <T>构造场景渲染。</T>
   //============================================================
   public FResSceneRenderable(){
      _typeName = "SceneRenderable";
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
   }

   //============================================================
   // <T>从配置节点中加载数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      // 读取属性
      _guid = xconfig.get("guid");
      _code = xconfig.get("code");
   }

   //============================================================
   // <T>从配置节点中合并数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void mergeConfig(FXmlNode xconfig){
      super.mergeConfig(xconfig);
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
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      // 读取属性
      _code = input.readString();
   }
}
