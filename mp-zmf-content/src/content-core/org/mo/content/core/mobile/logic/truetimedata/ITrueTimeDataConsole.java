package org.mo.content.core.mobile.logic.truetimedata;

import com.cyou.gccloud.data.data.FDataLogicTruetimeUnit;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<T>新闻服务接口。</T>
//============================================================
public interface ITrueTimeDataConsole
{
   //============================================================
   // <T>根据guid获取销售工具相关信息。</T>
   // @param guid 
   // @param logicContext  逻辑上下文
   //============================================================
   FDataLogicTruetimeUnit getNewsByGuid(String guid,
                                        ILogicContext logicContext);

   //============================================================
   // <T>分页获取销售工具相关信息。</T>
   // @param pageNum 页数
   // @param pageSize 每页的行数
   //============================================================
   FLogicDataset<FDataLogicTruetimeUnit> select(int pageNum,
                                                int pageSize,
                                                ILogicContext logicContext);
}
