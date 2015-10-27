package org.mo.content.core.manage.logger.user;

import com.cyou.gccloud.data.logger.FLoggerPersonUserModuleLogic;
import com.cyou.gccloud.data.logger.FLoggerPersonUserModuleUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>人员进入场景日志控制台。</T>
//============================================================
public class FLoggerModuleConsole
      extends FAbstractLogicUnitConsole<FLoggerPersonUserModuleLogic, FLoggerPersonUserModuleUnit>
      implements
         ILoggerModuleConsole
{

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FLoggerModuleConsole(){
      super(FLoggerPersonUserModuleLogic.class, FLoggerPersonUserModuleUnit.class);
   }

}
