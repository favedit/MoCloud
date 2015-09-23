package org.mo.content.face.manage.user;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.define.enums.core.EGcPersonUserRole;
import org.mo.com.encoding.RSha1;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.user.FDataPersonUserInfo;
import org.mo.content.core.manage.user.IUserConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
//============================================================
//<P>登录逻辑实现类</P>
//
//@class FUserAction
//@author Sunhr
//@Date 2015.08.04  
//@version 1.0.0
//============================================================

public class FUserAction
      implements
         IUserAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FUserAction.class);

   //用户控制器
   @ALink
   protected IUserConsole _userConsole;

   //============================================================
   // <T>默认action处理。</T>
   //
   // @param context 环境
   // @param page 容器
   // @return 处理结果
   //============================================================
   @Override
   public String construct(IWebContext context,
                           FUserPage userPage,
                           FBasePage basePage){
      _logger.debug(this, "construct", "construct begin.");
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "#/manage/user/UserList";
   }

   // ============================================================
   // <T>用户登陆</T>
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String select(IWebContext context,
                        ILogicContext logicContext,
                        FUserPage userPage,
                        FBasePage basePage){
      _logger.debug(this, "Select", "User Select. (passport={1},password={2})", context.parameter("passport"), context.parameter("password"));
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         userPage.setPageCurrent(Integer.parseInt(num));
      }else{
         userPage.setPageCurrent(0);
      }
      FDataPersonUserInfo user = new FDataPersonUserInfo();
      user.setPassport(context.parameter("passport"));
      FLogicDataset<FDataPersonUserInfo> unitList = _userConsole.selectDataByPageAndSomerow(logicContext, user, userPage.pageCurrent() - 1);
      basePage.setJson(unitList.toJsonListString());
      return "/manage/common/ajax";
   }

   // ============================================================
   // <T>用户增加之前处理</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String insertBefore(IWebContext context,
                              ILogicContext logicContext,
                              FUserPage formPage,
                              FBasePage basePage){
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "InsertBefore", "User InsertBefore. (user={1})", basePage.userId());
      return "#/manage/user/InsertUser";
   }

   // ============================================================
   // <T>用户增加</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String insert(IWebContext context,
                        ILogicContext logicContext,
                        FUserPage formPage,
                        FBasePage basePage){
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "InsertUser", "InsertUser Begin.(passport={1})", context.parameter("passport"));
      String passport = context.parameter("passport").replaceAll(" ", "");
      String password = context.parameter("password").trim();
      if(passport.indexOf("'") > -1 || passport.indexOf("%") > -1 || passport.indexOf(";") > -1 || passport.length() > 17 || RString.isEmpty(passport) || RString.isEmpty(password)){
         basePage.setJson("-1");
         return "/manage/common/ajax";
      }
      password = RSha1.encode(password);
      EResult result = _userConsole.passportExists(logicContext, context.parameter("passport"));
      if(result == EResult.Success){
         _logger.debug(this, "InsertUser", "InsertUser fail,This user already exists.(passport={1})", context.parameter("passport"));
         basePage.setJson("0");
         return "/manage/common/ajax";
      }
      FDataPersonUserUnit unit = new FDataPersonUserUnit();
      unit.setPassport(passport);
      unit.setPassword(password);
      unit.setLabel(context.parameter("label"));
      unit.setOvld(true);
      unit.setRoleId(context.parameterAsLong("role"));
      unit.setRoleCd(EGcPersonUserRole.Normal);
      _userConsole.doInsert(logicContext, unit);
      basePage.setJson("1");
      _logger.debug(this, "InsertUser", "InsertUser succeed.");
      return "/manage/common/ajax";
   }

   // ============================================================
   // <T>用户增加</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param formPage 容器
   // @param basePage 容器
   // @return 要跳转页面
   // ============================================================
   @Override
   public String updateBefore(IWebContext context,
                              ILogicContext logicContext,
                              FUserPage userPage,
                              FBasePage basePage){
      basePage.setTemp("");
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      String id = context.parameter("id");
      _logger.debug(this, "UpdateBefore", "UpdateBefore Begin.(id={1})", id);
      FDataPersonUserUnit unit = _userConsole.findByGuid(logicContext, id);
      String passport = unit.passport();
      int isOa = passport.indexOf(':');
      if(isOa > 0){
         basePage.setTemp("oa");
      }
      userPage.setUser(unit);
      return "#/manage/user/UpdateUser";
   }

   // ============================================================
   // <T>修改用户</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param formPage 容器
   // @param basePage 容器
   // @return 要跳转页面
   // ============================================================
   @Override
   public String update(IWebContext context,
                        ILogicContext logicContext,
                        FUserPage formPage,
                        FBasePage basePage){
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", context.parameter("id"));
      String id = context.parameter("id");
      String oa = context.parameter("oa");
      FDataPersonUserUnit unit = _userConsole.findByGuid(logicContext, id);
      if(RString.isEmpty(oa)){
         String password = context.parameter("password");
         if(password != null){
            password = password.trim();
            password = RSha1.encode(password);
            unit.setPassword(password);
         }
         unit.setLabel(context.parameter("label"));
      }
      unit.setRoleId(context.parameterAsLong("role"));
      unit.setRoleCd(EGcPersonUserRole.Normal);
      unit.setUpdateUserId(context.parameterAsLong("adminId"));
      _userConsole.doUpdate(logicContext, unit);
      basePage.setJson("1");
      return "/manage/common/ajax";
   }

   // ============================================================
   // <T>删除用户</T>
   //
   // @param context 上下文
   // @param sqlContext 数据库连接
   // @param formPage 容器
   // @param basePage 容器
   // @return 要跳转页面
   // ============================================================
   @Override
   public String del(IWebContext context,
                     ILogicContext logicContext,
                     FUserPage formPage,
                     FBasePage basePage){
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      String id = context.parameter("id");
      FDataPersonUserUnit unit = _userConsole.findByGuid(logicContext, id);
      if(unit != null){
         @SuppressWarnings("unused") EResult result = _userConsole.delete(logicContext, unit.ouid());
         _logger.debug(this, "Del", " Del finish.(guid={1})", id);
      }

      return "#/manage/user/UserList";
   }

}
