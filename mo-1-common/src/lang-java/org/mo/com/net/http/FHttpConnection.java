package org.mo.com.net.http;

import org.mo.com.lang.FObject;
import org.mo.com.net.FClientSocket;
import org.mo.com.net.FSocket;

//============================================================
// <T>网络链接。</T>
//============================================================
public class FHttpConnection
      extends FObject
      implements
         AutoCloseable
{
   // 网络端口
   protected FSocket _socket;

   // 网络请求
   protected FHttpRequest _request;

   // 网络应答
   protected FHttpResponse _response;

   // 网络地址
   protected FUrl _url;

   // 本地主机
   protected String _localHost;

   // 本地端口
   protected int _localPort;

   // 是否使用代理
   protected boolean _useProxy = false;

   //============================================================
   // <T>构造网络链接。</T>
   //============================================================
   public FHttpConnection(){
      _url = new FUrl();
   }

   //============================================================
   // <T>构造网络链接。</T>
   //
   // @param url 网络地址
   //============================================================
   public FHttpConnection(String url){
      _url = new FUrl(url);
   }

   //============================================================
   // <T>构造网络链接。</T>
   //
   // @param url 网络地址
   //============================================================
   public FHttpConnection(FUrl url){
      _url = url;
   }

   //============================================================
   // <T>获得网络地址。</T>
   //
   // @return 网络地址
   //============================================================
   public FUrl url(){
      return _url;
   }

   //============================================================
   // <T>获得本地主机。</T>
   //
   // @return 主机
   //============================================================
   public String localHost(){
      return _localHost;
   }

   //============================================================
   // <T>设置本地主机。</T>
   //
   // @param host 主机
   //============================================================
   public void setLocalHost(String host){
      _localHost = host;
   }

   //============================================================
   // <T>获得本地端口。</T>
   //
   // @return 端口
   //============================================================
   public int localPort(){
      return _localPort;
   }

   //============================================================
   // <T>设置本地端口。</T>
   //
   // @param port 端口
   //============================================================
   public void setLocalPort(int port){
      _localPort = port;
   }

   //============================================================
   // <T>获得是否使用代理。</T>
   //
   // @return 是否使用代理
   //============================================================
   public boolean useProxy(){
      return _useProxy;
   }

   //============================================================
   // <T>获得网络端口。</T>
   //
   // @return 网络端口
   //============================================================
   public FSocket socket(){
      return _socket;
   }

   //============================================================
   // <T>获得网络请求。</T>
   //
   // @return 网络请求
   //============================================================
   public FHttpRequest request(){
      if(_request == null){
         _request = new FHttpRequest(this);
      }
      return _request;
   }

   //============================================================
   // <T>获得网络应答。</T>
   //
   // @return 网络应答
   //============================================================
   public FHttpResponse response(){
      if(_response == null){
         _response = new FHttpResponse(this);
      }
      return _response;
   }

   //============================================================
   // <T>链接主机。</T>
   //============================================================
   public void connect(){
      if(_socket == null){
         String host = _url.host();
         int port = _url.port();
         if(_localHost == null){
            _socket = new FClientSocket(host, port);
         }else{
            _socket = new FClientSocket(host, port, _localHost, _localPort);
         }
      }
   }

   //============================================================
   // <T>链接代理。</T>
   //
   // @param host 地址
   // @param port 端口
   //============================================================
   public void connectProxy(String host,
                            int port){
      _useProxy = true;
      _socket = new FClientSocket(host, port);
   }

   //============================================================
   // <T>获取数据。</T>
   //============================================================
   public String fetch(){
      connect();
      request().send();
      response().receive();
      disconnect();
      // 返回内容
      return response().content();
   }

   //============================================================
   // <T>获取数据。</T>
   //
   // @param data 数据
   //============================================================
   public void fetch(byte[] data){
      connect();
      request().setData(data);
      request().send();
      response().receive();
      disconnect();
   }

   //============================================================
   // <T>断开链接。</T>
   //============================================================
   public void disconnect(){
      if(_socket != null){
         _socket.close();
         _socket = null;
      }
   }

   //============================================================
   // <T>关闭处理。</T>
   //============================================================
   @Override
   public void close(){
      disconnect();
   }
}
