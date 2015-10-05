package org.mo.content.core.logic.version;

import org.mo.com.net.http.FHttpConnection;
import org.mo.com.xml.FXmlNode;

public class Test
{
   public static void main(String[] args){
      test();
      //      System.out.println(new TDateTime(new Date()).format("yyyymmdd"));
   }

   public static void test(){
      FXmlNode inputNode = new FXmlNode("Service");
      String action = "disconnect";
      inputNode.set("action", action);
      //输入session的id
      inputNode.createNode("SessionCode").setText("11122233344455");
      FHttpConnection connection = new FHttpConnection("http://localhost:8099/eai.mobile.ws");
      connection.connect();
      connection.request().setText(inputNode.xml().toString());
      //      System.out.println(connection.request().toString());
      connection.request().send();
      connection.response().receive();
      connection.disconnect();
      String content = connection.response().content();
      System.out.println(content);
      connection.close();
   }
}
