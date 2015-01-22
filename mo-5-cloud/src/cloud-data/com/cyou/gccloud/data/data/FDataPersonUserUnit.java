package com.cyou.gccloud.data.data;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>人员用户信息逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataPersonUserUnit
      extends FLogicUnit
{
   // 存储字段对象标识的定义。
   private long __ouid;

   // 字段对象标识的定义。
   protected long _ouid;

   // 存储字段有效性的定义。
   private boolean __ovld;

   // 字段有效性的定义。
   protected boolean _ovld;

   // 存储字段对象唯一标识的定义。
   private String __guid;

   // 字段对象唯一标识的定义。
   protected String _guid;

   // 存储字段代码的定义。
   private String __code;

   // 字段代码的定义。
   protected String _code;

   // 存储字段帐号的定义。
   private String __passport;

   // 字段帐号的定义。
   protected String _passport;

   // 存储字段上次登录时间的定义。
   private TDateTime __passportLoginDate = new TDateTime();

   // 字段上次登录时间的定义。
   protected TDateTime _passportLoginDate = new TDateTime();

   // 存储字段密码的定义。
   private String __password;

   // 字段密码的定义。
   protected String _password;

   // 存储字段密码更新时间的定义。
   private TDateTime __passwordUpdateDate = new TDateTime();

   // 字段密码更新时间的定义。
   protected TDateTime _passwordUpdateDate = new TDateTime();

   // 存储字段状态类型的定义。
   private int __statusCd;

   // 字段状态类型的定义。
   protected int _statusCd;

   // 存储字段角色类型的定义。
   private int __roleCd;

   // 字段角色类型的定义。
   protected int _roleCd;

   // 存储字段业务角色编号的定义。
   private long __roleId;

   // 字段业务角色编号的定义。
   protected long _roleId;

   // 存储字段开发类型的定义。
   private int __developCd;

   // 字段开发类型的定义。
   protected int _developCd;

   // 存储字段教师类型的定义。
   private int __teacherCd;

   // 字段教师类型的定义。
   protected int _teacherCd;

   // 存储字段导师编号的定义。
   private long __teacherId;

   // 字段导师编号的定义。
   protected long _teacherId;

   // 存储字段显示名称的定义。
   private String __alias;

   // 字段显示名称的定义。
   protected String _alias;

   // 存储字段真实名称的定义。
   private String __label;

   // 字段真实名称的定义。
   protected String _label;

   // 存储字段真实名称权限类型的定义。
   private int __labelSecurityCd;

   // 字段真实名称权限类型的定义。
   protected int _labelSecurityCd;

   // 存储字段性别代码的定义。
   private int __genderCd;

   // 字段性别代码的定义。
   protected int _genderCd;

   // 存储字段性别权限类型的定义。
   private int __genderSecurityCd;

   // 字段性别权限类型的定义。
   protected int _genderSecurityCd;

   // 存储字段生日的定义。
   private TDateTime __birthday = new TDateTime();

   // 字段生日的定义。
   protected TDateTime _birthday = new TDateTime();

   // 存储字段生日权限类型的定义。
   private int __birthdaySecurityCd;

   // 字段生日权限类型的定义。
   protected int _birthdaySecurityCd;

   // 存储字段图标地址的定义。
   private String __iconUrl;

   // 字段图标地址的定义。
   protected String _iconUrl;

   // 存储字段联系电话号码的定义。
   private String __contactPhone;

   // 字段联系电话号码的定义。
   protected String _contactPhone;

   // 存储字段联系电话权号码限类型的定义。
   private int __contactPhoneSecurityCd;

   // 字段联系电话权号码限类型的定义。
   protected int _contactPhoneSecurityCd;

   // 存储字段联系电话号码验证类型的定义。
   private int __contactPhoneVerifyCd;

   // 字段联系电话号码验证类型的定义。
   protected int _contactPhoneVerifyCd;

   // 存储字段联系邮箱地址的定义。
   private String __contactEmail;

   // 字段联系邮箱地址的定义。
   protected String _contactEmail;

   // 存储字段联系邮箱地址验证类型的定义。
   private int __contactEmailSecurityCd;

   // 字段联系邮箱地址验证类型的定义。
   protected int _contactEmailSecurityCd;

   // 存储字段联系邮箱地址验证类型的定义。
   private int __contactEmailVerifyCd;

   // 字段联系邮箱地址验证类型的定义。
   protected int _contactEmailVerifyCd;

   // 存储字段联系QQ号码的定义。
   private String __contactQq;

   // 字段联系QQ号码的定义。
   protected String _contactQq;

   // 存储字段联系QQ号码权限类型的定义。
   private int __contactQqSecurityCd;

   // 字段联系QQ号码权限类型的定义。
   protected int _contactQqSecurityCd;

   // 存储字段联系MSN号码的定义。
   private String __contactMsn;

   // 字段联系MSN号码的定义。
   protected String _contactMsn;

   // 存储字段联系MSN号码权限类型的定义。
   private int __contactMsnSecurityCd;

   // 字段联系MSN号码权限类型的定义。
   protected int _contactMsnSecurityCd;

   // 存储字段学校类型的定义。
   private int __schoolCd;

   // 字段学校类型的定义。
   protected int _schoolCd;

   // 存储字段学校编号的定义。
   private long __schoolId;

   // 字段学校编号的定义。
   protected long _schoolId;

   // 存储字段学校名称的定义。
   private String __schoolLabel;

   // 字段学校名称的定义。
   protected String _schoolLabel;

   // 存储字段入学年份的定义。
   private int __schoolEnterYear;

   // 字段入学年份的定义。
   protected int _schoolEnterYear;

   // 存储字段院系编号的定义。
   private long __schoolPartId;

   // 字段院系编号的定义。
   protected long _schoolPartId;

   // 存储字段院系名称的定义。
   private String __schoolPartLabel;

   // 字段院系名称的定义。
   protected String _schoolPartLabel;

   // 存储字段班级编号的定义。
   private long __schoolClassId;

   // 字段班级编号的定义。
   protected long _schoolClassId;

   // 存储字段班级名称的定义。
   private String __schoolClassLabel;

   // 字段班级名称的定义。
   protected String _schoolClassLabel;

   // 存储字段公司编号的定义。
   private long __companyId;

   // 字段公司编号的定义。
   protected long _companyId;

   // 存储字段公司名称的定义。
   private String __companyLabel;

   // 字段公司名称的定义。
   protected String _companyLabel;

   // 存储字段省份编号的定义。
   private long __homeProvinceId;

   // 字段省份编号的定义。
   protected long _homeProvinceId;

   // 存储字段家庭电话的定义。
   private String __homePhone;

   // 字段家庭电话的定义。
   protected String _homePhone;

   // 存储字段家庭地址的定义。
   private String __homeAddress;

   // 字段家庭地址的定义。
   protected String _homeAddress;

   // 存储字段级别的定义。
   private int __scoreLevel;

   // 字段级别的定义。
   protected int _scoreLevel;

   // 存储字段点数(豆豆)的定义。
   private int __scoreBean;

   // 字段点数(豆豆)的定义。
   protected int _scoreBean;

   // 存储字段最大点数(豆豆)的定义。
   private int __scoreBeanExperience;

   // 字段最大点数(豆豆)的定义。
   protected int _scoreBeanExperience;

   // 存储字段点数(豆币)的定义。
   private int __scorePoint;

   // 字段点数(豆币)的定义。
   protected int _scorePoint;

   // 存储字段最大点数(豆币)的定义。
   private int __scorePointExperience;

   // 字段最大点数(豆币)的定义。
   protected int _scorePointExperience;

   // 存储字段点数(金币)的定义。
   private float __scoreGold;

   // 字段点数(金币)的定义。
   protected float _scoreGold;

   // 存储字段最大点数(金币)的定义。
   private int __scoreGoldExperience;

   // 字段最大点数(金币)的定义。
   protected int _scoreGoldExperience;

   // 存储字段描述的定义。
   private String __description;

   // 字段描述的定义。
   protected String _description;

   // 存储字段内容的定义。
   private String __content;

   // 字段内容的定义。
   protected String _content;

   // 存储字段备注的定义。
   private String __note;

   // 字段备注的定义。
   protected String _note;

   // 存储字段创建用户标识的定义。
   private long __createUserId;

   // 字段创建用户标识的定义。
   protected long _createUserId;

   // 存储字段创建日期的定义。
   private TDateTime __createDate = new TDateTime();

   // 字段创建日期的定义。
   protected TDateTime _createDate = new TDateTime();

   // 存储字段更新者标识的定义。
   private long __updateUserId;

   // 字段更新者标识的定义。
   protected long _updateUserId;

   // 存储字段更新时间的定义。
   private TDateTime __updateDate = new TDateTime();

   // 字段更新时间的定义。
   protected TDateTime _updateDate = new TDateTime();

   //============================================================
   // <T>构造人员用户信息逻辑单元。</T>
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
   // <T>判断对象唯一标识的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isGuidChanged(){
      return !RString.equals(__guid, _guid);
   }

   //============================================================
   // <T>获得对象唯一标识的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String guid(){
      return _guid;
   }

   //============================================================
   // <T>设置对象唯一标识的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setGuid(String value){
      _guid = value;
   }

   //============================================================
   // <T>判断代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCodeChanged(){
      return !RString.equals(__code, _code);
   }

   //============================================================
   // <T>获得代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String code(){
      return _code;
   }

   //============================================================
   // <T>设置代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCode(String value){
      _code = value;
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
   // <T>判断上次登录时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPassportLoginDateChanged(){
      return !__passportLoginDate.equals(_passportLoginDate);
   }

   //============================================================
   // <T>获得上次登录时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime passportLoginDate(){
      return _passportLoginDate;
   }

   //============================================================
   // <T>设置上次登录时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPassportLoginDate(TDateTime value){
      _passportLoginDate = value;
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
   // <T>判断密码更新时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPasswordUpdateDateChanged(){
      return !__passwordUpdateDate.equals(_passwordUpdateDate);
   }

   //============================================================
   // <T>获得密码更新时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime passwordUpdateDate(){
      return _passwordUpdateDate;
   }

   //============================================================
   // <T>设置密码更新时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPasswordUpdateDate(TDateTime value){
      _passwordUpdateDate = value;
   }

   //============================================================
   // <T>判断状态类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isStatusCdChanged(){
      return __statusCd != _statusCd;
   }

   //============================================================
   // <T>获得状态类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int statusCd(){
      return _statusCd;
   }

   //============================================================
   // <T>设置状态类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setStatusCd(int value){
      _statusCd = value;
   }

   //============================================================
   // <T>判断角色类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRoleCdChanged(){
      return __roleCd != _roleCd;
   }

   //============================================================
   // <T>获得角色类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int roleCd(){
      return _roleCd;
   }

   //============================================================
   // <T>设置角色类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRoleCd(int value){
      _roleCd = value;
   }

   //============================================================
   // <T>判断业务角色编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRoleIdChanged(){
      return __roleId != _roleId;
   }

   //============================================================
   // <T>获得业务角色编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long roleId(){
      return _roleId;
   }

   //============================================================
   // <T>设置业务角色编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRoleId(long value){
      _roleId = value;
   }

   //============================================================
   // <T>判断开发类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDevelopCdChanged(){
      return __developCd != _developCd;
   }

   //============================================================
   // <T>获得开发类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int developCd(){
      return _developCd;
   }

   //============================================================
   // <T>设置开发类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDevelopCd(int value){
      _developCd = value;
   }

   //============================================================
   // <T>判断教师类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isTeacherCdChanged(){
      return __teacherCd != _teacherCd;
   }

   //============================================================
   // <T>获得教师类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int teacherCd(){
      return _teacherCd;
   }

   //============================================================
   // <T>设置教师类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setTeacherCd(int value){
      _teacherCd = value;
   }

   //============================================================
   // <T>判断导师编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isTeacherIdChanged(){
      return __teacherId != _teacherId;
   }

   //============================================================
   // <T>获得导师编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long teacherId(){
      return _teacherId;
   }

   //============================================================
   // <T>设置导师编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setTeacherId(long value){
      _teacherId = value;
   }

   //============================================================
   // <T>判断显示名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAliasChanged(){
      return !RString.equals(__alias, _alias);
   }

   //============================================================
   // <T>获得显示名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String alias(){
      return _alias;
   }

   //============================================================
   // <T>设置显示名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAlias(String value){
      _alias = value;
   }

   //============================================================
   // <T>判断真实名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLabelChanged(){
      return !RString.equals(__label, _label);
   }

   //============================================================
   // <T>获得真实名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String label(){
      return _label;
   }

   //============================================================
   // <T>设置真实名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLabel(String value){
      _label = value;
   }

   //============================================================
   // <T>判断真实名称权限类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLabelSecurityCdChanged(){
      return __labelSecurityCd != _labelSecurityCd;
   }

   //============================================================
   // <T>获得真实名称权限类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int labelSecurityCd(){
      return _labelSecurityCd;
   }

   //============================================================
   // <T>设置真实名称权限类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLabelSecurityCd(int value){
      _labelSecurityCd = value;
   }

   //============================================================
   // <T>判断性别代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isGenderCdChanged(){
      return __genderCd != _genderCd;
   }

   //============================================================
   // <T>获得性别代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int genderCd(){
      return _genderCd;
   }

   //============================================================
   // <T>设置性别代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setGenderCd(int value){
      _genderCd = value;
   }

   //============================================================
   // <T>判断性别权限类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isGenderSecurityCdChanged(){
      return __genderSecurityCd != _genderSecurityCd;
   }

   //============================================================
   // <T>获得性别权限类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int genderSecurityCd(){
      return _genderSecurityCd;
   }

   //============================================================
   // <T>设置性别权限类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setGenderSecurityCd(int value){
      _genderSecurityCd = value;
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
   // <T>判断生日权限类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBirthdaySecurityCdChanged(){
      return __birthdaySecurityCd != _birthdaySecurityCd;
   }

   //============================================================
   // <T>获得生日权限类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int birthdaySecurityCd(){
      return _birthdaySecurityCd;
   }

   //============================================================
   // <T>设置生日权限类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBirthdaySecurityCd(int value){
      _birthdaySecurityCd = value;
   }

   //============================================================
   // <T>判断图标地址的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isIconUrlChanged(){
      return !RString.equals(__iconUrl, _iconUrl);
   }

   //============================================================
   // <T>获得图标地址的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String iconUrl(){
      return _iconUrl;
   }

   //============================================================
   // <T>设置图标地址的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setIconUrl(String value){
      _iconUrl = value;
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
   // <T>判断联系电话权号码限类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContactPhoneSecurityCdChanged(){
      return __contactPhoneSecurityCd != _contactPhoneSecurityCd;
   }

   //============================================================
   // <T>获得联系电话权号码限类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int contactPhoneSecurityCd(){
      return _contactPhoneSecurityCd;
   }

   //============================================================
   // <T>设置联系电话权号码限类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContactPhoneSecurityCd(int value){
      _contactPhoneSecurityCd = value;
   }

   //============================================================
   // <T>判断联系电话号码验证类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContactPhoneVerifyCdChanged(){
      return __contactPhoneVerifyCd != _contactPhoneVerifyCd;
   }

   //============================================================
   // <T>获得联系电话号码验证类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int contactPhoneVerifyCd(){
      return _contactPhoneVerifyCd;
   }

   //============================================================
   // <T>设置联系电话号码验证类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContactPhoneVerifyCd(int value){
      _contactPhoneVerifyCd = value;
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
   // <T>判断联系邮箱地址验证类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContactEmailSecurityCdChanged(){
      return __contactEmailSecurityCd != _contactEmailSecurityCd;
   }

   //============================================================
   // <T>获得联系邮箱地址验证类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int contactEmailSecurityCd(){
      return _contactEmailSecurityCd;
   }

   //============================================================
   // <T>设置联系邮箱地址验证类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContactEmailSecurityCd(int value){
      _contactEmailSecurityCd = value;
   }

   //============================================================
   // <T>判断联系邮箱地址验证类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContactEmailVerifyCdChanged(){
      return __contactEmailVerifyCd != _contactEmailVerifyCd;
   }

   //============================================================
   // <T>获得联系邮箱地址验证类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int contactEmailVerifyCd(){
      return _contactEmailVerifyCd;
   }

   //============================================================
   // <T>设置联系邮箱地址验证类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContactEmailVerifyCd(int value){
      _contactEmailVerifyCd = value;
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
   // <T>判断联系QQ号码权限类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContactQqSecurityCdChanged(){
      return __contactQqSecurityCd != _contactQqSecurityCd;
   }

   //============================================================
   // <T>获得联系QQ号码权限类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int contactQqSecurityCd(){
      return _contactQqSecurityCd;
   }

   //============================================================
   // <T>设置联系QQ号码权限类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContactQqSecurityCd(int value){
      _contactQqSecurityCd = value;
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
   // <T>判断联系MSN号码权限类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContactMsnSecurityCdChanged(){
      return __contactMsnSecurityCd != _contactMsnSecurityCd;
   }

   //============================================================
   // <T>获得联系MSN号码权限类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int contactMsnSecurityCd(){
      return _contactMsnSecurityCd;
   }

   //============================================================
   // <T>设置联系MSN号码权限类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContactMsnSecurityCd(int value){
      _contactMsnSecurityCd = value;
   }

   //============================================================
   // <T>判断学校类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSchoolCdChanged(){
      return __schoolCd != _schoolCd;
   }

   //============================================================
   // <T>获得学校类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int schoolCd(){
      return _schoolCd;
   }

   //============================================================
   // <T>设置学校类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSchoolCd(int value){
      _schoolCd = value;
   }

   //============================================================
   // <T>判断学校编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSchoolIdChanged(){
      return __schoolId != _schoolId;
   }

   //============================================================
   // <T>获得学校编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long schoolId(){
      return _schoolId;
   }

   //============================================================
   // <T>设置学校编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSchoolId(long value){
      _schoolId = value;
   }

   //============================================================
   // <T>判断学校名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSchoolLabelChanged(){
      return !RString.equals(__schoolLabel, _schoolLabel);
   }

   //============================================================
   // <T>获得学校名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String schoolLabel(){
      return _schoolLabel;
   }

   //============================================================
   // <T>设置学校名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSchoolLabel(String value){
      _schoolLabel = value;
   }

   //============================================================
   // <T>判断入学年份的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSchoolEnterYearChanged(){
      return __schoolEnterYear != _schoolEnterYear;
   }

   //============================================================
   // <T>获得入学年份的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int schoolEnterYear(){
      return _schoolEnterYear;
   }

   //============================================================
   // <T>设置入学年份的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSchoolEnterYear(int value){
      _schoolEnterYear = value;
   }

   //============================================================
   // <T>判断院系编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSchoolPartIdChanged(){
      return __schoolPartId != _schoolPartId;
   }

   //============================================================
   // <T>获得院系编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long schoolPartId(){
      return _schoolPartId;
   }

   //============================================================
   // <T>设置院系编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSchoolPartId(long value){
      _schoolPartId = value;
   }

   //============================================================
   // <T>判断院系名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSchoolPartLabelChanged(){
      return !RString.equals(__schoolPartLabel, _schoolPartLabel);
   }

   //============================================================
   // <T>获得院系名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String schoolPartLabel(){
      return _schoolPartLabel;
   }

   //============================================================
   // <T>设置院系名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSchoolPartLabel(String value){
      _schoolPartLabel = value;
   }

   //============================================================
   // <T>判断班级编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSchoolClassIdChanged(){
      return __schoolClassId != _schoolClassId;
   }

   //============================================================
   // <T>获得班级编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long schoolClassId(){
      return _schoolClassId;
   }

   //============================================================
   // <T>设置班级编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSchoolClassId(long value){
      _schoolClassId = value;
   }

   //============================================================
   // <T>判断班级名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isSchoolClassLabelChanged(){
      return !RString.equals(__schoolClassLabel, _schoolClassLabel);
   }

   //============================================================
   // <T>获得班级名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String schoolClassLabel(){
      return _schoolClassLabel;
   }

   //============================================================
   // <T>设置班级名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setSchoolClassLabel(String value){
      _schoolClassLabel = value;
   }

   //============================================================
   // <T>判断公司编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCompanyIdChanged(){
      return __companyId != _companyId;
   }

   //============================================================
   // <T>获得公司编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long companyId(){
      return _companyId;
   }

   //============================================================
   // <T>设置公司编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCompanyId(long value){
      _companyId = value;
   }

   //============================================================
   // <T>判断公司名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCompanyLabelChanged(){
      return !RString.equals(__companyLabel, _companyLabel);
   }

   //============================================================
   // <T>获得公司名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String companyLabel(){
      return _companyLabel;
   }

   //============================================================
   // <T>设置公司名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCompanyLabel(String value){
      _companyLabel = value;
   }

   //============================================================
   // <T>判断省份编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isHomeProvinceIdChanged(){
      return __homeProvinceId != _homeProvinceId;
   }

   //============================================================
   // <T>获得省份编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long homeProvinceId(){
      return _homeProvinceId;
   }

   //============================================================
   // <T>设置省份编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setHomeProvinceId(long value){
      _homeProvinceId = value;
   }

   //============================================================
   // <T>判断家庭电话的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isHomePhoneChanged(){
      return !RString.equals(__homePhone, _homePhone);
   }

   //============================================================
   // <T>获得家庭电话的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String homePhone(){
      return _homePhone;
   }

   //============================================================
   // <T>设置家庭电话的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setHomePhone(String value){
      _homePhone = value;
   }

   //============================================================
   // <T>判断家庭地址的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isHomeAddressChanged(){
      return !RString.equals(__homeAddress, _homeAddress);
   }

   //============================================================
   // <T>获得家庭地址的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String homeAddress(){
      return _homeAddress;
   }

   //============================================================
   // <T>设置家庭地址的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setHomeAddress(String value){
      _homeAddress = value;
   }

   //============================================================
   // <T>判断级别的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isScoreLevelChanged(){
      return __scoreLevel != _scoreLevel;
   }

   //============================================================
   // <T>获得级别的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int scoreLevel(){
      return _scoreLevel;
   }

   //============================================================
   // <T>设置级别的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setScoreLevel(int value){
      _scoreLevel = value;
   }

   //============================================================
   // <T>判断点数(豆豆)的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isScoreBeanChanged(){
      return __scoreBean != _scoreBean;
   }

   //============================================================
   // <T>获得点数(豆豆)的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int scoreBean(){
      return _scoreBean;
   }

   //============================================================
   // <T>设置点数(豆豆)的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setScoreBean(int value){
      _scoreBean = value;
   }

   //============================================================
   // <T>判断最大点数(豆豆)的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isScoreBeanExperienceChanged(){
      return __scoreBeanExperience != _scoreBeanExperience;
   }

   //============================================================
   // <T>获得最大点数(豆豆)的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int scoreBeanExperience(){
      return _scoreBeanExperience;
   }

   //============================================================
   // <T>设置最大点数(豆豆)的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setScoreBeanExperience(int value){
      _scoreBeanExperience = value;
   }

   //============================================================
   // <T>判断点数(豆币)的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isScorePointChanged(){
      return __scorePoint != _scorePoint;
   }

   //============================================================
   // <T>获得点数(豆币)的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int scorePoint(){
      return _scorePoint;
   }

   //============================================================
   // <T>设置点数(豆币)的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setScorePoint(int value){
      _scorePoint = value;
   }

   //============================================================
   // <T>判断最大点数(豆币)的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isScorePointExperienceChanged(){
      return __scorePointExperience != _scorePointExperience;
   }

   //============================================================
   // <T>获得最大点数(豆币)的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int scorePointExperience(){
      return _scorePointExperience;
   }

   //============================================================
   // <T>设置最大点数(豆币)的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setScorePointExperience(int value){
      _scorePointExperience = value;
   }

   //============================================================
   // <T>判断点数(金币)的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isScoreGoldChanged(){
      return __scoreGold != _scoreGold;
   }

   //============================================================
   // <T>获得点数(金币)的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public float scoreGold(){
      return _scoreGold;
   }

   //============================================================
   // <T>设置点数(金币)的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setScoreGold(float value){
      _scoreGold = value;
   }

   //============================================================
   // <T>判断最大点数(金币)的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isScoreGoldExperienceChanged(){
      return __scoreGoldExperience != _scoreGoldExperience;
   }

   //============================================================
   // <T>获得最大点数(金币)的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int scoreGoldExperience(){
      return _scoreGoldExperience;
   }

   //============================================================
   // <T>设置最大点数(金币)的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setScoreGoldExperience(int value){
      _scoreGoldExperience = value;
   }

   //============================================================
   // <T>判断描述的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDescriptionChanged(){
      return !RString.equals(__description, _description);
   }

   //============================================================
   // <T>获得描述的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String description(){
      return _description;
   }

   //============================================================
   // <T>设置描述的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDescription(String value){
      _description = value;
   }

   //============================================================
   // <T>判断内容的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContentChanged(){
      return !RString.equals(__content, _content);
   }

   //============================================================
   // <T>获得内容的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String content(){
      return _content;
   }

   //============================================================
   // <T>设置内容的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContent(String value){
      _content = value;
   }

   //============================================================
   // <T>判断备注的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isNoteChanged(){
      return !RString.equals(__note, _note);
   }

   //============================================================
   // <T>获得备注的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String note(){
      return _note;
   }

   //============================================================
   // <T>设置备注的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setNote(String value){
      _note = value;
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
   public long createUserId(){
      return _createUserId;
   }

   //============================================================
   // <T>设置创建用户标识的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCreateUserId(long value){
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
   public long updateUserId(){
      return _updateUserId;
   }

   //============================================================
   // <T>设置更新者标识的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setUpdateUserId(long value){
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
   // <T>根据名称获得内容。</T>
   //
   // @param name 名称
   // @return 内容
   //============================================================
   @Override
   public String get(String name){
      switch(name){
         case "ouid":
            return Long.toString(_ouid);
         case "ovld":
            return RBoolean.toString(_ovld);
         case "guid":
            return _guid;
         case "code":
            return _code;
         case "passport":
            return _passport;
         case "passport_login_date":
            return _passportLoginDate.toString();
         case "password":
            return _password;
         case "password_update_date":
            return _passwordUpdateDate.toString();
         case "status_cd":
            return RInteger.toString(_statusCd);
         case "role_cd":
            return RInteger.toString(_roleCd);
         case "role_id":
            return Long.toString(_roleId);
         case "develop_cd":
            return RInteger.toString(_developCd);
         case "teacher_cd":
            return RInteger.toString(_teacherCd);
         case "teacher_id":
            return Long.toString(_teacherId);
         case "alias":
            return _alias;
         case "label":
            return _label;
         case "label_security_cd":
            return RInteger.toString(_labelSecurityCd);
         case "gender_cd":
            return RInteger.toString(_genderCd);
         case "gender_security_cd":
            return RInteger.toString(_genderSecurityCd);
         case "birthday":
            return _birthday.toString();
         case "birthday_security_cd":
            return RInteger.toString(_birthdaySecurityCd);
         case "icon_url":
            return _iconUrl;
         case "contact_phone":
            return _contactPhone;
         case "contact_phone_security_cd":
            return RInteger.toString(_contactPhoneSecurityCd);
         case "contact_phone_verify_cd":
            return RInteger.toString(_contactPhoneVerifyCd);
         case "contact_email":
            return _contactEmail;
         case "contact_email_security_cd":
            return RInteger.toString(_contactEmailSecurityCd);
         case "contact_email_verify_cd":
            return RInteger.toString(_contactEmailVerifyCd);
         case "contact_qq":
            return _contactQq;
         case "contact_qq_security_cd":
            return RInteger.toString(_contactQqSecurityCd);
         case "contact_msn":
            return _contactMsn;
         case "contact_msn_security_cd":
            return RInteger.toString(_contactMsnSecurityCd);
         case "school_cd":
            return RInteger.toString(_schoolCd);
         case "school_id":
            return Long.toString(_schoolId);
         case "school_label":
            return _schoolLabel;
         case "school_enter_year":
            return RInteger.toString(_schoolEnterYear);
         case "school_part_id":
            return Long.toString(_schoolPartId);
         case "school_part_label":
            return _schoolPartLabel;
         case "school_class_id":
            return Long.toString(_schoolClassId);
         case "school_class_label":
            return _schoolClassLabel;
         case "company_id":
            return Long.toString(_companyId);
         case "company_label":
            return _companyLabel;
         case "home_province_id":
            return Long.toString(_homeProvinceId);
         case "home_phone":
            return _homePhone;
         case "home_address":
            return _homeAddress;
         case "score_level":
            return RInteger.toString(_scoreLevel);
         case "score_bean":
            return RInteger.toString(_scoreBean);
         case "score_bean_experience":
            return RInteger.toString(_scoreBeanExperience);
         case "score_point":
            return RInteger.toString(_scorePoint);
         case "score_point_experience":
            return RInteger.toString(_scorePointExperience);
         case "score_gold":
            return RFloat.toString(_scoreGold);
         case "score_gold_experience":
            return RInteger.toString(_scoreGoldExperience);
         case "description":
            return _description;
         case "content":
            return _content;
         case "note":
            return _note;
         case "create_user_id":
            return Long.toString(_createUserId);
         case "create_date":
            return _createDate.toString();
         case "update_user_id":
            return Long.toString(_updateUserId);
         case "update_date":
            return _updateDate.toString();
      }
      return null;
   }

   //============================================================
   // <T>根据名称设置内容。</T>
   //
   // @param name 名称
   // @param value 内容
   //============================================================
   @Override
   public void set(String name,
                   String value){
      switch(name){
         case "ouid":
            _ouid = RLong.parse(value);
            break;
         case "ovld":
            _ovld = RBoolean.parse(value);
            break;
         case "guid":
            _guid = value;
            break;
         case "code":
            _code = value;
            break;
         case "passport":
            _passport = value;
            break;
         case "passport_login_date":
            _passportLoginDate.parse(value);
            break;
         case "password":
            _password = value;
            break;
         case "password_update_date":
            _passwordUpdateDate.parse(value);
            break;
         case "status_cd":
            _statusCd = RInteger.parse(value);
            break;
         case "role_cd":
            _roleCd = RInteger.parse(value);
            break;
         case "role_id":
            _roleId = RLong.parse(value);
            break;
         case "develop_cd":
            _developCd = RInteger.parse(value);
            break;
         case "teacher_cd":
            _teacherCd = RInteger.parse(value);
            break;
         case "teacher_id":
            _teacherId = RLong.parse(value);
            break;
         case "alias":
            _alias = value;
            break;
         case "label":
            _label = value;
            break;
         case "label_security_cd":
            _labelSecurityCd = RInteger.parse(value);
            break;
         case "gender_cd":
            _genderCd = RInteger.parse(value);
            break;
         case "gender_security_cd":
            _genderSecurityCd = RInteger.parse(value);
            break;
         case "birthday":
            _birthday.parse(value);
            break;
         case "birthday_security_cd":
            _birthdaySecurityCd = RInteger.parse(value);
            break;
         case "icon_url":
            _iconUrl = value;
            break;
         case "contact_phone":
            _contactPhone = value;
            break;
         case "contact_phone_security_cd":
            _contactPhoneSecurityCd = RInteger.parse(value);
            break;
         case "contact_phone_verify_cd":
            _contactPhoneVerifyCd = RInteger.parse(value);
            break;
         case "contact_email":
            _contactEmail = value;
            break;
         case "contact_email_security_cd":
            _contactEmailSecurityCd = RInteger.parse(value);
            break;
         case "contact_email_verify_cd":
            _contactEmailVerifyCd = RInteger.parse(value);
            break;
         case "contact_qq":
            _contactQq = value;
            break;
         case "contact_qq_security_cd":
            _contactQqSecurityCd = RInteger.parse(value);
            break;
         case "contact_msn":
            _contactMsn = value;
            break;
         case "contact_msn_security_cd":
            _contactMsnSecurityCd = RInteger.parse(value);
            break;
         case "school_cd":
            _schoolCd = RInteger.parse(value);
            break;
         case "school_id":
            _schoolId = RLong.parse(value);
            break;
         case "school_label":
            _schoolLabel = value;
            break;
         case "school_enter_year":
            _schoolEnterYear = RInteger.parse(value);
            break;
         case "school_part_id":
            _schoolPartId = RLong.parse(value);
            break;
         case "school_part_label":
            _schoolPartLabel = value;
            break;
         case "school_class_id":
            _schoolClassId = RLong.parse(value);
            break;
         case "school_class_label":
            _schoolClassLabel = value;
            break;
         case "company_id":
            _companyId = RLong.parse(value);
            break;
         case "company_label":
            _companyLabel = value;
            break;
         case "home_province_id":
            _homeProvinceId = RLong.parse(value);
            break;
         case "home_phone":
            _homePhone = value;
            break;
         case "home_address":
            _homeAddress = value;
            break;
         case "score_level":
            _scoreLevel = RInteger.parse(value);
            break;
         case "score_bean":
            _scoreBean = RInteger.parse(value);
            break;
         case "score_bean_experience":
            _scoreBeanExperience = RInteger.parse(value);
            break;
         case "score_point":
            _scorePoint = RInteger.parse(value);
            break;
         case "score_point_experience":
            _scorePointExperience = RInteger.parse(value);
            break;
         case "score_gold":
            _scoreGold = RFloat.parse(value);
            break;
         case "score_gold_experience":
            _scoreGoldExperience = RInteger.parse(value);
            break;
         case "description":
            _description = value;
            break;
         case "content":
            _content = value;
            break;
         case "note":
            _note = value;
            break;
         case "create_user_id":
            _createUserId = RLong.parse(value);
            break;
         case "create_date":
            _createDate.parse(value);
            break;
         case "update_user_id":
            _updateUserId = RLong.parse(value);
            break;
         case "update_date":
            _updateDate.parse(value);
            break;
      }
   }

   //============================================================
   // <T>加载行记录。</T>
   //
   // @param row 行记录
   //============================================================
   @Override
   public void load(FRow row){
      super.load(row);
      for(IStringPair pair : row){
         String name = pair.name();
         String value = pair.value();
         switch(name){
            case "ouid":
               __ouid = RLong.parse(value);
               _ouid = __ouid;
               break;
            case "ovld":
               __ovld = RBoolean.parse(value);
               _ovld = __ovld;
               break;
            case "guid":
               __guid = value;
               _guid = __guid;
               break;
            case "code":
               __code = value;
               _code = __code;
               break;
            case "passport":
               __passport = value;
               _passport = __passport;
               break;
            case "passport_login_date":
               __passportLoginDate.parse(value);
               _passportLoginDate.assign(__passportLoginDate);
               break;
            case "password":
               __password = value;
               _password = __password;
               break;
            case "password_update_date":
               __passwordUpdateDate.parse(value);
               _passwordUpdateDate.assign(__passwordUpdateDate);
               break;
            case "status_cd":
               __statusCd = RInteger.parse(value);
               _statusCd = __statusCd;
               break;
            case "role_cd":
               __roleCd = RInteger.parse(value);
               _roleCd = __roleCd;
               break;
            case "role_id":
               __roleId = RLong.parse(value);
               _roleId = __roleId;
               break;
            case "develop_cd":
               __developCd = RInteger.parse(value);
               _developCd = __developCd;
               break;
            case "teacher_cd":
               __teacherCd = RInteger.parse(value);
               _teacherCd = __teacherCd;
               break;
            case "teacher_id":
               __teacherId = RLong.parse(value);
               _teacherId = __teacherId;
               break;
            case "alias":
               __alias = value;
               _alias = __alias;
               break;
            case "label":
               __label = value;
               _label = __label;
               break;
            case "label_security_cd":
               __labelSecurityCd = RInteger.parse(value);
               _labelSecurityCd = __labelSecurityCd;
               break;
            case "gender_cd":
               __genderCd = RInteger.parse(value);
               _genderCd = __genderCd;
               break;
            case "gender_security_cd":
               __genderSecurityCd = RInteger.parse(value);
               _genderSecurityCd = __genderSecurityCd;
               break;
            case "birthday":
               __birthday.parse(value);
               _birthday.assign(__birthday);
               break;
            case "birthday_security_cd":
               __birthdaySecurityCd = RInteger.parse(value);
               _birthdaySecurityCd = __birthdaySecurityCd;
               break;
            case "icon_url":
               __iconUrl = value;
               _iconUrl = __iconUrl;
               break;
            case "contact_phone":
               __contactPhone = value;
               _contactPhone = __contactPhone;
               break;
            case "contact_phone_security_cd":
               __contactPhoneSecurityCd = RInteger.parse(value);
               _contactPhoneSecurityCd = __contactPhoneSecurityCd;
               break;
            case "contact_phone_verify_cd":
               __contactPhoneVerifyCd = RInteger.parse(value);
               _contactPhoneVerifyCd = __contactPhoneVerifyCd;
               break;
            case "contact_email":
               __contactEmail = value;
               _contactEmail = __contactEmail;
               break;
            case "contact_email_security_cd":
               __contactEmailSecurityCd = RInteger.parse(value);
               _contactEmailSecurityCd = __contactEmailSecurityCd;
               break;
            case "contact_email_verify_cd":
               __contactEmailVerifyCd = RInteger.parse(value);
               _contactEmailVerifyCd = __contactEmailVerifyCd;
               break;
            case "contact_qq":
               __contactQq = value;
               _contactQq = __contactQq;
               break;
            case "contact_qq_security_cd":
               __contactQqSecurityCd = RInteger.parse(value);
               _contactQqSecurityCd = __contactQqSecurityCd;
               break;
            case "contact_msn":
               __contactMsn = value;
               _contactMsn = __contactMsn;
               break;
            case "contact_msn_security_cd":
               __contactMsnSecurityCd = RInteger.parse(value);
               _contactMsnSecurityCd = __contactMsnSecurityCd;
               break;
            case "school_cd":
               __schoolCd = RInteger.parse(value);
               _schoolCd = __schoolCd;
               break;
            case "school_id":
               __schoolId = RLong.parse(value);
               _schoolId = __schoolId;
               break;
            case "school_label":
               __schoolLabel = value;
               _schoolLabel = __schoolLabel;
               break;
            case "school_enter_year":
               __schoolEnterYear = RInteger.parse(value);
               _schoolEnterYear = __schoolEnterYear;
               break;
            case "school_part_id":
               __schoolPartId = RLong.parse(value);
               _schoolPartId = __schoolPartId;
               break;
            case "school_part_label":
               __schoolPartLabel = value;
               _schoolPartLabel = __schoolPartLabel;
               break;
            case "school_class_id":
               __schoolClassId = RLong.parse(value);
               _schoolClassId = __schoolClassId;
               break;
            case "school_class_label":
               __schoolClassLabel = value;
               _schoolClassLabel = __schoolClassLabel;
               break;
            case "company_id":
               __companyId = RLong.parse(value);
               _companyId = __companyId;
               break;
            case "company_label":
               __companyLabel = value;
               _companyLabel = __companyLabel;
               break;
            case "home_province_id":
               __homeProvinceId = RLong.parse(value);
               _homeProvinceId = __homeProvinceId;
               break;
            case "home_phone":
               __homePhone = value;
               _homePhone = __homePhone;
               break;
            case "home_address":
               __homeAddress = value;
               _homeAddress = __homeAddress;
               break;
            case "score_level":
               __scoreLevel = RInteger.parse(value);
               _scoreLevel = __scoreLevel;
               break;
            case "score_bean":
               __scoreBean = RInteger.parse(value);
               _scoreBean = __scoreBean;
               break;
            case "score_bean_experience":
               __scoreBeanExperience = RInteger.parse(value);
               _scoreBeanExperience = __scoreBeanExperience;
               break;
            case "score_point":
               __scorePoint = RInteger.parse(value);
               _scorePoint = __scorePoint;
               break;
            case "score_point_experience":
               __scorePointExperience = RInteger.parse(value);
               _scorePointExperience = __scorePointExperience;
               break;
            case "score_gold":
               __scoreGold = RFloat.parse(value);
               _scoreGold = __scoreGold;
               break;
            case "score_gold_experience":
               __scoreGoldExperience = RInteger.parse(value);
               _scoreGoldExperience = __scoreGoldExperience;
               break;
            case "description":
               __description = value;
               _description = __description;
               break;
            case "content":
               __content = value;
               _content = __content;
               break;
            case "note":
               __note = value;
               _note = __note;
               break;
            case "create_user_id":
               __createUserId = RLong.parse(value);
               _createUserId = __createUserId;
               break;
            case "create_date":
               __createDate.parse(value);
               _createDate.assign(__createDate);
               break;
            case "update_user_id":
               __updateUserId = RLong.parse(value);
               _updateUserId = __updateUserId;
               break;
            case "update_date":
               __updateDate.parse(value);
               _updateDate.assign(__updateDate);
               break;
         }
      }
   }

   //============================================================
   // <T>存储行记录。</T>
   //
   // @param row 行记录
   //============================================================
   @Override
   public void save(FRow row){
      super.load(row);
      row.set("ouid", _ouid);
      row.set("ovld", _ovld);
      row.set("guid", _guid);
      row.set("code", _code);
      row.set("passport", _passport);
      row.set("passportLoginDate", _passportLoginDate);
      row.set("password", _password);
      row.set("passwordUpdateDate", _passwordUpdateDate);
      row.set("statusCd", _statusCd);
      row.set("roleCd", _roleCd);
      row.set("roleId", _roleId);
      row.set("developCd", _developCd);
      row.set("teacherCd", _teacherCd);
      row.set("teacherId", _teacherId);
      row.set("alias", _alias);
      row.set("label", _label);
      row.set("labelSecurityCd", _labelSecurityCd);
      row.set("genderCd", _genderCd);
      row.set("genderSecurityCd", _genderSecurityCd);
      row.set("birthday", _birthday);
      row.set("birthdaySecurityCd", _birthdaySecurityCd);
      row.set("iconUrl", _iconUrl);
      row.set("contactPhone", _contactPhone);
      row.set("contactPhoneSecurityCd", _contactPhoneSecurityCd);
      row.set("contactPhoneVerifyCd", _contactPhoneVerifyCd);
      row.set("contactEmail", _contactEmail);
      row.set("contactEmailSecurityCd", _contactEmailSecurityCd);
      row.set("contactEmailVerifyCd", _contactEmailVerifyCd);
      row.set("contactQq", _contactQq);
      row.set("contactQqSecurityCd", _contactQqSecurityCd);
      row.set("contactMsn", _contactMsn);
      row.set("contactMsnSecurityCd", _contactMsnSecurityCd);
      row.set("schoolCd", _schoolCd);
      row.set("schoolId", _schoolId);
      row.set("schoolLabel", _schoolLabel);
      row.set("schoolEnterYear", _schoolEnterYear);
      row.set("schoolPartId", _schoolPartId);
      row.set("schoolPartLabel", _schoolPartLabel);
      row.set("schoolClassId", _schoolClassId);
      row.set("schoolClassLabel", _schoolClassLabel);
      row.set("companyId", _companyId);
      row.set("companyLabel", _companyLabel);
      row.set("homeProvinceId", _homeProvinceId);
      row.set("homePhone", _homePhone);
      row.set("homeAddress", _homeAddress);
      row.set("scoreLevel", _scoreLevel);
      row.set("scoreBean", _scoreBean);
      row.set("scoreBeanExperience", _scoreBeanExperience);
      row.set("scorePoint", _scorePoint);
      row.set("scorePointExperience", _scorePointExperience);
      row.set("scoreGold", _scoreGold);
      row.set("scoreGoldExperience", _scoreGoldExperience);
      row.set("description", _description);
      row.set("content", _content);
      row.set("note", _note);
      row.set("createUserId", _createUserId);
      row.set("createDate", _createDate);
      row.set("updateUserId", _updateUserId);
      row.set("updateDate", _updateDate);
   }

   //============================================================
   // <T>保存对照表。</T>
   //
   // @param map 对照表
   //============================================================
   @Override
   public void saveMap(Map<String, String> map){
      super.saveMap(map);
      map.put("ouid", RLong.toString(_ouid));
      map.put("ovld", RBoolean.toString(_ovld));
      map.put("guid", _guid);
      map.put("code", _code);
      map.put("passport", _passport);
      map.put("passportLoginDate", _passportLoginDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("password", _password);
      map.put("passwordUpdateDate", _passwordUpdateDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("statusCd", RInteger.toString(_statusCd));
      map.put("roleCd", RInteger.toString(_roleCd));
      map.put("roleId", RLong.toString(_roleId));
      map.put("developCd", RInteger.toString(_developCd));
      map.put("teacherCd", RInteger.toString(_teacherCd));
      map.put("teacherId", RLong.toString(_teacherId));
      map.put("alias", _alias);
      map.put("label", _label);
      map.put("labelSecurityCd", RInteger.toString(_labelSecurityCd));
      map.put("genderCd", RInteger.toString(_genderCd));
      map.put("genderSecurityCd", RInteger.toString(_genderSecurityCd));
      map.put("birthday", _birthday.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("birthdaySecurityCd", RInteger.toString(_birthdaySecurityCd));
      map.put("iconUrl", _iconUrl);
      map.put("contactPhone", _contactPhone);
      map.put("contactPhoneSecurityCd", RInteger.toString(_contactPhoneSecurityCd));
      map.put("contactPhoneVerifyCd", RInteger.toString(_contactPhoneVerifyCd));
      map.put("contactEmail", _contactEmail);
      map.put("contactEmailSecurityCd", RInteger.toString(_contactEmailSecurityCd));
      map.put("contactEmailVerifyCd", RInteger.toString(_contactEmailVerifyCd));
      map.put("contactQq", _contactQq);
      map.put("contactQqSecurityCd", RInteger.toString(_contactQqSecurityCd));
      map.put("contactMsn", _contactMsn);
      map.put("contactMsnSecurityCd", RInteger.toString(_contactMsnSecurityCd));
      map.put("schoolCd", RInteger.toString(_schoolCd));
      map.put("schoolId", RLong.toString(_schoolId));
      map.put("schoolLabel", _schoolLabel);
      map.put("schoolEnterYear", RInteger.toString(_schoolEnterYear));
      map.put("schoolPartId", RLong.toString(_schoolPartId));
      map.put("schoolPartLabel", _schoolPartLabel);
      map.put("schoolClassId", RLong.toString(_schoolClassId));
      map.put("schoolClassLabel", _schoolClassLabel);
      map.put("companyId", RLong.toString(_companyId));
      map.put("companyLabel", _companyLabel);
      map.put("homeProvinceId", RLong.toString(_homeProvinceId));
      map.put("homePhone", _homePhone);
      map.put("homeAddress", _homeAddress);
      map.put("scoreLevel", RInteger.toString(_scoreLevel));
      map.put("scoreBean", RInteger.toString(_scoreBean));
      map.put("scoreBeanExperience", RInteger.toString(_scoreBeanExperience));
      map.put("scorePoint", RInteger.toString(_scorePoint));
      map.put("scorePointExperience", RInteger.toString(_scorePointExperience));
      map.put("scoreGold", RFloat.toString(_scoreGold));
      map.put("scoreGoldExperience", RInteger.toString(_scoreGoldExperience));
      map.put("description", _description);
      map.put("content", _content);
      map.put("note", _note);
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
