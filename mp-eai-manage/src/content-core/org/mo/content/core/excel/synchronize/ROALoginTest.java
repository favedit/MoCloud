package org.mo.content.core.excel.synchronize;

import org.mo.core.aop.face.ALink;
import org.mo.eai.logic.data.person.user.IDataPersonAccessAuthorityConsole;

public class ROALoginTest
{
   @ALink
   static IDataPersonAccessAuthorityConsole _accessConsole;

   public static void main(String[] args){
      String passport = "";
      String pwd = "";
      String result = _accessConsole.oaLogin(passport, pwd);
      System.out.println(result);

   }
}
