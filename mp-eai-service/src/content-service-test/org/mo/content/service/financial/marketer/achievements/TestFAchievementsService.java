package org.mo.content.service.financial.marketer.achievements;

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
import org.mo.com.lang.RUuid;

public class TestFAchievementsService
{

   @Test
   public void month() throws ClientProtocolException, IOException{

      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.27:8020/eai.financial.marketer.achievements.wsp";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("session_code", "beb7e325a2aa41d499b4d0dd81cb80b5"));
      System.out.println(RUuid.makeUuidUpper());
      //      listPram.add(new BasicNameValuePair("login_date", new TDateTime(new Date()).toString()));// 20151019103636时间戳
      // listPram.add(new BasicNameValuePair("mo-session-id",
      // "4649AD3AF9BFBBAE690C5DF6C0AF202C"));
      //      post.setHeader("mo-session-id", "77BEFC569B9E4CE5A65B34B8C1E89333");
      listPram.add(new BasicNameValuePair("action", "month"));
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
      System.out.println(url + "?" + EntityUtils.toString(post.getEntity()));
      CloseableHttpResponse response = httpclient.execute(post);
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         String result = new String(responseContent.getBytes("utf-8"));
         System.out.println(result);
      }

   }

   @Test
   public void fetchProducts() throws ClientProtocolException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.27:8020/eai.financial.marketer.achievements.wsp";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("session_code", "9cbf1e4011c84da7858c68858ba120e1"));
      //      listPram.add(new BasicNameValuePair("login_date", new TDateTime(new Date()).toString()));// 20151019103636时间戳
      // listPram.add(new BasicNameValuePair("mo-session-id",
      // "4649AD3AF9BFBBAE690C5DF6C0AF202C"));
      //      post.setHeader("mo-session-id", "77BEFC569B9E4CE5A65B34B8C1E89333");
      listPram.add(new BasicNameValuePair("action", "fetchProducts"));
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
      System.out.println(url + "?" + EntityUtils.toString(post.getEntity()));
      CloseableHttpResponse response = httpclient.execute(post);
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         String result = new String(responseContent.getBytes("utf-8"));
         System.out.println(result);
      }

   }

   @Test
   public void fetchCount() throws ClientProtocolException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.27:8020/eai.financial.marketer.achievements.wsp";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("session_code", "9cbf1e4011c84da7858c68858ba120e1"));
      //      listPram.add(new BasicNameValuePair("login_date", new TDateTime(new Date()).toString()));// 20151019103636时间戳
      // listPram.add(new BasicNameValuePair("mo-session-id",
      // "4649AD3AF9BFBBAE690C5DF6C0AF202C"));
      //      post.setHeader("mo-session-id", "77BEFC569B9E4CE5A65B34B8C1E89333");
      listPram.add(new BasicNameValuePair("action", "fetchCount"));
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
      System.out.println(url + "?" + EntityUtils.toString(post.getEntity()));
      CloseableHttpResponse response = httpclient.execute(post);
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         String result = new String(responseContent.getBytes("utf-8"));
         System.out.println(result);
      }
   }

   @Test
   public void fetchActions() throws ClientProtocolException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.27:8020/eai.financial.marketer.achievements.wsp";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("session_code", "beb7e325a2aa41d499b4d0dd81cb80b5"));
      //      listPram.add(new BasicNameValuePair("login_date", new TDateTime(new Date()).toString()));// 20151019103636时间戳
      // listPram.add(new BasicNameValuePair("mo-session-id",
      // "4649AD3AF9BFBBAE690C5DF6C0AF202C"));
      //      post.setHeader("mo-session-id", "77BEFC569B9E4CE5A65B34B8C1E89333");
      listPram.add(new BasicNameValuePair("action", "fetchActions"));
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
      System.out.println(url + "?" + EntityUtils.toString(post.getEntity()));
      CloseableHttpResponse response = httpclient.execute(post);
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         String result = new String(responseContent.getBytes("utf-8"));
         System.out.println(result);
      }

   }
}
