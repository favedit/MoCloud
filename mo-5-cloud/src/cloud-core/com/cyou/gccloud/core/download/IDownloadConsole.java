package com.cyou.gccloud.core.download;

import org.mo.data.logic.ILogicContext;

//============================================================
// <T>存储控制台接口。</T>
//============================================================
public interface IDownloadConsole
{
   //============================================================
   // <T>生成存储文件名称。</T>
   //
   // @param name 名称
   // @return 存储文件名称
   //============================================================
   String makeTypeName(int typeCd);

   //============================================================
   // <T>下载一个ZIP文件。</T>
   //
   // @param logicContext 逻辑环境
   // @param typeCd 类型
   // @param userId 用户编号
   // @param linkId 关联编号
   // @param downloadUrl 下载地址
   // @param storageFile 存储文件
   //============================================================
   void downloadZip(ILogicContext logicContext,
                    int typeCd,
                    long userId,
                    long linkId,
                    String downloadUrl,
                    String storageFile);
}
