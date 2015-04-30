package org.mo.content.resource.common;

import org.mo.com.geom.SFloatQuaternion;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;

//============================================================
// <T>资源动画帧旋转。</T>
//============================================================
public class FResFrameRotation
      extends FObject
{
   // 索引
   private int _index;

   // 矩阵
   protected SFloatQuaternion _data = new SFloatQuaternion();

   //============================================================
   // <T>构造资源动画帧旋转。</T>
   //============================================================
   public FResFrameRotation(){
   }

   //============================================================
   // <T>获得索引。</T>
   //
   // @return 索引
   //============================================================
   public int index(){
      return _index;
   }

   //============================================================
   // <T>设置索引。</T>
   //
   // @param index 索引
   //============================================================
   public void setIndex(int index){
      _index = index;
   }

   //============================================================
   // <T>获得数据。</T>
   //
   // @return 数据
   //============================================================
   public SFloatQuaternion data(){
      return _data;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeFloat(_data.x);
      output.writeFloat(_data.y);
      output.writeFloat(_data.z);
      output.writeFloat(_data.w);
   }
}
