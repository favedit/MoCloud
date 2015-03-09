package org.mo.content.core.resource3d.texture;

import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.core.aop.face.ALink;

//============================================================
// <T>模型控制台。</T>
//============================================================
public class FC3dBitmapConsole
      implements
         IC3dBitmapConsole
{
   // 存储管理接口
   @ALink
   protected IGcStorageConsole _storageConsole;
}
