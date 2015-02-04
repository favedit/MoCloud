package org.mo.content.resource3d.common;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>浮点三维矩阵。</T>
//============================================================
public class SFloatMatrixQuat
{
   public float tx;

   public float ty;

   public float tz;

   public float qx;

   public float qy;

   public float qz;

   public float qw;

   public float sx;

   public float sy;

   public float sz;

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeFloat(tx);
      output.writeFloat(ty);
      output.writeFloat(tz);
      output.writeFloat(qx);
      output.writeFloat(qy);
      output.writeFloat(qz);
      output.writeFloat(qw);
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
      qx = input.readFloat();
      qy = input.readFloat();
      qz = input.readFloat();
      qw = input.readFloat();
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
      qx = xconfig.getFloat("qx");
      qy = xconfig.getFloat("qy");
      qz = xconfig.getFloat("qz");
      qw = xconfig.getFloat("qw");
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
      xconfig.set("qx", qx);
      xconfig.set("qy", qy);
      xconfig.set("qz", qz);
      xconfig.set("qw", qw);
      xconfig.set("sx", sx);
      xconfig.set("sy", sy);
      xconfig.set("sz", sz);
   }
}
