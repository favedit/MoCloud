package com.ahyc.eai.core.cockpit.projectmanage;

import java.util.ArrayList;
import java.util.List;

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

}
