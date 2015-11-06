package util;

import java.io.BufferedReader;
import java.io.FileReader;

public class IpDataImportToRedis
{
   public static void main(String[] args) throws Exception{
      //运行之前先把aaaaaaaaaaa.txt文件的编码格式修改成:UTF-8
      BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\XLZPC\\Desktop\\aaaaaaaaaaa.txt"));

      String line = null;
      while((line = br.readLine()) != null){
         String newLine = new String(line.getBytes(), "UTF-8");
         String[] arr = newLine.split(" {1,}");
         if(arr.length == 4){
            System.out.println(arr[0] + "*******" + arr[1] + "*******" + arr[2] + "*******" + arr[3]);
         }
         if(arr.length == 3){
            System.out.println(arr[0] + "*******" + arr[1] + "*******" + arr[2]);
         }

      }

      br.close();

   }
}
