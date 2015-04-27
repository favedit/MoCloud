package org.mo.content.core.resource.skeleton;

import org.mo.content.engine.core.model.IResModelMeshStreamConsole;

import org.mo.core.aop.face.ALink;

//============================================================
// <T>模型控制台。</T>
//============================================================
public class FCntSkeletonConsole
      implements
         ICntSkeletonConsole
{
   // 存储管理接口
   @ALink
   protected IResModelMeshStreamConsole _streamConsole;
}
