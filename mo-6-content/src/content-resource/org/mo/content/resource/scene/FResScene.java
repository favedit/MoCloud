package org.mo.content.resource.scene;

import org.mo.cloud.logic.data.resource.scene.FGcResSceneInfo;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.INamePair;
import org.mo.com.lang.RUuid;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource.common.FResDisplayLayer;
import org.mo.content.resource.common.FResObject;
import org.mo.content.resource.common.FResSpace;
import org.mo.content.resource.template.FResTemplate;

//============================================================
// <T>场景。</T>
//============================================================
public class FResScene
      extends FResSpace
{
   // 模型集合
   protected FDictionary<FResTemplate> _templates = new FDictionary<FResTemplate>(FResTemplate.class);

   //============================================================
   // <T>构造场景。</T>
   //============================================================
   public FResScene(){
      _typeName = "Scene";
   }

   //============================================================
   // <T>创建子对象。</T>
   //
   // @param xconfig 配置信息
   // @return 子对象
   //============================================================
   @Override
   public FResObject createChild(FXmlNode xconfig){
      String typeName = xconfig.name();
      switch(typeName){
         case "SceneLayer":
            return new FResSceneLayer();
      }
      return super.createChild(xconfig);
   }

   //============================================================
   // <T>获得模板集合。</T>
   //
   // @return 模板集合
   //============================================================
   public FDictionary<FResTemplate> templates(){
      return _templates;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 存储模板定义集合
      if(_templates != null){
         int count = _templates.count();
         output.writeInt16((short)count);
         for(INamePair<FResTemplate> pair : _templates){
            pair.value().serialize(output);
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
      // 读取节点集合
      //for(FXmlNode xnode : xconfig){
      //if(xnode.isName("TemplateCollection")){
      // 读取层集合
      //            for(FXmlNode xlayer : xnode){
      //               FRs3SceneLayer layer = new FRs3SceneLayer();
      //               layer.loadConfig(xlayer);
      //               _layers.push(layer);
      //            }
      //}
      //}
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
         for(FResDisplayLayer layer : _layers){
            layer.saveConfig(xlayers.createNode("Layer"));
         }
      }
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FGcResSceneInfo unit){
      // 读取配置
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadString(unit.content());
      loadConfig(xdocument.root());
      // 加载属性
      _ouid = unit.ouid();
      _guid = unit.guid();
      _code = unit.code();
      _label = unit.label();
   }

   //============================================================
   // <T>将配置信息存入数据单元中。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void saveUnit(FGcResSceneInfo unit){
      // 存储属性
      unit.setCode(_code);
      unit.setFullCode(_fullCode);
      unit.setLabel(_label);
      unit.setKeywords(_keywords);
      // 存储配置
      FXmlNode xconfig = new FXmlNode("Scene");
      saveConfig(xconfig);
      unit.setContent(xconfig.xml().toString());
   }

   //============================================================
   // <T>从配置节点中合并数据信息。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void mergeConfig(FXmlNode xconfig){
      // 读取属性
      _code = xconfig.get("code");
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
               boolean isClone = xlayer.getBoolean("is_clone", false);
               if(isClone){
                  xlayer.set("guid", RUuid.makeUniqueId());
               }
               String layerGuid = xlayer.get("guid");
               FResDisplayLayer layer = findLayerByGuid(layerGuid);
               if(layer == null){
                  layer = new FResDisplayLayer();
                  layer.setGuid(layerGuid);
                  this.pushLayer(layer);
               }
               layer.mergeConfig(xlayer);
            }
         }
      }
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   @Override
   public void importData(IDataInput input){
      // 读取属性
      _code = input.readString();
      _fullCode = input.readString();
      _label = input.readString();
      _keywords = input.readString();
      input.readString(); // themeCode
      // 导入技术
      _technique.importData(input);
      // 导入区域
      _region.importData(input);
      // 读取层集合
      FResSceneLayer skyLayer = new FResSceneLayer();
      skyLayer.importData(input);
      pushLayer(skyLayer);
      FResSceneLayer mapLayer = new FResSceneLayer();
      mapLayer.importData(input);
      _layers.push(mapLayer);
      FResSceneLayer spaceLayer = new FResSceneLayer();
      spaceLayer.importData(input);
      _layers.push(spaceLayer);
   }
}
