package com.ahyc.eai.batch.financial.department;

import org.mo.data.logic.FLogicContext;

//============================================================
// <T>部门信息控制台接口。</T>
//============================================================
public interface IStatisticsDepartmentInfoConsole
{
   //============================================================
   // <T>查找部门信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param id 编号
   //============================================================
   FStatisticsDepartmentInfo find(FLogicContext logicContext,
                        long id);

   //============================================================
   // <T>清空处理。</T>
   //============================================================
   void clear();
}
