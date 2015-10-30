package org.mo.content.face.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonCityUnit;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.common.FDataCityInfo;
import org.mo.content.core.manage.product.common.IAreaConsole;
import org.mo.content.core.manage.product.common.ICityConsole;
import org.mo.content.core.manage.product.common.ICountryConsole;
import org.mo.content.core.manage.product.common.IProvinceConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>城市信息控制器</P>
//@class FCityAction
//@version 1.0.0
//============================================================
public class FCityAction 
      implements 
         ICityAction 
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCityAction.class);

   // 用户控制台
   @ALink
   protected ICityConsole _cityConsole;

   // 国家控制台
   @ALink
   protected ICountryConsole _countryConsole;

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
      return "/manage/product/common/CityList";
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
                        FCityPage page, 
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
      FDataCommonCityUnit unit = new FDataCommonCityUnit();
      String label = context.parameter("label");
      if (null != label) {
         unit.setLabel(label);
      }
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataCityInfo> unitList = _cityConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
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
                              FCityPage Page, 
                              FBasePage basePage) {
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/common/InsertCity";
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
                        FCityPage page, 
                        FBasePage basePage) {
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataCommonCityUnit unit = _cityConsole.doPrepare(logicContext);
      setCityDat(unit, context, logicContext);
      if (_cityConsole.isExsitsByLabelandId(logicContext, unit.label(), unit.countryId(), unit.areaId(), unit.provinceId())) {
         page.setResult("请重新增加!");
         return "/manage/product/common/InsertCity";
      }
      EResult result = _cityConsole.doInsert(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("增加失败");
         return "/manage/product/common/InsertCity";
      }
      return "/manage/product/common/CityList";
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
                              FCityPage page, 
                              FBasePage basePage) {
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataCommonCityUnit unit = _cityConsole.find(logicContext, id);
      page.setUnit(unit);
      page.setResult("");
      return "/manage/product/common/UpdateCity";
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
                        FCityPage page, 
                        FBasePage basePage) {

      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      FDataCommonCityUnit unit = _cityConsole.find(logicContext, Long.parseLong(context.parameter("ouid")));
      setCityDat(unit, context, logicContext);
      if (_cityConsole.isExsitsByLabelandIdandOuid(logicContext, unit.label(), unit.countryId(), unit.areaId(), unit.provinceId(),unit.ouid())) {
         page.setResult("数据重复,请重新增加!");
         return "/manage/product/common/UpdateCity";
      }
      _cityConsole.doUpdate(logicContext, unit);
      return "/manage/product/common/CityList";
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
                        FCityPage Page, 
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
         return "/manage/product/common/CityList";
      }
   }

   // ============================================================
   // <T>抽取方法</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @return void
   // ============================================================
   public void setCityDat(FDataCommonCityUnit unit, 
                          IWebContext context, 
                          ILogicContext logicContext) {
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setCode(context.parameter("code"));
      unit.setLabel(context.parameter("label"));
      unit.setCityCode(context.parameter("cityCode"));
      String level = context.parameter("level");
      if (!RString.isEmpty(level)) {
         unit.setLevel(Integer.valueOf(level));
      }
      unit.setNote(context.parameter("note"));
      String ltu = context.parameter("locationLongitude");
      if (!RString.isEmpty(ltu)) {
         unit.setLocationLongitude(Double.valueOf(ltu));
      }
      String ltd = context.parameter("locationLatitude");
      if (!RString.isEmpty(ltd)) {
         unit.setLocationLatitude(Double.valueOf(ltd));
      }
      unit.setCountryId(context.parameterAsLong("countryId"));
      unit.setAreaId(context.parameterAsLong("areaId"));
      unit.setProvinceId(context.parameterAsLong("provinceId"));
      unit.setDisplayOrder(context.parameterAsInteger("displayOrder"));
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
      FLogicDataset<FDataCommonCityUnit> countryList = _cityConsole.selectAll(logicContext, context.parameterAsLong("provinceId"));
      basePage.setJson(countryList.toJsonString());
      return "/manage/common/ajax";
   }
}
