package org.mo.content.resource.common;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;
import org.mo.content.geom.common.SFloatMatrixQuat;

//============================================================
// <T>资源动画帧。</T>
//============================================================
public class FResFrame
      extends FObject
{
   // 时刻
   protected int _tick;

   // 矩阵
   protected SFloatMatrixQuat _matrix = new SFloatMatrixQuat();

   // 帧平移
   protected FResFrameTranslate _frameTranslate;

   // 帧旋转
   protected FResFrameRotation _frameRotation;

   // 帧缩放
   protected FResFrameScale _frameScale;

   //============================================================
   // <T>构造资源精灵。</T>
   //============================================================
   public FResFrame(){
   }

   //============================================================
   // <T>获得矩阵。</T>
   //
   // @return 矩阵
   //============================================================
   public SFloatMatrixQuat matrix(){
      return _matrix;
   }

   //============================================================
   // <T>获得帧平移。</T>
   //
   // @return 帧平移
   //============================================================
   public FResFrameTranslate frameTranslate(){
      return _frameTranslate;
   }

   //============================================================
   // <T>设置帧平移。</T>
   //
   // @param frameTranslate 帧平移
   //============================================================
   public void setFrameTranslate(FResFrameTranslate frameTranslate){
      _frameTranslate = frameTranslate;
   }

   //============================================================
   // <T>获得帧旋转。</T>
   //
   // @return 帧旋转
   //============================================================
   public FResFrameRotation frameRotation(){
      return _frameRotation;
   }

   //============================================================
   // <T>设置帧旋转。</T>
   //
   // @param frameRotation 帧旋转
   //============================================================
   public void setFrameRotation(FResFrameRotation frameRotation){
      _frameRotation = frameRotation;
   }

   //============================================================
   // <T>获得帧缩放。</T>
   //
   // @return 帧缩放
   //============================================================
   public FResFrameScale frameScale(){
      return _frameScale;
   }

   //============================================================
   // <T>设置帧缩放。</T>
   //
   // @param frameScale 帧缩放
   //============================================================
   public void setFrameScale(FResFrameScale frameScale){
      _frameScale = frameScale;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeUint16(_tick);
      _matrix.serialize(output);
   }

   //============================================================
   // <T>加载数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void loadData(IDataInput input){
      _tick = input.readInt32();
      _matrix.unserialize(input);
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void saveData(IDataOutput output){
      output.writeInt32(_tick);
      _matrix.serialize(output);
   }

   //============================================================
   // <T>从输入流中导入数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      _tick = input.readInt32();
      _matrix.unserialize(input);
   }
}
