package org.mo.content.service.resource.material;

import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.face.AWebLogin;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>资源3D网格服务接口。</T>
//============================================================
@AWebLogin
public interface IMaterialService
{
   //============================================================
   // <T>获取材质列表。</T>
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
   // <T>获取材质位图列表。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult listBitmap(IWebContext context,
                      ILogicContext logicContext,
                      FGcSessionInfo session,
                      IWebInput input,
                      IWebOutput output);

   //============================================================
   // <T>查询数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult query(IWebContext context,
                 ILogicContext logicContext,
                 FGcSessionInfo session,
                 IWebInput input,
                 IWebOutput output);

   //============================================================
   // <T>新建数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult create(IWebContext context,
                  ILogicContext logicContext,
                  FGcSessionInfo session,
                  IWebInput input,
                  IWebOutput output);

   //============================================================
   // <T>修改数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult upate(IWebContext context,
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

   //============================================================
   // <T>删除位图数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   EResult deleteBitmap(IWebContext context,
                        ILogicContext logicContext,
                        FGcSessionInfo session,
                        IWebInput input,
                        IWebOutput output);
}
