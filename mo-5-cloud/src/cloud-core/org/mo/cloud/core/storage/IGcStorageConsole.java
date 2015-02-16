package org.mo.cloud.core.storage;

import org.mo.com.lang.EResult;

//============================================================
// <T>存储控制台接口。</T>
//============================================================
public interface IGcStorageConsole
{
   //============================================================
   // <T>保存一个存储信息。</T>
   //
   // @param storage 存储信息
   // @return 处理结果
   //============================================================
   SGcStorage find(String catalog,
                   String guid);

   //============================================================
   // <T>保存一个存储信息。</T>
   //
   // @param storage 存储信息
   // @return 处理结果
   //============================================================
   boolean store(SGcStorage storage);

   //============================================================
   // <T>保存一个存储信息。</T>
   //
   // @param storage 存储信息
   // @return 处理结果
   //============================================================
   EResult exportFile(String catalog,
                      String guid,
                      String path);

   //============================================================
   // <T>保存一个存储信息。</T>
   //
   // @param storage 存储信息
   // @return 处理结果
   //============================================================
   EResult importFile(String catalog,
                      String guid,
                      String type,
                      String fileName);
}
