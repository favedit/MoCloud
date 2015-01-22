package com.cyou.gccloud.common.sms;

import com.cyou.gccloud.common.TAsynBlock;
import java.net.InetAddress;
import org.mo.core.monitor.common.FAbstractMonitor;
import org.mo.eng.sms.FSms;

class FDoveSender
      extends FAbstractMonitor
{
   private SendCache _sendCache = null;

   private InetAddress _localAddress = null;

   //private FDoveSmsSender _sender = null;

   public FDoveSender(){
      _name = "dove.sender";
      _valid = true;
      _interval = 10;
      _sendCache = new SendCache();
      //_sender = new FDoveSmsSender();
   }

   @Override
   public void initialize(){

      if(_localAddress != null){
         //_sender.setup(_localAddress);
      }
      super.initialize();
   }

   public void setLocalAddress(InetAddress addr){
      _localAddress = addr;
      //if(_sender != null){
      //_sender.setup(_localAddress);
      //}
   }

   public void send(FSms sms){
      _sendCache.offer(sms);
   }

   @Override
   public boolean onExecute(){

      _sendCache.swap();

      FSms element = null;
      while((element = _sendCache.poll()) != null){
         doWork(element);
      }
      return super.onExecute();
   }

   private void doWork(FSms sms){
      //_sender.setSendInfo(sms.note(), sms.code());
      //_sender.send();
   }

   private class SendCache
         extends TAsynBlock<FSms>
   {
   }
}
