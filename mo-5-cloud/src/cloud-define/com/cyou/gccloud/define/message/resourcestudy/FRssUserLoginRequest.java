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
// <T>用户登录请求消息。</T>
//============================================================
public class FRssUserLoginRequest
      extends FNetMessage
      implements
         INetObject
{
   // 名称
   public final static String NAME = "RssUserLoginRequest";

   // 类型
   public final static int TYPE = ENetMessageType.Request;

   // 代码
   public final static int CODE = ENetMessageGroup.ResourceStudy + 0x0003;

   // 版本
   public final static int VERSION = 0x00E3C204;

   // 系统模式
   protected int _systemModeCd;

   // 账号
   protected String _passport;

   // 密码
   protected String _password;

   //============================================================
   // <T>构造消息的实例对象。</T>
   //
   // @return 实例对象
   //============================================================
   public FRssUserLoginRequest(){
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
   public FRssUserLoginRequest(FXmlNode xconfig){
      this();
      loadConfig(xconfig);
   }

   //============================================================
   // <T>获得系统模式。</T>
   //
   // @return 系统模式
   //============================================================
   public int systemModeCd(){
      return _systemModeCd;
   }

   //============================================================
   // <T>设置系统模式。</T>
   //
   // @param systemModeCd 系统模式
   //============================================================
   public void setSystemModeCd(int systemModeCd){
      _systemModeCd = systemModeCd;
   }

   //============================================================
   // <T>获得账号。</T>
   //
   // @return 账号
   //============================================================
   public String passport(){
      return _passport;
   }

   //============================================================
   // <T>设置账号。</T>
   //
   // @param passport 账号
   //============================================================
   public void setPassport(String passport){
      _passport = passport;
   }

   //============================================================
   // <T>获得密码。</T>
   //
   // @return 密码
   //============================================================
   public String password(){
      return _password;
   }

   //============================================================
   // <T>设置密码。</T>
   //
   // @param password 密码
   //============================================================
   public void setPassword(String password){
      _password = password;
   }

   //============================================================
   // <T>从配置节点中读取数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      _systemModeCd = xconfig.nodeTextAsInt("SystemModeCd");
      _passport = xconfig.nodeText("Passport");
      _password = xconfig.nodeText("Password");
   }

   //============================================================
   // <T>保存数据到配置节点中。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.createNode("system_mode_cd").setText(_systemModeCd);
      xconfig.createNode("passport").setText(_passport);
      xconfig.createNode("password").setText(_password);
   }

   //============================================================
   // <T>重置内容。</T>
   //============================================================
   @Override
   public void reset(){
      super.reset();
      _systemModeCd = 0;
      _passport = null;
      _password = null;
   }
}
