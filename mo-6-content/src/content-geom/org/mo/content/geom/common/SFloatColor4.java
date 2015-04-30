package org.mo.content.geom.common;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDouble;
import org.mo.com.lang.RString;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>浮点颜色。</T>
//============================================================
public class SFloatColor4
{
   // 红色
   public float red;

   // 绿色
   public float green;

   // 蓝色
   public float blue;

   // 强度
   public float alpha;

   //============================================================
   // <T>构造浮点颜色。</T>
   //============================================================
   public SFloatColor4(){
   }

   //============================================================
   // <T>构造浮点颜色。</T>
   //
   // @param red 红色
   // @param green 绿色
   // @param blue 蓝色
   // @param alpha 透明色
   //============================================================
   public SFloatColor4(float redValue,
                       float greenValue,
                       float blueValue,
                       float alphaValue){
      red = redValue;
      green = greenValue;
      blue = blueValue;
      alpha = alphaValue;
   }

   //============================================================
   // <T>设置数据。</T>
   //
   // @param value 数据
   //============================================================
   public void assign(SFloatColor4 value){
      red = value.red;
      green = value.green;
      blue = value.blue;
      alpha = value.alpha;
   }

   //============================================================
   // <T>设置数据。</T>
   //
   // @param red 红色
   // @param green 绿色
   // @param blue 蓝色
   // @param alpha 透明色
   //============================================================
   public void set(float redValue,
                   float greenValue,
                   float blueValue,
                   float alphaValue){
      red = redValue;
      green = greenValue;
      blue = blueValue;
      alpha = alphaValue;
   }

   //============================================================
   // <T>设置数据。</T>
   //
   // @param red 红色
   // @param green 绿色
   // @param blue 蓝色
   // @param alpha 透明色
   //============================================================
   public void setInt(int redValue,
                      int greenValue,
                      int blueValue,
                      int alphaValue){
      red = redValue / 255.0f;
      green = greenValue / 255.0f;
      blue = blueValue / 255.0f;
      alpha = alphaValue / 255.0f;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeFloat(red);
      output.writeFloat(green);
      output.writeFloat(blue);
      output.writeFloat(alpha);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
      red = input.readFloat();
      green = input.readFloat();
      blue = input.readFloat();
      alpha = input.readFloat();
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      red = xconfig.getFloat("r", red);
      green = xconfig.getFloat("g", green);
      blue = xconfig.getFloat("b", blue);
      alpha = xconfig.getFloat("power", alpha);
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.set("r", red);
      xconfig.set("g", green);
      xconfig.set("b", blue);
      xconfig.set("power", alpha);
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void importConfig(FXmlNode xconfig){
      red = xconfig.getFloat("r");
      green = xconfig.getFloat("g");
      blue = xconfig.getFloat("b");
      alpha = xconfig.getFloat("power", 1.0f);
   }

   //============================================================
   // <T>从配置信息中导入配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void parse(String value){
      String[] items = RString.split(value, ',');
      if(items.length != 4){
         throw new FFatalError("Parse failure.");
      }
      red = (float)RDouble.parse(items[0]);
      green = (float)RDouble.parse(items[1]);
      blue = (float)RDouble.parse(items[2]);
      alpha = (float)RDouble.parse(items[3]);
   }

   //============================================================
   // <T>获得内容字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      return red + "," + green + "," + blue + "," + alpha;
   }
}
