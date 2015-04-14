package org.mo.cloud.logic.resource.mesh;

import org.mo.cloud.logic.resource.stream.IGcResStreamConsole;

import com.cyou.gccloud.data.data.FDataResourceBitmapLogic;
import com.cyou.gccloud.data.data.FDataResourceModelMeshLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.logic.resource.IGcResourceConsole;
import org.mo.com.data.RSql;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源网格控制台。</T>
//============================================================
public class FGcResMeshConsole
      extends FAbstractLogicUnitConsole<FDataResourceModelMeshLogic, FGcResMeshInfo>
      implements
         IGcResMeshConsole
{
   // 资源管理器
   @ALink
   protected IGcResourceConsole _resourceConsole;

   // 数据流管理器
   @ALink
   protected IGcResStreamConsole _streamConsole;

   // 数据流管理器
   @ALink
   protected IGcResMeshStreamConsole _meshStreamConsole;

   //============================================================
   // <T>构造3D资源网格控制台。</T>
   //============================================================
   public FGcResMeshConsole(){
      super(FDataResourceModelMeshLogic.class, FGcResMeshInfo.class);
   }

   //============================================================
   // <T>根据资源编号查找网格信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param resourceId 资源编号
   // @return 网格信息
   //============================================================
   @Override
   public FGcResMeshInfo findByResourceId(ILogicContext logicContext,
                                          long resourceId){
      String whereSql = FDataResourceBitmapLogic.RESOURCE_ID + "=" + resourceId;
      FGcResMeshInfo mesh = search(logicContext, whereSql);
      return mesh;
   }

   //============================================================
   // <T>根据代码查找网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 网格信息
   //============================================================
   @Override
   public FGcResMeshInfo findByCode(ILogicContext logicContext,
                                    String code){
      String whereSql = FDataResourceModelMeshLogic.CODE + "='" + code + "'";
      FGcResMeshInfo mesh = search(logicContext, whereSql);
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
   public FGcResMeshInfo findByFullCode(ILogicContext logicContext,
                                        String code){
      String whereSql = FDataResourceModelMeshLogic.FULL_CODE + "='" + code + "'";
      FGcResMeshInfo mesh = search(logicContext, whereSql);
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
   public FGcResMeshInfo findByUserCode(ILogicContext logicContext,
                                        long userId,
                                        String code){
      String whereSql = "(" + FDataResourceModelMeshLogic.USER_ID + "=" + userId + ")";
      whereSql += " AND (" + FDataResourceModelMeshLogic.CODE + "='" + RSql.formatValue(code) + "')";
      FGcResMeshInfo mesh = search(logicContext, whereSql);
      return mesh;
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
                                 FGcResMeshInfo unit){
      long meshId = unit.ouid();
      // 删除网格数据流集合
      //      FDataResource3dMeshStreamLogic meshStreamLogic = logicContext.findLogic(FDataResource3dMeshStreamLogic.class);
      //      String whereSql = FDataResource3dMeshStreamLogic.MESH_ID + "=" + meshId;
      //      FLogicDataset<FGcRs3MeshStreamInfo> meshStreamDataset = meshStreamLogic.fetchClass(FGcRs3MeshStreamInfo.class, whereSql);
      //      if(meshStreamDataset != null){
      //         for(FGcRs3MeshStreamInfo meshStreamUnit : meshStreamDataset){
      //            _meshStreamConsole.doDelete(logicContext, meshStreamUnit);
      //         }
      //      }
      // 返回结果
      return EResult.Success;
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
                                FGcResMeshInfo unit){
      // 删除关联资源
      //      long resourceId = unit.resourceId();
      //      if(resourceId > 0){
      //         _resourceConsole.doDelete(logicContext, resourceId);
      //      }
      // 返回结果
      return EResult.Success;
   }
}
