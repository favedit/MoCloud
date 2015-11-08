package com.ahyc.eai.service.cockpit.projectmanage;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

public class TestFCockpitProjectManageServlet
{
   @Test
   public void testProjectManage() throws ClientProtocolException, IOException{
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://project.eai.ezubo.com/Api/get_projects?uid=4&token=7410db727cfc94f55d1e444fcf2dd736";
      HttpGet get = new HttpGet(url);
      CloseableHttpResponse response = httpclient.execute(get);
      HttpEntity entity = response.getEntity();
      if(entity != null){
         String responseContent = EntityUtils.toString(entity);
         String result = new String(responseContent.getBytes("utf-8"));
         System.out.println(result);
      }else{
         System.out.println("null...........");
      }
   }

   @Test
   public void testMD5() throws ClientProtocolException, IOException, NoSuchAlgorithmException{
      MessageDigest instance = MessageDigest.getInstance("MD5");
      String str = "mo-session-id=5A3E4A00079E4752B06691BEAF69BE7&name=zhangsan&pwd=123456&app_key=0E144A4C9CA64FAB854FF2DE8B589312";
      byte[] datas = instance.digest(str.getBytes("UTF-8"));
      StringBuffer buf = new StringBuffer();
      for(int i = 0; i < datas.length; i++){
         int val = (datas[i]) & 0xff;
         if(val < 16){
            buf.append("0");
         }
         buf.append(Integer.toHexString(val));
      }
      System.out.println("encode:" + buf.toString());

      String jsonStr = "[{\"name\": \"视频会议\",\"uname\": \"窦卫群\",\"priority\": \"0\",\"status\": 0,\"progress\": [{\"key\": \"时间进度\",\"start_v\": \"2015-11-01\",\"end_v\": \"2015-12-31\",\"cur_v\": \"2015-11-06\",\"type\": \"时间\",\"is_show\": 1,\"progress\": 9,\"value\": \"2015-12-31\"},{\"key\": \"项目进度\",\"start_v\": \"35\",\"end_v\": \"100\",\"cur_v\": \"61\",\"type\": \"百分比\",\"is_show\": \"1\",\"progress\": 40,\"value\": \"61%\"}]},{\"name\": \"台账管理系统\",\"uname\": \"窦卫群\",\"priority\": \"0\",\"status\": 0,\"progress\": [{\"key\": \"时间进度\",\"start_v\": \"2015-11-01\",\"end_v\": \"2015-12-31\",\"cur_v\": \"2015-11-06\",\"type\": \"时间\",\"is_show\": 1,\"progress\": 9,\"value\": \"2015-12-31\"},{\"key\": \"项目进度\",\"start_v\": \"35\",\"end_v\": \"100\",\"cur_v\": \"61\",\"type\": \"百分比\",\"is_show\": \"1\",\"progress\": 40,\"value\": \"61%\"}]},{\"name\": \"视频会议\",\"uname\": \"窦卫群\",\"priority\": \"0\",\"status\": 0,\"progress\": [{\"key\": \"时间进度\",\"start_v\": \"2015-11-01\",\"end_v\": \"2015-12-31\",\"cur_v\": \"2015-11-06\",\"type\": \"时间\",\"is_show\": 1,\"progress\": 9,\"value\": \"2015-12-31\"},{\"key\": \"项目进度\",\"start_v\": \"35\",\"end_v\": \"100\",\"cur_v\": \"61\",\"type\": \"百分比\",\"is_show\": \"1\",\"progress\": 40,\"value\": \"61%\"}]},{\"name\": \"视频会议\",\"uname\": \"窦卫群\",\"priority\": \"0\",\"status\": 0,\"progress\": [{\"key\": \"时间进度\",\"start_v\": \"2015-11-01\",\"end_v\": \"2015-12-31\",\"cur_v\": \"2015-11-06\",\"type\": \"时间\",\"is_show\": 1,\"progress\": 9,\"value\": \"2015-12-31\"},{\"key\": \"项目进度\",\"start_v\": \"35\",\"end_v\": \"100\",\"cur_v\": \"61\",\"type\": \"百分比\",\"is_show\": \"1\",\"progress\": 40,\"value\": \"61%\"}]},{\"name\": \"视频会议\",\"uname\": \"窦卫群\",\"priority\": \"0\",\"status\": 0,\"progress\": [{\"key\": \"时间进度\",\"start_v\": \"2015-11-01\",\"end_v\": \"2015-12-31\",\"cur_v\": \"2015-11-06\",\"type\": \"时间\",\"is_show\": 1,\"progress\": 9,\"value\": \"2015-12-31\"},{\"key\": \"项目进度\",\"start_v\": \"35\",\"end_v\": \"100\",\"cur_v\": \"61\",\"type\": \"百分比\",\"is_show\": \"1\",\"progress\": 40,\"value\": \"61%\"}]}]";
      JSONArray jsonOutArray = JSONArray.fromObject(jsonStr);
      //      int count = jsonOutArray.size();
      for(int j = 0; j < jsonOutArray.size(); j++){
         //获取数据
         JSONObject fromObject = jsonOutArray.getJSONObject(j);
         String name = fromObject.get("name").toString();
         String uname = fromObject.get("uname").toString();
         String priority = fromObject.get("priority").toString();
         String status = fromObject.get("status").toString();
         //输出数据
         JSONArray jsonInArray = fromObject.getJSONArray("progress");
         for(int i = 0; i < jsonInArray.size(); i++){
            JSONObject jsonInObject = jsonInArray.getJSONObject(i);
            String key = jsonInObject.get("key").toString();
            String progress = jsonInObject.get("progress").toString();
            System.out.println("name:" + name + " uname:" + uname + " priority:" + priority + " :status:" + status + " key:" + key + " progress:" + progress);
         }
      }

   }
}
