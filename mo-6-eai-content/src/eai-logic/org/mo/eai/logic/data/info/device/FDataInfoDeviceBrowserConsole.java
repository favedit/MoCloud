package org.mo.eai.logic.data.info.device;

import com.cyou.gccloud.data.data.FDataInfoDeviceBrowserLogic;
import org.mo.cloud.core.database.FAbstractLogicUnitConsole;
import org.mo.com.data.RSql;
import org.mo.data.logic.ILogicContext;

//============================================================
// <T>数据信息设备浏览器信息控制台。</T>
//============================================================
public class FDataInfoDeviceBrowserConsole
      extends FAbstractLogicUnitConsole<FDataInfoDeviceBrowserLogic, FDataInfoDeviceBrowser>
      implements
         IDataInfoDeviceBrowserConsole
{
   //============================================================
   // <T>构造数据信息设备浏览器信息控制台。</T>
   //============================================================
   public FDataInfoDeviceBrowserConsole(){
      super(FDataInfoDeviceBrowserLogic.class, FDataInfoDeviceBrowser.class);
   }

   //============================================================
   // <T>根据鉴定码查找浏览信息。</T>
   //
   // @param logicContext 逻辑环境
   // @param identityCode 鉴定码
   // @return 浏览信息
   //============================================================
   @Override
   public FDataInfoDeviceBrowser findByIdentityCode(ILogicContext logicContext,
                                                    String identityCode){
      String whereSql = FDataInfoDeviceBrowserLogic.IDENTITY_CODE + "='" + RSql.formatValue(identityCode) + "'";
      FDataInfoDeviceBrowser browser = search(logicContext, whereSql);
      return browser;
   }
}
