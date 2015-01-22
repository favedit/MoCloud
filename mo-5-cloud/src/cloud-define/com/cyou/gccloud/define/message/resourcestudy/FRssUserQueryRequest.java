//============================================================
// <T>资源学习消息定义。</T>
//
// @version 1.0
// @auto 代码器管理的代码，如需修改请在手动修改标出的地方修改。
//============================================================
package com.cyou.gccloud.define.message.resourcestudy;

import com.cyou.gccloud.common.INetObject;
import com.cyou.gccloud.common.message.ENetMessageGroup;
import com.cyou.gccloud.common.message.ENetMessageType;
import com.cyou.gccloud.common.message.FNetMessage;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>用户查询请求消息。</T>
//============================================================
public class FRssUserQueryRequest
      extends FNetMessage
      implements
         INetObject
{
   // 名称
   public final static String NAME = "RssUserQueryRequest";

   // 类型
   public final static int TYPE = ENetMessageType.Request;

   // 代码
   public final static int CODE = ENetMessageGroup.ResourceStudy + 0x0005;

   // 版本
   public final static int VERSION = 0x00E3C204;

   // 会话代码
   protected String _sessionCode;

   //============================================================
   // <T>构造消息的实例对象。</T>
   //
   // @return 实例对象
   //============================================================
   public FRssUserQueryRequest(){
      _head.name = NAME;
      _head.type = TYPE;
      _head.code = CODE;
      _head.version = VERSION;
   }

   //============================================================
   // <T>构造消息的实例对象。</T>
   //
   // @param xconfig 配置节点
   // @return 实例对象
   //============================================================
   public FRssUserQueryRequest(FXmlNode xconfig){
      this();
      loadConfig(xconfig);
   }

   //============================================================
   // <T>获得会话代码。</T>
   //
   // @return 会话代码
   //============================================================
   public String sessionCode(){
      return _sessionCode;
   }

   //============================================================
   // <T>设置会话代码。</T>
   //
   // @param sessionCode 会话代码
   //============================================================
   public void setSessionCode(String sessionCode){
      _sessionCode = sessionCode;
   }

   //============================================================
   // <T>从配置节点中读取数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      _sessionCode = xconfig.nodeText("SessionCode");
   }

   //============================================================
   // <T>保存数据到配置节点中。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.createNode("session_code").setText(_sessionCode);
   }

   //============================================================
   // <T>重置内容。</T>
   //============================================================
   @Override
   public void reset(){
      super.reset();
      _sessionCode = null;
   }
}
