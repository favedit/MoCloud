package org.mo.eng.instantmessag;

import org.mo.com.xml.FXmlNode;

//============================================================
// <T>链接参数集合。</T>
//============================================================
public class SImConnectParams
{

   public static final String KeyHost = "Host";

   public static final String KeyPost = "Port";

   public static final String KeyDomain = "Domain";

   public static final String KeyNode = "ImConn";

   // 主机
   protected String _host;

   // 端口
   protected int _port;

   // 主域
   protected String _domain;

   public SImConnectParams copy(){

      SImConnectParams p = new SImConnectParams();
      p._host = this._host;
      p._port = _port;
      p._domain = _domain;
      return p;
   }

   //============================================================
   // <T>构造链接参数集合。</T>
   //============================================================
   public SImConnectParams(){
   }

   public void saveXml(FXmlNode root){
      FXmlNode node = root.createNode(KeyNode);

      node.set(KeyDomain, _domain);
      node.set(KeyHost, _host);
      node.set(KeyPost, _port);
   }

   public void loadXml(FXmlNode node){
      if(node.name().equalsIgnoreCase(KeyNode)){
         _host = node.get(KeyHost, null);
         _port = node.getInt(KeyPost, 0);
         _domain = node.get(KeyDomain, null);
      }
   }

   //============================================================
   // <T>获得主机。</T>
   //
   // @return 主机
   //============================================================
   public String host(){
      return _host;
   }

   //============================================================
   // <T>设置主机。</T>
   //
   // @param host 主机
   //============================================================
   public void setHost(String host){
      _host = host;
   }

   //============================================================
   // <T>获得端口。</T>
   //
   // @return 端口
   //============================================================
   public int port(){
      return _port;
   }

   //============================================================
   // <T>设置端口。</T>
   //
   // @param port 端口
   //============================================================
   public void setPort(int port){
      _port = port;
   }

   //============================================================
   // <T>获得主域。</T>
   //
   // @return 主域
   //============================================================
   public String domain(){
      return _domain;
   }

   //============================================================
   // <T>设置主域。</T>
   //
   // @param domain 主域
   //============================================================
   public void setDomain(String domain){
      _domain = domain;
   }
}
