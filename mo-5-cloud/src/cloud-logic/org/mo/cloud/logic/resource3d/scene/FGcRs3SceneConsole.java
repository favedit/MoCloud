package org.mo.cloud.logic.resource3d.scene;

import com.cyou.gccloud.data.data.FDataResource3dSceneLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.data.RSql;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源场景控制台。</T>
//============================================================
public class FGcRs3SceneConsole
      extends FAbstractLogicUnitConsole<FDataResource3dSceneLogic, FGcRs3SceneInfo>
      implements
         IGcRs3SceneConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>构造3D资源数据流控制台。</T>
   //============================================================
   public FGcRs3SceneConsole(){
      super(FDataResource3dSceneLogic.class, FGcRs3SceneInfo.class);
   }

   //============================================================
   // <T>根据用户编号和项目编号和代码查找场景信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param projectId 项目编号
   // @param code 场景代码
   // @return 场景信息
   //============================================================
   @Override
   public FGcRs3SceneInfo findByCode(ILogicContext logicContext,
                                     long userId,
                                     long projectId,
                                     String code){
      String whereSql = "(" + FDataResource3dSceneLogic.USER_ID + "=" + userId + ")";
      whereSql += " AND (" + FDataResource3dSceneLogic.PROJECT_ID + "=" + projectId + ")";
      whereSql += " AND (" + FDataResource3dSceneLogic.CODE + "='" + RSql.formatValue(code) + "')";
      FGcRs3SceneInfo scene = search(logicContext, whereSql);
      return scene;
   }
}
