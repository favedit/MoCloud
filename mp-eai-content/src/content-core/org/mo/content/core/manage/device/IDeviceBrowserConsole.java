package org.mo.content.core.manage.device;

import com.cyou.gccloud.data.data.FDataInfoDeviceBrowserUnit;
import org.mo.cloud.core.database.IAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.data.logic.FLogicDataset;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>设备控制台接口。</T>
//============================================================
public interface IDeviceBrowserConsole
      extends
         IAbstractLogicUnitConsole<FDataInfoDeviceBrowserUnit>
{
   //============================================================
   // <T>插入设备信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param deviceBrowserInfo 设备信息
   // @return 插入结果
   //============================================================
   EResult insert(ILogicContext logicContext,
                  FDataInfoDeviceBrowserUnit deviceBrowserInfo);

   FLogicDataset<FDataInfoDeviceBrowserUnit> select(ILogicContext logicContext,
                                                    int pageNum);
}
