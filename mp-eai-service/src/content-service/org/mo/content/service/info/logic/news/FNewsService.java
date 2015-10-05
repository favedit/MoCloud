package org.mo.content.service.info.logic.news;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import com.cyou.gccloud.define.enums.common.EGcResult;
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
      FXmlNode inputNode = input.config();
      FXmlNode list = output.config().createNode("NewsInfoList");

      for(FXmlNode node : inputNode.allNodes()){
         String guid = node.text();
         String status = null;
         FXmlNode xruntime = list.createNode("NewsInfo");
         FDataLogicNewsUnit newsUnit = _newsConsole.getNewsByGuid(guid, logicContext);
         if(newsUnit == null){
            status = EGcResult.FailString;
            xruntime.set("guid", guid);
         }else{
            status = EGcResult.SuccessString;
            xruntime.set("ouid", newsUnit.ouid());
            xruntime.set("guid", newsUnit.guid());
            xruntime.set("label", newsUnit.label());
            //            xruntime.set("iconUrl", newsUnit.iconUrl());
            //            xruntime.set("displayCd", newsUnit.displayCd());
            //            xruntime.set("displayOrder", newsUnit.displayOrder());
            //            xruntime.set("recordDate", newsUnit.recordDate());
            //            xruntime.set("keywords", newsUnit.keywords());
            xruntime.set("content", newsUnit.content());
            //            xruntime.set("viewCount", newsUnit.viewCount());
            xruntime.set("updateDate", newsUnit.updateDate());
            //            xruntime.set("statusCd", newsUnit.statusCd());

         }
         // 设置数据
         xruntime.set("status_cd", status);
      }

      _logger.debug(this, "getNewsByGuid", "getNewsByGuid finish. (list={1})", list.toString());

      return EResult.Success;
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
      FXmlNode newsNode = inputNode.findNode("news");
      //      System.out.println("***************************************************---->" + );
      int pageNum = 0, pageSize = 10;
      String pageSizeStr = newsNode.get("pagesize");
      String pageNumStr = newsNode.get("pagenum");
      if(pageSizeStr != null && (!"".equals(pageSizeStr))){
         pageSize = Integer.parseInt(pageSizeStr);
      }
      if(pageNumStr != null && (!"".equals(pageNumStr))){
         pageNum = Integer.parseInt(pageNumStr);
      }
      FLogicDataset<FDataLogicNewsUnit> newsUnits = _newsConsole.select(pageNum, pageSize, logicContext);
      FXmlNode list = output.config().createNode("NewsInfoList");
      String status = null;
      if(newsUnits == null || newsUnits.count() < 1){
         status = EGcResult.FailString;
      }else{
         for(Iterator<FDataLogicNewsUnit> iterator = newsUnits.iterator(); iterator.hasNext();){
            FDataLogicNewsUnit newsUnit = iterator.next();
            FXmlNode xruntime = list.createNode("NewsInfo");
            status = EGcResult.SuccessString;
            xruntime.set("ouid", newsUnit.ouid());
            xruntime.set("guid", newsUnit.guid());
            xruntime.set("label", newsUnit.label());
            //            xruntime.set("iconUrl", newsUnit.iconUrl());
            //            xruntime.set("displayCd", newsUnit.displayCd());
            //            xruntime.set("displayOrder", newsUnit.displayOrder());
            //            xruntime.set("recordDate", newsUnit.recordDate());
            //            xruntime.set("keywords", newsUnit.keywords());
            xruntime.set("content", newsUnit.content());
            //            xruntime.set("viewCount", newsUnit.viewCount());
            xruntime.set("updateDate", newsUnit.updateDate());
            //            xruntime.set("statusCd", newsUnit.statusCd());
            xruntime.set("status_cd", status);
         }
      }
      return EResult.Success;
   }
}
