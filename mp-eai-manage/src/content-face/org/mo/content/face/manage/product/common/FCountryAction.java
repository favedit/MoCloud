package org.mo.content.face.manage.product.common;

import com.cyou.gccloud.data.data.FDataCommonCountryUnit;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.common.ICountryConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>国家信息控制器</P>
//@class FCountryAction
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================
public class FCountryAction
      implements
         ICountryAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FCountryAction.class);

   //国家控制台
   @ALink
   protected ICountryConsole _countryConsole;

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
      return "/manage/product/common/CountryList";
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
                        FCountryPage Page,
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
      FDataCommonCountryUnit unit = new FDataCommonCountryUnit();
      String name = context.parameter("name");
      if(null != name){
         unit.setName(name);
      }
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if(null != StrPageSize){
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataCommonCountryUnit> unitList = _countryConsole.select(logicContext, unit, Page.pageCurrent() - 1, pageSize);
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
                              FCountryPage Page,
                              FBasePage basePage){

      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/common/InsertCountry";
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
                        FCountryPage page,
                        FBasePage basePage){
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      FDataCommonCountryUnit unit = _countryConsole.doPrepare(logicContext);
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      setCountryDate(context, unit);
      EResult result = _countryConsole.doInsert(logicContext, unit);
      if(!result.equals(EResult.Success)){
         page.setResult("增加失败");
         return "/manage/product/common/InsertCountry";
      }
      return "/manage/product/common/CountryList";
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
                              FCountryPage page,
                              FBasePage basePage){
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");

      FDataCommonCountryUnit unit = _countryConsole.find(logicContext, id);
      page.setUnit(unit);
      return "/manage/product/common/UpdateCountry";
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
                        FCountryPage Page,
                        FBasePage basePage){

      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      FDataCommonCountryUnit unit = _countryConsole.find(logicContext, Long.parseLong(context.parameter("ouid")));
      unit.setOuid(Long.parseLong(context.parameter("ouid")));
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      setCountryDate(context, unit);
      _countryConsole.doUpdate(logicContext, unit);
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
                        FCountryPage Page,
                        FBasePage basePage){
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataCommonCountryUnit unit = _countryConsole.find(logicContext, id);
      if(unit == null){
         throw new FFatalError("id not exists.");
      }
      EResult result = _countryConsole.doDelete(logicContext, unit);
      if(!result.equals(EResult.Success)){
         throw new FFatalError("Delete failure.");
      }else{
         return "/manage/product/financial/customer/CustomerList";
      }
   }

   //============================================================
   // <T>抽取方法</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @return void
   //============================================================
   public void setCountryDate(IWebContext context,
                              FDataCommonCountryUnit unit){
      unit.setCode(context.parameter("code"));
      unit.setLabel(context.parameter("label"));
      unit.setName(context.parameter("name"));
      unit.setNote(context.parameter("note"));
      unit.setPhoneCode(context.parameter("phoneCode"));
   }
}
