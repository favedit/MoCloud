package org.mo.content.service.mobile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class TestFVersionService
{
   @Test
   public void testConnect() throws ClientProtocolException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.100:8020/eai.mobile.wsp";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("version_number", "4"));
      listPram.add(new BasicNameValuePair("app_os", "android"));
      // listPram.add(new BasicNameValuePair("mo-session-id",
      // "4649AD3AF9BFBBAE690C5DF6C0AF202C"));
      post.setHeader("mo-session-id", "59F0328E44D3FCE4BEFEEC709E337629");
      listPram.add(new BasicNameValuePair("action", "connect"));
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
      CloseableHttpResponse response = httpclient.execute(post);
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         String result = new String(responseContent.getBytes("utf-8"));
         System.out.println(result);
      }

   }

   @Test
   public void testDisconnect() throws ClientProtocolException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.100:8020/eai.mobile.wsp";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("version_number", "4"));
      listPram.add(new BasicNameValuePair("app_os", "android"));
      // listPram.add(new BasicNameValuePair("mo-session-id",
      // "4649AD3AF9BFBBAE690C5DF6C0AF202C"));
      post.setHeader("mo-session-id", "4649AD3AF9BFBBAE690C5DF6C0AF202C");
      listPram.add(new BasicNameValuePair("action", "disconnect"));
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
      CloseableHttpResponse response = httpclient.execute(post);
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         String result = new String(responseContent.getBytes("utf-8"));
         System.out.println(result);
      }

   }

}
