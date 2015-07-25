package org.mo.eai.logic.data.info.device;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>数据信息设备浏览器信息接口。</T>
//============================================================
public interface IDataInfoDeviceBrowserConsole
      extends
         IAbstractLogicUnitConsole<FDataInfoDeviceBrowser>
{
   //============================================================
   // <T>根据鉴定码查找浏览信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param identityCode 鉴定码
   // @return 浏览信息
   //============================================================
   FDataInfoDeviceBrowser findByIdentityCode(ILogicContext logicContext,
                                             String identityCode);
}
