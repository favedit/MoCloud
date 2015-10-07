package org.mo.content.face.product.system.application;

import org.mo.com.lang.EResult;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.product.system.application.IApplicationConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

import com.cyou.gccloud.data.data.FDataSystemApplicationUnit;
//============================================================
//<P>应用控制器</P>
//@class FProductAction
//@author AnjoyTian
//@Date 2015.09.29  
//@version 1.0.0
//============================================================
public class FApplicationAction 
               implements IApplicationAction {
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FApplicationAction.class);
   
   //应用控制端
   @ALink
   private IApplicationConsole _applicationConsole;
   
   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(IWebContext context, ILogicContext logicContext, FBasePage page) {
      _logger.debug(this, "Construct", "Construct begin. (userId={1})", page.userId());
      if(!page.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/system/application/ApplicationList";
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
   public String select(IWebContext context, ILogicContext logicContext, FApplicationPage page, FBasePage basePage) {
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
      FDataSystemApplicationUnit unit = new FDataSystemApplicationUnit();
      unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if(null != StrPageSize){
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataSystemApplicationUnit> unitList = _applicationConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
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
   public String insertBefore(IWebContext context, ILogicContext logicContext, FApplicationPage page, FBasePage basePage) {
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/system/application/InsertApplication";
   }
   //============================================================
   // <T>增加</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String insert(IWebContext context, ILogicContext logicContext, FApplicationPage page, FBasePage basePage) {
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      FDataSystemApplicationUnit unit = _applicationConsole.doPrepare(logicContext);
      setLogicApplication(context,logicContext,unit);
      EResult result = _applicationConsole.doInsert(logicContext, unit);
      if(!result.equals(EResult.Success)){
         page.setResult("增加失败");
         return "/manage/product/system/application/InsertApplication";
      }
      _logger.debug(this, "Insert", "Insert finish. (RESULT={S})", "SUCCESS");
      return "/manage/product/system/application/ApplicationList";
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
   public String updateBefore(IWebContext context, ILogicContext logicContext, FApplicationPage page, FBasePage basePage) {
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataSystemApplicationUnit unit = _applicationConsole.find(logicContext, id);
      page.setUnit(unit);
      _logger.debug(this, "ouid", "updateBefore finish. (Result={1})", "SUCCESS");
      return "/manage/product/system/application/UpdateApplication";
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
   public String update(IWebContext context, ILogicContext logicContext, FApplicationPage page, FBasePage basePage) {
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      FDataSystemApplicationUnit unit = _applicationConsole.find(logicContext, Long.parseLong(context.parameter("ouid")));
      unit.setOuid(Long.parseLong(context.parameter("ouid")));
      setLogicApplication(context,logicContext,unit);
      _applicationConsole.doUpdate(logicContext, unit);
      _logger.debug(this, "Update", "Update finish.(RESULT={1})", "SUCCESS");
      return "/manage/common/ajax";
   }

   @Override
   public String delete(IWebContext context, ILogicContext logicContext, FApplicationPage page, FBasePage basePage) {
      // TODO Auto-generated method stub
      return null;
   }
   //============================================================
   // <T>抽取数据库字段赋值的公共方法</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return void 
   //============================================================
   public void setLogicApplication(IWebContext context, ILogicContext logicContext,FDataSystemApplicationUnit unit){
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setCode(context.parameter("code"));
      unit.setLabel(context.parameter("label"));
      unit.setNote(context.parameter("note"));
   }
}
