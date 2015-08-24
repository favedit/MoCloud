package org.mo.content.face.manage.module;

import com.cyou.gccloud.data.data.FDataControlModuleUnit;
import com.cyou.gccloud.data.data.FDataControlRoleModuleUnit;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.module.FDataControlModuleInfo;
import org.mo.content.core.manage.module.IModuleConsole;
import org.mo.content.core.manage.role.IRoleModuleConsole;
import org.mo.content.core.manage.user.IUserConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
//============================================================
//<P>后台模块逻辑实现类</P>
//
//@class FModuleAction
//@author Sunhr
//@Date 2014.12.08  
//@version 1.0.0
//============================================================

public class FModuleAction
      implements
         IModuleAction
{

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FModuleAction.class);

   //模块控制台
   @ALink
   protected IModuleConsole _moduleConsole;

   //角色模块控制台
   @ALink
   protected IRoleModuleConsole _roleModuleConsole;

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
                           FBasePage basePage){
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "#/manage/module/ModuleList";
   }

   // ============================================================
   // <T>数据分页查询</T>
   //
   // @param context 上下文
   // @param logicContext 数据库连接
   // @param modulePage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String selectDataByPage(IWebContext context,
                                  ILogicContext logicContext,
                                  FModulePage modulePage,
                                  FBasePage basePage){
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "SelectDataByPage", "SelectDataByPage begin. (page={1},label={2})", context.parameter("page"), context.parameter("code"));
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         modulePage.setPageCurrent(Integer.parseInt(num));
      }else{
         modulePage.setPageCurrent(0);
      }
      FDataControlModuleUnit moduleUnit = new FDataControlModuleUnit();
      moduleUnit.setCode(context.parameter("code"));
      FLogicDataset<FDataControlModuleUnit> moduleUnitList = _moduleConsole.selectDataByPageAndSomerow(logicContext, moduleUnit, modulePage.pageCurrent() - 1);
      basePage.toJson(moduleUnitList.toJsonListString());
      _logger.debug(this, "SelectDataByPage", "SelectDataByPage Finish. (moduleUnitList={1})", moduleUnitList.count());
      return "#/common/ajax";
   }

   // ============================================================
   // <T>数据分页查询</T>
   //
   // @param context 上下文
   // @param logicContext 数据库连接
   // @param modulePage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String selectAll(IWebContext context,
                           ILogicContext logicContext,
                           FBasePage basePage){
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "SelectDataByPage", "SelectDataByPage begin. (page={1},label={2})", context.parameter("page"), context.parameter("code"));
      FLogicDataset<FDataControlModuleInfo> moduleUnitList = _moduleConsole.selectModule(logicContext);
      basePage.toJson(moduleUnitList.toJsonListString());
      _logger.debug(this, "SelectDataByPage", "SelectDataByPage Finish. (moduleUnitList={1})", moduleUnitList.count());
      return "#/common/ajax";
   }

   // ============================================================
   // <T>删除数据</T>
   //
   // @param context 上下文
   // @param logicContext 数据库连接
   // @param modulePage 页面
   // @return 要跳转页面
   // ============================================================
   @Override
   public String delete(IWebContext context,
                        ILogicContext logicContext,
                        FBasePage basePage){
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Delete", "Delete begin. (moduleId={1})", context.parameter("id"));
      try{
         long moduleId = context.parameterAsLong("id");
         FLogicDataset<FDataControlRoleModuleUnit> roleModuleList = _roleModuleConsole.selectDataByRoleIdAndModuleId(logicContext, 0, moduleId);
         if(roleModuleList.count() > 0){
            basePage.setJson("2");
            _logger.debug(this, "Delete", "Delete Error,Is being used. (moduleId={1})", moduleId);
         }else{
            _moduleConsole.doDelete(logicContext, moduleId);
            basePage.setJson("1");
            _logger.debug(this, "Delete", "Delete succeed, (moduleId={1})", moduleId);
         }
      }catch(Exception e){
         e.printStackTrace();
         basePage.setJson("0");
      }
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
      _logger.debug(this, "InsertPrepare", "InsertPrepare begin.");
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      basePage.setMessage("");
      return "#/manage/module/InsertModule";
   }

   // ============================================================
   // <T>新增数据</T>
   //
   // @param context 上下文
   // @param logicContext 数据库连接
   // @param modulePage 容器
   // @param basePage 容器
   // @return 要跳转页面
   // ============================================================
   @Override
   public String insert(IWebContext context,
                        ILogicContext logicContext,
                        FModulePage modulePage,
                        FBasePage basePage){
      _logger.debug(this, "Insert", "Insert insert begin.");
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      String code = context.parameter("code").trim();
      FDataControlModuleUnit module = _moduleConsole.findByCode(logicContext, code);
      if(module != null){
         basePage.setMessage("代码已存在！");
         return "#/manage/module/InsertModule";
      }
      FDataControlModuleUnit moduleUnit = new FDataControlModuleUnit();
      moduleUnit.setOvld(true);
      moduleUnit.setCode(code);
      moduleUnit.setLabel(context.parameter("label"));
      moduleUnit.setNote(context.parameter("note"));
      long userouid = _userConsole.findByGuid(logicContext, context.parameter("adminId")).ouid();
      moduleUnit.setCreateUserId(userouid);
      _moduleConsole.doInsert(logicContext, moduleUnit);
      _logger.debug(this, "Insert", "Insert finish.");
      return "#/manage/module/ModuleList";
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
                               FModulePage modulePage,
                               FBasePage basePage){
      _logger.debug(this, "UpdatePrepare", "UpdatePrepare begin. (moduleId={1})", context.parameter("moduleId"));
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      basePage.setMessage("");
      long id = context.parameterAsLong("id");
      modulePage.setModule(_moduleConsole.find(logicContext, id));
      _logger.debug(this, "UpdatePrepare", "UpdatePrepare finish. (module={1})", modulePage.module());
      return "#/manage/module/UpdateModule";
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
                        FModulePage modulePage,
                        FBasePage basePage){
      _logger.debug(this, "Update", "Update begin. (ouid={1})", context.parameterAsLong("ouid"));
      long id = context.parameterAsLong("ouid");
      String code = context.parameter("code").trim();
      FDataControlModuleUnit moduleUnit = _moduleConsole.find(logicContext, id);
      //      moduleUnit.setOvld(context.parameter("ovld") == null ? false : true);
      moduleUnit.setCode(code);
      if(moduleUnit.isCodeChanged()){
         FDataControlModuleUnit module = _moduleConsole.findByCode(logicContext, code);
         if(module != null){
            basePage.setMessage("代码已存在！");
            return "#/manage/module/UpdateModule";
         }
      }
      moduleUnit.setLabel(context.parameter("label"));
      moduleUnit.setNote(context.parameter("note"));
      long userouid = _userConsole.findByGuid(logicContext, context.parameter("adminId")).ouid();
      moduleUnit.setUpdateUserId(userouid);
      _moduleConsole.doUpdate(logicContext, moduleUnit);
      _logger.debug(this, "Update", "Update finish.");
      return "#/manage/module/ModuleList";
   }
}
