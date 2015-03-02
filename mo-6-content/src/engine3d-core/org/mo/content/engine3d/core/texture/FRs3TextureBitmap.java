package org.mo.content.engine3d.core.texture;

import com.cyou.gccloud.data.data.FDataResource3dTextureBitmapUnit;
import org.mo.com.io.IDataOutput;
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

   //============================================================
   // <T>从数据单元中导入配置。</T>
   //
   // @param unit 数据单元
   //============================================================
   public void loadUnit(FDataResource3dTextureBitmapUnit unit){
      _ouid = unit.ouid();
      _guid = unit.guid();
      _code = unit.code();
      _label = unit.label();
   }

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
}
