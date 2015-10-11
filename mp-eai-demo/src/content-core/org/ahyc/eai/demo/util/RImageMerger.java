package org.ahyc.eai.demo.util;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class RImageMerger
{

   public static void main(String[] args){
      String path = "D:/Microbject/MoScript/source/ars/eai/world";
      String fileName = path + "/identify.jpg";
      String areaPath = path + "/area";
      try{
         int width = 2048;
         int height = 1024;
         BufferedImage bitmap = new BufferedImage(width, height, ColorSpace.TYPE_RGB);
         for(int i = 1; i <= 8; i++){
            String imageFileName = areaPath + "/" + i + ".png";
            BufferedImage image = ImageIO.read(new File(imageFileName));
            for(int y = 0; y < height; y++){
               for(int x = 0; x < width; x++){
                  int color = image.getRGB(x, y);
                  int alpha = (color >> 24) & 0xFF;
                  if(alpha > 1){
                     long indexColor = (255 << 24) + (i << 16) + (i << 8) + i;
                     bitmap.setRGB(x, y, (int)indexColor);
                  }
               }
            }
         }
         ImageIO.write(bitmap, "jpg", new File(fileName));
      }catch(IOException e){
         e.printStackTrace();
      }
      System.out.println("OK");
   }
}
