package org.mo.eai.logic.logger.person.user;

import com.cyou.gccloud.data.logger.FLoggerPersonUserModuleLogic;
import com.cyou.gccloud.data.logger.FLoggerPersonUserModuleUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>日志人员用户访问控制台。</T>
//============================================================
public class FLoggerPersonUserModuleConsole
      extends FAbstractLogicUnitConsole<FLoggerPersonUserModuleLogic, FLoggerPersonUserModuleUnit>
      implements
         ILoggerPersonUserModuleConsole
{
   //============================================================
   // <T>构造日志人员用户访问控制台。</T>
   //============================================================
   public FLoggerPersonUserModuleConsole(){
      super(FLoggerPersonUserModuleLogic.class, FLoggerPersonUserModuleUnit.class);
   }

}
