package com.cyou.gccloud.common.sms;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.ALink;
import org.mo.core.monitor.IMonitorConsole;
import org.mo.eng.sms.FSms;
import org.mo.eng.sms.FSmsConsole;

public class FCloudSmsConsole
      extends FSmsConsole
{
   private FCloudSender _cloudSender = null;

   private static ILogger _logger = RLogger.find(FCloudSmsConsole.class);

   @ALink
   private IMonitorConsole _monitorConsole;

   public void initialize(){

      InetAddress localAddress = null;
      if(!RString.isEmpty(sendHost)){
         try{
            localAddress = InetAddress.getByName(sendHost);
         }catch(UnknownHostException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }

      _cloudSender = new FCloudSender();
      _cloudSender.setLocalAddress(localAddress);
      _cloudSender.setUrl(url);
      _monitorConsole.register(_cloudSender);

      _logger.print(this, "initialize", "dove sms service start.(local address={1})", (null == localAddress) ? "default" : sendHost);
   }

   @Override
   public void send(FSms sms){
      _cloudSender.send(sms);
   }

}
