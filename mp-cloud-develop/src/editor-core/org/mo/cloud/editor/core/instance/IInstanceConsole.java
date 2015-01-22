package org.mo.cloud.editor.core.instance;

import org.mo.cloud.editor.core.instance.common.XInstanceGroup;
import org.mo.eng.store.IXmlConfigConsole;

//============================================================
// <T>游戏实例控制台接口。</T>
//============================================================
public interface IInstanceConsole
      extends
         IXmlConfigConsole<XInstanceGroup>
{
   //============================================================
   // <T>建立代码。</T>
   //
   // @param typeCd 类型
   //============================================================
   void buildSource(EInstanceSource typeCd);
}
