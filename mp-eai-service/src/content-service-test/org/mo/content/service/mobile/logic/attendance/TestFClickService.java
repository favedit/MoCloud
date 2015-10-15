package org.mo.content.service.mobile.logic.attendance;

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

//============================================================
// <T>新闻服务。</T>
//============================================================
public class TestFClickService
{
   @Test
   public void testSign() throws ClientProtocolException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://10.13.0.100:8020/eai.mobile.logic.attendance.wsp";
      HttpPost post = new HttpPost(url);
      List<BasicNameValuePair> listPram = new ArrayList<BasicNameValuePair>();
      listPram.add(new BasicNameValuePair("action", "sign"));
      listPram.add(new BasicNameValuePair("format_cd", "json"));
      post.setHeader("mo-session-id", "BEE9D1B8C75D9124331E5745EC421083");
      listPram.add(new BasicNameValuePair("date_time", "20151023123043"));
      // 经度
      listPram.add(new BasicNameValuePair("location_longitude", "116.366899"));
      // 纬度
      listPram.add(new BasicNameValuePair("location_latitude", "40.01978"));
      // listPram.add(new BasicNameValuePair("mo-session-id",
      // "4649AD3AF9BFBBAE690C5DF6C0AF202C"));
      // post.setHeader("UserGuid", "A860A0BCF8CD42EBBF696A86E7492951");
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
