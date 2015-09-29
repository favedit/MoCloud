package org.mo.content.core.logic.news;

import com.cyou.gccloud.data.data.FDataLogicNewsLogic;
import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import org.mo.com.data.FSql;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.service.info.mobile.FMobileService;
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
   private static ILogger _logger = RLogger.find(FMobileService.class);

   //============================================================
   // <T>构造资源</T>
   //============================================================
   public FNewsConsole(){

   }

   //============================================================
   // <T>根据guid获取新闻相关信息。</T>
   //
   // @param guid 
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
   //
   // @param pageNum 页数
   // @param pageSize 每页的行数
   @Override
   public FLogicDataset<FDataLogicNewsUnit> select(int pageNum,
                                                   int pageSize,
                                                   ILogicContext logicContext){
      if(pageNum < 0){
         pageNum = 0;
      }
      String orderBy = String.format("%s %s", FDataLogicNewsLogic.LABEL, "DESC");
      FDataLogicNewsLogic logic = logicContext.findLogic(FDataLogicNewsLogic.class);
      FSql sql = new FSql();
      FLogicDataset<FDataLogicNewsUnit> moduleList = logic.fetch(sql.toString(), orderBy, pageSize, pageNum);
      return moduleList;
   }

}
