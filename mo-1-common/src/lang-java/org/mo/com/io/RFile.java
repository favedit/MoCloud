package org.mo.com.io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FString;
import org.mo.com.lang.FStrings;
import org.mo.com.lang.IAttributes;
import org.mo.com.lang.RString;
import org.mo.com.lang.cultrue.FEncoding;

//============================================================
// <T>文件工具类。</T>
//============================================================
public class RFile
{
   //============================================================
   // <T>获得短文件名称。</T>
   //
   // @param fileName 文件名称
   // @return 短文件名称
   //============================================================
   public static String shortName(String fileName){
      File file = new File(fileName);
      String name = file.getName();
      if(name != null){
         int sp = name.lastIndexOf('.');
         if(sp != -1){
            return name.substring(0, sp);
         }
      }
      return name;
   }

   //============================================================
   // <T>获得文件名称。</T>
   //
   // @param fileName 文件名称
   // @return 文件名称
   //============================================================
   public static String name(String fileName){
      File file = new File(fileName);
      return file.getName();
   }

   //============================================================
   // <T>获得文件的后缀。</T>
   //
   // @param file 文件
   // @return 后缀
   //============================================================
   public static String extension(File file){
      return extension(file.getName());
   }

   //============================================================
   // <T>获得文件的后缀。</T>
   //
   // @param fileName 文件名称
   // @return 后缀
   //============================================================
   public static String extension(String fileName){
      if(!RString.isEmpty(fileName)){
         int index = fileName.lastIndexOf('.');
         if(index > 0){
            return fileName.substring(index + 1);
         }
      }
      return null;
   }

   //============================================================
   // <T>获得无后缀的文件名称。</T>
   //
   // @param fileName 文件名称
   // @return 文件名称
   //============================================================
   public static String extensionPath(String fileName){
      if(fileName != null){
         int index = fileName.lastIndexOf('.');
         if(index != -1){
            String formatName = formatFileName(fileName);
            int indexSeparator = formatName.lastIndexOf(File.pathSeparatorChar);
            if(index > indexSeparator){
               return formatName.substring(0, index);
            }
         }
      }
      return fileName;
   }

   //============================================================
   // <T>获得文件路径。</T>
   //
   // @param fileName 文件名称
   // @return 文件路径
   //============================================================
   public static String path(String fileName){
      if(fileName != null){
         String name = format(fileName);
         int index = name.lastIndexOf(File.separatorChar);
         if(index != -1){
            return name.substring(0, index);
         }
      }
      return fileName;
   }

   //============================================================
   // <T>格式化文件名称。</T>
   //
   // @param fileName 文件名称
   // @return 文件名称
   //============================================================
   public static String formatFileName(String fileName){
      return RString.replaceChars(fileName, '\\', File.separatorChar, '/', File.separatorChar);
   }

   //============================================================
   // <T>获得文件的路径名称。</T>
   //
   // @param fileName 文件名称
   // @return 路径名称
   //============================================================
   public static String makeDirectoryName(String fileName){
      fileName = formatFileName(fileName);
      int index = fileName.lastIndexOf(File.separatorChar);
      if(-1 != index){
         return fileName.substring(0, index);
      }
      return fileName;
   }

   //============================================================
   // <T>格式化文件名为标准格式。</T>
   //
   // @param params 参数集合
   // @return 格式化后的文件名
   //============================================================
   public static String format(String fileName){
      return RString.replaceChars(fileName, '\\', File.separatorChar, '/', File.separatorChar);
   }

   //============================================================
   // <T>生成文件名称。</T>
   //
   // @param params 参数集合
   // @return 文件名称
   //============================================================
   public static String makeFilename(String... params){
      FString result = new FString();
      if(params != null){
         int count = params.length;
         for(int n = 0; n < count; n++){
            String param = params[n];
            if(param != null){
               // 格式化内容
               param = RString.replaceChars(param, '/', File.separatorChar, '\\', File.separatorChar);
               // 去掉前缀
               if(param.startsWith("." + File.separatorChar)){
                  param = param.substring(2);
               }
               // 写入内容
               if(n < count - 1){
                  if(param.endsWith(File.separator)){
                     result.append(param);
                  }else{
                     result.append(param);
                     result.append(File.separatorChar);
                  }
               }else{
                  result.append(param);
               }
            }
         }
      }
      // 返回文件
      String file = result.toString();
      while(file.indexOf(File.separator + File.separator) != -1){
         file = RString.replace(file, File.separator + File.separator, File.separator);
      }
      return file;
   }

