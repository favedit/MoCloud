package mo.hadoop.test;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.FObject;

//============================================================
// <T>HDFS文件系统链接。</T>
// <P>hdfs://ip:port/destination</P>
//============================================================
public class FHdfsConnection
      extends FObject
{
   // 配置信息
   protected Configuration _configuration;

   // 文件系统
   protected FileSystem _fileSystem;

   //============================================================
   // <T>构造HDFS文件系统链接。</T>
   //============================================================
   public FHdfsConnection(){
      try{
         _configuration = new Configuration();
         _fileSystem = FileSystem.get(_configuration);
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
   }

   //============================================================
   // <T>上传文件。</T>
   //
   // @param localFile 本地路径
   // @param hdfsPath 格式为
   //============================================================
   public void uploadFile(String localFile,
                          String hdfsPath){
      // 打开文件
      try(FileInputStream fileInputStream = new FileInputStream(localFile)){
         try(InputStream inputStream = new BufferedInputStream(fileInputStream)){
            // 写入路径
            Path path = new Path(hdfsPath);
            try(OutputStream outputStream = _fileSystem.create(path)){
               IOUtils.copyBytes(inputStream, outputStream, _configuration);
            }
         }
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
   }

   //============================================================
   // <T>附加文件。</T>
   //============================================================
   public void appendFile(String localFile,
                          String hdfsPath){
      try{
         InputStream in = new FileInputStream(localFile);
         OutputStream out = _fileSystem.append(new Path(hdfsPath));
         IOUtils.copyBytes(in, out, _configuration);
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
   }

   //============================================================
   // <T>下载文件。</T>
   //============================================================
   public void downloadFile(String hdfsPath,
                            String localPath){
      try{
         InputStream in = _fileSystem.open(new Path(hdfsPath));
         OutputStream out = new FileOutputStream(localPath);
         IOUtils.copyBytes(in, out, _configuration);
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
   }

   //============================================================
   // <T>删除文件或目录。</T>
   //============================================================
   public void deleteFile(String hdfsPath){
      try{
         _fileSystem.delete(new Path(hdfsPath), true);
      }catch(Exception exception){
         throw new FFatalError(exception);
      }
   }

}
