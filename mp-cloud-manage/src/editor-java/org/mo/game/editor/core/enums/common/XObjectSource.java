package org.mo.game.editor.core.enums.common;

import org.mo.com.xml.IXmlObject;

//============================================================
// <T>代码类型对象的XML节点基类。</T>
//============================================================
public interface XObjectSource
      extends IXmlObject
{
   // 名称定义
   String NAME = "ISource";

   // 服务器的名称定义
   String PTY_IS_SERVER = "is_server";

   // 服务器CPP代码的名称定义
   String PTY_IS_SERVER_CPP = "is_server_cpp";

   // 服务器JAVA代码的名称定义
   String PTY_IS_SERVER_JAVA = "is_server_java";

   // 客户端的名称定义
   String PTY_IS_CLIENT = "is_client";

   // 客户端CPP代码的名称定义
   String PTY_IS_CLIENT_CPP = "is_client_cpp";

   // 客户端AS代码的名称定义
   String PTY_IS_CLIENT_AS = "is_client_as";

   // 客户端CS代码的名称定义
   String PTY_IS_CLIENT_CS = "is_client_cs";

   // 客户端JAVA代码的名称定义
   String PTY_IS_CLIENT_JAVA = "is_client_java";

   //============================================================
   // <T>获得服务器的内容。</T>
   //
   // @return 服务器
   //============================================================
   String getIsServer();

   //============================================================
   // <T>设置服务器的内容。</T>
   //
   // @param value 服务器
   //============================================================
   void setIsServer(String value);

   //============================================================
   // <T>获得服务器CPP代码的内容。</T>
   //
   // @return 服务器CPP代码
   //============================================================
   String getIsServerCpp();

   //============================================================
   // <T>设置服务器CPP代码的内容。</T>
   //
   // @param value 服务器CPP代码
   //============================================================
   void setIsServerCpp(String value);

   //============================================================
   // <T>获得服务器JAVA代码的内容。</T>
   //
   // @return 服务器JAVA代码
   //============================================================
   String getIsServerJava();

   //============================================================
   // <T>设置服务器JAVA代码的内容。</T>
   //
   // @param value 服务器JAVA代码
   //============================================================
   void setIsServerJava(String value);

   //============================================================
   // <T>获得客户端的内容。</T>
   //
   // @return 客户端
   //============================================================
   String getIsClient();

   //============================================================
   // <T>设置客户端的内容。</T>
   //
   // @param value 客户端
   //============================================================
   void setIsClient(String value);

   //============================================================
   // <T>获得客户端CPP代码的内容。</T>
   //
   // @return 客户端CPP代码
   //============================================================
   String getIsClientCpp();

   //============================================================
   // <T>设置客户端CPP代码的内容。</T>
   //
   // @param value 客户端CPP代码
   //============================================================
   void setIsClientCpp(String value);

   //============================================================
   // <T>获得客户端AS代码的内容。</T>
   //
   // @return 客户端AS代码
   //============================================================
   String getIsClientAs();

   //============================================================
   // <T>设置客户端AS代码的内容。</T>
   //
   // @param value 客户端AS代码
   //============================================================
   void setIsClientAs(String value);

   //============================================================
   // <T>获得客户端CS代码的内容。</T>
   //
   // @return 客户端CS代码
   //============================================================
   String getIsClientCs();

   //============================================================
   // <T>设置客户端CS代码的内容。</T>
   //
   // @param value 客户端CS代码
   //============================================================
   void setIsClientCs(String value);

   //============================================================
   // <T>获得客户端JAVA代码的内容。</T>
   //
   // @return 客户端JAVA代码
   //============================================================
   String getIsClientJava();

   //============================================================
   // <T>设置客户端JAVA代码的内容。</T>
   //
   // @param value 客户端JAVA代码
   //============================================================
   void setIsClientJava(String value);
}