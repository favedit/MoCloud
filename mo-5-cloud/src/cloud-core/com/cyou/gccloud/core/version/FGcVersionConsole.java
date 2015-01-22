package com.cyou.gccloud.core.version;

import org.mo.core.aop.face.AProperty;

//============================================================
// <T>版本控制台接口。</T>
//============================================================
public class FGcVersionConsole
      implements
         IGcVersionConsole
{
   // 存储服务器
   @AProperty
   protected String _currentVersion;

   //============================================================
   // <T>获得当前版本。</T>
   //
   // @return 当前版本
   //============================================================
   @Override
   public String currentVersion(){
      return _currentVersion;
   }
}
