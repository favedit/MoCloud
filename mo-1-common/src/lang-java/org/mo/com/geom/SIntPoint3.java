package org.mo.com.geom;

import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;

public class SIntPoint3
{
   // X坐标
   public int x;

   // Y坐标
   public int y;

   // Z坐标
   public int z;

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void parse(String value){
      String[] items = RString.split(value, ',');
      if(items.length != 3){
         throw new FFatalError("Parse failure.");
      }
      x = RInteger.parse(items[0]);
      y = RInteger.parse(items[1]);
      z = RInteger.parse(items[2]);
   }
}
