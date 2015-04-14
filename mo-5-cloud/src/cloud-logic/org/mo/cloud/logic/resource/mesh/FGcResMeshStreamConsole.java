package org.mo.cloud.logic.resource.mesh;

import org.mo.cloud.logic.resource.stream.IGcResStreamConsole;

import com.cyou.gccloud.data.data.FDataResourceModelMeshStreamLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.RSql;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源网格数据流控制台。</T>
//============================================================
public class FGcResMeshStreamConsole
      extends FAbstractLogicUnitConsole<FDataResourceModelMeshStreamLogic, FGcResMeshStreamInfo>
      implements
         IGcResMeshStreamConsole
{
   // 数据流管理器
   @ALink
   protected IGcResStreamConsole _streamConsole;

   //============================================================
   // <T>构造3D资源网格数据流控制台。</T>
   //============================================================
   public FGcResMeshStreamConsole(){
      super(FDataResourceModelMeshStreamLogic.class, FGcResMeshStreamInfo.class);
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
   public FGcResMeshStreamInfo findByCode(ILogicContext logicContext,
                                          long meshId,
                                          String code){
      String whereSql = "(" + FDataResourceModelMeshStreamLogic.MESH_ID + "=" + meshId + ") AND (" + FDataResourceModelMeshStreamLogic.CODE + "='" + RSql.formatValue(code) + "')";
      // 查询数据流
      FDataResourceModelMeshStreamLogic logic = findLogic(logicContext);
      FGcResMeshStreamInfo stream = logic.search(FGcResMeshStreamInfo.class, whereSql);
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
   public FLogicDataset<FGcResMeshStreamInfo> fetchByMeshId(ILogicContext logicContext,
                                                            long meshId){
      String whereSql = FDataResourceModelMeshStreamLogic.MESH_ID + "=" + meshId;
      // 查询集合
      FDataResourceModelMeshStreamLogic logic = findLogic(logicContext);
      FLogicDataset<FGcResMeshStreamInfo> dataset = logic.fetchClass(FGcResMeshStreamInfo.class, whereSql);
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
                                FGcResMeshStreamInfo unit){
      //      // 删除数据流
      //      long streamId = unit.streamId();
      //      _streamConsole.doDelete(logicContext, streamId);
      // 返回结果
      return EResult.Success;
   }
}
