package org.mo.content.core.mobile.logic.news;

import org.mo.content.service.city.info.TMobileService;

import com.cyou.gccloud.data.data.FDataLogicNewsLogic;
import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
import org.mo.com.data.FSql;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>新闻服务接口。</T>
//============================================================
public class FNewsConsole
      extends FObject
      implements
         INewsConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(TMobileService.class);

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
      String orderBy = String.format("%s %s %s %s", FDataLogicNewsLogic.DISPLAY_ORDER, "DESC,", FDataLogicNewsLogic.CREATE_DATE, "DESC");
      FDataLogicNewsLogic logic = logicContext.findLogic(FDataLogicNewsLogic.class);
      FLogicDataset<FDataLogicNewsUnit> moduleList = logic.fetch(whereSql.toString(), orderBy, pageSize, pageNum - 1);
      return moduleList;
   }
}
