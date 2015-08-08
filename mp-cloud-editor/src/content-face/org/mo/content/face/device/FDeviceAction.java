package org.mo.content.face.device;

import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.content.core.device.FDeviceBrowserInfo;
import org.mo.content.core.device.IDeviceBrowserConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
// <P>接口。</P>
//
// @author sunhr
// @version 150718
//============================================================
public class FDeviceAction
      implements
         IDeviceAction
{

   //用户控制台
   @ALink
   protected IDeviceBrowserConsole _deviceBrowserConsole;

   //============================================================
   // <T>默认逻辑处理。</T>
   //
   // @param context 页面环境
   // @param page 页面
   //============================================================
   @Override
   public String construct(IWebContext context,
                           ILogicContext logicContext,
                           FDevicePage areaPage){
      return "/Index";
   }

   @Override
   public String putMobileInfo(IWebContext context,
                               ILogicContext logicContext,
                               FDevicePage page){
      String agentCode = context.parameter("agentCode");
      if(RString.isEmpty(agentCode)){
         throw new FFatalError("agentCode is empty.");
         //         page.setResult("userAgent is empty!");
      }
      String capability = context.parameter("capability");
      if(RString.isEmpty(capability)){
         throw new FFatalError("deviceBrowserInfo is empty.");
         //         page.setResult("deviceBrowserInfo is empty!");
      }
      FDeviceBrowserInfo deviceBrowserInfo = _deviceBrowserConsole.doPrepare(logicContext);
      deviceBrowserInfo.setAgentCode(agentCode);
      deviceBrowserInfo.setContent(capability);
      EResult result = _deviceBrowserConsole.insert(logicContext, deviceBrowserInfo);
      if(result.equals(EResult.Success)){
         page.setResult("Success");
      }else{
         throw new FFatalError("insert Failure.");
         //         page.setResult("Failure");
      }

      return "/";
   }
}
