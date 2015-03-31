package org.mo.cloud.logic.person;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>用户控制台接口。</T>
//============================================================
public interface IGcUserConsole
      extends
         IAbstractLogicUnitConsole<FGcUserInfo>
{
   //============================================================
   // <T>根据通行证查找用户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param passport 通行证
   // @return 用户信息
   //============================================================
   FGcUserInfo findByPassport(ILogicContext logicContext,
                              String passport);
}
