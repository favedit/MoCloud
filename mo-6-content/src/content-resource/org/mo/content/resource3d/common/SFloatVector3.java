package org.mo.content.resource3d.common;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDouble;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>三维浮点坐标。</T>
//============================================================
public class SFloatVector3
{
   // X坐标
   public float x;

   // Y坐标
   public float y;

   // Z坐标
   public float z;

   //============================================================
   // <T>构造三维浮点坐标。</T>
   //============================================================
   public SFloatVector3(){
   }

   //============================================================
   // <T>构造三维浮点坐标。</T>
   //============================================================
   public SFloatVector3(float valueX,
                        float valueY,
                        float valueZ){
      x = valueX;
      y = valueY;
      z = valueZ;
   }

   //============================================================
   // <T>单位化处理。</T>
   //============================================================
   public void normallize(){
      float vlaue = (float)Math.sqrt(x * x + y * y + z * z);
      x /= vlaue;
      y /= vlaue;
      z /= vlaue;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeFloat(x);
      output.writeFloat(y);
      output.writeFloat(z);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
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
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void importConfig(FXmlNode xconfig){
      x = xconfig.getFloat("x");
      y = xconfig.getFloat("y");
      z = xconfig.getFloat("z");
   }

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
      x = (float)RDouble.parse(items[0]);
      y = (float)RDouble.parse(items[1]);
      z = (float)RDouble.parse(items[2]);
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
