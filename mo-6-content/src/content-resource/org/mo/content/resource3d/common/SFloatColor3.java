package org.mo.content.resource3d.common;

import org.mo.com.io.IDataOutput;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>三维浮点颜色。</T>
//============================================================
public class SFloatColor3
{
   // 红色
   public float red;

   // 绿色
   public float green;

   // 蓝色
   public float blue;

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeFloat(red);
      output.writeFloat(green);
      output.writeFloat(blue);
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      red = xconfig.getFloat("red");
      green = xconfig.getFloat("green");
      blue = xconfig.getFloat("blue");
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.set("red", red);
      xconfig.set("green", green);
      xconfig.set("blue", blue);
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
   }
}
