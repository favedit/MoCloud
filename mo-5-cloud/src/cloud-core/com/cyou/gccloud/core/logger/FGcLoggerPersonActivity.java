package com.cyou.gccloud.core.logger;

import com.cyou.gccloud.define.enums.common.EGcLogger;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>用户活动日志。</T>
//============================================================
public class FGcLoggerPersonActivity
      extends FGcLogger
{
   // 活动编号
   protected long _activityId;

   // 用户编号
   protected long _userId;

   // 操作类型
   private int _operationCd;

   //============================================================
   // <T>构造用户活动日志。</T>
   //============================================================
   public FGcLoggerPersonActivity(){
      _typeCd = EGcLogger.PersonActivity;
   }

   //============================================================
   // <T>构造用户活动日志。</T>
   //
   // @param activityId 活动编号
   // @param userId 用户编号
   // @param operationCd 操作类型
   // @param parameters 参数集合
   //============================================================
   public FGcLoggerPersonActivity(long activityId,
                                  long userId,
                                  int operationCd,
                                  Object... parameters){
      _typeCd = EGcLogger.PersonActivity;
      _activityId = activityId;
      _userId = userId;
      _operationCd = operationCd;
      setAttributes(parameters);
   }

   //============================================================
   // <T>获得活动编号。</T>
   //
   // @return 活动编号
   //============================================================
   public long activityId(){
      return _activityId;
   }

   //============================================================
   // <T>设置活动编号。</T>
   //
   // @param activityId 活动编号
   //============================================================
   public void setActivityId(long activityId){
      _activityId = activityId;
   }

   //============================================================
   // <T>获得用户编号。</T>
   //
   // @return 用户编号
   //============================================================
   public long userId(){
      return _userId;
   }

   //============================================================
   // <T>设置用户编号。</T>
   //
   // @param userId 用户编号
   //============================================================
   public void setUserId(long userId){
      _userId = userId;
   }

   //============================================================
   // <T>获得操作类型。</T>
   //
   // @return 操作类型
   //============================================================
   public int operationCd(){
      return _operationCd;
   }

   //============================================================
   // <T>设置操作类型。</T>
   //
   // @param operationCd 操作类型
   //============================================================
   public void setOperationCd(int operationCd){
      _operationCd = operationCd;
   }

   //============================================================
   // <T>从配置节点中加载数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   @Override
   public void loadConfig(FXmlNode xconfig){
      super.loadConfig(xconfig);
      _activityId = xconfig.getLong("activity_id");
      _userId = xconfig.getLong("user_id");
      _operationCd = xconfig.getInt("operation_cd");
   }

   //============================================================
   // <T>向配置节点中保存数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   @Override
   public void saveConfig(FXmlNode xconfig){
      super.saveConfig(xconfig);
      xconfig.set("activity_id", _activityId);
      xconfig.set("user_id", _userId);
      xconfig.set("operation_cd", _operationCd);
   }
}
