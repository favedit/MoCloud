package com.cyou.gccloud.core.instantmessage;

import com.cyou.gccloud.define.enums.core.EGcMessageContent;
import com.cyou.gccloud.define.enums.core.EGcMessageType;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>任务消息通知。</T>
//============================================================
public class SGcImTaskNotify
      extends SGcImNotify
{
   // 任务编号
   protected long _taskId;

   // 任务标题
   protected String _taskTitle;

   // 任务图标
   protected String _taskIconUrl;

   // 任务奖励
   protected int _taskPoint;

   // 任务奖励信息
   protected String _taskPointInfo;

   // 任务信息
   protected String _taskDescription;

   //============================================================
   // <T>构造任务消息通知。</T>
   //============================================================
   public SGcImTaskNotify(){
   }

   //============================================================
   // <T>获得任务编号。</T>
   //
   // @return 任务编号
   //============================================================
   public long taskId(){
      return _taskId;
   }

   //============================================================
   // <T>设置任务编号。</T>
   //
   // @param taskId 任务编号
   //============================================================
   public void setTaskId(long taskId){
      _taskId = taskId;
   }

   //============================================================
   // <T>获得任务标题。</T>
   //
   // @return 任务标题
   //============================================================
   public String taskTitle(){
      return _taskTitle;
   }

   //============================================================
   // <T>设置任务标题。</T>
   //
   // @param taskTitle 任务标题
   //============================================================
   public void setTaskTitle(String taskTitle){
      _taskTitle = taskTitle;
   }

   //============================================================
   // <T>获得任务图标。</T>
   //
   // @return 任务图标
   //============================================================
   public String taskIconUrl(){
      return _taskIconUrl;
   }

   //============================================================
   // <T>设置任务图标。</T>
   //
   // @param taskIconUrl 任务图标
   //============================================================
   public void setTaskIconUrl(String taskIconUrl){
      _taskIconUrl = taskIconUrl;
   }

   //============================================================
   // <T>获得任务奖励。</T>
   //
   // @return 任务奖励
   //============================================================
   public int taskPoint(){
      return _taskPoint;
   }

   //============================================================
   // <T>设置任务奖励。</T>
   //
   // @param taskPoint 任务奖励
   //============================================================
   public void setTaskPoint(int taskPoint){
      _taskPoint = taskPoint;
   }

   //============================================================
   // <T>获得任务奖励信息。</T>
   //
   // @return 任务奖励信息
   //============================================================
   public String taskPointInfo(){
      return _taskPointInfo;
   }

   //============================================================
   // <T>设置任务奖励信息。</T>
   //
   // @param taskPointInfo 任务奖励信息
   //============================================================
   public void setTaskPointInfo(String taskPointInfo){
      _taskPointInfo = taskPointInfo;
   }

   //============================================================
   // <T>获得任务描述。</T>
   //
   // @return 任务描述
   //============================================================
   public String taskDescription(){
      return _taskDescription;
   }

   //============================================================
   // <T>设置任务描述。</T>
   //
   // @param description 任务描述
   //============================================================
   public void setTaskDescription(String taskDescription){
      _taskDescription = taskDescription;
   }

   //============================================================
   // <T>生成打包内容。</T>
   //
   // @param text 文本
   //============================================================
   @Override
   public String pack(){
      // 设置属性
      FXmlNode xconfig = new FXmlNode("Config");
      xconfig.set("type_cd", EGcMessageType.Task);
      xconfig.set("content_cd", EGcMessageContent.Text);
      // 设置内容
      FXmlNode xtask = xconfig.createNode("Task");
      xtask.set("ouid", _taskId);
      xtask.set("label", _taskTitle);
      xtask.set("icon_url", _taskIconUrl);
      xtask.set("score_point", _taskPoint);
      xtask.set("score_point_info", _taskPointInfo);
      xtask.set("description", _taskDescription);
      return xconfig.xml().toString();
   }
}
