package org.mo.content.resource3d.template;

import com.cyou.gccloud.data.data.FDataResourceTemplateUnit;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.INamePair;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.common.FRs3Spatial;
import org.mo.content.resource3d.common.FRs3Material;
import org.mo.content.resource3d.common.FRs3MaterialGroup;
import org.mo.content.resource3d.common.FRs3Resource;
import org.mo.content.resource3d.common.FRs3Sprite;
import org.mo.content.resource3d.common.FRs3Theme;

//============================================================
// <T>资源模板。</T>
//============================================================
public class FRs3Template
      extends FRs3Resource
{
   // 材质集合
   protected FDictionary<FRs3MaterialGroup> _materialGroups = new FDictionary<FRs3MaterialGroup>(FRs3MaterialGroup.class);

   // 主题集合
   protected FObjects<FRs3Theme> _themes = new FObjects<FRs3Theme>(FRs3Theme.class);

   // 网格集合
   protected FObjects<FRs3Spatial> _displays = new FObjects<FRs3Spatial>(FRs3Spatial.class);

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FRs3Template(){
   }

   //============================================================
   // <T>同步材质。</T>
   //
   // @param code 代码
   // @return 材质
   //============================================================
   public FRs3MaterialGroup syncMaterialGroup(String code){
      FRs3MaterialGroup materialGroup = _materialGroups.find(code);
      if(materialGroup == null){
         materialGroup = new FRs3MaterialGroup();
         materialGroup.setCode(code);
         _materialGroups.set(code, materialGroup);
      }
      return materialGroup;
   }

   //============================================================
   // <T>获得材质分组集合。</T>
   //
   // @return 材质分组集合
   //============================================================
   public FDictionary<FRs3MaterialGroup> materialGroups(){
      return _materialGroups;
   }

   //============================================================
   // <T>获得主题集合。</T>
   //
   // @return 主题集合
   //============================================================
   public FObjects<FRs3Theme> themes(){
      return _themes;
   }

   //============================================================
   // <T>获得网格集合。</T>
   //
   // @return 网格集合
   //============================================================
   public FObjects<FRs3Spatial> displays(){
      return _displays;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      // 存储属性
      super.serialize(output);
      // 输出材质组集合
      int materialGroupCount = _materialGroups.count();
      output.writeInt16((short)materialGroupCount);
      for(int i = 0; i < materialGroupCount; i++){
         FRs3MaterialGroup materialGroup = _materialGroups.value(i);
         materialGroup.serialize(output);
      }
      // 输出主题集合
      int themeCount = _themes.count();
      output.writeInt16((short)themeCount);
      for(int i = 0; i < themeCount; i++){
         FRs3Theme theme = _themes.get(i);
         theme.serialize(output);
      }
      // 输出显示集合
      int displayCount = _displays.count();
      output.writeInt16((short)displayCount);
      for(int i = 0; i < displayCount; i++){
         FRs3Spatial display = _displays.get(i);
         display.serialize(output);
      }
   }

   //============================================================
   // <T>从配置节点中加载数据信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      // 检查参数
      if(!xconfig.isName("Template")){
         throw new FFatalError("Invalid config.");
      }
      // 读取属性
      //      _guid = xconfig.get("guid");
      //      _code = xconfig.get("code");
      // 读取节点集合
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("MaterialGroupCollection")){
            // 读取材质组集合
            //            for(FXmlNode xchild : xnode){
            //               if(xchild.isName("MaterialGroup")){
            //                  FRs3MaterialGroup materialGroup = new FRs3MaterialGroup();
            //                  materialGroup.loadConfig(xchild);
            //                  _materialGroups.set(materialGroup.guid(), materialGroup);
            //               }
            //            }
         }else if(xnode.isName("ThemeCollection")){
            // 读取主题集合
            //            for(FXmlNode xchild : xnode){
            //               if(xchild.isName("Theme")){
            //                  FRs3Theme theme = new FRs3Theme();
            //                  theme.loadConfig(xchild);
            //                  _themes.push(theme);
            //               }
            //            }
         }else if(xnode.isName("DisplayCollection")){
            // 读取显示集合
            for(FXmlNode xchild : xnode){
               if(xchild.isName("Sprite") || xchild.isName("Display")){
                  FRs3Sprite display = new FRs3Sprite();
                  display.loadConfig(xchild);
                  _displays.push(display);
               }
            }
         }else{
            throw new FFatalError("Unknown child node. (name={1})", xnode.name());
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
      xconfig.set("label", _label);
      // 存储材质分组集合
      FXmlNode xmaterialGroups = xconfig.createNode("MaterialGroupCollection");
      for(INamePair<FRs3MaterialGroup> pair : _materialGroups){
         pair.value().saveConfig(xmaterialGroups.createNode("MaterialGroup"));
      }
      // 存储主题集合
      FXmlNode xtheme = xconfig.createNode("ThemeCollection");
      for(FRs3Theme theme : _themes){
         theme.saveConfig(xtheme.createNode("Theme"));
      }
      // 存储显示集合
      FXmlNode xdisplays = xconfig.createNode("DisplayCollection");
      for(FRs3Spatial display : _displays){
         display.saveConfig(xdisplays.createNode("Display"));
      }
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FDataResourceTemplateUnit unit){
      // 加载属性
      _guid = unit.guid();
      _code = unit.code();
      // 读取配置
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadString(unit.content());
      loadConfig(xdocument.root());
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
            for(FXmlNode xchild : xnode){
               if(xchild.isName("Theme")){
                  FRs3Theme theme = new FRs3Theme();
                  theme.importConfig(xchild);
                  _themes.push(theme);
               }
            }
         }else if(xnode.isName("DisplayCollection")){
            for(FXmlNode xchild : xnode){
               if(xchild.isName("Sprite")){
                  FRs3Sprite display = new FRs3Sprite();
                  display.importConfig(xchild);
                  _displays.push(display);
               }
            }
         }
      }
      //............................................................
      // 建立所有材质组
      for(FRs3Theme theme : _themes){
         for(FRs3Material material : theme.materials()){
            FRs3MaterialGroup materialGroup = syncMaterialGroup(material.code());
            materialGroup.setLabel(material.label());
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
