package com.ahyc.eai.service.cockpit.warning;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
   private InputStream content;

   @Test
   public void testFetch() throws ParseException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.16:8020/eai.cockpit.notice.wv";
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

      while((a = in.read()) != -1){
         out.write(a);
      }
      System.out.println(out.toString("UTF-8"));
   }

   @Test
   public void test(){
      ArrayList<Double[]> parent = new ArrayList<Double[]>();
      Double[] child0 = new Double[31];
      Double[] child1 = new Double[31];
      Double[] child2 = new Double[31];
      Double[] child3 = new Double[31];
      Double[] child4 = new Double[31];
      Double[] child5 = new Double[31];
      parent.add(child0);
      parent.add(child1);
      parent.add(child2);
      parent.add(child3);
      parent.add(child4);
      parent.add(child5);
      for(Double[] doubles : parent){
         for(int i = 0; i < doubles.length; i++){
            doubles[i] = Double.parseDouble(new DecimalFormat("#").format(Math.random() * 100000));
         }
      }
      int count = parent.size();
      for(Double[] doubles : parent){
         Arrays.toString(doubles);
      }
   }
}
