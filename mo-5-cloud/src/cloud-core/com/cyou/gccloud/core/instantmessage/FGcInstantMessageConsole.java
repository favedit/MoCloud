package com.cyou.gccloud.core.instantmessage;

import org.mo.com.lang.EResult;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.core.monitor.IMonitorConsole;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.instantmessag.IImConnection;
import org.mo.eng.instantmessag.SImConnectParams;
import org.mo.eng.instantmessag.SImLoginParams;
import org.mo.external.network.xmpp.smack.FXmppConnection;

//============================================================
// <T>即时消息控制台。</T>
//============================================================
public class FGcInstantMessageConsole
      extends FGcInstantMessageBase
      implements
         IGcInstantMessageConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FGcInstantMessageConsole.class);

   // 主机地址
   @AProperty(name = "host")
   protected String _host;

   // 主机端口
   @AProperty(name = "port")
   protected int _port;

   // 主域
   @AProperty(name = "domain")
   protected String _domain;

   // 账号
   @AProperty(name = "passport")
   protected String _passport;

   // 密码
   @AProperty(name = "password")
   protected String _password;

   // 资源
   @AProperty(name = "resource")
   protected String _resource;

   // 消息集合
   protected SGcImMessages _messages = new SGcImMessages();

   // 发送监视器
   protected FGcInstantMessageSendMonitor _sendMonitor;

   // 连接参数
   protected SImConnectParams _connectParams;

   //登录参数
   protected SImLoginParams _loginParams;

   // 账号链接
   protected IImConnection _accountConnection;

   // 聊天链接
   protected IImConnection _chatConnection;

   @ALink
   protected IMonitorConsole _monitorConsole;

   //============================================================
   // <T>获得账号链接。</T>
   //
   // @return 账号链接
   //============================================================
   public IImConnection accountConnection(){
      return _accountConnection;
   }

   //============================================================
   // <T>获得聊天链接。</T>
   //
   // @return 聊天链接
   //============================================================
   public IImConnection chatConnection(){
      return _chatConnection;
   }

   //============================================================
   // <T>初始化处理。</T>
   //============================================================
   public void initialize(){
      // 检查设置
      if(!_enable){
         _logger.info(this, "initialize", "Initialize instant messag skip.");
         return;
      }
      // 设置参数
      _connectParams = new SImConnectParams();
      _connectParams.setHost(_host);
      _connectParams.setPort(_port);
      _connectParams.setDomain(_domain);
      // 创建账号管理链接
      _accountConnection = new FXmppConnection();
      _accountConnection.connect(_connectParams);
      // 创建聊天管理链接
      _chatConnection = new FXmppConnection();
      // _chatConnection.connect(_connectParams);
      // 登录聊天管理连接
      _loginParams = new SImLoginParams();
      _loginParams.setPassport(_passport);
      _loginParams.setPassword(_password);
      _loginParams.setResource(_resource);
      //_chatConnection.login(_loginParams);

      _sendMonitor = new FGcInstantMessageSendMonitor(this);
      _monitorConsole.register(_sendMonitor);
   }

   @Override
   public SImConnectParams getImConnectParams(){
      SImConnectParams cf = new SImConnectParams();
      cf.setDomain(_domain);
      cf.setHost(_host);
      cf.setPort(_port);
      return cf;
   }

   //============================================================
   // <T>链接用户信息。</T>
   //
   // @param sqlContext 数据环境
   // @param userId 用户编号
   // @param xconfig 配置信息
   // @return 处理结果
   //============================================================
   @Override
   public EResult connectUser(ILogicContext logicContext,
                              long userId,
                              FXmlNode xconfig){
      return EResult.Failure;
   }

   //============================================================
   // <T>推送信息。</T>
   //
   // @param sqlContext 数据环境
   // @param message 消息对象
   // @return 处理结果
   //============================================================
   @Override
   public EResult pushMessage(ILogicContext logicContext,
                              SGcImMessage message){
      EResult resultCd = EResult.Failure;
      // 检查允许
      if(!_enable){
         return resultCd;
      }

      // 送入队列
      synchronized(_messages){
         _messages.push(message);
         resultCd = EResult.Success;
      }

      return resultCd;
   }

   //============================================================
   // <T>获取信息集合。</T>
   //
   // @param messages 消息集合
   // @return 处理结果
   //============================================================
   public void fetchMessages(SGcImMessages messages){
      synchronized(_messages){
         messages.append(_messages);
         _messages.clear();
      }
   }

   //============================================================
   // <T>是否连接。</T>
   //
   // @return 处理结果
   //============================================================

   public boolean isConnected(){
      if(_chatConnection != null){
         return _chatConnection.isConnected();
      }
      return false;
   }

   //============================================================
   // <T>是否连接。</T>
   //
   // @return 处理结果
   //============================================================

   public void connect(){
      if(null != _chatConnection){
         if(isConnected()){
            _chatConnection.disconnect();
         }
         _chatConnection.connect(_connectParams);
         // 登录聊天管理连接
         _chatConnection.login(_loginParams);
      }
   }
}
