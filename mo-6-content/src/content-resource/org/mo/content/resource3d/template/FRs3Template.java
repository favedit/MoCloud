package org.mo.content.resource3d.template;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FDictionary;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.INamePair;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.common.FRs3Display;
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
   // 唯一编号
   protected String _guid;

   // 材质集合
   protected FDictionary<FRs3MaterialGroup> _materialGroups = new FDictionary<FRs3MaterialGroup>(FRs3MaterialGroup.class);

   // 主题集合
   protected FObjects<FRs3Theme> _themes = new FObjects<FRs3Theme>(FRs3Theme.class);

   // 网格集合
   protected FObjects<FRs3Display> _displays = new FObjects<FRs3Display>(FRs3Display.class);

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FRs3Template(){
   }

   //============================================================
   // <T>获得唯一编号。</T>
   //
   // @return 唯一编号
   //============================================================
   public String guid(){
      return _guid;
   }

   //============================================================
   // <T>设置唯一编号。</T>
   //
   // @return 唯一编号
   //============================================================
   public void setGuid(String guid){
      _guid = guid;
   }

   //============================================================
   // <T>同步材质。</T>
   //
   // @param code 代码
   // @return 材质
   //============================================================
   public FRs3MaterialGroup syncMaterial(String code){
      FRs3MaterialGroup material = _materialGroups.find(code);
      if(material == null){
         material = new FRs3MaterialGroup();
         material.setCode(code);
         _materialGroups.set(code, material);
      }
      return material;
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
   public FObjects<FRs3Display> displays(){
      return _displays;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      //      // 输出网格集合
      //      int meshCount = _meshs.count();
      //      output.writeInt16((short)meshCount);
      //      for(int i = 0; i < meshCount; i++){
      //         FRs3ModelMesh mesh = _meshs.get(i);
      //         mesh.serialize(output);
      //      }
   }

   //============================================================
   // <T>从配置节点中加载数据信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      // 检查参数
      if(!xconfig.isName("Template")){
         throw new FFatalError("Invalid config.");
      }
      // 读取属性
      _guid = xconfig.get("guid");
      _code = xconfig.get("code");
      // 读取节点集合
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("MaterialGroupCollection")){
            // 读取材质组集合
            for(FXmlNode xchild : xnode){
               if(xchild.isName("MaterialGroup")){
                  FRs3MaterialGroup materialGroup = new FRs3MaterialGroup();
                  materialGroup.loadConfig(xchild);
                  _materialGroups.set(materialGroup.guid(), materialGroup);
               }
            }
         }else if(xnode.isName("ThemeCollection")){
            // 读取主题集合
            for(FXmlNode xchild : xnode){
               if(xchild.isName("Theme")){
                  FRs3Theme theme = new FRs3Theme();
                  theme.loadConfig(xchild);
                  _themes.push(theme);
               }
            }
         }else if(xnode.isName("DisplayCollection")){
            // 读取显示集合
            for(FXmlNode xchild : xnode){
               if(xchild.isName("Sprite")){
                  FRs3Sprite display = new FRs3Sprite();
                  display.loadConfig(xchild);
                  _displays.push(display);
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
   public void saveConfig(FXmlNode xconfig){
      // 存储属性
      xconfig.set("guid", _guid);
      xconfig.set("code", _code);
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
      for(FRs3Display display : _displays){
         display.saveConfig(xdisplays.createNode("Display"));
      }
   }

   //============================================================
   // <T>从配置节点中导入数据信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void importConfig(FXmlNode xconfig){
      FXmlNode xtemplate = xconfig.findNode("Template");
      _code = xtemplate.get("code");
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
   }

   //============================================================
   // <T>获得字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      FXmlNode xconfig = new FXmlNode("Template");
      this.saveConfig(xconfig);
      return xconfig.xml().toString();
   }
}
