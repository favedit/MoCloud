package org.mo.content.service.mobile.logic.news;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import com.cyou.gccloud.define.enums.core.EGcLink;
import java.util.Iterator;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.mobile.logic.news.INewsConsole;
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
public class FNewsService
      extends FObject
      implements
         INewsService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FNewsService.class);

   // 新闻逻辑控制台
   @ALink
   protected INewsConsole _newsConsole;

   // GcSession会话控制台
   @ALink
   protected IGcSessionConsole _sessionConsole;

   // protected String _newsServiceHost = "http://eai.ezubo.com:8089/";
   // 配置文件注入属性
   @AProperty
   protected String _newsServiceHost;

   // Storage服务器
   @ALink
   protected IGcStorageConsole _storageConsole;

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
   // <T>根据guid获取新闻相关信息。</T>
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
      FDataLogicNewsUnit newsUnit = _newsConsole.getNewsByGuid(guid, logicContext);
      if(newsUnit != null){
         FXmlNode news_info = output.config().createNode("news_info");
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
   // <T>分页获取新闻相关信息。</T>
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
      String sessionCode = context.head("mo-session-id");
      String pageSizeStr = input.config().findNode("pagesize").text();
      String pageNumStr = input.config().findNode("pagenumber").text();
      long userId = -1;
      if(RString.isNotEmpty(sessionCode)){
         FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(logicContext, sessionCode);
         if(sessionInfo != null){
            userId = sessionInfo.userId();
         }
      }
      if(pageSizeStr != null && (!"".equals(pageSizeStr))){
         pageSize = Integer.parseInt(pageSizeStr);
      }
      if(pageNumStr != null && (!"".equals(pageNumStr))){
         pageNum = Integer.parseInt(pageNumStr);
      }
      FLogicDataset<FDataLogicNewsUnit> newsUnits = _newsConsole.select(pageNum, pageSize, logicContext);
      output.config().createNode("page_number").setText(pageNumStr);
      if(newsUnits != null && newsUnits.count() > 0){
         FXmlNode list = output.config().createNode("news_list");
         for(Iterator<FDataLogicNewsUnit> iterator = newsUnits.iterator(); iterator.hasNext();){
            FDataLogicNewsUnit newsUnit = iterator.next();
            FXmlNode xruntime = list.createNode("news_info");
            // xruntime.createNode("ouid").setText(newsUnit.ouid());
            String guidStr = newsUnit.guid();
            if(guidStr != null && (!"".equals(guidStr))){
               xruntime.createNode("guid").setText(guidStr);
               if(newsUnit.linkCd() == EGcLink.Content){
                  xruntime.createNode("info_url").setText(_newsServiceHost + "mobile/logic/news/News.wa?do=getNewInfo&guid=" + newsUnit.guid());
               }
            }else{
               xruntime.createNode("guid").setText("0");
            }

            // 如果是外链新闻
            if(newsUnit.linkCd() == EGcLink.Link){
               String newsLinkUrl = newsUnit.linkUrl();
               if(newsLinkUrl != null && (!"".equals(newsLinkUrl))){
                  xruntime.createNode("info_url").setText(newsUnit.linkUrl());
               }else{
                  xruntime.createNode("info_url").setText("0");
               }
            }
            String newsLabel = newsUnit.label();
            if(newsLabel != null && (!"".equals(newsLabel))){
               xruntime.createNode("label").setText(newsLabel);
            }else{
               xruntime.createNode("label").setText("0");
            }
            String newsDescription = newsUnit.description();
            if(newsDescription != null && (!"".equals(newsDescription))){
               xruntime.createNode("info_description").setText(newsDescription);
            }else{
               xruntime.createNode("info_description").setText("0");
            }
            if(newsUnit.iconUrl() != null && (!"".equals(newsUnit.iconUrl()))){
               String makeUrl = _storageConsole.makeUrl(newsUnit.iconUrl());
               xruntime.createNode("icon_url").setText(makeUrl);
            }else{
               xruntime.createNode("icon_url").setText("0");
            }
            String updateDate = newsUnit.updateDate() + "";
            if(updateDate != null && (!"".equals(updateDate))){
               xruntime.createNode("update_date").setText(updateDate);
            }else{
               xruntime.createNode("update_date").setText("0");
            }
            //返回新闻已读人数
            xruntime.createNode("read_count").setText(newsUnit.viewCount() + "");
            //返回新闻的发布日期
            TDateTime recordDate = newsUnit.recordDate();
            if(!recordDate.isEmpty()){
               xruntime.createNode("publish_date").setText(newsUnit.recordDate().format("yyyy/mm/dd"));
            }
            //此新闻是否被用户已读
            boolean isRead = _newsConsole.isRead(newsUnit.guid(), userId, logicContext);
            xruntime.createNode("read").setText(isRead + "");

         }

      }
      return EResult.Success;
   }

   // ============================================================
   // <T>标记新闻已读</T>
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
      String newsGuid = context.parameter("news_id");
      if(RString.isNotEmpty(sessionCode)){
         FGcSessionInfo sessionInfo = _sessionConsole.findBySessionCode(logicContext, sessionCode);
         long userId = sessionInfo.userId();
         int isSuccess = _newsConsole.markRead(newsGuid, userId, logicContext, sessionContext);
         if(isSuccess == -1){
            return EResult.Failure;
         }else{
            output.config().createNode("read_count").setText(isSuccess + "");
         }
      }
      return EResult.Success;
   }
}
