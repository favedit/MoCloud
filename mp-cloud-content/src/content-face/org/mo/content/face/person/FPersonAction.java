package org.mo.content.face.person;

import com.cyou.gccloud.data.data.FDataPersonUserUnit;
import org.mo.com.lang.EResult;
import org.mo.content.core.person.IPersonConsole;
import org.mo.core.aop.face.ALink;
import org.mo.data.logic.ILogicContext;
import org.mo.eng.data.common.ISqlContext;
import org.mo.web.protocol.context.IWebContext;

//============================================================
//<P>用户逻辑实现类</P>
//
//@class FPersonAction
//@author Sunhr
//@Date 2012.11.05  
//@version 1.0.0
//============================================================

public class FPersonAction
      implements
         IPersonAction
{
   //用户控制台
   @ALink
   protected IPersonConsole _personConsole;

   @Override
   public String construct(ISqlContext context,
                           FPersonPage areaPage){
      return "/index";
   }

   // ============================================================
   // <T>注册</T>
   //
   // @param context 上下文
   // @param logicContext 数据库连接
   // @param personPage 容器
   // @return 要跳转页面
   // ============================================================
   @Override
   public String register(IWebContext context,
                          ILogicContext logicContext,
                          FPersonPage personPage){
      String passport = context.parameter("passport");
      String password = context.parameter("pwd1");
      FDataPersonUserUnit person = new FDataPersonUserUnit();
      person.setPassport(passport);
      person.setPassword(password);
      EResult result = _personConsole.register(logicContext, person);
      if(result.equals(EResult.Success)){
         personPage.setResult("注册成功，单击[返回]按扭返回。");
      }else{
         personPage.setResult("注册失败，请检查注册步骤是否正确。");
      }
      return "/registerResult";
   }
}
