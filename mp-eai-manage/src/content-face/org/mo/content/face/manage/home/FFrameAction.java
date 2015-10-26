package org.mo.content.face.manage.home;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.define.enums.core.EGcPersonUserRole;
import org.mo.com.encoding.RSha1;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.system.user.IUserConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
//============================================================
//<P>登录逻辑实现类</P>
//
//@class FFormAction
//@author Sunhr
//@Date 2015.07.27  
//@version 1.0.0
//============================================================

public class FFrameAction 
      implements 
         IFrameAction 
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FFrameAction.class);

   // 用户控制器
   @ALink
   protected IUserConsole _userConsole;

   // ============================================================
   // <T>列出目录处理。</T>
   //
   // @param context 环境
   // @param page 容器
   // @return 处理结果
   // ============================================================
   @Override
   public String construct(IWebContext context, 
                           FFramePage formPage, 
                           FBasePage basePage) {
      _logger.debug(this, "construct", "construct begin.");
      if (!basePage.userExists()) {
         return "/manage/home/Frame";
      }
      return "/manage/manage/home/Frame";
   }

   // ============================================================
   // <T>用户登陆</T>
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String loginUser(IWebContext context, 
                           ILogicContext logicContext, 
                           FFramePage formPage, 
                           FBasePage basePage) {
      _logger.debug(this, "LoginUser", "LoginUser begin. (passport={1},password={2})", context.parameter("passport"), context.parameter("password"));
      String passport = context.parameter("passport").trim();
      String password = context.parameter("password").trim();
      if (passport.indexOf("'") > -1 || passport.indexOf("%") > -1 || passport.length() > 18 || RString.isEmpty(passport) || RString.isEmpty(password)) {
         _logger.debug(this, "LoginUser", "LoginUser , the passport illegal. (passport={1})", passport);
         basePage.ajax(0, null);
         return "/manage/common/ajax";
      }
      password = RSha1.encode(password);
      // 初始用户处理
      FLogicDataset<FDataPersonUserUnit> unitList = _userConsole.fetch(logicContext, null);
      FDataPersonUserUnit userUnit = new FDataPersonUserUnit();
      if (unitList.count() <= 0) {
         userUnit.setOvld(true);
         userUnit.setPassport(passport);
         userUnit.setPassword(password);
         // userUnit.setRoleId(1);
         userUnit.setRoleCd(EGcPersonUserRole.Admin);
         userUnit.setLabel("初始用户");
         _userConsole.doInsert(logicContext, userUnit);
         formPage.setUser(userUnit);
         basePage.setUserId(userUnit.guid());
         basePage.setUserName(userUnit.label());
         basePage.setPassport(userUnit.passport());
         basePage.setRoleId(userUnit.roleId());
         basePage.ajax(1, "/manage/home/Frame.wa");
         _logger.debug(this, "LoginUser", "LoginUser first user login Sueeccd.");
      }

      userUnit.setPassport(passport);
      FLogicDataset<FDataPersonUserUnit> userUnitList = _userConsole.loginUser(logicContext, userUnit);
      if (userUnitList.count() == 0) {// 无此用户
         basePage.ajax(0, null);
         _logger.debug(this, "LoginUser", "LoginUser fail,Without this user.");
      } else if (userUnitList.count() == 1) {// 有此用户
         if (userUnitList.first().password().equals(password)) {// 密码正确
            FDataPersonUserUnit unit = userUnitList.first();
            formPage.setUser(unit);
            basePage.setUserId(unit.guid());
            basePage.setUserName(unit.label());
            basePage.setPassport(unit.passport());
            basePage.setRoleId(unit.roleId());
            basePage.ajax(1, "/manage/home/Frame.wa");
         } else {// 密码不正确
            basePage.ajax(0, null);
            _logger.debug(this, "LoginUser", "LoginUser fail,Password is not currect.");
         }
      } else if (userUnitList.count() > 1) {// 有多个相同用户
         basePage.ajax(3, null);
         _logger.debug(this, "LoginUser", "LoginUser fail,Have the same multiple users.");
      }
      return "/manage/common/ajax";
   }

   // ============================================================
   // <T>修改密码加载</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param basePage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String changePwdPrepare(IWebContext context, 
                                  ILogicContext logicContext, 
                                  FBasePage basePage) {
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/manage/user/ChangePwd";
   }

   // ============================================================
   // <T>修改用户信息</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @return 要跳转页面
   // ============================================================
   @Override
   public String changePwd(IWebContext context, 
                           ILogicContext logicContext, 
                           FFramePage formPage, 
                           FBasePage basePage) {
      _logger.debug(this, "ChangePwd", "ChangePwd begin.(userId={1})", context.parameter("id"));
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      String id = context.parameter("id");

      String password = RSha1.encode(context.parameter("password").trim());
      String oldpwd = RSha1.encode(context.parameter("oldpwd").trim());
      FDataPersonUserUnit unit = _userConsole.findByGuid(logicContext, id);
      unit.setPassword(oldpwd);
      if (unit.isPasswordChanged()) {
         basePage.setJson("0");
         return "/manage/common/ajax";
      } else {
         unit.setPassword(password);
         _userConsole.doUpdate(logicContext, unit);
         basePage.setJson("1");
         return "/manage/common/ajax";
      }
   }

   // ============================================================
   // <T>用户注销</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String loginOut(IWebContext context, 
                          ILogicContext logicContext, 
                          FFramePage formPage, 
                          FBasePage basePage) {
      _logger.debug(this, "loginOut", "loginOut begin.");
      // 清空basePage
      formPage.setUser(null);
      basePage.setMenuString(null);
      basePage.setUserId(null);
      basePage.setUserName(null);
      basePage.setPassport(null);
      basePage.setJson(null);
      return "/manage/home/Frame";
   }
}
