package org.mo.cloud.logic.data.solution;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>方案项目控制台接口。</T>
//============================================================
public interface IGcProjectConsole
      extends
         IAbstractLogicUnitConsole<FGcProjectInfo>
{
   //============================================================
   // <T>根据用户编号和代码查找项目信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param code 项目代码
   // @return 项目信息
   //============================================================
   FGcProjectInfo findByUserCode(ILogicContext logicContext,
                                 long userId,
                                 String code);
}
