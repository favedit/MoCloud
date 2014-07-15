package com.cyou.gccloud.service.data.data;

import org.mo.com.lang.*;
import org.mo.com.collections.*;
import org.mo.com.lang.type.*;
import org.mo.data.logic.*;

//============================================================
// <T>帐号信息逻辑单元。</T>
//============================================================
public class FDataPersonUserUnit extends FLogicUnit
{
   // 存储字段对象标识的定义。
   private long __ouid;

   // 字段对象标识的定义。
   protected long _ouid;

   // 存储字段有效性的定义。
   private boolean __ovld;

   // 字段有效性的定义。
   protected boolean _ovld;

   // 存储字段帐号的定义。
   private String __passport;

   // 字段帐号的定义。
   protected String _passport;

   // 存储字段密码的定义。
   private String __password;

   // 字段密码的定义。
   protected String _password;

   // 存储字段名称的定义。
   private String __label;

   // 字段名称的定义。
   protected String _label;

   // 存储字段生日的定义。
   private TDateTime __birthday = new TDateTime();

   // 字段生日的定义。
   protected TDateTime _birthday = new TDateTime();

   // 存储字段联系电话号码的定义。
   private String __contactPhone;

   // 字段联系电话号码的定义。
   protected String _contactPhone;

   // 存储字段联系邮箱地址的定义。
   private String __contactEmail;

   // 字段联系邮箱地址的定义。
   protected String _contactEmail;

   // 存储字段联系QQ号码的定义。
   private String __contactQq;

   // 字段联系QQ号码的定义。
   protected String _contactQq;

   // 存储字段联系MSN号码的定义。
   private String __contactMsn;

   // 字段联系MSN号码的定义。
   protected String _contactMsn;

   // 存储字段创建用户标识的定义。
   private int __createUserId;

   // 字段创建用户标识的定义。
   protected int _createUserId;

   // 存储字段创建日期的定义。
   private TDateTime __createDate = new TDateTime();

   // 字段创建日期的定义。
   protected TDateTime _createDate = new TDateTime();

   // 存储字段更新者标识的定义。
   private int __updateUserId;

   // 字段更新者标识的定义。
   protected int _updateUserId;

   // 存储字段更新时间的定义。
   private TDateTime __updateDate = new TDateTime();

   // 字段更新时间的定义。
   protected TDateTime _updateDate = new TDateTime();

   //============================================================
   // <T>构造帐号信息逻辑单元。</T>
   //============================================================
   public FDataPersonUserUnit(){
   }

