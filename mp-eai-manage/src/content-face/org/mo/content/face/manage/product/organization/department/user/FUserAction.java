package org.mo.content.face.manage.product.organization.department.user;

import com.cyou.gccloud.data.data.FDataOrganizationDepartmentUserUnit;

import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.organization.department.user.FDataUserInfo;
import org.mo.content.core.manage.product.organization.department.user.IUserConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>部门用户控制器</P>
//@class FUserAction
//@version 1.0.0
//============================================================
public class FUserAction 
      implements 
         IUserAction 
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FUserAction.class);

   // 部门用户控制台
   @ALink
   protected IUserConsole _userConsole;
   
   // ============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   // ============================================================
   @Override
   public String construct(IWebContext context, 
                           ILogicContext logicContext, 
                           FBasePage basePage) {

      _logger.debug(this, "Construct", "Construct begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }

      return "/manage/product/organization/department/user/UserList";
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
                        FUserPage Page, 
                        FBasePage basePage) {
      _logger.debug(this, "Select", "Select begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      if (null != context.parameter("page")) {
         String num = context.parameter("page");
         Page.setPageCurrent(Integer.parseInt(num));
      } else {
         Page.setPageCurrent(0);
      }
      FDataUserInfo unit = new FDataUserInfo();
      unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataUserInfo> unitList = _userConsole.select(logicContext, unit, Page.pageCurrent() - 1, pageSize);
      _logger.debug(this, "Select", "Select finish. (unitListCount={1})", unitList.count());
      basePage.setJson(unitList.toJsonListString());
      return "/manage/common/ajax";
   }

   // ============================================================
   // <T>增加之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String insertBefore(IWebContext context, 
                              ILogicContext logicContext, 
                              FUserPage page, 
                              FBasePage basePage) {

      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      page.setResult("");
      return "/manage/product/organization/department/user/InsertUser";
   }

   // ============================================================
   // <T>增加</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String insert(IWebContext context, 
                        ILogicContext logicContext, 
                        FUserPage page, 
                        FBasePage basePage) {
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataOrganizationDepartmentUserUnit unit = _userConsole.doPrepare(logicContext);
      unit.setLabel(context.parameter("label"));
      setProductData(context,logicContext,unit);
      EResult result = _userConsole.doInsert(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("增加失败");
         return "/manage/product/organization/department/user/InsertUser";
      }
      return "/manage/product/organization/department/user/UserList";
   }

   // ============================================================
   // <T>更新之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String updateBefore(IWebContext context, 
                              ILogicContext logicContext, 
                              FUserPage page, 
                              FBasePage basePage) {
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");

      FDataUserInfo info = _userConsole.findInfo(logicContext, id);
      
      page.setUnit(info);
      page.setResult("");
      return "/manage/product/organization/department/user/UpdateUser";
   }

   // ============================================================
   // <T>更新</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String update(IWebContext context, 
                        ILogicContext logicContext, 
                        FUserPage page, 
                        FBasePage basePage) {

      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      FDataOrganizationDepartmentUserUnit unit = _userConsole.find(logicContext, Long.parseLong(context.parameter("ouid")));
      setProductData(context,logicContext,unit);
      EResult result = _userConsole.doUpdate(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("更新失败");
         return "/manage/product/organization/department/user/UpdateUser";
      }
      return "/manage/product/organization/department/user/UserList";
   }

   // ============================================================
   // <T>删除</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String delete(IWebContext context, 
                        ILogicContext logicContext, 
                        FUserPage Page, 
                        FBasePage basePage) {
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataOrganizationDepartmentUserUnit unit = _userConsole.find(logicContext, id);
      if (unit == null) {
         return "/manage/product/organization/department/user/UserList";
      }
      EResult result = _userConsole.doDelete(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         throw new FFatalError("Delete failure.");
      } else {
         return "/manage/product/organization/department/user/UserList";
      }
   }
   // ============================================================
   // <T>抽取公共方法</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   public void setProductData(IWebContext context, 
                              ILogicContext logicContext,
                              FDataOrganizationDepartmentUserUnit unit){
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setCode(context.parameter("code"));
      unit.setName(context.parameter("name"));
      unit.setRelationCd(context.parameterAsInteger("relationCd"));
      unit.setStatusCd(context.parameterAsLong("statusCd"));
      String note = context.parameter("note");
      note = note.replaceAll("<br>", "\r\n");
      unit.setNote(note);
      String entryDateStr = context.parameter("entryDate");
      TDateTime entryDate = new TDateTime();
      entryDate.parse(entryDateStr, "YYYY-MM-DD");
      String leaveDateStr = context.parameter("leaveDate");
      TDateTime leaveDate = new TDateTime();
      leaveDate.parse(leaveDateStr, "YYYY-MM-DD");
      unit.setDepartmentId(context.parameterAsInteger("departmentId"));
   }
}
