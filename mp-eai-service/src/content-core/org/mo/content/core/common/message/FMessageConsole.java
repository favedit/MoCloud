package org.mo.content.core.common.message;

import com.jianzhou.sdk.BusinessService;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;

//============================================================
// <T>建周短信发送控制台。</T>
//============================================================
public class FMessageConsole
      extends FObject
      implements
         IMessageConsole
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FMessageConsole.class);

   // 调用建周短信平台的webservice地址
   private String webServiceURL = "http://www.jianzhou.sh.cn/JianzhouSMSWSServer/services/BusinessService";

   // 企业用户名
   private String passport1 = "sdk_yucheng";

   // 密码
   private String password1 = "1qazxsw2";

   // 签名
   private String sign = "【钰诚办公平台】";

   // private String passport2 = "yucheng";
   // private String password2 = "1a2s3dqwe";

   // ============================================================
   // <T>构造资源</T>
   // ============================================================
   public FMessageConsole(){

   }

   // ============================================================
   // <T>短信发送</T>
   // @param mobile 手机号
   // @param msgText 短信内容
   // @return 短信处理结果
   // ============================================================
   @Override
   public int sendBatchMessage(String mobile,
                               String msgText){
      _logger.debug(this, "sendBatchMessage", "sendBatchMessage begin. mobile={1},msgText={2}", mobile, msgText);
      BusinessService bs = new BusinessService();
      bs.setWebService(webServiceURL);
      int result = bs.sendBatchMessage(passport1, password1, mobile, msgText + sign);
      return result;
   }
}
