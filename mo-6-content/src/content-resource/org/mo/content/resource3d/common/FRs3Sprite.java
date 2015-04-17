package org.mo.content.resource3d.common;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源精灵对象。</T>
// <T>可以被控制和自带事件和行为。</T>
//============================================================
public class FRs3Sprite
      extends FRs3DisplayContainer
{
   // 材质集合
   protected FObjects<FRs3Material> _materials;

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FRs3Sprite(){
      _typeName = "Sprite";
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
   // <T>根据唯一编号查找材质对象。</T>
   //
   // @param guid 唯一编号
   // @return 材质对象
   //============================================================
   public FRs3Material findMaterialByGuid(String guid){
      if(!RString.isEmpty(guid) && (_materials != null)){
         for(FRs3Material material : _materials){
            if(guid.equals(material.guid())){
               return material;
            }
         }
      }
      return null;
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
      if(hasMaterial()){
         int materialCount = _materials.count();
         output.writeUint16(materialCount);
         for(int i = 0; i < materialCount; i++){
            FRs3Material material = _materials.get(i);
            material.serialize(output);
         }
      }else{
         output.writeUint16(0);
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
                  pushMaterial(material);
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
   // <T>从配置节点中合并数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void mergeConfig(FXmlNode xconfig){
      super.mergeConfig(xconfig);
      // 读取节点集合
      for(FXmlNode xnode : xconfig.nodes()){
         if(xnode.isName("MaterialCollection")){
            // 读取动画集合
            for(FXmlNode xmaterial : xnode){
               String materialGuid = xmaterial.get("guid");
               FRs3Material material = findMaterialByGuid(materialGuid);
               material.mergeConfig(xmaterial);
            }
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
