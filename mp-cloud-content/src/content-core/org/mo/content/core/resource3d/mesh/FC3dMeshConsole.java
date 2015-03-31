package org.mo.content.core.resource3d.mesh;

import org.mo.cloud.logic.resource3d.mesh.FGcRs3MeshConsole;
import org.mo.cloud.logic.resource3d.mesh.FGcRs3MeshInfo;
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
}
