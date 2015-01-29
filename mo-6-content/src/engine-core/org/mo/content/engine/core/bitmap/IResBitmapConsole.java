package org.mo.content.engine.core.bitmap;

import com.cyou.gccloud.data.data.FDataResourceBitmapUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台接口。</T>
//============================================================
public interface IResBitmapConsole
{
   //============================================================
   // <T>根据代码查找位图单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param bitmapId 位图编号
   // @return 位图单元
   //============================================================
   FDataResourceBitmapUnit find(ILogicContext logicContext,
                                long bitmapId);
}
