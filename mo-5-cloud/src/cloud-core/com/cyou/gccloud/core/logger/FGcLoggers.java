package com.cyou.gccloud.core.logger;

import org.mo.com.lang.FObjects;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>日志集合。</T>
//============================================================
public class FGcLoggers
      extends FObjects<FGcLogger>
{
   //============================================================
   // <T>从配置节点中加载数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      //      for(FXmlNode xlogger : xconfig){
      //         if(xlogger.isName("Logger")){
      //            // 创建日志对象
      //            int typeCd = xlogger.getInt("type_cd");
      //            FGcLogger logger = null;
      //            switch(typeCd){
      //               case EGcLogger.SystemLogger:
      //                  logger = new FGcLoggerSystemLogger();
      //                  break;
      //               case EGcLogger.SystemException:
      //                  logger = new FGcLoggerSystemException();
      //                  break;
      //               case EGcLogger.PersonOperation:
      //                  logger = new FGcLoggerPersonOperation();
      //                  break;
      //               case EGcLogger.PersonActivity:
      //                  logger = new FGcLoggerPersonActivity();
      //                  break;
      //               case EGcLogger.ResourceOperation:
      //                  logger = new FGcLoggerResourceOperation();
      //                  break;
      //               default:
      //                  throw new FFatalError("Unknown logger type. (type_cd={1})", typeCd);
      //            }
      //            // 加载日志配置
      //            logger.loadConfig(xlogger);
      //            // 增加日志
      //            push(logger);
      //         }
      //      }
   }

   //============================================================
   // <T>向配置节点中保存数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      for(int n = 0; n < _count; n++){
         FXmlNode xlogger = xconfig.createNode("Logger");
         _items[n].saveConfig(xlogger);
      }
   }
}
