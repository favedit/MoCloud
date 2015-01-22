package com.cyou.gccloud.core.instantmessage;

import com.cyou.gccloud.core.database.EGcDataConnection;
import com.cyou.gccloud.data.data.FDataPersonEntryLogic;
import com.cyou.gccloud.data.data.FDataPersonEntryUnit;
import com.cyou.gccloud.define.enums.core.EGcAccountSource;
import com.cyou.gccloud.define.enums.core.EGcPersonEntryStatus;
import com.cyou.gccloud.logic.person.FGcUserEntryInfo;
import com.cyou.gccloud.logic.person.FGcUserInfo;
import com.cyou.gccloud.logic.person.IGcUserConsole;
import com.cyou.gccloud.logic.person.IGcUserEntryConsole;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.mo.com.data.ISqlConnection;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RString;
import org.mo.com.lang.RUuid;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.core.monitor.IMonitorConsole;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.IDatabaseConsole;
import org.mo.eng.instantmessag.SImConnectParams;

public class FGcInstantMessageCloudConsole
      extends FGcInstantMessageBase
      implements
         IGcInstantMessageConsole
{
   // 发送地址
   @AProperty(name = "send_host")
   protected String _sendHost;

   //url
   @AProperty(name = "connect_url")
   protected String _connUrl;

   //url
   @AProperty(name = "send_url")
   protected String _sendUrl;

   @AProperty(name = "delay_count")
   protected int _delayCount = 5000;

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FGcInstantMessageCloudConsole.class);

   // 数据库控制台
   @ALink
   protected IDatabaseConsole _databaseConsole;

   // 用户控制台
   @ALink
   protected IGcUserConsole _userConsole;

   // 用户入口控制台
   @ALink
   protected IGcUserEntryConsole _userEntryConsole;

   @ALink
   private IMonitorConsole _monitorConsole;

   private FCloudImSender _cloudSender = null;

   //============================================================
   // <T>初始化处理。</T>
   //============================================================
   public void initialize(){
      InetAddress localAddress = null;
      if(!RString.isEmpty(_sendHost)){
         try{
            localAddress = InetAddress.getByName(_sendHost);
         }catch(UnknownHostException e){
            // TODO Auto-generated catch block
            e.printStackTrace();
         }
      }
      String param = String.format("local address={%s}, connect url={%s}, send url={%s}", ((null == localAddress) ? "default" : localAddress.getHostAddress()), _connUrl, _sendUrl);
      _logger.print(this, "initialize", "cloud im console initialize.({1})", param);

      _cloudSender = new FCloudImSender();
      _cloudSender.setLocalAddress(localAddress);
      _cloudSender.setUrl(_connUrl, _sendUrl);
      _cloudSender.setDelayCount(_delayCount);

      _monitorConsole.register(_cloudSender);

   }

   //============================================================
   // <T>链接用户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param xconfig 配置信息
   // @return 处理结果
   //============================================================
   @Override
   public EResult connectUser(ILogicContext logicContext,
                              long userId,
                              FXmlNode xconfig){
      EResult resultCd = EResult.Failure;
      // 检查允许
      if(_enable){
         FDataPersonEntryUnit entryUnit = findEntry(logicContext, userId);

         if(null == entryUnit){
            entryUnit = createAccount(logicContext, userId);
         }

         if(entryUnit != null){

            SImConnectParams cp = getImConnectParams();

            if(null != cp){
               FXmlNode xconnection = xconfig.createNode("XmppConnection");
               xconnection.set("host", cp.host());
               xconnection.set("port", cp.port());
               xconnection.set("domain", cp.domain());
               xconnection.set("passport", entryUnit.passport());
               xconnection.set("password", entryUnit.password());
               resultCd = EResult.Success;
            }
         }
      }

      return resultCd;
   }

   @Override
   public EResult pushMessage(ILogicContext logicContext,
                              SGcImMessage message){
      EResult resultCd = EResult.Failure;
      // 检查允许
      if(!_enable){
         return resultCd;
      }

      // 检查参数
      if(message == null){
         return resultCd;
      }

      // 目标类型
      long targetId = message.targetId();
      FDataPersonEntryUnit entryUnit = findEntry(logicContext, targetId);
      if(entryUnit != null){
         String entryPassport = makePassort(entryUnit.passport(), _cloudSender.getDomain());
         message.setTargetPassport(entryPassport);

         _cloudSender.send(message);
         resultCd = EResult.Success;
      }else{
         _logger.warn(this, "pushMessage", "Can't find person entry. (target_id={1})", targetId);
      }
      return resultCd;

   }

   @Override
   public SImConnectParams getImConnectParams(){

      return _cloudSender.getImConnectParams();
   }

   private FDataPersonEntryUnit createAccount(ILogicContext logicContext,
                                              long userId){
      FGcUserInfo userInfo = _userConsole.find(logicContext, userId, FGcUserInfo.class);
      if(null == userInfo){
         return null;
      }

      ISqlConnection connection = logicContext.activeConnection(EGcDataConnection.Ejabberd);
      if(null == connection){
         return null;
      }

      try{
         String passport = makePassort(userInfo);
         String password = RUuid.makeUniqueId();
         String sql = String.format("INSERT INTO `users` (username,password) VALUES ('%s','%s')", passport, password);
         if(connection.executeSql(sql)){
            // 新建记录
            FDataPersonEntryLogic entryLogic = logicContext.findLogic(FDataPersonEntryLogic.class);
            FGcUserEntryInfo entryInfo = entryLogic.doPrepare(FGcUserEntryInfo.class);
            entryInfo.setFromCd(EGcAccountSource.GameCollegeXmpp);
            entryInfo.setPassport(passport);
            entryInfo.setPassword(password);
            entryInfo.setStatusCd(EGcPersonEntryStatus.Normal);
            entryInfo.setUserId(userId);
            entryLogic.doInsert(entryInfo);
            return entryInfo;
         }

      }catch(Exception e){
         // TODO: handle exception
         _logger.print(this, "createAccount", "error:", e);
         return null;
      }
      return null;
   }

   //============================================================
   // <T>查找入口。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @return 入口节点
   //============================================================
   public FGcUserEntryInfo findEntry(ILogicContext logicContext,
                                     long userId){
      // 查找用户
      FGcUserInfo userInfo = _userConsole.find(logicContext, userId, FGcUserInfo.class);
      if(userInfo == null){
         return null;
      }
      String entryPassport = makePassort(userInfo);
      // 查找入口
      FGcUserEntryInfo entryInfo = _userEntryConsole.find(logicContext, EGcAccountSource.GameCollegeXmpp, entryPassport);
      return entryInfo;
   }
}
