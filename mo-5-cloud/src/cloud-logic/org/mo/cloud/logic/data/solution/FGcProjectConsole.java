package org.mo.cloud.logic.data.solution;

import com.cyou.gccloud.data.data.FDataSolutionProjectLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.message.IGcMessageConsole;
import org.mo.com.data.RSql;
import org.mo.core.aop.face.ALink;
import org.mo.core.bind.IBindConsole;
import org.mo.data.logic.ILogicContext;

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

   //============================================================
   // <T>根据用户编号和代码查找项目信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param code 项目代码
   // @return 项目信息
   //============================================================
   @Override
   public FGcProjectInfo findByUserCode(ILogicContext logicContext,
                                        long userId,
                                        String code){
      String whereSql = "(" + FDataSolutionProjectLogic.USER_ID + "=" + userId + ") AND (" + FDataSolutionProjectLogic.CODE + "='" + RSql.formatValue(code) + "')";
      FGcProjectInfo project = search(logicContext, whereSql);
      return project;
   }
}
