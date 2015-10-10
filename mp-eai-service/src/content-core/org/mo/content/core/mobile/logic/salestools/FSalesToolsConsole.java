package org.mo.content.core.mobile.logic.salestools;

import com.cyou.gccloud.data.data.FDataLogicSalestoolsLogic;
import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import com.cyou.gccloud.define.enums.common.EGcDisplay;
import com.cyou.gccloud.define.enums.core.EGcResourceStatus;
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
public class FSalesToolsConsole
      extends FObject
      implements
         ISalesToolsConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMobileService.class);

   //============================================================
   // <T>构造资源</T>
   //============================================================
   public FSalesToolsConsole(){

   }

   //============================================================
   // <T>根据guid获取新闻相关信息。</T>
   //
   // @param guid 
   //============================================================
   @Override
   public FDataLogicSalestoolsUnit getNewsByGuid(String guid,
                                                 ILogicContext logicContext){
      _logger.debug(this, "getNewsByGuid", "getNewsByGuid start guid={1}", guid);
      FDataLogicSalestoolsLogic logic = logicContext.findLogic(FDataLogicSalestoolsLogic.class);
      return logic.findByGuid(guid);
   }

   //============================================================
   // <T>分页获取新闻相关信息。</T>
   //
   // @param pageNum 页数
   // @param pageSize 每页的行数
   @Override
   public FLogicDataset<FDataLogicSalestoolsUnit> select(int pageNum,
                                                         int pageSize,
                                                         ILogicContext logicContext){
      if(pageNum <= 0){
         pageNum = 1;
      }
      FSql whereSql = new FSql();
      whereSql.append(FDataLogicSalestoolsLogic.STATUS_CD);
      whereSql.append("=");
      whereSql.append(EGcResourceStatus.Publish);
      whereSql.append(" AND ");
      whereSql.append(FDataLogicSalestoolsLogic.DISPLAY_CD);
      whereSql.append("=");
      whereSql.append(EGcDisplay.Enabled);
      String orderBy = String.format("%s %s", FDataLogicSalestoolsLogic.LABEL, "DESC");
      FDataLogicSalestoolsLogic logic = logicContext.findLogic(FDataLogicSalestoolsLogic.class);
      FLogicDataset<FDataLogicSalestoolsUnit> moduleList = logic.fetch(whereSql.toString(), orderBy, pageSize, pageNum - 1);
      return moduleList;
   }

}
