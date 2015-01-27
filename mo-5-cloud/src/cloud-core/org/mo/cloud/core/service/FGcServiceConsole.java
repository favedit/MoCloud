package org.mo.cloud.core.service;

import org.mo.cloud.core.message.IGcMessageConsole;

import com.cyou.gccloud.logic.system.FGcSessionInfo;
import com.cyou.gccloud.logic.system.IGcSessionConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.RString;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.FDataOperator;
import org.mo.web.core.service.FServiceConsole;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>服务命令处理控制台。</T>
// <P>根据访问的地址，对页面服务执行分发处理。</P>
//============================================================
public class FGcServiceConsole
      extends FServiceConsole
{
   // 头标志
   public final static String HeadSession = "cloud_session";

   // 消息控制台
   @ALink
   protected IGcMessageConsole _gcMessageConsole;

   // 会话控制台
   @ALink
   protected IGcSessionConsole _gcSessionConsole;

   //============================================================
   // <T>构造服务命令处理控制台。</T>
   //============================================================
   public FGcServiceConsole(){
   }

   //============================================================
   // <T>检查会话是否有效。</T>  
   //
   // @param context 页面环境
   // @param logicContext 逻辑环境
   // @param input 输入信息
   // @param output 输出信息
   // @return 处理结果
   //============================================================
   @Override
   public EResult checkSession(IWebContext context,
                               ILogicContext logicContext,
                               IWebInput input,
                               IWebOutput output){
      // 获得会话代码
      String sessionCode = context.head(HeadSession);
      if(RString.isEmpty(sessionCode)){
         sessionCode = input.config().nodeText("SessionCode");
      }
      // 验证会话存在
      FGcSessionInfo sessionInfo = _gcSessionConsole.findByCode(logicContext, sessionCode);
      // 检查会话信息
      if(sessionInfo == null){
         _gcMessageConsole.pushError(context, "E00103", sessionCode);
         return EResult.Failure;
      }else if(!sessionInfo.ovld()){
         _gcMessageConsole.pushError(context, "E00104", sessionCode);
         return EResult.Failure;
      }
      // 绑定数据
      _bindConsole.bind(FGcSessionInfo.class, sessionInfo);
      return EResult.Success;
   }

   //============================================================
   // <T>检查会话是否登录。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入信息
   // @param output 输出信息
   // @return 处理结果
   //============================================================
   @Override
   public EResult checkLogin(IWebContext context,
                             ILogicContext logicContext,
                             IWebInput input,
                             IWebOutput output){
      // 获得会话代码
      String sessionCode = context.head(HeadSession);
      if(RString.isEmpty(sessionCode)){
         sessionCode = input.config().nodeText("SessionCode");
      }
      // 验证会话存在
      FGcSessionInfo sessionInfo = _gcSessionConsole.findByCode(logicContext, sessionCode);
      // 检查会话信息
      if(sessionInfo == null){
         // 会话不存在
         _gcMessageConsole.pushError(context, "E00103", sessionCode);
         return EResult.Failure;
      }else if(!sessionInfo.ovld()){
         // 会话已经失效
         _gcMessageConsole.pushError(context, "E00104", sessionCode);
         return EResult.Failure;
      }else if(sessionInfo.userId() == 0){
         // 会话用户未登录
         _gcMessageConsole.pushError(context, "E00105", sessionCode);
         return EResult.Failure;
      }
      // 绑定会话数据
      _bindConsole.bind(FGcSessionInfo.class, sessionInfo);
      // 绑定数据操作者
      FDataOperator operator = new FDataOperator();
      operator.setUserId(sessionInfo.userId());
      _bindConsole.bind(FDataOperator.class, operator);
      return EResult.Success;
   }

   //============================================================
   // <T>执行后处理。</T>
   //
   // @return 处理结果
   //============================================================
   @Override
   public EResult executeBefore(){
      return EResult.Success;
   }

   //============================================================
   // <T>执行后处理。</T>
   //
   // @return 处理结果
   //============================================================
   @Override
   public EResult executeAfter(Object result){
      return EResult.Success;
   }
}
