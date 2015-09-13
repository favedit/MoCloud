package com.ahyc.eai.core.common;

import com.cyou.gccloud.data.data.FDataFinancialDepartmentLogic;
import com.cyou.gccloud.data.data.FDataFinancialDepartmentUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
//============================================================
//<P>部门信息操作接口</P>
//
//@class FDepartmentConsole
//@author Sunhr
//@Date 2015.09.11
//@version 1.0.0
//============================================================
import org.mo.data.logic.ILogicContext;

public class FDepartmentConsole
      extends FAbstractLogicUnitConsole<FDataFinancialDepartmentLogic, FDataFinancialDepartmentUnit>
      implements
         IDepartmentConsole
{

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FDepartmentConsole(){
      super(FDataFinancialDepartmentLogic.class, FDataFinancialDepartmentUnit.class);
   }

   // ============================================================
   // <T>根据外链编号获取对象</T>
   //
   // @param logicContext 链接对象
   // @param linkId 外链编号
   // @return 数据对象
   // ============================================================
   @Override
   public FDataFinancialDepartmentUnit findByLinkId(ILogicContext logicContext,
                                                    long linkId){
      StringBuffer where = new StringBuffer();
      if(linkId != 0){
         where.append(FDataFinancialDepartmentLogic.LINK_ID).append(" = '").append(linkId).append("'");
      }
      FDataFinancialDepartmentLogic logic = logicContext.findLogic(FDataFinancialDepartmentLogic.class);
      FLogicDataset<FDataFinancialDepartmentUnit> department = logic.fetch(where);
      return department.first();
   }

}
