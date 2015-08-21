package org.mo.content.core.manage.person.user;

import com.cyou.gccloud.data.data.FDataPersonUserEntryLogic;
import com.cyou.gccloud.data.data.FDataPersonUserEntryUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>人员账号入口控制台。</T>
//============================================================
public class FEntryConsole
      extends FAbstractLogicUnitConsole<FDataPersonUserEntryLogic, FDataPersonUserEntryUnit>
      implements
         IEntryConsole
{

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FEntryConsole(){
      super(FDataPersonUserEntryLogic.class, FDataPersonUserEntryUnit.class);
   }

}
