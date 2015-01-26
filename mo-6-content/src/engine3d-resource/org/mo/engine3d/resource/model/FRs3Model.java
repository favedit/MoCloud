package org.mo.engine3d.resource.model;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObjects;
import org.mo.engine3d.resource.common.FRs3Resource;

//============================================================
// <T>资源模型。</T>
//============================================================
public class FRs3Model
      extends FRs3Resource
{
   // 网格集合
   protected FObjects<FRs3ModelMesh> _meshs = new FObjects<FRs3ModelMesh>(FRs3ModelMesh.class);

   //============================================================
   // <T>构造资源模型。</T>
   //============================================================
   public FRs3Model(){
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   @Override
   public void unserialize(IDataInput input){
      super.unserialize(input);
      // 读取网格集合
      int meshCount = input.readInt16();
      for(int n = 0; n < meshCount; n++){
         FRs3ModelMesh mesh = new FRs3ModelMesh();
         mesh.unserialize(input);
         _meshs.push(mesh);
      }
   }
}
