package org.mo.eai.logic.logger.person.user;

import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>用户访问控制台。</T>
//============================================================
public class FLoggerPersonUserAccessConsole
      extends FAbstractLogicUnitConsole<FDataPersonAccessAuthorityLogic, FLoggerPersonUserAccess>
      implements
         ILoggerPersonUserAccessConsole
{
   //============================================================
   // <T>构造用户访问控制台。</T>
   //============================================================
   public FLoggerPersonUserAccessConsole(){
      super(FDataPersonAccessAuthorityLogic.class, FLoggerPersonUserAccess.class);
   }
}
