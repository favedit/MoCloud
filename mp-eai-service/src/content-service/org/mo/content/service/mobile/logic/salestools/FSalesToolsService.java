package org.mo.content.service.mobile.logic.salestools;

import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import com.cyou.gccloud.define.enums.core.EGcLink;
import java.util.Iterator;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.mobile.logic.salestools.ISalesToolsConsole;
import org.mo.core.aop.face.ALink;
import org.mo.core.aop.face.AProperty;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
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

   // 销售工具逻辑控制台
   @ALink
   protected ISalesToolsConsole _salesToolsConsole;

   // protected String _salesServiceHost = "http://eai.ezubo.com:8089/";
   // 配置文件注入属性
   @AProperty
   protected String _salesServiceHost;

   // Storage服务器
   @ALink
   protected IGcStorageConsole _storageConsole;

   // GcSession会话控制台
   @ALink
   protected IGcSessionConsole _sessionConsole;

   // ============================================================
   // <T>默认逻辑。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public EResult process(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      _logger.debug(this, "process", "process begin. ");
      return EResult.Success;
   }

   // ============================================================
   // <T>根据guid获取销售工具相关信息。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public EResult query(IWebContext context,
                        IWebInput input,
                        IWebOutput output,
                        ILogicContext logicContext){
      _logger.debug(this, "query", "query begin. ");

      // 获得guid参数
      String guid = input.config().findNode("guid").text();
      FDataLogicSalestoolsUnit newsUnit = _salesToolsConsole.getNewsByGuid(guid, logicContext);
      if(newsUnit != null){
         FXmlNode news_info = output.config().createNode("sales_info");
         String guidStr = newsUnit.guid();
         String newsLabel = newsUnit.label();
         String newsContent = newsUnit.content();
         String newsUpdate = newsUnit.updateDate() + "";
         if(guidStr != null && (!"".equals(guidStr))){
            news_info.createNode("guid").setText(guidStr);
         }else{
            news_info.createNode("guid").setText("0");
         }
         if(newsLabel != null && (!"".equals(newsLabel))){
            news_info.createNode("label").setText(newsLabel);
         }else{
            news_info.createNode("label").setText("0");
         }
         if(newsContent != null && (!"".equals(newsContent))){
            news_info.createNode("content").setText(newsContent);
         }else{
            news_info.createNode("content").setText("0");
         }
         if(newsUpdate != null && (!"".equals(newsUpdate))){
            news_info.createNode("update_date").setText(newsUpdate);
         }else{
            news_info.createNode("update_date").setText("0");
         }
         return EResult.Success;
      }
      return EResult.Failure;

   }

   // ============================================================
   // <T>分页获取销售工具相关信息。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public EResult select(IWebContext context,
                         IWebInput input,
                         IWebOutput output,
                         ILogicContext logicContext){
      _logger.debug(this, "select", "select begin. ");
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
      if(salesToolsUnits != null && salesToolsUnits.count() > 0){
         FXmlNode list = output.config().createNode("sales_list");
         for(Iterator<FDataLogicSalestoolsUnit> iterator = salesToolsUnits.iterator(); iterator.hasNext();){
            FDataLogicSalestoolsUnit salesToolsUnit = iterator.next();
            FXmlNode xruntime = list.createNode("sales_info");
            // xruntime.createNode("ouid").setText(newsUnit.ouid());
            if(salesToolsUnit.guid() != null && (!"".equals(salesToolsUnit.guid()))){
               xruntime.createNode("guid").setText(salesToolsUnit.guid());
               if(salesToolsUnit.linkCd() == EGcLink.Content){
                  xruntime.createNode("info_url").setText(_salesServiceHost + "mobile/logic/salestools/SalesTools.wa?do=getContent&guid=" + salesToolsUnit.guid());
               }
            }else{
               xruntime.createNode("guid").setText("0");
            }
            // 如果是外链销售工具
            if(salesToolsUnit.linkCd() == EGcLink.Link){
               if(salesToolsUnit.linkUrl() != null && (!"".equals(salesToolsUnit.linkUrl()))){
                  xruntime.createNode("info_url").setText(salesToolsUnit.linkUrl());
               }else{
                  xruntime.createNode("info_url").setText("0");
               }
            }

            if(salesToolsUnit.label() != null && (!"".equals(salesToolsUnit.label()))){
               xruntime.createNode("label").setText(salesToolsUnit.label());
            }else{
               xruntime.createNode("label").setText("0");
            }
            if(salesToolsUnit.description() != null && (!"".equals(salesToolsUnit.description()))){
               xruntime.createNode("info_description").setText(salesToolsUnit.description());
            }else{
               xruntime.createNode("info_description").setText("0");
            }
            if(salesToolsUnit.iconUrl() != null && (!"".equals(salesToolsUnit.iconUrl()))){
               String makeUrl = _storageConsole.makeUrl(salesToolsUnit.iconUrl());
               xruntime.createNode("icon_url").setText(makeUrl);
            }else{
               xruntime.createNode("icon_url").setText("0");
            }

            String updateDate = salesToolsUnit.recordDate().format("yyyy/mm/dd");
            if(updateDate != null && (!"".equals(updateDate))){
               xruntime.createNode("publish_date").setText(updateDate);
            }else{
               xruntime.createNode("publish_date").setText("0");
            }
            int viewCount = salesToolsUnit.viewCount();
            xruntime.createNode("read_count").setText(viewCount + "");
            // 如果不是
         }

      }
      return EResult.Success;
   }

   // ============================================================
   // <T>标记销售工具已读</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public EResult markRead(IWebContext context,
                           IWebInput input,
                           IWebOutput output,
                           ILogicContext logicContext,
                           IWebSession sessionContext){
      String sessionCode = context.head("mo-session-id");
      String guid = context.parameter("salestools_id");
      if(RString.isNotEmpty(sessionCode)){
         FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(logicContext, sessionCode);
         long userId = sessionInfo.userId();
         int isSuccess = _salesToolsConsole.markRead(guid, userId, logicContext, sessionContext);
         if(isSuccess == -1){
            return EResult.Failure;
         }else{
            output.config().createNode("read_count").setText(isSuccess + "");
         }
      }
      return EResult.Success;
   }
}
