package org.mo.content.face.chart;

import com.cyou.gccloud.define.enums.core.EGcAuthorityAccess;
import com.cyou.gccloud.define.enums.core.EGcAuthorityResult;
import org.mo.com.lang.RString;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.logic.data.person.user.FDataPersonAccessAuthority;
import org.mo.eai.logic.data.person.user.IDataPersonAccessAuthorityConsole;
import org.mo.eai.logic.logger.person.user.FLoggerPersonUserAccess;
import org.mo.eai.logic.logger.person.user.ILoggerPersonUserAccessConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>首页。</P>
//
// @author maocy
// @version 150427
//============================================================
public class FLiveAction
      implements
         ILiveAction
{
   @ALink
   protected IDataPersonAccessAuthorityConsole _personAccessAuthorityConsole;

   @ALink
   protected ILoggerPersonUserAccessConsole _loggerPersonUserAccessConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FLivePage page){
      // 清空参数
      page.setPassport(null);
      page.setPassword(null);
      page.setMessage(null);
      // 获得参数
      String hostAddress = context.head("x-real-ip");
      if(RString.isEmpty(hostAddress)){
         hostAddress = context.head("x-forwarded-for");
         if(RString.isEmpty(hostAddress)){
            hostAddress = context.remoteAddress();
         }
      }
      // 登录处理
      FDataPersonAccessAuthority authority = _personAccessAuthorityConsole.findByHostAddress(logicContext, hostAddress);
      if(authority != null){
         int accessCd = authority.accessCd();
         if(accessCd == EGcAuthorityAccess.Allow){
            // 增加日志
            FLoggerPersonUserAccess logger = _loggerPersonUserAccessConsole.doPrepare(logicContext);
            logger.setHostAddress(hostAddress);
            logger.setLogicMessage("主机地址为白名单。");
            _loggerPersonUserAccessConsole.doInsert(logicContext, logger);
            return "Live";
         }
      }
      // 非法设置
      return "Login";
   }

   //============================================================
   // <T>登录逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String login(IWebContext context,
                       ILogicContext logicContext,
                       FLivePage page){
      // 获得参数
      String passport = page.passport();
      String password = page.password();
      String hostAddress = context.head("x-real-ip");
      if(RString.isEmpty(hostAddress)){
         hostAddress = context.head("x-forwarded-for");
         if(RString.isEmpty(hostAddress)){
            hostAddress = context.remoteAddress();
         }
      }
      // 登录处理
      String message = null;
      String logggerMessage = null;
      int resultCd = _personAccessAuthorityConsole.doLogin(logicContext, hostAddress, passport, password);
      switch(resultCd){
         case EGcAuthorityResult.PassportInvalid:
            logggerMessage = "账号不存在。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.PasswordInvalid:
            logggerMessage = "密码错误。";
            message = "用户名或密码错误。";
            break;
         case EGcAuthorityResult.DateInvalid:
            message = "时间已失效。";
            break;
         case EGcAuthorityResult.Success:
            logggerMessage = "登录成功。";
            break;
      }
      // 增加日志
      FLoggerPersonUserAccess logger = _loggerPersonUserAccessConsole.doPrepare(logicContext);
      logger.setHostAddress(hostAddress);
      logger.setLogicMessage(logggerMessage);
      logger.setPassport(passport);
      logger.setPassword(password);
      _loggerPersonUserAccessConsole.doInsert(logicContext, logger);
      // 非法设置
      page.setMessage(message);
      if(resultCd == EGcAuthorityResult.Success){
         return "Live";
      }
      return "Login";
   }
}
