package org.mo.content.face.manage.product.business.salestools;

import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.business.salestools.FDataSalestoolsInfo;
import org.mo.content.core.manage.product.business.salestools.ISalestoolsConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.common.FWebUploadFile;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>销售工具控制器</P>
//@class FSalestoolsAction
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
                           FBasePage basePage){
      _logger.debug(this, "Construct", "Construct begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/business/salestools/SalestoolsList";
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
      FDataLogicSalestoolsUnit unit = new FDataLogicSalestoolsUnit();
      unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if(null != StrPageSize){
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataSalestoolsInfo> unitList = _salestoolsConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
      for(FDataSalestoolsInfo info : unitList){
         info.setMakeUrl(_storageConsole.makeUrl(info.iconUrl()));
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
                              FSalestoolsPage page,
                              FBasePage basePage){
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      page.setResult("");
      return "/manage/product/business/salestools/InsertSalestools";
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
                        FSalestoolsPage page,
                        FBasePage basePage){
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicSalestoolsUnit unit = _salestoolsConsole.doPrepare(logicContext);
      FWebUploadFile file = context.files().first();
      if(null != file){
         Integer len = file.length() / 1024;
         if(len > 1024){
            page.setResult("请上传小于1M的图片!");
            return "/manage/product/business/salestools/InsertSalestools";
         }
         String type = file.contentType();
         if(!type.contains("image")){
            page.setResult("请上传图片!");
            return "/manage/product/business/salestools/InsertSalestools";
         }
         SGcStorage storage = new SGcStorage("data.logic.salestools", unit.guid(), file);
         _storageConsole.store(storage);
         unit.setIconUrl(storage.pack());
         _logger.debug(this, "Insert", "Insert insertImages .(url={1})", _storageConsole.makeUrl(storage.pack()));
      }
      unit.setContent(_storageConsole.makeText(context.parameter("content")));
      setLogicNews(context, logicContext, unit, "0");
      EResult result = _salestoolsConsole.doInsert(logicContext, unit);
      if(!result.equals(EResult.Success)){
         page.setResult("增加失败");
         return "/manage/product/business/salestools/InsertSalestools";
      }
      _logger.debug(this, "Insert", "Insert finish. (RESULT={S})", "SUCCESS");
      return "/manage/product/business/salestools/SalestoolsList";
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
                              FSalestoolsPage page,
                              FBasePage basePage){
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
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
      info.setIconUrl(unit.iconUrl());
      if(unit.content().trim().length() > 0){
         info.setContent(_storageConsole.makeEdit(unit.content()));
      }
      if(info.iconUrl() != null && info.iconUrl().trim().length() > 0){
         String iconUrl = _storageConsole.makeUrl(info.iconUrl());
         info.setMakeUrl(iconUrl);
      }
      page.setUnit(info);
      page.setResult("");
      _logger.debug(this, "ouid", "updateBefore begin. (Result={1})", "SUCCESS");
      return "/manage/product/business/salestools/UpdateSalestools";
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
                        FSalestoolsPage page,
                        FBasePage basePage){
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      FDataLogicSalestoolsUnit unit = _salestoolsConsole.find(logicContext, Long.parseLong(context.parameter("ouid")));
      FWebUploadFile file = context.files().first();
      if(null != file){
         Integer len = file.length() / 1024;
         if(len > 1024){
            page.setResult("请上传小于1M的图片!");
            return "/manage/product/business/salestools/UpdateSalestools";
         }
         String type = file.contentType();
         if(!type.contains("image")){
            page.setResult("请上传图片!");
            return "/manage/product/business/salestools/UpdateSalestools";
         }
         SGcStorage storage = new SGcStorage("data.logic.salestools", unit.guid(), file);
         _storageConsole.store(storage);
         unit.setIconUrl(storage.pack());
         _logger.debug(this, "Update", "Update uploadImages .(url={1})", _storageConsole.makeUrl(storage.pack()));
      }
      String content = context.parameter("content");
      unit.setContent(_storageConsole.makeText(content));
      setLogicNews(context, logicContext, unit, "1");
      _salestoolsConsole.doUpdate(logicContext, unit);
      _logger.debug(this, "Update", "Update finish.(RESULT={1})", "SUCCESS");
      return "/manage/product/business/salestools/SalestoolsList";
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
                              FSalestoolsPage Page,
                              FBasePage basePage){
      _logger.debug(this, "deleteBefore", "deleteBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataLogicSalestoolsUnit unit = _salestoolsConsole.find(logicContext, id);
      if(RString.equals(unit.statusCd(), 2)){
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
                        FSalestoolsPage Page,
                        FBasePage basePage){
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataLogicSalestoolsUnit unit = _salestoolsConsole.find(logicContext, id);
      if(unit == null){
         throw new FFatalError("id not exists.");
      }
      EResult result = _salestoolsConsole.doDelete(logicContext, unit);
      if(!result.equals(EResult.Success)){
         throw new FFatalError("Delete failure.");
      }else{
         return "/manage/product/business/salestools/SalestoolsList";
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
                            FDataLogicSalestoolsUnit unit,
                            String flag){
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setDescription(context.parameter("description"));
      unit.setKeywords(context.parameter("keywords"));
      unit.setDisplayOrder(context.parameterAsInteger("displayOrder"));
      unit.setDisplayCd(context.parameterAsInteger("displayCd"));
      unit.setLinkCd(context.parameterAsInteger("linkCd"));
      unit.setStatusCd(EGcResourceStatus.Apply);
      unit.setLabel(context.parameter("label"));
      unit.setLinkUrl(context.parameter("linkUrl"));
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
                              FSalestoolsPage page,
                              FBasePage basePage){
      _logger.debug(this, "selectByData", "selectByData begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         page.setPageCurrent(Integer.parseInt(num));
      }else{
         page.setPageCurrent(0);
      }
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if(null != StrPageSize){
         pageSize = Integer.parseInt(StrPageSize);
      }
      Integer statusCd = context.parameterAsInteger("statusCd");
      Integer displayCd = context.parameterAsInteger("displayCd");
      String label = context.parameter("label");
      FLogicDataset<FDataSalestoolsInfo> unitlist = _salestoolsConsole.selectByMessage(logicContext, statusCd, displayCd, label, page.pageCurrent() - 1, pageSize);
      basePage.setJson(unitlist.toJsonListString());
      _logger.debug(this, "selectByData", "selectByData finish. (unitListCount={1})", unitlist.count());
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
                                FSalestoolsPage page,
                                FBasePage basePage){
      _logger.debug(this, "getDescription", "getDescription begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicSalestoolsUnit unit = _salestoolsConsole.find(logicContext, context.parameterAsLong("ouid"));
      FDataSalestoolsInfo info = new FDataSalestoolsInfo();
      info.setContent(_storageConsole.makeDisplay(unit.content()));
      page.setUnit(info);
      _logger.debug(this, "getDescription", "getDescription finish. (Result={1})", "SUCCESS");
      return "/manage/product/business/salestools/SalestoolsDataInfoForContent";
   }
}
