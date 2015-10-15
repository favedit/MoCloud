package com.cyou.gccloud.data.statistics;

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
// <T>用户统计表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FStatisticsFinancialMemberUnit
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

   // 存储字段关联编号的定义。
   private long __linkId;

   // 字段关联编号的定义。
   protected long _linkId;

   // 存储字段关联时间的定义。
   private TDateTime __linkDate = new TDateTime();

   // 字段关联时间的定义。
   protected TDateTime _linkDate = new TDateTime();

   // 存储字段关联类型的定义。
   private int __linkCd;

   // 字段关联类型的定义。
   protected int _linkCd;

   // 存储字段数据编号的定义。
   private long __dataId;

   // 字段数据编号的定义。
   protected long _dataId;

   // 存储字段客户编号的定义。
   private long __customerId;

   // 字段客户编号的定义。
   protected long _customerId;

   // 存储字段客户级别的定义。
   private int __customerLevelCd;

   // 字段客户级别的定义。
   protected int _customerLevelCd;

   // 存储字段理财师编号的定义。
   private long __marketerId;

   // 字段理财师编号的定义。
   protected long _marketerId;

   // 存储字段部门编号的定义。
   private long __departmentId;

   // 字段部门编号的定义。
   protected long _departmentId;

   // 存储字段账号的定义。
   private String __passport;

   // 字段账号的定义。
   protected String _passport;

   // 存储字段标签的定义。
   private String __label;

   // 字段标签的定义。
   protected String _label;

   // 存储字段身份证的定义。
   private String __card;

   // 字段身份证的定义。
   protected String _card;

   // 存储字段卡片地区的定义。
   private String __cardArea;

   // 字段卡片地区的定义。
   protected String _cardArea;

   // 存储字段卡片生日的定义。
   private String __cardBirth;

   // 字段卡片生日的定义。
   protected String _cardBirth;

   // 存储字段卡片性别的定义。
   private int __cardGender;

   // 字段卡片性别的定义。
   protected int _cardGender;

   // 存储字段电话的定义。
   private String __phone;

   // 字段电话的定义。
   protected String _phone;

   // 存储字段电话城市编号的定义。
   private long __phoneCityId;

   // 字段电话城市编号的定义。
   protected long _phoneCityId;

   // 存储字段电话城市代码的定义。
   private String __phoneCityCode;

   // 字段电话城市代码的定义。
   protected String _phoneCityCode;

   // 存储字段电子邮箱的定义。
   private String __email;

   // 字段电子邮箱的定义。
   protected String _email;

   // 存储字段性别类型的定义。
   private int __genderCd;

   // 字段性别类型的定义。
   protected int _genderCd;

   // 存储字段性别代码的定义。
   private String __genderCode;

   // 字段性别代码的定义。
   protected String _genderCode;

   // 存储字段已婚类型的定义。
   private int __marryCd;

   // 字段已婚类型的定义。
   protected int _marryCd;

   // 存储字段已婚代码的定义。
   private String __marryCode;

   // 字段已婚代码的定义。
   protected String _marryCode;

   // 存储字段学历类型的定义。
   private int __educationCd;

   // 字段学历类型的定义。
   protected int _educationCd;

   // 存储字段学历代码的定义。
   private String __educationCode;

   // 字段学历代码的定义。
   protected String _educationCode;

   // 存储字段行业类型的定义。
   private int __businessCd;

   // 字段行业类型的定义。
   protected int _businessCd;

   // 存储字段行业代码的定义。
   private String __businessCode;

   // 字段行业代码的定义。
   protected String _businessCode;

   // 存储字段收入类型的定义。
   private int __incomeCd;

   // 字段收入类型的定义。
   protected int _incomeCd;

   // 存储字段收入代码的定义。
   private String __incomeCode;

   // 字段收入代码的定义。
   protected String _incomeCode;

   // 存储字段省份区域编号的定义。
   private long __provinceAreaId;

   // 字段省份区域编号的定义。
   protected long _provinceAreaId;

   // 存储字段省份编号的定义。
   private long __provinceId;

   // 字段省份编号的定义。
   protected long _provinceId;

   // 存储字段省份代码的定义。
   private int __provinceCode;

   // 字段省份代码的定义。
   protected int _provinceCode;

   // 存储字段城市编号的定义。
   private long __cityId;

   // 字段城市编号的定义。
   protected long _cityId;

   // 存储字段城市代码的定义。
   private int __cityCode;

   // 字段城市代码的定义。
   protected int _cityCode;

   // 存储字段地区编号的定义。
   private long __areaId;

   // 字段地区编号的定义。
   protected long _areaId;

   // 存储字段地区代码的定义。
   private int __areaCode;

   // 字段地区代码的定义。
   protected int _areaCode;

   // 存储字段地址的定义。
   private String __address;

   // 字段地址的定义。
   protected String _address;

   // 存储字段信息的定义。
   private String __info;

   // 字段信息的定义。
   protected String _info;

   // 存储字段注册时间的定义。
   private TDateTime __registerDate = new TDateTime();

   // 字段注册时间的定义。
   protected TDateTime _registerDate = new TDateTime();

   // 存储字段投资时间的定义。
   private TDateTime __investmentDate = new TDateTime();

   // 字段投资时间的定义。
   protected TDateTime _investmentDate = new TDateTime();

   // 存储字段赎回时间的定义。
   private TDateTime __redemptionDate = new TDateTime();

   // 字段赎回时间的定义。
   protected TDateTime _redemptionDate = new TDateTime();

   // 存储字段登录时间的定义。
   private TDateTime __lastLoginDate = new TDateTime();

   // 字段登录时间的定义。
   protected TDateTime _lastLoginDate = new TDateTime();

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
   // <T>构造用户统计表逻辑单元。</T>
   //============================================================
   public FStatisticsFinancialMemberUnit(){
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
   // <T>判断关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLinkIdChanged(){
      return __linkId != _linkId;
   }

   //============================================================
   // <T>获得关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long linkId(){
      return _linkId;
   }

   //============================================================
   // <T>设置关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLinkId(long value){
      _linkId = value;
   }

   //============================================================
   // <T>判断关联时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLinkDateChanged(){
      return !__linkDate.equals(_linkDate);
   }

   //============================================================
   // <T>获得关联时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime linkDate(){
      return _linkDate;
   }

   //============================================================
   // <T>设置关联时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLinkDate(TDateTime value){
      _linkDate = value;
   }

   //============================================================
   // <T>判断关联类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLinkCdChanged(){
      return __linkCd != _linkCd;
   }

   //============================================================
   // <T>获得关联类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int linkCd(){
      return _linkCd;
   }

   //============================================================
   // <T>设置关联类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLinkCd(int value){
      _linkCd = value;
   }

   //============================================================
   // <T>判断数据编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDataIdChanged(){
      return __dataId != _dataId;
   }

   //============================================================
   // <T>获得数据编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long dataId(){
      return _dataId;
   }

   //============================================================
   // <T>设置数据编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDataId(long value){
      _dataId = value;
   }

   //============================================================
   // <T>判断客户编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerIdChanged(){
      return __customerId != _customerId;
   }

   //============================================================
   // <T>获得客户编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long customerId(){
      return _customerId;
   }

   //============================================================
   // <T>设置客户编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerId(long value){
      _customerId = value;
   }

   //============================================================
   // <T>判断客户级别的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerLevelCdChanged(){
      return __customerLevelCd != _customerLevelCd;
   }

   //============================================================
   // <T>获得客户级别的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int customerLevelCd(){
      return _customerLevelCd;
   }

   //============================================================
   // <T>设置客户级别的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerLevelCd(int value){
      _customerLevelCd = value;
   }

   //============================================================
   // <T>判断理财师编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarketerIdChanged(){
      return __marketerId != _marketerId;
   }

   //============================================================
   // <T>获得理财师编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long marketerId(){
      return _marketerId;
   }

   //============================================================
   // <T>设置理财师编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerId(long value){
      _marketerId = value;
   }

   //============================================================
   // <T>判断部门编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentIdChanged(){
      return __departmentId != _departmentId;
   }

   //============================================================
   // <T>获得部门编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentId(){
      return _departmentId;
   }

   //============================================================
   // <T>设置部门编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentId(long value){
      _departmentId = value;
   }

   //============================================================
   // <T>判断账号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPassportChanged(){
      return !RString.equals(__passport, _passport);
   }

   //============================================================
   // <T>获得账号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String passport(){
      return _passport;
   }

   //============================================================
   // <T>设置账号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPassport(String value){
      _passport = value;
   }

   //============================================================
   // <T>判断标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLabelChanged(){
      return !RString.equals(__label, _label);
   }

   //============================================================
   // <T>获得标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String label(){
      return _label;
   }

   //============================================================
   // <T>设置标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLabel(String value){
      _label = value;
   }

   //============================================================
   // <T>判断身份证的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCardChanged(){
      return !RString.equals(__card, _card);
   }

   //============================================================
   // <T>获得身份证的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String card(){
      return _card;
   }

   //============================================================
   // <T>设置身份证的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCard(String value){
      _card = value;
   }

   //============================================================
   // <T>判断卡片地区的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCardAreaChanged(){
      return !RString.equals(__cardArea, _cardArea);
   }

   //============================================================
   // <T>获得卡片地区的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String cardArea(){
      return _cardArea;
   }

   //============================================================
   // <T>设置卡片地区的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCardArea(String value){
      _cardArea = value;
   }

   //============================================================
   // <T>判断卡片生日的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCardBirthChanged(){
      return !RString.equals(__cardBirth, _cardBirth);
   }

   //============================================================
   // <T>获得卡片生日的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String cardBirth(){
      return _cardBirth;
   }

   //============================================================
   // <T>设置卡片生日的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCardBirth(String value){
      _cardBirth = value;
   }

   //============================================================
   // <T>判断卡片性别的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCardGenderChanged(){
      return __cardGender != _cardGender;
   }

   //============================================================
   // <T>获得卡片性别的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int cardGender(){
      return _cardGender;
   }

   //============================================================
   // <T>设置卡片性别的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCardGender(int value){
      _cardGender = value;
   }

   //============================================================
   // <T>判断电话的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPhoneChanged(){
      return !RString.equals(__phone, _phone);
   }

   //============================================================
   // <T>获得电话的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String phone(){
      return _phone;
   }

   //============================================================
   // <T>设置电话的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPhone(String value){
      _phone = value;
   }

   //============================================================
   // <T>判断电话城市编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPhoneCityIdChanged(){
      return __phoneCityId != _phoneCityId;
   }

   //============================================================
   // <T>获得电话城市编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long phoneCityId(){
      return _phoneCityId;
   }

   //============================================================
   // <T>设置电话城市编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPhoneCityId(long value){
      _phoneCityId = value;
   }

   //============================================================
   // <T>判断电话城市代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPhoneCityCodeChanged(){
      return !RString.equals(__phoneCityCode, _phoneCityCode);
   }

   //============================================================
   // <T>获得电话城市代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String phoneCityCode(){
      return _phoneCityCode;
   }

   //============================================================
   // <T>设置电话城市代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPhoneCityCode(String value){
      _phoneCityCode = value;
   }

   //============================================================
   // <T>判断电子邮箱的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isEmailChanged(){
      return !RString.equals(__email, _email);
   }

   //============================================================
   // <T>获得电子邮箱的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String email(){
      return _email;
   }

   //============================================================
   // <T>设置电子邮箱的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setEmail(String value){
      _email = value;
   }

   //============================================================
   // <T>判断性别类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isGenderCdChanged(){
      return __genderCd != _genderCd;
   }

   //============================================================
   // <T>获得性别类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int genderCd(){
      return _genderCd;
   }

   //============================================================
   // <T>设置性别类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setGenderCd(int value){
      _genderCd = value;
   }

   //============================================================
   // <T>判断性别代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isGenderCodeChanged(){
      return !RString.equals(__genderCode, _genderCode);
   }

   //============================================================
   // <T>获得性别代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String genderCode(){
      return _genderCode;
   }

   //============================================================
   // <T>设置性别代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setGenderCode(String value){
      _genderCode = value;
   }

   //============================================================
   // <T>判断已婚类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarryCdChanged(){
      return __marryCd != _marryCd;
   }

   //============================================================
   // <T>获得已婚类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int marryCd(){
      return _marryCd;
   }

   //============================================================
   // <T>设置已婚类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarryCd(int value){
      _marryCd = value;
   }

   //============================================================
   // <T>判断已婚代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarryCodeChanged(){
      return !RString.equals(__marryCode, _marryCode);
   }

   //============================================================
   // <T>获得已婚代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String marryCode(){
      return _marryCode;
   }

   //============================================================
   // <T>设置已婚代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarryCode(String value){
      _marryCode = value;
   }

   //============================================================
   // <T>判断学历类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isEducationCdChanged(){
      return __educationCd != _educationCd;
   }

   //============================================================
   // <T>获得学历类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int educationCd(){
      return _educationCd;
   }

   //============================================================
   // <T>设置学历类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setEducationCd(int value){
      _educationCd = value;
   }

   //============================================================
   // <T>判断学历代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isEducationCodeChanged(){
      return !RString.equals(__educationCode, _educationCode);
   }

   //============================================================
   // <T>获得学历代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String educationCode(){
      return _educationCode;
   }

   //============================================================
   // <T>设置学历代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setEducationCode(String value){
      _educationCode = value;
   }

   //============================================================
   // <T>判断行业类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBusinessCdChanged(){
      return __businessCd != _businessCd;
   }

   //============================================================
   // <T>获得行业类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int businessCd(){
      return _businessCd;
   }

   //============================================================
   // <T>设置行业类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBusinessCd(int value){
      _businessCd = value;
   }

   //============================================================
   // <T>判断行业代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBusinessCodeChanged(){
      return !RString.equals(__businessCode, _businessCode);
   }

   //============================================================
   // <T>获得行业代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String businessCode(){
      return _businessCode;
   }

   //============================================================
   // <T>设置行业代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBusinessCode(String value){
      _businessCode = value;
   }

   //============================================================
   // <T>判断收入类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isIncomeCdChanged(){
      return __incomeCd != _incomeCd;
   }

   //============================================================
   // <T>获得收入类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int incomeCd(){
      return _incomeCd;
   }

   //============================================================
   // <T>设置收入类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setIncomeCd(int value){
      _incomeCd = value;
   }

   //============================================================
   // <T>判断收入代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isIncomeCodeChanged(){
      return !RString.equals(__incomeCode, _incomeCode);
   }

   //============================================================
   // <T>获得收入代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String incomeCode(){
      return _incomeCode;
   }

   //============================================================
   // <T>设置收入代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setIncomeCode(String value){
      _incomeCode = value;
   }

   //============================================================
   // <T>判断省份区域编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProvinceAreaIdChanged(){
      return __provinceAreaId != _provinceAreaId;
   }

   //============================================================
   // <T>获得省份区域编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long provinceAreaId(){
      return _provinceAreaId;
   }

   //============================================================
   // <T>设置省份区域编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProvinceAreaId(long value){
      _provinceAreaId = value;
   }

   //============================================================
   // <T>判断省份编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProvinceIdChanged(){
      return __provinceId != _provinceId;
   }

   //============================================================
   // <T>获得省份编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long provinceId(){
      return _provinceId;
   }

   //============================================================
   // <T>设置省份编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProvinceId(long value){
      _provinceId = value;
   }

   //============================================================
   // <T>判断省份代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProvinceCodeChanged(){
      return __provinceCode != _provinceCode;
   }

   //============================================================
   // <T>获得省份代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int provinceCode(){
      return _provinceCode;
   }

   //============================================================
   // <T>设置省份代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProvinceCode(int value){
      _provinceCode = value;
   }

   //============================================================
   // <T>判断城市编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCityIdChanged(){
      return __cityId != _cityId;
   }

   //============================================================
   // <T>获得城市编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long cityId(){
      return _cityId;
   }

   //============================================================
   // <T>设置城市编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCityId(long value){
      _cityId = value;
   }

   //============================================================
   // <T>判断城市代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCityCodeChanged(){
      return __cityCode != _cityCode;
   }

   //============================================================
   // <T>获得城市代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int cityCode(){
      return _cityCode;
   }

   //============================================================
   // <T>设置城市代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCityCode(int value){
      _cityCode = value;
   }

   //============================================================
   // <T>判断地区编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAreaIdChanged(){
      return __areaId != _areaId;
   }

   //============================================================
   // <T>获得地区编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long areaId(){
      return _areaId;
   }

   //============================================================
   // <T>设置地区编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAreaId(long value){
      _areaId = value;
   }

   //============================================================
   // <T>判断地区代码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAreaCodeChanged(){
      return __areaCode != _areaCode;
   }

   //============================================================
   // <T>获得地区代码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int areaCode(){
      return _areaCode;
   }

   //============================================================
   // <T>设置地区代码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAreaCode(int value){
      _areaCode = value;
   }

   //============================================================
   // <T>判断地址的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAddressChanged(){
      return !RString.equals(__address, _address);
   }

   //============================================================
   // <T>获得地址的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String address(){
      return _address;
   }

   //============================================================
   // <T>设置地址的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAddress(String value){
      _address = value;
   }

   //============================================================
   // <T>判断信息的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInfoChanged(){
      return !RString.equals(__info, _info);
   }

   //============================================================
   // <T>获得信息的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String info(){
      return _info;
   }

   //============================================================
   // <T>设置信息的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInfo(String value){
      _info = value;
   }

   //============================================================
   // <T>判断注册时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRegisterDateChanged(){
      return !__registerDate.equals(_registerDate);
   }

   //============================================================
   // <T>获得注册时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime registerDate(){
      return _registerDate;
   }

   //============================================================
   // <T>设置注册时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRegisterDate(TDateTime value){
      _registerDate = value;
   }

   //============================================================
   // <T>判断投资时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInvestmentDateChanged(){
      return !__investmentDate.equals(_investmentDate);
   }

   //============================================================
   // <T>获得投资时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime investmentDate(){
      return _investmentDate;
   }

   //============================================================
   // <T>设置投资时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInvestmentDate(TDateTime value){
      _investmentDate = value;
   }

   //============================================================
   // <T>判断赎回时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRedemptionDateChanged(){
      return !__redemptionDate.equals(_redemptionDate);
   }

   //============================================================
   // <T>获得赎回时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime redemptionDate(){
      return _redemptionDate;
   }

   //============================================================
   // <T>设置赎回时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRedemptionDate(TDateTime value){
      _redemptionDate = value;
   }

   //============================================================
   // <T>判断登录时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLastLoginDateChanged(){
      return !__lastLoginDate.equals(_lastLoginDate);
   }

   //============================================================
   // <T>获得登录时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime lastLoginDate(){
      return _lastLoginDate;
   }

   //============================================================
   // <T>设置登录时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLastLoginDate(TDateTime value){
      _lastLoginDate = value;
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
         case "link_id":
            return Long.toString(_linkId);
         case "link_date":
            return _linkDate.toString();
         case "link_cd":
            return RInteger.toString(_linkCd);
         case "data_id":
            return Long.toString(_dataId);
         case "customer_id":
            return Long.toString(_customerId);
         case "customer_level_cd":
            return RInteger.toString(_customerLevelCd);
         case "marketer_id":
            return Long.toString(_marketerId);
         case "department_id":
            return Long.toString(_departmentId);
         case "passport":
            return _passport;
         case "label":
            return _label;
         case "card":
            return _card;
         case "card_area":
            return _cardArea;
         case "card_birth":
            return _cardBirth;
         case "card_gender":
            return RInteger.toString(_cardGender);
         case "phone":
            return _phone;
         case "phone_city_id":
            return Long.toString(_phoneCityId);
         case "phone_city_code":
            return _phoneCityCode;
         case "email":
            return _email;
         case "gender_cd":
            return RInteger.toString(_genderCd);
         case "gender_code":
            return _genderCode;
         case "marry_cd":
            return RInteger.toString(_marryCd);
         case "marry_code":
            return _marryCode;
         case "education_cd":
            return RInteger.toString(_educationCd);
         case "education_code":
            return _educationCode;
         case "business_cd":
            return RInteger.toString(_businessCd);
         case "business_code":
            return _businessCode;
         case "income_cd":
            return RInteger.toString(_incomeCd);
         case "income_code":
            return _incomeCode;
         case "province_area_id":
            return Long.toString(_provinceAreaId);
         case "province_id":
            return Long.toString(_provinceId);
         case "province_code":
            return RInteger.toString(_provinceCode);
         case "city_id":
            return Long.toString(_cityId);
         case "city_code":
            return RInteger.toString(_cityCode);
         case "area_id":
            return Long.toString(_areaId);
         case "area_code":
            return RInteger.toString(_areaCode);
         case "address":
            return _address;
         case "info":
            return _info;
         case "register_date":
            return _registerDate.toString();
         case "investment_date":
            return _investmentDate.toString();
         case "redemption_date":
            return _redemptionDate.toString();
         case "last_login_date":
            return _lastLoginDate.toString();
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
         case "link_id":
            _linkId = RLong.parse(value);
            break;
         case "link_date":
            _linkDate.parse(value);
            break;
         case "link_cd":
            _linkCd = RInteger.parse(value);
            break;
         case "data_id":
            _dataId = RLong.parse(value);
            break;
         case "customer_id":
            _customerId = RLong.parse(value);
            break;
         case "customer_level_cd":
            _customerLevelCd = RInteger.parse(value);
            break;
         case "marketer_id":
            _marketerId = RLong.parse(value);
            break;
         case "department_id":
            _departmentId = RLong.parse(value);
            break;
         case "passport":
            _passport = value;
            break;
         case "label":
            _label = value;
            break;
         case "card":
            _card = value;
            break;
         case "card_area":
            _cardArea = value;
            break;
         case "card_birth":
            _cardBirth = value;
            break;
         case "card_gender":
            _cardGender = RInteger.parse(value);
            break;
         case "phone":
            _phone = value;
            break;
         case "phone_city_id":
            _phoneCityId = RLong.parse(value);
            break;
         case "phone_city_code":
            _phoneCityCode = value;
            break;
         case "email":
            _email = value;
            break;
         case "gender_cd":
            _genderCd = RInteger.parse(value);
            break;
         case "gender_code":
            _genderCode = value;
            break;
         case "marry_cd":
            _marryCd = RInteger.parse(value);
            break;
         case "marry_code":
            _marryCode = value;
            break;
         case "education_cd":
            _educationCd = RInteger.parse(value);
            break;
         case "education_code":
            _educationCode = value;
            break;
         case "business_cd":
            _businessCd = RInteger.parse(value);
            break;
         case "business_code":
            _businessCode = value;
            break;
         case "income_cd":
            _incomeCd = RInteger.parse(value);
            break;
         case "income_code":
            _incomeCode = value;
            break;
         case "province_area_id":
            _provinceAreaId = RLong.parse(value);
            break;
         case "province_id":
            _provinceId = RLong.parse(value);
            break;
         case "province_code":
            _provinceCode = RInteger.parse(value);
            break;
         case "city_id":
            _cityId = RLong.parse(value);
            break;
         case "city_code":
            _cityCode = RInteger.parse(value);
            break;
         case "area_id":
            _areaId = RLong.parse(value);
            break;
         case "area_code":
            _areaCode = RInteger.parse(value);
            break;
         case "address":
            _address = value;
            break;
         case "info":
            _info = value;
            break;
         case "register_date":
            _registerDate.parse(value);
            break;
         case "investment_date":
            _investmentDate.parse(value);
            break;
         case "redemption_date":
            _redemptionDate.parse(value);
            break;
         case "last_login_date":
            _lastLoginDate.parse(value);
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
            case "link_id":
               __linkId = RLong.parse(value);
               _linkId = __linkId;
               break;
            case "link_date":
               __linkDate.parse(value);
               _linkDate.assign(__linkDate);
               break;
            case "link_cd":
               __linkCd = RInteger.parse(value);
               _linkCd = __linkCd;
               break;
            case "data_id":
               __dataId = RLong.parse(value);
               _dataId = __dataId;
               break;
            case "customer_id":
               __customerId = RLong.parse(value);
               _customerId = __customerId;
               break;
            case "customer_level_cd":
               __customerLevelCd = RInteger.parse(value);
               _customerLevelCd = __customerLevelCd;
               break;
            case "marketer_id":
               __marketerId = RLong.parse(value);
               _marketerId = __marketerId;
               break;
            case "department_id":
               __departmentId = RLong.parse(value);
               _departmentId = __departmentId;
               break;
            case "passport":
               __passport = value;
               _passport = __passport;
               break;
            case "label":
               __label = value;
               _label = __label;
               break;
            case "card":
               __card = value;
               _card = __card;
               break;
            case "card_area":
               __cardArea = value;
               _cardArea = __cardArea;
               break;
            case "card_birth":
               __cardBirth = value;
               _cardBirth = __cardBirth;
               break;
            case "card_gender":
               __cardGender = RInteger.parse(value);
               _cardGender = __cardGender;
               break;
            case "phone":
               __phone = value;
               _phone = __phone;
               break;
            case "phone_city_id":
               __phoneCityId = RLong.parse(value);
               _phoneCityId = __phoneCityId;
               break;
            case "phone_city_code":
               __phoneCityCode = value;
               _phoneCityCode = __phoneCityCode;
               break;
            case "email":
               __email = value;
               _email = __email;
               break;
            case "gender_cd":
               __genderCd = RInteger.parse(value);
               _genderCd = __genderCd;
               break;
            case "gender_code":
               __genderCode = value;
               _genderCode = __genderCode;
               break;
            case "marry_cd":
               __marryCd = RInteger.parse(value);
               _marryCd = __marryCd;
               break;
            case "marry_code":
               __marryCode = value;
               _marryCode = __marryCode;
               break;
            case "education_cd":
               __educationCd = RInteger.parse(value);
               _educationCd = __educationCd;
               break;
            case "education_code":
               __educationCode = value;
               _educationCode = __educationCode;
               break;
            case "business_cd":
               __businessCd = RInteger.parse(value);
               _businessCd = __businessCd;
               break;
            case "business_code":
               __businessCode = value;
               _businessCode = __businessCode;
               break;
            case "income_cd":
               __incomeCd = RInteger.parse(value);
               _incomeCd = __incomeCd;
               break;
            case "income_code":
               __incomeCode = value;
               _incomeCode = __incomeCode;
               break;
            case "province_area_id":
               __provinceAreaId = RLong.parse(value);
               _provinceAreaId = __provinceAreaId;
               break;
            case "province_id":
               __provinceId = RLong.parse(value);
               _provinceId = __provinceId;
               break;
            case "province_code":
               __provinceCode = RInteger.parse(value);
               _provinceCode = __provinceCode;
               break;
            case "city_id":
               __cityId = RLong.parse(value);
               _cityId = __cityId;
               break;
            case "city_code":
               __cityCode = RInteger.parse(value);
               _cityCode = __cityCode;
               break;
            case "area_id":
               __areaId = RLong.parse(value);
               _areaId = __areaId;
               break;
            case "area_code":
               __areaCode = RInteger.parse(value);
               _areaCode = __areaCode;
               break;
            case "address":
               __address = value;
               _address = __address;
               break;
            case "info":
               __info = value;
               _info = __info;
               break;
            case "register_date":
               __registerDate.parse(value);
               _registerDate.assign(__registerDate);
               break;
            case "investment_date":
               __investmentDate.parse(value);
               _investmentDate.assign(__investmentDate);
               break;
            case "redemption_date":
               __redemptionDate.parse(value);
               _redemptionDate.assign(__redemptionDate);
               break;
            case "last_login_date":
               __lastLoginDate.parse(value);
               _lastLoginDate.assign(__lastLoginDate);
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
      row.set("linkId", _linkId);
      row.set("linkDate", _linkDate);
      row.set("linkCd", _linkCd);
      row.set("dataId", _dataId);
      row.set("customerId", _customerId);
      row.set("customerLevelCd", _customerLevelCd);
      row.set("marketerId", _marketerId);
      row.set("departmentId", _departmentId);
      row.set("passport", _passport);
      row.set("label", _label);
      row.set("card", _card);
      row.set("cardArea", _cardArea);
      row.set("cardBirth", _cardBirth);
      row.set("cardGender", _cardGender);
      row.set("phone", _phone);
      row.set("phoneCityId", _phoneCityId);
      row.set("phoneCityCode", _phoneCityCode);
      row.set("email", _email);
      row.set("genderCd", _genderCd);
      row.set("genderCode", _genderCode);
      row.set("marryCd", _marryCd);
      row.set("marryCode", _marryCode);
      row.set("educationCd", _educationCd);
      row.set("educationCode", _educationCode);
      row.set("businessCd", _businessCd);
      row.set("businessCode", _businessCode);
      row.set("incomeCd", _incomeCd);
      row.set("incomeCode", _incomeCode);
      row.set("provinceAreaId", _provinceAreaId);
      row.set("provinceId", _provinceId);
      row.set("provinceCode", _provinceCode);
      row.set("cityId", _cityId);
      row.set("cityCode", _cityCode);
      row.set("areaId", _areaId);
      row.set("areaCode", _areaCode);
      row.set("address", _address);
      row.set("info", _info);
      row.set("registerDate", _registerDate);
      row.set("investmentDate", _investmentDate);
      row.set("redemptionDate", _redemptionDate);
      row.set("lastLoginDate", _lastLoginDate);
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
      map.put("linkId", RLong.toString(_linkId));
      map.put("linkDate", _linkDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("linkCd", RInteger.toString(_linkCd));
      map.put("dataId", RLong.toString(_dataId));
      map.put("customerId", RLong.toString(_customerId));
      map.put("customerLevelCd", RInteger.toString(_customerLevelCd));
      map.put("marketerId", RLong.toString(_marketerId));
      map.put("departmentId", RLong.toString(_departmentId));
      map.put("passport", _passport);
      map.put("label", _label);
      map.put("card", _card);
      map.put("cardArea", _cardArea);
      map.put("cardBirth", _cardBirth);
      map.put("cardGender", RInteger.toString(_cardGender));
      map.put("phone", _phone);
      map.put("phoneCityId", RLong.toString(_phoneCityId));
      map.put("phoneCityCode", _phoneCityCode);
      map.put("email", _email);
      map.put("genderCd", RInteger.toString(_genderCd));
      map.put("genderCode", _genderCode);
      map.put("marryCd", RInteger.toString(_marryCd));
      map.put("marryCode", _marryCode);
      map.put("educationCd", RInteger.toString(_educationCd));
      map.put("educationCode", _educationCode);
      map.put("businessCd", RInteger.toString(_businessCd));
      map.put("businessCode", _businessCode);
      map.put("incomeCd", RInteger.toString(_incomeCd));
      map.put("incomeCode", _incomeCode);
      map.put("provinceAreaId", RLong.toString(_provinceAreaId));
      map.put("provinceId", RLong.toString(_provinceId));
      map.put("provinceCode", RInteger.toString(_provinceCode));
      map.put("cityId", RLong.toString(_cityId));
      map.put("cityCode", RInteger.toString(_cityCode));
      map.put("areaId", RLong.toString(_areaId));
      map.put("areaCode", RInteger.toString(_areaCode));
      map.put("address", _address);
      map.put("info", _info);
      map.put("registerDate", _registerDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("investmentDate", _investmentDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("redemptionDate", _redemptionDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("lastLoginDate", _lastLoginDate.format("YYYY-MM-DD HH24:MI:SS"));
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
      _linkId = input.readInt64();
      _linkDate.set(input.readInt64());
      _linkCd = input.readInt32();
      _dataId = input.readInt64();
      _customerId = input.readInt64();
      _customerLevelCd = input.readInt32();
      _marketerId = input.readInt64();
      _departmentId = input.readInt64();
      _passport = input.readString();
      _label = input.readString();
      _card = input.readString();
      _cardArea = input.readString();
      _cardBirth = input.readString();
      _cardGender = input.readInt32();
      _phone = input.readString();
      _phoneCityId = input.readInt64();
      _phoneCityCode = input.readString();
      _email = input.readString();
      _genderCd = input.readInt32();
      _genderCode = input.readString();
      _marryCd = input.readInt32();
      _marryCode = input.readString();
      _educationCd = input.readInt32();
      _educationCode = input.readString();
      _businessCd = input.readInt32();
      _businessCode = input.readString();
      _incomeCd = input.readInt32();
      _incomeCode = input.readString();
      _provinceAreaId = input.readInt64();
      _provinceId = input.readInt64();
      _provinceCode = input.readInt32();
      _cityId = input.readInt64();
      _cityCode = input.readInt32();
      _areaId = input.readInt64();
      _areaCode = input.readInt32();
      _address = input.readString();
      _info = input.readString();
      _registerDate.set(input.readInt64());
      _investmentDate.set(input.readInt64());
      _redemptionDate.set(input.readInt64());
      _lastLoginDate.set(input.readInt64());
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
      output.writeInt64(_linkId);
      output.writeInt64(_linkDate.get());
      output.writeInt32(_linkCd);
      output.writeInt64(_dataId);
      output.writeInt64(_customerId);
      output.writeInt32(_customerLevelCd);
      output.writeInt64(_marketerId);
      output.writeInt64(_departmentId);
      output.writeString(_passport);
      output.writeString(_label);
      output.writeString(_card);
      output.writeString(_cardArea);
      output.writeString(_cardBirth);
      output.writeInt32(_cardGender);
      output.writeString(_phone);
      output.writeInt64(_phoneCityId);
      output.writeString(_phoneCityCode);
      output.writeString(_email);
      output.writeInt32(_genderCd);
      output.writeString(_genderCode);
      output.writeInt32(_marryCd);
      output.writeString(_marryCode);
      output.writeInt32(_educationCd);
      output.writeString(_educationCode);
      output.writeInt32(_businessCd);
      output.writeString(_businessCode);
      output.writeInt32(_incomeCd);
      output.writeString(_incomeCode);
      output.writeInt64(_provinceAreaId);
      output.writeInt64(_provinceId);
      output.writeInt32(_provinceCode);
      output.writeInt64(_cityId);
      output.writeInt32(_cityCode);
      output.writeInt64(_areaId);
      output.writeInt32(_areaCode);
      output.writeString(_address);
      output.writeString(_info);
      output.writeInt64(_registerDate.get());
      output.writeInt64(_investmentDate.get());
      output.writeInt64(_redemptionDate.get());
      output.writeInt64(_lastLoginDate.get());
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }
}
