package org.mo.content.service.resource;

import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.face.AWebLogin;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源3D服务接口。</T>
//============================================================
@AWebLogin
public interface IResourceService
{
   //============================================================
   // <T>获取数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult list(IWebContext context,
                ILogicContext logicContext,
                FGcSessionInfo session,
                IWebInput input,
                IWebOutput output);

   //============================================================
   // <T>获取共享数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult listShare(IWebContext context,
                     ILogicContext logicContext,
                     FGcSessionInfo session,
                     IWebInput input,
                     IWebOutput output);

   //============================================================
   // <T>分享数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult share(IWebContext context,
                 ILogicContext logicContext,
                 FGcSessionInfo session,
                 IWebInput input,
                 IWebOutput output);

   //============================================================
   // <T>删除数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult delete(IWebContext context,
                  ILogicContext logicContext,
                  FGcSessionInfo session,
                  IWebInput input,
                  IWebOutput output);
}
