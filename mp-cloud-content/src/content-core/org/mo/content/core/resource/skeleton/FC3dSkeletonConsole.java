package org.mo.content.core.resource.skeleton;

import org.mo.content.engine3d.core.stream.IRs3StreamConsole;
import org.mo.core.aop.face.ALink;

//============================================================
// <T>模型控制台。</T>
//============================================================
public class FC3dSkeletonConsole
      implements
         IC3dSkeletonConsole
{
   // 存储管理接口
   @ALink
   protected IRs3StreamConsole _streamConsole;
}
