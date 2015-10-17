package org.mo.content.face.manage.product.financial.marketer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.financial.marketer.IMarketerConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>理财师信息控制器</P>
//@class FMarketerAction
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================
public class FMarketerAction 
      implements 
         IMarketerAction 
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMarketerAction.class);

   // 理财师控制台
   @ALink
   protected IMarketerConsole _marketerConsole;

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

      return "/manage/product/financial/marketer/MarketerList";
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
                        FMarketerPage Page, 
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
      FDataFinancialMarketerUnit unit = new FDataFinancialMarketerUnit();
      unit.setName(context.parameter("name"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataFinancialMarketerUnit> unitList = _marketerConsole.select(logicContext, unit, Page.pageCurrent() - 1, pageSize);
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
                              FMarketerPage Page, 
                              FBasePage basePage) {

      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/financial/marketer/InsertMarketer";
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
                        FMarketerPage page, 
                        FBasePage basePage) {
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataFinancialMarketerUnit unit = _marketerConsole.doPrepare(logicContext);

      // 客户投资时间
      String customerInvestmentDate = context.parameter("customerInvestmentDate");
      if (!"".equals(customerInvestmentDate) && null != customerInvestmentDate) {
         TDateTime dateTime = null;
         try {
            dateTime = new TDateTime(new SimpleDateFormat("yyyy-MM-dd").parse(customerInvestmentDate));
            unit.setCustomerInvestmentDate(dateTime);
         } catch (ParseException e) {
            e.printStackTrace();
         }
      }
      // 客户赎回时间
      String customerRedemptionDate = context.parameter("customerRedemptionDate");
      if (!"".equals("customerRedemptionDate") && null != customerRedemptionDate) {
         TDateTime dateTime = null;
         try {
            dateTime = new TDateTime(new SimpleDateFormat("yyyy-MM-dd").parse(customerRedemptionDate));
            unit.setCustomerRedemptionDate(dateTime);
         } catch (ParseException e) {
            e.printStackTrace();
         }
      }
      // 客户投资总额
      unit.setCustomerInvestmentTotal(context.parameterAsDouble("customerInvestmentTotal"));
      unit.setCustomerInvestmentCount(context.parameterAsInteger("customerInvestmentCount"));
      unit.setCustomerRedemptionTotal(context.parameterAsDouble("customerRedemptionTotal"));
      unit.setCustomerRedemptionCount(context.parameterAsInteger("customerRedemptionCount"));
      unit.setCustomerNetinvestmentTotal(context.parameterAsDouble("customerNetinvestmentTotal"));
      unit.setCustomerInterestTotal(context.parameterAsDouble("customerInterestTotal"));
      unit.setCustomerPerformanceTotal(context.parameterAsDouble("customerPerformanceTotal"));
      // 是否删除
      unit.setName(context.parameter("name"));
      unit.setLabel(context.parameter("label"));
      unit.setStatusCd(context.parameterAsInteger("statusCd"));
      unit.setNote(context.parameter("note"));
      unit.setPhone(context.parameter("phone"));
      unit.setRankLabel(context.parameter("rankLabel"));
      unit.setDepartmentLabel(context.parameter("departmentLabel"));
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      EResult result = _marketerConsole.doInsert(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("增加失败");
         return "/manage/product/financial/marketer/InsertMarketer";
      }
      return "/manage/product/financial/marketer/MarketerList";
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
                              FMarketerPage page, 
                              FBasePage basePage) {
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");

      FDataFinancialMarketerUnit unit = _marketerConsole.find(logicContext, id);
      page.setUnit(unit);
      page.setCustomerInvestmentDate(unit.customerInvestmentDate().format("yyyy-mm-dd hh24:mi:ss"));
      page.setCustomerRedemptionDate(unit.customerRedemptionDate().format("yyyy-mm-dd hh24:mi:ss"));
      return "/manage/product/financial/marketer/UpdateMarketer";
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
                        FMarketerPage Page, 
                        FBasePage basePage) {

      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      FDataFinancialMarketerUnit unit = new FDataFinancialMarketerUnit();
      unit.setOuid(Long.parseLong(context.parameter("ouid")));

      // 客户投资时间
      String customerInvestmentDate = context.parameter("customerInvestmentDate");
      if (!"".equals(customerInvestmentDate) && null != customerInvestmentDate) {
         TDateTime dateTime = null;
         try {
            dateTime = new TDateTime(new SimpleDateFormat("yyyy-MM-dd").parse(customerInvestmentDate));
            unit.setCustomerInvestmentDate(dateTime);
         } catch (ParseException e) {
            e.printStackTrace();
         }
      }
      // 客户赎回时间
      String customerRedemptionDate = context.parameter("customerRedemptionDate");
      if (!"".equals("customerRedemptionDate") && null != customerRedemptionDate) {
         TDateTime dateTime = null;
         try {
            dateTime = new TDateTime(new SimpleDateFormat("yyyy-MM-dd").parse(customerRedemptionDate));
            unit.setCustomerRedemptionDate(dateTime);
         } catch (ParseException e) {
            e.printStackTrace();
         }
      }
      // 客户投资总额
      unit.setCustomerInvestmentTotal(context.parameterAsDouble("customerInvestmentTotal"));
      unit.setCustomerInvestmentCount(context.parameterAsInteger("customerInvestmentCount"));
      unit.setCustomerRedemptionTotal(context.parameterAsDouble("customerRedemptionTotal"));
      unit.setCustomerRedemptionCount(context.parameterAsInteger("customerRedemptionCount"));
      unit.setCustomerNetinvestmentTotal(context.parameterAsDouble("customerNetinvestmentTotal"));
      unit.setCustomerInterestTotal(context.parameterAsDouble("customerInterestTotal"));
      unit.setCustomerPerformanceTotal(context.parameterAsDouble("customerPerformanceTotal"));
      // 是否删除
      unit.setName(context.parameter("name"));
      unit.setLabel(context.parameter("label"));
      unit.setStatusCd(context.parameterAsInteger("statusCd"));
      unit.setNote(context.parameter("note"));
      unit.setPhone(context.parameter("phone"));
      unit.setRankLabel(context.parameter("rankLabel"));
      unit.setDepartmentLabel(context.parameter("departmentLabel"));
      unit.setCreateUserId(context.parameterAsLong("adminId"));

      _marketerConsole.doUpdate(logicContext, unit);
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
                        FMarketerPage Page, 
                        FBasePage basePage) {
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataFinancialMarketerUnit unit = _marketerConsole.find(logicContext, id);
      if (unit == null) {
         throw new FFatalError("id not exists.");
      }
      EResult result = _marketerConsole.doDelete(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         throw new FFatalError("Delete failure.");
      } else {
         return "/manage/product/financial/marketer/MarketerList";
      }
   }
}
