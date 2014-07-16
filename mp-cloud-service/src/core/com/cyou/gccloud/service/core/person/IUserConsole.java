package com.cyou.gccloud.service.core.person;

import org.mo.com.lang.EResult;
import org.mo.eng.data.common.ISqlContext;

//============================================================
// <T>游戏实例控制台接口。</T>
//============================================================
public interface IUserConsole
{
   //============================================================
   // <T>用户注册处理。</T>
   //
   // @param sqlContext 数据环境
   // @param info 用户信息输出配置
   // @return 处理结果
   //============================================================
   EResult register(ISqlContext sqlContext,
                    FUserInfo info);

   //============================================================
   // <T>用户登录处理。</T>
   //
   // @param sqlContext 数据环境
   // @param info 用户信息输出配置
   // @return 处理结果
   //============================================================
   EResult login(ISqlContext sqlContext,
                 FUserInfo info);

   //============================================================
   // <T>用户登出处理。</T>
   //
   // @param sqlContext 数据环境
   // @param info 用户信息输出配置
   // @return 处理结果
   //============================================================
   EResult logout(ISqlContext sqlContext,
                  FUserInfo info);
}
