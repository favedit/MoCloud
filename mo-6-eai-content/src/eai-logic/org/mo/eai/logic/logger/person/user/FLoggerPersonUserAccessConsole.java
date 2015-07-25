package org.mo.eai.logic.logger.person.user;

import com.cyou.gccloud.data.logger.FLoggerPersonUserAccessLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>日志人员用户访问控制台。</T>
//============================================================
public class FLoggerPersonUserAccessConsole
      extends FAbstractLogicUnitConsole<FLoggerPersonUserAccessLogic, FLoggerPersonUserAccess>
      implements
         ILoggerPersonUserAccessConsole
{
   //============================================================
   // <T>构造日志人员用户访问控制台。</T>
   //============================================================
   public FLoggerPersonUserAccessConsole(){
      super(FLoggerPersonUserAccessLogic.class, FLoggerPersonUserAccess.class);
   }
}
