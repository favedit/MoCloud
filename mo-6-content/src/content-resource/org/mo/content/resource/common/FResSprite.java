package org.mo.content.resource.common;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.lang.RUuid;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源精灵对象。</T>
// <T>可以被控制和自带事件和行为。</T>
//============================================================
public class FResSprite
      extends FResDisplayContainer
{
   // 材质集合
   protected FObjects<FResMaterial> _materials;

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FResSprite(){
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
   public FResMaterial findMaterialByGuid(String guid){
      if(!RString.isEmpty(guid) && (_materials != null)){
         for(FResMaterial material : _materials){
            if(guid.equals(material.guid())){
               return material;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>根据父唯一编号查找材质对象。</T>
   //
   // @param guid 父唯一编号
   // @return 材质对象
   //============================================================
   public FResMaterial findMaterialByParentGuid(String guid){
      if(!RString.isEmpty(guid) && (_materials != null)){
         for(FResMaterial material : _materials){
            if(guid.equals(material.parentGuid())){
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
   public FObjects<FResMaterial> materials(){
      return _materials;
   }

   //============================================================
   // <T>增加一个材质。</T>
   //
   // @param material 材质
   //============================================================
   public void pushMaterial(FResMaterial material){
      if(_materials == null){
         _materials = new FObjects<FResMaterial>(FResMaterial.class);
      }
      _materials.push(material);
   }

   //============================================================
   // <T>设置材质集合。</T>
   //
   // @param materials 材质集合
   //============================================================
   public void setMaterials(FObjects<FResMaterial> materials){
      if(_materials == null){
         _materials = new FObjects<FResMaterial>(FResMaterial.class);
      }else{
         _materials.clear();
      }
      _materials.assign(materials);
   }

   //============================================================
   // <T>清空材质集合。</T>
   //============================================================
   public void clearMaterials(){
      if(_materials != null){
         _materials.clear();
      }
   }

   //============================================================
   // <T>接收资源数据。</T>
   //
   // @param resource 资源
   //============================================================
   @Override
   public void assignInfo(FResObject resource){
      super.assignInfo(resource);
      FResSprite sprite = (FResSprite)resource;
      // 复制材质集合
      if(_materials != null){
         _materials.clear();
      }
      if(sprite.hasMaterial()){
         for(FResMaterial material : sprite.materials()){
            FResMaterial createMaterial = new FResMaterial();
            createMaterial.assignInfo(material);
            pushMaterial(createMaterial);
         }
      }
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
            FResMaterial material = _materials.get(i);
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
                  FResMaterial material = new FResMaterial();
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
         for(FResMaterial material : _materials){
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
               boolean isClone = xmaterial.getBoolean("is_clone", false);
               if(isClone){
                  xmaterial.set("guid", RUuid.makeUniqueId());
               }
               String materialGuid = xmaterial.get("guid");
               FResMaterial material = findMaterialByGuid(materialGuid);
               if(material == null){
                  String materialParentGuid = xmaterial.get("parent_guid");
                  if(RString.isEmpty(materialParentGuid)){
                     throw new FFatalError("Parent material guid is empty.");
                  }
                  material = new FResMaterial();
                  material.setGuid(materialGuid);
                  material.setParentGuid(materialParentGuid);
                  pushMaterial(material);
               }
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
                  FResMaterial material = new FResMaterial();
                  material.importConfig(xchild);
                  _materials.push(material);
               }
            }
         }
      }
   }
}
