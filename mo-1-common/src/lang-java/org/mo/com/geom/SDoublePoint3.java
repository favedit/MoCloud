package org.mo.com.geom;

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
   // <T>构造三维双浮点坐标。</T>
   //============================================================
   public SDoublePoint3(){
   }

   //============================================================
   // <T>构造三维双浮点坐标。</T>
   //
   // @param value 内容
   //============================================================
   public SDoublePoint3(SDoublePoint3 value){
      assign(value);
   }

   //============================================================
   // <T>构造三维双浮点坐标。</T>
   //
   // @param x X坐标
   // @param y Y坐标
   // @param z Z坐标
   //============================================================
   public SDoublePoint3(double x,
                        double y,
                        double z){
      this.x = x;
      this.y = y;
      this.z = z;
   }

   public boolean equals(SDoublePoint3 value){
      if(x != value.x){
         return false;
      }
      if(y != value.y){
         return false;
      }
      if(z != value.z){
         return false;
      }
      return true;
   }

   //============================================================
   // <T>接收数据。</T>
   //
   // @param value 数据
   //============================================================
   public void assign(SDoublePoint3 value){
      this.x = value.x;
      this.y = value.y;
      this.z = value.z;
   }

   //============================================================
   // <T>设置数据为最小值。</T>
   //============================================================
   public void min(){
      x = -Double.MAX_VALUE;
      y = -Double.MAX_VALUE;
      z = -Double.MAX_VALUE;
   }

   //============================================================
   // <T>设置数据为最小值。</T>
   //
   // @param value 数据
   //============================================================
   public void min(SDoublePoint3 value){
      x = Math.min(x, value.x);
      y = Math.min(y, value.y);
      z = Math.min(z, value.z);
   }

   //============================================================
   // <T>设置数据为最大值。</T>
   //============================================================
   public void max(){
      x = Double.MAX_VALUE;
      y = Double.MAX_VALUE;
      z = Double.MAX_VALUE;
   }

   //============================================================
   // <T>设置数据为最大值。</T>
   //
   // @param value 数据
   //============================================================
   public void max(SDoublePoint3 value){
      x = Math.max(x, value.x);
      y = Math.max(y, value.y);
      z = Math.max(z, value.z);
   }

   //============================================================
   // <T>设置数据。</T>
   //
   // @param x X坐标
   // @param y Y坐标
   // @param z Z坐标
   //============================================================
   public void set(double x,
                   double y,
                   double z){
      this.x = x;
      this.y = y;
      this.z = z;
   }

   //============================================================
   // <T>计算到另外一点的长度。</T>
   //
   // @param value 坐标点
   //============================================================
   public double length(SDoublePoint3 value){
      double cx = x - value.x;
      double cy = y - value.y;
      double cz = z - value.z;
      return Math.sqrt(cx * cx + cy * cy + cz * cz);
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
      x = RDouble.parse(items[0]);
      y = RDouble.parse(items[1]);
      z = RDouble.parse(items[2]);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serializeFloat2(IDataOutput output){
      output.writeFloat((float)x);
      output.writeFloat((float)y);
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
      return Double.toString(x) + "," + Double.toString(y) + "," + Double.toString(z);
   }
}
