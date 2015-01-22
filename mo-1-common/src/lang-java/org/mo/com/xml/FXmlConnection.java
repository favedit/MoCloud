package org.mo.com.xml;

import org.mo.com.net.http.FHttpConnection;
import org.mo.com.net.http.FUrl;

//============================================================
// <T>节点网络链接。</T>
//============================================================
public class FXmlConnection
      extends FHttpConnection
{
   // 输入节点
   protected FXmlNode _inputNode = new FXmlNode();

   // 输出节点
   protected FXmlNode _outputNode;

   //============================================================
   // <T>构造节点网络链接。</T>
   //============================================================
   public FXmlConnection(){
   }

   //============================================================
   // <T>构造节点网络链接。</T>
   //
   // @param url 网络地址
   //============================================================
   public FXmlConnection(String url){
      super(url);
   }

   //============================================================
   // <T>构造节点网络链接。</T>
   //
   // @param url 网络地址
   //============================================================
   public FXmlConnection(FUrl url){
      super(url);
   }

   //============================================================
   // <T>获得输入节点。</T>
   //
   // @return 输入节点
   //============================================================
   public FXmlNode inputNode(){
      return _inputNode;
   }

   //============================================================
   // <T>获得输出节点。</T>
   //
   // @return 输出节点
   //============================================================
   public FXmlNode outputNode(){
      return _outputNode;
   }

   //============================================================
   // <T>设置参数。</T>
   //
   // @param name 名称
   // @param value 内容
   // @return 参数
   //============================================================
   public void setParameter(String name,
                            String value){
      _inputNode.set(name, value);
   }

   //============================================================
   // <T>设置节点参数。</T>
   //
   // @param name 名称
   // @param value 内容
   // @return 参数
   //============================================================
   public void setNodeParameter(String name,
                                String value){
      _inputNode.createNode(name).setText(value);
   }

   //============================================================
   // <T>调用处理。</T>
   //
   // @param action 命令
   // @return 输出节点
   //============================================================
   public FXmlNode process(String action){
      // 获得输入字符串
      _inputNode.setName("Service");
      _inputNode.set("action", action);
      String inputXml = _inputNode.xml().toString();
      // 发送数据
      connect();
      request().setText(inputXml);
      request().send();
      response().receive();
      disconnect();
      // 获得内容
      String content = response().content();
      FXmlDocument xdocument = new FXmlDocument();
      xdocument.loadString(content);
      _outputNode = xdocument.root();
      return _outputNode;
   }
}
