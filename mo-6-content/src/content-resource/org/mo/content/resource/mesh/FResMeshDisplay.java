package org.mo.content.resource.mesh;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.xml.FXmlNode;
import org.mo.content.geom.common.SFloatMatrix3d;
import org.mo.content.resource.common.FResComponent;
import org.mo.content.resource.common.FResMaterial;
import org.mo.content.resource.common.FResRenderable;

//============================================================
// <T>场景渲染。</T>
//============================================================
public class FResMeshDisplay
      extends FResComponent
{
   // 矩阵
   protected SFloatMatrix3d _matrix = new SFloatMatrix3d();

   // 材质
   protected FResMaterial _material = new FResMaterial();

   // 渲染对象
   protected FResRenderable _renderable = new FResRenderable();

   //============================================================
   // <T>构造场景渲染。</T>
   //============================================================
   public FResMeshDisplay(){
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      _matrix.serialize(output);
      _material.serialize(output);
      _renderable.serialize(output);
   }

   //============================================================
   // <T>从配置节点中加载数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Matrix")){
            _matrix.loadConfig(xnode);
         }else if(xnode.isName("Material")){
            _material.loadConfig(xnode);
         }else if(xnode.isName("Renderable")){
            _renderable.loadConfig(xnode);
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
      super.saveConfig(xconfig);
      // 存储属性
      _matrix.saveConfig(xconfig.createNode("Matrix"));
      _material.saveConfig(xconfig.createNode("Material"));
      _renderable.saveConfig(xconfig.createNode("Renderable"));
   }

   //============================================================
   // <T>从配置节点中合并数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void mergeConfig(FXmlNode xconfig){
      super.mergeConfig(xconfig);
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Matrix")){
            _matrix.loadConfig(xnode);
         }else if(xnode.isName("Material")){
            _material.mergeConfig(xnode);
         }else if(xnode.isName("Renderable")){
            _renderable.mergeConfig(xnode);
         }else{
            throw new FFatalError("Invalid config node.");
         }
      }
   }
}
