package org.mo.content.resource3d.template;

import org.mo.cloud.logic.resource.template.FGcResTemplateInfo;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.common.FRs3Material;
import org.mo.content.resource3d.common.FRs3Shape;
import org.mo.content.resource3d.common.FRs3Space;
import org.mo.content.resource3d.common.FRs3Sprite;

//============================================================
// <T>资源模板。</T>
//============================================================
public class FRs3Template
      extends FRs3Space
{
   // 精灵
   protected FRs3Sprite _sprite = new FRs3Sprite();

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FRs3Template(){
      _typeName = "Template";
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FGcResTemplateInfo templateInfo){
      // 加载属性
      _guid = templateInfo.guid();
      _code = templateInfo.code();
      // 读取配置
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadString(templateInfo.content());
      loadConfig(xdocument.root());
   }

   //============================================================
   // <T>将配置信息存入数据单元中。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void saveUnit(FGcResTemplateInfo unit){
      // 存储属性
      unit.setFullCode(fullCode());
      unit.setCode(_code);
      unit.setLabel(_label);
      unit.setContent(toXml());
   }

   //============================================================
   // <T>从配置节点中导入数据信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void importConfig(FXmlNode xconfig){
      FXmlNode xtemplate = xconfig.findNode("Template");
      _code = xtemplate.get("code");
      _fullCode = xtemplate.get("full_code");
      _label = xtemplate.get("label");
      _keywords = xtemplate.get("keywords");
      // 处理所有节点
      for(FXmlNode xnode : xtemplate){
         if(xnode.isName("ThemeCollection")){
            FXmlNode xtheme = xnode.findNode("Theme");
            FXmlNode xmaterials = xtheme.findNode("MaterialCollection");
            for(FXmlNode xmaterial : xmaterials){
               if(xmaterial.isName("Material")){
                  FRs3Material material = new FRs3Material();
                  material.importConfig(xmaterial);
                  pushMaterial(material);
               }
            }
         }else if(xnode.isName("DisplayCollection")){
            for(FXmlNode xchild : xnode){
               if(xchild.isName("Sprite")){
                  FRs3Shape shape = new FRs3Shape();
                  shape.importConfig(xchild);
                  _sprite.pushRenderable(shape);
               }
            }
            pushDisplay(_sprite);
         }
      }
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public String toXml(){
      FXmlNode xconfig = new FXmlNode("Template");
      saveConfig(xconfig);
      return xconfig.xml().toString();
   }

   //============================================================
   // <T>获得字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      FXmlNode xconfig = new FXmlNode("Template");
      saveConfig(xconfig);
      return xconfig.xml().toString();
   }
}
