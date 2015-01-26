package org.mo.engine3d.resource.common;

import org.mo.com.io.FByteFile;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;

//============================================================
// <T>资源信息。</T>
//============================================================
public class FRs3Resource
      extends FRs3Obejct
{
   protected String _name;

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
      _name = input.readString();
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
   }

   //============================================================
   // <T>加载文件数据。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void loadFile(String fileName){
      try(FByteFile file = new FByteFile(fileName)){
         unserialize(file);
      }
   }

   //============================================================
   // <T>保存文件数据。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void saveFile(String fileName){
      try(FByteFile file = new FByteFile()){
         serialize(file);
         file.saveToFile(fileName);
      }
   }
}
