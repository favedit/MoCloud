package org.mo.content.face.pc;

import com.cyou.gccloud.data.data.FDataControlRoleUnit;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.cache.system.IValidationConsole;
import org.mo.content.core.manage.logger.user.ILoggerModuleConsole;
import org.mo.content.core.manage.person.module.IModuleConsole;
import org.mo.content.core.manage.person.role.IRoleConsole;
import org.mo.content.core.manage.person.role.IRoleModuleConsole;
import org.mo.content.core.manage.person.user.IEntryConsole;
import org.mo.content.core.manage.person.user.IUserConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.logic.data.person.user.IDataPersonAccessAuthorityConsole;
import org.mo.eai.logic.financial.IFinancialMarketerConsole;
import org.mo.eai.logic.logger.person.user.ILoggerPersonUserAccessConsole;
import org.mo.eai.logic.service.info.ILogicServiceInfoConsole;
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
   protected IDataPersonAccessAuthorityConsole _personAccessAuthorityConsole;

   @ALink
   protected ILoggerPersonUserAccessConsole _loggerPersonUserAccessConsole;

   @ALink
   protected ILogicServiceInfoConsole _loggerServiceInfoConsole;

   @ALink
   protected IUserConsole _userConsole;

   @ALink
   protected IRoleConsole _roleConsole;

   //模块控制台
   @ALink
   protected IModuleConsole _moduleConsole;

   //角色模块控制台
   @ALink
   protected IRoleModuleConsole _roleModuleConsole;

   @ALink
   protected IEntryConsole _entryConsole;

   //短信校验控制台
   @ALink
   protected IValidationConsole _validationConsole;

   //理财师控制台
   @ALink
   protected IFinancialMarketerConsole _marketerConsole;

   @ALink
   protected ILoggerModuleConsole _loggerModuleConsole;

   //OA角色
   protected final String role_oa = "eai.oa";

   //理财师角色
   protected final String role_marketer = "eai.marketer";

   protected final String module_code_customer = "eai.marketer.customer";

   protected final String module_code_marketer = "eai.marketer.marketer";

   protected final String module_code_department = "eai.department.marketer";

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
                           FIndexPage page){
      String id = context.parameter("id");
      FDataPersonUserUnit user = _userConsole.findByGuid(logicContext, id);
      if(user == null){
         return "Login";
      }
      page.setId(id);
      //获取角色 验证此用户是否绑定e租宝
      FDataControlRoleUnit role = _roleConsole.findByCode(logicContext, role_oa);
      if(user.roleId() == role.ouid()){
         page.setIsOa(true);
      }
      String label = user.label();
      page.setPassport(label);
      page.setIsLogin(false);
      //      tackAuthority(logicContext, page, user.roleId());
      return "Main";
   }

   //============================================================
   // <T>主页面。</T>
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param page 页面
   //============================================================
   @Override
   public String main(IWebContext context,
                      IWebSession sessionContext,
                      ILogicContext logicContext,
                      FIndexPage page){
      String id = context.parameter("id");
      FDataPersonUserUnit user = _userConsole.findByGuid(logicContext, id);
      if(user == null){
         return "Login";
      }
      page.setId(id);
      //获取角色 验证此用户是否绑定e租宝
      FDataControlRoleUnit role = _roleConsole.findByCode(logicContext, role_oa);
      if(user.roleId() == role.ouid()){
         page.setIsOa(true);
      }
      String label = user.label();
      page.setPassport(label);
      page.setIsLogin(false);
      //      tackAuthority(logicContext, page, user.roleId());
      return "Main";
   }

   //   //============================================================
   //   // <T>获取管理权限。</T>
   //   //
   //   // @param logicContext 环境
   //   // @param page 容器
   //   // @param roleid 角色编号
   //   //============================================================
   //   private void tackAuthority(ILogicContext logicContext,
   //                              FIndexPage page,
   //                              long roleid){
   //      StringBuffer menuStrings = new StringBuffer();
   //      long roleId = roleid;
   //      if(roleId != 0){
   //         FLogicDataset<FDataControlRoleModuleUnit> roelModuleInfoList = _roleModuleConsole.selectDataByRoleIdAndModuleId(logicContext, roleId, 0);
   //         for(FDataControlRoleModuleUnit role : roelModuleInfoList){
   //            FDataControlModuleUnit module = _moduleConsole.find(logicContext, role.moduleId());
   //            if(module != null){
   //               menuStrings.append(module.code()).append("|");
   //            }
   //         }
   //         page.setMenuString(menuStrings.deleteCharAt(menuStrings.length() - 1).toString());
   //      }else{
   //         page.setMenuString(null);
   //      }
   //   }
}
