package org.mo.content.core.person.user;

import com.cyou.gccloud.data.data.FDataPersonAccessHostLogic;
import com.cyou.gccloud.data.data.FDataPersonAccessHostUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号控制台。</T>
//============================================================
public class FAccessConsole
      extends FAbstractLogicUnitConsole<FDataPersonAccessHostLogic, FDataPersonAccessHostUnit>
      implements
         IAccessConsole
{

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FAccessConsole(){
      super(FDataPersonAccessHostLogic.class, FDataPersonAccessHostUnit.class);
   }

   @Override
   public FLogicDataset<FDataPersonAccessHostUnit> select(ILogicContext logicContext){

      FDataPersonAccessHostLogic logic = new FDataPersonAccessHostLogic(logicContext);
      FLogicDataset<FDataPersonAccessHostUnit> unitlist = logic.fetchClass(FDataPersonAccessHostUnit.class, null);
      return unitlist;
   }

}
