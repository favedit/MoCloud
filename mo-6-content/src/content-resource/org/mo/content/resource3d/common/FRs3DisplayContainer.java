package org.mo.content.resource3d.common;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.lang.RUuid;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.scene.FRs3SceneDisplay;

//============================================================
// <T>资源显示集合。</T>
//============================================================
public class FRs3DisplayContainer
      extends FRs3Display
{
   // 显示集合
   protected FObjects<FRs3Display> _displays;

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
   @Override
   public FRs3Object createChild(FXmlNode xconfig){
      String typeName = xconfig.name();
      switch(typeName){
         case "Shape":
            return new FRs3Shape();
         case "Sprite":
            return new FRs3Sprite();
         case "SceneDisplay":
            return new FRs3SceneDisplay();
      }
      return super.createChild(xconfig);
   }

   //============================================================
   // <T>判断是否含有显示对象。</T>
   //
   // @return 是否含有
   //============================================================
   public boolean hasDisplay(){
      return (_displays != null) ? !_displays.isEmpty() : false;
   }

   //============================================================
   // <T>根据唯一编号查找显示对象。</T>
   //
   // @param guid 唯一编号
   // @return 显示对象
   //============================================================
   public FRs3Display findDisplayByGuid(String guid){
      if(!RString.isEmpty(guid) && (_displays != null)){
         for(FRs3Display display : _displays){
            if(guid.equals(display.guid())){
               return display;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>根据唯一编号搜索显示对象。</T>
   //
   // @param guid 唯一编号
   // @return 显示对象
   //============================================================
   public FRs3Display searchDisplayByGuid(String guid){
      if(!RString.isEmpty(guid) && (_displays != null)){
         for(FRs3Display display : _displays){
            if(guid.equals(display.guid())){
               return display;
            }
            if(display instanceof FRs3DisplayContainer){
               FRs3DisplayContainer container = (FRs3DisplayContainer)display;
               FRs3Display find = container.searchDisplayByGuid(guid);
               if(find != null){
                  return find;
               }
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>获得场景显示集合。</T>
   //
   // @return 场景显示集合
   //============================================================
   public void filterDisplays(FObjects<FRs3Display> displays){
      if(_displays != null){
         for(FRs3Display display : _displays){
            displays.push(display);
         }
      }
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
   // <T>增加一个显示对象。</T>
   //
   // @param renderable 显示对象
   //============================================================
   public void pushDisplay(FRs3Display display){
      if(_displays == null){
         _displays = new FObjects<FRs3Display>(FRs3Display.class);
      }
      display.setParent(this);
      _displays.push(display);
   }

   //============================================================
   // <T>删除一个显示对象。</T>
   //
   // @param renderable 显示对象
   //============================================================
   public void removeDisplay(FRs3Display display){
      display.setParent(null);
      if(_displays.contains(display)){
         _displays.remove(display);
      }else{
         throw new FFatalError("Remove display is not in container.");
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 存储技术过程集合
      if(_displays != null){
         int count = _displays.count();
         output.writeInt16((short)count);
         for(FRs3Display display : _displays){
            display.serialize(output);
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
      // 处理所有节点
      FXmlNode xdisplays = xconfig.findNode("DisplayCollection");
      if(xdisplays != null){
         for(FXmlNode xdisplay : xdisplays){
            FRs3Display display = (FRs3Display)createChild(xdisplay);
            display.loadConfig(xdisplay);
            pushDisplay(display);
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
      if(hasDisplay()){
         FXmlNode xdisplays = xconfig.createNode("DisplayCollection");
         for(FRs3Display display : _displays){
            display.saveConfig(xdisplays.createNode("Display"));
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
      // 处理所有节点
      FXmlNode xdisplays = xconfig.findNode("DisplayCollection");
      if(xdisplays != null){
         for(FXmlNode xdisplay : xdisplays){
            boolean isClone = xdisplay.getBoolean("is_clone", false);
            if(isClone){
               xdisplay.set("guid", RUuid.makeUniqueId());
            }
            String guid = xdisplay.get("guid");
            FRs3Display display = findDisplayByGuid(guid);
            if(display == null){
               display = (FRs3Display)createChild(xdisplay);
               pushDisplay(display);
            }
            display.mergeConfig(xdisplay);
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
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("DisplayCollection")){
            for(FXmlNode xchild : xnode){
               FRs3Display display = (FRs3Display)createChild(xchild);
               display.importConfig(xchild);
               _displays.push(display);
            }
         }
      }
   }
}
