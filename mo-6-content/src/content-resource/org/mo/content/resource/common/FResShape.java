package org.mo.content.resource.common;

import org.mo.com.io.IDataOutput;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源形状对象。</T>
// <T>一个形状就是一个网格</T>
//============================================================
public class FResShape
      extends FResRenderable
{
   // 模型代码
   private String _modelCode;

   // 模型唯一编号
   protected String _modelGuid;

   // 网格代码
   protected String _meshCode;

   // 网格唯一编号
   protected String _meshGuid;

   // 材质代码
   protected String _materialCode;

   // 材质唯一编号
   protected String _materialGuid;

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FResShape(){
      _typeName = "Shape";
   }

   //============================================================
   // <T>获得模型唯一编码。</T>
   //
   // @return 模型唯一编码
   //============================================================
   public String modelGuid(){
      return _modelGuid;
   }

   //============================================================
   // <T>设置模型唯一编码。</T>
   //
   // @param modelGuid 模型唯一编码
   //============================================================
   public void setModelGuid(String modelGuid){
      _modelGuid = modelGuid;
   }

   //============================================================
   // <T>获得模型代码。</T>
   //
   // @return 模型代码
   //============================================================
   public String modelCode(){
      return _modelCode;
   }

   //============================================================
   // <T>设置模型代码。</T>
   //
   // @param modelCode 模型代码
   //============================================================
   public void setModelCode(String modelCode){
      _modelCode = modelCode;
   }

   //============================================================
   // <T>获得网格唯一编码。</T>
   //
   // @return 网格唯一编码
   //============================================================
   public String meshGuid(){
      return _meshGuid;
   }

   //============================================================
   // <T>设置网格唯一编码。</T>
   //
   // @param meshGuid 网格唯一编码
   //============================================================
   public void setMeshGuid(String meshGuid){
      _meshGuid = meshGuid;
   }

   //============================================================
   // <T>获得网格代码。</T>
   //
   // @return 网格代码
   //============================================================
   public String meshCode(){
      return _meshCode;
   }

   //============================================================
   // <T>设置网格代码。</T>
   //
   // @param meshCode 网格代码
   //============================================================
   public void setMeshCode(String meshCode){
      _meshCode = meshCode;
   }

   //============================================================
   // <T>获得材质唯一编码。</T>
   //
   // @return 材质唯一编码
   //============================================================
   public String materialGuid(){
      return _materialGuid;
   }

   //============================================================
   // <T>设置材质唯一编码。</T>
   //
   // @param materialGuid 材质唯一编码
   //============================================================
   public void setMaterialGuid(String materialGuid){
      _materialGuid = materialGuid;
   }

   //============================================================
   // <T>获得材质代码。</T>
   //
   // @return 材质代码
   //============================================================
   public String materialCode(){
      return _materialCode;
   }

   //============================================================
   // <T>设置材质代码。</T>
   //
   // @param materialCode 材质代码
   //============================================================
   public void setMaterialCode(String materialCode){
      _materialCode = materialCode;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 输出属性
      output.writeString(_modelGuid);
      output.writeString(_meshGuid);
      output.writeString(_materialGuid);
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 读取属性
      _modelGuid = xconfig.get("model_guid");
      _modelCode = xconfig.get("model_code");
      _meshGuid = xconfig.get("mesh_guid");
      _meshCode = xconfig.get("mesh_code");
      _materialGuid = xconfig.get("material_guid");
      _materialCode = xconfig.get("material_code");
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
      xconfig.set("model_guid", _modelGuid);
      xconfig.set("model_code", _modelCode);
      xconfig.set("mesh_guid", _meshGuid);
      xconfig.set("mesh_code", _meshCode);
      xconfig.set("material_guid", _materialGuid);
      xconfig.set("material_code", _materialCode);
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void importConfig(FXmlNode xconfig){
      // 读取属性
      _modelCode = xconfig.get("model_code");
      _meshCode = xconfig.get("mesh_code");
      FXmlNode xmatrix = xconfig.findNode("Matrix");
      if(xmatrix != null){
         _matrix.loadConfig(xmatrix);
      }
      FXmlNode xmaterials = xconfig.findNode("MaterialCollection");
      if(xmaterials != null){
         if(xmaterials.hasNode()){
            FXmlNode xmaterial = xmaterials.nodes().first();
            _materialCode = xmaterial.get("code");
         }
      }
   }
}
