package org.mo.content.face.product.financial.news;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.mo.com.lang.EResult;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.product.financial.news.FDataNewsInfo;
import org.mo.content.core.product.financial.news.INewsConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.upload.IWebUploadConsole;
import org.mo.web.protocol.common.FWebUploadFile;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>理财师信息控制器</P>
//@class FMarketerAction
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================
public class FNewsAction
      implements
         INewsAction
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FNewsAction.class);

   //业务资讯控制台
   @ALink
   protected INewsConsole _newsConsole;
   @ALink
   protected IWebUploadConsole _webUploadConsole;
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
      return "/manage/product/financial/news/NewsList";
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
                        FNewsPage page,
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
      FDataLogicNewsUnit unit = new FDataLogicNewsUnit();
      unit.setLabel(context.parameter("label"));
      String StrPageSize = context.parameter("pageSize");
      int pageSize = 20;
      if(null != StrPageSize){
         pageSize = Integer.parseInt(StrPageSize);
      }
      FLogicDataset<FDataNewsInfo> unitList = _newsConsole.select(logicContext, unit, page.pageCurrent() - 1, pageSize);
      for(Iterator<FDataNewsInfo> iterator = unitList.iterator(); iterator.hasNext();){
         FDataNewsInfo tunit = iterator.next();
         String s="";
         if(RString.equals(EGcResourceStatus.Unknown,tunit.statusCd())){
            s= EGcResourceStatus.UnknownLabel;
         }
         if(RString.equals(EGcResourceStatus.Apply,tunit.statusCd())){
            s=EGcResourceStatus.ApplyLabel;
         }
         if(RString.equals(EGcResourceStatus.Publish,tunit.statusCd())){
            s=EGcResourceStatus.PublishLabel;
         }
         if(RString.equals(EGcResourceStatus.CheckFail,tunit.statusCd())){
            s=EGcResourceStatus.CheckFailLabel;
         }
         tunit.setStatusCdStr(s);
         String s1="";
         if(RString.equals(EGcDisplay.Unknown, tunit.displayCd())){
            s1= EGcDisplay.UnknownLabel;
         }
         if(RString.equals(EGcDisplay.Enabled,tunit.displayCd())){
            s1=EGcDisplay.EnabledLabel;
         }
         if(RString.equals(EGcDisplay.Disable,tunit.displayCd())){
            s1=EGcDisplay.DisableLabel;
         }
         tunit.setDisplayCdStr(s1);
      }
      basePage.setJson(unitList.toJsonListString());
      _logger.debug(this, "Select", "Select finish. (unitListCount={1})", unitList.count());
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
                              FNewsPage Page,
                              FBasePage basePage){
      _logger.debug(this, "InsertBefore", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return "/manage/product/financial/news/InsertNews";
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
   public String insert(IWebContext context,
                        ILogicContext logicContext,
                        FNewsPage page,
                        FBasePage basePage){
      _logger.debug(this, "Insert", "InsertBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      FDataLogicNewsUnit unit = _newsConsole.doPrepare(logicContext);
      setLogicNews(context,logicContext,unit);
      EResult result = _newsConsole.doInsert(logicContext, unit);
      if(!result.equals(EResult.Success)){
         page.setResult("增加失败");
         return "/manage/product/financial/news/InsertNews";
      }
      _logger.debug(this, "Insert", "Insert finish. (RESULT={S})", "SUCCESS");
      return "/manage/product/financial/news/NewsList";
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
                              FNewsPage page,
                              FBasePage basePage){
      _logger.debug(this, "updateBefore", "updateBefore begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      long id = context.parameterAsLong("id");
      FDataLogicNewsUnit unit = _newsConsole.find(logicContext, id);
      FDataNewsInfo info = new FDataNewsInfo();
      info.setOuid(unit.ouid());
      info.setContent(unit.content());
      info.setDescription(unit.description());
      if(RString.equals(EGcResourceStatus.Unknown,unit.statusCd())){
         info.setStatusCdStr(EGcResourceStatus.UnknownLabel);
      }
      if(RString.equals(EGcResourceStatus.Apply,unit.statusCd())){
         info.setStatusCdStr(EGcResourceStatus.ApplyLabel);
      }
      if(RString.equals(EGcResourceStatus.Publish,unit.statusCd())){
         info.setStatusCdStr(EGcResourceStatus.PublishLabel);
      }
      if(RString.equals(EGcResourceStatus.CheckFail,unit.statusCd())){
         info.setStatusCdStr(EGcResourceStatus.CheckFailLabel);
      }
      if(RString.equals(EGcDisplay.Unknown,unit.displayCd())){
         info.setDisplayCdStr(EGcDisplay.UnknownLabel);
      }
      if(RString.equals(EGcDisplay.Disable,unit.displayCd())){
         info.setDisplayCdStr(EGcDisplay.DisableLabel);
      }
      if(RString.equals(EGcDisplay.Enabled,unit.displayCd())){
         info.setDisplayCdStr(EGcDisplay.EnabledLabel);
      }
      info.setLabel(unit.label());
      if(!RString.isEmpty(unit.iconUrl())){
         info.setIconUrl(unit.iconUrl());
         int na = unit.iconUrl().indexOf("images");
         info.setImageName("/manage/images/"+unit.iconUrl().substring(na+7, unit.iconUrl().length()));
      }
      page.setUnit(info);
      _logger.debug(this, "ouid", "updateBefore begin. (Result={1})", "SUCCESS");
      return "/manage/product/financial/news/UpdateNews";
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
                        FNewsPage Page,
                        FBasePage basePage){
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      _logger.debug(this, "Update", "Update Begin.(id={1})", basePage.userId());
      FDataLogicNewsUnit unit = new FDataLogicNewsUnit();
      unit.setOuid(Long.parseLong(context.parameter("ouid")));
      setLogicNews(context,logicContext,unit);
      _newsConsole.doUpdate(logicContext, unit);
      _logger.debug(this, "Update", "Update finish.(RESULT={1})", "SUCCESS");
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
                        FNewsPage Page,
                        FBasePage basePage){
      _logger.debug(this, "Delete", "Delete begin. (userId={1})", basePage.userId());
      if(!basePage.userExists()){
         return "/manage/common/ConnectTimeout";
      }
      return null;
   }
   //============================================================
   // <T>抽取数据库字段赋值的公共方法</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   public void setLogicNews(IWebContext context, ILogicContext logicContext,FDataLogicNewsUnit unit){
      unit.setCreateUserId(context.parameterAsLong("adminId"));
      unit.setContent(context.parameter("content"));
      unit.setDescription(context.parameter("description"));
      String scd = context.parameter("displayCdStr");
      if(!RString.isEmpty(scd)){
         unit.setDisplayCd(context.parameterAsInteger("displayCdStr"));
      }
      String scc = context.parameter("statusCdStr");
      if(!RString.isEmpty(scc)){
         unit.setStatusCd(context.parameterAsInteger("statusCdStr"));
      }
      unit.setLabel(context.parameter("label"));
      String name = context.files().first().fileName();
      try {
         FileInputStream fi = new FileInputStream(context.files().first().uploadName());
         FileOutputStream fo = new FileOutputStream("D:\\Microbject\\MoCloud\\mp-eai-manage\\webroot\\manage\\images\\"+name);
         byte []buffer =new byte[1024]; 
         int a=0;
         while((a=fi.read(buffer))!=-1){
            fo.write(buffer);
         }
         fo.close();
         fi.close();
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      unit.setIconUrl("D:\\Microbject\\MoCloud\\mp-eai-manage\\webroot\\manage\\images\\"+name);//文件上传的绝对路径
   }

}
