package org.mo.content.service.face.mobile;

import com.cyou.gccloud.define.enums.common.EGcResult;
import net.sf.json.JSONObject;
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
   // <T>根据手机号获取相关信息。</T>
   //
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult mobileInfo(IWebContext context,
                             IWebInput input,
                             IWebOutput output){
      // 获得参数
      FXmlNode inputNode = input.config();
      String mobile = inputNode.nodeText("mobile");
      FXmlNode xruntime = output.config().createNode("MobileInfo");
      String status = null;
      //............................................................
      JSONObject mobileInfo = _mobileLogic.getMobileInfo(mobile);
      if(mobileInfo.size() == 0){
         status = EGcResult.FailString;
      }else{
         status = EGcResult.SuccessString;
         xruntime.set("province", mobileInfo.get("province"));
         xruntime.set("city", mobileInfo.get("cityname"));
         xruntime.set("telString", mobileInfo.get("mobile"));
         xruntime.set("operators", mobileInfo.get("isp"));
      }
      // 设置数据
      xruntime.set("status", status);
      _logger.debug(this, "mobileInfo", "mobileInfo. (xruntime={1})", xruntime.toString());
      return EResult.Success;
   }
}
