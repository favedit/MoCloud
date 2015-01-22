package com.cyou.gccloud.core.instantmessage;

import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.monitor.common.FAbstractMonitor;
import org.mo.eng.instantmessag.IImChatChannel;
import org.mo.eng.instantmessag.IImConnection;
import org.mo.web.core.service.common.RWebService;

//============================================================
// <T>消息监视器。</T>
//============================================================
public class FGcInstantMessageMonitor
      extends FAbstractMonitor
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FGcInstantMessageConsole.class);

   // 控制台
   protected FGcInstantMessageConsole _console;

   // 消息集合
   protected SGcImMessages _messages = new SGcImMessages();

   //private TAsynBlock<FXmppMessage> _cache;

   //protected LoginParam _loginParam;

   //protected FXmppConnection _pusher;

   //============================================================
   // <T>构造消息监视器。</T>
   //============================================================
   public FGcInstantMessageMonitor(FGcInstantMessageConsole console){
      _name = "instance.message.monitor";
      _console = console;
      _valid = true;
      _interval = 1000;
      //_cache = new TAsynBlock<FXmppMessage>();
      //_pusher = new FXmppConnection();
   }

   //============================================================
   // <T>处理单个消息。</T>
   //============================================================
   protected void processMessage(SGcImMessage message){
      // 获得链接
      IImConnection connection = _console.chatConnection();
      // 获得聊天频道
      String passport = message.targetPassport();
      IImChatChannel chatChannel = connection.syncChatChannel(passport);
      if(chatChannel != null){
         // 发送信息
         String xml = message.pack();
         String json = RWebService.xml2json(xml);
         chatChannel.send(json);
      }
   }

   //============================================================
   // <T>逻辑处理。</T>
   //============================================================
   @Override
   public boolean onExecute(){
      _console.fetchMessages(_messages);
      int count = _messages.count();
      if(count > 0){
         for(SGcImMessage message : _messages){
            processMessage(message);
         }
         _messages.clear();
         _logger.debug(this, "onExecute", "Process messages. (count={1})", count);
      }
      return super.onExecute();
   }
}
