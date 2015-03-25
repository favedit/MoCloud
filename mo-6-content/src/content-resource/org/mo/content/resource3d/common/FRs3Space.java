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

   // 场景层集合
   protected FObjects<FRs3DisplayLayer> _layers = new FObjects<FRs3DisplayLayer>(FRs3DisplayLayer.class);

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
   // <T>获得场景显示集合。</T>
   //
   // @return 场景显示集合
   //============================================================
   public FObjects<FRs3Display> filterDisplays(){
      FObjects<FRs3Display> displays = new FObjects<FRs3Display>(FRs3Display.class);
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
      // 读取属性
      _code = xconfig.get("code");
      _fullCode = xconfig.get("full_code");
      _label = xconfig.get("label");
      _keywords = xconfig.get("keywords");
      // 读取节点集合
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Technique")){
            // 读取技术
            _technique.loadConfig(xnode);
         }else if(xnode.isName("Region")){
            // 读取区域
            _region.loadConfig(xnode);
         }else if(xnode.isName("LayerCollection")){
            // 读取层集合
            for(FXmlNode xlayer : xnode){
               FRs3DisplayLayer layer = new FRs3DisplayLayer();
               layer.loadConfig(xlayer);
               _layers.push(layer);
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
      if(_layers != null){
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
      // 读取属性
      _label = xconfig.get("label");
      // 读取节点集合
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("Technique")){
            // 读取技术
            _technique.mergeConfig(xnode);
         }else if(xnode.isName("Region")){
            // 读取区域
            _region.mergeConfig(xnode);
         }else if(xnode.isName("LayerCollection")){
            // 读取层集合
            for(FXmlNode xlayer : xnode){
               String layerGuid = xlayer.get("guid");
               FRs3DisplayLayer layer = findLayerByGuid(layerGuid);
               layer.mergeConfig(xlayer);
            }
         }
      }
   }
}
