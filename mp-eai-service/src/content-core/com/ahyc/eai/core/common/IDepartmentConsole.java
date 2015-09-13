package com.ahyc.eai.core.common;

import com.cyou.gccloud.data.data.FDataFinancialDepartmentUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
//============================================================
//<P>部门信息操作接口</P>
//
//@class IDepartmentConsole
//@author Sunhr
//@Date 2015.09.11 
//@version 1.0.0
//============================================================
import org.mo.data.logic.ILogicContext;

public interface IDepartmentConsole
      extends
         IAbstractLogicUnitConsole<FDataFinancialDepartmentUnit>
{
   // ============================================================
   // <T>根据外链id获取对象</T>
   //
   // @param logicContext 链接对象
   // @param linkId 外链id
   // @return 数据对象
   // ============================================================
   FDataFinancialDepartmentUnit findByLinkId(ILogicContext logicContext,
                                             long linkId);
}
