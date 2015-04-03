package org.mo.content.geom.common;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDouble;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>三维双浮点坐标。</T>
//============================================================
public class SDoublePoint3
{
   // X坐标
   public double x;

   // Y坐标
   public double y;

   // Z坐标
   public double z;

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void parse(String value){
      if(!RString.isEmpty(value)){
         String[] items = RString.split(value, ',');
         if(items.length != 3){
            throw new FFatalError("Parse failure.");
         }
         x = RDouble.parse(items[0]);
         y = RDouble.parse(items[1]);
         z = RDouble.parse(items[2]);
      }
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serializeFloat3(IDataOutput output){
      output.writeFloat((float)x);
      output.writeFloat((float)y);
      output.writeFloat((float)z);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserializeFloat3(IDataInput input){
      x = input.readFloat();
      y = input.readFloat();
      z = input.readFloat();
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      x = xconfig.getFloat("x");
      y = xconfig.getFloat("y");
      z = xconfig.getFloat("z");
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.set("x", x);
      xconfig.set("y", y);
      xconfig.set("z", z);
   }

   //============================================================
   // <T>获得内容字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      return x + "," + y + "," + z;
   }
}