   //============================================================
   // <T>生成路径名称。</T>
   //
   // @param params 参数集合
   // @return 路径名称
   //============================================================
   public static String makePathname(String... params){
      FString filename = new FString();
      if(params != null){
         String param;
         int count = params.length;
         for(int n = 0; n < count; n++){
            if(params[n] != null){
               param = RString.replaceChars(params[n], '/', File.separatorChar, '\\', File.separatorChar);
               if(n < count - 1){
                  if(param.endsWith(File.separator)){
                     filename.append(param);
                  }else{
                     filename.append(param);
                     filename.append(File.separatorChar);
                  }
               }else{
                  filename.append(param);
               }
            }
         }
      }
      return filename.toString();
   }

   //============================================================
   // <T>更改文件的名称。</T>
   //
   // @param sourceName 源名称
   // @param targetName 目标名称
   // @return 路径名称
   //============================================================
   public static String rename(String sourceName,
                               String targetName){
      File sourceFile = new File(sourceName);
      File targetFile = new File(targetName);
      // 更换名称
      sourceFile.renameTo(targetFile);
      return targetFile.getAbsolutePath();
   }

   //============================================================
   // <T>创建指定的名称的全路径。</T>
   //
   // @param fileName 文件名称
   //============================================================
   public static void makeFileDirectory(String fileName){
      fileName = formatFileName(fileName);
      String filepath = fileName.substring(0, fileName.lastIndexOf(File.separatorChar));
      File dir = new File(filepath);
      if(!dir.isDirectory()){
         dir.mkdirs();
      }
   }

   //============================================================
   // <T>复制来源文件到目标文件。</T>
   //
   // @param fromFile 来源文件
   // @param destName 目标文件
   // @return 处理结果
   //============================================================
   public static boolean copyFile(String fromFile,
                                  String destName){
      return copyFile(fromFile, destName, true);
   }

   //============================================================
   // <T>复制来源文件到目标文件。</T>
   //
   // @param fromFile 来源文件
   // @param destName 目标文件
   // @param overwrite 是否覆盖
   // @return 处理结果
   //============================================================
   public static boolean copyFile(String fromName,
                                  String destName,
                                  boolean overwrite){
      // 检查参数
      if(RString.isEmpty(fromName)){
         return false;
      }
      if(RString.isEmpty(destName)){
         return false;
      }
      if(fromName.equals(destName)){
         return true;
      }
      // 建立目标目录
      destName = formatFileName(destName);
      int separatorIndex = destName.lastIndexOf(File.separator);
      if(separatorIndex > 0){
         String filePath = destName.substring(0, separatorIndex);
         File fileDir = new File(filePath);
         if(!fileDir.exists()){
            fileDir.mkdirs();
         }
      }
      // 复制数据
      File srcFile = new File(fromName);
      File destFile = new File(destName);
      try{
         FileInputStream fileIS = new FileInputStream(srcFile);
         FileOutputStream fileOS = new FileOutputStream(destFile, !overwrite);
         byte[] arBuffer = new byte[1024 * 1024 * 16];
         int nSize = fileIS.read(arBuffer);
         while(nSize != -1){
            fileOS.write(arBuffer, 0, nSize);
            nSize = fileIS.read(arBuffer);
         }
         fileIS.close();
         fileOS.close();
      }catch(FileNotFoundException fileNotFoundException){
         if(srcFile.isDirectory()){
            File[] files = srcFile.listFiles();
            for(int i = 0; i < files.length; i++){
               destFile.mkdirs();
               copyFile(srcFile + File.separator + files[i].getName(), destName + File.separator + files[i].getName(), overwrite);
            }
         }else{
            throw new FFatalError(fileNotFoundException);
         }
      }catch(IOException e){
         throw new FFatalError(e);
      }
      return true;
   }

   //============================================================
   // <T>复制来源文件到目标文件。</T>
   //
   // @param fromFile 来源文件
   // @param destName 目标文件
   // @return 处理结果
   //============================================================
   public static void checkFile(String fileName){
      checkFile(new File(fileName));
   }

