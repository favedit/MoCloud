package org.mo.content.core.mobile.logic.salestools;

import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<T>新闻服务接口。</T>
//============================================================
public interface ISalesToolsConsole
{
   //============================================================
   // <T>根据guid获取新闻相关信息。</T>
   //
   // @param guid 
   //============================================================
   FDataLogicSalestoolsUnit getNewsByGuid(String guid,
                                          ILogicContext logicContext);

   //============================================================
   // <T>分页获取新闻相关信息。</T>
   // @param pageNum 页数
   // @param pageSize 每页的行数
   //============================================================
   FLogicDataset<FDataLogicSalestoolsUnit> select(int pageNum,
                                                  int pageSize,
                                                  ILogicContext logicContext);
}
