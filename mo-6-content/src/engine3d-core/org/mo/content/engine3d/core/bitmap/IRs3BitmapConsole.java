package org.mo.content.engine3d.core.bitmap;

import org.mo.cloud.logic.resource.bitmap.FGcResBitmapInfo;
import org.mo.cloud.logic.resource.bitmap.IGcResBitmapConsole;
import org.mo.cloud.logic.system.FGcSessionInfo;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.image.FImage;

//============================================================
// <T>资源模型控制台接口。</T>
//============================================================
public interface IRs3BitmapConsole
      extends
         IGcResBitmapConsole
{
   //============================================================
   // <T>更新资源处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param bitmapInfo 位图信息
   // @param bitmap 位图
   // @return 处理结果
   //============================================================
   EResult updateResource(ILogicContext logicContext,
                          FGcResBitmapInfo bitmapInfo,
                          FImage bitmap);

   //============================================================
   // <T>导入资源。</T>
   //
   // @param logicContext 逻辑环境
   // @param session 会话信息
   // @param path 路径
   // @return 处理结果
   //============================================================
   EResult importResource(ILogicContext logicContext,
                          FGcSessionInfo session,
                          String path);
}
