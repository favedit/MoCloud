package org.mo.engine3d.resource.model;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;

//============================================================
// <T>资源模型网格。</T>
//============================================================
public class FRs3ModelMesh
{
   // 数据流集合
   protected FObjects<FRs3ModelStream> _streams = new FObjects<FRs3ModelStream>(FRs3ModelStream.class);

   //============================================================
   // <T>构造资源模型网格。</T>
   //============================================================
   public FRs3ModelMesh(){
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
      // 读取数据流集合
      int meshCount = input.readInt16();
      for(int n = 0; n < meshCount; n++){
         FRs3ModelStream stream = new FRs3ModelStream();
         stream.unserialize(input);
         _streams.push(stream);
      }
   }
}
