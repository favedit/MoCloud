package org.mo.content.core.resource3d.resource;

import org.mo.cloud.logic.resource.bitmap.IGcResBitmapConsole;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容图片控制台接口。</T>
//============================================================
public interface IC3dResourceConsole
      extends
         IGcResBitmapConsole
{
   //============================================================
   // <T>查找预览数据。</T>
   //
   // @param context 逻辑环境
   // @param typeCd 类型
   // @param guid 唯一编号
   // @return 数据
   //============================================================
   byte[] findPreviewData(ILogicContext context,
                          String typeCd,
                          String guid);

   //============================================================
   // <T>上传预览数据。</T>
   //
   // @param context 逻辑环境
   // @param typeCd 类型
   // @param guid 唯一编号
   // @param data 数据
   // @return 处理结果
   //============================================================
   EResult uploadPreviewData(ILogicContext context,
                             String typeCd,
                             String guid,
                             byte[] data);
}
