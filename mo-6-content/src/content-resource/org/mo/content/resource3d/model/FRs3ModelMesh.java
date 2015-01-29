package org.mo.content.resource3d.model;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;

//============================================================
// <T>资源模型网格。</T>
//============================================================
public class FRs3ModelMesh
{
   // 代码
   protected String _code;

   // 数据流集合
   protected FObjects<FRs3ModelStream> _streams = new FObjects<FRs3ModelStream>(FRs3ModelStream.class);

   //============================================================
   // <T>构造资源模型网格。</T>
   //============================================================
   public FRs3ModelMesh(){
   }

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
   public String code(){
      return _code;
   }

   //============================================================
   // <T>获得网格集合。</T>
   //
   // @return 网格集合
   //============================================================
   public FObjects<FRs3ModelStream> streams(){
      return _streams;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      // 输出网格集合
      int streamCount = _streams.count();
      output.writeInt8((byte)streamCount);
      for(int i = 0; i < streamCount; i++){
         FRs3ModelStream stream = _streams.get(i);
         stream.serialize(output);
      }
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
      // 读取属性
      _code = input.readString();
      // 读取数据流集合
      int count = input.readInt16();
      for(int n = 0; n < count; n++){
         FRs3ModelStream stream = new FRs3ModelStream();
         stream.unserialize(input);
         _streams.push(stream);
      }
   }
}