   //============================================================
   // <T>复制来源文件到目标文件。</T>
   //
   // @param fromFile 来源文件
   // @param destName 目标文件
   // @return 处理结果
   //============================================================
   public static void checkFile(File file){
      // 检查文件存在
      if(!file.exists()){
         throw new FFatalError("File is not exists. (file_name={1})", file.getAbsolutePath());
      }
      // 检查是文件
      if(!file.isFile()){
         throw new FFatalError("File is invalid. (file_name={1})", file.getAbsolutePath());
      }
   }

   private static void listFile__(FStrings files,
                                  File directory,
                                  boolean deep,
                                  String startsWith,
                                  String endWith){
      if(directory.isDirectory()){
         for(File file : directory.listFiles()){
            if(deep && file.isDirectory()){
               listFile__(files, file, deep, startsWith, endWith);
            }else{
               String filename = file.getAbsolutePath();
               boolean finded = false;
               if(startsWith == null && endWith == null){
                  finded = true;
               }else if(startsWith != null && endWith == null){
                  if(filename.startsWith(startsWith)){
                     finded = true;
                  }
               }else if(startsWith == null && endWith != null){
                  if(filename.startsWith(endWith)){
                     finded = true;
                  }
               }else if(startsWith != null && endWith != null){
                  if(filename.startsWith(startsWith) && filename.startsWith(endWith)){
                     finded = true;
                  }
               }
               if(finded){
                  files.push(filename);
               }
            }
         }
      }
   }

   public static FStrings listFiles(String directory){
      FStrings files = new FStrings();
      listFile__(files, new File(directory), false, null, null);
      return files;
   }

   /**
    * <p>检查指定的文件名的物理文件是否存在，如果不存在则会发生例外</p>
    * 
    * @param fileName 文件名称
    */
   public static void checkExists(String fileName){
      if(!RString.isEmpty(fileName)){
         if(new File(fileName).exists()){
            return;
         }
      }
      throw new FFatalError("File is not exists (fileName=)", fileName);
   }

   /**
    * <p>删除指定的文件</p>
    * 
    * @param filename 文件名称
    */
   public static boolean delete(String filename){
      File file = new File(filename);
      if(file.isFile() || file.isDirectory()){
         return file.delete();
      }
      return false;
   }

   /**
    * <p>判断指定的文件名的物理文件是否存在</p>
    * 
    * @param name 文件名称
    * @return true:存在<br>false:不存在
    */
   public static boolean exists(String name){
      return RString.isEmpty(name) ? false : new File(name).exists();
   }

   /**
    * <p>格式化文件路径为标准格式</p>
    * <p>create date:2005/02/14</p>
    * 
    * @param sDirectory 文件路径
    * @return 格式化后的文件路径
    */
   public static String formatDirectory(String sDirectory){
      return formatDirectory(sDirectory, false);
   }

   /**
    * <p>格式化文件路径为标准格式</p>
    * <p>create date:2005/02/14</p>
    * 
    * @param sDirectory 文件路径
    * @param bEndSplitter 是否在路径最后带路径分隔符
    * @return 格式化后的文件路径
    */
   public static String formatDirectory(String sDirectory,
                                        boolean bEndSplitter){
      sDirectory = RString.replaceChars(sDirectory, '\\', '/');
      sDirectory = RString.replace(sDirectory, "//", "/");
      sDirectory = RString.replaceChars(sDirectory, '/', File.separatorChar);
      if(bEndSplitter && !sDirectory.endsWith(File.separator)){
         sDirectory += File.separator;
      }else if(!bEndSplitter && sDirectory.endsWith(File.separator)){
         sDirectory = sDirectory.substring(0, File.separator.length() - 1);
      }
      return sDirectory;
   }

   //private ILogger _logger = new FLogger(FFileUtil.class);
   public static boolean hasFile(String path){
      File file = new File(path);
      if(file.isDirectory()){
         return file.list().length > 0;
      }
      return false;
   }

   /**
    * <p>判断指定的名称是否是文件路径</p>
    * 
    * @param path 指定的名称
    * @return true：是 <br>false：否
    */
   public static boolean isDirectory(String path){
      if(null != path){
         return (new File(path)).isDirectory();
      }
      return false;
   }

   public static boolean isExtension(File oFile,
                                     String sExtension){
      return extension(oFile).equalsIgnoreCase(sExtension);
   }

