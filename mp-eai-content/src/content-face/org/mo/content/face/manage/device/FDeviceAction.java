package org.mo.content.face.manage.device;

import com.cyou.gccloud.data.data.FDataInfoDeviceBrowserUnit;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FFatalError;
import org.mo.com.lang.RString;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.content.core.manage.device.IDeviceBrowserConsole;
import org.mo.content.face.base.FBasePage;
import org.mo.content.face.manage.home.FFrameAction;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.FLogicDataset;
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
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FFrameAction.class);

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
                           FBasePage basePage){
      _logger.debug(this, "Construct", "Construct begin. (user={1})", basePage.user());
      //      if(basePage.user() == null){
      //         return "/manage/home/Frame.wp";
      //            }
      //      System.out.println(basePage.user().ouid() + "---------------");
      return "/manage/manage/device/BrowserAccessList";
   }

   @Override
   public String select(IWebContext context,
                        ILogicContext logicContext,
                        FDevicePage devicePage,
                        FBasePage basePage){
      if(null != context.parameter("page")){
         String num = context.parameter("page");
         devicePage.setPageCurrent(Integer.parseInt(num));
      }else{
         devicePage.setPageCurrent(0);
      }
      FLogicDataset<FDataInfoDeviceBrowserUnit> unitlist = _deviceBrowserConsole.select(logicContext, devicePage.pageCurrent() - 1);
      basePage.setJson(unitlist.toJsonListString());
      return "/manage/common/ajax";
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
      FDataInfoDeviceBrowserUnit deviceBrowserInfo = _deviceBrowserConsole.doPrepare(logicContext);
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

   @Override
   public String updateBefore(IWebContext context,
                              ILogicContext logicContext,
                              FDevicePage devicePage,
                              FBasePage basePage){
      long id = context.parameterAsLong("ouid");
      devicePage.setUnit(_deviceBrowserConsole.find(logicContext, id));
      return "//manage/manage/device/BrowserAccessInfo";
   }
}
