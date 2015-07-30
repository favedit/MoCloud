package com.ahyc.eai.batch.common;

import org.mo.com.lang.EResult;
import org.mo.eng.data.common.ISqlContext;

//============================================================
// <T>用户操作处理接口。</T>
//============================================================
public interface IProcedureBatch
{
   //============================================================
   // <T>人员处理。</T>
   //
   // @param sqlContext 数据环境
   // @param info 用户信息输出配置
   // @return 处理结果
   //============================================================
   EResult process(ISqlContext sqlContext);
}
