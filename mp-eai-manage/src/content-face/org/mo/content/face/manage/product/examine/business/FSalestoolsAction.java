package org.mo.content.face.manage.product.examine.business;

import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcLink;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.examine.business.FDataSalestoolsInfo;
import org.mo.content.core.manage.product.examine.business.ISalestoolsConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.upload.IWebUploadConsole;
import org.mo.web.protocol.common.FWebUploadFile;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>销售工具控制器</P>
//@class FSalestoolsAction
//@author zhangxiaohui
//@Date 2015.10.10
//@version 1.0.0
//============================================================
public class FSalestoolsAction implements ISalestoolsAction {

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FSalestoolsAction.class);

   // 销售工具控制台
   @ALink
   protected ISalestoolsConsole _salestoolsConsole;

   @ALink
   protected IWebUploadConsole _webUploadConsole;

   // ============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   // ============================================================
   @Override
   public String construct(IWebContext context, ILogicContext logicContext, FBasePage basePage) {
      _logger.debug(this, "Construct", "Construct begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/examine/business/SalestoolsList";
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
   public String select(IWebContext context, ILogicContext logicContext, FSalestoolsPage page, FBasePage basePage) {
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
      FDataLogicSalestoolsUnit unit = new FDataLogicSalestoolsUnit();
      unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataSalestoolsInfo> unitList = _salestoolsConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
      basePage.setJson(unitList.toJsonListString());
      _logger.debug(this, "Select", "Select finish. (unitListCount={1})", unitList.count());
      return "/manage/common/ajax";
   }

   // ============================================================
   // <T>查询资讯内容</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String getDescription(IWebContext context, ILogicContext logicContext, FSalestoolsPage page, FBasePage basePage) {
      _logger.debug(this, "getDescription", "getDescription begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicSalestoolsUnit unit = _salestoolsConsole.find(logicContext, context.parameterAsLong("ouid"));
      page.setUnit(unit);
      _logger.debug(this, "getDescription", "getDescription finish. (Result={1})", "SUCCESS");
      return "/manage/product/examine/business/DataInfoForContent";
   }

   // ============================================================
   // <T>审核-更新资讯状态</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String checking(IWebContext context, ILogicContext logicContext, FSalestoolsPage page, FBasePage basePage) {
      _logger.debug(this, "checking", "checking begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      String flag = context.parameter("flag");
      int statusCd = 0;
      if (!RString.isEmpty(flag)) {
         // 审核不通过时flag,0,状态改为审核未通过
         if (RString.equals(EGcResourceStatus.Unknown, flag)) {
            statusCd = EGcResourceStatus.CheckFail;
         }
         // 审核通过flag,1，状态改为发布
         if (RString.equals(EGcResourceStatus.Apply, flag)) {
            statusCd = EGcResourceStatus.Publish;
         }
      }
      String ouids = context.parameter("newsIds");
      if (!RString.isEmpty(ouids)) {
         String[] ouid = ouids.split(",");
         for (String id : ouid) {
            FDataLogicSalestoolsUnit unit = _salestoolsConsole.find(logicContext, RLong.parse(id));
            unit.setStatusCd(statusCd);
            _salestoolsConsole.doUpdate(logicContext, unit);
         }
      }
      _logger.debug(this, "checking", "checking finish. (userId={1})", "SUCCESS");
      return "/manage/product/examine/business/SalestoolsList";
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
   public String insertBefore(IWebContext context, ILogicContext logicContext, FSalestoolsPage Page, FBasePage basePage) {
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/business/InsertSalestools";
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
   public String insert(IWebContext context, ILogicContext logicContext, FSalestoolsPage page, FBasePage basePage) {
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicSalestoolsUnit unit = _salestoolsConsole.doPrepare(logicContext);
      setLogicNews(context, logicContext, unit, "0");
      EResult result = _salestoolsConsole.doInsert(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("增加失败");
         return "/manage/product/business/InsertNews";
      }
      _logger.debug(this, "Insert", "Insert finish. (RESULT={S})", "SUCCESS");
      return "/manage/product/business/SalestoolsList";
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
   public String updateBefore(IWebContext context, ILogicContext logicContext, FSalestoolsPage page, FBasePage basePage) {
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataLogicSalestoolsUnit unit = _salestoolsConsole.find(logicContext, id);
      FDataSalestoolsInfo info = new FDataSalestoolsInfo();
      info.setOuid(unit.ouid());
      info.setContent(unit.content());
      info.setDescription(unit.description());
      info.setKeywords(unit.keywords());
      if (RString.equals(EGcResourceStatus.Apply, unit.statusCd())) {
         info.setStatusCdStr(EGcResourceStatus.ApplyLabel);
      }
      if (RString.equals(EGcResourceStatus.Publish, unit.statusCd())) {
         info.setStatusCdStr(EGcResourceStatus.PublishLabel);
      }
      if (RString.equals(EGcResourceStatus.CheckFail, unit.statusCd())) {
         info.setStatusCdStr(EGcResourceStatus.CheckFailLabel);
      }
      if (RString.equals(EGcDisplay.Disable, unit.displayCd())) {
         info.setDisplayCdStr(EGcDisplay.DisableLabel);
      }
      if (RString.equals(EGcDisplay.Enabled, unit.displayCd())) {
         info.setDisplayCdStr(EGcDisplay.EnabledLabel);
      }
      if (RString.equals(EGcLink.Unknown, unit.linkCd())) {
         info.setLinkCdStr(EGcLink.UnknownLabel);
      }
      if (RString.equals(EGcLink.Content, unit.linkCd())) {
         info.setLinkCdStr(EGcLink.ContentLabel);
      }
      if (RString.equals(EGcLink.Link, unit.linkCd())) {
         info.setLinkCdStr(EGcLink.LinkLabel);
      }
      info.setLinkUrl(unit.linkUrl());
      info.setLabel(unit.label());
      if (!RString.isEmpty(unit.iconUrl())) {
         info.setIconUrl(unit.iconUrl());
         int na = unit.iconUrl().indexOf("salestoolsImages");
         info.setImageName("/manage/images/salestoolsImages/" + unit.iconUrl().substring(na + 17, unit.iconUrl().length()));
      }
      page.setUnit(info);
      _logger.debug(this, "ouid", "updateBefore begin. (Result={1})", "SUCCESS");
      return "/manage/product/business/UpdateSalestools";
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
   public String update(IWebContext context, ILogicContext logicContext, FSalestoolsPage Page, FBasePage basePage) {
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      FDataLogicSalestoolsUnit unit = _salestoolsConsole.find(logicContext, Long.parseLong(context.parameter("ouid")));

      setLogicNews(context, logicContext, unit, "1");
      _salestoolsConsole.doUpdate(logicContext, unit);
      _logger.debug(this, "Update", "Update finish.(RESULT={1})", "SUCCESS");
      return "/manage/product/business/SalestoolsList";
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
   public String delete(IWebContext context, ILogicContext logicContext, FSalestoolsPage Page, FBasePage basePage) {
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataLogicSalestoolsUnit unit = _salestoolsConsole.find(logicContext, id);
      if (unit == null) {
         throw new FFatalError("id not exists.");
      }
      EResult result = _salestoolsConsole.doDelete(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         throw new FFatalError("Delete failure.");
      } else {
         return "/manage/product/business/SalestoolsList";
      }
   }

   // ============================================================
   // <T>抽取数据库字段赋值的公共方法</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   public void setLogicNews(IWebContext context, ILogicContext logicContext, FDataLogicSalestoolsUnit unit, String flag) {
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setContent(context.parameter("content"));
      unit.setDescription(context.parameter("description"));
      unit.setKeywords(context.parameter("keywords"));
      String scd = context.parameter("displayCdStr");
      if (!RString.isEmpty(scd)) {
         unit.setDisplayCd(context.parameterAsInteger("displayCdStr"));
      }
      String scc = context.parameter("statusCdStr");
      if (!RString.isEmpty(scc)) {
         unit.setStatusCd(context.parameterAsInteger("statusCdStr"));
      }
      String lcs = context.parameter("linkCdStr");
      if (!RString.isEmpty(lcs)) {
         unit.setLinkCd(context.parameterAsInteger("linkCdStr"));
      }
      unit.setLabel(context.parameter("label"));
      unit.setLinkUrl(context.parameter("linkUrl"));
      FWebUploadFile file = context.files().first();
      if (null == file) {
         unit.setIconUrl(context.parameter("iconUrl"));
      } else {
         _salestoolsConsole.saveImage(file, unit, flag);
      }
   }
}
