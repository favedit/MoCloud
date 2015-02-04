package org.mo.content.resource3d.model;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;

//============================================================
// <T>资源模型网格。</T>
//============================================================
public class FRs3ModelMeshBone
      extends FObject
{
   // 骨头编号
   protected int _boneId;

   //============================================================
   // <T>构造资源模型网格。</T>
   //============================================================
   public FRs3ModelMeshBone(){
   }

   //============================================================
   // <T>获得骨头编号。</T>
   //
   // @return 骨头编号
   //============================================================
   public int boneId(){
      return _boneId;
   }

   //============================================================
   // <T>设置骨头编号。</T>
   //
   // @param boneId 骨头编号
   //============================================================
   public void setGuid(int boneId){
      _boneId = boneId;
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      // 输出属性
      output.writeUint8((short)_boneId);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
      // 读取属性
      _boneId = input.readInt32();
   }
}
