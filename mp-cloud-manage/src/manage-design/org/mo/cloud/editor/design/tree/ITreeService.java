package org.mo.cloud.editor.design.tree;

import org.mo.com.lang.EResult;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>设计目录服务接口。</T>
//============================================================
public interface ITreeService
{
   //============================================================
   // <T>获得目录处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   // @return 处理结果
   //============================================================
   EResult catalog(IWebContext context,
                   IWebInput input,
                   IWebOutput output);

   //============================================================
   // <T>获得目录节点处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   // @return 处理结果
   //============================================================
   EResult list(IWebContext context,
                IWebInput input,
                IWebOutput output);

   //============================================================
   // <T>获取配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   // @return 处理结果
   //============================================================
   EResult fetch(IWebContext context,
                 IWebInput input,
                 IWebOutput output);

   //============================================================
   // <T>查询配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   // @return 处理结果
   //============================================================
   EResult query(IWebContext context,
                 IWebInput input,
                 IWebOutput output);

   //============================================================
   // <T>新建配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   // @return 处理结果
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
   // @return 处理结果
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
   // @return 处理结果
   //============================================================
   EResult delete(IWebContext context,
                  IWebInput input,
                  IWebOutput output);
}
