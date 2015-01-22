//============================================================
// <T>资源应用消息定义。</T>
//
// @version 1.0
// @auto 代码器管理的代码，如需修改请在手动修改标出的地方修改。
//============================================================
package com.cyou.gccloud.define.message.resourceapplication;

import com.cyou.gccloud.common.INetObject;
import com.cyou.gccloud.common.message.ENetMessageGroup;
import com.cyou.gccloud.common.message.ENetMessageType;
import com.cyou.gccloud.common.message.FNetMessage;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>用户注册请求消息。</T>
//============================================================
public class FRsaUserRegisterRequest
      extends FNetMessage
      implements
         INetObject
{
   // 名称
   public final static String NAME = "RsaUserRegisterRequest";

   // 类型
   public final static int TYPE = ENetMessageType.Request;

   // 代码
   public final static int CODE = ENetMessageGroup.ResourceApplication + 0x0001;

   // 版本
   public final static int VERSION = 0x00E3C204;

   // 登录帐号
   protected String _passport;

   // 用户密码
   protected String _password;

   // 用户标签
   protected String _label;

   // 性别代码
   protected int _genderCd;

   // 学校编号
   protected long _schoolId;

   // 联系电话
   protected String _contactPhone;

   // 联系邮箱
   protected String _contactEmail;

   // 家庭住址
   protected String _homeAddress;

   //============================================================
   // <T>构造消息的实例对象。</T>
   //
   // @return 实例对象
   //============================================================
   public FRsaUserRegisterRequest(){
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
   public FRsaUserRegisterRequest(FXmlNode xconfig){
      this();
      loadConfig(xconfig);
   }

   //============================================================
   // <T>获得登录帐号。</T>
   //
   // @return 登录帐号
   //============================================================
   public String passport(){
      return _passport;
   }

   //============================================================
   // <T>设置登录帐号。</T>
   //
   // @param passport 登录帐号
   //============================================================
   public void setPassport(String passport){
      _passport = passport;
   }

   //============================================================
   // <T>获得用户密码。</T>
   //
   // @return 用户密码
   //============================================================
   public String password(){
      return _password;
   }

   //============================================================
   // <T>设置用户密码。</T>
   //
   // @param password 用户密码
   //============================================================
   public void setPassword(String password){
      _password = password;
   }

   //============================================================
   // <T>获得用户标签。</T>
   //
   // @return 用户标签
   //============================================================
   public String label(){
      return _label;
   }

   //============================================================
   // <T>设置用户标签。</T>
   //
   // @param label 用户标签
   //============================================================
   public void setLabel(String label){
      _label = label;
   }

   //============================================================
   // <T>获得性别代码。</T>
   //
   // @return 性别代码
   //============================================================
   public int genderCd(){
      return _genderCd;
   }

   //============================================================
   // <T>设置性别代码。</T>
   //
   // @param genderCd 性别代码
   //============================================================
   public void setGenderCd(int genderCd){
      _genderCd = genderCd;
   }

   //============================================================
   // <T>获得联系电话。</T>
   //
   // @return 联系电话
   //============================================================
   public String contactPhone(){
      return _contactPhone;
   }

   //============================================================
   // <T>设置联系电话。</T>
   //
   // @param contactPhone 联系电话
   //============================================================
   public void setContactPhone(String contactPhone){
      _contactPhone = contactPhone;
   }

   //============================================================
   // <T>获得联系邮箱。</T>
   //
   // @return 联系邮箱
   //============================================================
   public String contactEmail(){
      return _contactEmail;
   }

   //============================================================
   // <T>设置联系邮箱。</T>
   //
   // @param contactEmail 联系邮箱
   //============================================================
   public void setContactEmail(String contactEmail){
      _contactEmail = contactEmail;
   }

   //============================================================
   // <T>获得家庭住址。</T>
   //
   // @return 家庭住址
   //============================================================
   public String homeAddress(){
      return _homeAddress;
   }

   //============================================================
   // <T>设置家庭住址。</T>
   //
   // @param homeAddress 家庭住址
   //============================================================
   public void setHomeAddress(String homeAddress){
      _homeAddress = homeAddress;
   }

   //============================================================
   // <T>从配置节点中读取数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      _passport = xconfig.nodeText("Passport");
      _password = xconfig.nodeText("Password");
      _label = xconfig.nodeText("Label");
      _genderCd = xconfig.nodeTextAsInt("GenderCd");
      _schoolId = xconfig.nodeTextAsLong("SchoolId");
      _contactPhone = xconfig.nodeText("ContactPhone");
      _contactEmail = xconfig.nodeText("ContactEmail");
      _homeAddress = xconfig.nodeText("HomeAddress");
   }

   //============================================================
   // <T>保存数据到配置节点中。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      xconfig.createNode("passport").setText(_passport);
      xconfig.createNode("password").setText(_password);
      xconfig.createNode("label").setText(_label);
      xconfig.createNode("gender_cd").setText(_genderCd);
      xconfig.createNode("school_id").setText(_schoolId);
      xconfig.createNode("contact_phone").setText(_contactPhone);
      xconfig.createNode("contact_email").setText(_contactEmail);
      xconfig.createNode("home_address").setText(_homeAddress);
   }

   //============================================================
   // <T>重置内容。</T>
   //============================================================
   @Override
   public void reset(){
      super.reset();
      _passport = null;
      _password = null;
      _label = null;
      _genderCd = 0;
      _contactPhone = null;
      _contactEmail = null;
      _homeAddress = null;
   }
}
