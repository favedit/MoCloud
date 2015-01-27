package com.cyou.gccloud.logic.person;

import com.cyou.gccloud.data.data.FDataPersonUserLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.data.logic.FLogicTable;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>用户控制台。</T>
//============================================================
public class FGcUserConsole
      extends FAbstractLogicUnitConsole<FGcUserInfo>
      implements
         IGcUserConsole
{
   //============================================================
   // <T>构造用户控制台。</T>
   //============================================================
   public FGcUserConsole(){
      super(FGcUserInfo.class);
   }

   //============================================================
   // <T>创建逻辑单元</T>
   //
   // @param logicContext 逻辑环境
   // @return 逻辑单元
   //============================================================
   @Override
   protected FLogicTable createLogic(ILogicContext logicContext){
      return logicContext.findLogic(FDataPersonUserLogic.class);
   }
}
