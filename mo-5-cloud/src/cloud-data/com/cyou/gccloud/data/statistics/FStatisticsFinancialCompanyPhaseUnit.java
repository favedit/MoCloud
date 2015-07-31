package com.cyou.gccloud.data.statistics;

import java.util.Map;
import org.mo.com.lang.*;
import org.mo.com.lang.type.*;
import org.mo.com.collections.*;
import org.mo.core.aop.face.*;
import org.mo.data.logic.*;

//============================================================
// <T>公司阶段统计表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FStatisticsFinancialCompanyPhaseUnit extends FLogicUnit
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

   // 存储字段公司投资的定义。
   private int __companyInvestment;

   // 字段公司投资的定义。
   protected int _companyInvestment;

   // 存储字段公司投资总计的定义。
   private int __companyInvestmentTotal;

   // 字段公司投资总计的定义。
   protected int _companyInvestmentTotal;

   // 存储字段公司赎回的定义。
   private int __companyRedemption;

   // 字段公司赎回的定义。
   protected int _companyRedemption;

   // 存储字段公司赎回总计的定义。
   private int __companyRedemptionTotal;

   // 字段公司赎回总计的定义。
   protected int _companyRedemptionTotal;

   // 存储字段公司净投的定义。
   private int __companyNetinvestment;

   // 字段公司净投的定义。
   protected int _companyNetinvestment;

   // 存储字段公司净投总计的定义。
   private int __companyNetinvestmentTotal;

   // 字段公司净投总计的定义。
   protected int _companyNetinvestmentTotal;

   // 存储字段公司绩效的定义。
   private int __companyPerformance;

   // 字段公司绩效的定义。
   protected int _companyPerformance;

   // 存储字段公司绩效总计的定义。
   private int __companyPerformanceTotal;

   // 字段公司绩效总计的定义。
   protected int _companyPerformanceTotal;

   // 存储字段理财师注册数的定义。
   private int __marketerRegister;

   // 字段理财师注册数的定义。
   protected int _marketerRegister;

   // 存储字段理财师总数的定义。
   private long __marketerTotal;

   // 字段理财师总数的定义。
   protected long _marketerTotal;

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
   // <T>构造公司阶段统计表逻辑单元。</T>
   //============================================================
   public FStatisticsFinancialCompanyPhaseUnit(){
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
   // <T>判断公司投资的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCompanyInvestmentChanged(){
      return __companyInvestment != _companyInvestment;
   }

   //============================================================
   // <T>获得公司投资的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int companyInvestment(){
      return _companyInvestment;
   }

   //============================================================
   // <T>设置公司投资的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCompanyInvestment(int value){
      _companyInvestment = value;
   }

   //============================================================
   // <T>判断公司投资总计的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCompanyInvestmentTotalChanged(){
      return __companyInvestmentTotal != _companyInvestmentTotal;
   }

   //============================================================
   // <T>获得公司投资总计的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int companyInvestmentTotal(){
      return _companyInvestmentTotal;
   }

   //============================================================
   // <T>设置公司投资总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCompanyInvestmentTotal(int value){
      _companyInvestmentTotal = value;
   }

   //============================================================
   // <T>判断公司赎回的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCompanyRedemptionChanged(){
      return __companyRedemption != _companyRedemption;
   }

   //============================================================
   // <T>获得公司赎回的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int companyRedemption(){
      return _companyRedemption;
   }

   //============================================================
   // <T>设置公司赎回的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCompanyRedemption(int value){
      _companyRedemption = value;
   }

   //============================================================
   // <T>判断公司赎回总计的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCompanyRedemptionTotalChanged(){
      return __companyRedemptionTotal != _companyRedemptionTotal;
   }

   //============================================================
   // <T>获得公司赎回总计的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int companyRedemptionTotal(){
      return _companyRedemptionTotal;
   }

   //============================================================
   // <T>设置公司赎回总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCompanyRedemptionTotal(int value){
      _companyRedemptionTotal = value;
   }

   //============================================================
   // <T>判断公司净投的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCompanyNetinvestmentChanged(){
      return __companyNetinvestment != _companyNetinvestment;
   }

   //============================================================
   // <T>获得公司净投的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int companyNetinvestment(){
      return _companyNetinvestment;
   }

   //============================================================
   // <T>设置公司净投的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCompanyNetinvestment(int value){
      _companyNetinvestment = value;
   }

   //============================================================
   // <T>判断公司净投总计的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCompanyNetinvestmentTotalChanged(){
      return __companyNetinvestmentTotal != _companyNetinvestmentTotal;
   }

   //============================================================
   // <T>获得公司净投总计的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int companyNetinvestmentTotal(){
      return _companyNetinvestmentTotal;
   }

   //============================================================
   // <T>设置公司净投总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCompanyNetinvestmentTotal(int value){
      _companyNetinvestmentTotal = value;
   }

   //============================================================
   // <T>判断公司绩效的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCompanyPerformanceChanged(){
      return __companyPerformance != _companyPerformance;
   }

   //============================================================
   // <T>获得公司绩效的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int companyPerformance(){
      return _companyPerformance;
   }

   //============================================================
   // <T>设置公司绩效的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCompanyPerformance(int value){
      _companyPerformance = value;
   }

   //============================================================
   // <T>判断公司绩效总计的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCompanyPerformanceTotalChanged(){
      return __companyPerformanceTotal != _companyPerformanceTotal;
   }

   //============================================================
   // <T>获得公司绩效总计的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int companyPerformanceTotal(){
      return _companyPerformanceTotal;
   }

   //============================================================
   // <T>设置公司绩效总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCompanyPerformanceTotal(int value){
      _companyPerformanceTotal = value;
   }

   //============================================================
   // <T>判断理财师注册数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarketerRegisterChanged(){
      return __marketerRegister != _marketerRegister;
   }

   //============================================================
   // <T>获得理财师注册数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int marketerRegister(){
      return _marketerRegister;
   }

   //============================================================
   // <T>设置理财师注册数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerRegister(int value){
      _marketerRegister = value;
   }

   //============================================================
   // <T>判断理财师总数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarketerTotalChanged(){
      return __marketerTotal != _marketerTotal;
   }

   //============================================================
   // <T>获得理财师总数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long marketerTotal(){
      return _marketerTotal;
   }

   //============================================================
   // <T>设置理财师总数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerTotal(long value){
      _marketerTotal = value;
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
         case "company_investment":
            return RInteger.toString(_companyInvestment);
         case "company_investment_total":
            return RInteger.toString(_companyInvestmentTotal);
         case "company_redemption":
            return RInteger.toString(_companyRedemption);
         case "company_redemption_total":
            return RInteger.toString(_companyRedemptionTotal);
         case "company_netinvestment":
            return RInteger.toString(_companyNetinvestment);
         case "company_netinvestment_total":
            return RInteger.toString(_companyNetinvestmentTotal);
         case "company_performance":
            return RInteger.toString(_companyPerformance);
         case "company_performance_total":
            return RInteger.toString(_companyPerformanceTotal);
         case "marketer_register":
            return RInteger.toString(_marketerRegister);
         case "marketer_total":
            return Long.toString(_marketerTotal);
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
         case "company_investment":
            _companyInvestment = RInteger.parse(value);
            break;
         case "company_investment_total":
            _companyInvestmentTotal = RInteger.parse(value);
            break;
         case "company_redemption":
            _companyRedemption = RInteger.parse(value);
            break;
         case "company_redemption_total":
            _companyRedemptionTotal = RInteger.parse(value);
            break;
         case "company_netinvestment":
            _companyNetinvestment = RInteger.parse(value);
            break;
         case "company_netinvestment_total":
            _companyNetinvestmentTotal = RInteger.parse(value);
            break;
         case "company_performance":
            _companyPerformance = RInteger.parse(value);
            break;
         case "company_performance_total":
            _companyPerformanceTotal = RInteger.parse(value);
            break;
         case "marketer_register":
            _marketerRegister = RInteger.parse(value);
            break;
         case "marketer_total":
            _marketerTotal = RLong.parse(value);
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
            case "company_investment":
               __companyInvestment = RInteger.parse(value);
               _companyInvestment = __companyInvestment;
               break;
            case "company_investment_total":
               __companyInvestmentTotal = RInteger.parse(value);
               _companyInvestmentTotal = __companyInvestmentTotal;
               break;
            case "company_redemption":
               __companyRedemption = RInteger.parse(value);
               _companyRedemption = __companyRedemption;
               break;
            case "company_redemption_total":
               __companyRedemptionTotal = RInteger.parse(value);
               _companyRedemptionTotal = __companyRedemptionTotal;
               break;
            case "company_netinvestment":
               __companyNetinvestment = RInteger.parse(value);
               _companyNetinvestment = __companyNetinvestment;
               break;
            case "company_netinvestment_total":
               __companyNetinvestmentTotal = RInteger.parse(value);
               _companyNetinvestmentTotal = __companyNetinvestmentTotal;
               break;
            case "company_performance":
               __companyPerformance = RInteger.parse(value);
               _companyPerformance = __companyPerformance;
               break;
            case "company_performance_total":
               __companyPerformanceTotal = RInteger.parse(value);
               _companyPerformanceTotal = __companyPerformanceTotal;
               break;
            case "marketer_register":
               __marketerRegister = RInteger.parse(value);
               _marketerRegister = __marketerRegister;
               break;
            case "marketer_total":
               __marketerTotal = RLong.parse(value);
               _marketerTotal = __marketerTotal;
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
      row.set("companyInvestment", _companyInvestment);
      row.set("companyInvestmentTotal", _companyInvestmentTotal);
      row.set("companyRedemption", _companyRedemption);
      row.set("companyRedemptionTotal", _companyRedemptionTotal);
      row.set("companyNetinvestment", _companyNetinvestment);
      row.set("companyNetinvestmentTotal", _companyNetinvestmentTotal);
      row.set("companyPerformance", _companyPerformance);
      row.set("companyPerformanceTotal", _companyPerformanceTotal);
      row.set("marketerRegister", _marketerRegister);
      row.set("marketerTotal", _marketerTotal);
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
      map.put("companyInvestment", RInteger.toString(_companyInvestment));
      map.put("companyInvestmentTotal", RInteger.toString(_companyInvestmentTotal));
      map.put("companyRedemption", RInteger.toString(_companyRedemption));
      map.put("companyRedemptionTotal", RInteger.toString(_companyRedemptionTotal));
      map.put("companyNetinvestment", RInteger.toString(_companyNetinvestment));
      map.put("companyNetinvestmentTotal", RInteger.toString(_companyNetinvestmentTotal));
      map.put("companyPerformance", RInteger.toString(_companyPerformance));
      map.put("companyPerformanceTotal", RInteger.toString(_companyPerformanceTotal));
      map.put("marketerRegister", RInteger.toString(_marketerRegister));
      map.put("marketerTotal", RLong.toString(_marketerTotal));
      map.put("customerRegister", RInteger.toString(_customerRegister));
      map.put("customerTotal", RInteger.toString(_customerTotal));
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
