package com.cyou.gccloud.logic.person;

import com.cyou.gccloud.core.database.FAbstractLogicUnitConsole;
import com.cyou.gccloud.data.data.FDataPersonEntryLogic;
import org.mo.data.logic.FLogicTable;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>用户入口控制台。</T>
//============================================================
public class FGcUserEntryConsole
      extends FAbstractLogicUnitConsole<FGcUserEntryInfo>
      implements
         IGcUserEntryConsole
{
   //============================================================
   // <T>创建逻辑单元</T>
   //
   // @param logicContext 逻辑环境
   // @return 逻辑单元
   //============================================================
   @Override
   protected FLogicTable createLogic(ILogicContext logicContext){
      return logicContext.findLogic(FDataPersonEntryLogic.class);
   }

   //============================================================
   // <T>根据来源类型和账号获得一个数据单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param fromCd 来源类型
   // @param passport 账号
   // @return 处理结果
   //============================================================
   @Override
   public FGcUserEntryInfo find(ILogicContext logicContext,
                                int fromCd,
                                String passport){
      FDataPersonEntryLogic logic = logicContext.findLogic(FDataPersonEntryLogic.class);
      String whereSql = "(" + FDataPersonEntryLogic.FROM_CD + "=" + fromCd + ") AND (" + FDataPersonEntryLogic.PASSPORT + "='" + passport + "')";
      FGcUserEntryInfo info = logic.search(FGcUserEntryInfo.class, whereSql);
      return info;
   }
}
