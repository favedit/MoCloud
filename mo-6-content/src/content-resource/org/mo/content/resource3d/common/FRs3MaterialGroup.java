package org.mo.content.resource3d.common;

import org.mo.com.io.IDataOutput;
import org.mo.com.lang.RUuid;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源模板。</T>
//============================================================
public class FRs3MaterialGroup
      extends FRs3Object
{
   // 主题
   protected FRs3Theme _theme;

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FRs3MaterialGroup(){
      _guid = RUuid.makeUniqueId();
   }

   //============================================================
   // <T>获得主题。</T>
   //
   // @return 主题
   //============================================================
   public FRs3Theme theme(){
      return _theme;
   }

   //============================================================
   // <T>设置主题。</T>
   //
   // @param theme 主题
   //============================================================
   public void setTheme(FRs3Theme theme){
      _theme = theme;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      // 读取属性
      _guid = xconfig.get("guid");
      _code = xconfig.get("code");
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
   }

   //   //============================================================
   //   // <T>从数据单元中导入配置。</T>
   //   //
   //   // @param unit 数据单元
   //   //============================================================
   //   public void loadUnit(FDataResource3dMaterialGroupUnit unit){
   //      // 加载属性
   //      _guid = unit.guid();
   //      _code = unit.code();
   //   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void importConfig(FXmlNode xconfig){
      // 读取属性
      _code = xconfig.get("code");
   }
}
