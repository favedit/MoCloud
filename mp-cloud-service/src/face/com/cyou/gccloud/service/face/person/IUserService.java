package com.cyou.gccloud.service.face.person;

import org.mo.eng.data.common.ISqlContext;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>用户服务接口。</T>
//============================================================
public interface IUserService
{
   //============================================================
   // <T>注册用户处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   //============================================================
   void register(IWebContext context,
                 ISqlContext sqlContext,
                 IWebInput input,
                 IWebOutput output);

   //============================================================
   // <T>用户登录处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   //============================================================
   void login(IWebContext context,
              ISqlContext sqlContext,
              IWebInput input,
              IWebOutput output);

   //============================================================
   // <T>用户查询处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   //============================================================
   void query(IWebContext context,
              ISqlContext sqlContext,
              IWebInput input,
              IWebOutput output);

   //============================================================
   // <T>用户登出处理。</T>
   //
   // @param context 页面环境
   // @param sqlContext 数据环境
   // @param input 输入配置
   // @param output 输出配置
   //============================================================
   void logout(IWebContext context,
               ISqlContext sqlContext,
               IWebInput input,
               IWebOutput output);
}
