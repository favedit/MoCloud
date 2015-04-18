package org.mo.com.geom;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>三维浮点轮廓。</T>
//============================================================
public class SFloatOutline3
{
   // 最小顶点
   public SFloatPoint3 min = new SFloatPoint3();

   // 最大顶点
   public SFloatPoint3 max = new SFloatPoint3();

   //============================================================
   // <T>设置为最小值。</T>
   //============================================================
   public void setMin(){
      max.setMin();
      min.setMax();
   }

   //============================================================
   // <T>设置为最大值。</T>
   //============================================================
   public void setMax(){
      min.setMin();
      max.setMax();
   }

   //============================================================
   // <T>合并轮廓。</T>
   //
   // @param x X坐标
   // @param y Y坐标
   // @param z Z坐标
   //============================================================
   public void merge(float x,
                     float y,
                     float z){
      min.mergeMin(x, y, z);
      max.mergeMax(x, y, z);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      min.serialize(output);
      max.serialize(output);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
      min.unserialize(input);
      max.unserialize(input);
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void loadConfig(FXmlNode xconfig){
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void saveConfig(FXmlNode xconfig){
   }

   //============================================================
   // <T>获得内容字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      return min + "-" + max;
   }
}
