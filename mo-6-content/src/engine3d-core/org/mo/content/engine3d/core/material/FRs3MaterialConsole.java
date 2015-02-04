package org.mo.content.engine3d.core.material;

import com.cyou.gccloud.data.data.FDataResource3dModelLogic;
import com.cyou.gccloud.data.data.FDataResource3dModelUnit;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.console.FConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台。</T>
//============================================================
public class FRs3MaterialConsole
      extends FConsole
      implements
         IRs3MaterialConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>根据代码查找模型单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param code 代码
   // @return 处理结果
   //============================================================
   @Override
   public FDataResource3dModelUnit findByCode(ILogicContext logicContext,
                                              String code){
      String searchSql = FDataResource3dModelLogic.CODE + "='" + code + "'";
      FDataResource3dModelLogic modelLogic = logicContext.findLogic(FDataResource3dModelLogic.class);
      FDataResource3dModelUnit modelUnit = modelLogic.search(searchSql);
      return modelUnit;
   }
}
