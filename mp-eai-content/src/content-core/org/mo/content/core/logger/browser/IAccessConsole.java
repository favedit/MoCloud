package org.mo.content.core.logger.browser;

import com.cyou.gccloud.data.logger.FLoggerInfoBrowserAccessUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号控制台接口。</T>
//============================================================
public interface IAccessConsole
      extends
         IAbstractLogicUnitConsole<FLoggerInfoBrowserAccessUnit>
{

   FLogicDataset<FLoggerInfoBrowserAccessUnit> select(ILogicContext logicContext,
                                                      int pageNum);

}
