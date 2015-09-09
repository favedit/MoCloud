package mo.hadoop.test;

import org.mo.com.logging.RLogger;

public class RTester
{
   public static void main(String[] args){
      System.setProperty("hadoop.home.dir", "D:/Studio/Hadoop");
      try{
         FHdfsConnection connection = new FHdfsConnection();
         connection.uploadFile("D:/test.html", "hdfs://hadoop-master:9000/");
         System.out.println(connection);
      }catch(Exception exception){
         RLogger.find(RTester.class).fatal(null, "main", exception);
      }
   }
}
