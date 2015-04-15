package org.mo.content.resource3d.common;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>场景。</T>
//============================================================
public class FRs3Space
      extends FRs3Resource
{
   // 场景技术
   protected FRs3Technique _technique = new FRs3Technique();

   // 场景区域
   protected FRs3Region _region = new FRs3Region();

   // 材质集合
   protected FObjects<FRs3Material> _materials;

   // 显示层集合
   protected FObjects<FRs3DisplayLayer> _layers;

   //============================================================
   // <T>构造场景。</T>
   //============================================================
   public FRs3Space(){
   }

   //============================================================
   // <T>获得场景技术。</T>
   //
   // @return 场景技术
   //============================================================
   public FRs3Technique technique(){
      return _technique;
   }

   //============================================================
   // <T>获得场景区域。</T>
   //
   // @return 场景区域
   //============================================================
   public FRs3Region region(){
      return _region;
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
   // <T>根据唯一编号查找材质。</T>
   //
   // @param guid 唯一编号
   // @return 材质
   //============================================================
   public FRs3Material findMaterialByGuid(String guid){
      if(!RString.isEmpty(guid)){
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
   // <T>判断是否含有显示层。</T>
   //
   // @return 是否含有
   //============================================================
   public boolean hasLayer(){
      return (_layers != null) ? !_layers.isEmpty() : false;
   }

   //============================================================
   // <T>根据唯一编号查找场景层。</T>
   //
   // @param guid 唯一编号
   // @return 场景层
   //============================================================
   public FRs3DisplayLayer findLayerByGuid(String guid){
      if(!RString.isEmpty(guid)){
         for(FRs3DisplayLayer layer : _layers){
            if(guid.equals(layer.guid())){
               return layer;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>获得场景层集合。</T>
   //
   // @return 场景层集合
   //============================================================
   public FObjects<FRs3DisplayLayer> layers(){
      return _layers;
   }

   //============================================================
   // <T>增加一个显示层。</T>
   //
   // @param layer 显示层
   //============================================================
   public void pushLayer(FRs3DisplayLayer layer){
      if(_layers == null){
         _layers = new FObjects<FRs3DisplayLayer>(FRs3DisplayLayer.class);
      }
      _layers.push(layer);
   }

   //============================================================
   // <T>获得场景显示集合。</T>
   //
   // @return 场景显示集合
   //============================================================
   public FObjects<FRs3Spatial> filterDisplays(){
      FObjects<FRs3Spatial> displays = new FObjects<FRs3Spatial>(FRs3Spatial.class);
      if(_layers != null){
         for(FRs3DisplayLayer layer : _layers){
            layer.filterDisplays(displays);
         }
      }
      return displays;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 存储属性
      _technique.serialize(output);
      _region.serialize(output);
      // 存储场景层集合
      if(_layers != null){
         int count = _layers.count();
         output.writeInt16((short)count);
         for(FRs3DisplayLayer layer : _layers){
            layer.serialize(output);
         }
      }else{
         output.writeInt16((short)0);
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
      // 读取属性
      _fullCode = xconfig.get("full_code", _fullCode);
      _keywords = xconfig.get("keywords", _keywords);
      // 读取节点集合
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Technique")){
            // 读取技术
            _technique.loadConfig(xnode);
         }else if(xnode.isName("Region")){
            // 读取区域
            _region.loadConfig(xnode);
         }else if(xnode.isName("MaterialCollection")){
            // 读取层集合
            for(FXmlNode xmaterial : xnode){
               FRs3Material material = new FRs3Material();
               material.loadConfig(xmaterial);
               pushMaterial(material);
            }
         }else if(xnode.isName("LayerCollection")){
            // 读取层集合
            for(FXmlNode xlayer : xnode){
               FRs3DisplayLayer layer = new FRs3DisplayLayer();
               layer.loadConfig(xlayer);
               pushLayer(layer);
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
      // 存储属性
      xconfig.set("guid", _guid);
      xconfig.set("code", _code);
      xconfig.set("full_code", _fullCode);
      xconfig.set("label", _label);
      xconfig.set("keywords", _keywords);
      // 存储技术
      _technique.saveConfig(xconfig.createNode("Technique"));
      // 存储区域
      _region.saveConfig(xconfig.createNode("Region"));
      // 存储层集合
      if(hasMaterial()){
         FXmlNode xmaterial = xconfig.createNode("MaterialCollection");
         for(FRs3Material material : _materials){
            material.saveConfig(xmaterial.createNode("Material"));
         }
      }
      if(hasLayer()){
         FXmlNode xlayers = xconfig.createNode("LayerCollection");
         for(FRs3DisplayLayer layer : _layers){
            layer.saveConfig(xlayers.createNode("Layer"));
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
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Technique")){
            // 读取技术
            _technique.mergeConfig(xnode);
         }else if(xnode.isName("Region")){
            // 读取区域
            _region.mergeConfig(xnode);
         }else if(xnode.isName("MaterialCollection")){
            // 读取材质集合
            for(FXmlNode xmaterial : xnode){
               String materialGuid = xmaterial.get("guid");
               FRs3Material material = findMaterialByGuid(materialGuid);
               material.mergeConfig(xmaterial);
            }
         }else if(xnode.isName("LayerCollection")){
            // 读取显示层集合
            for(FXmlNode xlayer : xnode){
               String layerGuid = xlayer.get("guid");
               FRs3DisplayLayer layer = findLayerByGuid(layerGuid);
               layer.mergeConfig(xlayer);
            }
         }
      }
   }
}
