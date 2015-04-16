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
   // <T>判断是否含有显示对象。</T>
   //
   // @return 是否含有显示对象
   //============================================================
   public boolean hasDisplay(){
      return (_displays != null) ? !_displays.isEmpty() : false;
   }

   //============================================================
   // <T>获得显示集合。</T>
   //
   // @return 显示集合
   //============================================================
   @Override
   public FRs3Object createChild(FXmlNode xconfig){
      String typeName = xconfig.name();
      switch(typeName){
         case "Shape":
            return new FRs3Shape();
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
      FXmlNode xdisplays = xconfig.findNode("DisplayCollection");
      if(xdisplays != null){
         for(FXmlNode xdisplay : xdisplays){
            if(xdisplay.isName("Display")){
               FRs3Display display = (FRs3Display)createChild(xdisplay);
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
   public void importConfig(FXmlNode xconfig){
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("DisplayCollection")){
            for(FXmlNode xchild : xnode){
               FRs3Display display = (FRs3Display)createChild(xchild);
               //display.importConfig(xchild);
               _displays.push(display);
            }
         }
      }
   }
}
