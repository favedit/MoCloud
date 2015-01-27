package org.mo.cloud.core.server;

import org.mo.core.aop.face.AProperty;

//============================================================
// <T>服务器控制台。</T>
//============================================================
public class FGcServerConsole
      implements
         IGcServerConsole
{
   // 服务本地地址
   @AProperty
   protected String _serviceLocalUrl;

   // 服务远程地址
   @AProperty
   protected String _serviceRemoteUrl;

   // 存储本地地址
   @AProperty
   protected String _storageLocalUrl;

   // 存储远程地址
   @AProperty
   protected String _storageRemoteUrl;

   //============================================================
   // <T>获得服务本地地址。</T>
   //
   // @return 本地地址
   //============================================================
   @Override
   public String serviceLocalUrl(){
      return _serviceLocalUrl;
   }

   //============================================================
   // <T>获得服务远程地址。</T>
   //
   // @return 远程地址
   //============================================================
   @Override
   public String serviceRemoteUrl(){
      return _serviceRemoteUrl;
   }

   //============================================================
   // <T>生成服务远程地址。</T>
   //
   // @return 远程地址
   //============================================================
   @Override
   public String serviceRemoteUrl(String uri){
      return _serviceRemoteUrl + uri;
   }

   //============================================================
   // <T>获得存储本地地址。</T>
   //
   // @return 本地地址
   //============================================================
   @Override
   public String storageLocalUrl(){
      return _storageLocalUrl;
   }

   //============================================================
   // <T>获得存储远程地址。</T>
   //
   // @return 远程地址
   //============================================================
   @Override
   public String storageRemoteUrl(){
      return _storageRemoteUrl;
   }

   //============================================================
   // <T>生成存储远程地址。</T>
   //
   // @return 远程地址
   //============================================================
   @Override
   public String storageRemoteUrl(String uri){
      return _storageRemoteUrl + uri;
   }
}
