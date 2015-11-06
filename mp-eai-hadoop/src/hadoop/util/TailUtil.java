package util;

import domain.FileProperties;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

/**
 * 
 * @author 胡国青
 * 读取正在生成的日志信息,取出userid,做到实时向理财师推送登录的客户
 *
 */
public class TailUtil
      implements
         Runnable
{
   private static boolean isOpen = true;

   static{
      //开启线程把监听到的文件名称放到FileProperties的fileName中
      System.out.println("开始监听目录下的文件名修改____________________________");
      Runnable r = new Runnable(){
         @Override
         public void run(){
            try{
               new WatcherServiceUtil(Paths.get("/data/hadoop/flumelogs/")).handleEvents();
            }catch(Exception e){
               e.printStackTrace();
            }
         }
      };
      Thread t = new Thread(r);
      t.start();
   }

   public TailUtil(){
   }

   @Override
   public void run(){
      System.out.println("*****************************************" + Thread.currentThread().getName());
      //TailUtil compiler1 = new TailUtil();
      Runtime runtime = Runtime.getRuntime();
      Process process = null;
      String line = null;
      InputStream is = null;
      InputStreamReader isr = null;
      BufferedReader br = null;
      try{
         while(true){
            Thread.sleep(2000);
            System.out.println("**************" + FileProperties.getFileProperties().isModify() + "**********" + FileProperties.getFileProperties().getFileName());

            if(FileProperties.getFileProperties().isModify()){
               FileProperties.getFileProperties().setModify(false);
               isOpen = true;
               process = runtime.exec("tail -f /data/hadoop/flumelogs/" + FileProperties.getFileProperties().getFileName()); //  关键是这行 

               break;
            }
         }
         is = process.getInputStream();
         isr = new InputStreamReader(is);
         br = new BufferedReader(isr);
         while((line = br.readLine()) != null){
            String lineStr = new String(line.getBytes("ISO8859-1"));
            String[] splitArr = lineStr.split("\\\t|\\t");
            if("0".equals(splitArr[1])){
               continue;
            }
            if(splitArr[4].contains("/member/common/actlogin")){
               CloseableHttpClient httpclient = HttpClients.createDefault();
               String url = "http://10.13.0.16:8020/eai.financial.logic.message.wsp";
               HttpPost post = new HttpPost(url);
               List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
               listPram.add(new BasicNameValuePair("link_id", splitArr[3]));
               listPram.add(new BasicNameValuePair("login_date", splitArr[1]));// 20151019103636时间戳
               listPram.add(new BasicNameValuePair("action", "pushSMS"));
               listPram.add(new BasicNameValuePair("format_cd", "json"));
               post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8"));
               System.out.println(EntityUtils.toString(post.getEntity()));
               CloseableHttpResponse response = httpclient.execute(post);
               HttpEntity entity = response.getEntity();
               if(entity != null){
                  String responseContent = EntityUtils.toString(entity);
                  String result = new String(responseContent.getBytes("utf-8"));
                  System.out.println(result);
               }
               System.out.println(splitArr[3]);
            }
            //System.out.println(line);
         }
      }catch(Exception e){
         System.out.println(e);
         e.printStackTrace();
      }
   }

   public static void main(String[] args){
      while(true){
         try{

            Thread.sleep(300);
            if(FileProperties.getFileProperties().isModify() && isOpen){
               TailUtil tail = new TailUtil();
               System.out.println("*********************一个线程开始*************************");
               Thread t = new Thread(tail);
               t.start();
               isOpen = false;
            }

         }catch(InterruptedException e){
            e.printStackTrace();
         }

      }

   }
}
