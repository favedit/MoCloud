package org.mo.content.resource3d.common;

import com.cyou.gccloud.data.data.FDataResourceMaterialBitmapUnit;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.RUuid;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源模型。</T>
//============================================================
public class FRs3MaterialBitmap
      extends FRs3Object
{
   // 材质
   protected FRs3Material _material;

   // 位图打包
   protected FRs3MaterialBitmapPack _materialBitmapPack;

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
   public FRs3MaterialBitmap(){
      _typeName = "MaterialBitmap";
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
   // <T>获得位图打包。</T>
   //
   // @return 位图打包
   //============================================================
   public FRs3MaterialBitmapPack materialBitmapPack(){
      return _materialBitmapPack;
   }

   //============================================================
   // <T>设置位图打包。</T>
   //
   // @param bitmapPack 位图打包
   //============================================================
   public void setMaterialBitmapPack(FRs3MaterialBitmapPack materialBitmapPack){
      _materialBitmapPack = materialBitmapPack;
   }

   //============================================================
   // <T>获得全代码。</T>
   //
   // @return 全代码
   //============================================================
   @Override
   public String fullCode(){
      return _textureCode + "|" + _bitmapCode;
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
      if(_materialBitmapPack != null){
         output.writeString(_materialBitmapPack.guid());
      }else{
         output.writeString("");
      }
      output.writeString(_bitmapGuid);
      output.writeUint16(_index);
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      _bitmapGuid = xconfig.get("bitmap_guid");
      _index = xconfig.getInt("index");
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
      xconfig.set("bitmap_guid", _bitmapGuid);
      xconfig.set("index", _index);
   }

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FDataResourceMaterialBitmapUnit unit){
      // 加载属性
      _ouid = unit.ouid();
      _guid = unit.guid();
      _code = unit.code();
   }

   //============================================================
   // <T>将配置信息存入数据单元中。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void saveUnit(FDataResourceMaterialBitmapUnit unit){
      unit.setFullCode(_code);
      unit.setCode(_code);
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
