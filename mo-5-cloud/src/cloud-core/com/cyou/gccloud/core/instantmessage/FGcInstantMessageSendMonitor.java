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
public class FGcInstantMessageSendMonitor
      extends FAbstractMonitor
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FGcInstantMessageConsole.class);

   // 控制台
   protected FGcInstantMessageConsole _console;

   // 消息集合
   protected SGcImMessages _messages = new SGcImMessages();

   //============================================================
   // <T>构造消息监视器。</T>
   //============================================================
   public FGcInstantMessageSendMonitor(FGcInstantMessageConsole console){
      _valid = true;
      _console = console;
      _interval = 1000;
      _name = "instance.message.send.monitor";
   }

   //============================================================
   // <T>处理单个消息。</T>
   //
   // @param message 消息
   //============================================================
   protected void processMessage(SGcImMessage message){
      // 获得链接
      IImConnection connection = _console.chatConnection();
      // 获得聊天频道
      String passport = message.targetPassport();
      try(IImChatChannel chatChannel = connection.createChatChannel(passport)){
         if(chatChannel != null){
            // 发送信息
            String xml = message.pack();
            String json = RWebService.xml2json(xml);
            chatChannel.send(json);
            _logger.debug(this, "processMessage", "process messages.(source_id={1}, target_id={2},text={3})", message.sourceId(), message.targetId(), message.text());

         }else{
            _logger.warn(this, "processMessage", "Cannot create chat channel. (message={1})", message);
         }
      }catch(Exception e){
         _logger.debug(this, "processMessage", "Process messages failure. (message={1},error={2})", message, e.toString());
      }
   }

   private boolean _connectWarn = true;

   //============================================================
   // <T>逻辑处理。</T>
   //
   // @return 处理结果
   //============================================================
   @Override
   public boolean onExecute(){
      _console.fetchMessages(_messages);
      int count = _messages.count();
      if(count > 0){

         if(!_console.isConnected()){
            _console.connect();
         }
         if(_console.isConnected()){
            for(SGcImMessage message : _messages){
               processMessage(message);
            }
            _connectWarn = true;
         }else{
            if(!_connectWarn){
               _logger.warn(this, "onExecute", "im service connect false.");
               _connectWarn = false;
            }

         }

         _messages.clear();
         _logger.debug(this, "onExecute", "Process messages. (count={1})", count);
      }
      return super.onExecute();
   }
}
