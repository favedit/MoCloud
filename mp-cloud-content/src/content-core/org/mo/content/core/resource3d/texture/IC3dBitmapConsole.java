package org.mo.content.core.resource3d.texture;

import com.cyou.gccloud.data.data.FDataResourceBitmapImageUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>模型控制台接口。</T>
//============================================================
public interface IC3dBitmapConsole
{
   //============================================================
   // <T>逻辑处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param version 版本
   //============================================================
   FDataResourceBitmapImageUnit findBitmapUnit(ILogicContext logicContext,
                                               String code,
                                               String version);
}
