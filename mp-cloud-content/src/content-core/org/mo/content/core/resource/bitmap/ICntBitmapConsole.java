package org.mo.content.core.resource.bitmap;

import org.mo.cloud.logic.resource.bitmap.FGcResBitmapInfo;
import org.mo.cloud.logic.resource.bitmap.IGcResBitmapConsole;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容位图控制台接口。</T>
//============================================================
public interface ICntBitmapConsole
      extends
         IGcResBitmapConsole
{
   //============================================================
   // <T>生成位图数据。</T>
   //
   // @param context 逻辑环境
   // @param guid 唯一编号
   // @return 数据
   //============================================================
   byte[] makeViewData(ILogicContext context,
                       String guid);

   //============================================================
   // <T>生成位图预览数据。</T>
   //
   // @param context 逻辑环境
   // @param guid 唯一编号
   // @return 数据
   //============================================================
   byte[] makePreviewData(ILogicContext context,
                          String guid);

   //============================================================
   // <T>更新位图数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param bitmap 位图信息
   // @param stream 数据流
   // @return 处理结果
   //============================================================
   EResult updateData(ILogicContext logicContext,
                      FGcResBitmapInfo bitmap,
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
