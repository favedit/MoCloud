package org.mo.data.logic;

import org.mo.eng.data.common.ISqlContext;

//============================================================
// <T>逻辑环境接口。</T>
//============================================================
public interface ILogicContext
      extends
         ISqlContext
{
   //============================================================
   // <T>根据类对象获得逻辑表格接口。</T>
   //
   // @param clazz 类对象
   // @return 逻辑表格接口
   //============================================================
   <T extends ILogicTable> T findLogic(Class<T> clazz);
}
