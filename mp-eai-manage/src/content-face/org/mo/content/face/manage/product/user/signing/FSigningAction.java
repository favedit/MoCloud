package org.mo.content.face.manage.product.user.signing;

import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.user.signing.FDataSigningInfo;
import org.mo.content.core.manage.product.user.signing.ISigningConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
//============================================================
//<P>用户签到控制器</P>
//@class FSigningAction
//============================================================
public class FSigningAction 
      implements 
         ISigningAction 
{

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FSigningAction.class);
   // 签到控制台
   @ALink
   protected ISigningConsole _signingConsole;

   // ============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   // ============================================================
   @Override
   public String construct(IWebContext context, 
                           ILogicContext logicContext, 
                           FBasePage page) {
      _logger.debug(this, "Construct", "Construct begin. (userId={1})", page.userId());
      if (!page.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/user/signing/SigningList";
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
                        FSigningPage page, 
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
      FDataSigningInfo unit = new FDataSigningInfo();
      unit.setUserId(context.parameterAsLong("auserId"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataSigningInfo> unitList = _signingConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
      basePage.setJson(unitList.toJsonListString());
      return "/manage/common/ajax";
   }

   @Override
   public String selectByDate(IWebContext context, 
                              ILogicContext logicContext, 
                              FSigningPage page, 
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
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      String biginDateStr = context.parameter("beginDate");
      String endDateStr = context.parameter("endDate");
      FLogicDataset<FDataSigningInfo> unitList = _signingConsole.selectByDate(logicContext, biginDateStr, endDateStr, page.pageCurrent() - 1, pageSize);
      basePage.setJson(unitList.toJsonListString());
      return "/manage/common/ajax";
   }

}
