package org.mo.content.core.person;

import com.cyou.gccloud.data.data.FDataPersonUserLogic;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>模型控制台。</T>
//============================================================
public class FPersonConsole
      implements
         IPersonConsole
{

   @Override
   public EResult register(ILogicContext logicContext,
                           FDataPersonUserUnit userUnit){
      try{
         FDataPersonUserLogic logic = logicContext.findLogic(FDataPersonUserLogic.class);
         logic.doInsert(userUnit);
         return EResult.Success;
      }catch(Exception e){
         e.printStackTrace();
         return EResult.Failure;
      }

   }
}
