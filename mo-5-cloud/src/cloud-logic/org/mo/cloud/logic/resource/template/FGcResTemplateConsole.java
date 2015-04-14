package org.mo.cloud.logic.resource.template;

import com.cyou.gccloud.data.data.FDataResourceTemplateLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.data.RSql;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模板控制台。</T>
//============================================================
public class FGcResTemplateConsole
      extends FAbstractLogicUnitConsole<FDataResourceTemplateLogic, FGcResTemplateInfo>
      implements
         IGcResTemplateConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>构造3D资源数据流控制台。</T>
   //============================================================
   public FGcResTemplateConsole(){
      super(FDataResourceTemplateLogic.class, FGcResTemplateInfo.class);
   }

   //============================================================
   // <T>根据用户编号和项目编号和代码查找模板信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param userId 用户编号
   // @param projectId 项目编号
   // @param code 代码
   // @return 模板信息
   //============================================================
   @Override
   public FGcResTemplateInfo findByCode(ILogicContext logicContext,
                                        long userId,
                                        long projectId,
                                        String code){
      String whereSql = "(" + FDataResourceTemplateLogic.USER_ID + "=" + userId + ")";
      whereSql += " AND (" + FDataResourceTemplateLogic.PROJECT_ID + "=" + projectId + ")";
      whereSql += " AND (" + FDataResourceTemplateLogic.CODE + "='" + RSql.formatValue(code) + "')";
      FGcResTemplateInfo template = search(logicContext, whereSql);
      return template;
   }
}
