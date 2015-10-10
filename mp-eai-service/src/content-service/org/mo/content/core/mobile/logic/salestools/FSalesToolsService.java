package org.mo.content.core.mobile.logic.salestools;

import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import com.cyou.gccloud.define.enums.core.EGcLink;
import java.util.Iterator;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>新闻服务。</T>
//============================================================
public class FSalesToolsService
      extends FObject
      implements
         ISalesToolsService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FSalesToolsService.class);

   //新闻逻辑控制台
   @ALink
   protected ISalesToolsConsole _salesToolsConsole;

   protected String _salesServiceHost = "http://eai.ezubo.com:8089/";

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
      FDataLogicSalestoolsUnit newsUnit = _salesToolsConsole.getNewsByGuid(guid, logicContext);
      if(newsUnit == null){
         news_info.set("guid", guid);
      }else{
         //         news_info.createNode("ouid").setText(newsUnit.ouid());
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
      _logger.debug(this, "FSalesToolsService_select", "FSalesToolsService_select begin. ");
      int pageNum = 0, pageSize = 10;
      String pageSizeStr = input.config().findNode("pagesize").text();
      String pageNumStr = input.config().findNode("pagenumber").text();
      if(pageSizeStr != null && (!"".equals(pageSizeStr))){
         pageSize = Integer.parseInt(pageSizeStr);
      }
      if(pageNumStr != null && (!"".equals(pageNumStr))){
         pageNum = Integer.parseInt(pageNumStr);
      }
      FLogicDataset<FDataLogicSalestoolsUnit> salesToolsUnits = _salesToolsConsole.select(pageNum, pageSize, logicContext);
      output.config().createNode("page_number").setText(pageNumStr);
      FXmlNode list = output.config().createNode("sales_list");
      if(salesToolsUnits != null && salesToolsUnits.count() > 0){
         for(Iterator<FDataLogicSalestoolsUnit> iterator = salesToolsUnits.iterator(); iterator.hasNext();){
            FDataLogicSalestoolsUnit salesToolsUnit = iterator.next();
            FXmlNode xruntime = list.createNode("sales_info");
            //            xruntime.createNode("ouid").setText(newsUnit.ouid());
            if(salesToolsUnit.guid() != null && (!"".equals(salesToolsUnit.guid()))){
               xruntime.createNode("guid").setText(salesToolsUnit.guid());
            }else{
               xruntime.createNode("guid").setText("0");
            }
            if(salesToolsUnit.label() != null && (!"".equals(salesToolsUnit.label()))){
               xruntime.createNode("label").setText(salesToolsUnit.label());
            }else{
               xruntime.createNode("label").setText("0");
            }
            if(salesToolsUnit.description() != null && (!"".equals(salesToolsUnit.description()))){
               xruntime.createNode("description").setText(salesToolsUnit.description());
            }else{
               xruntime.createNode("description").setText("0");
            }
            if(salesToolsUnit.iconUrl() != null && (!"".equals(salesToolsUnit.iconUrl()))){
               xruntime.createNode("icon_url").setText(salesToolsUnit.iconUrl());
            }else{
               xruntime.createNode("icon_url").setText("0");
            }
            if(salesToolsUnit.updateDate() + "" != null && (!"".equals(salesToolsUnit.updateDate() + ""))){
               xruntime.createNode("update_date").setText(salesToolsUnit.updateDate() + "");
            }else{
               xruntime.createNode("update_date").setText("0");
            }
            //如果是外链销售工具
            if(salesToolsUnit.linkCd() == EGcLink.Link){
               xruntime.createNode("info_url").setText(salesToolsUnit.linkUrl());
            }
            if(salesToolsUnit.linkCd() == EGcLink.Content){
               xruntime.createNode("info_url").setText(_salesServiceHost + "mobile/logic/salestools/SalesTools.wa?do=getInfo&guid=" + salesToolsUnit.guid());
            }
            //如果不是
         }

      }
      return EResult.Success;
   }
}
