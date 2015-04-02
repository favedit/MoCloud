package org.mo.content.core.resource3d.mesh;

import org.mo.cloud.logic.resource.FGcResourceInfo;
import org.mo.cloud.logic.resource.IGcResourceConsole;
import org.mo.cloud.logic.resource3d.mesh.FGcRs3MeshConsole;
import org.mo.cloud.logic.resource3d.mesh.FGcRs3MeshInfo;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.FLogicUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容网格控制台。</T>
//============================================================
public class FC3dMeshConsole
      extends FGcRs3MeshConsole
      implements
         IC3dMeshConsole
{
   // 资源控制台接口
   @ALink
   protected IGcResourceConsole _resourceConsole;

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
      FLogicDataset<FGcRs3MeshInfo> meshes = fetch(logicContext, whereSql, orderSql, pageSize, page);
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
   public FGcRs3MeshInfo createMesh(ILogicContext logicContext,
                                    long userId,
                                    long projectId,
                                    String code,
                                    String label){
      // 创建资源对象
      FGcResourceInfo resource = _resourceConsole.doPrepare(logicContext);
      resource.setUserId(userId);
      resource.setProjectId(projectId);
      //resource.setTypeId(value);
      _resourceConsole.doInsert(logicContext, resource);
      // 创建网格对象
      FGcRs3MeshInfo mesh = doPrepare(logicContext);
      mesh.setUserId(userId);
      //mesh.setCode(code);
      //mesh.setLabel(label);
      doInsert(logicContext, mesh);
      return mesh;
   }
}
