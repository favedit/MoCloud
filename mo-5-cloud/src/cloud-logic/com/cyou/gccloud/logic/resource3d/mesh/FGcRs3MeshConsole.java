package com.cyou.gccloud.logic.resource3d.mesh;

import com.cyou.gccloud.data.data.FDataResource3dMeshLogic;
import com.cyou.gccloud.data.data.FDataResource3dMeshStreamLogic;
import com.cyou.gccloud.logic.resource3d.stream.IGcRs3StreamConsole;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源网格控制台。</T>
//============================================================
public class FGcRs3MeshConsole
      extends FAbstractLogicUnitConsole<FDataResource3dMeshLogic, FGcRs3MeshUnit>
      implements
         IGcRs3MeshConsole
{
   // 数据流管理器
   @ALink
   protected IGcRs3StreamConsole _streamConsole;

   // 数据流管理器
   @ALink
   protected IGcRs3MeshStreamConsole _meshStreamConsole;

   //============================================================
   // <T>构造3D资源网格控制台。</T>
   //============================================================
   public FGcRs3MeshConsole(){
      super(FDataResource3dMeshLogic.class, FGcRs3MeshUnit.class);
   }

   //============================================================
   // <T>根据代码查找网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 网格单元
   //============================================================
   @Override
   public FGcRs3MeshUnit findByCode(ILogicContext logicContext,
                                    String code){
      String searchSql = FDataResource3dMeshLogic.CODE + "='" + code + "'";
      FDataResource3dMeshLogic logic = logicContext.findLogic(FDataResource3dMeshLogic.class);
      FGcRs3MeshUnit unit = logic.search(FGcRs3MeshUnit.class, searchSql);
      return unit;
   }

   //============================================================
   // <T>根据全代码查找网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param fullCode 全代码
   // @return 网格单元
   //============================================================
   @Override
   public FGcRs3MeshUnit findByFullCode(ILogicContext logicContext,
                                        String code){
      String searchSql = FDataResource3dMeshLogic.FULL_CODE + "='" + code + "'";
      FDataResource3dMeshLogic logic = logicContext.findLogic(FDataResource3dMeshLogic.class);
      FGcRs3MeshUnit unit = logic.search(FGcRs3MeshUnit.class, searchSql);
      return unit;
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
                                 FGcRs3MeshUnit unit){
      long meshId = unit.ouid();
      // 删除网格数据流集合
      FDataResource3dMeshStreamLogic meshStreamLogic = logicContext.findLogic(FDataResource3dMeshStreamLogic.class);
      String whereSql = FDataResource3dMeshStreamLogic.MESH_ID + "=" + meshId;
      FLogicDataset<FGcRs3MeshStreamUnit> meshStreamDataset = meshStreamLogic.fetchClass(FGcRs3MeshStreamUnit.class, whereSql);
      if(meshStreamDataset != null){
         for(FGcRs3MeshStreamUnit meshStreamUnit : meshStreamDataset){
            _meshStreamConsole.doDelete(logicContext, meshStreamUnit);
         }
      }
      // 返回结果
      return EResult.Success;
   }
}
