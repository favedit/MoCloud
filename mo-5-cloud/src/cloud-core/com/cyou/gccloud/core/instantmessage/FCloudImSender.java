package com.cyou.gccloud.core.instantmessage;

import com.cyou.gccloud.common.TAsynBlock;
import java.net.InetAddress;
import java.util.LinkedList;
import java.util.Queue;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;
import org.mo.core.monitor.common.FAbstractMonitor;
import org.mo.eng.instantmessag.SImConnectParams;

public class FCloudImSender
      extends FAbstractMonitor
{

   private class SendCache
         extends TAsynBlock<SGcImMessage>
   {
   }

   @SuppressWarnings("unused")
   private static final int DefaultConnect = 10000;

   @SuppressWarnings("unused")
   private static final int DefaultInterval = 200;

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCloudImSender.class);

   private SendCache _sendCache = null;

   private Queue<SGcImMessage> _delayCache = new LinkedList<SGcImMessage>();

   private InetAddress _localAddress = null;

   private String _sendUrl;

   private String _connUrl;

   private int _delayCount = 6000;

   //private FCyouImSender _sender = null;

   private SImConnectParams _connectParams = null;

   public FCloudImSender(){
      _name = "cloud.im.sender";
      _valid = true;
      _interval = 10;
      _sendCache = new SendCache();
      //_sender = new FCyouImSender();
   }

   private void setup(){
      //_sender.setAddress(_localAddress);
      //_sender.setUrl(_connUrl, _sendUrl);
      //connect();
   }

   public boolean isConnected(){
      return null != _connectParams;
   }

   public SImConnectParams getImConnectParams(){

      if(isConnected()){
         return _connectParams.copy();
      }
      return null;
   }

   public String getDomain(){
      if(null != _connectParams){
         return _connectParams.domain();
      }
      return "";
   }

   @Override
   public void initialize(){
      setup();
      super.initialize();
   }

   public void setLocalAddress(InetAddress addr){
      _localAddress = addr;
      //_sender.setAddress(_localAddress);
   }

   public void setUrl(String connUrl,
                      String sendUrl){
      _connUrl = connUrl;
      _sendUrl = sendUrl;
      //_sender.setUrl(_connUrl, _sendUrl);
   }

   public void setDelayCount(int count){
      _delayCount = count;
   }

   public void send(SGcImMessage sms){
      _sendCache.offer(sms);
   }

   @Override
   public boolean onExecute(){

      if(!isConnected()){
         connect();
      }
      _sendCache.swap();
      if(isConnected()){

         SGcImMessage element = null;

         while((element = _delayCache.poll()) != null){
            doWork(element);
         }
         while((element = _sendCache.poll()) != null){
            doWork(element);
         }

      }else{
         Queue<SGcImMessage> delay = _sendCache.pollAll();
         if(null != delay && delay.size() > 0){

            int t = _delayCount - delay.size();

            if(_delayCache.size() <= t){//空间充足

               _delayCache.addAll(delay);

            }else if(t < 0){ //delay 多于最大数量

               while(delay.size() > _delayCount){
                  delay.poll();
               }
               _delayCache.clear();
               _delayCache.addAll(delay);
            }else{
               while(_delayCache.size() > t){
                  _delayCache.poll();
               }
               _delayCache.addAll(delay);
            }
         }
      }

      return super.onExecute();

   }

   private void doWork(SGcImMessage im){
      //_sender.setSendInfo(im.sourceId(), im.targetId(), im.targetPassport(), im.pack());
      //_sender.send();
   }

   private void connect(){
      @SuppressWarnings("unused") String param = String.format("local address={%s}, connect url={%s}, send url={%s}", ((null == _localAddress) ? "default" : _localAddress.getHostAddress()), _connUrl, _sendUrl);
      //String code = _sender.connect();

      //if(code != null){
      //   if(parse(code)){
      //      setInterval(DefaultInterval);
      //      _logger.print(this, "connect", "cloud im service connect.({1})", param);
      //   }
      //}else{
      //   setInterval(DefaultConnect);
      //   _logger.warn(this, "connect", "cloud im service connect false.({1})", param);
      //}
   }

   @SuppressWarnings("unused")
   private boolean parse(String code){

      try{

         FXmlDocument xdocument = new FXmlDocument();
         xdocument.loadString(code);
         FXmlNode root = xdocument.root();

         if(!root.name().equalsIgnoreCase("Service")){
            return false;
         }

         if(!root.get("result_cd", "").equalsIgnoreCase("success")){
            return false;
         }

         FXmlNode connNode = root.node(SImConnectParams.KeyNode);
         if(null == connNode){
            return false;
         }

         SImConnectParams conn = new SImConnectParams();
         conn.loadXml(connNode);

         _connectParams = conn;
      }catch(Exception e){
         _logger.warn(this, "parse", "cloud im service config parse false.({1})", e);
         return false;
      }
      return true;
   }
}
