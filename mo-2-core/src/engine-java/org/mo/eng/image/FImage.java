package org.mo.eng.image;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferInt;
import java.awt.image.DirectColorModel;
import java.awt.image.PixelGrabber;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.IIOImage;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import org.mo.com.io.RFile;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

//============================================================
// <T>图形对象。</T>
//============================================================
public class FImage
      extends FObject
      implements
         AutoCloseable
{
   // 日志输出接口
   private final static ILogger _logger = RLogger.find(FImage.class);

   // 颜色位
   private static final int[] RGB_MASKS = {0xFF0000, 0xFF00, 0xFF};

   // 颜色模式
   private static final ColorModel RGB_OPAQUE = new DirectColorModel(32, RGB_MASKS[0], RGB_MASKS[1], RGB_MASKS[2]);

   // 位图
   protected BufferedImage _image;

   //============================================================
   // <T>构造图形对象。</T>
   //============================================================
   public FImage(){
   }

   //============================================================
   // <T>构造图形对象。</T>
   //
   // @param image 位图
   //============================================================
   public FImage(BufferedImage image){
      _image = image;
   }

   //============================================================
   // <T>构造图形对象。</T>
   //
   // @param data 数据
   //============================================================
   public FImage(byte[] data){
      loadData(data);
   }

   //============================================================
   // <T>构造图形对象。</T>
   //
   // @param data 数据
   // @param offset 位置
   // @param length 长度
   //============================================================
   public FImage(byte[] data,
                 int offset,
                 int length){
      loadData(data, offset, length);
   }

   //============================================================
   // <T>构造图形对象。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public FImage(String fileName){
      loadFile(fileName);
   }

   //============================================================
   // <T>获得宽度。</T>
   //
   // @return 宽度
   //============================================================
   public int width(){
      return _image.getWidth();
   }

   //============================================================
   // <T>获得高度。</T>
   //
   // @return 高度
   //============================================================
   public int height(){
      return _image.getHeight();
   }

   //============================================================
   // <T>获得数据。</T>
   //
   // @param data 数据
   // @return 数据
   //============================================================
   public int[] getData(){
      int width = _image.getWidth();
      int height = _image.getHeight();
      return _image.getRGB(0, 0, width, height, null, 0, width);
   }

   //============================================================
   // <T>设置数据。</T>
   //
   // @param data 数据
   // @return 数据
   //============================================================
   public void setData(int[] data){
      int width = _image.getWidth();
      int height = _image.getHeight();
      _image.setRGB(0, 0, width, height, data, 0, width);
   }

   //============================================================
   // <T>加载数据。</T>
   //
   // @param data 数据
   //============================================================
   public FImage imageRectangle(int x,
                                int y,
                                int width,
                                int height){
      // 检查参数
      if((x < 0) || (y < 0) || (width <= 0) || (height <= 0)){
         throw new FFatalError("Rect size is invalid. (x={1}, y={2},width={3}, height={4})", x, y, width, height);
      }
      // 创建目标
      int imageType = _image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : _image.getType();
      BufferedImage image = new BufferedImage(width, height, imageType);
      Graphics2D graphics = null;
      try{
         graphics = image.createGraphics();
         graphics.setComposite(AlphaComposite.Src);
         graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
         graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         graphics.drawImage(_image, 0, 0, width, height, x, y, x + width, y + height, null);
      }finally{
         if(graphics != null){
            graphics.dispose();
         }
      }
      _logger.debug(this, "resize", "Rect image success. (x={1}, y={2},width={3}, height={4})", x, y, width, height);
      return new FImage(image);
   }

   //============================================================
   // <T>加载数据。</T>
   //
   // @param data 数据
   //============================================================
   public void loadData(byte[] data){
      loadData(data, 0, data.length);
   }

   //============================================================
   // <T>加载数据。</T>
   //
   // @param data 数据
   // @param offset 位置
   // @param length 长度
   //============================================================
   public void loadData(byte[] data,
                        int offset,
                        int length){
      try{
         _logger.debug(this, "loadFile", "Load image data. (data={1}, length={2})", data, data.length);
         //_image = ImageIO.read(new ByteArrayInputStream(data));
         Image image = Toolkit.getDefaultToolkit().createImage(data, offset, length);
         PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, -1, -1, true);
         pixelGrabber.grabPixels();
         int width = pixelGrabber.getWidth();
         int height = pixelGrabber.getHeight();
         DataBuffer buffer = new DataBufferInt((int[])pixelGrabber.getPixels(), width * height);
         WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
         _image = new BufferedImage(RGB_OPAQUE, raster, false, null);
      }catch(Exception e){
         _logger.error(this, "loadFile", e, "Load image data failure. (data={1}, length={2})", data, data.length);
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>加载文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void loadFile(String fileName){
      try{
         _logger.debug(this, "loadFile", "Load image file. (file_name={1})", fileName);
         //_image = ImageIO.read(new File(fileName));
         Image image = Toolkit.getDefaultToolkit().createImage(fileName);
         PixelGrabber pixelGrabber = new PixelGrabber(image, 0, 0, -1, -1, true);
         pixelGrabber.grabPixels();
         int width = pixelGrabber.getWidth();
         int height = pixelGrabber.getHeight();
         DataBuffer buffer = new DataBufferInt((int[])pixelGrabber.getPixels(), width * height);
         WritableRaster raster = Raster.createPackedRaster(buffer, width, height, width, RGB_MASKS, null);
         _image = new BufferedImage(RGB_OPAQUE, raster, false, null);
      }catch(Exception e){
         _logger.error(this, "loadFile", e, "Load image file failure. (file_name={1})", fileName);
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>存储文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void saveFile(String fileName){
      String extension = RFile.extension(fileName);
      try{
         _logger.debug(this, "saveFile", "Save image file. (file_name={1})", fileName);
         ImageIO.write(_image, extension, new File(fileName));
      }catch(Exception e){
         _logger.error(this, "saveFile", e, "Save image file failure. (file_name={1})", fileName);
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>存储数据。</T>
   //
   // @param extension 格式
   // @return 数据
   //============================================================
   public byte[] toBytes(String extension){
      try{
         ByteArrayOutputStream output = new ByteArrayOutputStream();
         ImageIO.write(_image, extension, output);
         return output.toByteArray();
      }catch(Exception e){
         _logger.error(this, "saveFile", e, "Save image data failure. (extension={1})", extension);
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>存储JPEG品质数据。</T>
   //
   // @param quality 品质(0.0f ~ 1.0f)
   // @return 数据
   //============================================================
   public byte[] toJpegBytes(float quality){
      byte[] data = null;
      ImageWriter writer = null;
      ByteOutputStream outputStream = null;
      ImageOutputStream imageOutputStream = null;
      try{
         // 获得参数
         writer = ImageIO.getImageWritersByFormatName("jpeg").next();
         ImageWriteParam param = writer.getDefaultWriteParam();
         param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
         param.setCompressionQuality(quality);
         // 压缩数据
         outputStream = new ByteOutputStream();
         imageOutputStream = ImageIO.createImageOutputStream(outputStream);
         writer.setOutput(imageOutputStream);
         writer.write(null, new IIOImage(_image, null, null), param);
         data = outputStream.getBytes();
      }catch(Exception e){
         throw new FFatalError(e);
      }finally{
         if(imageOutputStream != null){
            try{
               imageOutputStream.close();
            }catch(IOException e){
               throw new FFatalError(e);
            }
         }
         if(outputStream != null){
            outputStream.close();
         }
         if(writer != null){
            writer.dispose();
         }
      }
      return data;
   }

   //============================================================
   // <T>圆角处理。</T>
   //
   // @param radius 圆角像素
   //============================================================
   public void round(int radius){
      int width = _image.getWidth();
      int height = _image.getHeight();
      BufferedImage outputImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
      Graphics2D graphics = null;
      try{
         graphics = outputImage.createGraphics();
         graphics.setComposite(AlphaComposite.Src);
         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         graphics.setColor(Color.WHITE);
         graphics.fill(new RoundRectangle2D.Float(0, 0, width, height, radius, radius));
         graphics.setComposite(AlphaComposite.SrcAtop);
         graphics.drawImage(_image, 0, 0, null);
      }finally{
         if(graphics != null){
            graphics.dispose();
         }
      }
      _image = outputImage;
   }

   //============================================================
   // <T>强制改变大小。</T>
   //
   // @param width 宽度
   // @param height 高度
   // @param alpha 透明
   //============================================================
   public void resize(int width,
                      int height,
                      boolean alpha){
      // 检查参数
      if((width <= 0) || (height <= 0)){
         throw new FFatalError("Scale size is invalid. (width={1}, height={2})", width, height);
      }
      // 绘制目标
      int type = _image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : _image.getType();
      BufferedImage image = new BufferedImage(width, height, type);
      Graphics2D graphics = null;
      try{
         graphics = image.createGraphics();
         graphics.setComposite(AlphaComposite.Src);
         graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
         graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         graphics.drawImage(_image, 0, 0, width, height, null);
      }finally{
         if(graphics != null){
            graphics.dispose();
         }
      }
      _image = image;
      _logger.debug(this, "resize", "Resize image. (source_size={1}x{2}, target_size={3}x{4})", _image.getWidth(), _image.getHeight(), image.getWidth(), image.getHeight());
   }

   //============================================================
   // <T>等比率改变大小。</T>
   //
   // @param width 宽度
   // @param height 高度
   // @param alpha 透明
   //============================================================
   public void resizeScale(int width,
                           int height,
                           boolean alpha){
      // 检查参数
      if((width <= 0) || (height <= 0)){
         throw new FFatalError("Scale size is invalid. (width={1}, height={2})", width, height);
      }
      // 计算比率
      int imageWidth = _image.getWidth();
      int imageHeight = _image.getHeight();
      float widthRate = (float)width / (float)imageWidth;
      float heightRate = (float)height / (float)imageHeight;
      float rate = (widthRate < heightRate) ? widthRate : heightRate;
      // 计算大小
      int scaleWidth = (int)(imageWidth * rate);
      int scaleHeight = (int)(imageHeight * rate);
      int left = (width - scaleWidth) >> 1;
      int top = (height - scaleHeight) >> 1;
      // 绘制目标
      int type = _image.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : _image.getType();
      BufferedImage image = new BufferedImage(width, height, type);
      Graphics2D graphics = null;
      try{
         graphics = image.createGraphics();
         graphics.setComposite(AlphaComposite.Src);
         graphics.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
         graphics.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
         graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
         graphics.drawImage(_image, left, top, scaleWidth, scaleHeight, null);
      }finally{
         if(graphics != null){
            graphics.dispose();
         }
      }
      _image = image;
      _logger.debug(this, "resize", "Resize image. (source_size={1}x{2}, target_size={3}x{4})", _image.getWidth(), _image.getHeight(), image.getWidth(), image.getHeight());
      //resize(scaleWidth, scaleHeight, alpha);
   }

   //============================================================
   // <T>释放处理。</T>
   //============================================================
   @Override
   public void close() throws Exception{
      _image = null;
   }
}
