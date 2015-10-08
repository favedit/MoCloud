package org.mo.content.service.info.logic.news;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import java.util.Iterator;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.logic.news.INewsConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>新闻服务。</T>
//============================================================
public class FNewsService
      extends FObject
      implements
         INewsService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FNewsService.class);

   //新闻逻辑控制台
   @ALink
   protected INewsConsole _newsConsole;

   //============================================================
   // <T>默认逻辑。</T>
   //
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult process(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      _logger.debug(this, "process", "process begin. ");
      return EResult.Success;
   }

   //============================================================
   // <T>根据guid获取新闻相关信息。</T>
   //
   // @param guid 
   //============================================================
   @Override
   public EResult query(IWebContext context,
                        IWebInput input,
                        IWebOutput output,
                        ILogicContext logicContext){
      _logger.debug(this, "FNewsService_query", "FNewsService_query begin. ");
      // 获得guid参数
      String guid = input.config().findNode("guid").text();
      FXmlNode news_info = output.config().createNode("news_info");
      FDataLogicNewsUnit newsUnit = _newsConsole.getNewsByGuid(guid, logicContext);
      if(newsUnit == null){
         news_info.set("guid", guid);
      }else{
         news_info.createNode("ouid").setText(newsUnit.ouid());
         news_info.createNode("guid").setText(newsUnit.guid());
         news_info.createNode("label").setText(newsUnit.label());
         news_info.createNode("content").setText(newsUnit.content());
         news_info.createNode("update_date").setText(newsUnit.updateDate() + "");
         return EResult.Success;
      }
      return EResult.Failure;
   }

   //============================================================
   // <T>分页获取新闻相关信息。</T>
   //
   // @param pageNum 页数
   // @param pageSize 每页的行数
   //============================================================
   @Override
   public EResult select(IWebContext context,
                         IWebInput input,
                         IWebOutput output,
                         ILogicContext logicContext){
      _logger.debug(this, "FNewsService_select", "FNewsService_select begin. ");

      FXmlNode inputNode = input.config();
      //      System.out.println("***************************************************---->" + );
      int pageNum = 0, pageSize = 10;
      String pageSizeStr = input.config().findNode("pagesize").text();
      String pageNumStr = input.config().findNode("pagenumber").text();
      if(pageSizeStr != null && (!"".equals(pageSizeStr))){
         pageSize = Integer.parseInt(pageSizeStr);
      }
      if(pageNumStr != null && (!"".equals(pageNumStr))){
         pageNum = Integer.parseInt(pageNumStr);
      }
      FLogicDataset<FDataLogicNewsUnit> newsUnits = _newsConsole.select(pageNum, pageSize, logicContext);
      output.config().createNode("page_number").setText(pageNumStr);
      FXmlNode list = output.config().createNode("news_list");
      if(newsUnits == null || newsUnits.count() < 1){
      }else{
         for(Iterator<FDataLogicNewsUnit> iterator = newsUnits.iterator(); iterator.hasNext();){
            FDataLogicNewsUnit newsUnit = iterator.next();
            FXmlNode xruntime = list.createNode("news_info");
            xruntime.createNode("ouid").setText(newsUnit.ouid());
            xruntime.createNode("guid").setText(newsUnit.guid());
            xruntime.createNode("label").setText(newsUnit.label());
            xruntime.createNode("content").setText(newsUnit.content());
            xruntime.createNode("icon_url").setText(newsUnit.iconUrl());
            xruntime.createNode("update_date").setText(newsUnit.updateDate() + "");
         }
      }
      return EResult.Success;
   }
}
