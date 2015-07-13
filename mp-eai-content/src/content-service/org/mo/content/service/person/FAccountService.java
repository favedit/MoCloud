package org.mo.content.service.person;

import com.cyou.gccloud.define.enums.core.EGcAccountFrom;
import org.mo.cloud.logic.person.FGcUserInfo;
import org.mo.com.lang.EResult;
import org.mo.com.lang.FObject;
import org.mo.com.xml.FXmlNode;
import org.mo.content.core.person.IAccountConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.web.core.action.common.FWebCookie;
import org.mo.web.protocol.context.IWebContext;
import org.mo.web.protocol.context.IWebInput;
import org.mo.web.protocol.context.IWebOutput;

//============================================================
// <T>人员账号服务接口。</T>
//============================================================
public class FAccountService
      extends FObject
      implements
         IAccountService
{
   //用户控制台
   @ALink
   protected IAccountConsole _accountConsole;

   //============================================================
   // <T>构造资源3D服务。</T>
   //============================================================
   public FAccountService(){
   }

   //============================================================
   // <T>登录数据处理。</T>
   //
   // @param context 网络环境
   // @param logicContext 逻辑环境
   // @param input 网络输入
   // @param output 网络输出
   //============================================================
   @Override
   public EResult login(IWebContext context,
                        ILogicContext logicContext,
                        IWebInput input,
                        IWebOutput output){
      // 获得参数
      String passport = context.parameter("passport");
      String password = context.parameter("password");
      // 新建记录
      FGcUserInfo user = _accountConsole.doLogin(logicContext, passport, password, EGcAccountFrom.Service);
      // 设置客户端信息
      FXmlNode xuser = output.config().createNode("User");
      String sessionGuid = user.sessionGuid();
      xuser.set("session_guid", sessionGuid);
      // 设置会话代码
      context.outputCookies().push(new FWebCookie("session_guid", sessionGuid));
      return EResult.Success;
   }
}
