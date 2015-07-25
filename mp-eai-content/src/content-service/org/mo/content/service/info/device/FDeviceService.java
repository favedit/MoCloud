package org.mo.content.service.info.device;

import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.xml.FXmlNode;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.eai.logic.data.info.device.FDataInfoDeviceBrowser;
import org.mo.eai.logic.data.info.device.IDataInfoDeviceBrowserConsole;
import org.mo.eai.logic.logger.info.browser.FLoggerInfoBrowserAccess;
import org.mo.eai.logic.logger.info.browser.ILoggerInfoBrowserAccessConsole;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>信息设备数据服务。</T>
//============================================================
public class FDeviceService
      extends FObject
      implements
         IDeviceService
{
   @ALink
   protected IDataInfoDeviceBrowserConsole _deviceBrowserConsole;

   @ALink
   protected ILoggerInfoBrowserAccessConsole _browserAccessConsole;

   //============================================================
   // <T>构造资源3D服务。</T>
   //============================================================
   public FDeviceService(){
   }

   //============================================================
   // <T>登录信息处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult access(IWebContext context,
                         ILogicContext logicContext,
                         IWebInput input,
                         IWebOutput output){
      // 获得信息
      String identityCode = input.config().get("identity_code");
      FXmlNode xbrowser = input.config().findNode("Browser");
      // 插入记录
      FDataInfoDeviceBrowser browser = _deviceBrowserConsole.findByIdentityCode(logicContext, identityCode);
      if(browser == null){
         browser = _deviceBrowserConsole.doPrepare(logicContext);
         browser.setAgentCode(xbrowser.nodeText("Agent"));
         browser.setIdentityCode(identityCode);
         browser.setContent(xbrowser.xml().toString());
         _deviceBrowserConsole.doInsert(logicContext, browser);
      }
      // 插入日志
      FLoggerInfoBrowserAccess access = _browserAccessConsole.doPrepare(logicContext);
      access.setBrowserId(browser.ouid());
      _browserAccessConsole.doInsert(logicContext, access);
      // 获得参数
      return EResult.Success;
   }
}
