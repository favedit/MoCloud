package com.cyou.gccloud.data.statistics;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>理财师阶段统计表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FStatisticsFinancialMarketerPhaseUnit
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

   // 存储字段记录年的定义。
   private TDateTime __recordYear = new TDateTime();

   // 字段记录年的定义。
   protected TDateTime _recordYear = new TDateTime();

   // 存储字段记录月的定义。
   private TDateTime __recordMonth = new TDateTime();

   // 字段记录月的定义。
   protected TDateTime _recordMonth = new TDateTime();

   // 存储字段记录周的定义。
   private TDateTime __recordWeek = new TDateTime();

   // 字段记录周的定义。
   protected TDateTime _recordWeek = new TDateTime();

   // 存储字段记录日的定义。
   private TDateTime __recordDay = new TDateTime();

   // 字段记录日的定义。
   protected TDateTime _recordDay = new TDateTime();

   // 存储字段记录小时的定义。
   private TDateTime __recordHour = new TDateTime();

   // 字段记录小时的定义。
   protected TDateTime _recordHour = new TDateTime();

   // 存储字段记录日期的定义。
   private TDateTime __recordDate = new TDateTime();

   // 字段记录日期的定义。
   protected TDateTime _recordDate = new TDateTime();

   // 存储字段公司编号的定义。
   private long __companyId;

   // 字段公司编号的定义。
   protected long _companyId;

   // 存储字段公司名称的定义。
   private String __companyLabel;

   // 字段公司名称的定义。
   protected String _companyLabel;

   // 存储字段理财师编号的定义。
   private long __marketerId;

   // 字段理财师编号的定义。
   protected long _marketerId;

   // 存储字段理财师名称的定义。
   private String __marketerLabel;

   // 字段理财师名称的定义。
   protected String _marketerLabel;

   // 存储字段理财师投资的定义。
   private int __marketerInvestment;

   // 字段理财师投资的定义。
   protected int _marketerInvestment;

   // 存储字段理财师投资总计的定义。
   private int __marketerInvestmentTotal;

   // 字段理财师投资总计的定义。
   protected int _marketerInvestmentTotal;

   // 存储字段理财师赎回的定义。
   private int __marketerRedemption;

   // 字段理财师赎回的定义。
   protected int _marketerRedemption;

   // 存储字段理财师赎回总计的定义。
   private int __marketerRedemptionTotal;

   // 字段理财师赎回总计的定义。
   protected int _marketerRedemptionTotal;

   // 存储字段理财师净投的定义。
   private int __marketerNetinvestment;

   // 字段理财师净投的定义。
   protected int _marketerNetinvestment;

   // 存储字段理财师净投总计的定义。
   private int __marketerNetinvestmentTotal;

   // 字段理财师净投总计的定义。
   protected int _marketerNetinvestmentTotal;

   // 存储字段理财师绩效的定义。
   private int __marketerPerformance;

   // 字段理财师绩效的定义。
   protected int _marketerPerformance;

   // 存储字段理财师绩效总计的定义。
   private int __marketerPerformanceTotal;

   // 字段理财师绩效总计的定义。
   protected int _marketerPerformanceTotal;

   // 存储字段客户注册数的定义。
   private int __customerRegister;

   // 字段客户注册数的定义。
   protected int _customerRegister;

   // 存储字段客户总数的定义。
   private int __customerTotal;

   // 字段客户总数的定义。
   protected int _customerTotal;

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
   // <T>构造理财师阶段统计表逻辑单元。</T>
   //============================================================
   public FStatisticsFinancialMarketerPhaseUnit(){
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
   // <T>判断记录年的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecordYearChanged(){
      return !__recordYear.equals(_recordYear);
   }

   //============================================================
   // <T>获得记录年的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime recordYear(){
      return _recordYear;
   }

   //============================================================
   // <T>设置记录年的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecordYear(TDateTime value){
      _recordYear = value;
   }

   //============================================================
   // <T>判断记录月的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecordMonthChanged(){
      return !__recordMonth.equals(_recordMonth);
   }

   //============================================================
   // <T>获得记录月的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime recordMonth(){
      return _recordMonth;
   }

   //============================================================
   // <T>设置记录月的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecordMonth(TDateTime value){
      _recordMonth = value;
   }

   //============================================================
   // <T>判断记录周的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecordWeekChanged(){
      return !__recordWeek.equals(_recordWeek);
   }

   //============================================================
   // <T>获得记录周的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime recordWeek(){
      return _recordWeek;
   }

   //============================================================
   // <T>设置记录周的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecordWeek(TDateTime value){
      _recordWeek = value;
   }

   //============================================================
   // <T>判断记录日的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecordDayChanged(){
      return !__recordDay.equals(_recordDay);
   }

   //============================================================
   // <T>获得记录日的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime recordDay(){
      return _recordDay;
   }

   //============================================================
   // <T>设置记录日的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecordDay(TDateTime value){
      _recordDay = value;
   }

   //============================================================
   // <T>判断记录小时的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecordHourChanged(){
      return !__recordHour.equals(_recordHour);
   }

   //============================================================
   // <T>获得记录小时的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime recordHour(){
      return _recordHour;
   }

   //============================================================
   // <T>设置记录小时的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecordHour(TDateTime value){
      _recordHour = value;
   }

   //============================================================
   // <T>判断记录日期的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRecordDateChanged(){
      return !__recordDate.equals(_recordDate);
   }

   //============================================================
   // <T>获得记录日期的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime recordDate(){
      return _recordDate;
   }

   //============================================================
   // <T>设置记录日期的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRecordDate(TDateTime value){
      _recordDate = value;
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
   // <T>判断理财师名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarketerLabelChanged(){
      return !RString.equals(__marketerLabel, _marketerLabel);
   }

   //============================================================
   // <T>获得理财师名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String marketerLabel(){
      return _marketerLabel;
   }

   //============================================================
   // <T>设置理财师名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerLabel(String value){
      _marketerLabel = value;
   }

   //============================================================
   // <T>判断理财师投资的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarketerInvestmentChanged(){
      return __marketerInvestment != _marketerInvestment;
   }

   //============================================================
   // <T>获得理财师投资的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int marketerInvestment(){
      return _marketerInvestment;
   }

   //============================================================
   // <T>设置理财师投资的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerInvestment(int value){
      _marketerInvestment = value;
   }

   //============================================================
   // <T>判断理财师投资总计的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarketerInvestmentTotalChanged(){
      return __marketerInvestmentTotal != _marketerInvestmentTotal;
   }

   //============================================================
   // <T>获得理财师投资总计的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int marketerInvestmentTotal(){
      return _marketerInvestmentTotal;
   }

   //============================================================
   // <T>设置理财师投资总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerInvestmentTotal(int value){
      _marketerInvestmentTotal = value;
   }

   //============================================================
   // <T>判断理财师赎回的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarketerRedemptionChanged(){
      return __marketerRedemption != _marketerRedemption;
   }

   //============================================================
   // <T>获得理财师赎回的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int marketerRedemption(){
      return _marketerRedemption;
   }

   //============================================================
   // <T>设置理财师赎回的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerRedemption(int value){
      _marketerRedemption = value;
   }

   //============================================================
   // <T>判断理财师赎回总计的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarketerRedemptionTotalChanged(){
      return __marketerRedemptionTotal != _marketerRedemptionTotal;
   }

   //============================================================
   // <T>获得理财师赎回总计的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int marketerRedemptionTotal(){
      return _marketerRedemptionTotal;
   }

   //============================================================
   // <T>设置理财师赎回总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerRedemptionTotal(int value){
      _marketerRedemptionTotal = value;
   }

   //============================================================
   // <T>判断理财师净投的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarketerNetinvestmentChanged(){
      return __marketerNetinvestment != _marketerNetinvestment;
   }

   //============================================================
   // <T>获得理财师净投的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int marketerNetinvestment(){
      return _marketerNetinvestment;
   }

   //============================================================
   // <T>设置理财师净投的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerNetinvestment(int value){
      _marketerNetinvestment = value;
   }

   //============================================================
   // <T>判断理财师净投总计的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarketerNetinvestmentTotalChanged(){
      return __marketerNetinvestmentTotal != _marketerNetinvestmentTotal;
   }

   //============================================================
   // <T>获得理财师净投总计的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int marketerNetinvestmentTotal(){
      return _marketerNetinvestmentTotal;
   }

   //============================================================
   // <T>设置理财师净投总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerNetinvestmentTotal(int value){
      _marketerNetinvestmentTotal = value;
   }

   //============================================================
   // <T>判断理财师绩效的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarketerPerformanceChanged(){
      return __marketerPerformance != _marketerPerformance;
   }

   //============================================================
   // <T>获得理财师绩效的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int marketerPerformance(){
      return _marketerPerformance;
   }

   //============================================================
   // <T>设置理财师绩效的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerPerformance(int value){
      _marketerPerformance = value;
   }

   //============================================================
   // <T>判断理财师绩效总计的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarketerPerformanceTotalChanged(){
      return __marketerPerformanceTotal != _marketerPerformanceTotal;
   }

   //============================================================
   // <T>获得理财师绩效总计的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int marketerPerformanceTotal(){
      return _marketerPerformanceTotal;
   }

   //============================================================
   // <T>设置理财师绩效总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerPerformanceTotal(int value){
      _marketerPerformanceTotal = value;
   }

   //============================================================
   // <T>判断客户注册数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerRegisterChanged(){
      return __customerRegister != _customerRegister;
   }

   //============================================================
   // <T>获得客户注册数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int customerRegister(){
      return _customerRegister;
   }

   //============================================================
   // <T>设置客户注册数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerRegister(int value){
      _customerRegister = value;
   }

   //============================================================
   // <T>判断客户总数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerTotalChanged(){
      return __customerTotal != _customerTotal;
   }

   //============================================================
   // <T>获得客户总数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int customerTotal(){
      return _customerTotal;
   }

   //============================================================
   // <T>设置客户总数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerTotal(int value){
      _customerTotal = value;
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
         case "record_year":
            return _recordYear.toString();
         case "record_month":
            return _recordMonth.toString();
         case "record_week":
            return _recordWeek.toString();
         case "record_day":
            return _recordDay.toString();
         case "record_hour":
            return _recordHour.toString();
         case "record_date":
            return _recordDate.toString();
         case "company_id":
            return Long.toString(_companyId);
         case "company_label":
            return _companyLabel;
         case "marketer_id":
            return Long.toString(_marketerId);
         case "marketer_label":
            return _marketerLabel;
         case "marketer_investment":
            return RInteger.toString(_marketerInvestment);
         case "marketer_investment_total":
            return RInteger.toString(_marketerInvestmentTotal);
         case "marketer_redemption":
            return RInteger.toString(_marketerRedemption);
         case "marketer_redemption_total":
            return RInteger.toString(_marketerRedemptionTotal);
         case "marketer_netinvestment":
            return RInteger.toString(_marketerNetinvestment);
         case "marketer_netinvestment_total":
            return RInteger.toString(_marketerNetinvestmentTotal);
         case "marketer_performance":
            return RInteger.toString(_marketerPerformance);
         case "marketer_performance_total":
            return RInteger.toString(_marketerPerformanceTotal);
         case "customer_register":
            return RInteger.toString(_customerRegister);
         case "customer_total":
            return RInteger.toString(_customerTotal);
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
         case "record_year":
            _recordYear.parse(value);
            break;
         case "record_month":
            _recordMonth.parse(value);
            break;
         case "record_week":
            _recordWeek.parse(value);
            break;
         case "record_day":
            _recordDay.parse(value);
            break;
         case "record_hour":
            _recordHour.parse(value);
            break;
         case "record_date":
            _recordDate.parse(value);
            break;
         case "company_id":
            _companyId = RLong.parse(value);
            break;
         case "company_label":
            _companyLabel = value;
            break;
         case "marketer_id":
            _marketerId = RLong.parse(value);
            break;
         case "marketer_label":
            _marketerLabel = value;
            break;
         case "marketer_investment":
            _marketerInvestment = RInteger.parse(value);
            break;
         case "marketer_investment_total":
            _marketerInvestmentTotal = RInteger.parse(value);
            break;
         case "marketer_redemption":
            _marketerRedemption = RInteger.parse(value);
            break;
         case "marketer_redemption_total":
            _marketerRedemptionTotal = RInteger.parse(value);
            break;
         case "marketer_netinvestment":
            _marketerNetinvestment = RInteger.parse(value);
            break;
         case "marketer_netinvestment_total":
            _marketerNetinvestmentTotal = RInteger.parse(value);
            break;
         case "marketer_performance":
            _marketerPerformance = RInteger.parse(value);
            break;
         case "marketer_performance_total":
            _marketerPerformanceTotal = RInteger.parse(value);
            break;
         case "customer_register":
            _customerRegister = RInteger.parse(value);
            break;
         case "customer_total":
            _customerTotal = RInteger.parse(value);
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
            case "record_year":
               __recordYear.parse(value);
               _recordYear.assign(__recordYear);
               break;
            case "record_month":
               __recordMonth.parse(value);
               _recordMonth.assign(__recordMonth);
               break;
            case "record_week":
               __recordWeek.parse(value);
               _recordWeek.assign(__recordWeek);
               break;
            case "record_day":
               __recordDay.parse(value);
               _recordDay.assign(__recordDay);
               break;
            case "record_hour":
               __recordHour.parse(value);
               _recordHour.assign(__recordHour);
               break;
            case "record_date":
               __recordDate.parse(value);
               _recordDate.assign(__recordDate);
               break;
            case "company_id":
               __companyId = RLong.parse(value);
               _companyId = __companyId;
               break;
            case "company_label":
               __companyLabel = value;
               _companyLabel = __companyLabel;
               break;
            case "marketer_id":
               __marketerId = RLong.parse(value);
               _marketerId = __marketerId;
               break;
            case "marketer_label":
               __marketerLabel = value;
               _marketerLabel = __marketerLabel;
               break;
            case "marketer_investment":
               __marketerInvestment = RInteger.parse(value);
               _marketerInvestment = __marketerInvestment;
               break;
            case "marketer_investment_total":
               __marketerInvestmentTotal = RInteger.parse(value);
               _marketerInvestmentTotal = __marketerInvestmentTotal;
               break;
            case "marketer_redemption":
               __marketerRedemption = RInteger.parse(value);
               _marketerRedemption = __marketerRedemption;
               break;
            case "marketer_redemption_total":
               __marketerRedemptionTotal = RInteger.parse(value);
               _marketerRedemptionTotal = __marketerRedemptionTotal;
               break;
            case "marketer_netinvestment":
               __marketerNetinvestment = RInteger.parse(value);
               _marketerNetinvestment = __marketerNetinvestment;
               break;
            case "marketer_netinvestment_total":
               __marketerNetinvestmentTotal = RInteger.parse(value);
               _marketerNetinvestmentTotal = __marketerNetinvestmentTotal;
               break;
            case "marketer_performance":
               __marketerPerformance = RInteger.parse(value);
               _marketerPerformance = __marketerPerformance;
               break;
            case "marketer_performance_total":
               __marketerPerformanceTotal = RInteger.parse(value);
               _marketerPerformanceTotal = __marketerPerformanceTotal;
               break;
            case "customer_register":
               __customerRegister = RInteger.parse(value);
               _customerRegister = __customerRegister;
               break;
            case "customer_total":
               __customerTotal = RInteger.parse(value);
               _customerTotal = __customerTotal;
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
      row.set("recordYear", _recordYear);
      row.set("recordMonth", _recordMonth);
      row.set("recordWeek", _recordWeek);
      row.set("recordDay", _recordDay);
      row.set("recordHour", _recordHour);
      row.set("recordDate", _recordDate);
      row.set("companyId", _companyId);
      row.set("companyLabel", _companyLabel);
      row.set("marketerId", _marketerId);
      row.set("marketerLabel", _marketerLabel);
      row.set("marketerInvestment", _marketerInvestment);
      row.set("marketerInvestmentTotal", _marketerInvestmentTotal);
      row.set("marketerRedemption", _marketerRedemption);
      row.set("marketerRedemptionTotal", _marketerRedemptionTotal);
      row.set("marketerNetinvestment", _marketerNetinvestment);
      row.set("marketerNetinvestmentTotal", _marketerNetinvestmentTotal);
      row.set("marketerPerformance", _marketerPerformance);
      row.set("marketerPerformanceTotal", _marketerPerformanceTotal);
      row.set("customerRegister", _customerRegister);
      row.set("customerTotal", _customerTotal);
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
      map.put("recordYear", _recordYear.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("recordMonth", _recordMonth.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("recordWeek", _recordWeek.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("recordDay", _recordDay.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("recordHour", _recordHour.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("recordDate", _recordDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("companyId", RLong.toString(_companyId));
      map.put("companyLabel", _companyLabel);
      map.put("marketerId", RLong.toString(_marketerId));
      map.put("marketerLabel", _marketerLabel);
      map.put("marketerInvestment", RInteger.toString(_marketerInvestment));
      map.put("marketerInvestmentTotal", RInteger.toString(_marketerInvestmentTotal));
      map.put("marketerRedemption", RInteger.toString(_marketerRedemption));
      map.put("marketerRedemptionTotal", RInteger.toString(_marketerRedemptionTotal));
      map.put("marketerNetinvestment", RInteger.toString(_marketerNetinvestment));
      map.put("marketerNetinvestmentTotal", RInteger.toString(_marketerNetinvestmentTotal));
      map.put("marketerPerformance", RInteger.toString(_marketerPerformance));
      map.put("marketerPerformanceTotal", RInteger.toString(_marketerPerformanceTotal));
      map.put("customerRegister", RInteger.toString(_customerRegister));
      map.put("customerTotal", RInteger.toString(_customerTotal));
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
