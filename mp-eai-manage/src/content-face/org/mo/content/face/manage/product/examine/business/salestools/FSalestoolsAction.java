package org.mo.content.face.manage.product.examine.business.salestools;

import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;

import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.examine.business.salestools.FDataSalestoolsInfo;
import org.mo.content.core.manage.product.examine.business.salestools.ISalestoolsConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.upload.IWebUploadConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>销售工具控制器</P>
//@class FSalestoolsAction
//@version 1.0.0
//============================================================
public class FSalestoolsAction 
      implements 
         ISalestoolsAction 
{

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FSalestoolsAction.class);

   // 销售工具控制台
   @ALink
   protected ISalestoolsConsole _salestoolsConsole;

   @ALink
   protected IWebUploadConsole _webUploadConsole;
   
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   // ============================================================
   // <T>默认逻辑处理。</T>
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
      return "/manage/product/examine/business/salestools/SalestoolsList";
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
                        FSalestoolsPage page, 
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
      FDataLogicSalestoolsUnit unit = new FDataLogicSalestoolsUnit();
      unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataSalestoolsInfo> unitList = _salestoolsConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
      for(FDataSalestoolsInfo info : unitList){
         String urls = info.iconUrl();
         if(!RString.isEmpty(urls)){
            info.setMakeUrl(_storageConsole.makeUrl(urls.trim()));
         }
         info.setContent(_storageConsole.makeDisplay(info.content()));
      }
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
   public String getDescription(IWebContext context, 
                                ILogicContext logicContext, 
                                FSalestoolsPage page, 
                                FBasePage basePage) {
      _logger.debug(this, "getDescription", "getDescription begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicSalestoolsUnit unit = _salestoolsConsole.find(logicContext, context.parameterAsLong("ouid"));
      FDataSalestoolsInfo info = new FDataSalestoolsInfo();
      info.setContent(_storageConsole.makeDisplay(unit.content()));
      page.setUnit(info);
      _logger.debug(this, "getDescription", "getDescription finish. (Result={1})", "SUCCESS");
      return "/manage/product/examine/business/salestools/SalestoolsDataInfoForContent";
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
   public String checking(IWebContext context, 
                          ILogicContext logicContext, 
                          FSalestoolsPage page, 
                          FBasePage basePage) {
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
      return "/manage/product/examine/business/salestools/SalestoolsList";
   }

   // ============================================================
   // <T>手机浏览信息</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   @Override
   public String browserInfo(IWebContext context, 
                             ILogicContext logicContext, 
                             FSalestoolsPage page, 
                             FBasePage basePage) {
      _logger.debug(this, "browserInfo", "browserInfo begin. (userId={1})", basePage.userId());
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
      info.setDisplayCd(unit.displayCd());
      info.setLinkCd(unit.linkCd());
      info.setLinkUrl(unit.linkUrl());
      info.setLabel(unit.label());
      info.setDisplayOrder(unit.displayOrder());
      if (!RString.isEmpty(unit.iconUrl())) {
         info.setIconUrl(unit.iconUrl());
         int na = unit.iconUrl().indexOf("salestoolsImages");
         info.setImageName(
               "/manage/images/salestoolsImages/" + unit.iconUrl().substring(na + 17, unit.iconUrl().length()));
      }
      page.setUnit(info);
      page.setResult("");
      _logger.debug(this, "ouid", "browserInfo begin. (Result={1})", "SUCCESS");
      return "/manage/product/examine/business/salestools/BrowserSalestools";
   }

   @Override
   public String insert(IWebContext context, 
                        ILogicContext logicContext, 
                        FSalestoolsPage page, 
                        FBasePage basePage) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String updateBefore(IWebContext context, 
                              ILogicContext logicContext, 
                              FSalestoolsPage page, 
                              FBasePage basePage) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String update(IWebContext context, 
                        ILogicContext logicContext, 
                        FSalestoolsPage page, 
                        FBasePage basePage) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String delete(IWebContext context, 
                        ILogicContext logicContext, 
                        FSalestoolsPage page, 
                        FBasePage basePage) {
      // TODO Auto-generated method stub
      return null;
   }

}
