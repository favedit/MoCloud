package org.mo.content.face.mobile;

import com.cyou.gccloud.data.data.FDataSystemApplicationUnit;
import com.cyou.gccloud.data.data.FDataSystemVersionLogic;
import com.cyou.gccloud.data.data.FDataSystemVersionUnit;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.RString;
import org.mo.content.core.mobile.logic.news.INewsConsole;
import org.mo.content.core.system.application.IApplicationConsole;
import org.mo.content.core.system.version.IVersionConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>客户信息控制器</P>
//@class FCustomerAction
//@author hyw
//============================================================
public class FMobileAction
      implements
         IMobileAction
{
   // 日志输出接口
   //   private static ILogger _logger = RLogger.find(FNewsAction.class);
   //新闻逻辑控制台
   @ALink
   protected INewsConsole _newsConsole;

   // 存储服务器
   @ALink
   protected IGcStorageConsole _storageConsole;

   @ALink
   protected IApplicationConsole _applicationConsole;

   @ALink
   protected IVersionConsole _versionConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================                         
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FMobilePage Page,
                           FBasePage basePage){

      return null;
   }

   //============================================================
   // <T>获取安卓最新版本。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================               
   @Override
   public String getAndroid(IWebContext context,
                            ILogicContext logicContext,
                            FMobilePage Page,
                            FBasePage basePage){
      String appkey = "0E144A4C9CA64FAB854FF2DE8B589312";
      FDataSystemVersionLogic logic = logicContext.findLogic(FDataSystemVersionLogic.class);

      FDataSystemApplicationUnit app = _applicationConsole.findByGuid(logicContext, appkey);

      FDataSystemVersionUnit version = _versionConsole.findMaxByAppId(logicContext, app.ouid());
      System.out.println(version.downloadUrl() + "==============================================================number");
      Page.setDownloadUrl(version.downloadUrl());
      //      System.out.println(unit.downloadUrl() + "==============================================================unit.downloadUrl()");
      return "/mobile/DownFile";
   }

   //============================================================
   // <T>获取ios最新版本。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================            
   @Override
   public String getIos(IWebContext context,
                        ILogicContext logicContext,
                        FMobilePage Page,
                        FBasePage basePage){
      String appkey = "58BEFC782B9E4CE5A65B34B8C1E89141";
      FDataSystemVersionLogic logic = logicContext.findLogic(FDataSystemVersionLogic.class);
      FSql whereSql = new FSql();
      whereSql.append(FDataSystemVersionLogic.NUMBER, " = '{NUMBER}'");
      //      System.out.println(_applicationConsole.getNumber(context, logicContext, Page, basePage, appkey) + "==============================================================number");
      whereSql.bind("NUMBER", RString.parse(_applicationConsole.getNumber(context, logicContext, Page, basePage, appkey)));
      FDataSystemVersionUnit unit = logic.search(FDataSystemVersionUnit.class, whereSql);
      Page.setDownloadUrl(unit.downloadUrl());
      //      System.out.println(unit.downloadUrl() + "==============================================================unit.downloadUrl()");
      return "/mobile/DownFile";
   }

}
