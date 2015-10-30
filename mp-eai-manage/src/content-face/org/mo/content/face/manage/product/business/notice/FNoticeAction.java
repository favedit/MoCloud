package org.mo.content.face.manage.product.business.notice;

import com.cyou.gccloud.data.data.FDataLogicNoticeUnit;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;

import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.business.notice.FDataNoticeInfo;
import org.mo.content.core.manage.product.business.notice.INoticeConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.upload.IWebUploadConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>公告控制器</P>
//@class FNoticeAction
//============================================================
public class FNoticeAction 
      implements 
         INoticeAction 
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FNoticeAction.class);

   // 公告控制台
   @ALink
   protected INoticeConsole _noticeConsole;

   @ALink
   protected IWebUploadConsole _webUploadConsole;
   
// 存储服务器
   @ALink
   protected IGcStorageConsole _storageConsole;

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
      return "/manage/product/business/notice/NoticeList";
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
                        FNoticePage page, 
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
      FDataLogicNoticeUnit unit = new FDataLogicNoticeUnit();
      unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataNoticeInfo> unitList = _noticeConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
      for(FDataNoticeInfo info : unitList){
         info.setContent(_storageConsole.makeDisplay(info.content()));
      }
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
   public String insertBefore(IWebContext context, 
                              ILogicContext logicContext, 
                              FNoticePage page, 
                              FBasePage basePage) {
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      page.setResult("");
      return "/manage/product/business/notice/InsertNotice";
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
                        FNoticePage page, 
                        FBasePage basePage) {
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicNoticeUnit unit = _noticeConsole.doPrepare(logicContext);
      unit.setContent(_storageConsole.makeText(context.parameter("content")));
      setLogicNews(context, logicContext, unit);
      EResult result = _noticeConsole.doInsert(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("增加失败");
         return "/manage/product/business/notice/InsertNotice";
      }
      _logger.debug(this, "Insert", "Insert finish. (RESULT={S})", "SUCCESS");
      return "/manage/product/business/notice/NoticeList";
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
                              FNoticePage page, 
                              FBasePage basePage) {
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataLogicNoticeUnit unit = _noticeConsole.find(logicContext, id);
      FDataNoticeInfo info = new FDataNoticeInfo();
      info.setOuid(unit.ouid());
      info.setContent(unit.content());
      info.setDescription(unit.description());
      info.setDisplayCd(unit.displayCd());
      info.setLinkCd(unit.linkCd());
      info.setLinkUrl(unit.linkUrl());
      info.setLabel(unit.label());
      info.setDisplayOrder(unit.displayOrder());
      if(unit.content().trim().length() > 0){
         info.setContent(_storageConsole.makeEdit(unit.content()));
      }
      page.setUnit(info);
      page.setResult("");
      _logger.debug(this, "ouid", "updateBefore begin. (Result={1})", "SUCCESS");
      return "/manage/product/business/notice/UpdateNotice";
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
                        FNoticePage page, 
                        FBasePage basePage) {
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicNoticeUnit unit = _noticeConsole.find(logicContext, Long.parseLong(context.parameter("ouid")));
      String content = context.parameter("content");
      unit.setContent(_storageConsole.makeText(content));
      
      setLogicNews(context, logicContext, unit);
      _noticeConsole.doUpdate(logicContext, unit);
      _logger.debug(this, "Update", "Update finish.(RESULT={1})", "SUCCESS");
      return "/manage/product/business/notice/NoticeList";
   }
   
   // ============================================================
   // <T>撤回</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String resetStatusCd(IWebContext context, 
                               ILogicContext logicContext, 
                               FNoticePage page, 
                               FBasePage basePage){
      _logger.debug(this, "resetStatusCd", "resetStatusCd begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataLogicNoticeUnit unit = _noticeConsole.find(logicContext, id);
      unit.setStatusCd(EGcResourceStatus.Apply);
      _noticeConsole.doUpdate(logicContext, unit);
      page.setResult("");
      return "/manage/product/business/notice/NoticeList";
   }
   // ============================================================
   // <T>删除之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String deleteBefore(IWebContext context, 
                              ILogicContext logicContext, 
                              FNoticePage Page, 
                              FBasePage basePage){
      _logger.debug(this, "deleteBefore", "deleteBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataLogicNoticeUnit unit = _noticeConsole.find(logicContext, id);
      if(RString.equals(unit.statusCd(),2)){
         basePage.setJson("noDel");
      }else{
         basePage.setJson("yesDel");
      }
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
                        FNoticePage Page, 
                        FBasePage basePage) {
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataLogicNoticeUnit unit = _noticeConsole.find(logicContext, id);
      if (unit == null) {
         throw new FFatalError("id not exists.");
      }
      EResult result = _noticeConsole.doDelete(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         throw new FFatalError("Delete failure.");
      } else {
         return "/manage/product/business/notice/NoticeList";
      }
   }

   // ============================================================
   // <T>抽取数据库字段赋值的公共方法</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   public void setLogicNews(IWebContext context, 
                            ILogicContext logicContext, 
                            FDataLogicNoticeUnit unit) {
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setDescription(context.parameter("description"));
      unit.setDisplayOrder(context.parameterAsInteger("displayOrder"));
      unit.setDisplayCd(context.parameterAsInteger("displayCd"));
      unit.setLinkCd(context.parameterAsInteger("linkCd"));
      unit.setLabel(context.parameter("label"));
      unit.setLinkUrl(context.parameter("linkUrl"));
      unit.setStatusCd(EGcResourceStatus.Apply);
   }
   // ============================================================
   // <T>根据状态，是否显示，标题查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String selectByData(IWebContext context, 
                              ILogicContext logicContext, 
                              FNoticePage page, 
                              FBasePage basePage) {
      _logger.debug(this, "selectByDate", "selectByDate begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      if (null != context.parameter("page")) {
         String num = context.parameter("page");
         page.setPageCurrent(Integer.parseInt(num));
      } else {
         page.setPageCurrent(0);
      }
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      Integer statusCd = context.parameterAsInteger("statusCd");
      Integer displayCd = context.parameterAsInteger("displayCd");
      String label = context.parameter("label");
      FLogicDataset<FDataNoticeInfo> unitlist = _noticeConsole.selectByMessage(logicContext, statusCd, displayCd, label, page.pageCurrent() - 1, pageSize);
      basePage.setJson(unitlist.toJsonListString());
      _logger.debug(this, "selectByDate", "selectByDate finish. (unitListCount={1})", unitlist.count());
      return "/manage/common/ajax";
   }
   // ============================================================
   // <T>查询内容</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String getDescription(IWebContext context, 
                                ILogicContext logicContext, 
                                FNoticePage page, 
                                FBasePage basePage) {
      _logger.debug(this, "getDescription", "getDescription begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicNoticeUnit unit = _noticeConsole.find(logicContext, context.parameterAsLong("ouid"));
      FDataNoticeInfo info = new FDataNoticeInfo();
      info.setContent(_storageConsole.makeDisplay(unit.content()));
      page.setUnit(info);
      _logger.debug(this, "getDescription", "getDescription finish. (Result={1})", "SUCCESS");
      return "/manage/product/business/notice/NoticeDataInfoForContent";
   }
}
