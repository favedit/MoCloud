package org.mo.content.face.manage.product.examine.system;

import com.cyou.gccloud.data.data.FDataSystemVersionUnit;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RLong;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.system.version.FDataVersionInfo;
import org.mo.content.core.manage.product.system.version.IVersionConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>版本控制器</P>
//@class FMarketerAction
//@version 1.0.0
//============================================================
public class FVersionAction 
      implements 
         IVersionAction 
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FVersionAction.class);

   // 业务资讯控制台
   @ALink
   protected IVersionConsole _versionConsole;

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
      return "/manage/product/examine/system/VersionList";
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
                        FVersionPage page, 
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
      FDataSystemVersionUnit unit = new FDataSystemVersionUnit();
      // unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataVersionInfo> unitList = _versionConsole.selectExamine(logicContext, unit, page.pageCurrent() - 1, pageSize);
      basePage.setJson(unitList.toJsonListString());
      _logger.debug(this, "Select", "Select finish. (unitListCount={1})", unitList.count());
      return "/manage/common/ajax";
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
                          FVersionPage page, 
                          FBasePage basePage) {
      _logger.debug(this, "checking", "checking begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      int flag = context.parameterAsInteger("flag");
      String[] versionIds = context.parameter("versionIds").split(",");
      for (int i = 0; i < versionIds.length; i++) {
         FDataSystemVersionUnit version = _versionConsole.find(logicContext, RLong.parse(versionIds[i]));
         // 如果flag是1审核通过，0审核未通过
         version.setStatusCd(flag == 3 ? EGcResourceStatus.CheckFail : EGcResourceStatus.Publish);
         EResult result = _versionConsole.doUpdate(logicContext, version);
         _logger.debug(this, "Checking", "Checking " + result + ". (newsId={1}, flag={2})", versionIds[i], flag);
      }
      return "/manage/product/examine/system/VersionList";
   }
}
