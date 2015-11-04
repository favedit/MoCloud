package org.mo.content.service.mobile.logic.salestools;

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
public class TestFSalesToolsService
{
   @Test
   public void testSelect() throws ParseException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      // http://eai.ezubo.com:8089/eai.mobile.logic.salestools.wsp
      String url2 = "http://10.13.0.16:8020/eai.mobile.logic.salestools.wsp";
      // String url =
      // "http://eai.ezubo.com:8089/eai.mobile.logic.salestools.wsp";
      // String url3 =
      // "http://10.13.0.250:8020/eai.mobile.logic.salestools.wsp";
      HttpPost post = new HttpPost(url2);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("page_size", "111"));
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      listPram.add(new BasicNameValuePair("page_number", "1"));
      listPram.add(new BasicNameValuePair("action", "select"));
      post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8"));
      CloseableHttpResponse response = httpclient.execute(post);
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

   @Test
   public void testMarkRead() throws ParseException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.16:8020/eai.mobile.logic.salestools.wsp";
      // String url = "http://eai.ezubo.com:8089/eai.mobile.logic.news.wsp";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      listPram.add(new BasicNameValuePair("action", "markRead"));
      listPram.add(new BasicNameValuePair("salestools_id", "B8C05117E0BD4471A748CF1A08F041A2"));
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
