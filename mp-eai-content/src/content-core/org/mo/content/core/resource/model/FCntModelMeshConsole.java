package org.mo.content.core.resource.model;

import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshConsole;
import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.resource.model.mesh.IGcResModelMeshConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.FLogicUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容网格控制台。</T>
//============================================================
public class FCntModelMeshConsole
      extends FGcResModelMeshConsole
      implements
         ICntModelMeshConsole
{
   // 网格控制台接口
   @ALink
   protected IGcResModelMeshConsole _meshConsole;

   //============================================================
   // <T>获取数据处理。</T>
   //
   // @param logicContext 逻辑环境
   // @param whereSql 搜索内容
   // @param orderSql 排序内容
   // @param pageSize 页面大小
   // @param page 页面编号
   // @return 处理结果
   //============================================================
   @Override
   public FLogicDataset<FLogicUnit> list(ILogicContext logicContext,
                                         String whereSql,
                                         String orderSql,
                                         int pageSize,
                                         int page){
      FLogicDataset<FGcResModelMeshInfo> meshes = fetch(logicContext, whereSql, orderSql, pageSize, page);
      // 转换结果
      FLogicDataset<FLogicUnit> dataset = new FLogicDataset<FLogicUnit>(FLogicUnit.class);
      dataset.loadDataset(meshes);
      return dataset;
   }

   //============================================================
   // <T>创建网格信息。</T>
   //
   // @param logicContext 逻辑环境
   // @return 网格信息
   //============================================================
   @Override
   public FGcResModelMeshInfo createMesh(ILogicContext logicContext,
                                         FGcResModelMeshInfo mesh){
      //      // 创建资源对象
      //      FGcResourceInfo resource = _resourceConsole.doPrepare(logicContext);
      //      resource.setUserId(mesh.userId());
      //      resource.setProjectId(mesh.projectId());
      //      resource.setCatalogId(mesh.catalogId());
      //      resource.setResourceCd(EGcResource.Mesh);
      //      resource.setCode(mesh.code());
      //      resource.setLabel(mesh.label());
      //      _resourceConsole.doInsert(logicContext, resource);
      //      // 创建网格对象
      //      //mesh.setResourceId(resource.ouid());
      //      doInsert(logicContext, mesh);
      //      return mesh;
      return null;
   }

   //============================================================
   // <T>删除网格信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 逻辑环境
   // @param guid 逻辑环境
   // @return 处理结果
   //============================================================
   @Override
   public EResult doDeleteByGuid(ILogicContext logicContext,
                                 long userId,
                                 String guid){
      FGcResModelMeshInfo mesh = findByGuid(logicContext, guid);
      // 网格存在检查
      if(mesh == null){
         throw new FFatalError("Mesh is not exists. (guid={1})", guid);
      }
      // 检查用户
      if(mesh.userId() != userId){
         throw new FFatalError("Mesh user is not same. (user_id={1}, mesh_user_id={2})", userId, mesh.userId());
      }
      // 删除关联资源对象
      _meshConsole.doDelete(logicContext, mesh);
      doDelete(logicContext, mesh);
      return EResult.Success;
   }

   //============================================================
   // <T>删除网格信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param resourceId 资源编号
   // @return 处理结果
   //============================================================
   @Override
   public EResult doDeleteByResourceId(ILogicContext logicContext,
                                       long userId,
                                       long resourceId){
      //      FGcResModelMeshInfo mesh = findByResourceId(logicContext, resourceId);
      //      // 网格存在检查
      //      if(mesh == null){
      //         throw new FFatalError("Mesh is not exists. (resource_id={1})", resourceId);
      //      }
      //      // 检查用户
      //      if(mesh.userId() != userId){
      //         throw new FFatalError("Mesh user is not same. (user_id={1}, mesh_user_id={2})", userId, mesh.userId());
      //      }
      //      // 删除关联资源对象
      //      _meshConsole.doDelete(logicContext, mesh);
      //      doDelete(logicContext, mesh);
      return EResult.Success;
   }
}
