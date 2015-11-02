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
      listPram.add(new BasicNameValuePair("sign", "842367349"));
      listPram.add(new BasicNameValuePair("begin", "2015103033101000"));
      listPram.add(new BasicNameValuePair("end", "20151030101100"));
      post.setEntity(new UrlEncodedFormEntity(listPram, "UTF-8")); // 执行get请求
      System.out.println(EntityUtils.toString(post.getEntity()));
      CloseableHttpResponse response = httpclient.execute(post);
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         String result = new String(responseContent.getBytes("UTF-8"));
         System.out.println(result);
      }

   }

   @Test
   public void test(){
      ArrayList<ArrayList<Object>> parent = new ArrayList<ArrayList<Object>>();
      ArrayList<Object> child1 = new ArrayList<Object>();
      child1.add("一诺财富");
      child1.add("300万到3600元");
      child1.add(1);
      ArrayList<Object> child2 = new ArrayList<Object>();
      child2.add("上海钰申");
      child2.add("300万到3600元");
      child2.add(2);
      ArrayList<Object> child3 = new ArrayList<Object>();
      child3.add("上海仁立");
      child3.add("300万到3600元");
      child3.add(3);
      parent.add(child1);
      parent.add(child2);
      parent.add(child3);
      for(ArrayList<Object> list : parent){
         for(Object obj : list){
            if(obj instanceof Integer){
               System.out.print((Integer)obj + " ");
            }
            if(obj instanceof String){
               System.out.print((String)obj + " ");
            }

         }
         System.out.println();
      }
   }

}
