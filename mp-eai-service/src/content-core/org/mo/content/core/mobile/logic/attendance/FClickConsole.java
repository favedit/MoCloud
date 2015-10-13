package org.mo.content.core.mobile.logic.attendance;

import com.cyou.gccloud.data.data.FDataPersonUserSigningLogic;
import com.cyou.gccloud.data.data.FDataPersonUserSigningUnit;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <T>打卡控制台。</T>
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

   //============================================================
   // @打卡
   // @param context 页面环境
   // @param unit 打卡记录
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public EResult click(IWebContext context,
                        ILogicContext logicContext,
                        IWebSession sessionContext,
                        FDataPersonUserSigningUnit unit){
      EResult result = logicContext.findLogic(FDataPersonUserSigningLogic.class).doInsert(unit);
      return result;
   }

}
