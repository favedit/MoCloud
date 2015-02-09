package org.mo.content.resource3d.scene;

import com.cyou.gccloud.data.data.FDataResource3dSceneUnit;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.common.FRs3Resource;

//============================================================
// <T>场景。</T>
//============================================================
public class FRs3Scene
      extends FRs3Resource
{
   // 主题代码
   protected String _themeCode;

   // 场景技术
   protected FRs3SceneTechnique _technique = new FRs3SceneTechnique();

   // 场景区域
   protected FRs3SceneRegion _region = new FRs3SceneRegion();

   // 场景层集合
   protected FObjects<FRs3SceneLayer> _layers = new FObjects<FRs3SceneLayer>(FRs3SceneLayer.class);

   //============================================================
   // <T>构造场景。</T>
   //============================================================
   public FRs3Scene(){
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
      output.writeString(_themeCode);
      _technique.serialize(output);
      _region.serialize(output);
      // 存储场景层集合
      if(_layers != null){
         int count = _layers.count();
         output.writeInt16((short)count);
         for(FRs3SceneLayer layer : _layers){
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
   public void loadConfig(FXmlNode xconfig){
      // 读取属性
      _code = xconfig.get("code");
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
               FRs3SceneLayer layer = new FRs3SceneLayer();
               layer.loadConfig(xlayer);
               _layers.push(layer);
            }
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
   public void saveConfig(FXmlNode xconfig){
      // 存储属性
      xconfig.set("guid", _guid);
      xconfig.set("code", _code);
      xconfig.set("label", _label);
      // 存储技术
      _technique.saveConfig(xconfig.createNode("Technique"));
      // 存储区域
      _region.saveConfig(xconfig.createNode("Region"));
      // 存储层集合
      if(_layers != null){
         FXmlNode xlayers = xconfig.createNode("LayerCollection");
         for(FRs3SceneLayer layer : _layers){
            layer.saveConfig(xlayers.createNode("Layer"));
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
      _label = input.readString();
      _themeCode = input.readString();
      // 导入技术
      _technique.importData(input);
      // 导入区域
      _region.importData(input);
      // 读取层集合
      FRs3SceneLayer skyLayer = new FRs3SceneLayer();
      skyLayer.importData(input);
      _layers.push(skyLayer);
      FRs3SceneLayer mapLayer = new FRs3SceneLayer();
      mapLayer.importData(input);
      _layers.push(mapLayer);
      FRs3SceneLayer spaceLayer = new FRs3SceneLayer();
      spaceLayer.importData(input);
      _layers.push(spaceLayer);
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FDataResource3dSceneUnit unit){
      // 加载属性
      _ouid = unit.ouid();
      _guid = unit.guid();
      _code = unit.code();
      _label = unit.label();
      // 读取配置
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadString(unit.content());
      loadConfig(xdocument.root());
   }

   //============================================================
   // <T>将配置信息存入数据单元中。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void saveUnit(FDataResource3dSceneUnit unit){
      // 存储属性
      unit.setCode(_code);
      unit.setLabel(_label);
      unit.setContent(toXml());
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public String toXml(){
      FXmlNode xconfig = new FXmlNode("Scene");
      saveConfig(xconfig);
      return xconfig.xml().toString();
   }
}
