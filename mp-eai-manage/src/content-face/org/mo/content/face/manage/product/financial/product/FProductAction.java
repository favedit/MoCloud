package org.mo.content.face.manage.product.financial.product;

import com.cyou.gccloud.data.data.FDataFinancialProductUnit;

import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.financial.product.FDataProductInfo;
import org.mo.content.core.manage.product.financial.product.IProductConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.common.FWebUploadFile;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>产品信息控制器</P>
//@class FProductAction
//@version 1.0.0
//============================================================
public class FProductAction 
      implements 
         IProductAction 
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FProductAction.class);

   // 产品控制台
   @ALink
   protected IProductConsole _productConsole;
   
   // 存储控制台
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

      return "/manage/product/financial/product/ProductList";
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
                        FProductPage Page, 
                        FBasePage basePage) {
      _logger.debug(this, "Select", "Select begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      if (null != context.parameter("page")) {
         String num = context.parameter("page");
         Page.setPageCurrent(Integer.parseInt(num));
      } else {
         Page.setPageCurrent(0);
      }
      FDataProductInfo unit = new FDataProductInfo();
      unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if (null != StrPageSize) {
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataProductInfo> unitList = _productConsole.select(logicContext, unit, Page.pageCurrent() - 1, pageSize);
      for(FDataProductInfo info : unitList){
         String urls = info.iconUrl();
         if(!RString.isEmpty(urls)){
            info.setMakeUrl(_storageConsole.makeUrl(urls.trim()));
         }
      }
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
                              FProductPage page, 
                              FBasePage basePage) {

      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      page.setResult("");
      return "/manage/product/financial/product/InsertProduct";
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
                        FProductPage page, 
                        FBasePage basePage) {
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      FDataFinancialProductUnit unit = _productConsole.doPrepare(logicContext);
      FWebUploadFile file = context.files().first();
      if(null != file){
         Integer len = file.length() / 1024;
         if(len > 1024){
            page.setResult("请上传小于1M的图片!");
            return "/manage/product/financial/product/InsertProduct";
         }
         String type = file.contentType();
         if(!type.contains("image")){
            page.setResult("请上传图片!");
            return "/manage/product/financial/product/InsertProduct";
         }
         SGcStorage storage = new SGcStorage("data.financial.product", unit.guid(), file);
         _storageConsole.store(storage);
         String urls = storage.pack();
         if(!RString.isEmpty(urls)){
            unit.setIconUrl(urls.trim());
         }
      }
      setProductData(context,logicContext,unit);
      EResult result = _productConsole.doInsert(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("增加失败");
         return "/manage/product/financial/product/InsertProduct";
      }
      return "/manage/product/financial/product/ProductList";
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
                              FProductPage page, 
                              FBasePage basePage) {
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");

      FDataProductInfo info = _productConsole.findInfo(logicContext, id);
      
      if(!RString.isEmpty(info.iconUrl())){
         String iconUrl = _storageConsole.makeUrl(info.iconUrl());
         info.setMakeUrl(iconUrl);
      }
      page.setUnit(info);
      page.setResult("");
      return "/manage/product/financial/product/UpdateProduct";
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
                        FProductPage page, 
                        FBasePage basePage) {

      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      FDataFinancialProductUnit unit = _productConsole.find(logicContext, Long.parseLong(context.parameter("ouid")));
      FWebUploadFile file = context.files().first();
      if(null != file){
         Integer len = file.length() / 1024;
         if(len > 1024){
            page.setResult("请上传小于1M的图片!");
            return "/manage/product/financial/product/UpdateProduct";
         }
         String type = file.contentType();
         if(!type.contains("image")){
            page.setResult("请上传图片!");
            return "/manage/product/financial/product/UpdateProduct";
         }
         SGcStorage storage = new SGcStorage("data.financial.product", unit.guid(), file);
         _storageConsole.store(storage);
         String urls = storage.pack();
         if(!RString.isEmpty(urls)){
            unit.setIconUrl(urls.trim());
         }
      }
      setProductData(context,logicContext,unit);
      EResult result = _productConsole.doUpdate(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         page.setResult("更新失败");
         return "/manage/product/financial/product/UpdateProduct";
      }
      return "/manage/product/financial/product/ProductList";
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
                        FProductPage Page, 
                        FBasePage basePage) {
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if (!basePage.userExists()) {
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataFinancialProductUnit unit = _productConsole.find(logicContext, id);
      if (unit == null) {
         throw new FFatalError("id not exists.");
      }
      EResult result = _productConsole.doDelete(logicContext, unit);
      if (!result.equals(EResult.Success)) {
         throw new FFatalError("Delete failure.");
      } else {
         return "/manage/product/financial/product/ProductList";
      }
   }
   // ============================================================
   // <T>抽取公共方法</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   // ============================================================
   public void setProductData(IWebContext context, 
                              ILogicContext logicContext,
                              FDataFinancialProductUnit unit){
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setNote(context.parameter("note"));
      unit.setLabel(context.parameter("label"));
      unit.setCode(context.parameter("code"));
      unit.setHorizonCount(context.parameterAsInteger("horizonCount"));
      unit.setHorizonClosed(context.parameterAsInteger("horizonClosed"));
      unit.setHorizonWait(context.parameterAsInteger("horizonWait"));
      unit.setFactor(context.parameterAsDouble("factor"));
      unit.setRate(context.parameterAsDouble("rate"));
      unit.setHorizonUnit(context.parameter("horizonUnit"));
   }
}
