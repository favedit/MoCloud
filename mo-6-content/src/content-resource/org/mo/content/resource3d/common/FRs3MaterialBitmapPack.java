package org.mo.content.resource3d.common;

import org.mo.com.geom.SIntSize2;
import org.mo.com.io.IDataOutput;
import org.mo.eng.image.FImage;

//============================================================
// <T>资源纹理位图。</T>
//============================================================
public class FRs3MaterialBitmapPack
      extends FRs3Object
      implements
         AutoCloseable
{
   // 透明
   protected boolean _optionAlpha;

   // 格式
   protected String _formatCode;

   // 数据
   protected int[] _data;

   // 位图
   protected FImage _image;

   // 位图
   protected SIntSize2 _size = new SIntSize2();

   // 资源位图
   protected FRs3MaterialBitmap _textureBitmap;

   //============================================================
   // <T>构造资源纹理位图。</T>
   //============================================================
   public FRs3MaterialBitmapPack(){
      makeGuid();
   }

   //============================================================
   // <T>获得透明配置。</T>
   //
   // @return 透明配置
   //============================================================
   public boolean optionAlpha(){
      return _optionAlpha;
   }

   //============================================================
   // <T>设置透明配置。</T>
   //
   // @param optionAlpha 透明配置
   //============================================================
   public void setOptionAlpha(boolean optionAlpha){
      _optionAlpha = optionAlpha;
   }

   //   //============================================================
   //   // <T>获得格式。</T>
   //   //
   //   // @return 格式
   //   //============================================================
   //   public String formatCode(){
   //      // 非压缩模式
   //      String format = "jpg";
   //      if(_optionAlpha){
   //         return "png";
   //      }
   //      // 转换数据
   //      if(_textureBitmap == null){
   //         return format;
   //      }else{
   //         String code = _textureBitmap.code();
   //         if(code.equals("environment")){
   //            // 分拆为6个面
   //            return "jpg";
   //         }
   //      }
   //      return format;
   //   }

   //============================================================
   // <T>获得纹理位图。</T>
   //
   // @return 纹理位图
   //============================================================
   public FRs3MaterialBitmap textureBitmap(){
      return _textureBitmap;
   }

   //============================================================
   // <T>获得纹理位图。</T>
   //
   // @param textureBitmap 纹理位图
   //============================================================
   public void setTextureBitmap(FRs3MaterialBitmap textureBitmap){
      _textureBitmap = textureBitmap;
   }

   //   //============================================================
   //   // <T>初始化位图。</T>
   //   //
   //   // @param width 宽度
   //   // @param height 高度
   //   //============================================================
   //   public void initializeImage(int width,
   //                               int height){
   //      if(_image == null){
   //         BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
   //         int size = width * height;
   //         _data = new int[size];
   //         _image = new FImage(image);
   //         _size.set(width, height);
   //      }else if((width != _image.width()) || (height != _image.height())){
   //         throw new FFatalError("Image size is invalid. (origin_size={1}x{2}, size={3}x{4})", _image.width(), _image.height(), width, height);
   //      }
   //   }
   //
   //   //============================================================
   //   // <T>合并RGB位图。</T>
   //   //
   //   // @param bitmap 位图
   //   //============================================================
   //   public void mergeRgb(FRs3MaterialBitmap bitmap){
   //      mergeRgb(bitmap, 0);
   //   }
   //
   //   //============================================================
   //   // <T>合并RGB位图。</T>
   //   //
   //   // @param bitmap 位图
   //   //============================================================
   //   public void mergeRgb(FRs3MaterialBitmap bitmap,
   //                        int alpha){
   //      bitmap.setMaterialBitmapPack(this);
   //      //      // 加载图片
   //      //      try(FImage image = new FImage(bitmap.data())){
   //      //         int width = image.width();
   //      //         int height = image.height();
   //      //         // 初始化位图
   //      //         initializeImage(width, height);
   //      //         // 合并数据
   //      //         int colorAlpha = (alpha & 0xFF) << 24;
   //      //         int size = width * height;
   //      //         int[] data = image.getData();
   //      //         for(int i = 0; i < size; i++){
   //      //            int source = data[i];
   //      //            _data[i] = colorAlpha | (source & 0xFFFFFF);
   //      //         }
   //      //      }catch(Exception e){
   //      //         throw new FFatalError("Merge alpha failure.");
   //      //      }
   //      //      // 设置数据
   //      //      _image.setData(_data);
   //   }
   //
   //   //============================================================
   //   // <T>合并RGB位图。</T>
   //   //
   //   // @param bitmap 位图
   //   //============================================================
   //   public void mergeRgb(byte[] data,
   //                        int alpha){
   //      // 加载图片
   //      try(FImage image = new FImage(data)){
   //         int width = image.width();
   //         int height = image.height();
   //         // 初始化位图
   //         initializeImage(width, height);
   //         // 合并数据
   //         int colorAlpha = (alpha & 0xFF) << 24;
   //         int size = width * height;
   //         int[] imageData = image.getData();
   //         for(int i = 0; i < size; i++){
   //            int source = imageData[i];
   //            _data[i] = colorAlpha | (source & 0xFFFFFF);
   //         }
   //      }catch(Exception e){
   //         throw new FFatalError("Merge alpha failure.");
   //      }
   //      // 设置数据
   //      _image.setData(_data);
   //   }
   //
   //   //============================================================
   //   // <T>合并Alpha位图。</T>
   //   //
   //   // @param bitmap 位图
   //   //============================================================
   //   public void mergeAlpha(FRs3MaterialBitmap bitmap){
   //      mergeAlpha(bitmap, 0);
   //   }
   //
   //   //============================================================
   //   // <T>合并Alpha位图。</T>
   //   //
   //   // @param bitmap 位图
   //   //============================================================
   //   public void mergeAlpha(FRs3MaterialBitmap bitmap,
   //                          int rgb){
   //      bitmap.setBitmapPack(this);
   //      //      // 加载图片
   //      //      try(FImage image = new FImage(bitmap.data())){
   //      //         int width = image.width();
   //      //         int height = image.height();
   //      //         // 初始化位图
   //      //         initializeImage(width, height);
   //      //         // 合并数据
   //      //         int size = width * height;
   //      //         int[] data = image.getData();
   //      //         for(int i = 0; i < size; i++){
   //      //            int source = data[i];
   //      //            _data[i] |= (source & 0xFF) << 24 | rgb;
   //      //         }
   //      //      }catch(Exception e){
   //      //         throw new FFatalError("Merge alpha failure.");
   //      //      }
   //      //      // 设置数据
   //      //      _image.setData(_data);
   //   }
   //
   //   //============================================================
   //   // <T>合并Alpha位图。</T>
   //   //
   //   // @param bitmap 位图
   //   //============================================================
   //   public void mergeAlpha(byte[] data,
   //                          int rgb){
   //      // 加载图片
   //      try(FImage image = new FImage(data)){
   //         int width = image.width();
   //         int height = image.height();
   //         // 初始化位图
   //         initializeImage(width, height);
   //         // 合并数据
   //         int size = width * height;
   //         int[] imageData = image.getData();
   //         for(int i = 0; i < size; i++){
   //            int source = imageData[i];
   //            _data[i] |= (source & 0xFF) << 24 | rgb;
   //         }
   //      }catch(Exception e){
   //         throw new FFatalError("Merge alpha failure.");
   //      }
   //      // 设置数据
   //      _image.setData(_data);
   //   }
   //
   //   //============================================================
   //   // <T>合并RGB位图。</T>
   //   //
   //   // @param bitmap 位图
   //   //============================================================
   //   public void mergeRgba(byte[] rgbData,
   //                         byte[] alphaData){
   //      // 加载图片
   //      try(FImage imageRgb = new FImage(rgbData); FImage imageAlpha = new FImage(alphaData)){
   //         int width = imageRgb.width();
   //         int height = imageRgb.height();
   //         // 初始化位图
   //         initializeImage(width, height);
   //         // 合并数据
   //         int size = width * height;
   //         int[] imageRgbData = imageRgb.getData();
   //         int[] imageAlphaData = imageAlpha.getData();
   //         for(int i = 0; i < size; i++){
   //            _data[i] = ((imageAlphaData[i] & 0xFF) << 24) | (imageRgbData[i] & 0xFFFFFF);
   //         }
   //      }catch(Exception e){
   //         throw new FFatalError("Merge alpha failure.");
   //      }
   //      // 设置数据
   //      _image.setData(_data);
   //   }
   //
   //   //============================================================
   //   // <T>合并RGB位图。</T>
   //   //
   //   // @param bitmap 位图
   //   //============================================================
   //   public void mergeRgba3(byte[] rData,
   //                          byte[] gData,
   //                          byte[] bData){
   //      FImage image = null;
   //      FImage imageR = null;
   //      int[] imageRData = null;
   //      if(rData != null){
   //         imageR = new FImage(rData);
   //         imageRData = imageR.getData();
   //         image = imageR;
   //      }
   //      FImage imageG = null;
   //      int[] imageGData = null;
   //      if(gData != null){
   //         imageG = new FImage(gData);
   //         imageGData = imageG.getData();
   //         image = imageG;
   //      }
   //      FImage imageB = null;
   //      int[] imageBData = null;
   //      if(bData != null){
   //         imageB = new FImage(bData);
   //         imageBData = imageB.getData();
   //         image = imageB;
   //      }
   //      // 加载图片
   //      int width = image.width();
   //      int height = image.height();
   //      // 初始化位图
   //      initializeImage(width, height);
   //      // 合并数据
   //      int size = width * height;
   //      for(int i = 0; i < size; i++){
   //         int r = (imageRData != null) ? imageRData[i] : 0;
   //         int g = (imageGData != null) ? imageGData[i] : 0;
   //         int b = (imageBData != null) ? imageBData[i] : 0;
   //         _data[i] = (0xFF << 24) | ((r & 0xFF) << 16) | ((g & 0xFF) << 8) | (b & 0xFF);
   //      }
   //      // 设置数据
   //      _image.setData(_data);
   //   }
   //
   //   //============================================================
   //   // <T>合并Alpha位图。</T>
   //   //
   //   // @param bitmap 位图
   //   //============================================================
   //   public void mergeR(FRs3MaterialBitmap bitmap){
   //      bitmap.setBitmapPack(this);
   //      //      // 加载图片
   //      //      try(FImage image = new FImage(bitmap.data())){
   //      //         int width = image.width();
   //      //         int height = image.height();
   //      //         // 初始化位图
   //      //         initializeImage(width, height);
   //      //         // 合并数据
   //      //         int size = width * height;
   //      //         int[] data = image.getData();
   //      //         for(int i = 0; i < size; i++){
   //      //            int source = data[i];
   //      //            _data[i] |= (source & 0xFF) << 16;
   //      //         }
   //      //      }catch(Exception e){
   //      //         throw new FFatalError("Merge red failure.");
   //      //      }
   //      //      // 设置数据
   //      //      _image.setData(_data);
   //   }
   //
   //   //============================================================
   //   // <T>合并Alpha位图。</T>
   //   //
   //   // @param bitmap 位图
   //   //============================================================
   //   public void mergeG(FRs3MaterialBitmap bitmap){
   //      bitmap.setBitmapPack(this);
   //      //      // 加载图片
   //      //      try(FImage image = new FImage(bitmap.data())){
   //      //         int width = image.width();
   //      //         int height = image.height();
   //      //         // 初始化位图
   //      //         initializeImage(width, height);
   //      //         // 合并数据
   //      //         int size = width * height;
   //      //         int[] data = image.getData();
   //      //         for(int i = 0; i < size; i++){
   //      //            int source = data[i];
   //      //            _data[i] |= (source & 0xFF) << 8;
   //      //         }
   //      //      }catch(Exception e){
   //      //         throw new FFatalError("Merge red failure.");
   //      //      }
   //      //      // 设置数据
   //      //      _image.setData(_data);
   //   }
   //
   //   //============================================================
   //   // <T>合并Alpha位图。</T>
   //   //
   //   // @param bitmap 位图
   //   //============================================================
   //   public void mergeB(FRs3MaterialBitmap bitmap){
   //      bitmap.setBitmapPack(this);
   //      //      // 加载图片
   //      //      try(FImage image = new FImage(bitmap.data())){
   //      //         int width = image.width();
   //      //         int height = image.height();
   //      //         // 初始化位图
   //      //         initializeImage(width, height);
   //      //         // 合并数据
   //      //         int size = width * height;
   //      //         int[] data = image.getData();
   //      //         for(int i = 0; i < size; i++){
   //      //            int source = data[i];
   //      //            _data[i] |= (source & 0xFF);
   //      //         }
   //      //      }catch(Exception e){
   //      //         throw new FFatalError("Merge red failure.");
   //      //      }
   //      //      // 设置数据
   //      //      _image.setData(_data);
   //   }
   //
   //   //============================================================
   //   // <T>序列化数据到输出流。</T>
   //   //
   //   // @param output 输出流
   //   //============================================================
   //   public void serializeEnvironment(IDataOutput output){
   //      byte[] data = _textureBitmap.data();
   //      // 获得部分数据
   //      try(FImage image = new FImage(data)){
   //         int height = image.height();
   //         synchronized(getClass()){
   //            for(int n = 0; n < 6; n++){
   //               int x = height * n;
   //               try(FImage dataImage = image.imageRectangle(x, 0, height, height)){
   //                  data = dataImage.toBytes("jpg");
   //                  output.writeInt32(data.length);
   //                  output.write(data, 0, data.length);
   //               }
   //            }
   //         }
   //      }catch(Exception e){
   //         throw new FFatalError("Serialize envrionment failure.");
   //      }
   //   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      // 非压缩模式
      String format = "jpg";
      if(_optionAlpha){
         format = "png";
      }
      // 转换数据
      if(_textureBitmap == null){
         // 写入数据
         output.writeString("flat");
         output.writeString(format);
         output.writeUint16(_size.width);
         output.writeUint16(_size.height);
         //output.writeInt32(0);
      }else{
         String code = _textureBitmap.code();
         if(code.equals("environment")){
            // 分拆为6个面
            output.writeString("cube");
            output.writeString(format);
            output.writeUint16(_size.width);
            output.writeUint16(_size.height);
            //serializeEnvironment(output);
         }else{
            // 写入数据
            output.writeString("flat");
            output.writeString(format);
            output.writeUint16(_size.width);
            output.writeUint16(_size.height);
            //output.writeInt32(0);
         }
      }
      //      // 非压缩模式
      //      String format = "jpg";
      //      if(_optionAlpha){
      //         format = "png";
      //      }
      //      // 转换数据
      //      if(_textureBitmap == null){
      //         //byte[] data = _image.toBytes("png");
      //         //int length = data.length;
      //         // 写入数据
      //         output.writeBoolean(false);
      //         output.writeString("flat");
      //         output.writeString(format);
      //         output.writeUint16(_size.width);
      //         output.writeUint16(_size.height);
      //         output.writeInt32(4 * _data.length);
      //         for(int value : _data){
      //            output.writeUint8((short)((value >> 16) & 0xFF));
      //            output.writeUint8((short)((value >> 8) & 0xFF));
      //            output.writeUint8((short)(value & 0xFF));
      //            output.writeUint8((short)((value >> 24) & 0xFF));
      //         }
      //         //output.writeInt32(length);
      //         //output.write(data, 0, length);
      //      }else{
      //         output.writeBoolean(true);
      //         String code = _textureBitmap.code();
      //         if(code.equals("environment")){
      //            // 分拆为6个面
      //            output.writeString("cube");
      //            output.writeString(format);
      //            output.writeUint16(_size.width);
      //            output.writeUint16(_size.height);
      //            serializeEnvironment(output);
      //         }else{
      //            byte[] data = _textureBitmap.data();
      //            int length = data.length;
      //            // 写入数据
      //            output.writeString("flat");
      //            output.writeString(format);
      //            output.writeUint16(_size.width);
      //            output.writeUint16(_size.height);
      //            output.writeInt32(length);
      //            output.write(data, 0, length);
      //         }
      //      }
   }

   //============================================================
   // <T>释放处理。</T>
   //============================================================
   public byte[] toArray(){
      return _image.toBytes("png");
   }

   //============================================================
   // <T>释放处理。</T>
   //============================================================
   @Override
   public void close() throws Exception{
      _data = null;
      if(_image != null){
         _image.close();
      }
      _image = null;
   }
}
