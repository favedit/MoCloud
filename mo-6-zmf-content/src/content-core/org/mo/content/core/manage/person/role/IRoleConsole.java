package org.mo.content.core.manage.person.role;

import com.cyou.gccloud.data.data.FDataControlRoleUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;
//============================================================
//<P>用户逻辑数据库操作接口</P>
//
//@class IroleConsole
//@author Sunhr
//@Date 2015.08.21  
//@version 1.0.0
//============================================================

public interface IRoleConsole
      extends
         IAbstractLogicUnitConsole<FDataControlRoleUnit>
{

   FDataControlRoleUnit findByCode(ILogicContext logicContext,
                                   String code);
}
