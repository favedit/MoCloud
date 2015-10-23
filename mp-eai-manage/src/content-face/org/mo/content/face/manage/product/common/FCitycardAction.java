package org.mo.content.face.manage.product.common;

import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.common.FDataCitycardInfo;
import org.mo.content.core.manage.product.common.IAreaConsole;
import org.mo.content.core.manage.product.common.ICityConsole;
import org.mo.content.core.manage.product.common.ICitycardConsole;
import org.mo.content.core.manage.product.common.ICountryConsole;
import org.mo.content.core.manage.product.common.IProvinceConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

import com.cyou.gccloud.data.data.FDataCommonCityCardUnit;
import com.cyou.gccloud.data.data.FDataCommonCityUnit;

public class FCitycardAction 
      implements 
         ICitycardAction 
{
// 日志输出接口
   private static ILogger _logger = RLogger.find(FCityAction.class);

   // 用户控制台
   @ALink
   protected ICityConsole _cityConsole;

   // 国家控制台
   @ALink
   protected ICountryConsole _countryConsole;

   // 城市省份证对照控制台
   @ALink
   protected ICitycardConsole _citycardConsole;

// 省会控制台
   @ALink
   protected IProvinceConsole _provinceConsole;
   
   // 区域控制台
   @ALink
   protected IAreaConsole _areaConsole;

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
      return "/manage/product/common/CitycardList";
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
                        FCitycardPage page, 
                        FBasePage basePage) {
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
      FDataCommonCityCardUnit unit = new FDataCommonCityCardUnit();
      unit.setCardCode(context.parameterAsInteger("cardCode"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataCitycardInfo> unitList = _citycardConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
      _logger.debug(this, "Select", "Select finish. (unitListCount={1})", unitList.count());
      basePage.setJson(unitList.toJsonListString());
      page.setResult("");
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
                              FCitycardPage Page, 
                              FBasePage basePage) {
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/common/InsertCitycard";
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
                        FCitycardPage page, 
                        FBasePage basePage) {
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataCommonCityCardUnit unit = _citycardConsole.doPrepare(logicContext);
      setCitycardDat(unit, context, logicContext);
      if (_citycardConsole.isExsitsByCardcodeandByCityId(logicContext, unit.cityId(), unit.cardCode())) {
         page.setResult("数据重复,请重新增加!");
         return "/manage/product/common/InsertCitycard";
      }
      EResult result = _citycardConsole.doInsert(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("增加失败");
         return "/manage/product/common/InsertCitycard";
      }
      return "/manage/product/common/CitycardList";
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
                              FCitycardPage page, 
                              FBasePage basePage) {
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataCommonCityCardUnit unit = _citycardConsole.find(logicContext, id);
      FDataCitycardInfo info = new FDataCitycardInfo();
      info.setOuid(unit.ouid());
      info.setCardCode(unit.cardCode());
      FDataCommonCityUnit unitc = _cityConsole.find(logicContext, unit.cityId());
      if(unitc!=null){
         info.setAreaId(unitc.areaId());
         info.setCityId(unit.cityId());
         info.setProvinceId(unitc.provinceId());
         info.setCountryId(unitc.countryId());
      }
      page.setUnit(info);
      page.setResult("");
      return "/manage/product/common/UpdateCitycard";
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
                        FCitycardPage page, 
                        FBasePage basePage) {

      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update----------------------------------------", "Update Begin.(id={1})", basePage.userId());
      FDataCommonCityCardUnit unit = _citycardConsole.find(logicContext, Long.parseLong(context.parameter("ouid")));
      unit.setOuid(Long.parseLong(context.parameter("ouid")));
      setCitycardDat(unit, context, logicContext);
      if (_citycardConsole.isExsitsByCardcodeandByCityIdandOuid(logicContext, unit.cityId(), unit.cardCode(),unit.ouid())) {
         page.setResult("数据重复,请重新增加!");
         return "/manage/product/common/UpdateCitycard";
      }
      _citycardConsole.doUpdate(logicContext, unit);
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
                        FCitycardPage Page, 
                        FBasePage basePage) {
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataCommonCityUnit unit = _cityConsole.find(logicContext, id);
      if (unit == null) {
         throw new FFatalError("id not exists.");
      }
      EResult result = _cityConsole.doDelete(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         throw new FFatalError("Delete failure.");
      } else {
         return "/manage/product/common/CitycardList";
      }
   }

   // ============================================================
   // <T>抽取方法</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @return void
   // ============================================================
   public void setCitycardDat(FDataCommonCityCardUnit unit, 
                              IWebContext context, 
                              ILogicContext logicContext) {
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setCardCode(context.parameterAsInteger("cardCode"));
      unit.setCityId(context.parameterAsLong("cityId"));
   }
}
