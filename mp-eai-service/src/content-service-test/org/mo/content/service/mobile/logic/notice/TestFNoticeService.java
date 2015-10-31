package org.mo.content.service.mobile.logic.notice;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class TestFNoticeService
{
   @Test
   public void testSelect() throws ParseException, IOException, NoSuchAlgorithmException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.16:8020/eai.mobile.logic.notice.wsp";
      // String url = "http://eai.ezubo.com:8089/eai.mobile.logic.notice.wsp";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("page_size", "111"));
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      listPram.add(new BasicNameValuePair("page_number", "1"));
      listPram.add(new BasicNameValuePair("action", "select"));
      post.setHeader("mo-session-id", "BEE9D1B8C75D9124331E5745EC421023");
      post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
      CloseableHttpResponse response = httpclient.execute(post);
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         String result = new String(responseContent.getBytes("utf-8"));
         System.out.println(result);
      }

      MessageDigest instance = MessageDigest.getInstance("MD5");
      String name = "田禄";
      byte[] data = instance.digest(name.getBytes("UTF-8"));
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < data.length; i++){
         sb.append(Integer.toHexString(0xff & data[i]));
      }
      System.out.println(sb.toString());
   }

   @Test
   public void testMarkRead() throws ParseException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.16:8020/eai.mobile.logic.notice.wsp";
      // String url = "http://eai.ezubo.com:8089/eai.mobile.logic.news.wsp";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      listPram.add(new BasicNameValuePair("action", "markRead"));
      // 纬度
      listPram.add(new BasicNameValuePair("location_latitude", "11.3"));
      // 经度
      listPram.add(new BasicNameValuePair("location_longitude", "15.6"));
      listPram.add(new BasicNameValuePair("notice_id", "9EECE08E649C49CC982414BEBB511C78"));
      post.setHeader("mo-session-id", "BEE9D1B8C75D9124331E5745EC421023");
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
   public void noticePublish() throws ParseException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.16:8020/eai.mobile.logic.notice.wsp";
      // String url = "http://eai.ezubo.com:8089/eai.mobile.logic.news.wsp";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      listPram.add(new BasicNameValuePair("action", "noticePublish"));
      listPram.add(new BasicNameValuePair("label", "紧急号令"));
      listPram.add(new BasicNameValuePair("content", "全体员工请务必下午三点准时到北京国际大厦开会!!"));
      post.setHeader("mo-session-id", "5E4137EB3AD343507454DC0719502E8D");
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
