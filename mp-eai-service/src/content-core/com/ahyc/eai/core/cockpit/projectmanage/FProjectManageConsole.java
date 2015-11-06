package com.ahyc.eai.core.cockpit.projectmanage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
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
   public List<FProjectManageModel> fetch(){
      int uid = 3;
      String name = "d1e5ab7f41f7d25ce64" + uid + "e2036af314e26";
      String token = RMd5.encode(name).toLowerCase();
      CloseableHttpClient httpclient = HttpClients.createDefault();
      String url = "http://project.eai.ezubo.com/Api/get_projects?uid=" + uid + "&token=" + token;
      HttpGet get = new HttpGet(url);
      try{
         CloseableHttpResponse response = httpclient.execute(get);
         HttpEntity entity = response.getEntity();
         if(entity != null){
            String responseContent = EntityUtils.toString(entity);
            String result = new String(responseContent.getBytes("utf-8"));
         }
      }catch(ClientProtocolException e){
         e.printStackTrace();
      }catch(ParseException e){
         e.printStackTrace();
      }catch(UnsupportedEncodingException e){
         e.printStackTrace();
      }catch(IOException e){
         e.printStackTrace();
      }
      String jsonStr = "[{\"name\": \"视频会议\",\"uname\": \"窦卫群\",\"priority\": \"0\",\"status\": 0,\"progress\": [{\"key\": \"时间进度\",\"start_v\": \"2015-11-01\",\"end_v\": \"2015-12-31\",\"cur_v\": \"2015-11-06\",\"type\": \"时间\",\"is_show\": 1,\"progress\": 9,\"value\": \"2015-12-31\"},{\"key\": \"项目进度\",\"start_v\": \"35\",\"end_v\": \"100\",\"cur_v\": \"61\",\"type\": \"百分比\",\"is_show\": \"1\",\"progress\": 40,\"value\": \"61%\"}]},{\"name\": \"台账管理系统\",\"uname\": \"王丽娟\",\"priority\": \"0\",\"status\": 0,\"progress\": [{\"key\": \"时间进度\",\"start_v\": \"2015-11-01\",\"end_v\": \"2015-12-31\",\"cur_v\": \"2015-11-06\",\"type\": \"时间\",\"is_show\": 1,\"progress\": 9,\"value\": \"2015-12-31\"},{\"key\": \"项目进度\",\"start_v\": \"35\",\"end_v\": \"100\",\"cur_v\": \"61\",\"type\": \"百分比\",\"is_show\": \"1\",\"progress\": 40,\"value\": \"61%\"}]},{\"name\": \"视频会议\",\"uname\": \"窦卫群\",\"priority\": \"0\",\"status\": 0,\"progress\": [{\"key\": \"时间进度\",\"start_v\": \"2015-11-01\",\"end_v\": \"2015-12-31\",\"cur_v\": \"2015-11-06\",\"type\": \"时间\",\"is_show\": 1,\"progress\": 9,\"value\": \"2015-12-31\"},{\"key\": \"项目进度\",\"start_v\": \"35\",\"end_v\": \"100\",\"cur_v\": \"61\",\"type\": \"百分比\",\"is_show\": \"1\",\"progress\": 40,\"value\": \"61%\"}]}]";
      JSONArray jsonOutArray = JSONArray.fromObject(jsonStr);
      List<FProjectManageModel> lists = new ArrayList<FProjectManageModel>();
      for(int j = 0; j < jsonOutArray.size(); j++){
         JSONObject fromObject = jsonOutArray.getJSONObject(j);
         FProjectManageModel projectModel = new FProjectManageModel();
         List<FProjectProgressModel> progresses = projectModel.progresses();
         projectModel.setName(fromObject.get("name").toString());
         projectModel.setUname(fromObject.get("uname").toString());
         projectModel.setPriority(fromObject.get("priority").toString());
         projectModel.setStatus(fromObject.get("status").toString());
         JSONArray jsonInArray = fromObject.getJSONArray("progress");
         for(int i = 0; i < jsonInArray.size(); i++){
            FProjectProgressModel progressModel = new FProjectProgressModel();
            JSONObject jsonInObject = jsonInArray.getJSONObject(i);
            progressModel.setKey(jsonInObject.get("key").toString());
            progressModel.setStart_v(jsonInObject.get("start_v").toString());
            progressModel.setEnd_v(jsonInObject.get("end_v").toString());
            progressModel.setCur_v(jsonInObject.get("cur_v").toString());
            progressModel.setType(jsonInObject.get("type").toString());
            progressModel.setIs_show(jsonInObject.get("is_show").toString());
            progressModel.setProgress(jsonInObject.get("progress").toString());
            progressModel.setValue(jsonInObject.get("value").toString());
            progresses.add(progressModel);
         }
         lists.add(projectModel);
      }
      return lists;
   }
}
