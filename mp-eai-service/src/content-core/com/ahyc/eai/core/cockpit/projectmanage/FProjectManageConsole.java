package com.ahyc.eai.core.cockpit.projectmanage;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.mo.com.console.FConsole;
import org.mo.com.encoding.RMd5;

//============================================================
// <T>金融控制台。</T>
//============================================================
public class FProjectManageConsole
      extends FConsole
      implements
         IProjectManageConsole
{

   @Override
   public String getJson(String uid) throws ParseException, IOException{
      String result = "";
      uid = "3";
      String name = "d1e5ab7f41f7d25ce64" + uid + "e2036af314e26";
      String token = RMd5.encode(name).toLowerCase();
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://project.eai.ezubo.com/Api/get_projects?uid=" + uid + "&token=" + token;
      HttpGet get = new HttpGet(url);
      CloseableHttpResponse response = httpclient.execute(get);
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         result = new String(responseContent.getBytes("utf-8"));
      }
      return result;
   }
}
