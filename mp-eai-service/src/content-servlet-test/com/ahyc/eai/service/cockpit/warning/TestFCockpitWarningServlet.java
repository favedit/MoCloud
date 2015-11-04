package com.ahyc.eai.service.cockpit.warning;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
      String url = "http://10.13.0.16:8020/eai.cockpit.instrumentpanel.wv";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      //      listPram.add(new BasicNameValuePair("begin", "33"));
      //      post.setHeader("sign", "77BEFC569B9E4CE5A65B34B8C1E89333");
      listPram.add(new BasicNameValuePair("do", "fetch"));
      listPram.add(new BasicNameValuePair("sign", "842367349"));
      listPram.add(new BasicNameValuePair("begin", "2015103033101000"));
      listPram.add(new BasicNameValuePair("end", "20151030101100"));
      post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
      System.out.println(EntityUtils.toString(post.getEntity()));
      CloseableHttpResponse response = httpclient.execute(post);
      HttpEntity entity = response.getEntity();
      InputStream in = entity.getContent();
      int a = -1;
      ByteArrayOutputStream out = new ByteArrayOutputStream();
      int i = 0;
      while((a = in.read()) != -1){
         out.write(a);
         i++;
      }
      System.out.println("-------------------->" + i);
      System.out.println(new String(out.toByteArray(), "utf-8"));
   }

   @Test
   public void test(){
      System.out.println(11 & 0xff);
   }
}
