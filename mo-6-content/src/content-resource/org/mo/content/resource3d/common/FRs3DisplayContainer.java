package org.mo.content.resource3d.common;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源显示集合。</T>
//============================================================
public class FRs3DisplayContainer
      extends FRs3Display
{
   // 显示集合
   protected FObjects<FRs3Display> _displays = new FObjects<FRs3Display>(FRs3Display.class);

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
   public FRs3Display createChild(FXmlNode xconfig){
      String name = xconfig.name();
      switch(name){
         case "Sprite":
            return new FRs3Sprite();
      }
      throw new FFatalError("Invalid type.");
   }

   //============================================================
   // <T>获得显示集合。</T>
   //
   // @return 显示集合
   //============================================================
   public FObjects<FRs3Display> displays(){
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
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("DisplayCollection")){
            for(FXmlNode xchild : xnode){
               FRs3Display display = createChild(xchild);
               display.loadConfig(xchild);
               _displays.push(display);
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
         for(FRs3Display display : _displays){
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
               FRs3Display display = createChild(xchild);
               display.importConfig(xchild);
               _displays.push(display);
            }
         }
      }
   }
}
