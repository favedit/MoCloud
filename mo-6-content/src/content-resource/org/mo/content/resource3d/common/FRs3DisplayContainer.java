package org.mo.content.resource3d.common;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源显示集合。</T>
//============================================================
public class FRs3DisplayContainer
      extends FRs3Spatial
{
   // 显示集合
   protected FObjects<FRs3Spatial> _displays = new FObjects<FRs3Spatial>(FRs3Spatial.class);

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FRs3DisplayContainer(){
   }

   //============================================================
   // <T>获得显示集合。</T>
   //
   // @return 显示集合
   //============================================================
   public FRs3Spatial createChild(FXmlNode xconfig){
      String name = xconfig.name();
      switch(name){
         case "Sprite":
            return new FRs3Sprite();
         case "Display":
            return new FRs3Sprite();
      }
      throw new FFatalError("Invalid type.");
   }

   //============================================================
   // <T>获得显示集合。</T>
   //
   // @return 显示集合
   //============================================================
   public FObjects<FRs3Spatial> displays(){
      return _displays;
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      // 处理所有节点
      FXmlNode xdisplays = xconfig.findNode("DisplayCollection");
      if(xdisplays != null){
         for(FXmlNode xdisplay : xdisplays){
            if(xdisplay.isName("Display")){
               FRs3Spatial display = createChild(xdisplay);
               display.loadConfig(xdisplay);
               _displays.push(display);
            }else{
               throw new FFatalError("Unknown child node. (name={1})", xdisplay.name());
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
      // 存储显示集合
      if(!_displays.isEmpty()){
         FXmlNode xdisplays = xconfig.createNode("DisplayCollection");
         for(FRs3Spatial display : _displays){
            display.saveConfig(xdisplays.createNode("Display"));
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
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("DisplayCollection")){
            for(FXmlNode xchild : xnode){
               FRs3Spatial display = createChild(xchild);
               display.importConfig(xchild);
               _displays.push(display);
            }
         }
      }
   }
}
