package com.cyou.gccloud.logic.common;

import com.cyou.gccloud.data.data.FDataCommonConfigUnit;
import org.mo.com.lang.face.APublish;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>配置控制台接口。</T>
//============================================================
public interface IGcConfigConsole
{
   //============================================================
   // <T>根据代码获得配置单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 配置单元
   //============================================================
   FDataCommonConfigUnit findByCode(ILogicContext logicContext,
                                    String code);

   //============================================================
   // <T>根据代码获得参数内容。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 参数内容
   //============================================================
   @APublish(version = "141226")
   String findParamter(ILogicContext logicContext,
                       String code);
}
