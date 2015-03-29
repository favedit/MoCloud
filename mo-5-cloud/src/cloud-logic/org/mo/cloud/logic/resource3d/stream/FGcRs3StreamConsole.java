package org.mo.cloud.logic.resource3d.stream;

import com.cyou.gccloud.data.data.FDataResource3dStreamLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.cloud.core.storage.EGcStorageCatalog;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.lang.EResult;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>3D资源数据流控制台。</T>
//============================================================
public class FGcRs3StreamConsole
      extends FAbstractLogicUnitConsole<FDataResource3dStreamLogic, FGcRs3StreamUnit>
      implements
         IGcRs3StreamConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>构造3D资源数据流控制台。</T>
   //============================================================
   public FGcRs3StreamConsole(){
      super(FDataResource3dStreamLogic.class, FGcRs3StreamUnit.class);
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
                                 FGcRs3StreamUnit unit){
      // 删除关联数据
      String guid = unit.guid();
      _storageConsole.delete(EGcStorageCatalog.Resource3dStream, guid);
      // 返回结果
      return EResult.Success;
   }
}
