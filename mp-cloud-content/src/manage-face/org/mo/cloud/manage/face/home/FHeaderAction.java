package org.mo.cloud.manage.face.home;

import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.face.base.FBasePage;
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

   //
   //   //控制台
   //   @ALink
   //   protected IRoleModuleConsole _roleModuleConsole;
   //
   //   //控制台
   //   @ALink
   //   protected IModuleConsole _moduleConsole;

   //   @ALink
   //   protected IGcVersionConsole _versonConsole;

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
      System.out.println("=========FHeaderAction.construct=======");
      //_logger.debug(this, "construct", "construct begin. (currentVersion={1})", _versonConsole.currentVersion());
      basePage.setVersion("1.0");//(_versonConsole.currentVersion());

      // test
      //productLeft(context, null, basePage);

      return "#/home/Header";
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
                             FBasePage basePage){
      System.out.println("============FHeaderAction.productLeft======");
      _logger.debug(this, "Header", "Header productLeft begin. (roleId={1})", context.parameterAsLong("roleId"));
      tackAuthority(context, logicContext, basePage);
      return "#/home/ProductLeft";
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
      tackAuthority(context, logicContext, basePage);
      return "#/home/AnalysisLeft";
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
      tackAuthority(context, logicContext, basePage);
      return "#/home/ManageLeft";
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
      String passport = context.parameter("passport");
      if(RString.equalsIgnoreCase("admin", passport)){
         return "#/home/DatabaseLeft";
      }else{
         basePage.setJson("只有admin用户才能进入此功能模块！");
         return "#/common/ajax";
      }
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
      //      _logger.debug(this, "TackAuthority", "TackAuthority begin. (roleId={1})", context.parameterAsLong("roleId"));
      //      long roleId = context.parameterAsLong("roleId");
      //      if(roleId != 0){
      //         FLogicDataset<FDataSystemRoleModuleUnit> roelModuleInfoList = _roleModuleConsole.selectDataByRoleIdAndModuleId(logicContext, roleId, 0);
      //         StringBuffer menuStrings = new StringBuffer();
      //         for(FDataSystemRoleModuleUnit role : roelModuleInfoList){
      //            FDataSystemModuleUnit module = _moduleConsole.find(logicContext, role.moduleId());
      //            if(module != null){
      //               menuStrings.append(module.code()).append("|");
      //            }
      //         }
      //         basePage.setMenuString(menuStrings.deleteCharAt(menuStrings.length() - 1).toString());
      //         _logger.debug(this, "TackAuthority", "TackAuthority menuStrings. (menuStrings={1})", basePage.menuString());
      //      }else{
      //         basePage.setMenuString(null);
      //      }
   }
}
