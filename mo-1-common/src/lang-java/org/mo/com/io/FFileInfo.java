package org.mo.com.io;

import java.io.File;
import org.mo.com.lang.FObject;
import org.mo.com.lang.generic.TDumpInfo;

//============================================================
// <T>文件信息。</T>
//============================================================
public class FFileInfo
      extends FObject
{
   // 名称
   protected String _name;

   // 扩展名
   protected String _extension;

   // 文件名称
   protected String _fileName;

   //============================================================
   // <T>构造文件信息。</T>
   //============================================================
   public FFileInfo(){
   }

   //============================================================
   // <T>构造文件信息。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public FFileInfo(String fileName){
      parse(fileName);
   }

   //============================================================
   // <T>获得代码。</T>
   //
   // @return 代码
   //============================================================
   public String code(){
      int find = _name.lastIndexOf('.');
      if(find != -1){
         return _name.substring(0, find);
      }
      return _name;
   }

   //============================================================
   // <T>获得短名称。</T>
   //
   // @return 短名称
   //============================================================
   public String name(){
      return _name;
   }

   //============================================================
   // <T>获得扩展名称。</T>
   //
   // @return 扩展名称
   //============================================================
   public String extension(){
      return _extension;
   }

   //============================================================
   // <T>获得文件名称。</T>
   //
   // @return 文件名称
   //============================================================
   public String fileName(){
      return _fileName;
   }

   //============================================================
   // <T>设置文件名称。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void parse(String fileName){
      // 替换分割符
      _fileName = RFile.format(fileName);
      // 生成短名称
      int find = _fileName.lastIndexOf(File.separatorChar);
      if(find != -1){
         _name = _fileName.substring(find + 1);
      }else{
         _name = _fileName;
      }
      // 生成扩展名称
      find = _name.lastIndexOf('.');
      if(find != -1){
         _extension = _name.substring(find + 1);
      }else{
         _extension = "";
      }
   }

   //============================================================
   // <T>获得字符串。</T>
   //
   // @return 字符串
   //============================================================
   @Override
   public String toString(){
      return _fileName;
   }

   //============================================================
   // <T>生成运行信息。</T>
   //
   // @param info 运行信息
   // @return 运行信息
   //============================================================
   @Override
   public TDumpInfo dump(TDumpInfo info){
      info.append(_fileName);
      return info;
   }
}
