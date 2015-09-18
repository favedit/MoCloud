package org.mo.content.face.product.financial.product;

import com.cyou.gccloud.data.data.FDataFinancialCustomerUnit;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.product.financial.customer.ICustomerConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>接口。</P>
//
// @author sunhr
// @version 150718
//============================================================
public class FProductAction
      implements
         IProductAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FProductAction.class);

   //用户控制台
   @ALink
   protected ICustomerConsole _customerConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FBasePage basePage){

      _logger.debug(this, "Construct", "Construct begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }

      return "/manage/product/financial/customer/CustomerList";
   }

   //============================================================
   // <T>查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String select(IWebContext context,
                        ILogicContext logicContext,
                        FProductPage Page,
                        FBasePage basePage){
      _logger.debug(this, "Select", "Select begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         Page.setPageCurrent(Integer.parseInt(num));
      }else{
         Page.setPageCurrent(0);
      }
      FDataFinancialCustomerUnit unit = new FDataFinancialCustomerUnit();
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if(null != StrPageSize){
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataFinancialCustomerUnit> unitList = _customerConsole.select(logicContext, unit, Page.pageCurrent() - 1, pageSize);
      _logger.debug(this, "Select", "Select finish. (unitListCount={1})", unitList.count());
      basePage.setJson(unitList.toJsonListString());
      return "/manage/common/ajax";
   }

   //============================================================
   // <T>增加之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String insertBefore(IWebContext context,
                              ILogicContext logicContext,
                              FProductPage Page,
                              FBasePage basePage){

      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/financial/customer/InsertCustomer";
   }

   //============================================================
   // <T>增加之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String insert(IWebContext context,
                        ILogicContext logicContext,
                        FProductPage page,
                        FBasePage basePage){
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      FDataFinancialCustomerUnit unit = _customerConsole.doPrepare(logicContext);

      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setMemberId(context.parameterAsInteger("memberId"));
      unit.setMarriageStatus(context.parameterAsInteger("marriageStatus"));
      unit.setMonthlyIncome(context.parameterAsInteger("monthlyIncome"));
      unit.setHighestEducation(context.parameterAsInteger("highestEducation"));
      unit.setInterestTotal(context.parameterAsFloat("interestTotal"));
      unit.setInvestmentTotal(context.parameterAsDouble("investmentTotal"));
      unit.setInvestmentCount(context.parameterAsInteger("investmentCount"));
      unit.setRedemptionTotal(context.parameterAsFloat("redemptionTotal"));
      unit.setRedemptionCount(context.parameterAsInteger("redemptionCount"));
      unit.setNetinvestment(context.parameterAsFloat("netinvestmentTotal"));
      unit.setNote(context.parameter("note"));
      unit.setProfession(context.parameterAsInteger("profession"));

      EResult result = _customerConsole.doInsert(logicContext, unit);
      if(!result.equals(EResult.Success)){
         page.setResult("增加失败");
         return "/manage/product/financial/marketer/InsertMarketer";
      }
      return "/manage/product/financial/customer/CustomerList";
   }

   //============================================================
   // <T>更新之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String updateBefore(IWebContext context,
                              ILogicContext logicContext,
                              FProductPage page,
                              FBasePage basePage){
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");

      FDataFinancialCustomerUnit unit = _customerConsole.find(logicContext, id);
      page.setUnit(unit);
      return "/manage/product/financial/customer/UpdateCustomer";
   }

   //============================================================
   // <T>更新</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String update(IWebContext context,
                        ILogicContext logicContext,
                        FProductPage Page,
                        FBasePage basePage){

      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      FDataFinancialCustomerUnit unit = new FDataFinancialCustomerUnit();
      unit.setOuid(Long.parseLong(context.parameter("ouid")));
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setMemberId(context.parameterAsInteger("memberId"));
      int marriageStatus = context.parameterAsInteger("marriageStatus");
      unit.setMarriageStatus(marriageStatus);
      unit.setMonthlyIncome(context.parameterAsInteger("monthlyIncome"));
      unit.setHighestEducation(context.parameterAsInteger("highestEducation"));
      unit.setInterestTotal(context.parameterAsFloat("interestTotal"));
      unit.setInvestmentTotal(context.parameterAsDouble("investmentTotal"));
      unit.setInvestmentCount(context.parameterAsInteger("investmentCount"));
      unit.setRedemptionTotal(context.parameterAsFloat("redemptionTotal"));
      unit.setRedemptionCount(context.parameterAsInteger("redemptionCount"));
      unit.setNetinvestment(context.parameterAsFloat("netinvestmentTotal"));
      unit.setNote(context.parameter("note"));
      unit.setProfession(context.parameterAsInteger("profession"));

      _customerConsole.doUpdate(logicContext, unit);
      return "/manage/common/ajax";
   }

   //============================================================
   // <T>删除</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String delete(IWebContext context,
                        ILogicContext logicContext,
                        FProductPage Page,
                        FBasePage basePage){
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataFinancialCustomerUnit unit = _customerConsole.find(logicContext, id);
      if(unit == null){
         throw new FFatalError("id not exists.");
      }
      EResult result = _customerConsole.doDelete(logicContext, unit);
      if(!result.equals(EResult.Success)){
         throw new FFatalError("Delete failure.");
      }else{
         return "/manage/product/financial/customer/CustomerList";
      }
   }
}
