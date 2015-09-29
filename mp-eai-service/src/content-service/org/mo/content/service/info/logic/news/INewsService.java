package org.mo.content.service.info.logic.news;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>新闻信息管理接口。</T>
//============================================================
public interface INewsService
{
   //============================================================
   // <T>默认逻辑。</T>
   //
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult process(IWebContext context,
                   IWebInput input,
                   IWebOutput output);

   //============================================================
   // <T>根据guid获取新闻相关信息。</T>
   //
   // @param guid 
   //============================================================
   EResult getNewsByGuid(IWebContext context,
                         IWebInput input,
                         IWebOutput output,
                         ILogicContext logicContext);

   //============================================================
   // <T>分页获取新闻相关信息。</T>
   //
   // @param pageNum 页数
   // @param pageSize 每页的行数
   EResult select(IWebContext context,
                  IWebInput input,
                  IWebOutput output,
                  ILogicContext logicContext);
}
