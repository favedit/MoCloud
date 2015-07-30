package com.ahyc.eai.batch.core.download;

import org.mo.eng.data.common.ISqlContext;

//============================================================
// <T>资源应用接口。</T>
//============================================================
public interface IBatchDownloadConsole
{
   //============================================================
   // <T>后台处理。</T>
   //============================================================
   public void process();

   //============================================================
   // <T>删除一个应用信息。</T>
   //
   // @param sqlContext 数据环境
   // @param info 应用信息
   //============================================================
   void push(ISqlContext sqlContext,
             long uid,
             long lid,
             String url);
}
