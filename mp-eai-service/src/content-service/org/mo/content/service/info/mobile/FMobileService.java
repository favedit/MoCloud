package org.mo.content.service.info.mobile;

import com.cyou.gccloud.define.enums.common.EGcResult;
import java.util.Map;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.logic.mobile.IMobileLogic;
import org.mo.core.aop.face.ALink;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>服务器工具服务。</T>
//============================================================
public class FMobileService
      extends FObject
      implements
         IMobileService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMobileService.class);

   @ALink
   protected IMobileLogic _mobileLogic;

   //============================================================
   // <T>默认逻辑。</T>
   //
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult process(IWebContext context,
                          IWebInput input,
                          IWebOutput output){
      _logger.debug(this, "process", "process begin. ");

      return EResult.Success;
   }

   //============================================================
   // <T>根据手机号获取相关信息。</T>
   //
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult getMobileInfo(IWebContext context,
                                IWebInput input,
                                IWebOutput output){
      _logger.debug(this, "getMobileInfo", "getMobileInfo begin. ");
      // 获得参数
      FXmlNode inputNode = input.config();
      String mobile = inputNode.nodeText("mobile");
      FXmlNode xruntime = output.config().createNode("MobileInfo");
      String status = null;
      //............................................................
      Map<String, String> mobileInfo = _mobileLogic.getMobileInfo(mobile);
      if(mobileInfo.size() == 0){
         status = EGcResult.FailString;
      }else{
         status = EGcResult.SuccessString;
         xruntime.set("province", mobileInfo.get("province"));
         xruntime.set("city", mobileInfo.get("city"));
         xruntime.set("telString", mobileInfo.get("telString"));
         xruntime.set("operators", mobileInfo.get("operators"));
      }
      // 设置数据
      xruntime.set("status", status);
      _logger.debug(this, "mobileInfo", "mobileInfo. (xruntime={1})", xruntime.toString());
      return EResult.Success;
   }
}
