package com.ahyc.eai.service.cockpit.projectmanage;

import com.ahyc.eai.core.cockpit.projectmanage.FProjectManageModel;
import com.ahyc.eai.core.cockpit.projectmanage.FProjectProgressModel;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import net.sf.json.JSONArray;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.mo.com.encoding.RMd5;

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
      int uid = 3;
      String name = "d1e5ab7f41f7d25ce64" + uid + "e2036af314e26";
      byte[] datas = instance.digest(name.getBytes("UTF-8"));
      StringBuffer buf = new StringBuffer();
      for(int i = 0; i < datas.length; i++){
         int val = (datas[i]) & 0xff;
         if(val < 16){
            buf.append("0");
         }
         buf.append(Integer.toHexString(val));
      }

      System.out.println(buf.toString() + "   ---" + buf.length());
      String aaaString = RMd5.encode(name).toLowerCase();

      System.out.println("--->" + aaaString + "  " + aaaString.length());
      String jsonStr = "[{\"name\": \"视频会议\",\"uname\": \"窦卫群\",\"priority\": \"0\",\"status\": 0,\"progress\": [{\"key\": \"时间进度\",\"start_v\": \"2015-11-01\",\"end_v\": \"2015-12-31\",\"cur_v\": \"2015-11-06\",\"type\": \"时间\",\"is_show\": 1,\"progress\": 9,\"value\": \"2015-12-31\"},{\"key\": \"项目进度\",\"start_v\": \"35\",\"end_v\": \"100\",\"cur_v\": \"61\",\"type\": \"百分比\",\"is_show\": \"1\",\"progress\": 40,\"value\": \"61%\"}]},{\"name\": \"视频会议\",\"uname\": \"窦卫群\",\"priority\": \"0\",\"status\": 0,\"progress\": [{\"key\": \"时间进度\",\"start_v\": \"2015-11-01\",\"end_v\": \"2015-12-31\",\"cur_v\": \"2015-11-06\",\"type\": \"时间\",\"is_show\": 1,\"progress\": 9,\"value\": \"2015-12-31\"},{\"key\": \"项目进度\",\"start_v\": \"35\",\"end_v\": \"100\",\"cur_v\": \"61\",\"type\": \"百分比\",\"is_show\": \"1\",\"progress\": 40,\"value\": \"61%\"}]},{\"name\": \"视频会议\",\"uname\": \"窦卫群\",\"priority\": \"0\",\"status\": 0,\"progress\": [{\"key\": \"时间进度\",\"start_v\": \"2015-11-01\",\"end_v\": \"2015-12-31\",\"cur_v\": \"2015-11-06\",\"type\": \"时间\",\"is_show\": 1,\"progress\": 9,\"value\": \"2015-12-31\"},{\"key\": \"项目进度\",\"start_v\": \"35\",\"end_v\": \"100\",\"cur_v\": \"61\",\"type\": \"百分比\",\"is_show\": \"1\",\"progress\": 40,\"value\": \"61%\"}]}]";
      //      JSONObject jsonObj = JSONObject.fromObject(jsonStr);

      Map<String, Class> classMap = new HashMap<String, Class>();
      classMap.put("progresses", FProjectProgressModel.class);
      JSONArray.toArray(JSONArray.fromObject(jsonStr), FProjectManageModel.class, classMap);
   }
}
