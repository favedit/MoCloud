package org.mo.content.face.mobile.logic.truetimedata;

import com.cyou.gccloud.data.data.FDataLogicTruetimeLogic;
import com.cyou.gccloud.data.data.FDataLogicTruetimeUnit;
import org.mo.com.data.FSql;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.mobile.logic.truetimedata.ITrueTimeDataConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.content.face.mobile.logic.salestools.FSalesToolsAction;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>实时数据控制器</P>
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
   private static ILogger _logger = RLogger.find(FSalesToolsAction.class);

   //新闻逻辑控制台
   @ALink
   protected ITrueTimeDataConsole _trueTimeDataConsole;

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
      _logger.debug(this, "GetContent", "getContent begin.");
      String guid = context.parameter("guid");
      FDataLogicTruetimeUnit salesUnit = _trueTimeDataConsole.getNewsByGuid(guid, logicContext);
      if(salesUnit != null){
         _logger.debug(this, "GetContent", "getContent find unit fnish.(salesUnit={1})", salesUnit.ouid());
         FSql whereFSql = new FSql();
         whereFSql.append(FDataLogicTruetimeLogic.OUID);
         whereFSql.append("=");
         whereFSql.append(salesUnit.createUserId());
         FLogicDataset<FDataLogicTruetimeUnit> fetch = logicContext.findLogic(FDataLogicTruetimeLogic.class).fetch(whereFSql);
         String userLabel = "";
         if(fetch != null && fetch.count() > 0){
            userLabel = fetch.first().label();
         }
         page.setUserLabel(userLabel);
         page.setUnit(salesUnit);
      }else{
         _logger.debug(this, "GetContent", "getContent find unit is null.");
         page.setUnit(new FDataLogicTruetimeUnit());
         page.setUserLabel("");
      }

      return "/manage/mobile/truetimedata/TrueTimeData";
   }
}
