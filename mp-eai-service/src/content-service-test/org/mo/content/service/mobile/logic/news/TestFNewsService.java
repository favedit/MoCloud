package org.mo.content.service.mobile.logic.news;

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

public class TestFNewsService
{
   @Test
   public void testSelect() throws ParseException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.100:8020/eai.mobile.logic.news.wsp";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("page_size", "9"));
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      listPram.add(new BasicNameValuePair("page_number", "1"));
      listPram.add(new BasicNameValuePair("action", "select"));
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
   public void testQuery() throws ParseException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.100:8020/eai.mobile.logic.news.wsp";
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

}
