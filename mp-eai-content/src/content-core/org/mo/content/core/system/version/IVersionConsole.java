package org.mo.content.core.system.version;

import com.cyou.gccloud.data.data.FDataSystemVersionUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
//<P>版本控制台接口</P>
//@interface IProductConsole
//@version 1.0.0
//============================================================
public interface IVersionConsole
      extends
         IAbstractLogicUnitConsole<FDataSystemVersionUnit>
{

   FDataSystemVersionUnit findMaxByAppId(ILogicContext logicContext,
                                         long applicationId);
}
