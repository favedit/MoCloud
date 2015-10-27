package com.cyou.gccloud.data.data;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
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

   // 存储字段对象唯一标识的定义。
   private String __guid;

   // 字段对象唯一标识的定义。
   protected String _guid;

   // 存储字段状态的定义。
   private int __statusCd;

   // 字段状态的定义。
   protected int _statusCd;

   // 存储字段帐号的定义。
   private String __passport;

   // 字段帐号的定义。
   protected String _passport;

   // 存储字段密码的定义。
   private String __password;

   // 字段密码的定义。
   protected String _password;

   // 存储字段代码的定义。
   private String __code;

   // 字段代码的定义。
   protected String _code;

   // 存储字段名称的定义。
   private String __name;

   // 字段名称的定义。
   protected String _name;

   // 存储字段真实名称的定义。
   private String __label;

   // 字段真实名称的定义。
   protected String _label;

   // 存储字段图标地址的定义。
   private String __iconUrl;

   // 字段图标地址的定义。
   protected String _iconUrl;

   // 存储字段联系手机的定义。
   private String __contactPhone;

   // 字段联系手机的定义。
   protected String _contactPhone;

   // 存储字段联系手机验证的定义。
   private int __contactPhoneVerifyCd;

   // 字段联系手机验证的定义。
   protected int _contactPhoneVerifyCd;

   // 存储字段联系邮件的定义。
   private String __contactMail;

   // 字段联系邮件的定义。
   protected String _contactMail;

   // 存储字段联系邮件验证的定义。
   private int __contactMailVerifyCd;

   // 字段联系邮件验证的定义。
   protected int _contactMailVerifyCd;

   // 存储字段身份证号的定义。
   private String __idCard;

   // 字段身份证号的定义。
   protected String _idCard;

   // 存储字段身份证号验证的定义。
   private int __idCardVerifyCd;

   // 字段身份证号验证的定义。
   protected int _idCardVerifyCd;

   // 存储字段用户权限状态的定义。
   private int __roleCd;

   // 字段用户权限状态的定义。
   protected int _roleCd;

   // 存储字段角色编号的定义。
   private long __roleId;

   // 字段角色编号的定义。
   protected long _roleId;

   // 存储字段等级标签的定义。
   private String __rankLabel;

   // 字段等级标签的定义。
   protected String _rankLabel;

   // 存储字段部门标签集合的定义。
   private String __departmentLabels;

   // 字段部门标签集合的定义。
   protected String _departmentLabels;

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
   // <T>判断状态的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isStatusCdChanged(){
      return __statusCd != _statusCd;
   }

   //============================================================
   // <T>获得状态的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int statusCd(){
      return _statusCd;
   }

   //============================================================
   // <T>设置状态的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setStatusCd(int value){
      _statusCd = value;
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
   // <T>判断名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isNameChanged(){
      return !RString.equals(__name, _name);
   }

   //============================================================
   // <T>获得名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String name(){
      return _name;
   }

   //============================================================
   // <T>设置名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setName(String value){
      _name = value;
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
   // <T>判断联系手机的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContactPhoneChanged(){
      return !RString.equals(__contactPhone, _contactPhone);
   }

   //============================================================
   // <T>获得联系手机的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String contactPhone(){
      return _contactPhone;
   }

   //============================================================
   // <T>设置联系手机的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContactPhone(String value){
      _contactPhone = value;
   }

   //============================================================
   // <T>判断联系手机验证的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContactPhoneVerifyCdChanged(){
      return __contactPhoneVerifyCd != _contactPhoneVerifyCd;
   }

   //============================================================
   // <T>获得联系手机验证的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int contactPhoneVerifyCd(){
      return _contactPhoneVerifyCd;
   }

   //============================================================
   // <T>设置联系手机验证的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContactPhoneVerifyCd(int value){
      _contactPhoneVerifyCd = value;
   }

   //============================================================
   // <T>判断联系邮件的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContactMailChanged(){
      return !RString.equals(__contactMail, _contactMail);
   }

   //============================================================
   // <T>获得联系邮件的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String contactMail(){
      return _contactMail;
   }

   //============================================================
   // <T>设置联系邮件的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContactMail(String value){
      _contactMail = value;
   }

   //============================================================
   // <T>判断联系邮件验证的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isContactMailVerifyCdChanged(){
      return __contactMailVerifyCd != _contactMailVerifyCd;
   }

   //============================================================
   // <T>获得联系邮件验证的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int contactMailVerifyCd(){
      return _contactMailVerifyCd;
   }

   //============================================================
   // <T>设置联系邮件验证的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setContactMailVerifyCd(int value){
      _contactMailVerifyCd = value;
   }

   //============================================================
   // <T>判断身份证号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isIdCardChanged(){
      return !RString.equals(__idCard, _idCard);
   }

   //============================================================
   // <T>获得身份证号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String idCard(){
      return _idCard;
   }

   //============================================================
   // <T>设置身份证号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setIdCard(String value){
      _idCard = value;
   }

   //============================================================
   // <T>判断身份证号验证的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isIdCardVerifyCdChanged(){
      return __idCardVerifyCd != _idCardVerifyCd;
   }

   //============================================================
   // <T>获得身份证号验证的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int idCardVerifyCd(){
      return _idCardVerifyCd;
   }

   //============================================================
   // <T>设置身份证号验证的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setIdCardVerifyCd(int value){
      _idCardVerifyCd = value;
   }

   //============================================================
   // <T>判断用户权限状态的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRoleCdChanged(){
      return __roleCd != _roleCd;
   }

   //============================================================
   // <T>获得用户权限状态的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int roleCd(){
      return _roleCd;
   }

   //============================================================
   // <T>设置用户权限状态的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRoleCd(int value){
      _roleCd = value;
   }

   //============================================================
   // <T>判断角色编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRoleIdChanged(){
      return __roleId != _roleId;
   }

   //============================================================
   // <T>获得角色编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long roleId(){
      return _roleId;
   }

   //============================================================
   // <T>设置角色编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRoleId(long value){
      _roleId = value;
   }

   //============================================================
   // <T>判断等级标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRankLabelChanged(){
      return !RString.equals(__rankLabel, _rankLabel);
   }

   //============================================================
   // <T>获得等级标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String rankLabel(){
      return _rankLabel;
   }

   //============================================================
   // <T>设置等级标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRankLabel(String value){
      _rankLabel = value;
   }

   //============================================================
   // <T>判断部门标签集合的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLabelsChanged(){
      return !RString.equals(__departmentLabels, _departmentLabels);
   }

   //============================================================
   // <T>获得部门标签集合的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String departmentLabels(){
      return _departmentLabels;
   }

   //============================================================
   // <T>设置部门标签集合的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLabels(String value){
      _departmentLabels = value;
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
         case "status_cd":
            return RInteger.toString(_statusCd);
         case "passport":
            return _passport;
         case "password":
            return _password;
         case "code":
            return _code;
         case "name":
            return _name;
         case "label":
            return _label;
         case "icon_url":
            return _iconUrl;
         case "contact_phone":
            return _contactPhone;
         case "contact_phone_verify_cd":
            return RInteger.toString(_contactPhoneVerifyCd);
         case "contact_mail":
            return _contactMail;
         case "contact_mail_verify_cd":
            return RInteger.toString(_contactMailVerifyCd);
         case "id_card":
            return _idCard;
         case "id_card_verify_cd":
            return RInteger.toString(_idCardVerifyCd);
         case "role_cd":
            return RInteger.toString(_roleCd);
         case "role_id":
            return Long.toString(_roleId);
         case "rank_label":
            return _rankLabel;
         case "department_labels":
            return _departmentLabels;
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
         case "status_cd":
            _statusCd = RInteger.parse(value);
            break;
         case "passport":
            _passport = value;
            break;
         case "password":
            _password = value;
            break;
         case "code":
            _code = value;
            break;
         case "name":
            _name = value;
            break;
         case "label":
            _label = value;
            break;
         case "icon_url":
            _iconUrl = value;
            break;
         case "contact_phone":
            _contactPhone = value;
            break;
         case "contact_phone_verify_cd":
            _contactPhoneVerifyCd = RInteger.parse(value);
            break;
         case "contact_mail":
            _contactMail = value;
            break;
         case "contact_mail_verify_cd":
            _contactMailVerifyCd = RInteger.parse(value);
            break;
         case "id_card":
            _idCard = value;
            break;
         case "id_card_verify_cd":
            _idCardVerifyCd = RInteger.parse(value);
            break;
         case "role_cd":
            _roleCd = RInteger.parse(value);
            break;
         case "role_id":
            _roleId = RLong.parse(value);
            break;
         case "rank_label":
            _rankLabel = value;
            break;
         case "department_labels":
            _departmentLabels = value;
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
            case "status_cd":
               __statusCd = RInteger.parse(value);
               _statusCd = __statusCd;
               break;
            case "passport":
               __passport = value;
               _passport = __passport;
               break;
            case "password":
               __password = value;
               _password = __password;
               break;
            case "code":
               __code = value;
               _code = __code;
               break;
            case "name":
               __name = value;
               _name = __name;
               break;
            case "label":
               __label = value;
               _label = __label;
               break;
            case "icon_url":
               __iconUrl = value;
               _iconUrl = __iconUrl;
               break;
            case "contact_phone":
               __contactPhone = value;
               _contactPhone = __contactPhone;
               break;
            case "contact_phone_verify_cd":
               __contactPhoneVerifyCd = RInteger.parse(value);
               _contactPhoneVerifyCd = __contactPhoneVerifyCd;
               break;
            case "contact_mail":
               __contactMail = value;
               _contactMail = __contactMail;
               break;
            case "contact_mail_verify_cd":
               __contactMailVerifyCd = RInteger.parse(value);
               _contactMailVerifyCd = __contactMailVerifyCd;
               break;
            case "id_card":
               __idCard = value;
               _idCard = __idCard;
               break;
            case "id_card_verify_cd":
               __idCardVerifyCd = RInteger.parse(value);
               _idCardVerifyCd = __idCardVerifyCd;
               break;
            case "role_cd":
               __roleCd = RInteger.parse(value);
               _roleCd = __roleCd;
               break;
            case "role_id":
               __roleId = RLong.parse(value);
               _roleId = __roleId;
               break;
            case "rank_label":
               __rankLabel = value;
               _rankLabel = __rankLabel;
               break;
            case "department_labels":
               __departmentLabels = value;
               _departmentLabels = __departmentLabels;
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
      row.set("statusCd", _statusCd);
      row.set("passport", _passport);
      row.set("password", _password);
      row.set("code", _code);
      row.set("name", _name);
      row.set("label", _label);
      row.set("iconUrl", _iconUrl);
      row.set("contactPhone", _contactPhone);
      row.set("contactPhoneVerifyCd", _contactPhoneVerifyCd);
      row.set("contactMail", _contactMail);
      row.set("contactMailVerifyCd", _contactMailVerifyCd);
      row.set("idCard", _idCard);
      row.set("idCardVerifyCd", _idCardVerifyCd);
      row.set("roleCd", _roleCd);
      row.set("roleId", _roleId);
      row.set("rankLabel", _rankLabel);
      row.set("departmentLabels", _departmentLabels);
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
      map.put("statusCd", RInteger.toString(_statusCd));
      map.put("passport", _passport);
      map.put("password", _password);
      map.put("code", _code);
      map.put("name", _name);
      map.put("label", _label);
      map.put("iconUrl", _iconUrl);
      map.put("contactPhone", _contactPhone);
      map.put("contactPhoneVerifyCd", RInteger.toString(_contactPhoneVerifyCd));
      map.put("contactMail", _contactMail);
      map.put("contactMailVerifyCd", RInteger.toString(_contactMailVerifyCd));
      map.put("idCard", _idCard);
      map.put("idCardVerifyCd", RInteger.toString(_idCardVerifyCd));
      map.put("roleCd", RInteger.toString(_roleCd));
      map.put("roleId", RLong.toString(_roleId));
      map.put("rankLabel", _rankLabel);
      map.put("departmentLabels", _departmentLabels);
      map.put("description", _description);
      map.put("content", _content);
      map.put("note", _note);
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }

   //============================================================
   // <T>反序列化数据到内容。</T>
   //
   // @param input 输入流
   //============================================================
   @Override
   public void unserialize(IDataInput input){
      super.unserialize(input);
      _ouid = input.readInt64();
      _ovld = input.readBoolean();
      _guid = input.readString();
      _statusCd = input.readInt32();
      _passport = input.readString();
      _password = input.readString();
      _code = input.readString();
      _name = input.readString();
      _label = input.readString();
      _iconUrl = input.readString();
      _contactPhone = input.readString();
      _contactPhoneVerifyCd = input.readInt32();
      _contactMail = input.readString();
      _contactMailVerifyCd = input.readInt32();
      _idCard = input.readString();
      _idCardVerifyCd = input.readInt32();
      _roleCd = input.readInt32();
      _roleId = input.readInt64();
      _rankLabel = input.readString();
      _departmentLabels = input.readString();
      _description = input.readString();
      _content = input.readString();
      _note = input.readString();
      _createUserId = input.readInt64();
      _createDate.set(input.readInt64());
      _updateUserId = input.readInt64();
      _updateDate.set(input.readInt64());
   }

   //============================================================
   // <T>序列化内容到数据。</T>
   //
   // @param output 输出流
   //============================================================
   @Override
   public void serialize(IDataOutput output){
      super.serialize(output);
      output.writeInt64(_ouid);
      output.writeBoolean(_ovld);
      output.writeString(_guid);
      output.writeInt32(_statusCd);
      output.writeString(_passport);
      output.writeString(_password);
      output.writeString(_code);
      output.writeString(_name);
      output.writeString(_label);
      output.writeString(_iconUrl);
      output.writeString(_contactPhone);
      output.writeInt32(_contactPhoneVerifyCd);
      output.writeString(_contactMail);
      output.writeInt32(_contactMailVerifyCd);
      output.writeString(_idCard);
      output.writeInt32(_idCardVerifyCd);
      output.writeInt32(_roleCd);
      output.writeInt64(_roleId);
      output.writeString(_rankLabel);
      output.writeString(_departmentLabels);
      output.writeString(_description);
      output.writeString(_content);
      output.writeString(_note);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }
}
