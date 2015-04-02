package org.mo.content.core.resource3d.mesh;

import org.mo.cloud.logic.resource3d.mesh.FGcRs3MeshInfo;
import org.mo.cloud.logic.resource3d.mesh.IGcRs3MeshConsole;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.FLogicUnit;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>内容网格控制台接口。</T>
//============================================================
public interface IC3dMeshConsole
      extends
         IGcRs3MeshConsole
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
   FGcRs3MeshInfo createMesh(ILogicContext logicContext,
                             long userId,
                             long projectId,
                             String code,
                             String label);
}
