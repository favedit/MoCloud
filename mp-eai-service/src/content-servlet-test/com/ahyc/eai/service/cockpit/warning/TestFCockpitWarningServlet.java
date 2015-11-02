package com.ahyc.eai.service.cockpit.warning;

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

public class TestFCockpitWarningServlet
{
   @Test
   public void testFetch() throws ParseException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.16:8020/eai.cockpit.warning.wv";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      //      listPram.add(new BasicNameValuePair("begin", "33"));
      //      post.setHeader("sign", "77BEFC569B9E4CE5A65B34B8C1E89333");
      listPram.add(new BasicNameValuePair("do", "fetch"));
      listPram.add(new BasicNameValuePair("sign", "146"));
      listPram.add(new BasicNameValuePair("begin", "20151030"));
      listPram.add(new BasicNameValuePair("end", "20151101"));
      post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
      System.out.println(EntityUtils.toString(post.getEntity()));
      CloseableHttpResponse response = httpclient.execute(post);
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         String result = new String(responseContent.getBytes("utf-8"));
         System.out.println(result);
      }

   }

}
