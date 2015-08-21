package org.mo.content.core.manage.person.role;

import com.cyou.gccloud.data.data.FDataControlRoleLogic;
import com.cyou.gccloud.data.data.FDataControlRoleUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.RString;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

public class FRoleConsole
      extends FAbstractLogicUnitConsole<FDataControlRoleLogic, FDataControlRoleUnit>
      implements
         IRoleConsole
{

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FRoleConsole(){
      super(FDataControlRoleLogic.class, FDataControlRoleUnit.class);
   }

   @Override
   public FDataControlRoleUnit findByCode(ILogicContext logicContext,
                                          String code){
      StringBuffer whereSql = new StringBuffer();
      if(!RString.isEmpty(code)){
         whereSql.append(FDataControlRoleLogic.CODE).append("='").append(code + "'");
      }
      FDataControlRoleLogic logic = logicContext.findLogic(FDataControlRoleLogic.class);
      FLogicDataset<FDataControlRoleUnit> roleList = logic.fetch(whereSql.toString());
      return roleList.first();
   }

}
