package org.mo.cloud.design.data.frame;

import org.mo.com.lang.EResult;
import org.mo.eng.data.common.ISqlContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>数据表单服务接口。</T>
//============================================================
public interface IFrameService
{
   //============================================================
   // <T>获取数据集合。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult fetch(IWebContext context,
                 ISqlContext sqlContext,
                 IWebInput input,
                 IWebOutput output);

   //============================================================
   // <T>数据准备处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult prepare(IWebContext context,
                   IWebInput input,
                   IWebOutput output);

   //============================================================
   // <T>数据新建处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult insert(IWebContext context,
                  IWebInput input,
                  IWebOutput output);

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult update(IWebContext context,
                  IWebInput input,
                  IWebOutput output);

   //============================================================
   // <T>删除配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult delete(IWebContext context,
                  IWebInput input,
                  IWebOutput output);
}
