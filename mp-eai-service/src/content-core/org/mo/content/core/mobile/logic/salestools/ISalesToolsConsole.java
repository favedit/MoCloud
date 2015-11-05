package org.mo.content.core.mobile.logic.salestools;

import com.cyou.gccloud.data.data.FDataLogicSalestoolsUnit;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;

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

   // ============================================================
   // <T>标记销售工具已读</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   int markRead(String guid,
                long userId,
                ILogicContext logicContext,
                IWebSession sessionContext);
}
