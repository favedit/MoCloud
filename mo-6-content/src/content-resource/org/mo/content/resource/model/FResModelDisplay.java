package org.mo.content.resource.model;

import org.mo.content.resource.common.FResDisplay;
import org.mo.content.resource.common.FResMaterial;
import org.mo.content.resource.common.FResObject;

import org.mo.com.io.IDataOutput;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>场景渲染。</T>
//============================================================
public class FResModelDisplay
      extends FResDisplay
{
   // 材质
   protected FResMaterial _material = new FResMaterial();

   //============================================================
   // <T>构造场景渲染。</T>
   //============================================================
   public FResModelDisplay(){
      _typeName = "ModelDisplay";
   }

   //============================================================
   // <T>创建子对象。</T>
   //
   // @param xconfig 配置信息
   // @return 子对象
   //============================================================
   @Override
   public FResObject createChild(FXmlNode xconfig){
      return new FResModelRenderable();
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      _material.serialize(output);
   }

   //============================================================
   // <T>从配置节点中加载数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 加载材质信息
      FXmlNode xmaterial = xconfig.findNode("Material");
      if(xmaterial != null){
         _material.loadConfig(xmaterial);
      }
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      super.saveConfig(xconfig);
      // 存储材质信息
      _material.saveConfig(xconfig.createNode("Material"));
   }

   //============================================================
   // <T>从配置节点中合并数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void mergeConfig(FXmlNode xconfig){
      super.mergeConfig(xconfig);
      // 加载材质信息
      FXmlNode xmaterial = xconfig.findNode("Material");
      if(xmaterial != null){
         _material.mergeConfig(xmaterial);
      }
   }
}
