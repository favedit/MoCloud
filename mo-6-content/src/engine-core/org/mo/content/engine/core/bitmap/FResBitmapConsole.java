package org.mo.content.engine.core.bitmap;

import com.cyou.gccloud.data.data.FDataResourceBitmapLogic;
import com.cyou.gccloud.data.data.FDataResourceBitmapUnit;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.console.FConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源模型控制台。</T>
//============================================================
public class FResBitmapConsole
      extends FConsole
      implements
         IResBitmapConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //============================================================
   // <T>根据代码查找位图单元。</T>
   //
   // @param logicContext 逻辑环境
   // @param bitmapId 位图编号
   // @return 位图单元
   //============================================================
   @Override
   public FDataResourceBitmapUnit find(ILogicContext logicContext,
                                       long bitmapId){
      FDataResourceBitmapLogic bitmapLogic = logicContext.findLogic(FDataResourceBitmapLogic.class);
      FDataResourceBitmapUnit bitmapUnit = bitmapLogic.find(bitmapId);
      return bitmapUnit;
   }
}