   public static boolean isExtension(String filename,
                                     String extension){
      if(null != filename && null != extension){
         if(extension.charAt(0) == '.'){
            return filename.toLowerCase().endsWith(extension.toLowerCase());
         }
         return filename.toLowerCase().endsWith("." + extension.toLowerCase());
      }
      return false;
   }

   /**
    * <p>判断指定的名称是否是文件</p>
    * 
    * @param filename 指定的名称
    * @return true：是 <br>false：否
    */
   public static boolean isFile(String filename){
      return (new File(filename)).isFile();
   }

   public static void listAllDirectory(String directory,
                                       IAttributes directories,
                                       FStrings files,
                                       String startsWith,
                                       String endsWith){
      listDirectory__(new File(directory), directories, files, true, startsWith, endsWith);
   }

   public static FStrings listAllFile(String directory){
      FStrings files = new FStrings();
      listFile__(files, new File(directory), true, null, null);
      return files;
   }

   private static void listDirectory__(File directory,
                                       IAttributes directories,
                                       FStrings files,
                                       boolean deep,
                                       String startsWith,
                                       String endsWith){
      if(directory.isDirectory()){
         int count = 0;
         for(File file : directory.listFiles()){
            if(deep && file.isDirectory()){
               listDirectory__(file, directories, files, deep, startsWith, endsWith);
            }else{
               String name = file.getName();
               boolean finded = false;
               if((null == startsWith) && (null == endsWith)){
                  finded = true;
               }else if((null != startsWith) && (null == endsWith)){
                  if(name.startsWith(startsWith)){
                     finded = true;
                  }
               }else if((null == startsWith) && (null != endsWith)){
                  if(name.endsWith(endsWith)){
                     finded = true;
                  }
               }else if((null != startsWith) && (null != endsWith)){
                  if(name.startsWith(startsWith) && name.startsWith(endsWith)){
                     finded = true;
                  }
               }
               if(finded){
                  count++;
                  files.push(file.getAbsolutePath());
               }
            }
         }
         if(null != directories){
            directories.set(directory.getAbsolutePath(), Integer.toString(count));
         }
      }
   }

   //   /**
   //    * <p>列出指定目录下的所有文件名称列表</p>
   //    * <p>create date:2005/10/20</p>
   //    * 
   //    * @param sDirectory 指定目录
   //    * @return 文件名称列表
   //    * @exception FException 应用程序例外
   //    */
   //   public static FStringArray listFile(String sDirectory) throws FException {
   //      return listFile(sDirectory, false);
   //   }
   //
   //   /**
   //    * <p>列出指定目录下的所有文件名称列表</p>
   //    * <p>create date:2005/10/20</p>
   //    * 
   //    * @param sDirectory 指定目录
   //    * @param bFullName 名称是否使用全路径
   //    * @return 文件名称列表
   //    * @exception FException 应用程序例外
   //    */
   //   public static FStringArray listFile(String sDirectory, boolean bFullName)
   //         throws FException {
   //      FStringArray oList = new FStringArray();
   //      File oDir = new File(sDirectory);
   //      if (oDir.isDirectory()) {
   //         for (File oFile : oDir.listFiles()) {
   //            if (oFile.isFile()) {
   //               if (bFullName) {
   //                  oList.push(makeDirectoryName(sDirectory, oFile.getName()));
   //               } else {
   //                  oList.push(oFile.getName());
   //               }
   //            }
   //         }
   //      }
   //      return oList;
   //   }
   //
   //   //
   //   // /**
   //   // * <p>读取一个文件，以字符串列表返回这个文件的全部内容</p>
   //   // * <p>create date:2005/02/18</p>
   //   // *
   //   // * @param sFileName 文件名称
   //   // * @return 文件的全部内容
   //   // * @exception FException 应用程序例外
   //   // */
   //   // public static FStringList loadFromFileAsList(String sFileName)
   //   // throws
   //   // FException {
   //   // return loadFromFileAsList(sFileName, null);
   //   // }
   //   //
   //   // /**
   //   // * <p>读取一个文件，以字符串列表返回这个文件的全部内容</p>
   //   // * <p>create date:2005/02/18</p>
   //   // *
   //   // * @param sFileName 文件名称
   //   // * @param sCharset 字符集
   //   // * @return 文件的全部内容
   //   // * @exception FException 应用程序例外
   //   // */
   //   // public static FStringList loadFromFileAsList(String sFileName,
   //   // String sCharset)
   //   // throws
   //   // FException {
   //   // BufferedReader oBufferedReader = null;
   //   // try {
   //   // File oFile = new File(sFileName);
   //   // if (FString.isEmpty(sCharset)) {
   //   // oBufferedReader = new BufferedReader(new InputStreamReader(
   //   // new FileInputStream(oFile)));
   //   // } else {
   //   // oBufferedReader = new BufferedReader(new InputStreamReader(
   //   // new FileInputStream(oFile), sCharset));
   //   // }
   //   // FStringList oList = new FStringList();
   //   // String sLine = null;
   //   // while (true) {
   //   // sLine = oBufferedReader.readLine();
   //   // if (sLine == null) {
   //   // break;
   //   // }
   //   // oList.push(sLine);
   //   // }
   //   // return oList;
   //   // } catch (Exception oException) {
   //   // throw new FFatalException(
   //   // FFile.class, oException,
   //   // "FileName[" + sFileName + "] Charset[" + sCharset + "]");
   //   // } finally {
   //   // if (oBufferedReader != null) {
   //   // try {
   //   // oBufferedReader.close();
   //   // } catch (Exception oException) {
   //   // throw new FFatalException(
   //   // FFile.class, oException,
   //   // "FileName[" + sFileName + "] Charset[" + sCharset + "]");
   //   // }
   //   // }
   //   // }
   //   // }
   //   //
   //   // /**
   //   // * <p>按字节方式，比较两个文件是否相同</p>
   //   // * <p>create date:2005/02/18</p>
   //   // *
   //   // * @param sFileName1 文件名称1
   //   // * @param sFileName2 文件名称2
   //   // * @return TRUE：是<br>FALSE：否
   //   // * @exception FException 应用程序例外
   //   // */
   //   // public static boolean compare(String sFileName1,
   //   // String sFileName2)
   //   // throws FException {
   //   // return FStream.compare(
   //   // loadFromFileAsByte(sFileName1), loadFromFileAsByte(sFileName2));
   //   // }
   //

