package org.mo.content.service.mobile.logic.truetimedata;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>实时数据管理接口。</T>
//============================================================
public interface ITrueTimeDataService
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
   // <T>根据guid获取实时数据相关信息。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult query(IWebContext context,
                 IWebInput input,
                 IWebOutput output,
                 ILogicContext logicContext);

   //============================================================
   // <T>分页获取实时数据相关信息。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   EResult select(IWebContext context,
                  IWebInput input,
                  IWebOutput output,
                  ILogicContext logicContext);
}
