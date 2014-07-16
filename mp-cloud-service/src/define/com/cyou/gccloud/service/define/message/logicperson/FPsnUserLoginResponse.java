//============================================================
// <T>用户逻辑消息定义。</T>
//
// @version 1.0
// @auto 代码器管理的代码，如需修改请在手动修改标出的地方修改。
//============================================================
package com.cyou.gccloud.service.define.message.logicperson;

import org.mo.com.xml.*;
import com.cyou.gccloud.service.common.message.*;

//============================================================
// <T>用户登录应答消息。</T>
//============================================================
public class FPsnUserLoginResponse extends FNetMessage implements INetObject
{
   // 名称
   public final static String NAME = "PsnUserLoginResponse";

   // 类型
   public final static int TYPE = ENetMessageType.Response;

   // 代码
   public final static int CODE = ENetMessageGroup.LogicPerson + 0x0002;

   // 版本
   public final static int VERSION = 0x00E3C204;

   public final static int EStatus_Success = 0;

   public final static int EStatus_Failure = 1;

   // 状态
   protected int _statusCd;

   // 会话代码
   protected String _sessionCode;

   // 用户标签
   protected String _userLabel;

   //============================================================
   // <T>构造消息的实例对象。</T>
   //
   // @return 实例对象
   //============================================================
   public FPsnUserLoginResponse(){
      _head.name = NAME;
      _head.type = TYPE;
      _head.code = CODE;
      _head.version = VERSION;
   }

   //============================================================
   // <T>从配置节点中读取数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      // 反序列化状态
      _statusCd = xconfig.getInt("status_cd");
      // 反序列化会话代码
      _sessionCode = xconfig.get("session_code");
      // 反序列化用户标签
      _userLabel = xconfig.get("user_label");
   }

   //============================================================
   // <T>保存数据到配置节点中。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      // 序列化状态
      xconfig.set("status_cd", _statusCd);
      // 序列化会话代码
      xconfig.set("session_code", _sessionCode);
      // 序列化用户标签
      xconfig.set("user_label", _userLabel);
   }

   //============================================================
   // <T>重置内容。</T>
   //============================================================
   @Override
   public void reset(){
      super.reset();
      // 重置状态内容
      _statusCd = 0;
      // 重置会话代码内容
      _sessionCode = null;
      // 重置用户标签内容
      _userLabel = null;
   }
}
