package org.mo.content.resource3d.common;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>浮点三维矩阵。</T>
//============================================================
public class SFloatMatrix3d
{
   public float tx = 0.0f;

   public float ty = 0.0f;

   public float tz = 0.0f;

   public float rx = 0.0f;

   public float ry = 0.0f;

   public float rz = 0.0f;

   public float sx = 1.0f;

   public float sy = 1.0f;

   public float sz = 1.0f;

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeFloat(tx);
      output.writeFloat(ty);
      output.writeFloat(tz);
      output.writeFloat(rx);
      output.writeFloat(ry);
      output.writeFloat(rz);
      output.writeFloat(sx);
      output.writeFloat(sy);
      output.writeFloat(sz);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
      tx = input.readFloat();
      ty = input.readFloat();
      tz = input.readFloat();
      rx = input.readFloat();
      ry = input.readFloat();
      rz = input.readFloat();
      sx = input.readFloat();
      sy = input.readFloat();
      sz = input.readFloat();
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      tx = xconfig.getFloat("tx");
      ty = xconfig.getFloat("ty");
      tz = xconfig.getFloat("tz");
      rx = xconfig.getFloat("rx");
      ry = xconfig.getFloat("ry");
      rz = xconfig.getFloat("rz");
      sx = xconfig.getFloat("sx");
      sy = xconfig.getFloat("sy");
      sz = xconfig.getFloat("sz");
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.set("tx", tx);
      xconfig.set("ty", ty);
      xconfig.set("tz", tz);
      xconfig.set("rx", rx);
      xconfig.set("ry", ry);
      xconfig.set("rz", rz);
      xconfig.set("sx", sx);
      xconfig.set("sy", sy);
      xconfig.set("sz", sz);
   }
}
