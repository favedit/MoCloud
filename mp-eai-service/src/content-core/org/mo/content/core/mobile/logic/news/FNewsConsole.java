package org.mo.content.core.mobile.logic.news;

import com.cyou.gccloud.data.data.FDataLogicNewsLogic;
import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import com.cyou.gccloud.data.data.FDataPersonUserNewsLogic;
import com.cyou.gccloud.data.data.FDataPersonUserNewsUnit;
import com.cyou.gccloud.define.enums.common.EGcActive;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.com.data.FSql;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.service.city.info.FMobileService;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;

//============================================================
// <T>新闻服务接口。</T>
//============================================================
public class FNewsConsole
      extends FObject
      implements
         INewsConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMobileService.class);

   //============================================================
   // <T>构造资源</T>
   //============================================================
   public FNewsConsole(){

   }

   //============================================================
   // <T>根据guid获取新闻相关信息。</T>
   // @param guid 
   // @param logicContext  逻辑上下文
   //============================================================
   @Override
   public FDataLogicNewsUnit getNewsByGuid(String guid,
                                           ILogicContext logicContext){
      _logger.debug(this, "getNewsByGuid", "getNewsByGuid start guid={1}", guid);
      FDataLogicNewsLogic logic = logicContext.findLogic(FDataLogicNewsLogic.class);
      return logic.findByGuid(guid);
   }

   //============================================================
   // <T>分页获取新闻相关信息。</T>
   // @param pageNum 页数
   // @param pageSize 每页的行数
   // @param logicContext  逻辑上下文
   //============================================================
   @Override
   public FLogicDataset<FDataLogicNewsUnit> select(int pageNum,
                                                   int pageSize,
                                                   ILogicContext logicContext){
      if(pageNum <= 0){
         pageNum = 1;
      }
      FSql whereSql = new FSql();
      whereSql.append(FDataLogicNewsLogic.STATUS_CD);
      whereSql.append("=");
      whereSql.append(EGcResourceStatus.Publish);
      whereSql.append(" AND ");
      whereSql.append(FDataLogicNewsLogic.DISPLAY_CD);
      whereSql.append("=");
      whereSql.append(EGcDisplay.Enabled);
      String orderBy = String.format("%s %s %s %s", FDataLogicNewsLogic.DISPLAY_ORDER, "DESC,", FDataLogicNewsLogic.RECORD_DATE, "DESC");
      FDataLogicNewsLogic logic = logicContext.findLogic(FDataLogicNewsLogic.class);
      FLogicDataset<FDataLogicNewsUnit> moduleList = logic.fetch(whereSql.toString(), orderBy, pageSize, pageNum - 1);
      return moduleList;
   }

   // ============================================================
   // <T>标记新闻已读</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public int markRead(String guid,
                       long userId,
                       ILogicContext logicContext,
                       IWebSession sessionContext){
      FDataPersonUserNewsLogic personUserLogic = logicContext.findLogic(FDataPersonUserNewsLogic.class);
      FDataLogicNewsLogic logic = logicContext.findLogic(FDataLogicNewsLogic.class);
      FDataLogicNewsUnit newsUnit = logic.findByGuid(guid);
      FSql whereSql = new FSql();
      whereSql.append(FDataPersonUserNewsLogic.NEWS_ID);
      whereSql.append("=");
      whereSql.append(newsUnit.ouid());
      whereSql.append(" AND ");
      whereSql.append(FDataPersonUserNewsLogic.USER_ID);
      whereSql.append("=");
      whereSql.append(userId);
      //线程并发 同一用连续户多次点击
      boolean flag = false;
      synchronized(sessionContext){
         FDataPersonUserNewsUnit unit = personUserLogic.search(whereSql);
         if(unit == null){
            // 如果还没有阅读,标志阅读
            FDataPersonUserNewsUnit tempUnit = personUserLogic.doPrepare();
            tempUnit.setUserId(userId);
            tempUnit.setNewsId(newsUnit.ouid());
            tempUnit.setActiveCd(EGcActive.Active);
            tempUnit.setActiveDate(RDateTime.currentDateTime());
            personUserLogic.doInsert(tempUnit);
            flag = true;
         }
      }
      if(flag){
         // 同时更新通知的view_count字段,,累加阅读次数
         int count = newsUnit.viewCount() + 1;
         newsUnit.setViewCount(count);
         logic.doUpdate(newsUnit);
         return count;
      }
      return -1;
   }

   // ============================================================
   // <T>标记新闻是否已读</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public boolean isRead(String guid,
                         long userId,
                         ILogicContext logicContext){
      FDataPersonUserNewsLogic personUserLogic = logicContext.findLogic(FDataPersonUserNewsLogic.class);
      FDataLogicNewsLogic logic = logicContext.findLogic(FDataLogicNewsLogic.class);
      FDataLogicNewsUnit newsUnit = logic.findByGuid(guid);
      FSql whereSql = new FSql();
      whereSql.append(FDataPersonUserNewsLogic.NEWS_ID);
      whereSql.append("=");
      whereSql.append(newsUnit.ouid());
      whereSql.append(" AND ");
      whereSql.append(FDataPersonUserNewsLogic.USER_ID);
      whereSql.append("=");
      whereSql.append(userId);
      FDataPersonUserNewsUnit unit = personUserLogic.search(whereSql);
      if(unit == null){
         return false;
      }
      return true;
   }

   // ============================================================
   // <T>通过guid获取记录</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   @Override
   public FDataLogicNewsUnit find(String noticeGuid,
                                  ILogicContext logicContext){
      return logicContext.findLogic(FDataLogicNewsLogic.class).findByGuid(noticeGuid);

   }
}
