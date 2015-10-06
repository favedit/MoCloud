package org.mo.content.face.manage.home;

import com.cyou.gccloud.data.data.FDataControlModuleUnit;
import com.cyou.gccloud.data.data.FDataControlRoleModuleUnit;
import com.cyou.gccloud.define.enums.core.EGcPersonUserRole;
import org.mo.cloud.core.version.IGcVersionConsole;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.module.IModuleConsole;
import org.mo.content.core.manage.role.IRoleModuleConsole;
import org.mo.content.core.manage.user.IUserConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
//============================================================
//<P>用户权限逻辑实现类</P>
//
//@class FHeaderAction
//@author Sunhr
//@Date 2014.12.08  
//@version 1.0.0
//============================================================

public class FHeaderAction
      implements
         IHeaderAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FHeaderAction.class);

   @ALink
   protected IGcVersionConsole _versonConsole;

   //模块控制台
   @ALink
   protected IModuleConsole _moduleConsole;

   //角色模块控制台
   @ALink
   protected IRoleModuleConsole _roleModuleConsole;

   @ALink
   protected IUserConsole _userConsole;

   //============================================================
   // <T>列出目录处理。</T>
   //
   // @param context 环境
   // @param page 容器
   // @return 处理结果
   //============================================================
   @Override
   public String construct(IWebContext context,
                           FBasePage basePage){
      _logger.debug(this, "construct", "construct begin. ");
      //      basePage.setVersion(_versonConsole.currentVersion());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/manage/home/Header";
   }

   //============================================================
   // <T>产品权限。</T>
   //
   // @param context 环境
   // @param basePage 容器
   // @return 处理结果
   //============================================================
   @Override
   public String productLeft(IWebContext context,
                             ILogicContext logicContext,
                             FFramePage framePage,
                             FBasePage basePage){
      _logger.debug(this, "Header", "Header productLeft begin. (roleId={1})", context.parameterAsLong("roleId"));
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      tackAuthority(context, logicContext, basePage);
      return "/manage/manage/home/ProductLeft";
   }

   //============================================================
   // <T>数据分析权限。</T>
   //
   // @param context 环境
   // @param basePage 容器
   // @return 处理结果
   //============================================================
   @Override
   public String analysisLeft(IWebContext context,
                              ILogicContext logicContext,
                              FBasePage basePage){
      _logger.debug(this, "Header", "Header analysisLeft begin. (roleId={1})", context.parameterAsLong("roleId"));
      //      tackAuthority(context, logicContext, basePage);
      return "#/manage/home/AnalysisLeft";
   }

   //============================================================
   // <T>后台管理权限。</T>
   //
   // @param context 环境
   // @param basePage 容器
   // @return 处理结果
   //============================================================
   @Override
   public String manageLeft(IWebContext context,
                            ILogicContext logicContext,
                            FBasePage basePage){
      _logger.debug(this, "Header", "Header manageLeft begin. (roleId={1})", context.parameterAsLong("roleId"));
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      tackAuthority(context, logicContext, basePage);
      System.out.println(basePage.menuString() + "--------------------");
      return "/manage/manage/home/ManageLeft";
   }

   //============================================================
   // <T>数据库管理</T>
   //
   // @param context 环境
   // @param userPage 容器
   // @return 处理结果
   //============================================================
   @Override
   public String databaseLeft(IWebContext context,
                              ILogicContext logicContext,
                              FBasePage basePage){
      _logger.debug(this, "Header", "Header databaseLeft begin. (roleId={1})", context.parameterAsLong("roleId"));
      return "#/manage/home/DatabaseLeft";
   }

   //============================================================
   // <T>获取管理权限。</T>
   //
   // @param context 环境
   // @param basePage 容器
   //============================================================
   private void tackAuthority(IWebContext context,
                              ILogicContext logicContext,
                              FBasePage basePage){
      _logger.debug(this, "TackAuthority", "TackAuthority begin. (userId={1})", basePage.userId());
      StringBuffer menuStrings = new StringBuffer();
      //初始用户单独处理
      String guid = basePage.userId();
      int roleCd = _userConsole.findByGuid(logicContext, guid).roleCd();
      if(roleCd == EGcPersonUserRole.Admin){
         menuStrings
            .append("manage.user.module|manage.user.role|product.common.country|product.common.province|product.common.city|product.common.area|product.financial.product|manage.user|product.financial.department|product.financial.lnews|product.financial.customer|product.configration|")
            .append("product.configration.rule|product.system.application|product.system.version|product.financial.marketer|product.device|product.user.logger|product.user.writelists");
         basePage.setMenuString(menuStrings.toString());
      }else{
         long roleId = basePage.roleId();
         if(roleId != 0){
            FLogicDataset<FDataControlRoleModuleUnit> roelModuleInfoList = _roleModuleConsole.selectDataByRoleIdAndModuleId(logicContext, roleId, 0);
            for(FDataControlRoleModuleUnit role : roelModuleInfoList){
               FDataControlModuleUnit module = _moduleConsole.find(logicContext, role.moduleId());
               if(module != null){
                  menuStrings.append(module.code()).append("|");
               }
            }
            basePage.setMenuString(menuStrings.deleteCharAt(menuStrings.length() - 1).toString());
            _logger.debug(this, "TackAuthority", "TackAuthority menuStrings. (menuStrings={1})", basePage.menuString());
         }else{
            basePage.setMenuString(null);
         }
      }
   }
}
