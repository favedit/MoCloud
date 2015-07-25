package org.mo.content.core.logger.user;

import com.cyou.gccloud.data.logger.FLoggerPersonUserAccessUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号控制台接口。</T>
//============================================================
public interface IAccessConsole
      extends
         IAbstractLogicUnitConsole<FLoggerPersonUserAccessUnit>
{

   FLogicDataset<FLoggerPersonUserAccessUnit> select(ILogicContext logicContext,
                                                     int pageNum);

}
