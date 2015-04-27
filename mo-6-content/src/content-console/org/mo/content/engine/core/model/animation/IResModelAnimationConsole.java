package org.mo.content.engine.core.model.animation;

import org.mo.content.resource.common.FResAnimation;

import org.mo.cloud.logic.resource.model.animation.FGcResModelAnimationInfo;
import org.mo.cloud.logic.resource.model.animation.IGcResModelAnimationConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型动画控制台接口。</T>
//============================================================
public interface IResModelAnimationConsole
      extends
         IGcResModelAnimationConsole
{
   //============================================================
   // <T>构建动画处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param animationInfo 动画信息
   // @return 动画
   //============================================================
   FResAnimation makeAnimation(ILogicContext logicContext,
                               FGcResModelAnimationInfo animationInfo);

   //============================================================
   // <T>构建动画处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param animationId 动画编号
   // @return 动画
   //============================================================
   FResAnimation makeAnimation(ILogicContext logicContext,
                               long animationId);
}
