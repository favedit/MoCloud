package org.mo.content.resource3d.common;

import org.mo.com.xml.FXmlNode;

//============================================================
// <T>浮点三维矩阵。</T>
//============================================================
public class SFloatMatrix3d
{
   public float tx;

   public float ty;

   public float tz;

   public float rx;

   public float ry;

   public float rz;

   public float sx;

   public float sy;

   public float sz;

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
