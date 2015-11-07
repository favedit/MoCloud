package com.ahyc.eai.core.cockpit.projectmanage;

import java.util.ArrayList;
import java.util.List;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

//============================================================
// <T>项目管理模型。</T>
//============================================================
public class FProjectManageModel
{
   // 项目名称
   private String _name;

   // 责任人
   private String _uname;

   // 优先级 0-低 1-中 2-高
   private String _priority;

   // 状态指示
   private String _status;

   //进度  时间进度和项目进度
   private List<FProjectProgressModel> _progresses;

   public FProjectManageModel(){
      this._progresses = new ArrayList<FProjectProgressModel>();
   }

   public String name(){
      return _name;
   }

   public void setName(String _name){
      this._name = _name;
   }

   public String uname(){
      return _uname;
   }

   public void setUname(String _uname){
      this._uname = _uname;
   }

   public String priority(){
      return _priority;
   }

   public void setPriority(String _priority){
      this._priority = _priority;
   }

   public String status(){
      return _status;
   }

   public void setStatus(String _status){
      this._status = _status;
   }

   public List<FProjectProgressModel> progresses(){
      return _progresses;
   }

   public void setProgresses(List<FProjectProgressModel> _progresses){
      this._progresses = _progresses;
   }

   public List<FProjectManageModel> fetch(String json){
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
