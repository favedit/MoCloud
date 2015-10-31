package org.mo.content.core.mobile.account;

import com.cyou.gccloud.data.data.FDataLogicNoticeLogic;
import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import com.cyou.gccloud.data.data.FDataPersonUserEntryLogic;
import com.cyou.gccloud.data.data.FDataPersonUserEntryUnit;
import com.cyou.gccloud.data.data.FDataPersonUserLogic;
import com.cyou.gccloud.data.data.FDataPersonUserSigningLogic;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.data.data.FDataSystemApplicationLogic;
import com.cyou.gccloud.data.data.FDataSystemApplicationUnit;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcAuthorityResult;
import com.cyou.gccloud.define.enums.core.EGcPersonUserFrom;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import com.ycjt.ead.ThreeDes;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import org.mo.cloud.core.web.FGcWebSession;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.collections.FRow;
import org.mo.com.data.FSql;
import org.mo.com.encoding.RMd5;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.net.http.FHttpConnection;
import org.mo.content.service.info.mobile.FMobileService;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.logic.logger.person.user.FLoggerPersonUserAccess;
import org.mo.eai.logic.logger.person.user.ILoggerPersonUserAccessConsole;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>登录控制台。</T>
//============================================================
public class FLoginConsole
      extends FObject
      implements
         ILoginConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMobileService.class);

   // 用户添加日志控制台
   @ALink
   protected ILoggerPersonUserAccessConsole _loggerPersonUserAccessConsole;

   // 从src/config/service/core.xml配置文件注入属性
   @AProperty
   protected boolean _oaLoginEnable;

   // 从src/config/service/core.xml配置文件注入属性
   @AProperty
   protected String _oaLoginUrl;

   // ============================================================
   // <T>构造资源</T>
   // ============================================================
   public FLoginConsole(){

   }

   // ============================================================
   // @登录逻辑处理
   // @param context 页面环境
   // @param passport 用户名
   // @param password 密码
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   // ============================================================
   @Override
   public FDataPersonUserUnit login(IWebContext context,
                                    String passport,
                                    String password,
                                    ILogicContext logicContext,
                                    IWebSession sessionContext){
      _logger.debug(null, "oaLogin************************------------>", "OA login. (_oaLoginUrl={1})", _oaLoginUrl);
      int statusCd = EGcAuthorityResult.OaHostInvalid;
      if(_oaLoginEnable){
         // OA用户检测
         String oaLoginResult = this.oaLogin(passport, password);
         _logger.debug(this, "doLogin", "OA login. (passport={1}, result={2})", passport, oaLoginResult);
         // 0:验证成功，1:签名不通过，3:用户名或密码错误，98:IP不在白名单中
         if(oaLoginResult.equals("0")){
            if(password.length() < 6){
               _logger.debug(this, "doLogin", "Login password length fial. (password={1})", password);
               statusCd = EGcAuthorityResult.PasswordLengthFail;
            }
            statusCd = EGcAuthorityResult.OaSuccess;
         }else if(oaLoginResult.equals("3")){
            statusCd = EGcAuthorityResult.OaPasswordInvald;
         }else if(oaLoginResult.equals("98")){
            statusCd = EGcAuthorityResult.OaHostInvalid;
         }
      }

      // 登录处理
      String message = null;
      String logggerMessage = null;
      String changePass = null;
      int from = 0;
      switch(statusCd){
         case EGcAuthorityResult.Success:
            changePass = "white-user:" + passport;
            from = EGcPersonUserFrom.EaiHost;
            logggerMessage = "mobile:登录成功。";
            break;
         case EGcAuthorityResult.PassportInvalid:
            logggerMessage = "mobile:账号不存在。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.PasswordInvalid:
            logggerMessage = "mobile:密码错误。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.DateInvalid:
            message = "时间已失效。";
            break;
         case EGcAuthorityResult.OaSuccess:
            changePass = "oa:" + passport;
            from = EGcPersonUserFrom.EaiOa;
            logggerMessage = "mobile:OA登录成功。";
            break;
         case EGcAuthorityResult.OaPasswordInvald:
            logggerMessage = "mobile:OA用户或密码错误。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.OaHostInvalid:
            logggerMessage = "mobile:OA主机非法。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.PassportIllegal:
            logggerMessage = "mobile:用户名非法特殊字符。";
            message = "用户名非法或含有特殊字符。";
            break;
         case EGcAuthorityResult.PasswordIllegal:
            logggerMessage = "mobile:密码非法特殊字符。";
            message = "密码非法或含有特殊字符。";
            break;
         case EGcAuthorityResult.PasswordLengthFail:
            logggerMessage = "mobile:密码长度小于6位。";
            message = "密码长度小于6位。";
            break;
      }
      _logger.info(this, "login", "User login. (passport={1}, message={1})", passport, logggerMessage);
      // 如果登录成功,同步数据
      FDataPersonUserUnit backUser = null;
      if((statusCd == EGcAuthorityResult.OaSuccess)){
         FDataPersonUserUnit unit = new FDataPersonUserUnit();
         unit.setStatusCd(statusCd);
         unit.setPassport(passport);
         unit.setPassword(password);
         unit.setNote(message);
         unit.setIconUrl("http://eai.ezubo.com/manage/images/userdefault.png");
         backUser = synchronizeData(logicContext, unit, from, changePass);
      }
      // 增加日志
      FLoggerPersonUserAccess logger = _loggerPersonUserAccessConsole.doPrepare(logicContext);
      logger.setUserId(1);
      logger.setLogicMessage(logggerMessage);
      logger.setPassport(RString.left(passport, 40));
      logger.setPassword(RString.left(password, 40));
      logger.setBrowserUri(context.requestUrl());
      logger.setPageInfo(context.parameters().dump());
      _loggerPersonUserAccessConsole.doInsert(logicContext, logger);

      if(backUser == null){
         backUser = new FDataPersonUserUnit();
         backUser.setStatusCd(statusCd);
      }
      return backUser;
   }

   // ============================================================
   // <T>请求OA登录接口</T>
   // @param url 接口链接
   // @param passport 用户名
   // @param password 密码
   // @return 登录结果（0：验证成功，1：签名不通过，2：参数不完整，3：用户名或密码错误，98：IP不在白名单中，99：系统异常）
   // ============================================================
   @Override
   public String oaLogin(String passport,
                         String password){
      // 设置参数
      String key = "ycjt*&^%$3fyg";
      String encodePassport = ThreeDes.encode(key, passport);
      String encodePassword = ThreeDes.encode(key, password);
      String appDate = String.valueOf(new Date().getTime());
      String from = "H5";
      String validate = RMd5.encode(encodePassport + encodePassword + appDate + from + key);
      // 拼装参数
      String parem = null;
      try{
         parem = "?username=" + URLEncoder.encode(encodePassport, "utf-8") + "&pwd=" + URLEncoder.encode(encodePassword, "utf-8") + "&appDate=" + appDate + "&from=" + from + "&validate=" + validate;
      }catch(Exception error){
         _logger.error(null, "oaLogin", error, "ROALoginUnit oaLogin", "OA login fail.");
      }
      _logger.debug(null, "ROALoginUnit oaLogin", "OA login. (url={1})", _oaLoginUrl + parem);
      // 发送请求
      String result = null;
      try(FHttpConnection connection = new FHttpConnection(_oaLoginUrl + parem)){
         result = connection.fetch();
      }
      return RString.trim(result);
   }

   // ============================================================
   // @同步oa用户到数据库中
   // @param logicContext 逻辑上下文
   // @param backUser oa接口返回的用户
   // @param from 是通过什么身份登录的系统
   // @param changePass 以何种身份登录的用户名
   // ============================================================
   @Override
   public FDataPersonUserUnit synchronizeData(ILogicContext logicContext,
                                              FDataPersonUserUnit backUser,
                                              int from,
                                              String changePass){
      // 创建一个零时用户
      FDataPersonUserUnit tempUserUnit = new FDataPersonUserUnit();
      tempUserUnit.setStatusCd(backUser.statusCd());
      tempUserUnit.setPassport(changePass);
      tempUserUnit.setOvld(true);
      tempUserUnit.setPassword(backUser.password());
      tempUserUnit.setIconUrl(backUser.iconUrl());
      // tempUserUnit.setGuid("A860A0BCF8CD42EBBF696A86E7492951");
      // tempUserUnit.setOuid(21);
      tempUserUnit.setLabel(backUser.passport());
      // userUnit.setLabel(value);
      FSql sql = new FSql();
      sql.append(FDataPersonUserLogic.PASSPORT);
      sql.append("='");
      sql.append(changePass);
      sql.append("'");
      FDataPersonUserLogic userLogic = logicContext.findLogic(FDataPersonUserLogic.class);
      FLogicDataset<FDataPersonUserUnit> findUserByGuids = userLogic.fetch(sql);

      FDataPersonUserEntryLogic userEntryLogic = logicContext.findLogic(FDataPersonUserEntryLogic.class);

      if(findUserByGuids == null || findUserByGuids.count() < 1){
         userLogic.doInsert(tempUserUnit);
         // 同步用户状态
         FDataPersonUserEntryUnit userEntryUnit = new FDataPersonUserEntryUnit();
         userEntryUnit.setOvld(true);
         userEntryUnit.setUserId(tempUserUnit.ouid());
         userEntryUnit.setStatusCd(tempUserUnit.statusCd());
         userEntryUnit.setFromCd(from);
         userEntryLogic.doInsert(userEntryUnit);
      }else{
         FDataPersonUserUnit findUserByGuid = findUserByGuids.first();
         findUserByGuid.setPassport(changePass);
         findUserByGuid.setPassword(tempUserUnit.password());
         findUserByGuid.setLabel(tempUserUnit.label());
         findUserByGuid.setStatusCd(tempUserUnit.statusCd());
         tempUserUnit.setOuid(findUserByGuid.ouid());
         userLogic.doUpdate(findUserByGuid);
         // 同步更新用户状态
         FSql whereSql = new FSql();
         whereSql.append(FDataPersonUserEntryLogic.USER_ID);
         whereSql.append("=");
         whereSql.append(findUserByGuid.ouid());
         FLogicDataset<FDataPersonUserEntryUnit> updateUserEntryUnits = userEntryLogic.fetch(whereSql);
         if(updateUserEntryUnits != null && updateUserEntryUnits.count() > 0){
            FDataPersonUserEntryUnit first = updateUserEntryUnits.first();
            first.setOvld(false);
            first.setUserId(findUserByGuid.ouid());
            first.setStatusCd(tempUserUnit.statusCd());
            first.setFromCd(from);
            userEntryLogic.doUpdate(first);
         }
      }
      return tempUserUnit;
   }

   // ============================================================
   // @注销
   // @param context 页面环境
   // @param sessionId sessionCode
   // @param logicContext 逻辑上下文
   // @param sessionContext session上下文
   // ============================================================
   @Override
   public FDataPersonUserUnit logout(IWebContext context,
                                     String sessionId,
                                     ILogicContext logicContext,
                                     IWebSession sessionContext){
      FDataPersonUserUnit fDataPersonUserUnit = new FDataPersonUserUnit();
      fDataPersonUserUnit.setStatusCd(0);
      return fDataPersonUserUnit;
   }

   // ============================================================
   // @根据guid查询用户
   // @param context 页面环境
   // @param userGuid 用户guid
   // @param logicContext 逻辑上下文
   // @param sessionContext session上下文
   // ============================================================
   @Override
   public FDataPersonUserUnit query(IWebContext context,
                                    String userGuid,
                                    ILogicContext logicContext,
                                    IWebSession sessionContext){
      FDataPersonUserLogic userLogic = logicContext.findLogic(FDataPersonUserLogic.class);
      FDataPersonUserUnit findUserByGuid = userLogic.findByGuid(userGuid);
      if(findUserByGuid == null){
         findUserByGuid = new FDataPersonUserUnit();
         findUserByGuid.setStatusCd(-1);
         return findUserByGuid;
      }else{
         return findUserByGuid;
      }
   }

   // ============================================================
   // @更新用户
   // @param context 页面环境
   // @param unit 用户
   // @param logicContext 逻辑上下文
   // @param sessionContext session上下文
   // ============================================================
   @Override
   public FDataPersonUserUnit update(IWebContext context,
                                     FDataPersonUserUnit unit,
                                     ILogicContext logicContext,
                                     IWebSession sessionContext){
      FDataPersonUserLogic userLogic = logicContext.findLogic(FDataPersonUserLogic.class);
      FDataPersonUserUnit findUserByGuid = userLogic.findByGuid(unit.guid());
      if(findUserByGuid == null){
         findUserByGuid = new FDataPersonUserUnit();
         findUserByGuid.setStatusCd(-1);
         return findUserByGuid;
      }else{
         // 先查找出来再更新标签
         findUserByGuid.setLabel(unit.label());
         userLogic.doUpdate(findUserByGuid);
         return findUserByGuid;
      }
   }

   // ============================================================
   // @获取已经登录的用户信息
   // @param user_id 用户id
   // @param logicContext 逻辑上下文
   // ============================================================
   @Override
   public FDataPersonUserInfo getUserInfo(long user_id,
                                          ILogicContext logicContext){
      FDataPersonUserInfo userInfo = new FDataPersonUserInfo();
      FDataPersonUserSigningLogic signingLogic = logicContext.findLogic(FDataPersonUserSigningLogic.class);
      FDataPersonUserLogic userLogic = logicContext.findLogic(FDataPersonUserLogic.class);
      FSql userFSql = new FSql();
      userFSql.append(FDataPersonUserLogic.OUID);
      userFSql.append("=");
      userFSql.append(user_id);
      FLogicDataset<FDataPersonUserInfo> userInfos = userLogic.fetchClass(FDataPersonUserInfo.class, userFSql);
      if(userInfos != null && userInfos.count() > 0){
         userInfo = userInfos.first();
      }

      // %Y-%m-%d %T
      String sql = "SELECT DATE_FORMAT(MAX(SINGN_DATE) ,'%Y-%m-%d %H:%i:%s') AS LAST_SIGN_DATE FROM DT_PSN_USER_SIGNING WHERE `USER_ID`=" + user_id;
      FRow rowData = signingLogic.connection().find(sql);
      String Last_sign_date = rowData.get("last_sign_date");
      _logger.debug(this, "getUserInfo", "----------------------------*****>Last_sign_date={1}", Last_sign_date);
      userInfo.setLast_sign_date(Last_sign_date);
      return userInfo;
   }

   // ============================================================
   // @根据app_key获取应用
   // @param applicationGuid 应用的guid
   // @param logicContext 逻辑上下文
   // ============================================================
   @Override
   public FDataSystemApplicationUnit getApplicationUnitByGuid(ILogicContext logicContext,
                                                              String applicationGuid){
      FDataSystemApplicationLogic applicationLogic = logicContext.findLogic(FDataSystemApplicationLogic.class);
      return applicationLogic.findByGuid(applicationGuid);
   }

   // ============================================================
   // @通过用户的ouid清空session
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   // ============================================================

   @Override
   public void clearSessionByUserId(long userId,
                                    long appId,
                                    IWebSession sessionContext,
                                    ILogicContext logicContext,
                                    IGcSessionConsole _sessionConsole,
                                    IWebSessionConsole _webSessionConsole){
      FLogicDataset<FGcSessionInfo> sessionInfos = _sessionConsole.findByUserAndAppId(logicContext, userId, appId);
      for(Iterator<FGcSessionInfo> iterator = sessionInfos.iterator(); iterator.hasNext();){
         FGcWebSession session = new FGcWebSession();
         FGcSessionInfo sessionInfo = iterator.next();
         session.loadInfo(sessionInfo);
         _webSessionConsole.close(session);
      }
   }

   // ============================================================
   // @查看当前用户是否有最新的公告
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   // ============================================================

   @Override
   public FLogicDataset<FDataLogicNoticeUnit> isThereNotices(long userId,
                                                             IWebSession sessionContext,
                                                             ILogicContext logicContext,
                                                             IGcSessionConsole _sessionConsole,
                                                             IWebSessionConsole _webSessionConsole){
      FDataLogicNoticeLogic noticeLogic = logicContext.findLogic(FDataLogicNoticeLogic.class);
      FSql whereSql2 = new FSql();
      whereSql2.append(FDataLogicNoticeLogic.STATUS_CD);
      whereSql2.append("=");
      whereSql2.append(EGcResourceStatus.Publish);
      whereSql2.append(" AND ");
      whereSql2.append(FDataLogicNoticeLogic.DISPLAY_CD);
      whereSql2.append("=");
      whereSql2.append(EGcDisplay.Enabled);
      whereSql2.append(" AND ");
      whereSql2.append(FDataLogicNoticeLogic.OUID);
      whereSql2.append(" NOT in (SELECT `NOTICE_ID` FROM `EAI_DATA`.`DT_PSN_USER_NOTICE` WHERE `USER_ID`=" + userId);
      whereSql2.append(")");
      FLogicDataset<FDataLogicNoticeUnit> moduleList = noticeLogic.fetch(whereSql2);
      return moduleList;

   }
}
