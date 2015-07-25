package org.mo.eai.logic.logger.info.browser;

import com.cyou.gccloud.data.logger.FLoggerInfoBrowserAccessLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>日志信息浏览器访问控制台。</T>
//============================================================
public class FLoggerInfoBrowserAccessConsole
      extends FAbstractLogicUnitConsole<FLoggerInfoBrowserAccessLogic, FLoggerInfoBrowserAccess>
      implements
         ILoggerInfoBrowserAccessConsole
{
   //============================================================
   // <T>构造日志信息浏览器访问控制台。</T>
   //============================================================
   public FLoggerInfoBrowserAccessConsole(){
      super(FLoggerInfoBrowserAccessLogic.class, FLoggerInfoBrowserAccess.class);
   }
}
