package org.mo.content.face.resource3d.mesh;

import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>目录描述服务接口。</T>
//============================================================
public interface IMeshService
{
   //============================================================
   // <T>获得模型列表。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑网络环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult list(IWebContext context,
                ILogicContext logicContext,
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
}
