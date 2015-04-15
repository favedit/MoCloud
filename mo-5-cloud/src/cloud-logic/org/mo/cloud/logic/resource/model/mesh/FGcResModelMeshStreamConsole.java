package org.mo.cloud.logic.resource.model.mesh;

import com.cyou.gccloud.data.data.FDataResourceModelMeshStreamLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.data.RSql;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源网格数据流控制台。</T>
//============================================================
public class FGcResModelMeshStreamConsole
      extends FAbstractLogicUnitConsole<FDataResourceModelMeshStreamLogic, FGcResModelMeshStreamInfo>
      implements
         IGcResModelMeshStreamConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>构造3D资源网格数据流控制台。</T>
   //============================================================
   public FGcResModelMeshStreamConsole(){
      super(FDataResourceModelMeshStreamLogic.class, FGcResModelMeshStreamInfo.class);
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
   public FGcResModelMeshStreamInfo findByCode(ILogicContext logicContext,
                                               long meshId,
                                               String code){
      String whereSql = "(" + FDataResourceModelMeshStreamLogic.MESH_ID + "=" + meshId + ") AND (" + FDataResourceModelMeshStreamLogic.CODE + "='" + RSql.formatValue(code) + "')";
      // 查询数据流
      FDataResourceModelMeshStreamLogic logic = findLogic(logicContext);
      FGcResModelMeshStreamInfo stream = logic.search(FGcResModelMeshStreamInfo.class, whereSql);
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
   public FLogicDataset<FGcResModelMeshStreamInfo> fetchByMeshId(ILogicContext logicContext,
                                                                 long meshId){
      String whereSql = FDataResourceModelMeshStreamLogic.MESH_ID + "=" + meshId;
      String orderBy = FDataResourceModelMeshStreamLogic.SORT_INDEX + " ASC";
      // 查询集合
      FDataResourceModelMeshStreamLogic logic = findLogic(logicContext);
      FLogicDataset<FGcResModelMeshStreamInfo> dataset = logic.fetchClass(FGcResModelMeshStreamInfo.class, whereSql, orderBy);
      return dataset;
   }

   //============================================================
   // <T>根据网格编号删除所有网格数据流集合。</T>
   //
   // @param logicContext 逻辑环境
   // @param modelMeshId 模型网格编号
   // @return 处理结果
   //============================================================
   @Override
   public EResult doDeleteByMeshId(ILogicContext logicContext,
                                   long modelMeshId){
      String whereSql = FDataResourceModelMeshStreamLogic.MESH_ID + "=" + modelMeshId;
      // 查询集合
      FDataResourceModelMeshStreamLogic logic = findLogic(logicContext);
      FLogicDataset<FGcResModelMeshStreamInfo> dataset = logic.fetchClass(FGcResModelMeshStreamInfo.class, whereSql);
      if(dataset != null){
         for(FGcResModelMeshStreamInfo modelMeshStream : dataset){
            doDelete(logicContext, modelMeshStream);
         }
      }
      return EResult.Success;
   }

   //============================================================
   // <T>删除记录前处理</T>
   //
   // @param logicContext 逻辑环境
   // @param unit 数据单元
   // @return 处理结果
   //============================================================
   @Override
   public EResult onDeleteBefore(ILogicContext logicContext,
                                 FGcResModelMeshStreamInfo unit){
      // 删除关联数据
      String guid = unit.guid();
      _storageConsole.delete(EGcStorageCatalog.ResourceModelMeshStream, guid);
      // 返回结果
      return EResult.Success;
   }
}
