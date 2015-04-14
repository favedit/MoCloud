package org.mo.content.core.resource.animation;

import org.mo.content.engine3d.core.animation.IRs3AnimationConsole;
import org.mo.content.engine3d.core.stream.IRs3StreamConsole;
import org.mo.core.aop.face.ALink;

//============================================================
// <T>模型控制台。</T>
//============================================================
public class FC3dAnimationConsole
      implements
         IC3dAnimationConsole
{
   // 存储管理接口
   @ALink
   protected IRs3StreamConsole _streamConsole;

   // 动画管理接口
   @ALink
   protected IRs3AnimationConsole _animationConsole;
}
