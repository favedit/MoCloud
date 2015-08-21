package org.mo.content.core.manage.person.user;

import com.cyou.gccloud.data.data.FDataPersonUserLogic;
import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>人员账号控制台。</T>
//============================================================
public class FUserConsole
      extends FAbstractLogicUnitConsole<FDataPersonUserLogic, FDataPersonUserUnit>
      implements
         IUserConsole
{
   // 每页条数
   static final int _pageSize = 20;

   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FUserConsole(){
      super(FDataPersonUserLogic.class, FDataPersonUserUnit.class);
   }

   @Override
   public boolean passportExists(ILogicContext logicContext,
                                 String passport){
      StringBuffer whereSql = new StringBuffer();
      if(!passport.isEmpty()){
         whereSql.append(FDataPersonUserLogic.PASSPORT).append(" = '").append(passport).append("'");
      }
      FDataPersonUserLogic logic = logicContext.findLogic(FDataPersonUserLogic.class);
      FLogicDataset<FDataPersonUserUnit> unitlist = logic.fetch(whereSql);
      return unitlist.count() > 0 ? true : false;
   }
}
