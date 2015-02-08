package org.mo.content.resource3d.common;

import org.mo.com.io.FByteFile;
import org.mo.com.io.IDataInput;

//============================================================
// <T>资源基类。</T>
//============================================================
public class FRs3Resource
      extends FRs3Object
{
   //============================================================
   // <T>构造资源基类。</T>
   //============================================================
   public FRs3Resource(){
   }

   //============================================================
   // <T>从输入流反序列化数据。</T>
   //
   // @param input 输入流
   //============================================================
   public void importData(IDataInput input){
      //_guid = input.readString();
      _code = input.readString();
   }

   //============================================================
   // <T>加载数据流。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void loadStream(IDataInput inputName){
      importData(inputName);
   }

   //============================================================
   // <T>加载文件数据。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void loadFile(String fileName){
      try(FByteFile file = new FByteFile(fileName)){
         importData(file);
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
