package org.mo.content.resource3d.texture;

import org.mo.com.io.IDataOutput;
import org.mo.com.xml.FXmlNode;
import org.mo.content.resource3d.common.FRs3Object;

//============================================================
// <T>资源纹理图片。</T>
//============================================================
public class FRs3TextureBitmap
      extends FRs3Object
{
   // 位图打包
   protected FRs3TextureBitmapPack _bitmapPack;

   // 数据
   protected int _index;

   // 间隔
   protected int _tick;

   // 数据
   protected byte[] _data;

   //============================================================
   // <T>构造资源纹理位图。</T>
   //============================================================
   public FRs3TextureBitmap(){
   }

   //============================================================
   // <T>获得位图打包。</T>
   //
   // @return 位图打包
   //============================================================
   public FRs3TextureBitmapPack bitmapPack(){
      return _bitmapPack;
   }

   //============================================================
   // <T>设置位图打包。</T>
   //
   // @param bitmapPack 位图打包
   //============================================================
   public void setBitmapPack(FRs3TextureBitmapPack bitmapPack){
      _bitmapPack = bitmapPack;
   }

   //============================================================
   // <T>获得索引。</T>
   //
   // @return 索引
   //============================================================
   public int index(){
      return _index;
   }

   //============================================================
   // <T>设置索引。</T>
   //
   // @param index 索引
   //============================================================
   public void setIndex(int index){
      _index = index;
   }

   //============================================================
   // <T>获得数据。</T>
   //
   // @return 数据
   //============================================================
   public byte[] data(){
      return _data;
   }

   //============================================================
   // <T>设置数据。</T>
   //
   // @param data 数据
   //============================================================
   public void setData(byte[] data){
      _data = data;
   }

   //   //============================================================
   //   // <T>从数据单元中导入配置。</T>
   //   //
   //   // @param unit 数据单元
   //   //============================================================
   //   public void loadUnit(FDataResource3dTextureBitmapUnit unit){
   //      _ouid = unit.ouid();
   //      _guid = unit.guid();
   //      _code = unit.code();
   //      _label = unit.label();
   //   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      String bitmapPackCode = null;
      if(_bitmapPack != null){
         bitmapPackCode = _bitmapPack.code();
      }else{
         bitmapPackCode = _code;
      }
      output.writeString(bitmapPackCode);
   }

   //============================================================
   // <T>从配置节点中加载数据信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      _guid = xconfig.get("guid");
      _code = xconfig.get("code");
      _index = xconfig.getInt("index");
      _tick = xconfig.getInt("tick");
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      xconfig.set("guid", _guid);
      xconfig.set("code", _code);
      xconfig.set("index", _index);
      xconfig.set("tick", _tick);
   }

   //============================================================
   // <T>从配置节点中导入数据信息。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void importConfig(FXmlNode xconfig){
      _code = xconfig.get("type_name");
      _index = xconfig.getInt("index");
      _tick = xconfig.getInt("tick");
   }
}
