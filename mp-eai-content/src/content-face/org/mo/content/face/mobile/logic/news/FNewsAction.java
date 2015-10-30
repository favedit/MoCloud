package org.mo.content.face.mobile.logic.news;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import com.cyou.gccloud.data.data.FDataPersonUserLogic;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.data.FSql;
import org.mo.content.core.mobile.logic.news.INewsConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>客户信息控制器</P>
//@class FCustomerAction
//@author AnjoyTian
//@Date 2015.09.21  
//@version 1.0.0
//============================================================
public class FNewsAction
      implements
         INewsAction
{
   // 日志输出接口
   //   private static ILogger _logger = RLogger.find(FNewsAction.class);
   //新闻逻辑控制台
   @ALink
   protected INewsConsole _newsConsole;

   // 存储服务器
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FNewsPage page,
                           FBasePage basePage){
      String guid = context.parameter("guid");
      FDataLogicNewsUnit newsUnit = _newsConsole.getNewsByGuid(guid, logicContext);
      newsUnit.setContent(_storageConsole.makeDisplay(newsUnit.content()));
      if(newsUnit != null){
         FSql whereFSql = new FSql();
         whereFSql.append(FDataPersonUserLogic.OUID);
         whereFSql.append("=");
         whereFSql.append(newsUnit.createUserId());
         FLogicDataset<FDataPersonUserUnit> fetch = logicContext.findLogic(FDataPersonUserLogic.class).fetch(whereFSql);
         String userLabel = "";
         if(fetch != null && fetch.count() > 0){
            userLabel = fetch.first().label();
         }
         page.setUserLabel(userLabel);
         page.setUnit(newsUnit);
      }

      return "/manage/mobile/newslist/NewsInfo";
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
   public String getNewInfo(IWebContext context,
                            ILogicContext logicContext,
                            FNewsPage page,
                            FBasePage basePage){
      String guid = context.parameter("guid");
      FDataLogicNewsUnit newsUnit = _newsConsole.getNewsByGuid(guid, logicContext);
      if(newsUnit != null){
         FSql whereFSql = new FSql();
         whereFSql.append(FDataPersonUserLogic.OUID);
         whereFSql.append("=");
         whereFSql.append(newsUnit.createUserId());
         FLogicDataset<FDataPersonUserUnit> fetch = logicContext.findLogic(FDataPersonUserLogic.class).fetch(whereFSql);
         String userLabel = "";
         if(fetch != null && fetch.count() > 0){
            userLabel = fetch.first().label();
         }
         newsUnit.setContent(_storageConsole.makeDisplay(newsUnit.content()));
         page.setUserLabel(userLabel);
         page.setUnit(newsUnit);
      }else{
         page.setUnit(new FDataLogicNewsUnit());
         page.setUserLabel("");
      }

      return "/manage/mobile/newslist/NewsInfo";
   }
}
