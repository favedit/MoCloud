package org.mo.cloud.logic.data.common.configuration;

import com.cyou.gccloud.data.data.FDataCommonConfigurationLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.FSql;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RDouble;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>配置信息控制台。</T>
//============================================================
public class FGcConfigurationConsole
      extends FAbstractLogicUnitConsole<FDataCommonConfigurationLogic, FGcConfigurationInfo>
      implements
         IGcConfigurationConsole
{
   // 日志输出接口
   // private static ILogger _logger = RLogger.find(FCountryConsole.class);

   //============================================================
   // <T>配置省份信息控制台。</T>
   //============================================================
   public FGcConfigurationConsole(){
      super(FDataCommonConfigurationLogic.class, FGcConfigurationInfo.class);
   }

   //============================================================
   // <T>根据代码查找配置信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 配置信息
   //============================================================
   @Override
   public FGcConfigurationInfo findByCode(ILogicContext logicContext,
                                          String code){
      FSql whereSql = new FSql("CODE={code}");
      whereSql.bindString("code", code);
      return search(logicContext, whereSql);
   }

   //============================================================
   // <T>根据参数获得内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   @Override
   public String getParameter(ILogicContext logicContext,
                              String code){
      FGcConfigurationInfo info = findByCode(logicContext, code);
      if(info == null){
         throw new FFatalError("Parameter is not exists. (code={1})", code);
      }
      return info.dataValue();
   }

   //============================================================
   // <T>根据参数获得内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   @Override
   public int getParameterAsInteger(ILogicContext logicContext,
                                    String code){
      String value = getParameter(logicContext, code);
      return RInteger.parse(value);
   }

   //============================================================
   // <T>根据参数获得内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   @Override
   public long getParameterAsLong(ILogicContext logicContext,
                                  String code){
      String value = getParameter(logicContext, code);
      return RLong.parse(value);
   }

   //============================================================
   // <T>根据参数获得内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   @Override
   public float getParameterAsFloat(ILogicContext logicContext,
                                    String code){
      String value = getParameter(logicContext, code);
      return RFloat.parse(value);
   }

   //============================================================
   // <T>根据参数获得内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   @Override
   public double getParameterAsDouble(ILogicContext logicContext,
                                      String code){
      String value = getParameter(logicContext, code);
      return RDouble.parse(value);

   }

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   @Override
   public String findParameter(ILogicContext logicContext,
                               String code){
      return findParameter(logicContext, code, null);
   }

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param defaultValue 默认内容
   // @return 内容
   //============================================================
   @Override
   public String findParameter(ILogicContext logicContext,
                               String code,
                               String defaultValue){
      String value = null;
      FGcConfigurationInfo info = findByCode(logicContext, code);
      if(info != null){
         value = info.dataValue();
      }else{
         value = defaultValue;
      }
      return value;
   }

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   @Override
   public int findParameterAsInteger(ILogicContext logicContext,
                                     String code){
      String value = findParameter(logicContext, code, null);
      return RInteger.parse(value, 0);
   }

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param defaultValue 默认内容
   // @return 内容
   //============================================================
   @Override
   public int findParameterAsInteger(ILogicContext logicContext,
                                     String code,
                                     int defaultValue){
      String value = findParameter(logicContext, code, null);
      return RInteger.parse(value, defaultValue);
   }

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   @Override
   public long findParameterAsLong(ILogicContext logicContext,
                                   String code){
      String value = findParameter(logicContext, code, null);
      return RLong.parse(value, 0);
   }

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param defaultValue 默认内容
   // @return 内容
   //============================================================
   @Override
   public long findParameterAsLong(ILogicContext logicContext,
                                   String code,
                                   long defaultValue){
      String value = findParameter(logicContext, code, null);
      return RLong.parse(value, defaultValue);
   }

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   @Override
   public float findParameterAsFloat(ILogicContext logicContext,
                                     String code){
      String value = findParameter(logicContext, code, null);
      return RFloat.parse(value, 0);
   }

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param defaultValue 默认内容
   // @return 内容
   //============================================================
   @Override
   public float findParameterAsFloat(ILogicContext logicContext,
                                     String code,
                                     float defaultValue){
      String value = findParameter(logicContext, code, null);
      return RFloat.parse(value, defaultValue);
   }

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 内容
   //============================================================
   @Override
   public double findParameterAsDouble(ILogicContext logicContext,
                                       String code){
      String value = findParameter(logicContext, code, null);
      return RDouble.parse(value, 0);
   }

   //============================================================
   // <T>根据参数查找内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param defaultValue 默认内容
   // @return 内容
   //============================================================
   @Override
   public double findParameterAsDouble(ILogicContext logicContext,
                                       String code,
                                       double defaultValue){
      String value = findParameter(logicContext, code, null);
      return RDouble.parse(value, defaultValue);
   }
}
