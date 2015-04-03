package org.mo.com.geom;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>二维浮点坐标。</T>
//============================================================
public class SFloatPoint2
{
   // X坐标
   public float x;

   // Y坐标
   public float y;

   //============================================================
   // <T>构造二维浮点坐标。</T>
   //============================================================
   public SFloatPoint2(){
   }

   //============================================================
   // <T>构造二维浮点坐标。</T>
   //
   // @param x X坐标
   // @param y Y坐标
   //============================================================
   public SFloatPoint2(float x,
                       float y){
      this.x = x;
      this.y = y;
   }

   //============================================================
   // <T>接收数据。</T>
   //
   // @param value 数据
   //============================================================
   public void assign(SFloatPoint2 value){
      this.x = value.x;
      this.y = value.y;
   }

   //============================================================
   // <T>设置数据。</T>
   //
   // @param x X坐标
   // @param y Y坐标
   //============================================================
   public void set(float x,
                   float y){
      this.x = x;
      this.y = y;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeFloat(x);
      output.writeFloat(y);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
      x = input.readFloat();
      y = input.readFloat();
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      x = xconfig.getFloat("x");
      y = xconfig.getFloat("y");
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.set("x", x);
      xconfig.set("y", y);
   }

   //============================================================
   // <T>解析字符串。</T>
   //
   // @param value 字符串
   //============================================================
   public void parse(String value){
      if(!RString.isEmpty(value)){
         String[] items = RString.split(value, ',');
         if(items.length != 2){
            throw new FFatalError("Parse failure.");
         }
         x = RFloat.parse(items[0]);
         y = RFloat.parse(items[1]);
      }
   }

   //============================================================
   // <T>获得内容字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      return x + "," + y;
   }
}
