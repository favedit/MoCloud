package org.mo.content.face.manage.system.statistics.user.login;

import com.cyou.gccloud.data.logger.FLoggerPersonUserAccessUnit;

import java.util.Arrays;

import org.mo.com.lang.RDateTime;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.system.statistics.user.login.IAccessConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>用户日志控制器</P>
//@class FAccessAction
//============================================================
public class FAccessAction 
      implements 
         IAccessAction 
{

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FAccessAction.class);
   // 用户控制台
   @ALink
   protected IAccessConsole _accessConsole;
   //开始日期时间结尾
   private static final String startTimeStr = "000000";
   //结束日期时间结尾
   private static final String endTimneStr = "235959";
   
   private static final String loginSuccess = "登录成功";
   
   private static final String loginFail = "登录失败";
   

   @Override
   public String construct(IWebContext context, 
                           ILogicContext logicContext, 
                           FBasePage basePage) {
      _logger.debug(this, "Construct", "Construct begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/system/statistics/user/login/AccessList";
   }

   // ============================================================
   // <T>查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String select(IWebContext context, 
                        ILogicContext logicContext, 
                        FAccessPage page, 
                        FBasePage basePage) {
      _logger.debug(this, "Select", "Select begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      if (null != context.parameter("page")) {
         String num = context.parameter("page");
         page.setPageCurrent(Integer.parseInt(num));
      } else {
         page.setPageCurrent(0);
      }
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FLoggerPersonUserAccessUnit> unitlist = _accessConsole.select(logicContext, page.pageCurrent() - 1, pageSize);
      basePage.setJson(unitlist.toJsonListString());
      _logger.debug(this, "Select", "Select finish. (unitListCount={1})", unitlist.count());
      return "/manage/common/ajax";
   }

   // ============================================================
   // <T>根据创建时间，操作信息查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String selectByDate(IWebContext context, 
                              ILogicContext logicContext, 
                              FAccessPage accessPage, 
                              FBasePage basePage) {
      _logger.debug(this, "selectByDate", "selectByDate begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      if (null != context.parameter("page")) {
         String num = context.parameter("page");
         accessPage.setPageCurrent(Integer.parseInt(num));
      } else {
         accessPage.setPageCurrent(0);
      }
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      String beginDateStr = context.parameter("beginDate");
      String endDateStr = context.parameter("endDate");
      String logicMessage = context.parameter("logicMessage");
      String passport = context.parameter("passport");
      FLogicDataset<FLoggerPersonUserAccessUnit> unitlist = _accessConsole.selectByDateandMessage(logicContext, beginDateStr, endDateStr, logicMessage,passport, accessPage.pageCurrent() - 1, pageSize);
      basePage.setJson(unitlist.toJsonListString());
      _logger.debug(this, "selectByDate", "selectByDate finish. (unitListCount={1})", unitlist.count());
      return "/manage/common/ajax";
   }
   
   // ============================================================
   // <T>根据自然日查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String selectByDay(IWebContext context, 
                             ILogicContext logicContext, 
                             FAccessPage accessPage, 
                             FBasePage basePage) {
      _logger.debug(this, "selectByDay", "selectByDay begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      
      Integer date[] = new Integer[30];//日期数组
      Integer success[] = new Integer[30];//登录成功数量
      Integer fail[] = new Integer[30];//登录失败数量
      TDateTime day = new TDateTime(RDateTime.currentDateTime());//当前日期
      day.addDay(-31);
      for(int k=0;k<30;k++){
         day.addDay(1);
         date[k]=RInteger.parse(day.format("MMDD"));
         success[k]=_accessConsole.getLoginCountByDateandMessage(logicContext, day.formatDate()+startTimeStr, day.formatDate()+endTimneStr, loginSuccess);
         fail[k]=_accessConsole.getLoginCountByDateandMessage(logicContext, day.formatDate()+startTimeStr, day.formatDate()+endTimneStr, loginFail);
      }
      
      String json = "{\"login\": [{\"name\": \"登录成功\",\"data\":"+ Arrays.toString(success)+"},{\"name\": \"登录失败\",\"data\":"+
            Arrays.toString(fail)+"}],\"date\":"+ Arrays.toString(date)+",\"text\":\"前30天用户登录结果趋势图\"}";
      basePage.setJson(json);
      _logger.debug(this, "selectByDay", "selectByDay finish. (unitListCount={1})", basePage.json());
      return "/manage/common/ajax";
   }
}
