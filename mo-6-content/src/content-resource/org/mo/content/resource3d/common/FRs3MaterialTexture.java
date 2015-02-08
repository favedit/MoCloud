package org.mo.content.resource3d.common;

import com.cyou.gccloud.data.data.FDataResource3dMaterialTextureUnit;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.RUuid;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源模型。</T>
//============================================================
public class FRs3MaterialTexture
      extends FRs3Object
{
   // 材质
   protected FRs3Material _material;

   // 纹理代码
   protected String _textureCode;

   // 纹理唯一编号
   protected String _textureGuid;

   // 位图代码
   protected String _bitmapCode;

   // 位图唯一编号
   protected String _bitmapGuid;

   protected int _index;

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FRs3MaterialTexture(){
      _guid = RUuid.makeUniqueId();
   }

   //============================================================
   // <T>获得材质。</T>
   //
   // @return 材质
   //============================================================
   public FRs3Material material(){
      return _material;
   }

   //============================================================
   // <T>设置材质。</T>
   //
   // @param material 材质
   //============================================================
   public void setMaterial(FRs3Material material){
      _material = material;
   }

   //============================================================
   // <T>获得全代码。</T>
   //
   // @return 全代码
   //============================================================
   public String fullCode(){
      return _material.fullCode() + "|" + _textureCode;
   }

   //============================================================
   // <T>获得纹理代码。</T>
   //
   // @return 纹理代码
   //============================================================
   public String textureCode(){
      return _textureCode;
   }

   //============================================================
   // <T>获得纹理唯一编号。</T>
   //
   // @return 纹理唯一编号
   //============================================================
   public String textureGuid(){
      return _textureGuid;
   }

   //============================================================
   // <T>设置纹理唯一编号。</T>
   //
   // @param textureGuid 纹理唯一编号
   //============================================================
   public void setTextureGuid(String textureGuid){
      _textureGuid = textureGuid;
   }

   //============================================================
   // <T>获得位图代码。</T>
   //
   // @return 位图代码
   //============================================================
   public String bitmapCode(){
      return _bitmapCode;
   }

   //============================================================
   // <T>获得位图唯一编号。</T>
   //
   // @return 纹位图理唯一编号
   //============================================================
   public String bitmapGuid(){
      return _bitmapGuid;
   }

   //============================================================
   // <T>设置位图唯一编号。</T>
   //
   // @param bitmapGuid 位图唯一编号
   //============================================================
   public void setBitmapGuid(String bitmapGuid){
      _bitmapGuid = bitmapGuid;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      output.writeString(_bitmapGuid);
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      _guid = xconfig.get("guid");
      _code = xconfig.get("code");
      _textureGuid = xconfig.get("texture_guid");
      _bitmapGuid = xconfig.get("bitmap_guid");
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
      xconfig.set("texture_guid", _textureGuid);
      xconfig.set("bitmap_guid", _bitmapGuid);
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FDataResource3dMaterialTextureUnit unit){
      // 加载属性
      _guid = unit.guid();
      _code = unit.code();
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void importConfig(FXmlNode xconfig){
      _code = xconfig.get("type");
      _textureCode = xconfig.get("texture");
      _bitmapCode = xconfig.get("bitmap");
      _index = xconfig.getInt("index");
   }
}
