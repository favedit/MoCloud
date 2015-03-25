package org.mo.content.engine3d.core.mesh;

import com.cyou.gccloud.data.data.FDataResource3dMeshUnit;
import org.mo.com.lang.EResult;
import org.mo.content.resource3d.mesh.FRs3Mesh;
import org.mo.content.resource3d.model.FRs3ModelMesh;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源数据流控制台接口。</T>
//============================================================
public interface IRs3MeshConsole
{
   //============================================================
   // <T>根据代码查找网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 网格单元
   //============================================================
   FDataResource3dMeshUnit findByGuid(ILogicContext logicContext,
                                      String guid);

   //============================================================
   // <T>根据代码查找网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 网格单元
   //============================================================
   FDataResource3dMeshUnit findByCode(ILogicContext logicContext,
                                      String code);

   //============================================================
   // <T>新建网格。</T>
   //
   // @param logicContext 逻辑环境
   // @param mesh 网格
   // @return 网格单元
   //============================================================
   FDataResource3dMeshUnit insert(ILogicContext logicContext,
                                  FRs3ModelMesh mesh);

   //============================================================
   // <T>更新网格。</T>
   //
   // @param logicContext 逻辑环境
   // @param mesh 网格
   // @return 网格单元
   //============================================================
   FDataResource3dMeshUnit updateMesh(ILogicContext logicContext,
                                      FRs3Mesh mesh);

   //============================================================
   // <T>生成资源网格。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 资源网格
   //============================================================
   FRs3Mesh makeMesh(ILogicContext logicContext,
                     String guid);

   //============================================================
   // <T>生成资源网格数据。</T>
   //
   // @param logicContext 逻辑环境
   // @param guid 唯一编号
   // @return 资源网格数据
   //============================================================
   byte[] makeMeshData(ILogicContext logicContext,
                       String guid);

   //============================================================
   // <T>导入PLY模型。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @param fileName 文件名称
   // @return 处理结果
   //============================================================
   EResult importMeshPly(ILogicContext logicContext,
                         String code,
                         String fileName);
}
