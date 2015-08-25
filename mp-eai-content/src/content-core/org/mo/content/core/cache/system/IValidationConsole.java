package org.mo.content.core.cache.system;

import com.cyou.gccloud.data.cache.FCacheSystemValidationUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
//============================================================
//<P>短信效验操作接口</P>
//
//@class IValidationConsole
//@author Sunhr
//@Date 2015.08.25  
//@version 1.0.0
//============================================================
import org.mo.data.logic.ILogicContext;

public interface IValidationConsole
      extends
         IAbstractLogicUnitConsole<FCacheSystemValidationUnit>
{
   // ============================================================
   // <T>根据账号获取短信验证信息</T>
   //
   // @param logicContext 链接对象
   // @param passport 角色编号
   // ============================================================
   FCacheSystemValidationUnit findByPassport(ILogicContext logicContext,
                                             String passport);
}
