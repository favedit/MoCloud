package org.mo.eai;

import org.mo.com.io.FByteFile;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.FObject;

//============================================================
// <T>资源导出器。</T>
//============================================================
public class FResourceExporter
      extends FObject
{
   //============================================================
   // <T>序列化数据到输出流。</T>
   //
   // @param output 输出流
   //============================================================
   public void serialize(IDataOutput output){
   }

   //============================================================
   // <T>序列化数据到文件。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void serializeFile(String fileName,
                             String code){
      FByteFile file = new FByteFile();
      file.writeString(code);
      serialize(file);
      file.saveToFile(fileName);
   }
}
