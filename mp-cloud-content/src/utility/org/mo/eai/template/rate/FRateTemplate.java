package org.mo.eai.template.rate;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FInts;
import org.mo.com.lang.RHex;

//============================================================
// <T>城市模板。</T>
//============================================================
public class FRateTemplate
{
   // 文件名称
   protected String _fileName = "D:/Microbject/MoScript/data/rate.png";

   protected FInts _data = new FInts();

   //============================================================
   // <T>解析处理。</T>
   //============================================================
   public void parser(){
      try{
         // 打开文件
         BufferedImage image = ImageIO.read(new File(_fileName));
         int width = image.getWidth();
         int height = image.getHeight();
         int y = height / 2;
         for(int x = 0; x < width; x++){
            int rgb = image.getRGB(x, y);
            _data.append(rgb);
            rgb = rgb & 0xFFFFFF;
            System.out.println(RHex.toString(rgb, 8));
         }
         System.out.println("Image - " + width + "x" + height);
      }catch(IOException e){
         throw new FFatalError(e);
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      int count = _data.length();
      output.writeInt32(count);
      for(int n = 0; n < count; n++){
         output.writeUint32(_data.get(n));
      }
   }

   //============================================================
   // <T>解析处理。</T>
   //============================================================
   public static void main(String args[]){
      FRateTemplate template = new FRateTemplate();
      template.parser();
   }
}
