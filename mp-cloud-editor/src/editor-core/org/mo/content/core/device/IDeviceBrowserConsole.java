package org.mo.content.core.device;

import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>设备控制台接口。</T>
//============================================================
public interface IDeviceBrowserConsole
      extends
         IAbstractLogicUnitConsole<FDeviceBrowserInfo>
{
   //============================================================
   // <T>插入设备信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param deviceBrowserInfo 设备信息
   // @return 插入结果
   //============================================================
   EResult insert(ILogicContext logicContext,
                  FDeviceBrowserInfo deviceBrowserInfo);
}
