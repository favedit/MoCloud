package com.cyou.gccloud.service.system.session;

import org.mo.eng.data.common.ISqlContext;

//============================================================
// <T>系统会话接口。</T>
//============================================================
public interface ISessionConsole
{
   //============================================================
   // <T>打开一个会话。</T>
   //
   // @param sqlContext 数据环境
   // @param userId 用户编号
   // @return 会话信息
   //============================================================
   FSessionInfo open(ISqlContext sqlContext,
                     long userId);

   //============================================================
   // <T>查找一个会话。</T>
   //
   // @param sqlContext 数据环境
   // @param code 代码
   // @return 会话信息
   //============================================================
   FSessionInfo find(ISqlContext sqlContext,
                     String code);

   //============================================================
   // <T>关闭一个会话。</T>
   //
   // @param session 会话信息
   //============================================================
   void close(FSessionInfo session);
}
