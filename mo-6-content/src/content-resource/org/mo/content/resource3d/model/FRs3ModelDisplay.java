package org.mo.content.resource3d.model;

import org.mo.com.io.IDataOutput;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.common.FRs3Display;
import org.mo.content.resource3d.common.FRs3Material;
import org.mo.content.resource3d.common.FRs3Object;

//============================================================
// <T>场景渲染。</T>
//============================================================
public class FRs3ModelDisplay
      extends FRs3Display
{
   // 材质
   protected FRs3Material _material = new FRs3Material();

   //============================================================
   // <T>构造场景渲染。</T>
   //============================================================
   public FRs3ModelDisplay(){
      _typeName = "ModelDisplay";
   }

   //============================================================
   // <T>创建子对象。</T>
   //
   // @param xconfig 配置信息
   // @return 子对象
   //============================================================
   @Override
   public FRs3Object createChild(FXmlNode xconfig){
      return new FRs3ModelRenderable();
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
