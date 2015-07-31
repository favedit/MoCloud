package com.cyou.gccloud.data.statistics;

import java.util.Map;
import org.mo.com.lang.*;
import org.mo.com.lang.type.*;
import org.mo.com.collections.*;
import org.mo.core.aop.face.*;
import org.mo.data.logic.*;

//============================================================
// <T>客户阶段统计表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FStatisticsFinancialCustomerPhaseUnit extends FLogicUnit
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

   // 存储字段用户编号的定义。
   private long __customerId;

   // 字段用户编号的定义。
   protected long _customerId;

   // 存储字段用户名称的定义。
   private String __customerLabel;

   // 字段用户名称的定义。
   protected String _customerLabel;

   // 存储字段投资的定义。
   private int __investment;

   // 字段投资的定义。
   protected int _investment;

   // 存储字段投资总计的定义。
   private int __investmentTotal;

   // 字段投资总计的定义。
   protected int _investmentTotal;

   // 存储字段赎回的定义。
   private int __redemption;

   // 字段赎回的定义。
   protected int _redemption;

   // 存储字段赎回总计的定义。
   private int __redemptionTotal;

   // 字段赎回总计的定义。
   protected int _redemptionTotal;

   // 存储字段净投的定义。
   private int __netinvestment;

   // 字段净投的定义。
   protected int _netinvestment;

   // 存储字段净投总计的定义。
   private int __netinvestmentTotal;

   // 字段净投总计的定义。
   protected int _netinvestmentTotal;

   // 存储字段绩效的定义。
   private int __performance;

   // 字段绩效的定义。
   protected int _performance;

   // 存储字段绩效总计的定义。
   private int __performanceTotal;

   // 字段绩效总计的定义。
   protected int _performanceTotal;

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
   // <T>构造客户阶段统计表逻辑单元。</T>
   //============================================================
   public FStatisticsFinancialCustomerPhaseUnit(){
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
   // <T>判断用户编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerIdChanged(){
      return __customerId != _customerId;
   }

   //============================================================
   // <T>获得用户编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long customerId(){
      return _customerId;
   }

   //============================================================
   // <T>设置用户编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerId(long value){
      _customerId = value;
   }

   //============================================================
   // <T>判断用户名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerLabelChanged(){
      return !RString.equals(__customerLabel, _customerLabel);
   }

   //============================================================
   // <T>获得用户名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String customerLabel(){
      return _customerLabel;
   }

   //============================================================
   // <T>设置用户名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerLabel(String value){
      _customerLabel = value;
   }

   //============================================================
   // <T>判断投资的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInvestmentChanged(){
      return __investment != _investment;
   }

   //============================================================
   // <T>获得投资的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int investment(){
      return _investment;
   }

   //============================================================
   // <T>设置投资的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInvestment(int value){
      _investment = value;
   }

   //============================================================
   // <T>判断投资总计的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInvestmentTotalChanged(){
      return __investmentTotal != _investmentTotal;
   }

   //============================================================
   // <T>获得投资总计的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int investmentTotal(){
      return _investmentTotal;
   }

   //============================================================
   // <T>设置投资总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInvestmentTotal(int value){
      _investmentTotal = value;
   }

   //============================================================
   // <T>判断赎回的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRedemptionChanged(){
      return __redemption != _redemption;
   }

   //============================================================
   // <T>获得赎回的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int redemption(){
      return _redemption;
   }

   //============================================================
   // <T>设置赎回的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRedemption(int value){
      _redemption = value;
   }

   //============================================================
   // <T>判断赎回总计的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRedemptionTotalChanged(){
      return __redemptionTotal != _redemptionTotal;
   }

   //============================================================
   // <T>获得赎回总计的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int redemptionTotal(){
      return _redemptionTotal;
   }

   //============================================================
   // <T>设置赎回总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRedemptionTotal(int value){
      _redemptionTotal = value;
   }

   //============================================================
   // <T>判断净投的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isNetinvestmentChanged(){
      return __netinvestment != _netinvestment;
   }

   //============================================================
   // <T>获得净投的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int netinvestment(){
      return _netinvestment;
   }

   //============================================================
   // <T>设置净投的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setNetinvestment(int value){
      _netinvestment = value;
   }

   //============================================================
   // <T>判断净投总计的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isNetinvestmentTotalChanged(){
      return __netinvestmentTotal != _netinvestmentTotal;
   }

   //============================================================
   // <T>获得净投总计的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int netinvestmentTotal(){
      return _netinvestmentTotal;
   }

   //============================================================
   // <T>设置净投总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setNetinvestmentTotal(int value){
      _netinvestmentTotal = value;
   }

   //============================================================
   // <T>判断绩效的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPerformanceChanged(){
      return __performance != _performance;
   }

   //============================================================
   // <T>获得绩效的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int performance(){
      return _performance;
   }

   //============================================================
   // <T>设置绩效的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPerformance(int value){
      _performance = value;
   }

   //============================================================
   // <T>判断绩效总计的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPerformanceTotalChanged(){
      return __performanceTotal != _performanceTotal;
   }

   //============================================================
   // <T>获得绩效总计的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int performanceTotal(){
      return _performanceTotal;
   }

   //============================================================
   // <T>设置绩效总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPerformanceTotal(int value){
      _performanceTotal = value;
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
         case "customer_id":
            return Long.toString(_customerId);
         case "customer_label":
            return _customerLabel;
         case "investment":
            return RInteger.toString(_investment);
         case "investment_total":
            return RInteger.toString(_investmentTotal);
         case "redemption":
            return RInteger.toString(_redemption);
         case "redemption_total":
            return RInteger.toString(_redemptionTotal);
         case "netinvestment":
            return RInteger.toString(_netinvestment);
         case "netinvestment_total":
            return RInteger.toString(_netinvestmentTotal);
         case "performance":
            return RInteger.toString(_performance);
         case "performance_total":
            return RInteger.toString(_performanceTotal);
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
         case "customer_id":
            _customerId = RLong.parse(value);
            break;
         case "customer_label":
            _customerLabel = value;
            break;
         case "investment":
            _investment = RInteger.parse(value);
            break;
         case "investment_total":
            _investmentTotal = RInteger.parse(value);
            break;
         case "redemption":
            _redemption = RInteger.parse(value);
            break;
         case "redemption_total":
            _redemptionTotal = RInteger.parse(value);
            break;
         case "netinvestment":
            _netinvestment = RInteger.parse(value);
            break;
         case "netinvestment_total":
            _netinvestmentTotal = RInteger.parse(value);
            break;
         case "performance":
            _performance = RInteger.parse(value);
            break;
         case "performance_total":
            _performanceTotal = RInteger.parse(value);
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
            case "customer_id":
               __customerId = RLong.parse(value);
               _customerId = __customerId;
               break;
            case "customer_label":
               __customerLabel = value;
               _customerLabel = __customerLabel;
               break;
            case "investment":
               __investment = RInteger.parse(value);
               _investment = __investment;
               break;
            case "investment_total":
               __investmentTotal = RInteger.parse(value);
               _investmentTotal = __investmentTotal;
               break;
            case "redemption":
               __redemption = RInteger.parse(value);
               _redemption = __redemption;
               break;
            case "redemption_total":
               __redemptionTotal = RInteger.parse(value);
               _redemptionTotal = __redemptionTotal;
               break;
            case "netinvestment":
               __netinvestment = RInteger.parse(value);
               _netinvestment = __netinvestment;
               break;
            case "netinvestment_total":
               __netinvestmentTotal = RInteger.parse(value);
               _netinvestmentTotal = __netinvestmentTotal;
               break;
            case "performance":
               __performance = RInteger.parse(value);
               _performance = __performance;
               break;
            case "performance_total":
               __performanceTotal = RInteger.parse(value);
               _performanceTotal = __performanceTotal;
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
      row.set("customerId", _customerId);
      row.set("customerLabel", _customerLabel);
      row.set("investment", _investment);
      row.set("investmentTotal", _investmentTotal);
      row.set("redemption", _redemption);
      row.set("redemptionTotal", _redemptionTotal);
      row.set("netinvestment", _netinvestment);
      row.set("netinvestmentTotal", _netinvestmentTotal);
      row.set("performance", _performance);
      row.set("performanceTotal", _performanceTotal);
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
      map.put("customerId", RLong.toString(_customerId));
      map.put("customerLabel", _customerLabel);
      map.put("investment", RInteger.toString(_investment));
      map.put("investmentTotal", RInteger.toString(_investmentTotal));
      map.put("redemption", RInteger.toString(_redemption));
      map.put("redemptionTotal", RInteger.toString(_redemptionTotal));
      map.put("netinvestment", RInteger.toString(_netinvestment));
      map.put("netinvestmentTotal", RInteger.toString(_netinvestmentTotal));
      map.put("performance", RInteger.toString(_performance));
      map.put("performanceTotal", RInteger.toString(_performanceTotal));
      map.put("createUserId", RLong.toString(_createUserId));
      map.put("createDate", _createDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("updateUserId", RLong.toString(_updateUserId));
      map.put("updateDate", _updateDate.format("YYYY-MM-DD HH24:MI:SS"));
   }
}
