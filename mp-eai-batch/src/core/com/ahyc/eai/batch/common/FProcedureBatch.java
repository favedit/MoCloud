package com.ahyc.eai.batch.common;

import org.mo.com.lang.EResult;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.core.aop.face.AProperty;
import org.mo.eng.data.common.ISqlContext;

//============================================================
// <T>用户控制台。</T>
//============================================================
public class FProcedureBatch
{
   // 日志输出接口
   @SuppressWarnings("unused")
   private static ILogger _logger = RLogger.find(FProcedureBatch.class);

   @AProperty
   protected String _name;

   @AProperty
   protected String _databaseName;

   @AProperty
   protected String _procedureName;

   @AProperty
   protected long _interval;

   //============================================================
   // <T>构造用户控制台。</T>
   //============================================================
   public FProcedureBatch(){
   }

   //============================================================
   // <T>用户登出处理。</T>
   //
   // @param sqlContext 数据环境
   // @param info 用户信息输出配置
   // @return 处理结果
   //============================================================
   public EResult process(ISqlContext sqlContext){
      return EResult.Success;
   }
}
