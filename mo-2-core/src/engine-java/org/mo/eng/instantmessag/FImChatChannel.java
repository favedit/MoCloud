package org.mo.eng.instantmessag;

import org.mo.com.lang.FObject;

//============================================================
// <T>即时通讯聊天通道。</T>
//============================================================
public abstract class FImChatChannel
      extends FObject
      implements
         IImChatChannel
{
   // 日志输出接口
   //private static ILogger _logger = RLogger.find(FImChatChannel.class);

   // 即时通讯链接
   protected FImConnection _connection;

   //============================================================
   // <T>构造即时通讯聊天通道。</T>
   //============================================================
   public FImChatChannel(){
   }

   //============================================================
   // <T>构造即时通讯聊天通道。</T>
   //
   // @param connection 即时通讯链接
   //============================================================
   public FImChatChannel(FImConnection connection){
      _connection = connection;
   }

   //============================================================
   // <T>获得即时通讯链接。</T>
   //
   // @return 即时通讯链接
   //============================================================
   public FImConnection connection(){
      return _connection;
   }

   //============================================================
   // <T>设置即时通讯链接。</T>
   //
   // @param connection 即时通讯链接
   //============================================================
   public void setConnection(FImConnection connection){
      _connection = connection;
   }
}
