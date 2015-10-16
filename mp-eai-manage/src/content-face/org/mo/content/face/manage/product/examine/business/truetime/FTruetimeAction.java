package org.mo.content.face.manage.product.examine.business.truetime;

import com.cyou.gccloud.data.data.FDataLogicTruetimeUnit;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.examine.business.truetime.FDataTruetimeInfo;
import org.mo.content.core.manage.product.examine.business.truetime.ITruetimeConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.upload.IWebUploadConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>实时数据控制器</P>
//@class FTruetimeAction
//============================================================
public class FTruetimeAction implements ITruetimeAction {

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FTruetimeAction.class);

   // 业务资讯控制台
   @ALink
   protected ITruetimeConsole _truetimeConsole;

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
      return "/manage/product/examine/business/truetime/TruetimeList";
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
   public String select(IWebContext context, ILogicContext logicContext, FTruetimePage page, FBasePage basePage) {
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
      FDataLogicTruetimeUnit unit = new FDataLogicTruetimeUnit();
      unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataTruetimeInfo> unitList = _truetimeConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
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
   public String getDescription(IWebContext context, ILogicContext logicContext, FTruetimePage page, FBasePage basePage) {
      _logger.debug(this, "getDescription", "getDescription begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicTruetimeUnit unit = _truetimeConsole.find(logicContext, context.parameterAsLong("ouid"));
      page.setUnit(unit);
      _logger.debug(this, "getDescription", "getDescription finish. (Result={1})", "SUCCESS");
      return "/manage/product/examine/business/truetime/TruetimeDataInfoForContent";
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
   public String checking(IWebContext context, ILogicContext logicContext, FTruetimePage page, FBasePage basePage) {
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
            FDataLogicTruetimeUnit unit = _truetimeConsole.find(logicContext, RLong.parse(id));
            unit.setStatusCd(statusCd);
            _truetimeConsole.doUpdate(logicContext, unit);
         }
      }
      _logger.debug(this, "checking", "checking finish. (userId={1})", "SUCCESS");
      return "/manage/product/examine/business/truetime/TruetimeList";
   }

   @Override
   public String insertBefore(IWebContext context, ILogicContext logicContext, FTruetimePage Page, FBasePage basePage) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String insert(IWebContext context, ILogicContext logicContext, FTruetimePage Page, FBasePage basePage) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String updateBefore(IWebContext context, ILogicContext logicContext, FTruetimePage Page, FBasePage basePage) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String update(IWebContext context, ILogicContext logicContext, FTruetimePage Page, FBasePage basePage) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public String delete(IWebContext context, ILogicContext logicContext, FTruetimePage Page, FBasePage basePage) {
      // TODO Auto-generated method stub
      return null;
   }

}
