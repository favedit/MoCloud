package org.mo.content.resource3d.common;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源显示对象。</T>
//============================================================
public class FRs3Spatial
      extends FRs3DisplayContainer
{
   // 类型名称
   protected String _typeName = "Spatial";

   // 材质集合
   protected FObjects<FRs3Material> _materials;

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FRs3Spatial(){
   }

   //============================================================
   // <T>判断是否含有材质。</T>
   //
   // @return 是否含有
   //============================================================
   public boolean hasMaterial(){
      return (_materials != null) ? !_materials.isEmpty() : false;
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
   // <T>增加一个材质。</T>
   //
   // @param material 材质
   //============================================================
   public void pushMaterial(FRs3Material material){
      if(_materials == null){
         _materials = new FObjects<FRs3Material>(FRs3Material.class);
      }
      _materials.push(material);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 输出网格集合
      int materialCount = _materials.count();
      output.writeInt16((short)materialCount);
      for(int i = 0; i < materialCount; i++){
         FRs3Material material = _materials.get(i);
         material.serialize(output);
      }
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 读取节点集合
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("MaterialCollection")){
            for(FXmlNode xchild : xnode){
               if(xchild.isName("Material")){
                  FRs3Material material = new FRs3Material();
                  material.loadConfig(xchild);
                  _materials.push(material);
               }
            }
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
      // 存储材质集合
      if(hasMaterial()){
         FXmlNode xmaterials = xconfig.createNode("MaterialCollection");
         for(FRs3Material material : _materials){
            material.saveConfig(xmaterials.createNode("Material"));
         }
      }
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void importConfig(FXmlNode xconfig){
      super.importConfig(xconfig);
      // 读取节点集合
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("MaterialCollection")){
            for(FXmlNode xchild : xnode){
               if(xchild.isName("Material")){
                  FRs3Material material = new FRs3Material();
                  material.importConfig(xchild);
                  _materials.push(material);
               }
            }
         }
      }
   }
}
