package org.mo.content.engine3d.core.theme;

import com.cyou.gccloud.data.data.FDataResource3dThemeUnit;
import org.mo.content.resource3d.common.FRs3Theme;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>资源主题控制台接口。</T>
//============================================================
public interface IRs3ThemeConsole
{
   //============================================================
   // <T>新建一个主题。</T>
   //
   // @param logicContext 逻辑环境
   // @param theme 主题
   // @return 主题单元
   //============================================================
   FDataResource3dThemeUnit insert(ILogicContext logicContext,
                                   FRs3Theme theme);
}
