/**
 * 
 */
package org.mo.content.face.manage.product.organization.department;

import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.organization.department.FDataDepartmentInfo;
import org.mo.content.core.manage.product.organization.department.IDepartmentConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

import com.cyou.gccloud.data.data.FDataOrganizationDepartmentUnit;

//============================================================
//<P>组织部门信息控制器</P>
//@class FDepartmentAction
//@version 1.0.0
//============================================================
public class FDepartmentAction
      implements
         IDepartmentAction
{
   // 组织部门控制台
   @ALink
   protected IDepartmentConsole _departmentConsole;
   
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FDepartmentAction.class);
   

   // ============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   // ============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FBasePage page){
      _logger.debug(this, "Construct", "Construct begin. (userId={1})", page.userId());
      if (!page.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/organization/department/DepartmentList";
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
                        FDepartmentPage page,
                        FBasePage basePage){
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
      FDataDepartmentInfo unit = new FDataDepartmentInfo();
      unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataDepartmentInfo> unitList = _departmentConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
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
                              FDepartmentPage page,
                              FBasePage basePage){
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      page.setResult("");
      return "/manage/product/organization/department/InsertDepartment";
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
                        FDepartmentPage page,
                        FBasePage basePage){
      FDataOrganizationDepartmentUnit unit = _departmentConsole.doPrepare(logicContext);
      setCommonData(context,logicContext,unit);
      EResult result = _departmentConsole.doInsert(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("增加失败");
         return "/manage/product/organization/department/InsertDepartment";
      }
      return "/manage/product/organization/department/DepartmentList";
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
                              FDepartmentPage page,
                              FBasePage basePage){
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");

      FDataDepartmentInfo info = _departmentConsole.findInfo(logicContext, id);
      
      page.setUnit(info);
      page.setResult("");
      return "/manage/product/organization/department/UpdateDepartment";
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
                        FDepartmentPage page,
                        FBasePage basePage){
      FDataOrganizationDepartmentUnit unit = _departmentConsole.find(logicContext, Long.parseLong(context.parameter("ouid")));
      setCommonData(context,logicContext,unit);
      EResult result = _departmentConsole.doUpdate(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("更新失败");
         return "/manage/product/organization/department/UpdateDepartment";
      }
      return "/manage/product/organization/department/DepartmentList";
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
                        FDepartmentPage Page,
                        FBasePage basePage){
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataOrganizationDepartmentUnit unit = _departmentConsole.find(logicContext, id);
      if (unit == null) {
         return "manage/product/organization/department/DepartmentList";
      }
      EResult result = _departmentConsole.doDelete(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         throw new FFatalError("Delete failure.");
      } else {
         return "/manage/product/organization/department/DepartmentList";
      }
   }

   // ============================================================
   // <T>全查</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String selectAll(IWebContext context, 
                           ILogicContext logicContext, 
                           FBasePage basePage) {
      FLogicDataset<FDataOrganizationDepartmentUnit> countryList = _departmentConsole.selectAll(logicContext);
      basePage.setJson(countryList.toJsonString());
      return "/manage/common/ajax";
   }
   // ============================================================
   // <T>公共方法</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param unit 模型
   // @return void 
   // ============================================================
   public void setCommonData(IWebContext context,
                             ILogicContext logicContext,
                             FDataOrganizationDepartmentUnit unit){
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setCode(context.parameter("code"));
      String description = context.parameter("description");
      description = description.replaceAll("<br>", "\r\n");
      unit.setDescription(description);
      String buildDateStr = context.parameter("buildDate");
      TDateTime buildDate = new TDateTime();
      buildDate.parse(buildDateStr, "YYYY-MM-DD");
      unit.setBuildDate(buildDate);
      unit.setLabel(context.parameter("label"));
      unit.setName(context.parameter("name"));
      unit.setUserCount(context.parameterAsInteger("userCount"));
      Long parentId = context.parameterAsLong("parentId");
      unit.setParentId(parentId);
      FDataOrganizationDepartmentUnit unitp = _departmentConsole.findParentUnitByParentId(logicContext,parentId);
      if(unitp!=null){
         unit.setPathIds(unitp.pathIds()+"/"+unitp.ouid());
         unit.setPathLabels(unitp.pathLabels()+"/"+unitp.label());
      }
      unit.setValidCd(context.parameterAsInteger("validCd"));
   }
}
