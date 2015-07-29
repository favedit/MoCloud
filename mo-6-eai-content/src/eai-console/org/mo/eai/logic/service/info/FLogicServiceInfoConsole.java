package org.mo.eai.logic.service.info;

import org.mo.core.aop.face.AProperty;

//============================================================
// <T>逻辑服务信息控制台。</T>
//============================================================
public class FLogicServiceInfoConsole
      implements
         ILogicServiceInfoConsole
{
   @AProperty
   protected String _serviceHost;

   //============================================================
   // <T>构造逻辑服务信息控制台。</T>
   //============================================================
   public FLogicServiceInfoConsole(){
   }

   //============================================================
   // <T>获得服务地址。</T>
   //
   // @return 服务地址
   //============================================================
   @Override
   public String serviceHost(){
      return _serviceHost;
   }
}
