package org.mo.eai.logic.data.control.role;

import com.cyou.gccloud.data.data.FDataControlModuleLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;

//============================================================
// <T>数据控件角色控制台。</T>
//============================================================
public class FDataControlModuleConsole
      extends FAbstractLogicUnitConsole<FDataControlModuleLogic, FDataControlModuleInfo>
      implements
         IDataControlModuleConsole
{
   // 日志输出接口
   // private static ILogger _logger = RLogger.find(FDataControlRoleConsole.class);

   //============================================================
   // <T>构造数据控件角色控制台。</T>
   //============================================================
   public FDataControlModuleConsole(){
      super(FDataControlModuleLogic.class, FDataControlModuleInfo.class);
   }
}
