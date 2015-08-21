package org.mo.content.face.manage.role;

import com.cyou.gccloud.data.data.FDataControlRoleLogic;
import com.cyou.gccloud.data.data.FDataControlRoleModuleUnit;
import com.cyou.gccloud.data.data.FDataControlRoleUnit;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.module.FDataControlModuleInfo;
import org.mo.content.core.manage.module.IModuleConsole;
import org.mo.content.core.manage.role.IRoleConsole;
import org.mo.content.core.manage.role.IRoleModuleConsole;
import org.mo.content.core.manage.user.IUserConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
//============================================================
//<P>后台角色逻辑实现类</P>
//
//@class FRoleAction
//@author Sunhr
//@Date 2014.12.08
//@version 1.0.0
//============================================================

public class FRoleAction
      implements
         IRoleAction
{

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FRoleAction.class);

   //角色控制台
   @ALink
   protected IRoleConsole _roleConsole;

   //角色模块控制台
   @ALink
   protected IRoleModuleConsole _roleModuleConsole;

   //模块控制台
   @ALink
   protected IModuleConsole _moduleConsole;

   //用户控制台
   @ALink
   protected IUserConsole _userConsole;

   // ============================================================
   // <T>默认跳转函数</T>
   //
   // @param context 上下文
   // @return 要跳转页面
   // ============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FBasePage basePage){
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Construct", "Construct Begin.");
      return "#/manage/role/RoleList";
   }

   // ============================================================
   // <T>数据分页查询</T>
   //
   // @param context 上下文
   // @param logicContext 数据库连接
   // @param rolePage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String selectDataByPage(IWebContext context,
                                  ILogicContext logicContext,
                                  FRolePage rolePage,
                                  FBasePage basePage){
      _logger.debug(this, "Role", "Role selectDataByPage begin. (page={1},label={2})", context.parameter("page"), context.parameter("label"));
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         rolePage.setPageCurrent(Integer.parseInt(num));
      }else{
         rolePage.setPageCurrent(0);
      }
      FDataControlRoleUnit roleUnit = new FDataControlRoleUnit();
      roleUnit.setCode(context.parameter("code"));
      FLogicDataset<FDataControlRoleUnit> roleUnitList = _roleConsole.selectDataByPageAndSomerow(logicContext, roleUnit, rolePage.pageCurrent() - 1);
      basePage.toJson(roleUnitList.toJsonListString());
      _logger.debug(this, "Role", "Role selectDataByPage Finish. (roleUnitList={1})", roleUnitList.count());
      return "#/common/ajax";
   }

   // ============================================================
   // <T>删除数据</T>
   //
   // @param context 上下文
   // @param logicContext 数据库连接
   // @param rolePage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String delete(IWebContext context,
                        ILogicContext logicContext,
                        FBasePage basePage){
      _logger.debug(this, "Role", "Role delete begin. (roleId={1})", context.parameter("roleId"));
      try{
         long roleId = context.parameterAsLong("roleId");
         EResult result = _userConsole.roleExists(logicContext, String.valueOf(roleId));
         if(!result.equals(EResult.Success)){
            //删除角色所拥有的权限
            _roleModuleConsole.deleteByRoleId(logicContext, roleId);
            //删除此角色
            _roleConsole.doDelete(logicContext, roleId);
            basePage.setJson("1");
         }else{
            basePage.setJson("0");
         }

      }catch(Exception e){
         e.printStackTrace();
         basePage.setJson("0");
      }
      _logger.debug(this, "Role", "Role delete finish. (ajax={1})", basePage.json());
      return "#/common/ajax";
   }

   // ============================================================
   // <T>加载新增页面</T>
   //
   // @param context 上下文
   // @param logicContext 数据库连接
   // @param basePage 容器
   // @return 要跳转页面
   // ============================================================
   @Override
   public String insertPrepare(IWebContext context,
                               ILogicContext logicContext,
                               FBasePage basePage){
      _logger.debug(this, "Role", "Role insertPrepare begin.");
      return "#/manage/role/InsertRole";
   }

   // ============================================================
   // <T>新增数据</T>
   //
   // @param context 上下文
   // @param logicContext 数据库连接
   // @param rolePage 容器
   // @param basePage 容器
   // @return 要跳转页面
   // ============================================================
   @Override
   public String insert(IWebContext context,
                        ILogicContext logicContext,
                        FRolePage rolePage,
                        FBasePage basePage){
      _logger.debug(this, "Role", "Role insert begin.");
      FDataControlRoleUnit roleUnit = new FDataControlRoleUnit();
      roleUnit.setOvld(true);
      roleUnit.setCode(context.parameter("code"));
      roleUnit.setLabel(context.parameter("label"));
      roleUnit.setNote(context.parameter("note"));
      String userId = context.parameter("adminId");
      long userOuid = _userConsole.findByGuid(logicContext, userId).ouid();
      roleUnit.setCreateUserId(userOuid);
      _roleConsole.doInsert(logicContext, roleUnit);
      //为角色添加查看权限
      String tempModuleIds = context.parameter("moduleIds");
      if(!RString.isEmpty(tempModuleIds)){
         String[] moduleIds = tempModuleIds.split(",");
         FDataControlRoleModuleUnit roleModuleUnit = new FDataControlRoleModuleUnit();
         for(int i = 0; i < moduleIds.length; i++){
            long moduleId = Long.parseLong(moduleIds[i]);
            roleModuleUnit.setOvld(true);
            roleModuleUnit.setRoleId(roleUnit.ouid());
            roleModuleUnit.setModuleId(moduleId);
            roleModuleUnit.setViewValidCd(1);
            roleModuleUnit.setCreateUserId(userOuid);
            _roleModuleConsole.doInsert(logicContext, roleModuleUnit);
         }
      }
      _logger.debug(this, "Role", "Role insert finish.");
      return "#/manage/role/RoleList";
   }

   // ============================================================
   // <T>修改数据之前的操作</T>
   //
   // @param context 上下文
   // @param logicContext 数据库连接
   // @return 要跳转页面
   // ============================================================
   @Override
   public String updatePrepare(IWebContext context,
                               ILogicContext logicContext,
                               FRolePage rolePage,
                               FBasePage basePage){
      _logger.debug(this, "Role", "Role delete begin. (roleId={1})", context.parameter("id"));
      long roleId = context.parameterAsLong("id");
      rolePage.setRole(_roleConsole.find(logicContext, roleId));
      return "#/manage/role/UpdateRole";
   }

   // ============================================================
   // <T>修改数据</T>
   //
   // @param context 上下文
   // @param logicContext 数据库连接
   // @return 要跳转页面
   // ============================================================
   @Override
   public String update(IWebContext context,
                        ILogicContext logicContext,
                        FRolePage rolePage,
                        FBasePage basePage){
      _logger.debug(this, "Role", "Role update begin. (ouid={1})", context.parameterAsLong("roleId"));
      String adminId = context.parameter("adminId");
      long roleId = context.parameterAsLong("roleId");
      long userOuid = _userConsole.findByGuid(logicContext, adminId).ouid();
      FDataControlRoleUnit roleUnit = logicContext.findLogic(FDataControlRoleLogic.class).find(roleId);
      //      roleUnit.setOvld(context.parameter("ovld") == null ? false : true);
      roleUnit.setCode(context.parameter("code"));
      roleUnit.setLabel(context.parameter("label"));
      roleUnit.setNote(context.parameter("note"));
      roleUnit.setUpdateUserId(userOuid);
      _roleConsole.doUpdate(logicContext, roleUnit);
      //删除此角色所拥有的权限
      _roleModuleConsole.deleteByRoleId(logicContext, roleUnit.ouid());
      //为角色添加查看权限
      String[] moduleIds = context.parameter("moduleIds").split(",");
      FDataControlRoleModuleUnit roleModuleUnit = new FDataControlRoleModuleUnit();
      for(int i = 0; i < moduleIds.length; i++){
         long moduleId = Long.parseLong(moduleIds[i]);
         roleModuleUnit.setOvld(true);
         roleModuleUnit.setRoleId(roleUnit.ouid());
         roleModuleUnit.setModuleId(moduleId);
         roleModuleUnit.setViewValidCd(1);
         roleModuleUnit.setCreateUserId(userOuid);
         _roleModuleConsole.doInsert(logicContext, roleModuleUnit);
      }
      _logger.debug(this, "Role", "Role update finish.");
      return "#/manage/role/RoleList";
   }

   // ============================================================
   // <T>查询角色模块</T>
   //
   // @param context 上下文
   // @param logicContext 数据库连接
   // @param userPage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String selectRoleModule(IWebContext context,
                                  ILogicContext logicContext,
                                  FRolePage rolePage,
                                  FBasePage basePage){
      _logger.debug(this, "Role", "Role selectRoleModule begin. (page={1})", context.parameter("page"));
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         rolePage.setPageCurrent(Integer.parseInt(num));
      }else{
         rolePage.setPageCurrent(0);
      }
      long roleId = context.parameterAsLong("roleId");
      FLogicDataset<FDataControlModuleInfo> moduleInfoList = _moduleConsole.selectModule(logicContext, rolePage.pageCurrent() - 1);
      for(FDataControlModuleInfo moduleInfo : moduleInfoList){
         FLogicDataset<FDataControlRoleModuleUnit> roleModuleUnitList = _roleModuleConsole.selectDataByRoleIdAndModuleId(logicContext, roleId, moduleInfo.ouid());
         if(roleModuleUnitList.count() != 0){
            moduleInfo.setViewValidCd(roleModuleUnitList.first().viewValidCd());
         }
      }
      basePage.setJson(moduleInfoList.toJsonListString());
      _logger.debug(this, "Role", "Role selectRoleModule finish. (moduleInfoList={1})", moduleInfoList.count());
      return "#/common/ajax";
   }

   // ============================================================
   // <T>查询所有角色</T>
   //
   // @param context 上下文
   // @param logicContext 数据库连接
   // @param basePage ajax
   // @return 要跳转页面
   // ============================================================
   @Override
   public String selectAll(IWebContext context,
                           ILogicContext logicContext,
                           FBasePage basePage){
      _logger.debug(this, "Role", "Role selectAll begin.");
      FLogicDataset<FDataControlRoleUnit> roleList = _roleConsole.selectDataByPageAndSomerow(logicContext, new FDataControlRoleUnit(), 0);
      basePage.setJson(roleList.toJsonString());
      _logger.debug(this, "Role", "Role selectAll begin. (roleList={1})", roleList.count());
      return "#/common/ajax";
   }
}
