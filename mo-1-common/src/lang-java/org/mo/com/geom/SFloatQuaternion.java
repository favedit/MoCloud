package org.mo.com.geom;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDouble;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>浮点四元数。</T>
//============================================================
public class SFloatQuaternion
{
   // X分量
   public float x;

   // Y分量
   public float y;

   // Z分量
   public float z;

   // W分量
   public float w;

   //============================================================
   // <T>构造浮点四元数。</T>
   //============================================================
   public SFloatQuaternion(){
   }

   //============================================================
   // <T>构造浮点四元数。</T>
   //
   // @param x X分量
   // @param y Y分量
   // @param z Z分量
   // @param w W分量
   //============================================================
   public SFloatQuaternion(float x,
                           float y,
                           float z,
                           float w){
      this.x = x;
      this.y = y;
      this.z = z;
      this.w = w;
   }

   //============================================================
   // <T>接收数据。</T>
   //
   // @param value 数据
   //============================================================
   public void assign(SFloatQuaternion value){
      x = value.x;
      y = value.y;
      z = value.z;
      w = value.w;
   }

   //============================================================
   // <T>设置数据。</T>
   //
   // @param x X坐标
   // @param y Y坐标
   // @param z Z坐标
   //============================================================
   public void set(float x,
                   float y,
                   float z,
                   float w){
      this.x = x;
      this.y = y;
      this.z = z;
      this.w = w;
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
      output.writeFloat(w);
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
      w = input.readFloat();
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
      w = xconfig.getFloat("w");
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
      xconfig.set("w", w);
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
      w = xconfig.getFloat("w");
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void parse(String value){
      if(!RString.isEmpty(value)){
         String[] items = RString.split(value, ',');
         if(items.length != 4){
            throw new FFatalError("Parse failure.");
         }
         x = (float)RDouble.parse(items[0]);
         y = (float)RDouble.parse(items[1]);
         z = (float)RDouble.parse(items[2]);
         w = (float)RDouble.parse(items[3]);
      }
   }

   //============================================================
   // <T>获得内容字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      return x + "," + y + "," + z + "," + w;
   }
}
