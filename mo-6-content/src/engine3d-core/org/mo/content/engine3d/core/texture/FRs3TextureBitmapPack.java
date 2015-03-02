package org.mo.content.engine3d.core.texture;

import java.awt.image.BufferedImage;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.content.resource3d.common.FRs3Object;
import org.mo.eng.image.FImage;

//============================================================
// <T>资源纹理位图。</T>
//============================================================
public class FRs3TextureBitmapPack
      extends FRs3Object
      implements
         AutoCloseable
{
   // 数据
   protected int[] _data;

   // 位图
   protected FImage _image;

   // 资源位图
   protected FRs3TextureBitmap _textureBitmap;

   //============================================================
   // <T>构造资源纹理位图。</T>
   //============================================================
   public FRs3TextureBitmapPack(){
   }

   //============================================================
   // <T>获得纹理位图。</T>
   //
   // @return 纹理位图
   //============================================================
   public FRs3TextureBitmap textureBitmap(){
      return _textureBitmap;
   }

   //============================================================
   // <T>获得纹理位图。</T>
   //
   // @param textureBitmap 纹理位图
   //============================================================
   public void setTextureBitmap(FRs3TextureBitmap textureBitmap){
      _textureBitmap = textureBitmap;
   }

   //============================================================
   // <T>初始化位图。</T>
   //
   // @param width 宽度
   // @param height 高度
   //============================================================
   public void initializeImage(int width,
                               int height){
      if(_image == null){
         BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_4BYTE_ABGR);
         int size = width * height;
         _data = new int[size];
         _image = new FImage(image);
      }else if((width != _image.width()) || (height != _image.height())){
         throw new FFatalError("Image size is invalid. (origin_size={1}x{2}, size={3}x{4})", _image.width(), _image.height(), width, height);
      }
   }

   //============================================================
   // <T>合并RGB位图。</T>
   //
   // @param bitmap 位图
   //============================================================
   public void mergeRgb(FRs3TextureBitmap bitmap){
      mergeRgb(bitmap, 0);
   }

   //============================================================
   // <T>合并RGB位图。</T>
   //
   // @param bitmap 位图
   //============================================================
   public void mergeRgb(FRs3TextureBitmap bitmap,
                        int alpha){
      bitmap.setBitmapPack(this);
      // 加载图片
      try(FImage image = new FImage(bitmap.data())){
         int width = image.width();
         int height = image.height();
         // 初始化位图
         initializeImage(width, height);
         // 合并数据
         int colorAlpha = (alpha & 0xFF) << 24;
         int size = width * height;
         int[] data = image.getData();
         for(int i = 0; i < size; i++){
            int source = data[i];
            _data[i] = colorAlpha | (source & 0xFFFFFF);
         }
      }catch(Exception e){
         throw new FFatalError("Merge alpha failure.");
      }
      // 设置数据
      _image.setData(_data);
   }

   //============================================================
   // <T>合并Alpha位图。</T>
   //
   // @param bitmap 位图
   //============================================================
   public void mergeAlpha(FRs3TextureBitmap bitmap){
      mergeAlpha(bitmap, 0);
   }

   //============================================================
   // <T>合并Alpha位图。</T>
   //
   // @param bitmap 位图
   //============================================================
   public void mergeAlpha(FRs3TextureBitmap bitmap,
                          int rgb){
      bitmap.setBitmapPack(this);
      // 加载图片
      try(FImage image = new FImage(bitmap.data())){
         int width = image.width();
         int height = image.height();
         // 初始化位图
         initializeImage(width, height);
         // 合并数据
         int size = width * height;
         int[] data = image.getData();
         for(int i = 0; i < size; i++){
            int source = data[i];
            _data[i] |= (source & 0xFF) << 24 | rgb;
         }
      }catch(Exception e){
         throw new FFatalError("Merge alpha failure.");
      }
      // 设置数据
      _image.setData(_data);
   }

   //============================================================
   // <T>合并Alpha位图。</T>
   //
   // @param bitmap 位图
   //============================================================
   public void mergeR(FRs3TextureBitmap bitmap){
      bitmap.setBitmapPack(this);
      // 加载图片
      try(FImage image = new FImage(bitmap.data())){
         int width = image.width();
         int height = image.height();
         // 初始化位图
         initializeImage(width, height);
         // 合并数据
         int size = width * height;
         int[] data = image.getData();
         for(int i = 0; i < size; i++){
            int source = data[i];
            _data[i] |= (source & 0xFF) << 16;
         }
      }catch(Exception e){
         throw new FFatalError("Merge red failure.");
      }
      // 设置数据
      _image.setData(_data);
   }

   //============================================================
   // <T>合并Alpha位图。</T>
   //
   // @param bitmap 位图
   //============================================================
   public void mergeG(FRs3TextureBitmap bitmap){
      bitmap.setBitmapPack(this);
      // 加载图片
      try(FImage image = new FImage(bitmap.data())){
         int width = image.width();
         int height = image.height();
         // 初始化位图
         initializeImage(width, height);
         // 合并数据
         int size = width * height;
         int[] data = image.getData();
         for(int i = 0; i < size; i++){
            int source = data[i];
            _data[i] |= (source & 0xFF) << 8;
         }
      }catch(Exception e){
         throw new FFatalError("Merge red failure.");
      }
      // 设置数据
      _image.setData(_data);
   }

   //============================================================
   // <T>合并Alpha位图。</T>
   //
   // @param bitmap 位图
   //============================================================
   public void mergeB(FRs3TextureBitmap bitmap){
      bitmap.setBitmapPack(this);
      // 加载图片
      try(FImage image = new FImage(bitmap.data())){
         int width = image.width();
         int height = image.height();
         // 初始化位图
         initializeImage(width, height);
         // 合并数据
         int size = width * height;
         int[] data = image.getData();
         for(int i = 0; i < size; i++){
            int source = data[i];
            _data[i] |= (source & 0xFF);
         }
      }catch(Exception e){
         throw new FFatalError("Merge red failure.");
      }
      // 设置数据
      _image.setData(_data);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serializeEnvironment(IDataOutput output){
      byte[] data = _textureBitmap.data();
      // 获得部分数据
      try(FImage image = new FImage(data)){
         int height = image.height();
         synchronized(getClass()){
            for(int n = 0; n < 6; n++){
               int x = height * n;
               try(FImage dataImage = image.imageRectangle(x, 0, height, height)){
                  data = dataImage.toBytes("jpg");
                  output.writeInt32(data.length);
                  output.write(data, 0, data.length);
               }
            }
         }
      }catch(Exception e){
         throw new FFatalError("Serialize envrionment failure.");
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
      // 转换数据
      if(_textureBitmap == null){
         byte[] data = _image.toBytes("png");
         int length = data.length;
         // 写入数据
         output.writeString("flat");
         output.writeString("png");
         output.writeInt32(length);
         output.write(data, 0, length);
      }else{
         String code = _textureBitmap.code();
         if(code.equals("environment")){
            // 分拆为6个面
            output.writeString("cube");
            output.writeString("jpg");
            serializeEnvironment(output);
         }else{
            byte[] data = _textureBitmap.data();
            int length = data.length;
            // 写入数据
            output.writeString("flat");
            output.writeString("jpg");
            output.writeInt32(length);
            output.write(data, 0, length);
         }
      }
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
