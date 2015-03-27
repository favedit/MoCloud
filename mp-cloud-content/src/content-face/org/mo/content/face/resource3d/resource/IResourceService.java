package org.mo.content.face.resource3d.resource;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源3D模板服务接口。</T>
//============================================================
public interface IResourceService
{
   //============================================================
   // <T>获取数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult fetch(IWebContext context,
                 ILogicContext logicContext,
                 IWebInput input,
                 IWebOutput output);

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult query(IWebContext context,
                 ILogicContext logicContext,
                 IWebInput input,
                 IWebOutput output);

   //============================================================
   // <T>更新配置处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult update(IWebContext context,
                  ILogicContext logicContext,
                  IWebInput input,
                  IWebOutput output);

   //============================================================
   // <T>更新主题配置处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult updateTheme(IWebContext context,
                       ILogicContext logicContext,
                       IWebInput input,
                       IWebOutput output);
}
