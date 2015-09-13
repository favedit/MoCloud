package org.mo.content.core.excel.synchronize;

import com.cyou.gccloud.data.data.FDataCommonProvinceUnit;
import com.cyou.gccloud.data.data.FDataFinancialDepartmentUnit;
import org.mo.com.lang.RString;
import org.mo.content.core.product.common.IProvinceConsole;
import org.mo.content.core.product.financial.department.IDepartmentConsole;
import org.mo.core.aop.RAop;
import org.mo.data.logic.FLogicContext;
import org.mo.data.logic.FLogicDataset;
import org.mo.eng.data.IDatabaseConsole;

//============================================================
// <T>根据分公司中的省份名称找到对应编号。</T>
//============================================================
public class RSynchronizeProvinceCity
{

   public static void main(String[] args){

      IDatabaseConsole databaseConsole = RAop.find(IDatabaseConsole.class);
      FLogicContext logicContext = new FLogicContext(databaseConsole);
      //省份
      IProvinceConsole provinceConsole = RAop.find(IProvinceConsole.class);
      //分公司
      IDepartmentConsole deparConsole = RAop.find(IDepartmentConsole.class);

      FLogicDataset<FDataFinancialDepartmentUnit> departmentList = deparConsole.fetch(logicContext, null);
      for(FDataFinancialDepartmentUnit unit : departmentList){
         String provinceLabel = unit.provinceLabel();
         if(!RString.isEmpty(provinceLabel)){
            FDataCommonProvinceUnit province = provinceConsole.findByLabel(logicContext, provinceLabel);
            if(province != null){
               unit.setProvinceId((int)province.ouid());
               deparConsole.doUpdate(logicContext, unit);
            }
         }
      }

   }
}
