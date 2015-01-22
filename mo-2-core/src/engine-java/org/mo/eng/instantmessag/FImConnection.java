package org.mo.eng.instantmessag;

import org.mo.com.lang.FObject;

//============================================================
// <T>即时通讯链接。</T>
//============================================================
public abstract class FImConnection
      extends FObject
      implements
         IImConnection
{
   // 日志输出接口
   //private static ILogger _logger = RLogger.find(FImConnection.class);

   //============================================================
   // <T>构造即时通讯链接。</T>
   //============================================================
   public FImConnection(){
   }
}
