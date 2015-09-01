package org.mo.content.face.pc;

import org.mo.eai.console.financial.FFinancialMarketerInfo;
import org.mo.eai.console.financial.IFinancialMarketerConsole;

import com.cyou.gccloud.data.cache.FCacheSystemValidationUnit;
import com.cyou.gccloud.data.data.FDataControlRoleUnit;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.define.enums.core.EGcValidationValidate;
import com.jianzhou.sdk.BusinessService;
import org.mo.cloud.core.web.FGcWebSession;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RRandom;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.cache.system.IValidationConsole;
import org.mo.content.core.manage.person.role.IRoleConsole;
import org.mo.content.core.manage.person.user.IEntryConsole;
import org.mo.content.core.manage.person.user.IUserConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.logic.data.person.user.IDataPersonAccessAuthorityConsole;
import org.mo.eai.logic.logger.person.user.ILoggerPersonUserAccessConsole;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>账号绑定。</P>
//
// @author sunhr
// @version 150427
//============================================================
public class FBindingAction
      implements
         IBindingAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FBindingAction.class);

   @ALink
   protected IWebSessionConsole _sessionConsole;

   @ALink
   protected IDataPersonAccessAuthorityConsole _personAccessAuthorityConsole;

   @ALink
   protected ILoggerPersonUserAccessConsole _loggerPersonUserAccessConsole;

   @ALink
   protected IUserConsole _userConsole;

   @ALink
   protected IRoleConsole _roleConsole;

   @ALink
   protected IEntryConsole _entryConsole;

   //短信校验控制台
   @ALink
   protected IValidationConsole _validationConsole;

   //理财师控制台
   @ALink
   protected IFinancialMarketerConsole _marketerConsole;

   //OA角色
   protected final String role_oa = "eai.oa";

   //理财师角色
   protected final String role_marketer = "eai.marketer";

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           IWebSession sessionContext,
                           ILogicContext logicContext,
                           FIndexPage page){
      page.setMessage(null);
      FGcWebSession session = (FGcWebSession)sessionContext;
      _logger.debug(this, "Bind", "Bind begin. (guid={1})", session);
      FDataPersonUserUnit user = _userConsole.find(logicContext, session.userId());
      if(user == null){
         page.setIsLogin(false);
         return "Main";
      }
      page.setPassport(user.label());
      return "Binding";
   }

   //============================================================
   // <T>发送验证码。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String sendValidate(IWebContext context,
                              IWebSession sessionContext,
                              ILogicContext logicContext,
                              FIndexPage page){
      page.setMessage(null);
      TDateTime nowTime = new TDateTime(RDateTime.currentDateTime());
      String passport = context.parameter("passport");
      _logger.debug(this, "SendValidate", "SendValidate begin. (passport={1})", passport);
      //根据帐号查找用户及手机号
      if(RString.isEmpty(passport)){
         page.setMessage("E租宝帐号不能为空");
         return "ajax";
      }

      FFinancialMarketerInfo marketer = _marketerConsole.findInfo(logicContext, passport);
      if(marketer == null){
         page.setMessage("E租宝账号无理财师权限！");
         return "ajax";
      }
      _logger.debug(this, "SendValidate", "SendValidate get marketer. (marketerPassport={1})", marketer.passport());
      //获取手机号码 －〉 发送验证码
      String mobile = marketer.phone();
      String random = null;
      //验证5分钟前有没有发过验证码，发过再次发送此验证码
      FCacheSystemValidationUnit validate = _validationConsole.findByTime(logicContext, nowTime, passport);
      if(validate != null){
         random = validate.checkCode();
         _logger.debug(this, "SendValidate", "SendValidate get 5Minute ago data. (checkCode={1})", validate.checkCode());
         EResult result = _validationConsole.deleteByCode(logicContext, random);
         _logger.debug(this, "SendValidate", "SendValidate delete 5Minute ago same code. (result={1})", result);
      }else{
         random = RRandom.getNumberRandom(4);
      }
      int result = sendMessage(random, mobile);
      if(result < 0){
         page.setMessage("验证码发送失败");
         return "ajax";
      }
      //保存数据库
      FCacheSystemValidationUnit unit = _validationConsole.doPrepare(logicContext);
      unit.setPassport(passport);
      unit.setCheckCode(random);
      unit.setValidateCd(EGcValidationValidate.EaiMarketer);
      _validationConsole.doInsert(logicContext, unit);
      page.setMessage("1");
      return "ajax";
   }

   //============================================================
   // <T>账号绑定。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String bindOnAccount(IWebContext context,
                               IWebSession sessionContext,
                               ILogicContext logicContext,
                               FIndexPage page){
      System.out.println("*************************************************bindOnAccount");
      page.setMessage(null);
      String epassport = context.parameter("ePassport");
      String validate = context.parameter("validate");
      String id = context.parameter("id");
      _logger.debug(this, "BindOnAccount", "BindOnAccount begin. (passport={1},validate={2},guid={3})", epassport, validate, id);
      if(RString.isEmpty(id)){
         return "Login";
      }
      if(RString.isEmpty(epassport) || RString.isEmpty(validate)){
         page.setMessage("账号或验证码不能为空");
         return "Binding";
      }
      //获取用户
      FDataPersonUserUnit user = _userConsole.findByGuid(logicContext, id);
      if(user != null){
         page.setPassport(user.label());
      }
      FCacheSystemValidationUnit unit = _validationConsole.findByPassport(logicContext, epassport);
      //时间验证
      if(unit == null){
         page.setMessage("验证码错误");
         return "Binding";
      }
      //检测时间超时
      TDateTime nowTime = new TDateTime(RDateTime.currentDateTime());
      TDateTime serviceTime = new TDateTime(unit.createDate());
      serviceTime.addMinute(5);
      if(serviceTime.isBefore(nowTime)){
         page.setMessage("验证码错误time");
         return "Binding";
      }

      String checkCode = unit.checkCode();
      if(!checkCode.equals(validate)){
         page.setMessage("验证码错误code");
         return "Binding";
      }

      //获取角色
      FDataControlRoleUnit role = _roleConsole.findByCode(logicContext, role_marketer);
      if(user != null){
         user.setRoleId(role.ouid());
         _userConsole.doUpdate(logicContext, user);
         page.setIsOa(false);
      }

      //      page.setId(id);
      page.setIsLogin(false);
      //      tackAuthority(logicContext, page, user.roleId());
      return "Main";
   }

   //============================================================
   // <T>发送短信</T>
   //
   // @param logicContext 逻辑环境
   // @param mobile 手机号
   //============================================================
   private int sendMessage(String random,
                           String mobile){
      _logger.debug(this, "SendValidate", "sendMessage begin. (random={1},mobile={2})", random, mobile);
      BusinessService bs = new BusinessService();
      bs.setWebService("http://www.jianzhou.sh.cn/JianzhouSMSWSServer/services/BusinessService");
      String text = "您正在使用[全球实时数据中心系统]进行账户绑定，验证码" + random + ",千万不要告诉别人哟。【钰诚办公平台】";
      int result = bs.sendBatchMessage("sdk_yucheng", "1qazxsw2", mobile, text);
      _logger.debug(this, "SendValidate", "sendMessage finish. (text={1},result={2})", text, result);
      return result;
   }
}
