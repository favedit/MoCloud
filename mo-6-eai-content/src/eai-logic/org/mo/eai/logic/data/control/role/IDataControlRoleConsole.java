package org.mo.eai.logic.data.control.role;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>数据控制角色控制台接口。</T>
//============================================================
public interface IDataControlRoleConsole
      extends
         IAbstractLogicUnitConsole<FDataControlRoleInfo>
{
   //============================================================
   // <T>根据角色编号查找授权的所有模块集合。</T>
   //
   // @param logicContext 逻辑环境
   // @param roleId 角色编号
   // @return 模块集合
   //============================================================
   FLogicDataset<FDataControlModuleInfo> findRoleModules(ILogicContext logicContext,
                                                         long roleId);
}
