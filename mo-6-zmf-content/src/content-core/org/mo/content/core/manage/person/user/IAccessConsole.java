package org.mo.content.core.manage.person.user;

import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号权限控制台接口。</T>
//============================================================
public interface IAccessConsole
      extends
         IAbstractLogicUnitConsole<FDataPersonAccessAuthorityUnit>
{

   FLogicDataset<FDataPersonAccessAuthorityUnit> select(ILogicContext logicContext,
                                                        int pageNum);

   EResult hostExists(ILogicContext logicContext,
                      String host);

   EResult passportExists(ILogicContext logicContext,
                          String passport);

}
