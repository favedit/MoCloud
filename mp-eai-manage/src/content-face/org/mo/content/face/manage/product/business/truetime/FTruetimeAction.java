package org.mo.content.face.manage.product.business.truetime;

import com.cyou.gccloud.data.data.FDataLogicTruetimeUnit;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.core.storage.SGcStorage;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.product.business.truetime.FDataTruetimeInfo;
import org.mo.content.core.manage.product.business.truetime.ITruetimeConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.upload.IWebUploadConsole;
import org.mo.web.protocol.common.FWebUploadFile;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>实时数据控制器</P>
//@class FTruetimeAction
//============================================================
public class FTruetimeAction
      implements
         ITruetimeAction
{

   // 日志输出接口
   private static ILogger _logger = RLogger.find(FTruetimeAction.class);

   // 业务资讯控制台
   @ALink
   protected ITruetimeConsole _truetimeConsole;

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
                           FBasePage basePage){
      _logger.debug(this, "Construct", "Construct begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/business/truetime/TruetimeList";
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
                        FTruetimePage page,
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
      FDataLogicTruetimeUnit unit = new FDataLogicTruetimeUnit();
      unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if(null != StrPageSize){
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataTruetimeInfo> unitList = _truetimeConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
      for(FDataTruetimeInfo info : unitList){
         info.setMakeUrl(_storageConsole.makeUrl(info.iconUrl()));
         info.setContent(_storageConsole.makeDisplay(unit.content()));
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
                              FTruetimePage page,
                              FBasePage basePage){
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      page.setResult("");
      return "/manage/product/business/truetime/InsertTruetime";
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
                        FTruetimePage page,
                        FBasePage basePage){
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicTruetimeUnit unit = _truetimeConsole.doPrepare(logicContext);
      FWebUploadFile file = context.files().first();
      if(null != file){
         Integer len = file.length() / 1024;
         if(len > 1024){
            page.setResult("请上传小于1M的图片!");
            return "/manage/product/business/truetime/InsertTruetime";
         }
         String type = file.contentType();
         if(!type.contains("image")){
            page.setResult("请上传图片!");
            return "/manage/product/business/truetime/InsertTruetime";
         }
         SGcStorage storage = new SGcStorage("data.logic.truetime", unit.guid(), file);
         _storageConsole.store(storage);
         unit.setIconUrl(storage.pack());
         _logger.debug(this, "Insert", "Insert insertImages .(url={1})", _storageConsole.makeUrl(storage.pack()));
      }
      unit.setContent(_storageConsole.makeText(context.parameter("context")));

      setLogicNews(context, logicContext, unit, "0");
      EResult result = _truetimeConsole.doInsert(logicContext, unit);
      if(!result.equals(EResult.Success)){
         page.setResult("增加失败");
         return "/manage/product/business/truetime/InsertTruetime";
      }
      _logger.debug(this, "Insert", "Insert finish. (RESULT={S})", "SUCCESS");
      return "/manage/product/business/truetime/TruetimeList";
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
                              FTruetimePage page,
                              FBasePage basePage){
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataLogicTruetimeUnit unit = _truetimeConsole.find(logicContext, id);
      FDataTruetimeInfo info = new FDataTruetimeInfo();
      info.setOuid(unit.ouid());
      info.setDescription(unit.description());
      info.setKeywords(unit.keywords());
      info.setDisplayCd(unit.displayCd());
      info.setLinkCd(unit.linkCd());
      info.setLinkUrl(unit.linkUrl());
      info.setLabel(unit.label());
      info.setDisplayOrder(unit.displayOrder());
      if(unit.content().trim().length() > 0){
         info.setContent(_storageConsole.makeEdit(unit.content()));
      }
      if(!RString.isEmpty(unit.iconUrl())){
         String iconUrl = _storageConsole.makeUrl(unit.iconUrl());
         info.setMakeUrl(iconUrl);
         _logger.debug(this, "UpdateBefore", "UpdateBefore makeImages .(url={1})", iconUrl);
      }
      page.setUnit(info);
      page.setResult("");
      _logger.debug(this, "ouid", "updateBefore begin. (Result={1})", "SUCCESS");
      return "/manage/product/business/truetime/UpdateTruetime";
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
                        FTruetimePage page,
                        FBasePage basePage){
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicTruetimeUnit unit = _truetimeConsole.find(logicContext, Long.parseLong(context.parameter("ouid")));
      FWebUploadFile file = context.files().findByName("iconUrl");
      if(null != file){
         Integer len = file.length() / 1024;
         if(len > 1024){
            page.setResult("请上传小于1M的图片!");
            return "/manage/product/business/truetime/UpdateTruetime";
         }
         String type = file.contentType();
         if(!type.contains("image")){
            page.setResult("请上传图片!");
            return "/manage/product/business/truetime/UpdateTruetime";
         }
         SGcStorage storage = new SGcStorage("data.logic.truetime", unit.guid(), file);
         _storageConsole.store(storage);
         unit.setIconUrl(storage.pack());
         _logger.debug(this, "Update", "Update uploadImages .(url={1})", _storageConsole.makeUrl(storage.pack()));
      }
      String content = context.parameter("content");
      unit.setContent(_storageConsole.makeText(content));
      setLogicNews(context, logicContext, unit, "1");
      _truetimeConsole.doUpdate(logicContext, unit);
      _logger.debug(this, "Update", "Update finish.(RESULT={1})", "SUCCESS");
      return "/manage/product/business/truetime/TruetimeList";
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
                        FTruetimePage Page,
                        FBasePage basePage){
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataLogicTruetimeUnit unit = _truetimeConsole.find(logicContext, id);
      if(unit == null){
         throw new FFatalError("id not exists.");
      }
      EResult result = _truetimeConsole.doDelete(logicContext, unit);
      if(!result.equals(EResult.Success)){
         throw new FFatalError("Delete failure.");
      }else{
         return "/manage/product/business/truetime/TruetimeList";
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
                            FDataLogicTruetimeUnit unit,
                            String flag){
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setDescription(context.parameter("description"));
      unit.setKeywords(context.parameter("keywords"));
      unit.setDisplayOrder(context.parameterAsInteger("displayOrder"));
      unit.setDisplayCd(context.parameterAsInteger("displayCd"));
      unit.setLinkCd(context.parameterAsInteger("linkCd"));
      unit.setLabel(context.parameter("label"));
      unit.setLinkUrl(context.parameter("linkUrl"));
      unit.setStatusCd(EGcResourceStatus.Apply);
      //      FWebUploadFile file = context.files().first();
      //      if(null == file){
      //         String oiconUr = context.parameter("oiconUr");
      //         if(!RString.isEmpty(oiconUr)){
      //            unit.setIconUrl(oiconUr);
      //         }else{
      //            unit.setIconUrl(context.parameter("iconUrl"));
      //         }
      //      }else{
      //               _truetimeConsole.saveImage(file, unit, flag);
      //      }
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
                                FTruetimePage page,
                                FBasePage basePage){
      _logger.debug(this, "getDescription", "getDescription begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicTruetimeUnit unit = _truetimeConsole.find(logicContext, context.parameterAsLong("ouid"));
      FDataTruetimeInfo info = new FDataTruetimeInfo();
      info.setContent(unit.content());
      page.setUnit(info);
      _logger.debug(this, "getDescription", "getDescription finish. (Result={1})", "SUCCESS");
      return "/manage/product/business/truetime/TruetimeDataInfoForContent";
   }
}
