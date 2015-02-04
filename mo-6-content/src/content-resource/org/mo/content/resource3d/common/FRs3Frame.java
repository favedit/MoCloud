package org.mo.content.resource3d.common;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;

//============================================================
// <T>资源精灵。</T>
//============================================================
public class FRs3Frame
      extends FObject
{
   protected int _tick;

   protected SFloatMatrixQuat _matrix = new SFloatMatrixQuat();

   //============================================================
   // <T>构造资源精灵。</T>
   //============================================================
   public FRs3Frame(){
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
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
      _tick = input.readInt32();
      _matrix.unserialize(input);
   }
}
