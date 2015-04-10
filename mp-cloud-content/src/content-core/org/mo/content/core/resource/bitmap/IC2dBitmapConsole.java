package org.mo.content.core.resource.bitmap;

import org.mo.cloud.logic.resource.bitmap.FGcResBitmapInfo;
import org.mo.cloud.logic.resource.bitmap.IGcResBitmapConsole;
import org.mo.com.io.FByteStream;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容位图控制台接口。</T>
//============================================================
public interface IC2dBitmapConsole
      extends
         IGcResBitmapConsole
{
   //============================================================
   // <T>创建位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param bitmap 位图
   // @return 网格信息
   //============================================================
   FGcResBitmapInfo createBitmap(ILogicContext logicContext,
                                 FGcResBitmapInfo bitmap);

   //============================================================
   // <T>导入位图信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @param stream 数据流
   // @return 处理结果
   //============================================================
   EResult importBitmap(ILogicContext logicContext,
                        String guid,
                        FByteStream stream);
}
