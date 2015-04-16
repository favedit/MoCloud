package org.mo.content.resource3d.common;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObjects;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>场景层。</T>
//============================================================
public class FRs3DisplayLayer
      extends FRs3Object
{
   // 变换类型
   protected String _transformCd;

   // 类型名称
   protected String _typeCd;

   // 场景技术过程集合
   protected FObjects<FRs3Sprite> _displays;

   //============================================================
   // <T>构造场景层。</T>
   //============================================================
   public FRs3DisplayLayer(){
   }

   //============================================================
   // <T>根据唯一编号查找显示对象。</T>
   //
   // @param guid 唯一编号
   // @return 显示对象
   //============================================================
   public FRs3Sprite findDisplayByGuid(String guid){
      if(!RString.isEmpty(guid) && (_displays != null)){
         for(FRs3Sprite display : _displays){
            if(guid.equals(display.guid())){
               return display;
            }
         }
      }
      return null;
   }

   //============================================================
   // <T>获得显示集合。</T>
   //
   // @return 显示集合
   //============================================================
   public FObjects<FRs3Sprite> displays(){
      return _displays;
   }

   //============================================================
   // <T>增加一个显示对象。</T>
   //
   // @param display 显示对象
   //============================================================
   public void pushDisplay(FRs3Sprite display){
      if(_displays == null){
         _displays = new FObjects<FRs3Sprite>(FRs3Sprite.class);
      }
      _displays.push(display);
   }

   //============================================================
   // <T>获得场景显示集合。</T>
   //
   // @return 场景显示集合
   //============================================================
   public void filterDisplays(FObjects<FRs3Sprite> displays){
      if(_displays != null){
         for(FRs3Sprite display : _displays){
            displays.push(display);
         }
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
      // 输出属性
      output.writeString(_typeCd);
      output.writeString(_transformCd);
      // 存储技术过程集合
      if(_displays != null){
         int count = _displays.count();
         output.writeInt16((short)count);
         for(FRs3Sprite display : _displays){
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
      // 读取属性
      _typeCd = xconfig.get("type_cd", _typeCd);
      _transformCd = xconfig.get("transform_cd", _transformCd);
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("DisplayCollection")){
            // 读取显示集合
            for(FXmlNode xdisplay : xnode){
               FRs3Sprite display = new FRs3Sprite();
               display.loadConfig(xdisplay);
               pushDisplay(display);
            }
         }else{
            throw new FFatalError("Invalid config node.");
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
      // 读取属性
      _typeCd = xconfig.get("type_cd", _typeCd);
      _transformCd = xconfig.get("transform_cd", _transformCd);
      // 处理所有节点
      for(FXmlNode xnode : xconfig){
         if(xnode.isName("DisplayCollection")){
            // 读取显示集合
            for(FXmlNode xdisplay : xnode){
               String displayGuid = xdisplay.get("guid");
               FRs3Sprite display = findDisplayByGuid(displayGuid);
               display.mergeConfig(xdisplay);
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
   @Override
   public void saveConfig(FXmlNode xconfig){
      super.saveConfig(xconfig);
      // 存储属性
      xconfig.set("type_cd", _typeCd);
      xconfig.set("transform_cd", _transformCd);
      // 存储层集合
      if(_displays != null){
         FXmlNode xdisplays = xconfig.createNode("DisplayCollection");
         for(FRs3Sprite display : _displays){
            display.saveConfig(xdisplays.createNode("Display"));
         }
      }
   }
}
