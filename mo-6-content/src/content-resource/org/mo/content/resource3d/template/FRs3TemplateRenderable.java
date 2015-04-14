package org.mo.content.resource3d.template;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.common.FRs3Display;
import org.mo.content.resource3d.common.FRs3Material;

//============================================================
// <T>资源显示对象。</T>
//============================================================
public class FRs3TemplateRenderable
      extends FRs3Display
{
   // 类型名称
   protected String _typeName = "Display";

   // 模型代码
   protected String _modelCode;

   // 模型唯一编号
   protected String _modelGuid;

   // 网格唯一编号
   protected String _meshGuid;

   // 网格代码
   protected String _meshCode;

   // 网格集合
   protected FObjects<FRs3Material> _materials = new FObjects<FRs3Material>(FRs3Material.class);

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FRs3TemplateRenderable(){
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
   // <T>获得模型唯一编号。</T>
   //
   // @return 模型唯一编号
   //============================================================
   public String modelGuid(){
      return _modelGuid;
   }

   //============================================================
   // <T>设置模型唯一编号。</T>
   //
   // @return 模型唯一编号
   //============================================================
   public void setModelGuid(String modelGuid){
      _modelGuid = modelGuid;
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
   // @return 网格唯一编号
   //============================================================
   public void setMeshGuid(String meshGuid){
      _meshGuid = meshGuid;
   }

   //============================================================
   // <T>获得材质集合。</T>
   //
   // @return 材质集合
   //============================================================
   public FObjects<FRs3Material> materials(){
      return _materials;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      //      // 输出属性
      //      output.writeString(_typeName);
      //      output.writeString(_modelGuid);
      //      output.writeString(_meshGuid);
      //      _matrix.serialize(output);
      //      // 输出网格集合
      //      int materialCount = _materials.count();
      //      output.writeInt16((short)materialCount);
      //      for(int i = 0; i < materialCount; i++){
      //         FRs3DisplayMaterial material = _materials.get(i);
      //         material.serialize(output);
      //      }
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      //      // 读取属性
      //      _guid = xconfig.get("guid");
      //      _modelGuid = xconfig.get("model_guid");
      //      _meshGuid = xconfig.get("mesh_guid");
      //      // 读取节点集合
      //      for(FXmlNode xnode : xconfig){
      //         if(xnode.isName("Matrix")){
      //            _matrix.loadConfig(xnode);
      //         }else if(xnode.isName("MaterialCollection")){
      //            for(FXmlNode xchild : xnode){
      //               if(xchild.isName("Material")){
      //                  FRs3DisplayMaterial material = new FRs3DisplayMaterial();
      //                  material.loadConfig(xchild);
      //                  _materials.push(material);
      //               }
      //            }
      //         }
      //      }
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      //      xconfig.setName(_typeName);
      //      // 存储属性
      //      xconfig.set("guid", _guid);
      //      xconfig.set("model_guid", _modelGuid);
      //      xconfig.set("mesh_guid", _meshGuid);
      //      // 存储矩阵
      //      _matrix.saveConfig(xconfig.createNode("Matrix"));
      //      // 存储材质集合
      //      FXmlNode xmaterials = xconfig.createNode("MaterialCollection");
      //      for(FRs3DisplayMaterial material : _materials){
      //         material.saveConfig(xmaterials.createNode("Material"));
      //      }
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void importConfig(FXmlNode xconfig){
      //      // 读取属性
      //      _modelCode = xconfig.get("model_code");
      //      _meshCode = xconfig.get("mesh_code");
      //      // 读取节点集合
      //      for(FXmlNode xnode : xconfig){
      //         if(xnode.isName("Matrix")){
      //            _matrix.loadConfig(xnode);
      //         }else if(xnode.isName("MaterialCollection")){
      //            for(FXmlNode xchild : xnode){
      //               if(xchild.isName("Material")){
      //                  FRs3DisplayMaterial material = new FRs3DisplayMaterial();
      //                  material.importConfig(xchild);
      //                  _materials.push(material);
      //               }
      //            }
      //         }
      //      }
   }
}
