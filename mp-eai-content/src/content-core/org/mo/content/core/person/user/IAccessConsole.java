package org.mo.content.core.person.user;

import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号控制台接口。</T>
//============================================================
public interface IAccessConsole
      extends
         IAbstractLogicUnitConsole<FDataPersonAccessAuthorityUnit>
{

   FLogicDataset<FDataPersonAccessAuthorityUnit> select(ILogicContext logicContext);
}
