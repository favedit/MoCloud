package org.mo.cloud.core.logger;

import org.mo.cloud.common.datetime.IDateTimeConsole;
import org.mo.com.lang.EResult;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.RNet;
import org.mo.com.xml.FXmlConnection;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.core.monitor.IMonitorConsole;

//============================================================
// <T>日志控制台。</T>
//============================================================
public class FGcLoggerConsole
      implements
         IGcLoggerConsole
{
   // 日志输出接口
   private final static ILogger _logger = RLogger.find(FGcLoggerConsole.class);

   // 日志集合
   protected FGcLoggers _loggers = new FGcLoggers();

   // 允许标志
   @AProperty
   protected boolean _enable = true;

   // 服务代码
   @AProperty
   protected String _serverCode;

   // 日志间隔
   @AProperty
   protected long _loggerInterval = 1000;

   // 日志服务
   @AProperty
   protected String _loggerServicePublish;

   // 监视器
   protected FGcLoggerMonitor _monitor;

   // 日志监听器
   protected FGcLoggerListener _loggerListener;

   // 监视器控制台
   @ALink
   protected IMonitorConsole _monitorConsole;

   // 时间控制台
   @ALink
   protected IDateTimeConsole _dateTimeConsole;

   // 主机地址
   protected String _address;

   //============================================================
   // <T>获得服务代码。</T>
   //
   // @return 服务代码
   //============================================================
   @Override
   public String serverCode(){
      return _serverCode;
   }

   //============================================================
   // <T>增加一个日志。</T>
   //
   // @param logger 日志对象
   //============================================================
   @Override
   public EResult push(FGcLogger logger){
      // 检查允许
      if(!_enable){
         return EResult.Failure;
      }
      // 检查参数
      if(logger == null){
         return EResult.Failure;
      }
      // 设置参数
      logger.setServerCode(_serverCode);
      logger.setServerHost(_address);
      if(_dateTimeConsole != null){
         logger.setDateTime(_dateTimeConsole.currentTick());
      }
      // 增加日志
      synchronized(_loggers){
         _loggers.push(logger);
      }
      return EResult.Success;
   }

   //============================================================
   // <T>获取日志集合。</T>
   //
   // @param loggers 日志集合
   //============================================================
   public void fetch(FGcLoggers loggers){
      synchronized(_loggers){
         loggers.assign(_loggers);
         _loggers.clear();
      }
   }

   //============================================================
   // <T>发送日志集合。</T>
   //
   // @param loggers 日志集合
   //============================================================
   public boolean send(FGcLoggers loggers){
      // 检查参数
      if(loggers == null){
         return false;
      }
      if(loggers.isEmpty()){
         return false;
      }
      //............................................................
      // 发送数据
      FXmlNode xresult = null;
      try(FXmlConnection connection = new FXmlConnection(_loggerServicePublish)){
         // 存储信息
         FXmlNode xinput = connection.inputNode();
         loggers.saveConfig(xinput);
         // 发送处理
         xresult = connection.process("process");
      }catch(Exception e){
         _logger.debug(this, "send", "Send logger failure. (url={1})", _loggerServicePublish);
      }
      // 检查结果
      if(xresult != null){
         String resultCd = xresult.get("result_cd", "failure");
         if("success".equals(resultCd)){
            return true;
         }
      }
      return false;
   }

   //============================================================
   // <T>初始化处理。</T>
   //============================================================
   public void initialize(){
      if(_enable){
         // 部署日志监听
         _loggerListener = new FGcLoggerListener(this);
         RLogger.listeners().push(_loggerListener);
         // 获得本机地址
         try{
            _address = RNet.hostName();
         }catch(Exception exception){
            _logger.error(this, "initialize", exception);
         }
         // 部署监视器
         _monitor = new FGcLoggerMonitor(this);
         _monitor.setInterval(_loggerInterval);
         _monitorConsole.start(_monitor);
         _logger.debug(this, "initialize", "Cloud logger enable. (service={1})", _loggerServicePublish);
      }else{
         _logger.debug(this, "initialize", "Cloud logger disable.");
      }
   }
}
