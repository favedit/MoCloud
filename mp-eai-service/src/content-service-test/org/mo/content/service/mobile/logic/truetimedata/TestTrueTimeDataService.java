package org.mo.content.service.mobile.logic.truetimedata;

import java.io.IOException;
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

//============================================================
// <T>新闻服务。</T>
//============================================================
public class TestTrueTimeDataService
{
   @Test
   public void testSelect() throws ParseException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      // http://eai.ezubo.com:8089/eai.mobile.logic.salestools.wsp
      String url2 = "http://10.13.0.16:8020/eai.mobile.logic.truetimedata.wsp";
      // String url2 =
      // "http://eai.ezubo.com:8089/eai.mobile.logic.truetimedata.wsp";
      // String url3 =
      // "http://10.13.0.250:8020/eai.mobile.logic.salestools.wsp";
      HttpPost post = new HttpPost(url2);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("page_size", "10"));
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      listPram.add(new BasicNameValuePair("page_number", "1"));
      listPram.add(new BasicNameValuePair("action", "select"));
      post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8"));
      CloseableHttpResponse response = httpclient.execute(post);
      System.out.println(EntityUtils.toString(post.getEntity()));
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         String result = new String(responseContent.getBytes("utf-8"));
         System.out.println(result);
      }
   }

   @Test
   public void testQuery() throws ParseException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.100:8020/eai.mobile.logic.salestools.wsp";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      listPram.add(new BasicNameValuePair("guid", "FE3814B38EA5477BAF6900FB927324B2"));
      listPram.add(new BasicNameValuePair("action", "query"));
      post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
      CloseableHttpResponse response = httpclient.execute(post);
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         String result = new String(responseContent.getBytes("utf-8"));
         System.out.println(result);
      }
   }

   // http://10.13.0.250:88/mb/Mai.wa?do=mobileCustomer&mo-session-id=BC4AAFA353F7C89350B43918E8E6AF50
   @Test
   public void testTrueTimeDataAction() throws ParseException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.250:88/mb/Main.wa?do=mobileCustomer";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("action", "mobileCustomer"));
      post.setHeader("mo-session-id", "4960AC258E7B145A6419831B40C1D3A3");
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
   public void testMarkRead() throws ParseException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.16:8020/eai.mobile.logic.truetimedata.wsp";
      // String url = "http://eai.ezubo.com:8089/eai.mobile.logic.news.wsp";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      listPram.add(new BasicNameValuePair("action", "markRead"));
      listPram.add(new BasicNameValuePair("truetime_id", "FE3814B38EA5477BAF6900FB927324B2"));
      post.setHeader("mo-session-id", "beb7e325a2aa41d499b4d0dd81cb80b5");
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
