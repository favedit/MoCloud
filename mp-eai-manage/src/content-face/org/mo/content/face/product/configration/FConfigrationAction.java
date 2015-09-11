package org.mo.content.face.product.configration;

import com.cyou.gccloud.data.data.FDataCommonConfigurationUnit;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.product.configration.IConfigrationConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>配置信息接口。</P>
//
// @author sunhr
// @version 150909
//============================================================
public class FConfigrationAction
      implements
         IConfigrationAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FConfigrationAction.class);

   // 配置控制台
   @ALink
   protected IConfigrationConsole _configrationConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FBasePage basePage){
      _logger.debug(this, "Construct", "Construct begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/configration/ConfigList";
   }

   //============================================================
   // <T>查询</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String select(IWebContext context,
                        ILogicContext logicContext,
                        FConfigrationPage Page,
                        FBasePage basePage){
      _logger.debug(this, "Select", "Select begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         Page.setPageCurrent(Integer.parseInt(num));
      }else{
         Page.setPageCurrent(0);
      }
      FDataCommonConfigurationUnit unit = new FDataCommonConfigurationUnit();
      unit.setCode(context.parameter("code"));
      FLogicDataset<FDataCommonConfigurationUnit> unitList = _configrationConsole.select(logicContext, unit, Page.pageCurrent() - 1);
      _logger.debug(this, "Select", "Select finish. (unitListCount={1})", unitList.count());
      basePage.setJson(unitList.toJsonListString());
      return "/manage/common/ajax";
   }

   //============================================================
   // <T>增加之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String insertBefore(IWebContext context,
                              ILogicContext logicContext,
                              FConfigrationPage Page,
                              FBasePage basePage){
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/configration/InsertConfig";
   }

   //============================================================
   // <T>增加之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String insert(IWebContext context,
                        ILogicContext logicContext,
                        FConfigrationPage page,
                        FBasePage basePage){
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      FDataCommonConfigurationUnit unit = _configrationConsole.doPrepare(logicContext);
      unit.setCode(context.parameter("code"));
      unit.setLabel(context.parameter("label"));
      unit.setDataTypeCd(context.parameter("dataType"));
      unit.setDataValue(context.parameter("dataValue"));
      unit.setNote(context.parameter("note"));
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      EResult result = _configrationConsole.doInsert(logicContext, unit);
      if(!result.equals(EResult.Success)){
         page.setResult("增加失败");
         return "/manage/product/configration/InsertConfig";
      }
      return "/manage/product/configration/ConfigList";
   }

   //============================================================
   // <T>更新之前</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String updateBefore(IWebContext context,
                              ILogicContext logicContext,
                              FConfigrationPage configrationPage,
                              FBasePage basePage){
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");

      FDataCommonConfigurationUnit unit = _configrationConsole.find(logicContext, id);
      configrationPage.setUnit(unit);
      return "/manage/product/configration/UpdateConfig";
   }

   //============================================================
   // <T>更新</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String update(IWebContext context,
                        ILogicContext logicContext,
                        FConfigrationPage Page,
                        FBasePage basePage){

      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", context.parameter("configInfoId"));
      FDataCommonConfigurationUnit unit = new FDataCommonConfigurationUnit();
      unit.setOuid(Long.parseLong(context.parameter("configInfoId")));
      unit.setLabel(context.parameter("label"));
      unit.setCode(context.parameter("code"));
      unit.setDataTypeCd(context.parameter("dataType"));
      unit.setDataValue(context.parameter("dataValue"));
      unit.setNote(context.parameter("note"));
      _configrationConsole.doUpdate(logicContext, unit);
      return "/manage/common/ajax";
   }

   //============================================================
   // <T>删除</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String delete(IWebContext context,
                        ILogicContext logicContext,
                        FConfigrationPage Page,
                        FBasePage basePage){
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataCommonConfigurationUnit unit = _configrationConsole.find(logicContext, id);
      if(unit == null){
         throw new FFatalError("id not exists.");
      }
      EResult result = _configrationConsole.doDelete(logicContext, unit);
      if(!result.equals(EResult.Success)){
         throw new FFatalError("Delete failure.");
      }else{
         return "/manage/product/configration/ConfigList";
      }
   }
}
