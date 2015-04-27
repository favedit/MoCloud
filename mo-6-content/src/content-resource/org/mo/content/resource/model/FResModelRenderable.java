package org.mo.content.resource.model;

import org.mo.content.resource.common.FResRenderable;

import org.mo.com.io.IDataOutput;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源模型渲染对象。</T>
//============================================================
public class FResModelRenderable
      extends FResRenderable
{
   // 网格唯一编号
   private String _meshGuid;

   //============================================================
   // <T>构造资源模型渲染对象。</T>
   //============================================================
   public FResModelRenderable(){
      _typeName = "ModelRenderable";
   }

   //============================================================
   // <T>获得网格唯一编号。</T>
   //
   // @return 网格唯一编号
   //============================================================
   public String meshGuid(){
      return _meshGuid;
   }

   //============================================================
   // <T>设置网格唯一编号。</T>
   //
   // @param meshGuid 网格唯一编号
   //============================================================
   public void setMeshGuid(String meshGuid){
      _meshGuid = meshGuid;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      output.writeString(_meshGuid);
   }

   //============================================================
   // <T>从配置节点中加载数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      _meshGuid = xconfig.get("mesh_guid");
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      super.saveConfig(xconfig);
      xconfig.set("mesh_guid", _meshGuid);
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
}
