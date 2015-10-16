package org.mo.content.core.mobile.logic.news;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
//<T>新闻服务接口。</T>
//============================================================
public interface INewsConsole
{
   //============================================================
   // <T>根据guid获取新闻相关信息。</T>
   // @param guid 
   // @param logicContext  逻辑上下文
   //============================================================
   FDataLogicNewsUnit getNewsByGuid(String guid,
                                    ILogicContext logicContext);

   //============================================================
   // <T>分页获取新闻相关信息。</T>
   // @param pageNum 页数
   // @param pageSize 每页的行数
   // @param logicContext  逻辑上下文
   //============================================================
   FLogicDataset<FDataLogicNewsUnit> select(int pageNum,
                                            int pageSize,
                                            ILogicContext logicContext);
}
