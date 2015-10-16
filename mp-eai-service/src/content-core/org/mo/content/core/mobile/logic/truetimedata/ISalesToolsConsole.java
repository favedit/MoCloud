package org.mo.content.core.mobile.logic.truetimedata;

import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<T>新闻服务接口。</T>
//============================================================
public interface ISalesToolsConsole
{
   //============================================================
   // <T>根据guid获取销售工具相关信息。</T>
   // @param guid 
   // @param logicContext  逻辑上下文
   //============================================================
   FDataLogicSalestoolsUnit getNewsByGuid(String guid,
                                          ILogicContext logicContext);

   //============================================================
   // <T>分页获取销售工具相关信息。</T>
   // @param pageNum 页数
   // @param pageSize 每页的行数
   //============================================================
   FLogicDataset<FDataLogicSalestoolsUnit> select(int pageNum,
                                                  int pageSize,
                                                  ILogicContext logicContext);
}
