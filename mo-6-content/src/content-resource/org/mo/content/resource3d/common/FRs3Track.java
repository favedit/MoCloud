package org.mo.content.resource3d.common;

import org.mo.com.io.FByteStream;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;

//============================================================
// <T>资源精灵。</T>
//============================================================
public class FRs3Track
      extends FRs3Obejct
{
   protected int _boneId;

   protected int _frameTick;

   protected SFloatMatrix3d _matrix = new SFloatMatrix3d();

   protected FObjects<FRs3Frame> _frames = new FObjects<FRs3Frame>(FRs3Frame.class);

   //============================================================
   // <T>构造资源精灵。</T>
   //============================================================
   public FRs3Track(){
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      // 读取属性
      output.writeUint8((byte)_boneId);
      output.writeInt32(_frameTick);
      _matrix.serialize(output);
      // 读取所有帧信息
      int frameCount = _frames.count();
      output.writeInt16((short)frameCount);
      for(int n = 0; n < frameCount; n++){
         FRs3Frame frame = _frames.get(n);
         frame.serialize(output);
      }
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
      // 读取属性
      _boneId = input.readInt32();
      _frameTick = input.readInt32();
      _matrix.unserialize(input);
      // 读取所有帧信息
      int frameCount = input.readInt32();
      for(int n = 0; n < frameCount; n++){
         FRs3Frame frame = new FRs3Frame();
         frame.unserialize(input);
         _frames.push(frame);
      }
   }

   //============================================================
   // <T>获得数据。</T>
   //
   // @return 数据
   //============================================================
   public byte[] toArray(){
      FByteStream stream = new FByteStream();
      serialize(stream);
      return stream.toArray();
   }
}