   //   /**
   //    * <p>获得文件的名称</p>
   //    * <p>create date:2005/02/18</p>
   //    * 
   //    * @param sFullName 文件全名称
   //    * @return 文件的名称
   //    */
   //   public static String fileName(String sFullName) throws FException {
   //      if (!FStringUtil.isEmpty(sFullName)) {
   //         sFullName = FStringUtil.replace(sFullName, "\\", "/");
   //         int nIndex = sFullName.lastIndexOf("/");
   //         if (nIndex != -1) {
   //            return sFullName.substring(nIndex + 1);
   //         }
   //         return sFullName;
   //      }
   //      return "";
   //   }
   //
   //   public static String directory(String sFileName) throws FException {
   //      if (!FStringUtil.isEmpty(sFileName)) {
   //         sFileName = FStringUtil.replace(sFileName, "\\", "/");
   //         int nIndex = sFileName.lastIndexOf("/");
   //         if (nIndex != -1) {
   //            return sFileName.substring(0, nIndex);
   //         }
   //         return sFileName;
   //      }
   //      return "";
   //   }
   //
   //   public static String fileShortName(String sFileName) {
   //      if (!FStringUtil.isEmpty(sFileName)) {
   //         sFileName = FStringUtil.replace(sFileName, "\\", "/");
   //         int nIndex = sFileName.lastIndexOf("/");
   //         if (nIndex != -1) {
   //            sFileName = sFileName.substring(nIndex + 1);
   //         }
   //         nIndex = sFileName.lastIndexOf('.');
   //         if (nIndex > 0) {
   //            return sFileName.substring(0, nIndex);
   //         }
   //         return sFileName;
   //      }
   //      return "";
   //   }
   //

