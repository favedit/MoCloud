package org.mo.content.face.mobile.logic.truetimedata;

import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import com.cyou.gccloud.data.data.FDataPersonUserLogic;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.com.data.FSql;
import org.mo.content.core.mobile.logic.salestools.ISalesToolsConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.content.service.mobile.logic.news.INewsService;
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
public class FTrueTimeDataAction
      implements
         ITrueTimeDataAction
{
   // 日志输出接口
   //   private static ILogger _logger = RLogger.find(FSalesToolsAction.class);

   @ALink
   protected INewsService _newsService;

   //新闻逻辑控制台
   @ALink
   protected ISalesToolsConsole _salesToolsConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FTrueTimeDataPage page,
                           FBasePage basePage){

      return "";
   }

   //============================================================
   // <T>查询</T>
   // @销售工具中的计算器模板
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String getInfo(IWebContext context,
                         ILogicContext logicContext,
                         FTrueTimeDataPage page,
                         FBasePage basePage){
      System.out.println(page.result + "-----------------------------page.result" + page.result);
      return "/manage/mobile/salestools/calculator/SalesInfo";
   }

   //============================================================
   // <T>查询</T>
   // @销售工具中内容模板
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================
   @Override
   public String getContent(IWebContext context,
                            ILogicContext logicContext,
                            FTrueTimeDataPage page,
                            FBasePage basePage){
      System.out.println(page.result + "-----------------------------page.result" + page.result);
      String guid = context.parameter("guid");
      FDataLogicSalestoolsUnit salesUnit = _salesToolsConsole.getNewsByGuid(guid, logicContext);
      System.out.println("**********************************************newsUnit" + salesUnit + guid);

      if(salesUnit != null){
         FSql whereFSql = new FSql();
         whereFSql.append(FDataPersonUserLogic.OUID);
         whereFSql.append("=");
         whereFSql.append(salesUnit.createUserId());
         FLogicDataset<FDataPersonUserUnit> fetch = logicContext.findLogic(FDataPersonUserLogic.class).fetch(whereFSql);
         String userLabel = "";
         if(fetch != null && fetch.count() > 0){
            userLabel = fetch.first().label();
         }
         page.setUserLabel(userLabel);
         page.setUnit(salesUnit);
         //      System.out.println("**********************************************" + guid + newsUnit.content());
      }else{
         page.setUnit(new FDataLogicSalestoolsUnit());
         page.setUserLabel("");
      }

      return "/manage/mobile/salestools/contentlist/Content";
   }

   //============================================================
   // <T>销售工具中集团简介模板</T>
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param page 容器
   // @return 页面
   //============================================================

   @Override
   public String getGroupInfo(IWebContext context,
                              ILogicContext logicContext,
                              FTrueTimeDataPage page,
                              FBasePage basePage){
      System.out.println(page.result + "-----------------------------page.result" + page.result);
      return "/manage/mobile/salestools/groupinfo/GroupInfo";
   }
}
