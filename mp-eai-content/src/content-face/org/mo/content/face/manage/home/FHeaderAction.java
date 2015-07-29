package org.mo.content.face.manage.home;

import org.mo.cloud.core.version.IGcVersionConsole;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.eng.data.common.ISqlContext;
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
      //      _logger.debug(this, "construct", "construct begin. (currentVersion={1})", _versonConsole.currentVersion());
      //      basePage.setVersion(_versonConsole.currentVersion());

      return "#/manage/home/Header";
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
                             ISqlContext sqlContext,
                             FBasePage basePage){
      _logger.debug(this, "Header", "Header productLeft begin. (roleId={1})", context.parameterAsLong("roleId"));
      //      tackAuthority(context, sqlContext, basePage);
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
                              ISqlContext sqlContext,
                              FBasePage basePage){
      _logger.debug(this, "Header", "Header analysisLeft begin. (roleId={1})", context.parameterAsLong("roleId"));
      tackAuthority(context, sqlContext, basePage);
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
                            ISqlContext sqlContext,
                            FBasePage basePage){
      _logger.debug(this, "Header", "Header manageLeft begin. (roleId={1})", context.parameterAsLong("roleId"));
      tackAuthority(context, sqlContext, basePage);
      return "#/manage/home/ManageLeft";
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
                              ISqlContext sqlContext,
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
                              ISqlContext sqlContext,
                              FBasePage basePage){
      //      _logger.debug(this, "TackAuthority", "TackAuthority begin. (roleId={1})", context.parameterAsLong("roleId"));
      //      long roleId = context.parameterAsLong("roleId");
      //      if(roleId != 0){
      //         FLogicDataset<FDataLogicRoleModuleUnit> roelModuleInfoList = _roleModuleConsole.selectDataByRoleIdAndModuleId(sqlContext, roleId, 0);
      //         StringBuffer menuStrings = new StringBuffer();
      //         for(FDataLogicRoleModuleUnit role : roelModuleInfoList){
      //            FDataLogicModuleUnit module = _moduleConsole.find(sqlContext, role.moduleId());
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
