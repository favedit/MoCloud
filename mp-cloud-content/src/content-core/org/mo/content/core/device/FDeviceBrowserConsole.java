package org.mo.content.core.device;

import com.cyou.gccloud.data.data.FDataInfoDeviceBrowserLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.lang.EResult;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>设备控制台。</T>
//============================================================
public class FDeviceBrowserConsole
      extends FAbstractLogicUnitConsole<FDataInfoDeviceBrowserLogic, FDeviceBrowserInfo>
      implements
         IDeviceBrowserConsole
{
   //============================================================
   // <T>构造设备控制台。</T>
   //============================================================
   public FDeviceBrowserConsole(){
      super(FDataInfoDeviceBrowserLogic.class, FDeviceBrowserInfo.class);
   }

   //============================================================
   // <T>插入设备信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param deviceBrowserInfo 设备信息
   // @return 插入结果
   //============================================================
   @Override
   public EResult insert(ILogicContext logicContext,
                         FDeviceBrowserInfo deviceBrowserInfo){
      EResult resultCd = doInsert(logicContext, deviceBrowserInfo);
      return resultCd;
   }
}
