package org.mo.cloud.logic.resource3d.mesh;

import org.mo.cloud.logic.resource3d.stream.IGcRs3StreamConsole;

import com.cyou.gccloud.data.data.FDataResource3dMeshStreamLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源网格数据流控制台。</T>
//============================================================
public class FGcRs3MeshStreamConsole
      extends FAbstractLogicUnitConsole<FDataResource3dMeshStreamLogic, FGcRs3MeshStreamUnit>
      implements
         IGcRs3MeshStreamConsole
{
   // 数据流管理器
   @ALink
   protected IGcRs3StreamConsole _streamConsole;

   //============================================================
   // <T>构造3D资源网格数据流控制台。</T>
   //============================================================
   public FGcRs3MeshStreamConsole(){
      super(FDataResource3dMeshStreamLogic.class, FGcRs3MeshStreamUnit.class);
   }

   //============================================================
   // <T>删除记录后处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult onDeleteAfter(ILogicContext logicContext,
                                FGcRs3MeshStreamUnit unit){
      // 删除数据流
      long streamId = unit.streamId();
      _streamConsole.doDelete(logicContext, streamId);
      // 返回结果
      return EResult.Success;
   }
}
