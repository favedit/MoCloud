package org.mo.web.protocol.common;

import org.mo.com.io.RFile;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RString;
import org.mo.com.lang.generic.INamed;
import org.mo.com.lang.generic.TDumpInfo;

//============================================================
// <T>网络上传文件。</T>
//============================================================
public class FWebUploadFile
      extends FObject
      implements
         INamed<String>
{
   // 内容类型
   protected String _contentType;

   // 名称
   protected String _name;

   // 文件名称
   protected String _fileName;

   // 上传名称
   protected String _uploadName;

   // 长度
   protected int _length;

   //============================================================
   // <T>构造网络上传文件。</T>
   //============================================================
   public FWebUploadFile(){
   }

   //============================================================
   // <T>获得内容类型。</T>
   //
   // @return 内容类型
   //============================================================
   public String contentType(){
      return _contentType;
   }

   //============================================================
   // <T>设置内容类型。</T>
   //
   // @param contentType 内容类型
   //============================================================
   public void setContentType(String contentType){
      _contentType = contentType;
   }

   //============================================================
   // <T>获得名称。</T>
   //
   // @return 名称
   //============================================================
   @Override
   public String name(){
      return _name;
   }

   //============================================================
   // <T>设置名称。</T>
   //
   // @param name 名称
   //============================================================
   public void setName(String name){
      _name = name;
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
   public void setFileName(String fileName){
      _fileName = fileName;
   }

   //============================================================
   // <T>生成文件名称。</T>
   //
   // @param name 名称
   // @return 文件名称
   //============================================================
   public String makeFileName(String name){
      String extension = RFile.extension(_fileName);
      if(RString.isEmpty(extension)){
         return _fileName;
      }
      return name + "." + extension;
   }

   //============================================================
   // <T>生成文件名称。</T>
   //
   // @param extension 后缀
   // @return 文件名称
   //============================================================
   public String makeFileExtension(String extension){
      String extensionPath = RFile.extensionPath(_fileName);
      return extensionPath + "." + extension;
   }

   //============================================================
   // <T>获得上传名称。</T>
   //
   // @return 上传名称
   //============================================================
   public String uploadName(){
      return _uploadName;
   }

   //============================================================
   // <T>获得上传名称。</T>
   //
   // @return 上传名称
   //============================================================
   public void setUploadName(String sValue){
      _uploadName = sValue;
   }

   //============================================================
   // <T>获得长度。</T>
   //
   // @return 长度
   //============================================================
   public int length(){
      return _length;
   }

   //============================================================
   // <T>设置长度。</T>
   //
   // @param length 长度
   //============================================================
   public void setLength(int length){
      _length = length;
   }

   //============================================================
   // <T>设置长度。</T>
   //
   // @param length 长度
   //============================================================
   public void setLength(String length){
      _length = RInteger.parse(length);
   }

   //============================================================
   // <T>移动文件到指定位置。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public void move(String fileName){
      RFile.copyFile(uploadName(), fileName);
   }

   //============================================================
   // <T>获得运行信息。</T>
   //
   // @param info 运行信息
   // @return 运行信息
   //============================================================
   @Override
   public TDumpInfo dump(TDumpInfo info){
      info.append(" Name:" + name());
      info.append(" File Name:" + _fileName);
      info.append(" Upload Name:" + _uploadName);
      info.append(" Length:" + _length);
      info.append(" Content Type:" + _contentType);
      return info;
   }
}
