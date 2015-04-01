package org.mo.cloud.logic.resource3d.mesh;

import com.cyou.gccloud.data.data.FDataResource3dMeshStreamLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.logic.resource3d.stream.IGcRs3StreamConsole;
import org.mo.com.data.RSql;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源网格数据流控制台。</T>
//============================================================
public class FGcRs3MeshStreamConsole
      extends FAbstractLogicUnitConsole<FDataResource3dMeshStreamLogic, FGcRs3MeshStreamInfo>
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
      super(FDataResource3dMeshStreamLogic.class, FGcRs3MeshStreamInfo.class);
   }

   //============================================================
   // <T>根据网格编号和代码查找数据流。</T>
   //
   // @param logicContext 逻辑环境
   // @param meshId 网格编号
   // @param code 代码
   // @return 网格数据流
   //============================================================
   @Override
   public FGcRs3MeshStreamInfo findByCode(ILogicContext logicContext,
                                          long meshId,
                                          String code){
      String whereSql = "(" + FDataResource3dMeshStreamLogic.MESH_ID + "=" + meshId + ") AND (" + FDataResource3dMeshStreamLogic.CODE + "='" + RSql.formatValue(code) + "')";
      // 查询数据流
      FDataResource3dMeshStreamLogic logic = findLogic(logicContext);
      FGcRs3MeshStreamInfo stream = logic.search(FGcRs3MeshStreamInfo.class, whereSql);
      return stream;
   }

   //============================================================
   // <T>根据网格编号查找所有网格数据流集合。</T>
   //
   // @param logicContext 逻辑环境
   // @param meshId 网格编号
   // @return 网格数据流集合
   //============================================================
   @Override
   public FLogicDataset<FGcRs3MeshStreamInfo> fetchByMeshId(ILogicContext logicContext,
                                                            long meshId){
      String whereSql = FDataResource3dMeshStreamLogic.MESH_ID + "=" + meshId;
      // 查询集合
      FDataResource3dMeshStreamLogic logic = findLogic(logicContext);
      FLogicDataset<FGcRs3MeshStreamInfo> dataset = logic.fetchClass(FGcRs3MeshStreamInfo.class, whereSql);
      return dataset;
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
                                FGcRs3MeshStreamInfo unit){
      // 删除数据流
      long streamId = unit.streamId();
      _streamConsole.doDelete(logicContext, streamId);
      // 返回结果
      return EResult.Success;
   }
}
