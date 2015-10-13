package org.mo.content.face.product.system.version;

import com.cyou.gccloud.data.data.FDataSystemVersionUnit;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import com.cyou.gccloud.define.enums.core.EGcVersionForce;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.product.system.application.IApplicationConsole;
import org.mo.content.core.product.system.version.FDataVersionInfo;
import org.mo.content.core.product.system.version.IVersionConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

public class FVersionAction
      implements
         IVersionAction
{

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FVersionAction.class);

   // 版本控制端
   @ALink
   private IVersionConsole _versionConsole;

   // 应用控制端
   @ALink
   private IApplicationConsole _applicationConsole;

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
      if(!page.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/system/version/VersionList";
   }

   // ============================================================
   // <T>查询</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String select(IWebContext context,
                        ILogicContext logicContext,
                        FVersionPage page,
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
      FDataSystemVersionUnit unit = new FDataSystemVersionUnit();
      unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if(null != StrPageSize){
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataVersionInfo> unitList = _versionConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
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
                              FVersionPage page,
                              FBasePage basePage){
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/system/version/InsertVersion";
   }

   // ============================================================
   // <T>增加</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String insert(IWebContext context,
                        ILogicContext logicContext,
                        FVersionPage page,
                        FBasePage basePage){
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }

      FDataSystemVersionUnit unit = _versionConsole.doPrepare(logicContext);
      setLogicVersion(context, logicContext, unit);
      if(_versionConsole.isExsitsAppIdandNumber(logicContext, unit.applicationId(), unit.number())){
         page.setResult("版本号重复！");
         return "/manage/product/system/version/InsertVersion";
      }

      EResult result = _versionConsole.doInsert(logicContext, unit);
      if(!result.equals(EResult.Success)){
         page.setResult("增加失败");
         return "/manage/product/system/version/InsertVersion";
      }
      _logger.debug(this, "Insert", "Insert finish. (RESULT={S})", "SUCCESS");
      return "/manage/product/system/version/VersionList";
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
                              FVersionPage page,
                              FBasePage basePage){
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataSystemVersionUnit unit = _versionConsole.find(logicContext, id);
      //      FDataVersionInfo info = new FDataVersionInfo();
      //      info.setOuid(unit.ouid());
      //      info.setBeginDate(unit.beginDate());
      //      info.setEndDate(unit.endDate());
      //      info.setCode(unit.code());
      //      info.setLabel(unit.label());
      //      info.setNote(unit.note());
      //      info.setDownloadUrl(unit.downloadUrl());
      //      //      info.setApplicationLabel(unit.application().label());
      //      info.setNumber(unit.number());
      //      setUnitVersionLabel(info, unit);
      page.setUnit(unit);
      _logger.debug(this, "ouid", "updateBefore finish. (Result={1})", "SUCCESS");
      return "/manage/product/system/version/UpdateVersion";
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
                        FVersionPage page,
                        FBasePage basePage){
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      FDataSystemVersionUnit unit = _versionConsole.find(logicContext, Long.parseLong(context.parameter("ouid")));
      setLogicVersion(context, logicContext, unit);
      // if (_versionConsole.isExsitsAppIdandNumber(logicContext,
      // unit.applicationId(), unit.number())) {
      // page.setResult("版本号重复！");
      // return "/manage/product/system/version/UpdateVersion";
      // }

      _versionConsole.doUpdate(logicContext, unit);
      _logger.debug(this, "Update", "Update finish.(RESULT={1})", "SUCCESS");
      return "/manage/common/ajax";
   }

   @Override
   public String delete(IWebContext context,
                        ILogicContext logicContext,
                        FVersionPage page,
                        FBasePage basePage){
      return null;
   }

   // ============================================================
   // <T>抽取数据库字段赋值的公共方法</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return void
   // ============================================================
   public void setLogicVersion(IWebContext context,
                               ILogicContext logicContext,
                               FDataSystemVersionUnit unit){
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setCode(context.parameter("code"));
      unit.setLabel(context.parameter("label"));
      unit.setNote(context.parameter("note"));
      unit.setNumber(context.parameterAsFloat("number"));
      String scd = context.parameter("forceCdStr");
      if(!RString.isEmpty(scd)){
         unit.setForceCd(context.parameterAsInteger("forceCdStr"));
      }
      String scc = context.parameter("statusCdStr");
      if(!RString.isEmpty(scc)){
         unit.setStatusCd(context.parameterAsInteger("statusCdStr"));
      }
      unit.setApplicationId(context.parameterAsLong("applicationId"));
      unit.setDownloadUrl(context.parameter("downloadUrl"));
      String beginDateStr = context.parameter("beginDate");
      TDateTime beginDate = new TDateTime();
      beginDate.parse(beginDateStr, "YYYY-MM-DD");
      unit.setBeginDate(beginDate);
      String endDateStr = context.parameter("endDate");
      TDateTime endDate = new TDateTime();
      endDate.parse(endDateStr, "YYYY-MM-DD");
      unit.setEndDate(endDate);
   }

   // ============================================================
   // <T>抽取数据库字段枚举赋值的公共方法</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return void
   // ============================================================
   public void setUnitVersionLabel(FDataVersionInfo info,
                                   FDataSystemVersionUnit unit){
      if(RString.equals(EGcResourceStatus.Unknown, unit.statusCd())){
         info.setStatusCdStr(EGcResourceStatus.UnknownLabel);
      }
      if(RString.equals(EGcResourceStatus.Apply, unit.statusCd())){
         info.setStatusCdStr(EGcResourceStatus.ApplyLabel);
      }
      if(RString.equals(EGcResourceStatus.Publish, unit.statusCd())){
         info.setStatusCdStr(EGcResourceStatus.PublishLabel);
      }
      if(RString.equals(EGcResourceStatus.CheckFail, unit.statusCd())){
         info.setStatusCdStr(EGcResourceStatus.CheckFailLabel);
      }
      if(RString.equals(EGcVersionForce.Unknown, unit.statusCd())){
         info.setForceCdStr(EGcVersionForce.UnknownLabel);
      }
      if(RString.equals(EGcVersionForce.Optional, unit.statusCd())){
         info.setForceCdStr(EGcVersionForce.OptionalLabel);
      }
      if(RString.equals(EGcVersionForce.Auto, unit.statusCd())){
         info.setForceCdStr(EGcVersionForce.AutoLabel);
      }
      if(RString.equals(EGcVersionForce.Force, unit.statusCd())){
         info.setForceCdStr(EGcVersionForce.ForceLabel);
      }
      if(RString.equals(EGcVersionForce.NoUpdate, unit.statusCd())){
         info.setForceCdStr(EGcVersionForce.NoUpdateLabel);
      }
   }
}
