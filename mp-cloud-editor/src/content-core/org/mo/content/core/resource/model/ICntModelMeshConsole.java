package org.mo.content.core.resource.model;

import org.mo.cloud.logic.resource.model.mesh.FGcResModelMeshInfo;
import org.mo.cloud.logic.resource.model.mesh.IGcResModelMeshConsole;

import org.mo.com.lang.EResult;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.FLogicUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容网格控制台接口。</T>
//============================================================
public interface ICntModelMeshConsole
      extends
         IGcResModelMeshConsole
{
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
   FLogicDataset<FLogicUnit> list(ILogicContext logicContext,
                                  String whereSql,
                                  String orderSql,
                                  int pageSize,
                                  int page);

   //============================================================
   // <T>创建网格信息。</T>
   //
   // @param logicContext 逻辑环境
   // @return 网格信息
   //============================================================
   FGcResModelMeshInfo createMesh(ILogicContext logicContext,
                             FGcResModelMeshInfo mesh);

   //============================================================
   // <T>删除网格信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 逻辑环境
   // @param guid 逻辑环境
   // @return 处理结果
   //============================================================
   EResult doDeleteByGuid(ILogicContext logicContext,
                          long userId,
                          String guid);

   //============================================================
   // <T>删除网格信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param resourceId 资源编号
   // @return 处理结果
   //============================================================
   EResult doDeleteByResourceId(ILogicContext logicContext,
                                long userId,
                                long resourceId);
}
