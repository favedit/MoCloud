package org.mo.content.engine3d.core.theme;

import com.cyou.gccloud.data.data.FDataResource3dThemeLogic;
import com.cyou.gccloud.data.data.FDataResource3dThemeUnit;
import org.mo.cloud.core.storage.IGcStorageConsole;
import org.mo.com.console.FConsole;
import org.mo.content.resource3d.common.FRs3Theme;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;

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

   //============================================================
   // <T>新建一个主题。</T>
   //
   // @param logicContext 逻辑环境
   // @param theme 主题
   // @return 主题单元
   //============================================================
   @Override
   public FDataResource3dThemeUnit insert(ILogicContext logicContext,
                                          FRs3Theme theme){
      FDataResource3dThemeLogic themeLogic = logicContext.findLogic(FDataResource3dThemeLogic.class);
      // 设置数据
      FDataResource3dThemeUnit themeUnit = themeLogic.doPrepare();
      themeUnit.setCode(theme.code());
      themeLogic.doInsert(themeUnit);
      // 返回内容
      return themeLogic.find(themeUnit.ouid());
   }
}
