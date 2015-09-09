package org.mo.cloud.logic.data.common.configuration;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>配置信息控制台接口。</T>
//============================================================
public interface IGcConfigurationConsole
      extends
         IAbstractLogicUnitConsole<FGcConfigurationInfo>
{
   //============================================================
   // <T>根据代码查找配置信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 配置信息
   //============================================================
   FGcConfigurationInfo findByCode(ILogicContext logicContext,
                                   String code);

   //============================================================
   // <T>根据参数获得内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   String getParameter(ILogicContext logicContext,
                       String code);

   //============================================================
   // <T>根据参数获得内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   int getParameterAsInteger(ILogicContext logicContext,
                             String code);

   //============================================================
   // <T>根据参数获得内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   long getParameterAsLong(ILogicContext logicContext,
                           String code);

   //============================================================
   // <T>根据参数获得内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   float getParameterAsFloat(ILogicContext logicContext,
                             String code);

   //============================================================
   // <T>根据参数获得内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   double getParameterAsDouble(ILogicContext logicContext,
                               String code);

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   String findParameter(ILogicContext logicContext,
                        String code);

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param defaultValue 默认内容
   // @return 内容
   //============================================================
   String findParameter(ILogicContext logicContext,
                        String code,
                        String defaultValue);

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   int findParameterAsInteger(ILogicContext logicContext,
                              String code);

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param defaultValue 默认内容
   // @return 内容
   //============================================================
   int findParameterAsInteger(ILogicContext logicContext,
                              String code,
                              int defaultValue);

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   long findParameterAsLong(ILogicContext logicContext,
                            String code);

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param defaultValue 默认内容
   // @return 内容
   //============================================================
   long findParameterAsLong(ILogicContext logicContext,
                            String code,
                            long defaultValue);

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   float findParameterAsFloat(ILogicContext logicContext,
                              String code);

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param defaultValue 默认内容
   // @return 内容
   //============================================================
   float findParameterAsFloat(ILogicContext logicContext,
                              String code,
                              float defaultValue);

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   double findParameterAsDouble(ILogicContext logicContext,
                                String code);

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param defaultValue 默认内容
   // @return 内容
   //============================================================
   double findParameterAsDouble(ILogicContext logicContext,
                                String code,
                                double defaultValue);
}
