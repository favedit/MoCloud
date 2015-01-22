package org.mo.com.io;

import java.io.File;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.lang.generic.TDumpInfo;

//============================================================
// <T>文件信息。</T>
//============================================================
public class FFileInfo
      extends FObject
{
   // 文件名称
   protected String _fileName;

   // 短名称
   protected String _shortName;

   // 扩展名称
   protected String _extendName;

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
      setFileName(fileName);
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
   // <T>获得短名称。</T>
   //
   // @return 短名称
   //============================================================
   public String shortName(){
      return _shortName;
   }

   //============================================================
   // <T>获得扩展名称。</T>
   //
   // @return 扩展名称
   //============================================================
   public String extendName(){
      return _extendName;
   }

   //============================================================
   // <T>设置文件名称。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void setFileName(String fileName){
      // 替换分割符
      fileName = RString.replace(fileName, '/', File.separatorChar);
      fileName = RString.replace(fileName, '\\', File.separatorChar);
      _fileName = fileName;
      // 生成短名称
      int find = _fileName.lastIndexOf(File.separatorChar);
      if(find != -1){
         _shortName = _fileName.substring(find + 1);
      }else{
         _shortName = _fileName;
      }
      // 生成扩展名称
      find = _shortName.lastIndexOf('.');
      if(find != -1){
         _extendName = _shortName.substring(find + 1);
      }else{
         _extendName = "";
      }
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
