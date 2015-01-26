package org.mo.eng.image;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
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
{
   // 日志输出接口
   private final static ILogger _logger = RLogger.find(FImage.class);

   // 位图
   BufferedImage _image;

   //============================================================
   // <T>构造图形对象。</T>
   //============================================================
   public FImage(){
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
   // <T>加载文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void loadFile(String fileName){
      try{
         _logger.debug(this, "loadFile", "Load image file. (file_name={1})", fileName);
         _image = ImageIO.read(new File(fileName));
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
      // 创建目标
      int imageType = alpha ? BufferedImage.TYPE_INT_ARGB : BufferedImage.TYPE_INT_RGB;
      BufferedImage image = new BufferedImage(width, height, imageType);
      Graphics2D graphics = null;
      try{
         graphics = image.createGraphics();
         if(alpha){
            graphics.setComposite(AlphaComposite.Src);
         }
         Image scaledImage = _image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
         graphics.drawImage(scaledImage, 0, 0, width, height, null);
      }finally{
         if(graphics != null){
            graphics.dispose();
         }
      }
      _logger.debug(this, "resize", "Resize image. (source_size={1}x{2}, target_size={3}x{4})", _image.getWidth(), _image.getHeight(), image.getWidth(), image.getHeight());
      _image = image;
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
      // 改变尺寸
      resize(scaleWidth, scaleHeight, alpha);
   }
}