package org.mo.content.face.mobile.logic.salestools;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class TestFSalesToolsAction
{
   @Test
   public void testGetInfo() throws ClientProtocolException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.100:8010/mobile/logic/salestools/SalesTools.wa?do=getInfo&guid=FE3814B38EA5477BAF6900FB927324B2";
      HttpGet post = new HttpGet(url);
      CloseableHttpResponse response = httpclient.execute(post);
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         String result = new String(responseContent.getBytes("utf-8"));
         System.out.println(result);
      }

   }

   @Test
   public void testGetContent() throws ClientProtocolException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.100:8010/mobile/logic/salestools/SalesTools.wa?do=getContent&guid=B8C05117E0BD4471A748CF1A08F041A2";
      HttpGet post = new HttpGet(url);
      CloseableHttpResponse response = httpclient.execute(post);
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         String result = new String(responseContent.getBytes("utf-8"));
         System.out.println(result);
      }
   }

   @Test
   public void testGetGroupInfo() throws ClientProtocolException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.100:8010/mobile/logic/salestools/SalesTools.wa?do=getGroupInfo";
      HttpGet post = new HttpGet(url);
      CloseableHttpResponse response = httpclient.execute(post);
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         String result = new String(responseContent.getBytes("utf-8"));
         System.out.println(result);
      }
   }
}