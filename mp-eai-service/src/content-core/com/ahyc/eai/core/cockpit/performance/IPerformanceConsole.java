package com.ahyc.eai.core.cockpit.performance;

//============================================================
// <T>金融控制台接口。</T>
//============================================================
public interface IPerformanceConsole
{
   //============================================================
   // <T>查找模式。</T>
   //
   // @param code 模式代码
   // @return 模式
   //============================================================
   FPerformanceModel findTenderModel(String code);
}
