//============================================================
// <T>资源应用消息定义。</T>
//
// @version 1.0
// @auto 代码器管理的代码，如需修改请在手动修改标出的地方修改。
//============================================================
package com.cyou.gccloud.define.message.resourceapplication;

import com.cyou.gccloud.define.entity.SGcSession;
import org.mo.cloud.common.INetObject;
import org.mo.cloud.common.message.ENetMessageGroup;
import org.mo.cloud.common.message.ENetMessageType;
import org.mo.cloud.common.message.FNetMessage;
import org.mo.com.xml.FXmlNode;

//============================================================
// <T>用户登录应答消息。</T>
//============================================================
public class FRsaUserLoginResponse
      extends FNetMessage
      implements
         INetObject
{
   // 名称
   public final static String NAME = "RsaUserLoginResponse";

   // 类型
   public final static int TYPE = ENetMessageType.Response;

   // 代码
   public final static int CODE = ENetMessageGroup.ResourceApplication + 0x0004;

   // 版本
   public final static int VERSION = 0x40E3C204;

   //============================================================
   // <T>用户信息定义。</T>
   //============================================================
   public final static class SUserInfo
         implements
            INetObject
   {
      // 代码
      public final static String CODE = "User";

      // 标签
      protected String _label;

      // 性别
      protected int _genderCd;

      // 学校编号
      protected long _schoolId;

      // 学校标签
      protected String _schoolLabel;

      // 联系电话
      protected String _contactPhone;

      // 联系邮件
      protected String _contactEmail;

      // 家庭住址
      protected String _homeAddress;

      //============================================================
      // <T>构造用户信息定义。</T>
      //============================================================
      public SUserInfo(){
      }

      //============================================================
      // <T>获得标签。</T>
      //
      // @return 个数
      //============================================================
      public String label(){
         return _label;
      }

      //============================================================
      // <T>设置标签。</T>
      //
      // @param value 内容
      // @return 对象
      //============================================================
      public void setLabel(String value){
         _label = value;
      }

      //============================================================
      // <T>获得性别。</T>
      //
      // @return 个数
      //============================================================
      public int genderCd(){
         return _genderCd;
      }

      //============================================================
      // <T>设置性别。</T>
      //
      // @param value 内容
      // @return 对象
      //============================================================
      public void setGenderCd(int value){
         _genderCd = value;
      }

      //============================================================
      // <T>获得学校编号。</T>
      //
      // @return 个数
      //============================================================
      public long schoolId(){
         return _schoolId;
      }

      //============================================================
      // <T>设置学校编号。</T>
      //
      // @param value 内容
      // @return 对象
      //============================================================
      public void setSchoolId(long value){
         _schoolId = value;
      }

      //============================================================
      // <T>获得学校标签。</T>
      //
      // @return 个数
      //============================================================
      public String schoolLabel(){
         return _schoolLabel;
      }

      //============================================================
      // <T>设置学校标签。</T>
      //
      // @param value 内容
      // @return 对象
      //============================================================
      public void setSchoolLabel(String value){
         _schoolLabel = value;
      }

      //============================================================
      // <T>获得联系电话。</T>
      //
      // @return 个数
      //============================================================
      public String contactPhone(){
         return _contactPhone;
      }

      //============================================================
      // <T>设置联系电话。</T>
      //
      // @param value 内容
      // @return 对象
      //============================================================
      public void setContactPhone(String value){
         _contactPhone = value;
      }

      //============================================================
      // <T>获得联系邮件。</T>
      //
      // @return 个数
      //============================================================
      public String contactEmail(){
         return _contactEmail;
      }

      //============================================================
      // <T>设置联系邮件。</T>
      //
      // @param value 内容
      // @return 对象
      //============================================================
      public void setContactEmail(String value){
         _contactEmail = value;
      }

      //============================================================
      // <T>获得家庭住址。</T>
      //
      // @return 个数
      //============================================================
      public String homeAddress(){
         return _homeAddress;
      }

      //============================================================
      // <T>设置家庭住址。</T>
      //
      // @param value 内容
      // @return 对象
      //============================================================
      public void setHomeAddress(String value){
         _homeAddress = value;
      }

      //============================================================
      // <T>从配置节点中读取数据。</T>
      //
      // @param xconfig 配置节点
      //============================================================
      public void loadConfig(FXmlNode xconfig){
         _label = xconfig.get("label");
         _genderCd = xconfig.getInt("gender_cd");
         _schoolId = xconfig.getLong("school_id");
         _schoolLabel = xconfig.get("school_label");
         _contactPhone = xconfig.get("contact_phone");
         _contactEmail = xconfig.get("contact_email");
         _homeAddress = xconfig.get("home_address");
      }

      //============================================================
      // <T>保存数据到配置节点中。</T>
      //
      // @param xconfig 配置节点
      //============================================================
      public void saveConfig(FXmlNode xconfig){
         xconfig.set("label", _label);
         xconfig.set("gender_cd", _genderCd);
         xconfig.set("school_id", _schoolId);
         xconfig.set("school_label", _schoolLabel);
         xconfig.set("contact_phone", _contactPhone);
         xconfig.set("contact_email", _contactEmail);
         xconfig.set("home_address", _homeAddress);
      }

      //============================================================
      // <T>重置内容。</T>
      //============================================================
      public void reset(){
         _label = null;
         _genderCd = 0;
         _schoolId = 0;
         _schoolLabel = null;
         _contactPhone = null;
         _contactEmail = null;
         _homeAddress = null;
      }
   }

   // 会话信息
   protected SGcSession _session = new SGcSession();

   // 用户信息
   protected SUserInfo _user = new SUserInfo();

   //============================================================
   // <T>构造消息的实例对象。</T>
   //
   // @return 实例对象
   //============================================================
   public FRsaUserLoginResponse(){
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
   public FRsaUserLoginResponse(FXmlNode xconfig){
      this();
      loadConfig(xconfig);
   }

   //============================================================
   // <T>获得会话信息。</T>
   //
   // @return 会话信息
   //============================================================
   public SGcSession session(){
      return _session;
   }

   //============================================================
   // <T>获得用户信息。</T>
   //
   // @return 用户信息
   //============================================================
   public SUserInfo user(){
      return _user;
   }

   //============================================================
   // <T>从配置节点中读取数据。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void loadConfig(FXmlNode xconfig){
      FXmlNode xsession = xconfig.findNode(SGcSession.CODE);
      if(xsession != null){
         _session.loadConfig(xsession);
      }
      FXmlNode xuser = xconfig.findNode(SUserInfo.CODE);
      if(xuser != null){
         _user.loadConfig(xuser);
      }
   }

   //============================================================
   // <T>保存数据到配置节点中。</T>
   //
   // @param xconfig 配置节点
   //============================================================
   public void saveConfig(FXmlNode xconfig){
      FXmlNode xsession = xconfig.syncNode(SGcSession.CODE);
      _session.saveConfig(xsession);
      FXmlNode xuser = xconfig.syncNode(SUserInfo.CODE);
      _user.saveConfig(xuser);
   }

   //============================================================
   // <T>重置内容。</T>
   //============================================================
   @Override
   public void reset(){
      super.reset();
      _session.reset();
      _user.reset();
   }
}
