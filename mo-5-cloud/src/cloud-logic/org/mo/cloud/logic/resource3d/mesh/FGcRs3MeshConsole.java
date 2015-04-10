package org.mo.cloud.logic.resource3d.mesh;

import com.cyou.gccloud.data.data.FDataResource3dMeshLogic;
import com.cyou.gccloud.data.data.FDataResource3dMeshStreamLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.logic.resource.IGcResourceConsole;
import org.mo.cloud.logic.resource3d.stream.IGcRs3StreamConsole;
import org.mo.com.data.RSql;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源网格控制台。</T>
//============================================================
public class FGcRs3MeshConsole
      extends FAbstractLogicUnitConsole<FDataResource3dMeshLogic, FGcRs3MeshInfo>
      implements
         IGcRs3MeshConsole
{
   // 资源管理器
   @ALink
   protected IGcResourceConsole _resourceConsole;

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
      super(FDataResource3dMeshLogic.class, FGcRs3MeshInfo.class);
   }

   //============================================================
   // <T>根据代码查找网格单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 网格信息
   //============================================================
   @Override
   public FGcRs3MeshInfo findByCode(ILogicContext logicContext,
                                    String code){
      String searchSql = FDataResource3dMeshLogic.CODE + "='" + code + "'";
      FDataResource3dMeshLogic logic = logicContext.findLogic(FDataResource3dMeshLogic.class);
      FGcRs3MeshInfo mesh = logic.search(FGcRs3MeshInfo.class, searchSql);
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
   public FGcRs3MeshInfo findByFullCode(ILogicContext logicContext,
                                        String code){
      String searchSql = FDataResource3dMeshLogic.FULL_CODE + "='" + code + "'";
      FDataResource3dMeshLogic logic = logicContext.findLogic(FDataResource3dMeshLogic.class);
      FGcRs3MeshInfo mesh = logic.search(FGcRs3MeshInfo.class, searchSql);
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
   public FGcRs3MeshInfo findByUserCode(ILogicContext logicContext,
                                        long userId,
                                        String code){
      String whereSql = "(" + FDataResource3dMeshLogic.USER_ID + "=" + userId + ") AND (" + FDataResource3dMeshLogic.CODE + "='" + RSql.formatValue(code) + "')";
      FGcRs3MeshInfo mesh = search(logicContext, whereSql);
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
                                 FGcRs3MeshInfo unit){
      long meshId = unit.ouid();
      // 删除网格数据流集合
      FDataResource3dMeshStreamLogic meshStreamLogic = logicContext.findLogic(FDataResource3dMeshStreamLogic.class);
      String whereSql = FDataResource3dMeshStreamLogic.MESH_ID + "=" + meshId;
      FLogicDataset<FGcRs3MeshStreamInfo> meshStreamDataset = meshStreamLogic.fetchClass(FGcRs3MeshStreamInfo.class, whereSql);
      if(meshStreamDataset != null){
         for(FGcRs3MeshStreamInfo meshStreamUnit : meshStreamDataset){
            _meshStreamConsole.doDelete(logicContext, meshStreamUnit);
         }
      }
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
                                FGcRs3MeshInfo unit){
      // 删除关联资源
      long resourceId = unit.resourceId();
      if(resourceId > 0){
         _resourceConsole.doDelete(logicContext, resourceId);
      }
      // 返回结果
      return EResult.Success;
   }
}
