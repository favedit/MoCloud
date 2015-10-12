package org.mo.content.face.manage.product.business.news;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcLink;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.business.news.FDataNewsInfo;
import org.mo.content.core.manage.product.business.news.INewsConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.upload.IWebUploadConsole;
import org.mo.web.protocol.common.FWebUploadFile;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>理财师信息控制器</P>
//@class FMarketerAction
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================
public class FNewsAction implements INewsAction {
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FNewsAction.class);

   // 业务资讯控制台
   @ALink
   protected INewsConsole _newsConsole;

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
      return "/manage/product/business/news/NewsList";
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
   public String select(IWebContext context, ILogicContext logicContext, FNewsPage page, FBasePage basePage) {
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
      FDataLogicNewsUnit unit = new FDataLogicNewsUnit();
      unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataNewsInfo> unitList = _newsConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
      basePage.setJson(unitList.toJsonListString());
      _logger.debug(this, "Select", "Select finish. (unitListCount={1})", unitList.count());
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
   public String insertBefore(IWebContext context, ILogicContext logicContext, FNewsPage Page, FBasePage basePage) {
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/business/news/InsertNews";
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
   public String insert(IWebContext context, ILogicContext logicContext, FNewsPage page, FBasePage basePage) {
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicNewsUnit unit = _newsConsole.doPrepare(logicContext);
      setLogicNews(context, logicContext, unit, "0");
      EResult result = _newsConsole.doInsert(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("增加失败");
         return "/manage/product/business/news/InsertNews";
      }
      _logger.debug(this, "Insert", "Insert finish. (RESULT={S})", "SUCCESS");
      return "/manage/product/business/news/NewsList";
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
   public String updateBefore(IWebContext context, ILogicContext logicContext, FNewsPage page, FBasePage basePage) {
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataLogicNewsUnit unit = _newsConsole.find(logicContext, id);
      FDataNewsInfo info = new FDataNewsInfo();
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
         int na = unit.iconUrl().indexOf("newsImages");
         info.setImageName("/manage/images/newsImages/" + unit.iconUrl().substring(na + 11, unit.iconUrl().length()));
      }
      page.setUnit(info);
      _logger.debug(this, "ouid", "updateBefore begin. (Result={1})", "SUCCESS");
      return "/manage/product/business/news/UpdateNews";
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
   public String update(IWebContext context, ILogicContext logicContext, FNewsPage Page, FBasePage basePage) {
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicNewsUnit unit = _newsConsole.find(logicContext, Long.parseLong(context.parameter("ouid")));
      setLogicNews(context, logicContext, unit, "1");
      _newsConsole.doUpdate(logicContext, unit);
      _logger.debug(this, "Update", "Update finish.(RESULT={1})", "SUCCESS");
      return "/manage/product/business/news/NewsList";
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
   public String delete(IWebContext context, ILogicContext logicContext, FNewsPage Page, FBasePage basePage) {
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataLogicNewsUnit unit = _newsConsole.find(logicContext, id);
      if (unit == null) {
         throw new FFatalError("id not exists.");
      }
      EResult result = _newsConsole.doDelete(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         throw new FFatalError("Delete failure.");
      } else {
         return "/manage/product/business/news/NewsList";
      }
   }

   // ============================================================
   // <T>抽取数据库字段赋值的公共方法</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   public void setLogicNews(IWebContext context, ILogicContext logicContext, FDataLogicNewsUnit unit, String flag) {
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setContent(context.parameter("content"));
      unit.setDescription(context.parameter("description"));
      unit.setKeywords(context.parameter("keywords"));
      String scd = context.parameter("displayCdStr");
      if (!RString.isEmpty(scd) && scd.length() < 2) {
         unit.setDisplayCd(context.parameterAsInteger("displayCdStr"));
      } else if (!RString.isEmpty(scd) && scd.length() > 1) {
         if (RString.equals(EGcDisplay.DisableLabel, scd)) {
            unit.setDisplayCd(EGcDisplay.Disable);
         }
         if (RString.equals(EGcDisplay.EnabledLabel, scd)) {
            unit.setDisplayCd(EGcDisplay.Enabled);
         }
      }
      String scc = context.parameter("statusCdStr");
      if (!RString.isEmpty(scc) && scc.length() < 2) {
         unit.setStatusCd(context.parameterAsInteger("statusCdStr"));
      } else if (!RString.isEmpty(scc) && scc.length() > 1) {
         if (RString.equals(EGcResourceStatus.ApplyLabel, unit.statusCd())) {
            unit.setStatusCd(EGcResourceStatus.Apply);
         }
         if (RString.equals(EGcResourceStatus.ApplyLabel, unit.statusCd())) {
            unit.setStatusCd(EGcResourceStatus.Publish);
         }
         if (RString.equals(EGcResourceStatus.ApplyLabel, unit.statusCd())) {
            unit.setStatusCd(EGcResourceStatus.CheckFail);
         }
      }
      String lcs = context.parameter("linkCdStr");
      if (!RString.isEmpty(lcs) && lcs.length() < 2) {
         unit.setLinkCd(context.parameterAsInteger("linkCdStr"));
      } else if (!RString.isEmpty(lcs) && lcs.length() > 1) {
         if (RString.equals(EGcLink.UnknownLabel, unit.linkCd())) {
            unit.setLinkCd(EGcLink.Unknown);
         }
         if (RString.equals(EGcLink.ContentLabel, unit.linkCd())) {
            unit.setLinkCd(EGcLink.Content);
         }
         if (RString.equals(EGcLink.LinkLabel, unit.linkCd())) {
            unit.setLinkCd(EGcLink.Link);
         }
      }
      unit.setLabel(context.parameter("label"));
      unit.setLinkUrl(context.parameter("linkUrl"));
      FWebUploadFile file = context.files().first();
      if (null == file) {
         String oiconUr = context.parameter("oiconUr");
         if (!RString.isEmpty(oiconUr)) {
            unit.setIconUrl(oiconUr);
         } else {
            unit.setIconUrl(context.parameter("iconUrl"));
         }
      } else {
         _newsConsole.saveImage(file, unit, flag);
      }
   }
}
