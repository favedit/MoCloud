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
// <T>金融成员信息逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataFinancialMemberUnit
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

   // 存储字段用户编号的定义。
   private long __userId;

   // 字段用户编号的定义。
   protected long _userId;

   // 存储字段关联编号的定义。
   private long __linkId;

   // 字段关联编号的定义。
   protected long _linkId;

   // 存储字段统计编号的定义。
   private long __statisticsId;

   // 字段统计编号的定义。
   protected long _statisticsId;

   // 存储字段账号的定义。
   private String __passport;

   // 字段账号的定义。
   protected String _passport;

   // 存储字段名称的定义。
   private String __label;

   // 字段名称的定义。
   protected String _label;

   // 存储字段身份证号的定义。
   private String __card;

   // 字段身份证号的定义。
   protected String _card;

   // 存储字段生日的定义。
   private TDateTime __birthday = new TDateTime();

   // 字段生日的定义。
   protected TDateTime _birthday = new TDateTime();

   // 存储字段电话号码的定义。
   private String __phone;

   // 字段电话号码的定义。
   protected String _phone;

   // 存储字段电子邮箱的定义。
   private String __email;

   // 字段电子邮箱的定义。
   protected String _email;

   // 存储字段性别的定义。
   private int __genderCd;

   // 字段性别的定义。
   protected int _genderCd;

   // 存储字段婚姻类型的定义。
   private int __marryCd;

   // 字段婚姻类型的定义。
   protected int _marryCd;

   // 存储字段教育类型的定义。
   private int __educationCd;

   // 字段教育类型的定义。
   protected int _educationCd;

   // 存储字段职业类型的定义。
   private int __businessCd;

   // 字段职业类型的定义。
   protected int _businessCd;

   // 存储字段收入类型的定义。
   private int __incomeCd;

   // 字段收入类型的定义。
   protected int _incomeCd;

   // 存储字段区域编号的定义。
   private long __provinceAreaId;

   // 字段区域编号的定义。
   protected long _provinceAreaId;

   // 存储字段省份编号的定义。
   private long __provinceId;

   // 字段省份编号的定义。
   protected long _provinceId;

   // 存储字段城市编号的定义。
   private long __cityId;

   // 字段城市编号的定义。
   protected long _cityId;

   // 存储字段区域编号的定义。
   private long __areaId;

   // 字段区域编号的定义。
   protected long _areaId;

   // 存储字段地址信息的定义。
   private String __address;

   // 字段地址信息的定义。
   protected String _address;

   // 存储字段注册时间的定义。
   private TDateTime __registerDate = new TDateTime();

   // 字段注册时间的定义。
   protected TDateTime _registerDate = new TDateTime();

   // 存储字段最后登录时间的定义。
   private TDateTime __lastLoginDate = new TDateTime();

   // 字段最后登录时间的定义。
   protected TDateTime _lastLoginDate = new TDateTime();

   // 存储字段推荐理财师编号的定义。
   private long __recommendMarketerId;

   // 字段推荐理财师编号的定义。
   protected long _recommendMarketerId;

   // 存储字段推荐理财师用户编号的定义。
   private long __recommendMarketerUserId;

   // 字段推荐理财师用户编号的定义。
   protected long _recommendMarketerUserId;

   // 存储字段推荐开始时间的定义。
   private TDateTime __recommendBeginDate = new TDateTime();

   // 字段推荐开始时间的定义。
   protected TDateTime _recommendBeginDate = new TDateTime();

   // 存储字段推荐结束时间的定义。
   private TDateTime __recommendEndDate = new TDateTime();

   // 字段推荐结束时间的定义。
   protected TDateTime _recommendEndDate = new TDateTime();

   // 存储字段推荐评分的定义。
   private int __recommendScore;

   // 字段推荐评分的定义。
   protected int _recommendScore;

   // 存储字段备注信息的定义。
   private String __note;

   // 字段备注信息的定义。
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
   // <T>构造金融成员信息逻辑单元。</T>
   //============================================================
   public FDataFinancialMemberUnit(){
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
   // <T>判断用户编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isUserIdChanged(){
      return __userId != _userId;
   }

   //============================================================
   // <T>获得用户编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long userId(){
      return _userId;
   }

   //============================================================
   // <T>设置用户编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setUserId(long value){
      _userId = value;
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
   // <T>判断统计编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isStatisticsIdChanged(){
      return __statisticsId != _statisticsId;
   }

   //============================================================
   // <T>获得统计编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long statisticsId(){
      return _statisticsId;
   }

   //============================================================
   // <T>设置统计编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setStatisticsId(long value){
      _statisticsId = value;
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
   // <T>判断身份证号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCardChanged(){
      return !RString.equals(__card, _card);
   }

   //============================================================
   // <T>获得身份证号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String card(){
      return _card;
   }

   //============================================================
   // <T>设置身份证号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCard(String value){
      _card = value;
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
   // <T>判断电话号码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPhoneChanged(){
      return !RString.equals(__phone, _phone);
   }

   //============================================================
   // <T>获得电话号码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String phone(){
      return _phone;
   }

   //============================================================
   // <T>设置电话号码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPhone(String value){
      _phone = value;
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
   // <T>判断性别的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isGenderCdChanged(){
      return __genderCd != _genderCd;
   }

   //============================================================
   // <T>获得性别的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int genderCd(){
      return _genderCd;
   }

   //============================================================
   // <T>设置性别的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setGenderCd(int value){
      _genderCd = value;
   }

   //============================================================
   // <T>判断婚姻类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarryCdChanged(){
      return __marryCd != _marryCd;
   }

   //============================================================
   // <T>获得婚姻类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int marryCd(){
      return _marryCd;
   }

   //============================================================
   // <T>设置婚姻类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarryCd(int value){
      _marryCd = value;
   }

   //============================================================
   // <T>判断教育类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isEducationCdChanged(){
      return __educationCd != _educationCd;
   }

   //============================================================
   // <T>获得教育类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int educationCd(){
      return _educationCd;
   }

   //============================================================
   // <T>设置教育类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setEducationCd(int value){
      _educationCd = value;
   }

   //============================================================
   // <T>判断职业类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBusinessCdChanged(){
      return __businessCd != _businessCd;
   }

   //============================================================
   // <T>获得职业类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int businessCd(){
      return _businessCd;
   }

   //============================================================
   // <T>设置职业类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBusinessCd(int value){
      _businessCd = value;
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
   // <T>判断区域编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProvinceAreaIdChanged(){
      return __provinceAreaId != _provinceAreaId;
   }

   //============================================================
   // <T>获得区域编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long provinceAreaId(){
      return _provinceAreaId;
   }

   //============================================================
   // <T>设置区域编号的数据内容。</T>
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
   // <T>判断区域编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAreaIdChanged(){
      return __areaId != _areaId;
   }

   //============================================================
   // <T>获得区域编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long areaId(){
      return _areaId;
   }

   //============================================================
   // <T>设置区域编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAreaId(long value){
      _areaId = value;
   }

   //============================================================
   // <T>判断地址信息的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isAddressChanged(){
      return !RString.equals(__address, _address);
   }

   //============================================================
   // <T>获得地址信息的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String address(){
      return _address;
   }

   //============================================================
   // <T>设置地址信息的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setAddress(String value){
      _address = value;
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
   // <T>判断最后登录时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLastLoginDateChanged(){
      return !__lastLoginDate.equals(_lastLoginDate);
   }

   //============================================================
   // <T>获得最后登录时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime lastLoginDate(){
      return _lastLoginDate;
   }

   //============================================================
   // <T>设置最后登录时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLastLoginDate(TDateTime value){
      _lastLoginDate = value;
   }

   //============================================================
   // <T>判断推荐理财师编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecommendMarketerIdChanged(){
      return __recommendMarketerId != _recommendMarketerId;
   }

   //============================================================
   // <T>获得推荐理财师编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long recommendMarketerId(){
      return _recommendMarketerId;
   }

   //============================================================
   // <T>设置推荐理财师编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecommendMarketerId(long value){
      _recommendMarketerId = value;
   }

   //============================================================
   // <T>判断推荐理财师用户编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecommendMarketerUserIdChanged(){
      return __recommendMarketerUserId != _recommendMarketerUserId;
   }

   //============================================================
   // <T>获得推荐理财师用户编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long recommendMarketerUserId(){
      return _recommendMarketerUserId;
   }

   //============================================================
   // <T>设置推荐理财师用户编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecommendMarketerUserId(long value){
      _recommendMarketerUserId = value;
   }

   //============================================================
   // <T>判断推荐开始时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecommendBeginDateChanged(){
      return !__recommendBeginDate.equals(_recommendBeginDate);
   }

   //============================================================
   // <T>获得推荐开始时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime recommendBeginDate(){
      return _recommendBeginDate;
   }

   //============================================================
   // <T>设置推荐开始时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecommendBeginDate(TDateTime value){
      _recommendBeginDate = value;
   }

   //============================================================
   // <T>判断推荐结束时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecommendEndDateChanged(){
      return !__recommendEndDate.equals(_recommendEndDate);
   }

   //============================================================
   // <T>获得推荐结束时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime recommendEndDate(){
      return _recommendEndDate;
   }

   //============================================================
   // <T>设置推荐结束时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecommendEndDate(TDateTime value){
      _recommendEndDate = value;
   }

   //============================================================
   // <T>判断推荐评分的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecommendScoreChanged(){
      return __recommendScore != _recommendScore;
   }

   //============================================================
   // <T>获得推荐评分的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int recommendScore(){
      return _recommendScore;
   }

   //============================================================
   // <T>设置推荐评分的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecommendScore(int value){
      _recommendScore = value;
   }

   //============================================================
   // <T>判断备注信息的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isNoteChanged(){
      return !RString.equals(__note, _note);
   }

   //============================================================
   // <T>获得备注信息的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String note(){
      return _note;
   }

   //============================================================
   // <T>设置备注信息的数据内容。</T>
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
         case "user_id":
            return Long.toString(_userId);
         case "link_id":
            return Long.toString(_linkId);
         case "statistics_id":
            return Long.toString(_statisticsId);
         case "passport":
            return _passport;
         case "label":
            return _label;
         case "card":
            return _card;
         case "birthday":
            return _birthday.toString();
         case "phone":
            return _phone;
         case "email":
            return _email;
         case "gender_cd":
            return RInteger.toString(_genderCd);
         case "marry_cd":
            return RInteger.toString(_marryCd);
         case "education_cd":
            return RInteger.toString(_educationCd);
         case "business_cd":
            return RInteger.toString(_businessCd);
         case "income_cd":
            return RInteger.toString(_incomeCd);
         case "province_area_id":
            return Long.toString(_provinceAreaId);
         case "province_id":
            return Long.toString(_provinceId);
         case "city_id":
            return Long.toString(_cityId);
         case "area_id":
            return Long.toString(_areaId);
         case "address":
            return _address;
         case "register_date":
            return _registerDate.toString();
         case "last_login_date":
            return _lastLoginDate.toString();
         case "recommend_marketer_id":
            return Long.toString(_recommendMarketerId);
         case "recommend_marketer_user_id":
            return Long.toString(_recommendMarketerUserId);
         case "recommend_begin_date":
            return _recommendBeginDate.toString();
         case "recommend_end_date":
            return _recommendEndDate.toString();
         case "recommend_score":
            return RInteger.toString(_recommendScore);
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
         case "user_id":
            _userId = RLong.parse(value);
            break;
         case "link_id":
            _linkId = RLong.parse(value);
            break;
         case "statistics_id":
            _statisticsId = RLong.parse(value);
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
         case "birthday":
            _birthday.parse(value);
            break;
         case "phone":
            _phone = value;
            break;
         case "email":
            _email = value;
            break;
         case "gender_cd":
            _genderCd = RInteger.parse(value);
            break;
         case "marry_cd":
            _marryCd = RInteger.parse(value);
            break;
         case "education_cd":
            _educationCd = RInteger.parse(value);
            break;
         case "business_cd":
            _businessCd = RInteger.parse(value);
            break;
         case "income_cd":
            _incomeCd = RInteger.parse(value);
            break;
         case "province_area_id":
            _provinceAreaId = RLong.parse(value);
            break;
         case "province_id":
            _provinceId = RLong.parse(value);
            break;
         case "city_id":
            _cityId = RLong.parse(value);
            break;
         case "area_id":
            _areaId = RLong.parse(value);
            break;
         case "address":
            _address = value;
            break;
         case "register_date":
            _registerDate.parse(value);
            break;
         case "last_login_date":
            _lastLoginDate.parse(value);
            break;
         case "recommend_marketer_id":
            _recommendMarketerId = RLong.parse(value);
            break;
         case "recommend_marketer_user_id":
            _recommendMarketerUserId = RLong.parse(value);
            break;
         case "recommend_begin_date":
            _recommendBeginDate.parse(value);
            break;
         case "recommend_end_date":
            _recommendEndDate.parse(value);
            break;
         case "recommend_score":
            _recommendScore = RInteger.parse(value);
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
            case "user_id":
               __userId = RLong.parse(value);
               _userId = __userId;
               break;
            case "link_id":
               __linkId = RLong.parse(value);
               _linkId = __linkId;
               break;
            case "statistics_id":
               __statisticsId = RLong.parse(value);
               _statisticsId = __statisticsId;
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
            case "birthday":
               __birthday.parse(value);
               _birthday.assign(__birthday);
               break;
            case "phone":
               __phone = value;
               _phone = __phone;
               break;
            case "email":
               __email = value;
               _email = __email;
               break;
            case "gender_cd":
               __genderCd = RInteger.parse(value);
               _genderCd = __genderCd;
               break;
            case "marry_cd":
               __marryCd = RInteger.parse(value);
               _marryCd = __marryCd;
               break;
            case "education_cd":
               __educationCd = RInteger.parse(value);
               _educationCd = __educationCd;
               break;
            case "business_cd":
               __businessCd = RInteger.parse(value);
               _businessCd = __businessCd;
               break;
            case "income_cd":
               __incomeCd = RInteger.parse(value);
               _incomeCd = __incomeCd;
               break;
            case "province_area_id":
               __provinceAreaId = RLong.parse(value);
               _provinceAreaId = __provinceAreaId;
               break;
            case "province_id":
               __provinceId = RLong.parse(value);
               _provinceId = __provinceId;
               break;
            case "city_id":
               __cityId = RLong.parse(value);
               _cityId = __cityId;
               break;
            case "area_id":
               __areaId = RLong.parse(value);
               _areaId = __areaId;
               break;
            case "address":
               __address = value;
               _address = __address;
               break;
            case "register_date":
               __registerDate.parse(value);
               _registerDate.assign(__registerDate);
               break;
            case "last_login_date":
               __lastLoginDate.parse(value);
               _lastLoginDate.assign(__lastLoginDate);
               break;
            case "recommend_marketer_id":
               __recommendMarketerId = RLong.parse(value);
               _recommendMarketerId = __recommendMarketerId;
               break;
            case "recommend_marketer_user_id":
               __recommendMarketerUserId = RLong.parse(value);
               _recommendMarketerUserId = __recommendMarketerUserId;
               break;
            case "recommend_begin_date":
               __recommendBeginDate.parse(value);
               _recommendBeginDate.assign(__recommendBeginDate);
               break;
            case "recommend_end_date":
               __recommendEndDate.parse(value);
               _recommendEndDate.assign(__recommendEndDate);
               break;
            case "recommend_score":
               __recommendScore = RInteger.parse(value);
               _recommendScore = __recommendScore;
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
      row.set("userId", _userId);
      row.set("linkId", _linkId);
      row.set("statisticsId", _statisticsId);
      row.set("passport", _passport);
      row.set("label", _label);
      row.set("card", _card);
      row.set("birthday", _birthday);
      row.set("phone", _phone);
      row.set("email", _email);
      row.set("genderCd", _genderCd);
      row.set("marryCd", _marryCd);
      row.set("educationCd", _educationCd);
      row.set("businessCd", _businessCd);
      row.set("incomeCd", _incomeCd);
      row.set("provinceAreaId", _provinceAreaId);
      row.set("provinceId", _provinceId);
      row.set("cityId", _cityId);
      row.set("areaId", _areaId);
      row.set("address", _address);
      row.set("registerDate", _registerDate);
      row.set("lastLoginDate", _lastLoginDate);
      row.set("recommendMarketerId", _recommendMarketerId);
      row.set("recommendMarketerUserId", _recommendMarketerUserId);
      row.set("recommendBeginDate", _recommendBeginDate);
      row.set("recommendEndDate", _recommendEndDate);
      row.set("recommendScore", _recommendScore);
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
      map.put("userId", RLong.toString(_userId));
      map.put("linkId", RLong.toString(_linkId));
      map.put("statisticsId", RLong.toString(_statisticsId));
      map.put("passport", _passport);
      map.put("label", _label);
      map.put("card", _card);
      map.put("birthday", _birthday.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("phone", _phone);
      map.put("email", _email);
      map.put("genderCd", RInteger.toString(_genderCd));
      map.put("marryCd", RInteger.toString(_marryCd));
      map.put("educationCd", RInteger.toString(_educationCd));
      map.put("businessCd", RInteger.toString(_businessCd));
      map.put("incomeCd", RInteger.toString(_incomeCd));
      map.put("provinceAreaId", RLong.toString(_provinceAreaId));
      map.put("provinceId", RLong.toString(_provinceId));
      map.put("cityId", RLong.toString(_cityId));
      map.put("areaId", RLong.toString(_areaId));
      map.put("address", _address);
      map.put("registerDate", _registerDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("lastLoginDate", _lastLoginDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("recommendMarketerId", RLong.toString(_recommendMarketerId));
      map.put("recommendMarketerUserId", RLong.toString(_recommendMarketerUserId));
      map.put("recommendBeginDate", _recommendBeginDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("recommendEndDate", _recommendEndDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("recommendScore", RInteger.toString(_recommendScore));
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
      _userId = input.readInt64();
      _linkId = input.readInt64();
      _statisticsId = input.readInt64();
      _passport = input.readString();
      _label = input.readString();
      _card = input.readString();
      _birthday.set(input.readInt64());
      _phone = input.readString();
      _email = input.readString();
      _genderCd = input.readInt32();
      _marryCd = input.readInt32();
      _educationCd = input.readInt32();
      _businessCd = input.readInt32();
      _incomeCd = input.readInt32();
      _provinceAreaId = input.readInt64();
      _provinceId = input.readInt64();
      _cityId = input.readInt64();
      _areaId = input.readInt64();
      _address = input.readString();
      _registerDate.set(input.readInt64());
      _lastLoginDate.set(input.readInt64());
      _recommendMarketerId = input.readInt64();
      _recommendMarketerUserId = input.readInt64();
      _recommendBeginDate.set(input.readInt64());
      _recommendEndDate.set(input.readInt64());
      _recommendScore = input.readInt32();
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
      output.writeInt64(_userId);
      output.writeInt64(_linkId);
      output.writeInt64(_statisticsId);
      output.writeString(_passport);
      output.writeString(_label);
      output.writeString(_card);
      output.writeInt64(_birthday.get());
      output.writeString(_phone);
      output.writeString(_email);
      output.writeInt32(_genderCd);
      output.writeInt32(_marryCd);
      output.writeInt32(_educationCd);
      output.writeInt32(_businessCd);
      output.writeInt32(_incomeCd);
      output.writeInt64(_provinceAreaId);
      output.writeInt64(_provinceId);
      output.writeInt64(_cityId);
      output.writeInt64(_areaId);
      output.writeString(_address);
      output.writeInt64(_registerDate.get());
      output.writeInt64(_lastLoginDate.get());
      output.writeInt64(_recommendMarketerId);
      output.writeInt64(_recommendMarketerUserId);
      output.writeInt64(_recommendBeginDate.get());
      output.writeInt64(_recommendEndDate.get());
      output.writeInt32(_recommendScore);
      output.writeString(_note);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }
}
