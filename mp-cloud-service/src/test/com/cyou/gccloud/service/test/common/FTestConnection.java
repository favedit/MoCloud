package com.cyou.gccloud.service.test.common;

import org.mo.com.lang.FFatalError;
import org.mo.com.net.http.FHttpConnection;
import org.mo.com.xml.FXmlDocument;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>测试链接。</T>
//============================================================
public class FTestConnection
      extends FHttpConnection
{
   // 服务地址
   public static String ServiceUrl = "http://localhost:89/";

   //============================================================
   // <T>构造测试链接。</T>
   //
   // @param serviceCd 服务类型
   //============================================================
   public FTestConnection(ETestService serviceCd){
      switch(serviceCd){
         case PersonUser:
            _url.set(ServiceUrl + "cloud.person.user.ws");
            break;
         default:
            throw new FFatalError("Unknown service type.");
      }
   }

   //============================================================
   // <T>调用处理。</T>
   //
   // @param action 命令
   // @param inputNode 输入节点
   // @return 输出节点
   //============================================================
   public FXmlNode process(String action,
                           FXmlNode inputNode){
      // 设置命令
      inputNode.set("action", action);
      // 发送数据
      connect();
      request().setText(inputNode.xml().toString());
      request().send();
      response().receive();
      disconnect();
      // 获得内容
      String content = response().content();
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadString(content);
      return xdocument.root();
   }
}
