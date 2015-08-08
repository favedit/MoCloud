package org.mo.cloud.editor.design.frame;

import org.mo.com.lang.EResult;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>内容表单服务接口。</T>
//============================================================
public interface IFrameService
{
   //============================================================
   // <T>从配置文件中获得目录节点。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult catalog(IWebContext context,
                   IWebInput input,
                   IWebOutput output);

   //============================================================
   // <T>从配置文件中加载树目录节点。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult list(IWebContext context,
                IWebInput input,
                IWebOutput output);

   //============================================================
   // <T>查询配置处理。</T>
   //
   // @param context 网络环境
   // @param input 网络输入
   // @param output 网络输出
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
