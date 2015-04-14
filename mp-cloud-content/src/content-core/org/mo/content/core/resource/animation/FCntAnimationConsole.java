package org.mo.content.core.resource.animation;

import org.mo.content.engine3d.core.model.IRs3ModelMeshStreamConsole;

import org.mo.content.engine3d.core.animation.IRs3AnimationConsole;
import org.mo.core.aop.face.ALink;

//============================================================
// <T>模型控制台。</T>
//============================================================
public class FCntAnimationConsole
      implements
         ICntAnimationConsole
{
   // 存储管理接口
   @ALink
   protected IRs3ModelMeshStreamConsole _streamConsole;

   // 动画管理接口
   @ALink
   protected IRs3AnimationConsole _animationConsole;
}
