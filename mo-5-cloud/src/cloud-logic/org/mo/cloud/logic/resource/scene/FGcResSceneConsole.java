package org.mo.cloud.logic.resource.scene;

import com.cyou.gccloud.data.data.FDataResourceSceneLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.data.RSql;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源场景控制台。</T>
//============================================================
public class FGcResSceneConsole
      extends FAbstractLogicUnitConsole<FDataResourceSceneLogic, FGcResSceneInfo>
      implements
         IGcResSceneConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>构造3D资源数据流控制台。</T>
   //============================================================
   public FGcResSceneConsole(){
      super(FDataResourceSceneLogic.class, FGcResSceneInfo.class);
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
   public FGcResSceneInfo findByCode(ILogicContext logicContext,
                                     long userId,
                                     long projectId,
                                     String code){
      String whereSql = "(" + FDataResourceSceneLogic.USER_ID + "=" + userId + ")";
      whereSql += " AND (" + FDataResourceSceneLogic.PROJECT_ID + "=" + projectId + ")";
      whereSql += " AND (" + FDataResourceSceneLogic.CODE + "='" + RSql.formatValue(code) + "')";
      FGcResSceneInfo scene = search(logicContext, whereSql);
      return scene;
   }
}
