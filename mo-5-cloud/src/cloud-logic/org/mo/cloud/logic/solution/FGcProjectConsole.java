package org.mo.cloud.logic.solution;

import com.cyou.gccloud.data.data.FDataSolutionProjectLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.message.IGcMessageConsole;
import org.mo.core.aop.face.ALink;
import org.mo.core.bind.IBindConsole;

//============================================================
// <T>方案项目控制台。</T>
//============================================================
public class FGcProjectConsole
      extends FAbstractLogicUnitConsole<FDataSolutionProjectLogic, FGcProjectInfo>
      implements
         IGcProjectConsole
{
   // 日志输出接口
   // private static ILogger _logger = RLogger.find(FGcProjectConsole.class);

   // 消息控制台
   @ALink
   protected IGcMessageConsole _logicMessageConsole;

   // 绑定控制台
   @ALink
   protected IBindConsole _bindConsole;

   //============================================================
   // <T>构造用户控制台。</T>
   //============================================================
   public FGcProjectConsole(){
      super(FDataSolutionProjectLogic.class, FGcProjectInfo.class);
   }
}
