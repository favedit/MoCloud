package org.mo.content.service.info.mobile;

import com.cyou.gccloud.define.enums.common.EGcResult;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FAttributes;
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
      FXmlNode list = output.config().createNode("MobileInfoList");
      //获取所有手机号
      for(FXmlNode node : inputNode.allNodes()){
         String mobile = node.text();
         String status = null;
         FXmlNode xruntime = list.createNode("MobileInfo");
         FAttributes mobileInfo = _mobileLogic.getMobileInfo(mobile);
         if(mobileInfo.isEmpty()){
            status = EGcResult.FailString;
            xruntime.set("phone", mobile);
         }else{
            status = EGcResult.SuccessString;
            xruntime.set("phone", mobileInfo.get("telString"));
            xruntime.set("province", mobileInfo.get("province"));
            xruntime.set("city", mobileInfo.get("city"));
            xruntime.set("operators", mobileInfo.get("operators"));
         }
         // 设置数据
         xruntime.set("status_cd", status);
      }

      _logger.debug(this, "getMobileInfo", "getMobileInfo finish. (list={1})", list.toString());
      return EResult.Success;
   }
}
