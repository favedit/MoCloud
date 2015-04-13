package org.mo.com.geom;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.RInteger;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>二维整数大小。</T>
//============================================================
public class SIntSize2
{
   // 宽度
   public int width;

   // 高度
   public int height;

   //============================================================
   // <T>构造二维整数坐标。</T>
   //============================================================
   public SIntSize2(){
   }

   //============================================================
   // <T>构造二维整数坐标。</T>
   //
   // @param widthValue 横坐标
   // @param heightValue 纵坐标
   //============================================================
   public SIntSize2(int widthValue,
                    int heightValue){
      width = widthValue;
      height = heightValue;
   }

   //============================================================
   // <T>判断是否为空。</T>
   //
   // @return 是否为空
   //============================================================
   public boolean isEmpty(){
      return (0 == width) && (0 == height);
   }

   //============================================================
   // <T>是否相等。</T>
   //
   // @param value 尺寸对象
   // @return 是否相等
   //============================================================
   public boolean equals(SIntSize2 value){
      return ((width == value.width) && (height == value.height));
   }

   //============================================================
   // <T>是否相等。</T>
   //
   // @param widthValue 宽度
   // @param heightValue 高度
   // @return 是否相等
   //============================================================
   public boolean equalsValue(int widthValue,
                              int heightValue){
      return ((width == widthValue) && (height == heightValue));
   }

   //============================================================
   // <T>计算面积。</T>
   //
   // @return 面积
   //============================================================
   public int square(){
      return width * height;
   }

   //============================================================
   // <T>设置整数尺寸宽高。</T>
   //
   // @param widthValue 宽度
   // @param heightValue 高度
   //============================================================
   public void set(int widthValue,
                   int heightValue){
      width = widthValue;
      height = heightValue;
   }

   //============================================================
   // <T>接收对象数据。</T>
   //
   // @param value 对象数据
   //============================================================
   public void assign(SIntSize2 value){
      width = value.width;
      height = value.height;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeInt32(width);
      output.writeInt32(height);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize16(IDataOutput output){
      output.writeUint16(width);
      output.writeUint16(height);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
      width = input.readInt32();
      height = input.readInt32();
   }

   //============================================================
   // <T>从配置信息中加载配置。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      width = xconfig.getInt("width");
      height = xconfig.getInt("height");
   }

   //============================================================
   // <T>存储数据信息到配置节点中。</T>
   //
   // @param xconfig 配置信息
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.set("width", width);
      xconfig.set("height", height);
   }

   //============================================================
   // <T>解析字符串。</T>
   //
   // @param value 字符串
   //============================================================
   public void parse(String value){
      if(null != value){
         if(value.length() > 0){
            int index = value.indexOf(",");
            if(-1 != index){
               width = RInteger.parse(value.substring(0, index));
               height = RInteger.parse(value.substring(index + 1));
            }else{
               width = height = RInteger.parse(value);
            }
         }
      }
   }

   //============================================================
   // <T>重置数据。</T>
   //============================================================
   public void reset(){
      width = 0;
      height = 0;
   }

   //============================================================
   // <T>获得内容字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      return width + "," + height;
   }
}
