package org.mo.content.core.product.financial;

import com.cyou.gccloud.data.data.FDataFinancialDepartmentLogic;
import com.cyou.gccloud.data.data.FDataFinancialDepartmentUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
//============================================================
//<P>部门信息操作接口</P>
//
//@class FDepartmentConsole
//@author Sunhr
//@Date 2015.09.11
//@version 1.0.0
//============================================================

public class FDepartmentConsole
      extends FAbstractLogicUnitConsole<FDataFinancialDepartmentLogic, FDataFinancialDepartmentUnit>
      implements
         IDepartmentConsole
{

   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FDepartmentConsole(){
      super(FDataFinancialDepartmentLogic.class, FDataFinancialDepartmentUnit.class);
   }

}
