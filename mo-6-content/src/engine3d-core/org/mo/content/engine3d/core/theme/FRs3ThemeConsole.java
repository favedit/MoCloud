package org.mo.content.engine3d.core.theme;

import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.console.FConsole;
import org.mo.core.aop.face.ALink;

//============================================================
// <T>资源主题控制台。</T>
//============================================================
public class FRs3ThemeConsole
      extends FConsole
      implements
         IRs3ThemeConsole
{
   // 存储控制台
   @ALink
   protected IGcStorageConsole _storageConsole;

   //   //============================================================
   //   // <T>新建一个主题。</T>
   //   //
   //   // @param logicContext 逻辑环境
   //   // @param theme 主题
   //   // @return 主题单元
   //   //============================================================
   //   @Override
   //   public FDataResource3dThemeUnit insert(ILogicContext logicContext,
   //                                          FRs3Theme theme){
   //      FDataResource3dThemeLogic themeLogic = logicContext.findLogic(FDataResource3dThemeLogic.class);
   //      // 设置数据
   //      FDataResource3dThemeUnit themeUnit = themeLogic.doPrepare();
   //      themeUnit.setCode(theme.code());
   //      themeUnit.setLabel(theme.label());
   //      themeLogic.doInsert(themeUnit);
   //      // 返回内容
   //      return themeLogic.find(themeUnit.ouid());
   //   }
}
