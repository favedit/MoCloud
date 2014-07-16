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
// <T>用户登录请求消息。</T>
//============================================================
public class FPsnUserLoginRequest extends FNetMessage implements INetObject
{
   // 名称
   public final static String NAME = "PsnUserLoginRequest";

   // 类型
   public final static int TYPE = ENetMessageType.Request;

   // 代码
   public final static int CODE = ENetMessageGroup.LogicPerson + 0x0001;

   // 版本
   public final static int VERSION = 0x1EFED67C;

   // 账号
   protected String _passport;

   // 密码
   protected String _password;

   //============================================================
   // <T>构造消息的实例对象。</T>
   //
   // @return 实例对象
   //============================================================
   public FPsnUserLoginRequest(){
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
      // 反序列化账号
      _passport = xconfig.get("passport");
      // 反序列化密码
      _password = xconfig.get("password");
   }

   //============================================================
   // <T>保存数据到配置节点中。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      // 序列化账号
      xconfig.set("passport", _passport);
      // 序列化密码
      xconfig.set("password", _password);
   }

   //============================================================
   // <T>重置内容。</T>
   //============================================================
   @Override
   public void reset(){
      super.reset();
      // 重置账号内容
      _passport = null;
      // 重置密码内容
      _password = null;
   }
}
