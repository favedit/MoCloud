package org.mo.content.face.mb;

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
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.console.financial.FFinancialMarketerInfo;
import org.mo.eai.console.financial.IFinancialMarketerConsole;
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
                           FBasePage basePage,
                           FBindingPage page){
      page.setMessage(null);
      FGcWebSession session = (FGcWebSession)sessionContext;
      _logger.debug(this, "Bind", "Bind default begin. (guid={1})", session);
      FDataPersonUserUnit user = _userConsole.find(logicContext, session.userId());
      if(user == null){
         basePage.setUrl("Main.wa");
         return "/apl/Redirector";
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
                              FBindingPage page){
      page.setMessage(null);
      TDateTime nowTime = new TDateTime(RDateTime.currentDateTime());
      String passport = context.parameter("passport");
      _logger.debug(this, "SendValidate", "SendValidate begin. (passport={1})", passport);
      //根据帐号查找用户及手机号
      if(RString.isEmpty(passport)){
         page.setMessage("E租宝账号不能为空");
         return "/apl/ajax";
      }
      if(passport.length() > 30 || passport.indexOf('%') > -1 || passport.indexOf("'") > -1){
         page.setMessage("E租宝账号非法");
         return "/apl/ajax";
      }
      FFinancialMarketerInfo marketer = _marketerConsole.findInfo(logicContext, passport);
      if(marketer == null){
         page.setMessage("E租宝账号无理财师权限！");
         return "/apl/ajax";
      }
      _logger.debug(this, "SendValidate", "SendValidate get marketer. (marketerPassport={1})", marketer.passport());
      //获取手机号码 －〉 发送验证码
      String mobile = marketer.phone();
      String card = marketer.card();
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
         return "/apl/ajax";
      }
      //保存数据库
      FCacheSystemValidationUnit unit = _validationConsole.doPrepare(logicContext);
      unit.setPassport(passport);
      unit.setCheckCode(random);
      unit.setValidateCd(EGcValidationValidate.EaiMarketer);
      _validationConsole.doInsert(logicContext, unit);
      // 记录用户信息
      FGcWebSession session = (FGcWebSession)sessionContext;
      FDataPersonUserUnit user = _userConsole.find(logicContext, session.userId());
      user.setIdCard(card);
      user.setContactPhone(mobile);
      _userConsole.doUpdate(logicContext, user);
      page.setMessage("1");
      return "/apl/ajax";
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
                               FBasePage basePage,
                               FBindingPage page){
      page.setMessage(null);
      FGcWebSession session = (FGcWebSession)sessionContext;
      String epassport = context.parameter("ePassport");
      String validate = context.parameter("validate");
      long userId = session.userId();
      _logger.debug(this, "BindOnAccount", "BindOnAccount begin. (passport={1},validate={2},userId={3})", epassport, validate, userId);
      //获取用户
      FDataPersonUserUnit user = _userConsole.find(logicContext, userId);
      page.setPassport(user.label());
      if(RString.isEmpty(epassport) || RString.isEmpty(validate)){
         page.setMessage("账号或验证码不能为空");
         return "Binding";
      }
      if(epassport.length() > 30 || epassport.indexOf('%') > -1 || epassport.indexOf("'") > -1){
         page.setMessage("E租宝账号或验证码非法");
         return "Binding";
      }
      if(validate.length() > 4 || validate.indexOf('%') > -1 || validate.indexOf("'") > -1){
         page.setMessage("E租宝账号或验证码非法");
         return "Binding";
      }
      // 验证是否发送过验证码
      FCacheSystemValidationUnit unit = _validationConsole.findByPassport(logicContext, epassport);
      if(unit == null){
         page.setMessage("验证码错误");
         return "Binding";
      }
      //检测时间超时
      TDateTime nowTime = new TDateTime(RDateTime.currentDateTime());
      TDateTime serviceTime = new TDateTime(unit.createDate());
      serviceTime.addMinute(5);
      _logger.debug(this, "BindOnAccount", "BindOnAccount check verification time out. (nowTime={1},serviceTime={2})", nowTime, serviceTime);
      if(serviceTime.isBefore(nowTime)){
         page.setMessage("验证码错误");
         return "Binding";
      }
      // 检查验证码
      String checkCode = unit.checkCode();
      _logger.debug(this, "BindOnAccount", "BindOnAccount check Verification. (inputVerifica={1},serviceVerifica={2})", validate, checkCode);
      if(!checkCode.equals(validate)){
         page.setMessage("验证码错误");
         return "Binding";
      }

      //获取角色
      FDataControlRoleUnit role = _roleConsole.findByCode(logicContext, role_marketer);
      if(user != null){
         user.setRoleId(role.ouid());
         _userConsole.doUpdate(logicContext, user);
      }
      _sessionConsole.open(session);
      basePage.setUrl("Main.wa");
      return "/apl/Redirector";
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
      String text = "验证码" + random + ",您正在使用[智慧企业－数据可视化平台]进行理财师绑定，注意保密哦！【钰诚办公平台】";
      int result = bs.sendBatchMessage("sdk_yucheng", "1qazxsw2", mobile, text);
      _logger.debug(this, "SendValidate", "sendMessage finish. (text={1},result={2})", text, result);
      return result;
   }
}
