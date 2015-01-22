package org.mo.eng.sms;

import org.mo.com.console.FConsole;
import org.mo.core.aop.face.AProperty;

//============================================================
// <T>短信控制台。</T>
//============================================================
public abstract class FSmsConsole
      extends FConsole
      implements
         ISmsConsole
{

   // 发送地址
   @AProperty
   protected String sendHost;

   //url
   @AProperty
   protected String url;

   @AProperty
   protected int debugCD = FSms.DEBUG_CD_NONE;

   @Override
   public int debugCD(){
      return debugCD;
   }

   //============================================================
   // <T>发送短信。</T>
   //
   // @param sms 短信
   // @return 结果
   //============================================================
   @Override
   public abstract void send(FSms sms);
}
