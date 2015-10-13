package org.mo.content.service.mobile;

import com.cyou.gccloud.data.data.FDataSystemVersionUnit;
import com.cyou.gccloud.define.enums.core.EGcVersionForce;
import java.util.HashMap;
import org.mo.cloud.core.web.FGcWebSession;
import org.mo.cloud.logic.data.system.FGcSessionInfo;
import org.mo.cloud.logic.data.system.IGcSessionConsole;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.logging.ILogger;
import org.mo.com.logging.RLogger;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.mobile.IVersionConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.session.IWebSession;
import org.mo.web.core.session.IWebSessionConsole;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>版本更新服务。</T>
//============================================================
public class FVersionService
      extends FObject
      implements
         IVersionService
{
   // 日志输出接口
   private static ILogger _logger = RLogger.find(FVersionService.class);

   //版本更新逻辑控制台
   @ALink
   protected IVersionConsole _versionConsole;

   //会话控制台
   @ALink
   protected IWebSessionConsole _sessionConsole;

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
   // @连接服务器查看版本是否有更新
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext session上下文
   //============================================================
   @Override
   public EResult connect(IWebContext context,
                          IWebSession sessionContext,
                          IWebInput input,
                          IWebOutput output,
                          ILogicContext logicContext){
      // 获得应用程序id和与之对应的版本编号
      FXmlNode inputNode = input.config();
      FXmlNode inputApplicationNode = inputNode.findNode("appkey");
      FXmlNode numberNode = inputNode.findNode("versionnumber");
      String numberText = "";
      float numberFloat = Float.MAX_VALUE;
      if(numberNode != null){
         numberText = numberNode.text();
         numberFloat = Float.parseFloat(numberText);
      }
      String sessionStr = context.head("mo-session-id");
      /*FXmlNode sessionNode = inputNode.findNode("mo-session-id");
      String sessionStr = sessionNode.text();*/
      String applicationStr = inputApplicationNode.text();
      _logger.debug(this, "****************************------------------------------------->show parameters", "appos={1},sessionCode={2}", applicationStr, sessionStr);
      String versionStr = "";
      System.out.println("****************************---------------->" + sessionContext.getClass().getName());
      //输出信息
      HashMap<String, Object> hashMap = _versionConsole.connect(context, versionStr, applicationStr, logicContext, sessionContext);
      FDataSystemVersionUnit lastVersionUnit = (FDataSystemVersionUnit)hashMap.get("lastVersion");
      String app_os = (String)hashMap.get("app_os");
      FXmlNode upgrade_cd = output.config().createNode("upgrade_cd");
      if(lastVersionUnit != null && lastVersionUnit.number() > numberFloat){
         FXmlNode version_num = output.config().createNode("version_number");
         FXmlNode versionCode = output.config().createNode("version_code");
         FXmlNode upgrade_url = output.config().createNode("upgrade_url");
         FXmlNode upgrade_log = output.config().createNode("upgrade_log");
         String code = lastVersionUnit.code();
         String downloadUrl = lastVersionUnit.downloadUrl();
         String note = lastVersionUnit.note();
         String number = lastVersionUnit.number() + "";
         int forceCd = lastVersionUnit.forceCd();
         version_num.setText(number);
         upgrade_cd.setText(forceCd);
         upgrade_url.setText(downloadUrl);
         upgrade_log.setText(note);
         if(code != null && (!"".equals(code))){
            versionCode.setText(code);
         }else{
            versionCode.setText("-1");
         }
         if(downloadUrl != null && (!"".equals(downloadUrl))){
            upgrade_url.setText(downloadUrl);
         }else{
            upgrade_url.setText("-1");
         }
         if(note != null && (!"".equals(note))){
            upgrade_log.setText(note);
         }else{
            upgrade_log.setText("-1");
         }
         //         outputVersionNode.set("upgrade_size", lastVersionUnit.downloadSize());
      }else if(lastVersionUnit == null){
         upgrade_cd.setText("app_key is error!");
      }else{
         upgrade_cd.setText(EGcVersionForce.NoUpdate);
      }
      //      outputApplicationNode.setText(applicationStr);
      if("".equals(sessionStr)){
         FXmlNode sessionCode = output.config().createNode("session_code");
         FGcWebSession session = (FGcWebSession)sessionContext;
         sessionCode.setText(session.id());
      }else{
         //如果有值,验证session是否有效
         FGcSessionInfo sessionInfo = _gcSessionConsole.findBySessionCode(logicContext, "eai", "mobile_" + app_os, sessionStr);
         //如果session无效
         if(sessionInfo == null){
            FXmlNode sessionCode = output.config().createNode("session_code");
            FGcWebSession session = (FGcWebSession)sessionContext;
            sessionCode.setText(session.id());
         }else{
            FXmlNode sessionCode = output.config().createNode("session_code");
            sessionCode.setText(sessionStr);
         }
      }
      return EResult.Success;
   }

   //============================================================
   // @断开与服务器的连接
   // @param context 页面环境
   // @param input 输入配置
   // @param output 输出配置
   // @return 处理结果
   // @logicContext 逻辑上下文
   // @sessionContext 会话session上下文
   //============================================================
   @Override
   public EResult disconnect(IWebContext context,
                             IWebSession sessionContext,
                             IWebInput input,
                             IWebOutput output,
                             ILogicContext logicContext){
      //获取会话id
      FXmlNode inputNode = input.config();
      FXmlNode inputSessionCodeNode = inputNode.findNode("SessionCode");
      String sessionCodeNodeStr = inputSessionCodeNode.text();
      _versionConsole.disconnect(context, sessionCodeNodeStr, logicContext, sessionContext, _sessionConsole);
      return EResult.Success;
   }
}
