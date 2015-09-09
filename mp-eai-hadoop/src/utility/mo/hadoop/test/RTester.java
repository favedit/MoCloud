package mo.hadoop.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URI;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.Progressable;

public class RTester
{
   public static void main(String[] args){
      //      System.setProperty("java.library.path", "D:/Studio/Hadoop/lib/native/");
      //      System.setProperty("hadoop.home.dir", "D:/Studio/Hadoop");
      // 获取读取源文件和目标文件位置参数
      String local = "D:/Temp/citydata.json";
      String uri = "hdfs://10.13.0.250:9000/test/citydata.json";
      FileInputStream in = null;
      OutputStream out = null;
      Configuration conf = new Configuration();
      try{
         // 获取读入文件数据
         in = new FileInputStream(new File(local));
         // 获取目标文件信息
         FileSystem fs = FileSystem.get(URI.create(uri), conf);
         out = fs.create(new Path(uri), new Progressable(){
            @Override
            public void progress(){
               System.out.println("*");
            }
         });
         // 跳过前100个字符
         in.skip(100);
         byte[] buffer = new byte[20];
         // 从101的位置读取20个字符到buffer中
         int bytesRead = in.read(buffer);
         if(bytesRead >= 0){
            out.write(buffer, 0, bytesRead);
         }
      }catch(Exception exception){
         exception.printStackTrace();
      }finally{
         //IOUtils.closeStream(in);
         //IOUtils.closeStream(out);
      }

      // try {
      // FHdfsConnection connection = new FHdfsConnection();
      // connection.uploadFile("/data/MoScript/readme.txt",c
      // "hdfs://10.13.0.25:9000/readme.txt");
      // System.out.println(connection);
      // } catch (Exception exception) {
      // RLogger.find(RTester.class).fatal(null, "main", exception);
      // }
      System.out.println("Finish");
   }
}
