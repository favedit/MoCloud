package org.mo.cloud.logic.person;

import com.cyou.gccloud.data.data.FDataPersonUserLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.RSql;
import org.mo.data.logic.ILogicContext;

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

   //============================================================
   // <T>根据通行证查找用户信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param passport 通行证
   // @return 用户信息
   //============================================================
   @Override
   public FGcUserInfo findByPassport(ILogicContext logicContext,
                                     String passport){
      String whereSql = FDataPersonUserLogic.PASSPORT + "='" + RSql.formatValue(passport) + "'";
      FDataPersonUserLogic logic = findLogic(logicContext);
      FGcUserInfo user = logic.search(FGcUserInfo.class, whereSql);
      return user;
   }
}
