package org.mo.content.face.manage.product.financial.product;

import com.cyou.gccloud.data.data.FDataFinancialProductUnit;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.financial.product.IProductConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>产品信息控制器</P>
//@class FProductAction
//@version 1.0.0
//============================================================
public class FProductAction 
      implements 
         IProductAction 
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FProductAction.class);

   // 产品控制台
   @ALink
   protected IProductConsole _productConsole;

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

      return "/manage/product/financial/product/ProductList";
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
                        FProductPage Page, 
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
      FDataFinancialProductUnit unit = new FDataFinancialProductUnit();
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataFinancialProductUnit> unitList = _productConsole.select(logicContext, unit, Page.pageCurrent() - 1, pageSize);
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
                              FProductPage Page, 
                              FBasePage basePage) {

      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/financial/product/InsertProduct";
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
                        FProductPage page, 
                        FBasePage basePage) {
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataFinancialProductUnit unit = _productConsole.doPrepare(logicContext);
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setNote(context.parameter("note"));
      unit.setLabel(context.parameter("label"));
      unit.setName(context.parameter("name"));
      unit.setTimeLimit(context.parameterAsInteger("timeLimit"));
      unit.setAnnualRateOfReturn(context.parameterAsFloat("annualRateOfReturn"));
      unit.setRentPerson(context.parameter("rentPerson"));
      unit.setTenantPerson(context.parameter("tenantPerson"));
      EResult result = _productConsole.doInsert(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("增加失败");
         return "/manage/product/financial/product/InsertProduct";
      }
      return "/manage/product/financial/product/ProductList";
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
                              FProductPage page, 
                              FBasePage basePage) {
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");

      FDataFinancialProductUnit unit = _productConsole.find(logicContext, id);
      page.setUnit(unit);
      return "/manage/product/financial/product/UpdateProduct";
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
                        FProductPage page, 
                        FBasePage basePage) {

      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      FDataFinancialProductUnit unit = new FDataFinancialProductUnit();
      unit.setOuid(Long.parseLong(context.parameter("ouid")));
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setNote(context.parameter("note"));
      unit.setLabel(context.parameter("label"));
      unit.setName(context.parameter("name"));
      unit.setTimeLimit(context.parameterAsInteger("timeLimit"));
      unit.setAnnualRateOfReturn(context.parameterAsFloat("annualRateOfReturn"));
      unit.setRentPerson(context.parameter("rentPerson"));
      unit.setTenantPerson(context.parameter("tenantPerson"));
      EResult result = _productConsole.doUpdate(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("更新失败");
         return "/manage/product/financial/product/UpdateProduct";
      }
      return "/manage/common/ajax";
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
                        FProductPage Page, 
                        FBasePage basePage) {
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataFinancialProductUnit unit = _productConsole.find(logicContext, id);
      if (unit == null) {
         throw new FFatalError("id not exists.");
      }
      EResult result = _productConsole.doDelete(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         throw new FFatalError("Delete failure.");
      } else {
         return "/manage/product/financial/customer/CustomerList";
      }
   }
}
