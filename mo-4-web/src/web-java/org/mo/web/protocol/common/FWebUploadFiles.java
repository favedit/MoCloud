package org.mo.web.protocol.common;

import org.mo.com.lang.FObjects;

//============================================================
// <T>网络上传文件集合。</T>
//============================================================
public class FWebUploadFiles
      extends FObjects<FWebUploadFile>
{
   //============================================================
   // <T>构造网络上传文件集合。</T>
   //============================================================
   public FWebUploadFiles(){
      super(FWebUploadFile.class);
   }

   //============================================================
   // <T>根据名称查找上传文件。</T>
   //
   // @param name 名称
   // @return 上传文件
   //============================================================
   public FWebUploadFile findByName(String name){
      for(int n = 0; n < _count; n++){
         FWebUploadFile file = _items[n];
         if(file.name().equalsIgnoreCase(name)){
            return file;
         }
      }
      return null;
   }
}
