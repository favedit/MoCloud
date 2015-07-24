package org.mo.content.core.person.user;

import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityLogic;
import com.cyou.gccloud.data.data.FDataPersonAccessAuthorityUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号控制台。</T>
//============================================================
public class FAccessConsole
      extends FAbstractLogicUnitConsole<FDataPersonAccessAuthorityLogic, FDataPersonAccessAuthorityUnit>
      implements
         IAccessConsole
{

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FAccessConsole(){
      super(FDataPersonAccessAuthorityLogic.class, FDataPersonAccessAuthorityUnit.class);
   }

   @Override
   public FLogicDataset<FDataPersonAccessAuthorityUnit> select(ILogicContext logicContext){

      FDataPersonAccessAuthorityLogic logic = new FDataPersonAccessAuthorityLogic(logicContext);
      FLogicDataset<FDataPersonAccessAuthorityUnit> unitlist = logic.fetchClass(FDataPersonAccessAuthorityUnit.class, null);
      return unitlist;
   }

}
