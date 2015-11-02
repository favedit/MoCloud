package org.mo.content.service.city.info;

import org.junit.Test;
import org.mo.com.lang.RDateTime;
import org.mo.com.lang.type.TDateTime;
import org.mo.com.net.http.FHttpConnection;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>服务器工具服务。</T>
//============================================================
public class TMobileService
{
   @Test
   public void find(){
      TDateTime beginTime = new TDateTime(RDateTime.currentDateTime());
      System.out.println(beginTime.format("yyyy-mm-dd hh:mm:ss:ms"));
      FXmlNode inputNode = new FXmlNode("Service");
      inputNode.set("action", "find");
      inputNode.createNode("mobile").setText("18700015908");

      @SuppressWarnings("resource") FHttpConnection connection = new FHttpConnection("http://localhost:8020/eai.city.info.mobile.ws");
      //      try(FHttpConnection connection = new FHttpConnection("http://localhost:8099/eai.info.mobile.ws")){
      //         result = connection.fetch();
      //      }
      //FHttpConnection connection = new FHttpConnection("http://10.12.20.218:8019/cloud.person.user.ws");
      connection.connect();
      connection.request().setText(inputNode.xml().toString());
      connection.request().send();
      connection.response().receive();
      connection.disconnect();

      String content = connection.response().content();
      System.out.println(content);
      TDateTime endTime = new TDateTime(RDateTime.currentDateTime());
      System.out.println(endTime.format("yyyy-mm-dd hh:mm:ss:ms"));
   }

   @Test
   public void fetch(){
      TDateTime beginTime = new TDateTime(RDateTime.currentDateTime());
      System.out.println(beginTime.format("yyyy-mm-dd hh:mm:ss:ms"));
      FXmlNode inputNode = new FXmlNode("Service");
      inputNode.set("action", "fetch");
      inputNode.createNode("mobile").setText("18700015908");
      inputNode.createNode("mobile").setText("18720555908");
      inputNode.createNode("mobile").setText("18730555908");
      inputNode.createNode("mobile").setText("18740555908");

      @SuppressWarnings("resource") FHttpConnection connection = new FHttpConnection("http://localhost:8020/eai.city.info.mobile.ws");
      //      try(FHttpConnection connection = new FHttpConnection("http://localhost:8099/eai.info.mobile.ws")){
      //         result = connection.fetch();
      //      }
      //FHttpConnection connection = new FHttpConnection("http://10.12.20.218:8019/cloud.person.user.ws");
      connection.connect();
      connection.request().setText(inputNode.xml().toString());
      connection.request().send();
      connection.response().receive();
      connection.disconnect();

      String content = connection.response().content();
      System.out.println(content);
      TDateTime endTime = new TDateTime(RDateTime.currentDateTime());
      System.out.println(endTime.format("yyyy-mm-dd hh:mm:ss:ms"));
   }
}
