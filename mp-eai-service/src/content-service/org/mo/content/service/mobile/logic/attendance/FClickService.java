package org.mo.content.service.mobile.logic.attendance;

import com.cyou.gccloud.data.data.FDataPersonUserSigningUnit;
import java.util.Date;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.mobile.logic.attendance.IClickConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>打卡服务。</T>
//============================================================
public class FClickService
      extends FObject
      implements
         IClickService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FClickService.class);

   //打卡逻辑控制台
   @ALink
   protected IClickConsole _clickConsole;

   //GcSession会话控制台
   @ALink
   protected IGcSessionConsole _gcSessionConsole;

   //============================================================
   // <T>默认逻辑。</T>
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
   // <T>打卡服务接口。</T>
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   //============================================================
   @Override
   public EResult sign(IWebContext context,
                       IWebSession sessionContext,
                       IWebInput input,
                       IWebOutput output,
                       ILogicContext logicContext){
      FXmlNode inputNode = input.config();
      FXmlNode locationLongitudeNode = inputNode.findNode("locationlongitude");
      FXmlNode locationLatitudeNode = inputNode.findNode("locationlatitude");
      String sessionCode = context.head("mo-session-id");
      String locationLongitude = locationLongitudeNode.text();
      String locationLatitude = locationLatitudeNode.text();
      _logger.debug(this, "click--------------------------------->", "userguid={1},locationlongitude={3},locationlatitude={4}", sessionCode, locationLongitude, locationLatitude);
      //所有的参数不能为空
      if("".equals(sessionCode) || "".equals(locationLongitude) || "".equals(locationLatitude)){
         return EResult.Failure;
      }
      //经纬度只能是正数(小数或整数)
      String pattern = "[0-9]+(.[0-9]+)?";
      boolean isLongitude = locationLongitude.matches(pattern);
      boolean isLatitude = locationLatitude.matches(pattern);
      if(!isLongitude || !isLatitude){
         return EResult.Failure;
      }
      double locationLongitudeD = Double.parseDouble(locationLongitude);
      double locationLatitudeD = Double.parseDouble(locationLatitude);
      FDataPersonUserSigningUnit singUser = new FDataPersonUserSigningUnit();
      FGcSessionInfo sessionInfo = _gcSessionConsole.findBySessionCode(logicContext, "eai", "mobile_android", sessionCode);
      long userId = -1;
      if(sessionInfo != null){
         FXmlNode last_sign_date = output.config().createNode("last_sign_date");
         userId = sessionInfo.userId();
         singUser.setUserId(userId);
         //日期十四位
         TDateTime dateTime = new TDateTime(new Date());
         singUser.setSingnDate(dateTime);
         singUser.setLocationLongitude(locationLongitudeD);
         singUser.setLocationLatitude(locationLatitudeD);
         _clickConsole.click(context, logicContext, sessionContext, singUser);
         String dateTimeStr = dateTime.format("yyyy-mm-dd hh:mi:ss");
         last_sign_date.setText(dateTimeStr);
         return EResult.Success;
      }else{
         //没有找到当前的用户
         return EResult.Failure;
      }
   }
}