   //============================================================
   // <T>判断对象标识的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isOuidChanged(){
      return __ouid != _ouid;
   }

   //============================================================
   // <T>获得对象标识的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long ouid(){
      return _ouid;
   }

   //============================================================
   // <T>设置对象标识的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setOuid(long value){
      _ouid = value;
   }

   //============================================================
   // <T>判断有效性的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isOvldChanged(){
      return __ovld != _ovld;
   }

   //============================================================
   // <T>获得有效性的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean ovld(){
      return _ovld;
   }

   //============================================================
   // <T>设置有效性的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setOvld(boolean value){
      _ovld = value;
   }

   //============================================================
   // <T>判断帐号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPassportChanged(){
      return !RString.equals(__passport, _passport);
   }

   //============================================================
   // <T>获得帐号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String passport(){
      return _passport;
   }

   //============================================================
   // <T>设置帐号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPassport(String value){
      _passport = value;
   }

   //============================================================
   // <T>判断密码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPasswordChanged(){
      return !RString.equals(__password, _password);
   }

   //============================================================
   // <T>获得密码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String password(){
      return _password;
   }

   //============================================================
   // <T>设置密码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPassword(String value){
      _password = value;
   }

   //============================================================
   // <T>判断名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLabelChanged(){
      return !RString.equals(__label, _label);
   }

   //============================================================
   // <T>获得名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String label(){
      return _label;
   }

   //============================================================
   // <T>设置名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLabel(String value){
      _label = value;
   }

   //============================================================
   // <T>判断生日的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBirthdayChanged(){
      return !__birthday.equals(_birthday);
   }

   //============================================================
   // <T>获得生日的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime birthday(){
      return _birthday;
   }

   //============================================================
   // <T>设置生日的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBirthday(TDateTime value){
      _birthday = value;
   }

   //============================================================
   // <T>判断联系电话号码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContactPhoneChanged(){
      return !RString.equals(__contactPhone, _contactPhone);
   }

   //============================================================
   // <T>获得联系电话号码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String contactPhone(){
      return _contactPhone;
   }

   //============================================================
   // <T>设置联系电话号码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContactPhone(String value){
      _contactPhone = value;
   }

   //============================================================
   // <T>判断联系邮箱地址的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContactEmailChanged(){
      return !RString.equals(__contactEmail, _contactEmail);
   }

   //============================================================
   // <T>获得联系邮箱地址的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String contactEmail(){
      return _contactEmail;
   }

   //============================================================
   // <T>设置联系邮箱地址的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContactEmail(String value){
      _contactEmail = value;
   }

   //============================================================
   // <T>判断联系QQ号码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContactQqChanged(){
      return !RString.equals(__contactQq, _contactQq);
   }

   //============================================================
   // <T>获得联系QQ号码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String contactQq(){
      return _contactQq;
   }

   //============================================================
   // <T>设置联系QQ号码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContactQq(String value){
      _contactQq = value;
   }

   //============================================================
   // <T>判断联系MSN号码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContactMsnChanged(){
      return !RString.equals(__contactMsn, _contactMsn);
   }

   //============================================================
   // <T>获得联系MSN号码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String contactMsn(){
      return _contactMsn;
   }

   //============================================================
   // <T>设置联系MSN号码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContactMsn(String value){
      _contactMsn = value;
   }

   //============================================================
   // <T>判断创建用户标识的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCreateUserIdChanged(){
      return __createUserId != _createUserId;
   }

   //============================================================
   // <T>获得创建用户标识的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int createUserId(){
      return _createUserId;
   }

   //============================================================
   // <T>设置创建用户标识的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCreateUserId(int value){
      _createUserId = value;
   }

   //============================================================
   // <T>判断创建日期的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCreateDateChanged(){
      return !__createDate.equals(_createDate);
   }

   //============================================================
   // <T>获得创建日期的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime createDate(){
      return _createDate;
   }

   //============================================================
   // <T>设置创建日期的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCreateDate(TDateTime value){
      _createDate = value;
   }

   //============================================================
   // <T>判断更新者标识的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isUpdateUserIdChanged(){
      return __updateUserId != _updateUserId;
   }

   //============================================================
   // <T>获得更新者标识的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int updateUserId(){
      return _updateUserId;
   }

   //============================================================
   // <T>设置更新者标识的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setUpdateUserId(int value){
      _updateUserId = value;
   }

   //============================================================
   // <T>判断更新时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isUpdateDateChanged(){
      return !__updateDate.equals(_updateDate);
   }

   //============================================================
   // <T>获得更新时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime updateDate(){
      return _updateDate;
   }

   //============================================================
   // <T>设置更新时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setUpdateDate(TDateTime value){
      _updateDate = value;
   }

   //============================================================
   // <T>加载行记录。</T>
   //
   // @param row 行记录
   //============================================================
   public void load(FRow row){
      __ouid = RLong.parse(row.get("ouid"));
      _ouid = __ouid;
      __passport = row.get("passport");
      _passport = __passport;
      __password = row.get("password");
      _password = __password;
      __label = row.get("label");
      _label = __label;
      __birthday.parse(row.get("birthday"));
      _birthday.assign(__birthday);
      __contactPhone = row.get("contact_phone");
      _contactPhone = __contactPhone;
      __contactEmail = row.get("contact_email");
      _contactEmail = __contactEmail;
      __contactQq = row.get("contact_qq");
      _contactQq = __contactQq;
      __contactMsn = row.get("contact_msn");
      _contactMsn = __contactMsn;
      __createUserId = row.getInteger("create_user_id");
      _createUserId = __createUserId;
      __createDate.parse(row.get("create_date"));
      _createDate.assign(__createDate);
      __updateUserId = row.getInteger("update_user_id");
      _updateUserId = __updateUserId;
      __updateDate.parse(row.get("update_date"));
      _updateDate.assign(__updateDate);
   }
}
