package com.cyou.gccloud.common.sms;

import com.cyou.gccloud.common.TAsynBlock;
import java.net.InetAddress;
import org.mo.core.monitor.common.FAbstractMonitor;
import org.mo.eng.sms.FSms;
import org.mo.external.network.gamecollege.internal.FCyouSmsSender;

public class FCloudSender
      extends FAbstractMonitor
{
   private SendCache _sendCache = null;

   private InetAddress _localAddress = null;

   private String _url = null;

   private FCyouSmsSender _sender = null;

   public FCloudSender(){
      _name = "cloud.sender";
      _valid = true;
      _interval = 10;
      _sendCache = new SendCache();
      _sender = new FCyouSmsSender();
   }

   @Override
   public void initialize(){

      _sender.setAddress(_localAddress);
      _sender.setUrl(_url);
      super.initialize();
   }

   public void setLocalAddress(InetAddress addr){
      _localAddress = addr;
      _sender.setAddress(_localAddress);
   }

   public void setUrl(String url){
      _url = url;
      _sender.setUrl(_url);
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
      _sender.setSendInfo(sms.note(), sms.code());
      _sender.send();
   }

   private class SendCache
         extends TAsynBlock<FSms>
   {
   }
}
