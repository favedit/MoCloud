package org.mo.cloud.logic.data.resource;

import com.cyou.gccloud.data.data.FDataResourceResourceLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.mongo.EGcStorageMongoCatalog;
import org.mo.cloud.core.storage.mongo.IGcStorageMongoConsole;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源信息控制台。</T>
//============================================================
public class FGcResourceConsole
      extends FAbstractLogicUnitConsole<FDataResourceResourceLogic, FGcResourceInfo>
      implements
         IGcResourceConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageMongoConsole _storageConsole;

   //============================================================
   // <T>构造资源信息控制台。</T>
   //============================================================
   public FGcResourceConsole(){
      super(FDataResourceResourceLogic.class, FGcResourceInfo.class);
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
                                 FGcResourceInfo resourceInfo){
      // 删除关联数据
      String guid = resourceInfo.guid();
      _storageConsole.delete(EGcStorageMongoCatalog.ResourcePreview, guid);
      // 返回结果
      return EResult.Success;
   }
}
