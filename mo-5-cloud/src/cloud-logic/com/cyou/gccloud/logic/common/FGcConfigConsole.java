package com.cyou.gccloud.logic.common;

import com.cyou.gccloud.data.data.FDataCommonConfigLogic;
import com.cyou.gccloud.data.data.FDataCommonConfigUnit;
import org.mo.com.console.FConsole;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>配置控制台。</T>
//============================================================
public class FGcConfigConsole
      extends FConsole
      implements
         IGcConfigConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FGcConfigConsole.class);

   //============================================================
   // <T>根据代码获得配置单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 配置单元
   //============================================================
   @Override
   public FDataCommonConfigUnit findByCode(ILogicContext logicContext,
                                           String code){
      FDataCommonConfigLogic logic = logicContext.findLogic(FDataCommonConfigLogic.class);
      String whereSql = String.format("(OVLD=1) AND (CODE='%s')", code);
      FDataCommonConfigUnit unit = logic.search(whereSql);
      if(unit == null){
         _logger.warn(this, "findByCode", "Find code not found.(code=%s)", code);
         return null;
      }
      return unit;
   }

   //============================================================
   // <T>根据代码获得参数1内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 参数内容
   //============================================================
   @Override
   public String findParamter(ILogicContext logicContext,
                              String code){
      String result = null;
      FDataCommonConfigUnit unit = findByCode(logicContext, code);
      if(unit != null){
         result = unit.parameter();
      }
      return result;
   }
}
