package org.mo.content.face.mb;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import com.cyou.gccloud.data.logger.FLoggerPersonUserModuleUnit;
import java.util.HashMap;
import java.util.Map;
import org.mo.cloud.core.web.FGcWebSession;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.common.EChartPage;
import org.mo.content.core.manage.logger.user.ILoggerModuleConsole;
import org.mo.content.core.manage.person.role.IRoleConsole;
import org.mo.content.core.manage.person.user.IUserConsole;
import org.mo.content.face.pc.FMainPage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.console.service.info.ILogicServiceInfoConsole;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>首页。</P>
//
// @author sunrui
// @version 150427
//============================================================
public class FMainAction
      implements
         IMainAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMainAction.class);

   @ALink
   protected IWebSessionConsole _sessionConsole;

   @ALink
   protected IGcSessionConsole _gcSessionConsole;

   @ALink
   protected ILogicServiceInfoConsole _loggerServiceInfoConsole;

   @ALink
   protected IUserConsole _userConsole;

   @ALink
   protected IRoleConsole _roleConsole;

   @ALink
   protected ILoggerModuleConsole _loggerModuleConsole;

   // OA角色
   protected final String role_oa = "eai.oa";

   // 模块的唯一代码
   protected final static Map<String, String> MODULE_CODE = new HashMap<String, String>();

   static{
      MODULE_CODE.put("ChartMarketerCustomer", "eai.marketer.customer");
      MODULE_CODE.put("ChartMarketerMarketer", "eai.marketer.marketer");
      MODULE_CODE.put("ChartDepartmentMarketer", "eai.marketer.customer");
      MODULE_CODE.put("ChartMarketerManage", "eai.marketer.manage");
      MODULE_CODE.put("ChartStatisticsMarketer", "eai.statistics.marketer");
      MODULE_CODE.put("ChartPerformenceMarketer", "eai.performence.marketer");
   }

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
                           FMainPage page){
      FGcWebSession session = (FGcWebSession)sessionContext;
      _sessionConsole.open(session);
      _logger.debug(this, "Main", "Main default begin.(session={1})", session);
      FDataPersonUserUnit user = _userConsole.find(logicContext, session.userId());
      if(user != null){
         page.setPassport(user.label());
         String passport = user.passport();
         if(passport.substring(0, passport.indexOf(':')).equals("white-host")){
            page.setUserType("host");
         }
      }
      return "Main";
   }

   //============================================================
   // <T>客户级。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String customer(IWebContext context,
                          IWebSession sessionContext,
                          ILogicContext logicContext,
                          FMainPage page){
      String code = "ChartMarketerCustomer";
      //保存日志
      saveLogger(context, sessionContext, logicContext, page, code, MODULE_CODE.get(code));
      return EChartPage.Scene;
   }

   //============================================================
   // <T>客户级。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String mobileCustomer(IWebContext context,
                                IWebSession sessionContext,
                                ILogicContext logicContext,
                                FMainPage page){
      String code = "ChartMarketerCustomer";
      ///pc/Main.wa?do=customer
      String sessionCode = context.head("mo-session-id");
      String appOS = context.parameter("appOS");
      if("".equals(sessionCode) || sessionCode == null){
         throw new FFatalError("sessionCode is null.");
      }
      FGcSessionInfo sessionInfo = _gcSessionConsole.findBySessionCode(logicContext, "eai", "mobile_" + appOS, sessionCode);
      if(sessionInfo == null){
         throw new FFatalError("sessionInfo is null.");
      }
      //保存日志
      saveLogger(context, sessionContext, logicContext, page, code, MODULE_CODE.get(code));
      return EChartPage.Scene;
   }

   //============================================================
   // <T>理财师级。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String marketer(IWebContext context,
                          IWebSession sessionContext,
                          ILogicContext logicContext,
                          FMainPage page){
      String code = "ChartMarketerMarketer";
      //保存日志
      saveLogger(context, sessionContext, logicContext, page, code, MODULE_CODE.get(code));
      return EChartPage.Scene;
   }

   //============================================================
   // <T>公司级。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String department(IWebContext context,
                            IWebSession sessionContext,
                            ILogicContext logicContext,
                            FMainPage page){
      String code = "ChartDepartmentMarketer";
      //保存日志
      saveLogger(context, sessionContext, logicContext, page, code, MODULE_CODE.get(code));
      return EChartPage.Scene;
   }

   //============================================================
   // <T>全国各省投资总额。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String statisticsMarketer(IWebContext context,
                                    IWebSession sessionContext,
                                    ILogicContext logicContext,
                                    FMainPage page){
      String code = "ChartStatisticsMarketer";
      //保存日志
      saveLogger(context, sessionContext, logicContext, page, code, MODULE_CODE.get(code));
      return EChartPage.Scene;
   }

   //============================================================
   // <T>全球理财师数据展示中心</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String marketerManage(IWebContext context,
                                IWebSession sessionContext,
                                ILogicContext logicContext,
                                FMainPage page){
      String code = "ChartMarketerManage";
      //保存日志
      saveLogger(context, sessionContext, logicContext, page, code, MODULE_CODE.get(code));
      return EChartPage.Scene3d;
   }

   //============================================================
   // <T>全球实时统计数据</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String performenceMarketer(IWebContext context,
                                     IWebSession sessionContext,
                                     ILogicContext logicContext,
                                     FMainPage page){
      String code = "ChartPerformenceMarketer";
      //保存日志
      saveLogger(context, sessionContext, logicContext, page, code, MODULE_CODE.get(code));
      return EChartPage.Scene;
   }

   //============================================================
   // <T>保存登录场景日志。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话环境
   // @param logicContext 逻辑环境
   // @param page 页面
   // @param code 场景名称
   //============================================================
   private void saveLogger(IWebContext context,
                           IWebSession sessionContext,
                           ILogicContext logicContext,
                           FMainPage page,
                           String sceneCode,
                           String moduleCode){
      _logger.debug(this, "Scene", "Into Scene.(sceneCode={1},moduleCode={2})", sceneCode, moduleCode);
      page.setServiceLogic(_loggerServiceInfoConsole.serviceLogic());
      page.setSceneCode(sceneCode);
      FGcWebSession session = (FGcWebSession)sessionContext;
      FDataPersonUserUnit user = _userConsole.find(logicContext, session.userId());
      if(user != null){
         //增加日志
         FLoggerPersonUserModuleUnit module = _loggerModuleConsole.doPrepare(logicContext);
         module.setUserId(user.ouid());
         module.setPassport(user.passport());
         module.setBrowserUri(context.requestUrl());
         module.setPageInfo(context.parameters().dump());
         module.setModuleAction("view");
         module.setModuleResult("Success");
         module.setModuleCode(moduleCode);
         _loggerModuleConsole.doInsert(logicContext, module);
      }
   }
}