   //
   //   // 列出指定目录下的所有文件
   //   private static boolean listPath(FStringList oFiles,
   //                                   File oDir,
   //                                   String sStartsWith,
   //                                   String sEndWith) throws FException {
   //      if (oDir.isDirectory()) {
   //         File oFile = null;
   //         File[] arFile = oDir.listFiles();
   //         int nCount = arFile.length;
   //         String sFileName = null;
   //         boolean bFinded = false;
   //         for (int n = 0; n < nCount; n++) {
   //            oFile = arFile[n];
   //            if (oFile.isDirectory()) {
   //               listPath(oFiles, oFile, sStartsWith, sEndWith);
   //            } else {
   //               sFileName = oFile.getAbsolutePath();
   //               bFinded = false;
   //               if (sStartsWith == null && sEndWith == null) {
   //                  bFinded = true;
   //               } else if (sStartsWith != null && sEndWith == null) {
   //                  if (sFileName.startsWith(sStartsWith)) {
   //                     bFinded = true;
   //                  }
   //               } else if (sStartsWith == null && sEndWith != null) {
   //                  if (sFileName.startsWith(sEndWith)) {
   //                     bFinded = true;
   //                  }
   //               } else if (sStartsWith != null && sEndWith != null) {
   //                  if (sFileName.startsWith(sStartsWith)
   //                        && sFileName.startsWith(sEndWith)) {
   //                     bFinded = true;
   //                  }
   //               }
   //               if (bFinded) {
   //                  oFiles.add(sFileName, Long.toString(oFile.lastModified()));
   //               }
   //            }
   //         }
   //         return true;
   //      }
   //      return false;
   //   }
   //
   //   /**
   //    * <p>列出指定目录下的所有文件</p>
   //    * <p>create date:2005/10/24</p>
   //    * 
   //    * @param sPathName 指定的目录
   //    * @return 文件列表
   //    * @exception FException 应用程序例外
   //    */
   //   public static FStringList listPath(String sPath) throws FException {
   //      return listPath(sPath, null, null);
   //
   //   }
   //
   //   /**
   //    * <p>列出指定目录下的所有文件</p>
   //    * <p>create date:2005/02/18</p>
   //    * 
   //    * @param sPathName 指定的目录
   //    * @param sBeginWith 文件名开始字符串
   //    * @param sEndWith 文件名结束字符串
   //    * @return 文件列表
   //    * @exception FException 应用程序例外
   //    */
   //   public static FStringList listPath(String sPathName,
   //                                      String sBeginWith,
   //                                      String sEndWith) throws FException {
   //      FStringList oFileList = new FStringList();
   //      File oDir = new File(sPathName);
   //      if (oDir.isDirectory()) {
   //         listPath(oFileList, oDir, sBeginWith, sEndWith);
   //      }
   //      return oFileList;
   //   }
   //
   //
   //   public static FString loadFromFileAsFString(String sFileName)
   //         throws FException {
   //      return new FString(new String(loadFromFileAsByte(sFileName)));
   //   }
   //
   //   /**
   //    * <p>读取一个文件，以字符串返回这个文件的全部内容</p><p>create date:2005/02/18</p>
   //    * 
   //    * @param sFileName 文件名称
   //    * @return 文件的全部内容
   //    * @exception FException 应用程序例外
   //    */
   //   public static String loadFromFileAsString(String sFileName)
   //         throws FException {
   //      return new String(loadFromFileAsByte(sFileName));
   //   }
   //
   //   /**
   //    * <p>读取一个文件，以字符串返回这个文件的全部内容</p><p>create date:2005/02/18</p>
   //    * 
   //    * @param sFileName 文件名称
   //    * @param sCharset 字符集
   //    * @return 文件的全部内容
   //    * @exception FException 应用程序例外
   //    */
   //   public static String loadFromFileAsString(String sFileName, String sCharset)
   //         throws FException {
   //      try {
   //         return new String(loadFromFileAsByte(sFileName), sCharset);
   //      } catch (Exception oException) {
   //         throw new FFatalException(FFileUtil.class,
   //               "FFileUtil.loadFromFileAsString", oException);
   //      }
   //   }
   //
   //   public static String makeDirectoryName(String sDirectory,
   //                                          String sSubDirectory) {
   //      sDirectory = FStringUtil.notEmptyValue(sDirectory);
   //      sDirectory = FStringUtil.replaceChars(sDirectory, "/\\", File.separator);
   //      sSubDirectory = FStringUtil.notEmptyValue(sSubDirectory);
   //      sSubDirectory = FStringUtil.replaceChars(sSubDirectory, "/\\",
   //            File.separator);
   //      FString sFullFileName = new FString();
   //      if (sDirectory.endsWith(File.separator)
   //            && !sSubDirectory.startsWith(File.separator)) {
   //         sFullFileName.append(sDirectory);
   //         sFullFileName.append(sSubDirectory);
   //      } else if (!sDirectory.endsWith(File.separator)
   //            && sSubDirectory.startsWith(File.separator)) {
   //         sFullFileName.append(sDirectory);
   //         sFullFileName.append(sSubDirectory);
   //      } else if (sDirectory.endsWith(File.separator)
   //            && sSubDirectory.startsWith(File.separator)) {
   //         sFullFileName.append(sDirectory);
   //         sFullFileName.append(sSubDirectory.substring(File.separator.length()));
   //      } else {
   //         sFullFileName.append(sDirectory);
   //         sFullFileName.append(File.separator);
   //         sFullFileName.append(sSubDirectory);
   //      }
   //      return sFullFileName.toString();
   //   }
   //
   /**
    * <p>删除指定路径下的全部子路径和文件</p>
    * <p>create date:2005/02/14</p>
    * 
    * @param directory 指定路径对象
    * @return TRUE：成功 <br>FALSE：失败
    */
   public static boolean rmdirs(File directory){
      if(directory != null && directory.isDirectory()){
         File[] files = directory.listFiles();
         if(files != null){
            for(int i = 0; i < files.length; i++){
               if(files[i].isDirectory()){
                  if(!rmdirs(files[i])){
                     return false;
                  }
               }else{
                  if(!files[i].delete()){
                     return false;
                  }
               }
            }
         }
         return directory.delete();
      }
      return false;
   }

