package com.cyou.gccloud.core.logger;

import com.cyou.gccloud.define.enums.common.EGcLogger;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>资源操作日志。</T>
//============================================================
public class FGcLoggerResourceOperation
      extends FGcLogger
{
   // 资源编号
   protected long _resourceId;

   // 用户编号
   protected long _userId;

   // 操作类型
   private int _operationCd;

   //============================================================
   // <T>构造资源操作日志。</T>
   //============================================================
   public FGcLoggerResourceOperation(){
      _typeCd = EGcLogger.ResourceOperation;
   }

   //============================================================
   // <T>构造资源操作日志。</T>
   //
   // @param resourceId 资源编号
   // @param userId 用户编号
   // @param operationCd 操作类型
   // @param parameters 参数集合
   //============================================================
   public FGcLoggerResourceOperation(long resourceId,
                                     long userId,
                                     int operationCd,
                                     Object... parameters){
      _typeCd = EGcLogger.ResourceOperation;
      _resourceId = resourceId;
      _userId = userId;
      _operationCd = operationCd;
      setAttributes(parameters);
   }

   //============================================================
   // <T>获得资源编号。</T>
   //
   // @return 资源编号
   //============================================================
   public long resourceId(){
      return _resourceId;
   }

   //============================================================
   // <T>设置资源编号。</T>
   //
   // @param resourceId 资源编号
   //============================================================
   public void setResourceId(long resourceId){
      _resourceId = resourceId;
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
      _resourceId = xconfig.getLong("resource_id");
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
      xconfig.set("resource_id", _resourceId);
      xconfig.set("user_id", _userId);
      xconfig.set("operation_cd", _operationCd);
   }
}
