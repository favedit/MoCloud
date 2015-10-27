package org.mo.content.core.manage.person.user;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号控制台接口。</T>
//============================================================
public interface IUserConsole
      extends
         IAbstractLogicUnitConsole<FDataPersonUserUnit>
{
   boolean passportExists(ILogicContext logicContext,
                          String passport);

   FDataPersonUserUnit findByPassport(ILogicContext logicContext,
                                      String passport);
}
