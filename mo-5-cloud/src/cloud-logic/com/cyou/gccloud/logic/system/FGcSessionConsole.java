package com.cyou.gccloud.logic.system;

import com.cyou.gccloud.core.database.FAbstractLogicUnitConsole;
import com.cyou.gccloud.core.message.IGcMessageConsole;
import com.cyou.gccloud.core.storage.IGcStorageConsole;
import com.cyou.gccloud.data.cache.FCacheSystemSessionLogic;
import com.cyou.gccloud.data.cache.FCacheSystemSessionUnit;
import com.cyou.gccloud.define.enums.core.EGcSessionFrom;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.message.IMessageContext;
import org.mo.core.aop.face.ALink;
import org.mo.core.bind.IBindConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>用户控制台。</T>
//============================================================
public class FGcSessionConsole
      extends FAbstractLogicUnitConsole<FGcSessionInfo>
      implements
         IGcSessionConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FGcSessionConsole.class);

   // 消息控制台
   @ALink
   protected IGcMessageConsole _logicMessageConsole;

   // 绑定控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   // 绑定控制台
   @ALink
   protected IBindConsole _bindConsole;

   //============================================================
   // <T>构造用户控制台。</T>
   //============================================================
   public FGcSessionConsole(){
      super(FGcSessionInfo.class);
   }

   //============================================================
   // <T>创建逻辑单元</T>
   //
   // @param logicContext 逻辑环境
   // @return 逻辑单元
   //============================================================
   @Override
   protected FCacheSystemSessionLogic createLogic(ILogicContext logicContext){
      FCacheSystemSessionLogic sessionLogic = logicContext.findLogic(FCacheSystemSessionLogic.class);
      return sessionLogic;
   }

   //============================================================
   // <T>根据代码查找会话。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 会话集合
   //============================================================
   @Override
   public FGcSessionInfo findByCode(ILogicContext logicContext,
                                    String code){
      // 检查参数
      if(RString.isEmpty(code)){
         return null;
      }
      // 查找会话
      String whereSql = FCacheSystemSessionLogic.GUID + "='" + code + "'";
      FCacheSystemSessionLogic sessionLogic = logicContext.findLogic(FCacheSystemSessionLogic.class);
      FGcSessionInfo sessionInfo = sessionLogic.search(FGcSessionInfo.class, whereSql);
      return sessionInfo;
   }

   //============================================================
   // <T>根据用户编号查找会话集合。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @return 会话集合
   //============================================================
   @Override
   public FLogicDataset<FGcSessionInfo> findByUserId(ILogicContext logicContext,
                                                     long userId){
      String whereSql = "(" + FCacheSystemSessionLogic.USER_ID + "=" + userId + ") AND (" + FCacheSystemSessionLogic.OVLD + "=1)";
      FCacheSystemSessionLogic sessionLogic = logicContext.findLogic(FCacheSystemSessionLogic.class);
      FLogicDataset<FGcSessionInfo> sessionInfos = sessionLogic.fetchClass(FGcSessionInfo.class, whereSql, -1, -1);
      return sessionInfos;
   }

   //============================================================
   // <T>打开一个会话。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param sysAppCode 系统应用编号
   // @param deviceWidth 设备宽度
   // @param deviceHeight 设备高度
   // @return 会话信息
   //============================================================
   @Override
   public FGcSessionInfo open(ILogicContext logicContext,
                              long userId,
                              int sessionFrom,
                              String applicationCode,
                              int deviceWidth,
                              int deviceHeight){

      FCacheSystemSessionLogic sessionLogic = logicContext.findLogic(FCacheSystemSessionLogic.class);
      //判断用户ID是否为-1，如果为-1则为游客登陆，否则为正常登陆
      if(userId != 0){
         if(sessionFrom != EGcSessionFrom.Browser){
            close(sessionLogic, userId, sessionFrom);
         }
      }
      // 生成质量代码
      String qualityCode = _storageConsole.makeQualityCode(applicationCode, deviceWidth, deviceHeight);
      // 新建记录
      FGcSessionInfo sessionInfo = sessionLogic.doPrepare(FGcSessionInfo.class);
      //      FDataPersonConnectUnit unit = _accountsConsole.findConnectUnit(sqlContext, userId);
      //      if(null == unit){
      //         sessionInfo.setDeviceId(0);
      //      }else{
      //         sessionInfo.setDeviceId(unit.deviceId());
      //      }
      // 设置内容
      sessionInfo.setOvld(true);
      sessionInfo.setFromCd(sessionFrom);
      sessionInfo.setUserId(userId);
      sessionInfo.setDeviceQuality(qualityCode);
      sessionInfo.setDeviceWidth(deviceWidth);
      sessionInfo.setDeviceHeight(deviceHeight);
      sessionLogic.doInsert(sessionInfo);
      _logger.debug(this, "open", "Open session. (code={1})", sessionInfo.guid());
      // 绑定数据
      _bindConsole.bind(FGcSessionInfo.class, sessionInfo);
      // 返回结果
      return sessionInfo;
   }

   //============================================================
   // <T>验证一个会话是否有效。</T>
   //
   // @param messageContext 消息环境
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 会话信息
   //============================================================
   @Override
   public FGcSessionInfo verify(IMessageContext messageContext,
                                ILogicContext logicContext,
                                String code){
      // 检查参数
      if(RString.isEmpty(code)){
         _logicMessageConsole.throwError(messageContext, "E00103", code);
         return null;
      }
      // 新建记录
      String whereSql = "(" + FCacheSystemSessionLogic.GUID + "='" + code + "') AND (OVLD=1)";
      FCacheSystemSessionLogic sessionLogic = logicContext.findLogic(FCacheSystemSessionLogic.class);
      FGcSessionInfo sessionInfo = sessionLogic.search(FGcSessionInfo.class, whereSql);
      // 检查会话信息
      if(sessionInfo == null){
         _logicMessageConsole.throwError(messageContext, "E00103", code);
      }else if(!sessionInfo.ovld()){
         _logicMessageConsole.throwError(messageContext, "E00104", code);
      }
      // 绑定数据
      _bindConsole.bind(FGcSessionInfo.class, sessionInfo);
      return sessionInfo;
   }

   //============================================================
   // <T>验证一个会话是否有效。</T>
   //
   // @param messageContext 消息环境
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 会话信息
   //============================================================
   @Override
   public FGcSessionInfo verifySession(IMessageContext messageContext,
                                       ILogicContext logicContext,
                                       String code){
      // 检查参数
      if(RString.isEmpty(code)){
         _logicMessageConsole.throwError(messageContext, "E00103", code);
         return null;
      }
      // 新建记录
      String whereSql = "(" + FCacheSystemSessionLogic.GUID + "='" + code + "') AND (OVLD=1)";
      FCacheSystemSessionLogic sessionLogic = logicContext.findLogic(FCacheSystemSessionLogic.class);
      FGcSessionInfo sessionInfo = sessionLogic.search(FGcSessionInfo.class, whereSql);
      // 检查会话信息
      if(sessionInfo == null){
         _logicMessageConsole.pushError(messageContext, "E00103", code);
      }else if(!sessionInfo.ovld()){
         _logicMessageConsole.pushError(messageContext, "E00104", code);
      }
      // 绑定数据
      _bindConsole.bind(FGcSessionInfo.class, sessionInfo);
      return sessionInfo;
   }

   //============================================================
   // <T>验证一个会话是否登录。</T>
   //
   // @param messageContext 消息环境
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 会话信息
   //============================================================
   @Override
   public FGcSessionInfo verifyLogin(IMessageContext messageContext,
                                     ILogicContext logicContext,
                                     String code){
      // 检查参数
      if(RString.isEmpty(code)){
         _logicMessageConsole.throwError(messageContext, "E00103", code);
         return null;
      }
      // 新建记录
      String whereSql = "(" + FCacheSystemSessionLogic.GUID + "='" + code + "') AND (OVLD=1)";
      FCacheSystemSessionLogic sessionLogic = logicContext.findLogic(FCacheSystemSessionLogic.class);
      FGcSessionInfo sessionInfo = sessionLogic.search(FGcSessionInfo.class, whereSql);
      // 检查会话信息
      if(sessionInfo == null){
         _logicMessageConsole.pushError(messageContext, "E00103", code);
      }else if(!sessionInfo.ovld()){
         _logicMessageConsole.pushError(messageContext, "E00104", code);
      }
      // 绑定数据
      _bindConsole.bind(FGcSessionInfo.class, sessionInfo);
      return sessionInfo;
   }

   //============================================================
   // <T>关闭用户的会话。</T>
   //============================================================
   protected void close(FCacheSystemSessionLogic sessionLogic,
                        long userId){
      String whereSql = String.format("(USER_ID=%d) AND (OVLD=1)", userId);
      FLogicDataset<FCacheSystemSessionUnit> sessionUnits = sessionLogic.fetch(whereSql, 100, 0);
      if(sessionUnits != null){
         for(FCacheSystemSessionUnit unit : sessionUnits){
            sessionLogic.doDelete(unit);
         }
      }
   }

   //============================================================
   // <T>关闭用户的会话。</T>
   //============================================================
   protected void close(FCacheSystemSessionLogic sessionLogic,
                        long userId,
                        int sessionFrom){
      String whereSql = String.format("(USER_ID=%d) AND (FROM_CD=%d) AND (OVLD=1)", userId, sessionFrom);
      FLogicDataset<FCacheSystemSessionUnit> sessionUnits = sessionLogic.fetch(whereSql, 100, 0);
      if(sessionUnits != null){
         for(FCacheSystemSessionUnit unit : sessionUnits){
            sessionLogic.doDelete(unit);
         }
      }
   }

   protected void close(FCacheSystemSessionLogic sessionLogic,
                        FCacheSystemSessionUnit unit){
      sessionLogic.doDelete(unit);
   }

   //============================================================
   // <T>关闭指定代码的会话。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   //============================================================
   @Override
   public void close(ILogicContext logicContext,
                     String code){
      // 新建记录
      FCacheSystemSessionLogic sessionLogic = logicContext.findLogic(FCacheSystemSessionLogic.class);
      FCacheSystemSessionUnit sessionUnit = sessionLogic.search(FCacheSystemSessionLogic.GUID + "='" + code + "'");
      if(sessionUnit != null){
         //long ouid = sessionUnit.ouid();
         //sessionUnit.setOvld(false);
         //sessionLogic.doUpdate(sessionUnit, ouid);
         sessionLogic.doDelete(sessionUnit);
         _logger.debug(this, "close", "Close session. (code={1})", code);
      }else{
         _logger.warn(this, "close", "Session is not exists. (code={1})", code);
      }
   }

   //============================================================
   // <T>关闭指定用户的所有会话。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   //============================================================
   @Override
   public void close(ILogicContext logicContext,
                     long userId){
      FCacheSystemSessionLogic sessionLogic = logicContext.findLogic(FCacheSystemSessionLogic.class);
      close(sessionLogic, userId);
   }
}
