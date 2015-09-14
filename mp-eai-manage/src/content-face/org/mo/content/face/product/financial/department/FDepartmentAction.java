package org.mo.content.face.product.financial.department;

import com.cyou.gccloud.data.data.FDataFinancialDepartmentUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.product.financial.department.IDepartmentConsole;
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
public class FDepartmentAction
      implements
         IDepartmentAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FDepartmentAction.class);

   //用户控制台
   @ALink
   protected IDepartmentConsole _departmentConsole;

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

      return "/manage/product/financial/department/DeptList";
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
                        FDepartmentPage Page,
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
      FDataFinancialDepartmentUnit unit = new FDataFinancialDepartmentUnit();
      unit.setCode(context.parameter("code"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if(null != StrPageSize){
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataFinancialDepartmentUnit> unitList = _departmentConsole.select(logicContext, unit, Page.pageCurrent() - 1, pageSize);
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
                              FDepartmentPage Page,
                              FBasePage basePage){
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/financial/department/InsertDept";
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
                        FDepartmentPage page,
                        FBasePage basePage){
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      FDataFinancialDepartmentUnit unit = _departmentConsole.doPrepare(logicContext);
      String provinceId = context.parameter("provinceId");
      if(!"".equals(provinceId) && null != provinceId){
         unit.setProvinceId(Integer.parseInt(provinceId));
      }
      String cityId = context.parameter("cityId");
      if(!"".equals(cityId) && cityId != null){
         unit.setCityId(Integer.parseInt(cityId));
      }
      String regionId = context.parameter("regionId");
      if(!"".equals(regionId) && null != regionId){
         unit.setRegionId(Integer.parseInt(regionId));
      }

      //投资时间
      String investmentDate = context.parameter("investmentDate");
      if(!"".equals(investmentDate) && null != investmentDate){
         TDateTime dateTime = null;
         try{
            dateTime = new TDateTime(new SimpleDateFormat("yyyy-MM-dd").parse(investmentDate));
         }catch(ParseException e){
            e.printStackTrace();
         }
         unit.setInvestmentDate(dateTime);
      }
      //赎回时间
      String redemptionDate = context.parameter("redemptionDate");
      if(!"".equals("redemptionDate") && null != redemptionDate){
         TDateTime dateTime = null;
         try{
            dateTime = new TDateTime(new SimpleDateFormat("yyyy-MM-dd").parse(redemptionDate));
         }catch(ParseException e){
            e.printStackTrace();
         }
         unit.setRedemptionDate(dateTime);
      }
      unit.setLevel(context.parameterAsInteger("level"));
      //是否删除
      String ovld = context.parameter("ovld");
      unit.setOvld(ovld.equals("0") ? true : false);
      unit.setName(context.parameter("name"));
      unit.setLabel(context.parameter("label"));
      unit.setLeaderLabel(context.parameter("leaderLabel"));
      unit.setLeaderPhone(context.parameter("leaderPhone"));
      unit.setDepartmentLabel(context.parameter("departmentLabel"));
      unit.setLocationLongitude(context.parameterAsDouble("locationLongitude"));
      unit.setLocationLatitude(context.parameterAsDouble("locationLatitude"));
      unit.setDepartmentPhone(context.parameter("departmentPhone"));
      unit.setInvestmentTotal(context.parameterAsDouble("investmentTotal"));
      unit.setInvestmentCount(context.parameterAsInteger("investmentCount"));
      unit.setRedemptionTotal(context.parameterAsDouble("redemptionTotal"));
      unit.setRedemptionCount(context.parameterAsInteger("redemptionCount"));
      unit.setInterestTotal(context.parameterAsDouble("interestTotal"));
      unit.setPerformanceTotal(context.parameterAsDouble("performanceTotal"));
      unit.setNetinvestmentTotal(context.parameterAsDouble("netinvestmentTotal"));
      unit.setCode(context.parameter("code"));
      unit.setDetailAddress(context.parameter("detailAddress"));

      unit.setNote(context.parameter("note"));
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      EResult result = _departmentConsole.doInsert(logicContext, unit);
      if(!result.equals(EResult.Success)){
         page.setResult("增加失败");
         return "/manage/product/configration/InsertConfig";
      }
      return "/manage/product/configration/ConfigList";
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
                              FDepartmentPage page,
                              FBasePage basePage){
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");

      FDataFinancialDepartmentUnit unit = _departmentConsole.find(logicContext, id);

      page.setRedemptionDate(unit.redemptionDate().format("yyyy-mm-dd"));
      page.setStrInvestment(unit.investmentDate().format("yyyy-mm-dd"));
      page.setUnit(unit);
      return "/manage/product/financial/department/UpdateDept";
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
                        FDepartmentPage Page,
                        FBasePage basePage){

      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", context.parameter("configInfoId"));
      FDataFinancialDepartmentUnit unit = new FDataFinancialDepartmentUnit();
      unit.setOuid(Long.parseLong(context.parameter("ouid")));
      String provinceId = context.parameter("provinceId");
      if(!"".equals(provinceId) && null != provinceId){
         unit.setProvinceId(Integer.parseInt(provinceId));
      }
      String cityId = context.parameter("cityId");
      if(!"".equals(cityId) && cityId != null){
         unit.setCityId(Integer.parseInt(cityId));
      }
      String regionId = context.parameter("regionId");
      if(!"".equals(regionId) && null != regionId){
         unit.setRegionId(Integer.parseInt(regionId));
      }

      //投资时间
      String investmentDate = context.parameter("investmentDate");
      if(!"".equals(investmentDate) && null != investmentDate){
         TDateTime dateTime = null;
         try{
            dateTime = new TDateTime(new SimpleDateFormat("yyyy-MM-dd").parse(investmentDate));
         }catch(ParseException e){
            e.printStackTrace();
         }
         unit.setInvestmentDate(dateTime);
      }
      //赎回时间
      String redemptionDate = context.parameter("redemptionDate");
      if(!"".equals("redemptionDate") && null != redemptionDate){
         TDateTime dateTime = null;
         try{
            dateTime = new TDateTime(new SimpleDateFormat("yyyy-MM-dd").parse(redemptionDate));
         }catch(ParseException e){
            e.printStackTrace();
         }
         unit.setRedemptionDate(dateTime);
      }
      unit.setLevel(context.parameterAsInteger("level"));
      //是否删除
      String ovld = context.parameter("ovld");
      unit.setOvld(ovld.equals("0") ? true : false);
      unit.setName(context.parameter("name"));
      unit.setLabel(context.parameter("label"));
      unit.setLeaderLabel(context.parameter("leaderLabel"));
      unit.setLeaderPhone(context.parameter("leaderPhone"));
      unit.setDepartmentLabel(context.parameter("departmentLabel"));
      unit.setLocationLongitude(context.parameterAsDouble("locationLongitude"));
      unit.setLocationLatitude(context.parameterAsDouble("locationLatitude"));
      unit.setDepartmentPhone(context.parameter("departmentPhone"));
      unit.setInvestmentTotal(context.parameterAsDouble("investmentTotal"));
      unit.setInvestmentCount(context.parameterAsInteger("investmentCount"));
      unit.setRedemptionTotal(context.parameterAsDouble("redemptionTotal"));
      unit.setRedemptionCount(context.parameterAsInteger("redemptionCount"));
      unit.setInterestTotal(context.parameterAsDouble("interestTotal"));
      unit.setPerformanceTotal(context.parameterAsDouble("performanceTotal"));
      unit.setNetinvestmentTotal(context.parameterAsDouble("netinvestmentTotal"));
      unit.setCode(context.parameter("code"));
      unit.setDetailAddress(context.parameter("detailAddress"));

      unit.setNote(context.parameter("note"));
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      _departmentConsole.doUpdate(logicContext, unit);
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
                        FDepartmentPage Page,
                        FBasePage basePage){
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataFinancialDepartmentUnit unit = _departmentConsole.find(logicContext, id);
      if(unit == null){
         throw new FFatalError("id not exists.");
      }
      EResult result = _departmentConsole.doDelete(logicContext, unit);
      if(!result.equals(EResult.Success)){
         throw new FFatalError("Delete failure.");
      }else{
         return "/manage/product/financial/department/DeptList";
      }
   }
}
