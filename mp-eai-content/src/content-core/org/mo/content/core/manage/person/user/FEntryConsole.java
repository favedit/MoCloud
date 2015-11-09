package org.mo.content.core.manage.person.user;

import com.cyou.gccloud.data.data.FDataPersonUserEntryLogic;
import com.cyou.gccloud.data.data.FDataPersonUserEntryUnit;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.FFatalError;
import org.mo.data.logic.ILogicContext;

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

   //============================================================
   // <T>根据用户编号获取从各个系统中的用户。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param from 来源
   // @return 获取对象
   //============================================================
   @Override
   public FDataPersonUserEntryUnit findByUserId(ILogicContext logicContext,
                                                long userId,
                                                int from){
      if(userId == 0 || from == 0){
         throw new FFatalError("user id can not be empty!");
      }
      FSql whereSql = new FSql();
      whereSql.append(FDataPersonUserEntryLogic.USER_ID, " = ", userId);
      whereSql.append(" AND ");
      whereSql.append(FDataPersonUserEntryLogic.FROM_CD, " = ", from);
      FDataPersonUserEntryUnit unit = search(logicContext, whereSql);
      return unit;
   }
}
