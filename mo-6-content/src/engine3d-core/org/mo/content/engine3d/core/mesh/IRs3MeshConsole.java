package org.mo.content.engine3d.core.mesh;

import com.cyou.gccloud.data.data.FDataResource3dMeshUnit;
import org.mo.content.resource3d.model.FRs3ModelMesh;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源数据流控制台接口。</T>
//============================================================
public interface IRs3MeshConsole
{
   //============================================================
   // <T>新建一个网格。</T>
   //
   // @param logicContext 逻辑环境
   // @param mesh 网格
   // @return 网格单元
   //============================================================
   FDataResource3dMeshUnit insert(ILogicContext logicContext,
                                  FRs3ModelMesh mesh);
}