   /**
    * <p>删除指定路径下的全部子路径和文件</p>
    * <p>create date:2005/02/14</p>
    * 
    * @param directory 指定路径
    * @return TRUE：成功 <br>FALSE：失败
    */
   public static boolean rmdirs(String directory){
      return rmdirs(new File(directory));
   }

   public static boolean saveToFile(String filename,
                                    FString buffer,
                                    FEncoding encoding){
      BufferedWriter writer = null;
      try{
         filename = formatFileName(filename);
         int nPathPosition = filename.lastIndexOf(File.separator);
         String sPath = filename.substring(0, nPathPosition);
         File dir = new File(sPath);
         if(!dir.isDirectory()){
            dir.mkdirs();
         }
         File file = new File(filename);
         if(null == encoding){
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file)));
         }else{
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding.toString()));
         }
         writer.write(buffer.toString());
         writer.close();
         return true;
      }catch(Exception e){
         throw new FFatalError(e, "filename=[{0}] buffer=[{1}] Charset=[{2}]", filename, buffer, encoding);
      }finally{
         if(writer != null){
            try{
               writer.close();
            }catch(Exception ie){
               throw new FFatalError(ie, "filename=[{0}] buffer=[{1}] Charset=[{2}]", filename, buffer, encoding);
            }
         }
      }
   }

   public static boolean saveToFile(String filename,
                                    String buffer){
      return saveToFile(filename, buffer, null);
   }

   /**
   * <p>将指定内容存储到一个指定的文件中</p><p>如果指定文件的目录不存在,则自动创建目录</p><p>
   * 
   * @param fileName 文件名称
   * @param buffer 指定内容
   * @param charset 字符集
   * @return TRUE：成功 <br>FALSE：失败
   */
   public static boolean saveToFile(String fileName,
                                    String buffer,
                                    String charset){
      BufferedWriter writer = null;
      try{
         fileName = formatFileName(fileName);
         int pathPosition = fileName.lastIndexOf(File.separator);
         String path = fileName.substring(0, pathPosition);
         File dir = new File(path);
         if(!dir.isDirectory()){
            dir.mkdirs();
         }
         File file = new File(fileName);
         FileOutputStream fileStream = new FileOutputStream(file);
         if(RString.isEmpty(charset)){
            writer = new BufferedWriter(new OutputStreamWriter(fileStream));
         }else{
            writer = new BufferedWriter(new OutputStreamWriter(fileStream, charset));
         }
         writer.write(buffer);
         writer.close();
         return true;
      }catch(Exception e){
         throw new FFatalError(e, "filename=[{0}] buffer=[{1}] Charset=[{2}]", fileName, buffer, charset);
      }finally{
         if(writer != null){
            try{
               writer.close();
            }catch(Exception ie){
               throw new FFatalError(ie, "filename=[{0}] buffer=[{1}] Charset=[{2}]", fileName, buffer, charset);
            }
         }
      }
   }

   public static FStrings searchFiles(String directory,
                                      String startsWith,
                                      String endsWith){
      FStrings files = new FStrings();
      listDirectory__(new File(directory), null, files, true, startsWith, endsWith);
      return files;
   }
}
