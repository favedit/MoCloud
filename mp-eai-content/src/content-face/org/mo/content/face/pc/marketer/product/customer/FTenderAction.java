package org.mo.content.face.pc.marketer.product.customer;

import com.cyou.gccloud.data.data.FDataFinancialMarketerUnit;
import com.cyou.gccloud.data.data.FDataFinancialProductUnit;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.cloud.core.web.FGcWebSession;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.financial.customer.FDataFinancialCustomerInfo;
import org.mo.content.core.financial.customer.ICustomerConsole;
import org.mo.content.core.financial.marketer.IDataMarketerConsole;
import org.mo.content.core.financial.product.FDataFinancialProductInfo;
import org.mo.content.core.financial.product.IDataProductConsole;
import org.mo.content.core.financial.tender.FDataFinancialTenderInfo;
import org.mo.content.core.financial.tender.FTenderConsole;
import org.mo.content.core.financial.tender.ITenderConsole;
import org.mo.content.core.manage.person.user.IUserConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.container.AContainer;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>金融成员信息。</P>
//
// @author hyw
// @version 
//============================================================
public class FTenderAction
      implements
         ITenderAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FTenderAction.class);

   //session控制台
   @ALink
   protected IWebSessionConsole _sessionConsole;

   //用户控制台
   @ALink
   protected IUserConsole _userConsole;

   //理财师信息控制器
   @ALink
   protected IDataMarketerConsole _marketerConsole;

   // 客户信息控制器
   @ALink
   protected ICustomerConsole _customerConsole;

   // 产品信息控制器
   @ALink
   protected IDataProductConsole _productConsole;

   // 客户投标信息控制器
   @ALink
   protected ITenderConsole _tenderConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param page 页面容器
   //============================================================
   @Override
   public String construct(IWebContext context,
                           IWebSession sessionContext,
                           ILogicContext logicContext,
                           @AContainer(name = "basePage") FBasePage basePage,
                           FTenderPage page){
      FGcWebSession session = (FGcWebSession)sessionContext;
      _logger.debug(this, "construct", "construct default begin.(session={1})", session.id());
      FDataPersonUserUnit user = _userConsole.find(logicContext, session.userId());
      long marketerId = 0;
      if(user != null){
         FDataFinancialMarketerUnit marketer = _marketerConsole.findByUserId(logicContext, user.ouid());
         if(marketer == null){
            _logger.debug(this, "construct", "construct this user is not marketer.(user={1})", user.ouid());
            return "/apl/message/LogicFatal";
         }
         marketerId = marketer.ouid();
         page.setLabel(user.label());
      }
      //产品集合
      FDataFinancialProductUnit unit = new FDataFinancialProductUnit();
      FLogicDataset<FDataFinancialProductInfo> productList = _productConsole.select(logicContext, unit);
      _logger.debug(this, "Select", "Select finish. (unitListCount={1})", productList.count());
      basePage.setJson(productList.toJsonListString());
      page.setProductList(productList);
      //产品编号
      long productId = 0;
      if(null == context.parameter("productId") || "".equals(context.parameter("productId"))){
         productId = productList.first().ouid();
      }else{
         productId = context.parameterAsLong("productId");
      }
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         page.setPageCurrent(Integer.parseInt(num));
      }else{
         page.setPageCurrent(0);
      }
      //分页处理
      int count = _tenderConsole.selectByMarkterIdAndProductId(logicContext, marketerId, productId);
      int pageTotal = count / FTenderConsole._pageSize;
      if(count % FTenderConsole._pageSize != 0){
         pageTotal += 1;
      }
      page.setNumTotal(count);
      page.setPageTotal(pageTotal);
      // 第0页
      if(page.pageCurrent() == 0){
         page.setPageCurrent(1);
      }
      // 最后一页
      if(pageTotal < page.pageCurrent()){
         page.setPageCurrent(pageTotal);
      }
      FLogicDataset<FDataFinancialTenderInfo> tenderList = _tenderConsole.selectByMarkterIdAndProductId(logicContext, marketerId, productId, page.pageCurrent() - 1);
      page.setTenderList(tenderList);
      return "/pc/marketer/product/CustomerList";
   }

   //============================================================
   // <T>获取客户信息。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param page 页面容器
   //============================================================
   @Override
   public String customerInfo(IWebContext context,
                              IWebSession sessionContext,
                              ILogicContext logicContext,
                              FTenderPage page){
      // 根据客户获取客户的所有信息
      long customer = context.parameterAsLong("customer");
      FDataFinancialCustomerInfo customerInfo = _customerConsole.findInfo(logicContext, customer);
      page.setCustomerInfo(customerInfo);
      return "/pc/marketer/customer/CustomerInfo";
   }

   //============================================================
   // <T>获取理财师产品下的客户。</T>
   //
   // @param context 页面环境
   // @param sessionContext 会话
   // @param logicContext 逻辑环境
   // @param page 页面容器
   //============================================================
   //   @AWebAuthority("eai.marketer.product.customer")
   @Override
   public String select(IWebContext context,
                        IWebSession sessionContext,
                        ILogicContext logicContext,
                        FTenderPage page){
      return null;
   }

   //============================================================
   // <T>查询产品</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String selectProduct(IWebContext context,
                               IWebSession sessionContext,
                               ILogicContext logicContext,
                               FBasePage basePage){
      FDataFinancialProductUnit unit = new FDataFinancialProductUnit();
      FLogicDataset<FDataFinancialProductInfo> unitList = _productConsole.select(logicContext, unit);
      _logger.debug(this, "Select", "Select finish. (unitListCount={1})", unitList.count());
      basePage.setJson(unitList.toJsonListString());
      return "/pc/marketer/product/CustomerList";
   }

   //============================================================
   // <T>查询客户</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String selectByMarketerIdAndProductId(IWebContext context,
                                                IWebSession sessionContext,
                                                ILogicContext logicContext,
                                                FTenderPage page,
                                                FBasePage basePage){
      FGcWebSession session = (FGcWebSession)sessionContext;
      _logger.debug(this, "construct", "construct default begin.(session={1})", session.id());
      FDataPersonUserUnit user = _userConsole.find(logicContext, session.userId());
      long marketerId = 0;
      if(user != null){
         FDataFinancialMarketerUnit marketer = _marketerConsole.findByUserId(logicContext, user.ouid());
         if(marketer == null){
            _logger.debug(this, "construct", "construct this user is not marketer.(user={1})", user.ouid());
            return "/apl/message/LogicFatal";
         }
         marketerId = marketer.ouid();
         page.setLabel(user.label());
      }
      long productId = context.parameterAsLong("productId");
      FLogicDataset<FDataFinancialTenderInfo> tenderList = _tenderConsole.select(logicContext, marketerId, productId);
      _logger.debug(this, "construct", "construct Select finish. (tenderList = {1})", tenderList);
      return null;
   }

}
