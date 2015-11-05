package org.mo.content.core.mobile.logic.truetimedata;

import com.cyou.gccloud.data.data.FDataLogicTruetimeLogic;
import com.cyou.gccloud.data.data.FDataLogicTruetimeUnit;
import com.cyou.gccloud.data.data.FDataPersonUserTruetimedataLogic;
import com.cyou.gccloud.data.data.FDataPersonUserTruetimedataUnit;
import com.cyou.gccloud.define.enums.common.EGcActive;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.com.data.FSql;
import org.mo.com.lang.FObject;
import org.mo.com.lang.RDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.service.city.info.TMobileService;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;

//============================================================
// <T>新闻服务接口。</T>
//============================================================
public class FTrueTimeDataConsole
      extends FObject
      implements
         ITrueTimeDataConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(TMobileService.class);

   //============================================================
   // <T>构造资源</T>
   //============================================================
   public FTrueTimeDataConsole(){

   }

   //============================================================
   // <T>根据guid获取实时数据相关信息。</T>
   // @param guid 
   // @param logicContext  逻辑上下文
   //============================================================
   @Override
   public FDataLogicTruetimeUnit getNewsByGuid(String guid,
                                               ILogicContext logicContext){
      _logger.debug(this, "getNewsByGuid", "getNewsByGuid begin. (guid={1})", guid);
      FDataLogicTruetimeLogic logic = logicContext.findLogic(FDataLogicTruetimeLogic.class);
      return logic.findByGuid(guid);
   }

   //============================================================
   // <T>分页获取实时数据相关信息。</T>
   // @param pageNum 页数
   // @param pageSize 每页的行数
   //============================================================
   @Override
   public FLogicDataset<FDataLogicTruetimeUnit> select(int pageNum,
                                                       int pageSize,
                                                       ILogicContext logicContext){
      if(pageNum <= 0){
         pageNum = 1;
      }
      FSql whereSql = new FSql();
      whereSql.append(FDataLogicTruetimeLogic.STATUS_CD);
      whereSql.append("=");
      whereSql.append(EGcResourceStatus.Publish);
      whereSql.append(" AND ");
      whereSql.append(FDataLogicTruetimeLogic.DISPLAY_CD);
      whereSql.append("=");
      whereSql.append(EGcDisplay.Enabled);
      String orderBy = String.format("%s %s %s %s", FDataLogicTruetimeLogic.DISPLAY_ORDER, "DESC,", FDataLogicTruetimeLogic.CREATE_DATE, "DESC");
      FDataLogicTruetimeLogic logic = logicContext.findLogic(FDataLogicTruetimeLogic.class);
      FLogicDataset<FDataLogicTruetimeUnit> moduleList = logic.fetch(whereSql.toString(), orderBy, pageSize, pageNum - 1);
      return moduleList;
   }

   // ============================================================
   // <T>标记实时数据已读</T>
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
      FDataPersonUserTruetimedataLogic personUserLogic = logicContext.findLogic(FDataPersonUserTruetimedataLogic.class);
      FDataLogicTruetimeLogic logic = logicContext.findLogic(FDataLogicTruetimeLogic.class);
      FDataLogicTruetimeUnit newsUnit = logic.findByGuid(guid);
      FSql whereSql = new FSql();
      whereSql.append(FDataPersonUserTruetimedataLogic.TRUETIME_ID);
      whereSql.append("=");
      whereSql.append(newsUnit.ouid());
      whereSql.append(" AND ");
      whereSql.append(FDataPersonUserTruetimedataLogic.USER_ID);
      whereSql.append("=");
      whereSql.append(userId);
      //线程并发 同一用连续户多次点击
      boolean flag = false;
      synchronized(sessionContext){
         FDataPersonUserTruetimedataUnit unit = personUserLogic.search(whereSql);
         if(unit == null){
            // 如果还没有阅读,标志阅读
            FDataPersonUserTruetimedataUnit tempUnit = personUserLogic.doPrepare();
            tempUnit.setUserId(userId);
            tempUnit.setTruetimeId(newsUnit.ouid());
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

}
