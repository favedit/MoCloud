package org.mo.content.core.mobile.logic.attendance;

import com.cyou.gccloud.data.data.FDataPersonUserSigningLogic;
import com.cyou.gccloud.data.data.FDataPersonUserSigningUnit;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>版本更新控制台。</T>
//============================================================
public class FClickConsole
      extends FObject
      implements
         IClickConsole
{
   // 日志输出接口

   //============================================================
   // <T>构造资源</T>
   //============================================================
   public FClickConsole(){

   }

   @Override
   public EResult click(IWebContext context,
                        ILogicContext logicContext,
                        IWebSession sessionContext,
                        FDataPersonUserSigningUnit unit){
      EResult result = logicContext.findLogic(FDataPersonUserSigningLogic.class).doInsert(unit);
      return result;
   }

}
