package com.cyou.gccloud.core.logger;

import com.cyou.gccloud.define.enums.common.EGcLogger;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>用户操作日志。</T>
//============================================================
public class FGcLoggerPersonOperation
      extends FGcLogger
{
   // 用户编号
   protected long _userId;

   // 操作类型
   protected int _operationCd;

   //============================================================
   // <T>构造用户操作日志。</T>
   //============================================================
   public FGcLoggerPersonOperation(){
      _typeCd = EGcLogger.PersonOperation;
   }

   //============================================================
   // <T>构造用户操作日志。</T>
   //
   // @param userId 用户编号
   // @param operationCd 操作类型
   // @param parameters 参数集合
   //============================================================
   public FGcLoggerPersonOperation(long userId,
                                   int operationCd,
                                   Object... parameters){
      _typeCd = EGcLogger.PersonOperation;
      _userId = userId;
      _operationCd = operationCd;
      setAttributes(parameters);
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
      xconfig.set("user_id", _userId);
      xconfig.set("operation_cd", _operationCd);
   }
}
