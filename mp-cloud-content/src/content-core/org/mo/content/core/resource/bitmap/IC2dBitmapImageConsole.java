package org.mo.content.core.resource.bitmap;

import org.mo.cloud.logic.resource.bitmap.IGcResBitmapImageConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容纹理控制台接口。</T>
//============================================================
public interface IC2dBitmapImageConsole
      extends
         IGcResBitmapImageConsole
{
   //============================================================
   // <T>生成位图预览数据。</T>
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
}
