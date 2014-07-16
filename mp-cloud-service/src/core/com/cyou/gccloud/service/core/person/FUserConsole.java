package com.cyou.gccloud.service.core.person;

import com.cyou.gccloud.service.data.data.FDataPersonUserLogic;
import org.mo.com.lang.EResult;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.eng.data.common.ISqlContext;

//============================================================
// <T>用户控制台。</T>
//============================================================
public class FUserConsole
      implements
         IUserConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FUserConsole.class);

   //============================================================
   // <T>构造用户控制台。</T>
   //============================================================
   public FUserConsole(){
   }

   //============================================================
   // <T>用户注册处理。</T>
   //
   // @param sqlContext 数据环境
   // @param info 用户信息输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult register(ISqlContext sqlContext,
                           FUserInfo info){
      // 新建记录
      FDataPersonUserLogic userLogic = new FDataPersonUserLogic(sqlContext);
      userLogic.doInsert(info);
      _logger.debug(this, "register", "Register user success.");
      return EResult.Success;
   }

   //============================================================
   // <T>用户登录处理。</T>
   //
   // @param sqlContext 数据环境
   // @param info 用户信息输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult login(ISqlContext sqlContext,
                        FUserInfo info){
      return EResult.Success;
   }

   //============================================================
   // <T>用户登出处理。</T>
   //
   // @param sqlContext 数据环境
   // @param info 用户信息输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult logout(ISqlContext sqlContext,
                         FUserInfo info){
      return EResult.Success;
   }
}
