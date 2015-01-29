package com.cyou.gccloud.logic.person;

import com.cyou.gccloud.data.data.FDataPersonUserLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>用户控制台。</T>
//============================================================
public class FGcUserConsole
      extends FAbstractLogicUnitConsole<FDataPersonUserLogic, FGcUserInfo>
      implements
         IGcUserConsole
{
   //============================================================
   // <T>构造用户控制台。</T>
   //============================================================
   public FGcUserConsole(){
      super(FDataPersonUserLogic.class, FGcUserInfo.class);
   }
}
