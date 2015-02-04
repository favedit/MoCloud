package org.mo.content.resource3d.common;

import org.mo.com.io.IDataOutput;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>三维浮点颜色。</T>
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
   public float power;

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeFloat(red);
      output.writeFloat(green);
      output.writeFloat(blue);
      output.writeFloat(power);
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      red = xconfig.getFloat("r");
      green = xconfig.getFloat("g");
      blue = xconfig.getFloat("b");
      power = xconfig.getFloat("power");
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
      xconfig.set("power", power);
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
      power = xconfig.getFloat("power", 1.0f);
   }
}
