package org.mo.content.resource3d.common;

import org.mo.com.io.FByteFile;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;

//============================================================
// <T>资源信息。</T>
//============================================================
public class FRs3Resource
      extends FRs3Obejct
{
   // 代码
   protected String _code;

   //============================================================
   // <T>构造资源模型数据流。</T>
   //============================================================
   public FRs3Resource(){
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
   // <T>获得代码。</T>
   //
   // @param code 代码
   //============================================================
   public void setCode(String code){
      _code = code;
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void unserialize(IDataInput input){
      _code = input.readString();
   }

   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
      output.writeString(_code);
   }

   //============================================================
   // <T>加载数据流。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void loadStream(IDataInput inputName){
      unserialize(inputName);
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
