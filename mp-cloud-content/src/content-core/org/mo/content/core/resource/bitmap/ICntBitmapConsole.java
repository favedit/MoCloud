package org.mo.content.core.resource.bitmap;

import org.mo.cloud.logic.data.resource.bitmap.FGcResBitmapInfo;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.content.engine.core.bitmap.IResBitmapConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容位图控制台接口。</T>
//============================================================
public interface ICntBitmapConsole
      extends
         IResBitmapConsole
{
   //============================================================
   // <T>更新位图数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param bitmapInfo 位图信息
   // @param stream 数据流
   // @return 处理结果
   //============================================================
   EResult updateData(ILogicContext logicContext,
                      FGcResBitmapInfo bitmapInfo,
                      FByteStream stream);

   //============================================================
   // <T>根据资源编号删除位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param resourceId 资源编号
   // @return 处理结果
   //============================================================
   EResult doDeleteByResourceId(ILogicContext logicContext,
                                long userId,
                                long resourceId);
}
