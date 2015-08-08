package org.mo.eai.logic.service.info;

import org.mo.core.aop.face.AProperty;

//============================================================
// <T>逻辑服务信息控制台。</T>
//============================================================
public class FLogicServiceInfoConsole
      implements
         ILogicServiceInfoConsole
{
   // 服务地址
   @AProperty
   protected String _serviceHost;

   // 服务逻辑
   @AProperty
   protected String _serviceLogic;

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

   //============================================================
   // <T>获得服务逻辑。</T>
   //
   // @return 服务逻辑
   //============================================================
   @Override
   public String serviceLogic(){
      return _serviceLogic;
   }
}
