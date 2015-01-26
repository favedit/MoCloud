package org.mo.engine3d.resource.model;

import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;

//============================================================
// <T>资源模型数据流。</T>
//============================================================
public class FRs3ModelStream
{
   protected String _code;

   protected int _stride;

   protected int _count;

   //============================================================
   // <T>构造资源模型数据流。</T>
   //============================================================
   public FRs3ModelStream(){
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
   }
}
