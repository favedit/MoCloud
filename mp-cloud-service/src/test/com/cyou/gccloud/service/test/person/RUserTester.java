package com.cyou.gccloud.service.test.person;

import com.cyou.gccloud.service.test.common.ETestService;
import com.cyou.gccloud.service.test.common.FTestConnection;
import org.junit.Test;
import org.mo.com.lang.RDateTime;
import org.mo.com.xml.FXmlNode;

public class RUserTester
{
   //============================================================
   // <T>测试用户注册处理。</T>
   //============================================================
   @Test
   public void testRegister(){
      long number = RDateTime.currentDateTime().get();
      // 构造参数
      FXmlNode inputNode = new FXmlNode("Service");
      inputNode.createNode("Passport").setText("test" + number);
      inputNode.createNode("Password").setText("test" + number);
      inputNode.createNode("Label").setText("测试" + number);
      inputNode.createNode("Email").setText(number + "@cyou-inc.com");
      // 调用处理
      FTestConnection connection = new FTestConnection(ETestService.PersonUser);
      FXmlNode outputNode = connection.process("register", inputNode);
      // 显示结果
      System.out.println(outputNode.xml().toString());
   }

   //============================================================
   // <T>测试用户登录处理。</T>
   //============================================================
   @Test
   public void testLogin(){
      // 构造参数
      FXmlNode inputNode = new FXmlNode("Service");
      inputNode.createNode("Passport").setText("maocy");
      inputNode.createNode("Password").setText("maocy");
      // 调用处理
      FTestConnection connection = new FTestConnection(ETestService.PersonUser);
      FXmlNode outputNode = connection.process("login", inputNode);
      // 显示结果
      System.out.println(outputNode.xml().toString());
   }
}
