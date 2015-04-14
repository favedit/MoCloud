package org.mo.cloud.logic.resource.model;

import com.cyou.gccloud.data.data.FDataResourceModelMeshLogic;
import com.cyou.gccloud.data.data.FDataResourceModelMeshStreamLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.logic.resource.IGcResourceConsole;
import org.mo.com.data.RSql;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源网格控制台。</T>
//============================================================
public class FGcResModelMeshConsole
      extends FAbstractLogicUnitConsole<FDataResourceModelMeshLogic, FGcResModelMeshInfo>
      implements
         IGcResModelMeshConsole
{
   // 资源管理器
   @ALink
   protected IGcResourceConsole _resourceConsole;

   // 数据流管理器
   @ALink
   protected IGcResModelMeshStreamConsole _modelMeshStreamConsole;

   //============================================================
   // <T>构造3D资源网格控制台。</T>
   //============================================================
   public FGcResModelMeshConsole(){
      super(FDataResourceModelMeshLogic.class, FGcResModelMeshInfo.class);
   }

   //============================================================
   // <T>根据代码查找网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 网格信息
   //============================================================
   @Override
   public FGcResModelMeshInfo findByCode(ILogicContext logicContext,
                                         String code){
      String whereSql = FDataResourceModelMeshLogic.CODE + "='" + code + "'";
      FGcResModelMeshInfo mesh = search(logicContext, whereSql);
      return mesh;
   }

   //============================================================
   // <T>根据全代码查找网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param fullCode 全代码
   // @return 网格信息
   //============================================================
   @Override
   public FGcResModelMeshInfo findByFullCode(ILogicContext logicContext,
                                             String code){
      String whereSql = FDataResourceModelMeshLogic.FULL_CODE + "='" + code + "'";
      FGcResModelMeshInfo mesh = search(logicContext, whereSql);
      return mesh;
   }

   //============================================================
   // <T>根据用户编号和代码查找网格信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param code 项目代码
   // @return 网格信息
   //============================================================
   @Override
   public FGcResModelMeshInfo findByUserCode(ILogicContext logicContext,
                                             long userId,
                                             String code){
      String whereSql = "(" + FDataResourceModelMeshLogic.USER_ID + "=" + userId + ")";
      whereSql += " AND (" + FDataResourceModelMeshLogic.CODE + "='" + RSql.formatValue(code) + "')";
      FGcResModelMeshInfo mesh = search(logicContext, whereSql);
      return mesh;
   }

   //============================================================
   // <T>根据模型编号查找所有网格集合。</T>
   //
   // @param logicContext 逻辑环境
   // @param modelId 模型编号
   // @return 网格集合
   //============================================================
   @Override
   public FLogicDataset<FGcResModelMeshInfo> fetchByModelId(ILogicContext logicContext,
                                                            long modelId){
      String whereSql = FDataResourceModelMeshLogic.MODEL_ID + "=" + modelId;
      String orderBy = FDataResourceModelMeshLogic.SORT_INDEX + " ASC";
      // 查询集合
      FDataResourceModelMeshLogic logic = findLogic(logicContext);
      FLogicDataset<FGcResModelMeshInfo> dataset = logic.fetchClass(FGcResModelMeshInfo.class, whereSql, orderBy);
      return dataset;
   }

   //============================================================
   // <T>根据模型编号删除所有网格集合。</T>
   //
   // @param logicContext 逻辑环境
   // @param modelId 模型编号
   // @return 处理结果
   //============================================================
   @Override
   public EResult doDeleteByModelId(ILogicContext logicContext,
                                    long modelId){
      String whereSql = FDataResourceModelMeshLogic.MODEL_ID + "=" + modelId;
      // 查询集合
      FDataResourceModelMeshLogic logic = findLogic(logicContext);
      FLogicDataset<FGcResModelMeshInfo> dataset = logic.fetchClass(FGcResModelMeshInfo.class, whereSql);
      if(dataset != null){
         for(FGcResModelMeshInfo modelMesh : dataset){
            doDelete(logicContext, modelMesh);
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
                                 FGcResModelMeshInfo unit){
      long meshId = unit.ouid();
      // 删除网格数据流集合
      FDataResourceModelMeshStreamLogic modelMeshStreamLogic = logicContext.findLogic(FDataResourceModelMeshStreamLogic.class);
      String whereSql = FDataResourceModelMeshStreamLogic.MESH_ID + "=" + meshId;
      FLogicDataset<FGcResModelMeshStreamInfo> modelMeshStreamDataset = modelMeshStreamLogic.fetchClass(FGcResModelMeshStreamInfo.class, whereSql);
      if(modelMeshStreamDataset != null){
         for(FGcResModelMeshStreamInfo modelMeshStream : modelMeshStreamDataset){
            _modelMeshStreamConsole.doDelete(logicContext, modelMeshStream);
         }
      }
      // 返回结果
      return EResult.Success;
   }
}
