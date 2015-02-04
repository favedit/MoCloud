package org.mo.content.engine3d.core.animation;

import com.cyou.gccloud.data.data.FDataResource3dTrackUnit;
import org.mo.content.resource3d.common.FRs3Track;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源动画控制台接口。</T>
//============================================================
public interface IRs3AnimationConsole
{
   //============================================================
   // <T>新建一个跟踪。</T>
   //
   // @param logicContext 逻辑环境
   // @param track 跟踪
   // @return 跟踪单元
   //============================================================
   FDataResource3dTrackUnit insertTrack(ILogicContext logicContext,
                                        FRs3Track track);
}
