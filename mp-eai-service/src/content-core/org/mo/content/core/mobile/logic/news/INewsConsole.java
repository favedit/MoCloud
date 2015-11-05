package org.mo.content.core.mobile.logic.news;

import com.cyou.gccloud.data.data.FDataLogicNewsUnit;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;

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

   // ============================================================
   // <T>标记新闻已读</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   int markRead(String noticeGuid,
                long userId,
                ILogicContext logicContext,
                IWebSession sessionContext);

   // ============================================================
   // <T>标记新闻是否已读</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   boolean isRead(String noticeGuid,
                  long userId,
                  ILogicContext logicContext);

   // ============================================================
   // <T>通过guid获取记录</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // ============================================================
   FDataLogicNewsUnit find(String noticeGuid,
                           ILogicContext logicContext);

}
