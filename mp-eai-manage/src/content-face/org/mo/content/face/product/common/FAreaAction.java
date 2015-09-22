package org.mo.content.face.product.common;

import com.cyou.gccloud.data.data.FDataCommonAreaUnit;
import com.cyou.gccloud.data.data.FDataCommonCountryUnit;
import java.util.Iterator;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.product.common.FDataAreaInfo;
import org.mo.content.core.product.common.IAreaConsole;
import org.mo.content.core.product.common.ICityConsole;
import org.mo.content.core.product.common.ICountryConsole;
import org.mo.content.core.product.common.IProvinceConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>区域信息控制器</P>
//@class FAreaAction
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================
public class FAreaAction
      implements
         IAreaAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FAreaAction.class);

   //用户控制台
   @ALink
   protected ICityConsole _cityConsole;

   //国家控制台
   @ALink
   protected ICountryConsole _countryConsole;

   //省会控制台
   @ALink
   protected IProvinceConsole _provinceConsole;

   //区域控制台
   @ALink
   protected IAreaConsole _areaConsole;

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

      return "/manage/product/common/AreaList";
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
                        FAreaPage page,
                        FBasePage basePage){
      _logger.debug(this, "Select", "Select begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         page.setPageCurrent(Integer.parseInt(num));
      }else{
         page.setPageCurrent(0);
      }
      FDataCommonAreaUnit unit = new FDataCommonAreaUnit();
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if(null != StrPageSize){
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataAreaInfo> unitList = _areaConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
      for(Iterator<FDataAreaInfo> iterator = unitList.iterator(); iterator.hasNext();){
         FDataAreaInfo tempUnit = iterator.next();
         //         String _areaLabel = "";
         FDataCommonCountryUnit unit2 = _countryConsole.find(logicContext, tempUnit.countryId());
         if(unit2 != null){
            String _countryLabel = unit2.name();
            tempUnit.setCountryLabel(_countryLabel);
         }

      }
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
                              FAreaPage Page,
                              FBasePage basePage){

      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/financial/customer/InsertCustomer";
   }

   //============================================================
   // <T>增</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String insert(IWebContext context,
                        ILogicContext logicContext,
                        FAreaPage page,
                        FBasePage basePage){
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      FDataCommonAreaUnit unit = _areaConsole.doPrepare(logicContext);

      unit.setCreateUserId(context.parameterAsLong("adminId"));

      EResult result = _areaConsole.doInsert(logicContext, unit);
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
                              FAreaPage page,
                              FBasePage basePage){
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");

      FDataCommonAreaUnit unit = _areaConsole.find(logicContext, id);
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
                        FAreaPage Page,
                        FBasePage basePage){

      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      FDataCommonAreaUnit unit = new FDataCommonAreaUnit();
      unit.setOuid(Long.parseLong(context.parameter("ouid")));
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setNote(context.parameter("note"));
      _areaConsole.doUpdate(logicContext, unit);
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
                        FAreaPage Page,
                        FBasePage basePage){
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataCommonAreaUnit unit = _areaConsole.find(logicContext, id);
      if(unit == null){
         throw new FFatalError("id not exists.");
      }
      EResult result = _areaConsole.doDelete(logicContext, unit);
      if(!result.equals(EResult.Success)){
         throw new FFatalError("Delete failure.");
      }else{
         return "/manage/product/financial/customer/CustomerList";
      }
   }
}
