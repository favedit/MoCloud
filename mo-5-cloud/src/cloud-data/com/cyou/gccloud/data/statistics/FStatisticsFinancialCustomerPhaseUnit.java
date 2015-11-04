package com.cyou.gccloud.data.statistics;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RDouble;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>客户阶段统计表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FStatisticsFinancialCustomerPhaseUnit
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

   // 存储字段部门编号的定义。
   private long __departmentId;

   // 字段部门编号的定义。
   protected long _departmentId;

   // 存储字段部门关联编号的定义。
   private long __departmentLinkId;

   // 字段部门关联编号的定义。
   protected long _departmentLinkId;

   // 存储字段部门名称的定义。
   private String __departmentLabel;

   // 字段部门名称的定义。
   protected String _departmentLabel;

   // 存储字段部门级别1编号的定义。
   private long __departmentLevel1Id;

   // 字段部门级别1编号的定义。
   protected long _departmentLevel1Id;

   // 存储字段部门级别1关联编号的定义。
   private long __departmentLevel1LinkId;

   // 字段部门级别1关联编号的定义。
   protected long _departmentLevel1LinkId;

   // 存储字段部门级别1标签的定义。
   private String __departmentLevel1Label;

   // 字段部门级别1标签的定义。
   protected String _departmentLevel1Label;

   // 存储字段部门级别2编号的定义。
   private long __departmentLevel2Id;

   // 字段部门级别2编号的定义。
   protected long _departmentLevel2Id;

   // 存储字段部门级别2关联编号的定义。
   private long __departmentLevel2LinkId;

   // 字段部门级别2关联编号的定义。
   protected long _departmentLevel2LinkId;

   // 存储字段部门级别2标签的定义。
   private String __departmentLevel2Label;

   // 字段部门级别2标签的定义。
   protected String _departmentLevel2Label;

   // 存储字段部门级别3编号的定义。
   private long __departmentLevel3Id;

   // 字段部门级别3编号的定义。
   protected long _departmentLevel3Id;

   // 存储字段部门级别3关联编号的定义。
   private long __departmentLevel3LinkId;

   // 字段部门级别3关联编号的定义。
   protected long _departmentLevel3LinkId;

   // 存储字段部门级别3标签的定义。
   private String __departmentLevel3Label;

   // 字段部门级别3标签的定义。
   protected String _departmentLevel3Label;

   // 存储字段部门级别4编号的定义。
   private long __departmentLevel4Id;

   // 字段部门级别4编号的定义。
   protected long _departmentLevel4Id;

   // 存储字段部门级别4关联编号的定义。
   private long __departmentLevel4LinkId;

   // 字段部门级别4关联编号的定义。
   protected long _departmentLevel4LinkId;

   // 存储字段部门级别4标签的定义。
   private String __departmentLevel4Label;

   // 字段部门级别4标签的定义。
   protected String _departmentLevel4Label;

   // 存储字段部门级别5编号的定义。
   private long __departmentLevel5Id;

   // 字段部门级别5编号的定义。
   protected long _departmentLevel5Id;

   // 存储字段部门级别5关联编号的定义。
   private long __departmentLevel5LinkId;

   // 字段部门级别5关联编号的定义。
   protected long _departmentLevel5LinkId;

   // 存储字段部门级别5标签的定义。
   private String __departmentLevel5Label;

   // 字段部门级别5标签的定义。
   protected String _departmentLevel5Label;

   // 存储字段部门级别6编号的定义。
   private long __departmentLevel6Id;

   // 字段部门级别6编号的定义。
   protected long _departmentLevel6Id;

   // 存储字段部门级别6关联编号的定义。
   private long __departmentLevel6LinkId;

   // 字段部门级别6关联编号的定义。
   protected long _departmentLevel6LinkId;

   // 存储字段部门级别6标签的定义。
   private String __departmentLevel6Label;

   // 字段部门级别6标签的定义。
   protected String _departmentLevel6Label;

   // 存储字段部门级别7编号的定义。
   private long __departmentLevel7Id;

   // 字段部门级别7编号的定义。
   protected long _departmentLevel7Id;

   // 存储字段部门级别7关联编号的定义。
   private long __departmentLevel7LinkId;

   // 字段部门级别7关联编号的定义。
   protected long _departmentLevel7LinkId;

   // 存储字段部门级别7标签的定义。
   private String __departmentLevel7Label;

   // 字段部门级别7标签的定义。
   protected String _departmentLevel7Label;

   // 存储字段理财师编号的定义。
   private long __marketerId;

   // 字段理财师编号的定义。
   protected long _marketerId;

   // 存储字段理财师关联编号的定义。
   private long __marketerLinkId;

   // 字段理财师关联编号的定义。
   protected long _marketerLinkId;

   // 存储字段理财师名称的定义。
   private String __marketerLabel;

   // 字段理财师名称的定义。
   protected String _marketerLabel;

   // 存储字段用户编号的定义。
   private long __customerId;

   // 字段用户编号的定义。
   protected long _customerId;

   // 存储字段客户关联编号的定义。
   private long __customerLinkId;

   // 字段客户关联编号的定义。
   protected long _customerLinkId;

   // 存储字段客户名称的定义。
   private String __customerLabel;

   // 字段客户名称的定义。
   protected String _customerLabel;

   // 存储字段客户身份证的定义。
   private String __customerCard;

   // 字段客户身份证的定义。
   protected String _customerCard;

   // 存储字段客户地区的定义。
   private String __customerArea;

   // 字段客户地区的定义。
   protected String _customerArea;

   // 存储字段客户生日的定义。
   private String __customerBirth;

   // 字段客户生日的定义。
   protected String _customerBirth;

   // 存储字段客户性别的定义。
   private int __customerGender;

   // 字段客户性别的定义。
   protected int _customerGender;

   // 存储字段客户电话号码的定义。
   private String __customerPhone;

   // 字段客户电话号码的定义。
   protected String _customerPhone;

   // 存储字段客户命令时间的定义。
   private TDateTime __customerActionDate = new TDateTime();

   // 字段客户命令时间的定义。
   protected TDateTime _customerActionDate = new TDateTime();

   // 存储字段投资的定义。
   private double __investment;

   // 字段投资的定义。
   protected double _investment;

   // 存储字段投资总计的定义。
   private double __investmentTotal;

   // 字段投资总计的定义。
   protected double _investmentTotal;

   // 存储字段赎回的定义。
   private double __redemption;

   // 字段赎回的定义。
   protected double _redemption;

   // 存储字段赎回总计的定义。
   private double __redemptionTotal;

   // 字段赎回总计的定义。
   protected double _redemptionTotal;

   // 存储字段净投的定义。
   private double __netinvestment;

   // 字段净投的定义。
   protected double _netinvestment;

   // 存储字段净投总计的定义。
   private double __netinvestmentTotal;

   // 字段净投总计的定义。
   protected double _netinvestmentTotal;

   // 存储字段利息的定义。
   private double __interest;

   // 字段利息的定义。
   protected double _interest;

   // 存储字段利息总计的定义。
   private double __interestTotal;

   // 字段利息总计的定义。
   protected double _interestTotal;

   // 存储字段绩效的定义。
   private double __performance;

   // 字段绩效的定义。
   protected double _performance;

   // 存储字段绩效总计的定义。
   private double __performanceTotal;

   // 字段绩效总计的定义。
   protected double _performanceTotal;

   // 存储字段投标改变的定义。
   private int __tenderChanged;

   // 字段投标改变的定义。
   protected int _tenderChanged;

   // 存储字段前投标编号的定义。
   private long __tenderPriorId;

   // 字段前投标编号的定义。
   protected long _tenderPriorId;

   // 存储字段前投标模式的定义。
   private String __tenderPriorModel;

   // 字段前投标模式的定义。
   protected String _tenderPriorModel;

   // 存储字段投标编号的定义。
   private long __tenderId;

   // 字段投标编号的定义。
   protected long _tenderId;

   // 存储字段投标模式的定义。
   private String __tenderModel;

   // 字段投标模式的定义。
   protected String _tenderModel;

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
   // <T>判断部门关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLinkIdChanged(){
      return __departmentLinkId != _departmentLinkId;
   }

   //============================================================
   // <T>获得部门关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentLinkId(){
      return _departmentLinkId;
   }

   //============================================================
   // <T>设置部门关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLinkId(long value){
      _departmentLinkId = value;
   }

   //============================================================
   // <T>判断部门名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLabelChanged(){
      return !RString.equals(__departmentLabel, _departmentLabel);
   }

   //============================================================
   // <T>获得部门名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String departmentLabel(){
      return _departmentLabel;
   }

   //============================================================
   // <T>设置部门名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLabel(String value){
      _departmentLabel = value;
   }

   //============================================================
   // <T>判断部门级别1编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel1IdChanged(){
      return __departmentLevel1Id != _departmentLevel1Id;
   }

   //============================================================
   // <T>获得部门级别1编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentLevel1Id(){
      return _departmentLevel1Id;
   }

   //============================================================
   // <T>设置部门级别1编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel1Id(long value){
      _departmentLevel1Id = value;
   }

   //============================================================
   // <T>判断部门级别1关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel1LinkIdChanged(){
      return __departmentLevel1LinkId != _departmentLevel1LinkId;
   }

   //============================================================
   // <T>获得部门级别1关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentLevel1LinkId(){
      return _departmentLevel1LinkId;
   }

   //============================================================
   // <T>设置部门级别1关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel1LinkId(long value){
      _departmentLevel1LinkId = value;
   }

   //============================================================
   // <T>判断部门级别1标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel1LabelChanged(){
      return !RString.equals(__departmentLevel1Label, _departmentLevel1Label);
   }

   //============================================================
   // <T>获得部门级别1标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String departmentLevel1Label(){
      return _departmentLevel1Label;
   }

   //============================================================
   // <T>设置部门级别1标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel1Label(String value){
      _departmentLevel1Label = value;
   }

   //============================================================
   // <T>判断部门级别2编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel2IdChanged(){
      return __departmentLevel2Id != _departmentLevel2Id;
   }

   //============================================================
   // <T>获得部门级别2编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentLevel2Id(){
      return _departmentLevel2Id;
   }

   //============================================================
   // <T>设置部门级别2编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel2Id(long value){
      _departmentLevel2Id = value;
   }

   //============================================================
   // <T>判断部门级别2关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel2LinkIdChanged(){
      return __departmentLevel2LinkId != _departmentLevel2LinkId;
   }

   //============================================================
   // <T>获得部门级别2关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentLevel2LinkId(){
      return _departmentLevel2LinkId;
   }

   //============================================================
   // <T>设置部门级别2关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel2LinkId(long value){
      _departmentLevel2LinkId = value;
   }

   //============================================================
   // <T>判断部门级别2标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel2LabelChanged(){
      return !RString.equals(__departmentLevel2Label, _departmentLevel2Label);
   }

   //============================================================
   // <T>获得部门级别2标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String departmentLevel2Label(){
      return _departmentLevel2Label;
   }

   //============================================================
   // <T>设置部门级别2标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel2Label(String value){
      _departmentLevel2Label = value;
   }

   //============================================================
   // <T>判断部门级别3编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel3IdChanged(){
      return __departmentLevel3Id != _departmentLevel3Id;
   }

   //============================================================
   // <T>获得部门级别3编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentLevel3Id(){
      return _departmentLevel3Id;
   }

   //============================================================
   // <T>设置部门级别3编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel3Id(long value){
      _departmentLevel3Id = value;
   }

   //============================================================
   // <T>判断部门级别3关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel3LinkIdChanged(){
      return __departmentLevel3LinkId != _departmentLevel3LinkId;
   }

   //============================================================
   // <T>获得部门级别3关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentLevel3LinkId(){
      return _departmentLevel3LinkId;
   }

   //============================================================
   // <T>设置部门级别3关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel3LinkId(long value){
      _departmentLevel3LinkId = value;
   }

   //============================================================
   // <T>判断部门级别3标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel3LabelChanged(){
      return !RString.equals(__departmentLevel3Label, _departmentLevel3Label);
   }

   //============================================================
   // <T>获得部门级别3标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String departmentLevel3Label(){
      return _departmentLevel3Label;
   }

   //============================================================
   // <T>设置部门级别3标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel3Label(String value){
      _departmentLevel3Label = value;
   }

   //============================================================
   // <T>判断部门级别4编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel4IdChanged(){
      return __departmentLevel4Id != _departmentLevel4Id;
   }

   //============================================================
   // <T>获得部门级别4编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentLevel4Id(){
      return _departmentLevel4Id;
   }

   //============================================================
   // <T>设置部门级别4编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel4Id(long value){
      _departmentLevel4Id = value;
   }

   //============================================================
   // <T>判断部门级别4关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel4LinkIdChanged(){
      return __departmentLevel4LinkId != _departmentLevel4LinkId;
   }

   //============================================================
   // <T>获得部门级别4关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentLevel4LinkId(){
      return _departmentLevel4LinkId;
   }

   //============================================================
   // <T>设置部门级别4关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel4LinkId(long value){
      _departmentLevel4LinkId = value;
   }

   //============================================================
   // <T>判断部门级别4标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel4LabelChanged(){
      return !RString.equals(__departmentLevel4Label, _departmentLevel4Label);
   }

   //============================================================
   // <T>获得部门级别4标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String departmentLevel4Label(){
      return _departmentLevel4Label;
   }

   //============================================================
   // <T>设置部门级别4标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel4Label(String value){
      _departmentLevel4Label = value;
   }

   //============================================================
   // <T>判断部门级别5编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel5IdChanged(){
      return __departmentLevel5Id != _departmentLevel5Id;
   }

   //============================================================
   // <T>获得部门级别5编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentLevel5Id(){
      return _departmentLevel5Id;
   }

   //============================================================
   // <T>设置部门级别5编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel5Id(long value){
      _departmentLevel5Id = value;
   }

   //============================================================
   // <T>判断部门级别5关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel5LinkIdChanged(){
      return __departmentLevel5LinkId != _departmentLevel5LinkId;
   }

   //============================================================
   // <T>获得部门级别5关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentLevel5LinkId(){
      return _departmentLevel5LinkId;
   }

   //============================================================
   // <T>设置部门级别5关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel5LinkId(long value){
      _departmentLevel5LinkId = value;
   }

   //============================================================
   // <T>判断部门级别5标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel5LabelChanged(){
      return !RString.equals(__departmentLevel5Label, _departmentLevel5Label);
   }

   //============================================================
   // <T>获得部门级别5标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String departmentLevel5Label(){
      return _departmentLevel5Label;
   }

   //============================================================
   // <T>设置部门级别5标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel5Label(String value){
      _departmentLevel5Label = value;
   }

   //============================================================
   // <T>判断部门级别6编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel6IdChanged(){
      return __departmentLevel6Id != _departmentLevel6Id;
   }

   //============================================================
   // <T>获得部门级别6编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentLevel6Id(){
      return _departmentLevel6Id;
   }

   //============================================================
   // <T>设置部门级别6编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel6Id(long value){
      _departmentLevel6Id = value;
   }

   //============================================================
   // <T>判断部门级别6关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel6LinkIdChanged(){
      return __departmentLevel6LinkId != _departmentLevel6LinkId;
   }

   //============================================================
   // <T>获得部门级别6关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentLevel6LinkId(){
      return _departmentLevel6LinkId;
   }

   //============================================================
   // <T>设置部门级别6关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel6LinkId(long value){
      _departmentLevel6LinkId = value;
   }

   //============================================================
   // <T>判断部门级别6标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel6LabelChanged(){
      return !RString.equals(__departmentLevel6Label, _departmentLevel6Label);
   }

   //============================================================
   // <T>获得部门级别6标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String departmentLevel6Label(){
      return _departmentLevel6Label;
   }

   //============================================================
   // <T>设置部门级别6标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel6Label(String value){
      _departmentLevel6Label = value;
   }

   //============================================================
   // <T>判断部门级别7编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel7IdChanged(){
      return __departmentLevel7Id != _departmentLevel7Id;
   }

   //============================================================
   // <T>获得部门级别7编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentLevel7Id(){
      return _departmentLevel7Id;
   }

   //============================================================
   // <T>设置部门级别7编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel7Id(long value){
      _departmentLevel7Id = value;
   }

   //============================================================
   // <T>判断部门级别7关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel7LinkIdChanged(){
      return __departmentLevel7LinkId != _departmentLevel7LinkId;
   }

   //============================================================
   // <T>获得部门级别7关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long departmentLevel7LinkId(){
      return _departmentLevel7LinkId;
   }

   //============================================================
   // <T>设置部门级别7关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel7LinkId(long value){
      _departmentLevel7LinkId = value;
   }

   //============================================================
   // <T>判断部门级别7标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLevel7LabelChanged(){
      return !RString.equals(__departmentLevel7Label, _departmentLevel7Label);
   }

   //============================================================
   // <T>获得部门级别7标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String departmentLevel7Label(){
      return _departmentLevel7Label;
   }

   //============================================================
   // <T>设置部门级别7标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLevel7Label(String value){
      _departmentLevel7Label = value;
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
   // <T>判断理财师关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarketerLinkIdChanged(){
      return __marketerLinkId != _marketerLinkId;
   }

   //============================================================
   // <T>获得理财师关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long marketerLinkId(){
      return _marketerLinkId;
   }

   //============================================================
   // <T>设置理财师关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerLinkId(long value){
      _marketerLinkId = value;
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
   // <T>判断客户关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerLinkIdChanged(){
      return __customerLinkId != _customerLinkId;
   }

   //============================================================
   // <T>获得客户关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long customerLinkId(){
      return _customerLinkId;
   }

   //============================================================
   // <T>设置客户关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerLinkId(long value){
      _customerLinkId = value;
   }

   //============================================================
   // <T>判断客户名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerLabelChanged(){
      return !RString.equals(__customerLabel, _customerLabel);
   }

   //============================================================
   // <T>获得客户名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String customerLabel(){
      return _customerLabel;
   }

   //============================================================
   // <T>设置客户名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerLabel(String value){
      _customerLabel = value;
   }

   //============================================================
   // <T>判断客户身份证的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerCardChanged(){
      return !RString.equals(__customerCard, _customerCard);
   }

   //============================================================
   // <T>获得客户身份证的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String customerCard(){
      return _customerCard;
   }

   //============================================================
   // <T>设置客户身份证的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerCard(String value){
      _customerCard = value;
   }

   //============================================================
   // <T>判断客户地区的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerAreaChanged(){
      return !RString.equals(__customerArea, _customerArea);
   }

   //============================================================
   // <T>获得客户地区的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String customerArea(){
      return _customerArea;
   }

   //============================================================
   // <T>设置客户地区的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerArea(String value){
      _customerArea = value;
   }

   //============================================================
   // <T>判断客户生日的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerBirthChanged(){
      return !RString.equals(__customerBirth, _customerBirth);
   }

   //============================================================
   // <T>获得客户生日的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String customerBirth(){
      return _customerBirth;
   }

   //============================================================
   // <T>设置客户生日的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerBirth(String value){
      _customerBirth = value;
   }

   //============================================================
   // <T>判断客户性别的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerGenderChanged(){
      return __customerGender != _customerGender;
   }

   //============================================================
   // <T>获得客户性别的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int customerGender(){
      return _customerGender;
   }

   //============================================================
   // <T>设置客户性别的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerGender(int value){
      _customerGender = value;
   }

   //============================================================
   // <T>判断客户电话号码的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerPhoneChanged(){
      return !RString.equals(__customerPhone, _customerPhone);
   }

   //============================================================
   // <T>获得客户电话号码的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String customerPhone(){
      return _customerPhone;
   }

   //============================================================
   // <T>设置客户电话号码的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerPhone(String value){
      _customerPhone = value;
   }

   //============================================================
   // <T>判断客户命令时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerActionDateChanged(){
      return !__customerActionDate.equals(_customerActionDate);
   }

   //============================================================
   // <T>获得客户命令时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime customerActionDate(){
      return _customerActionDate;
   }

   //============================================================
   // <T>设置客户命令时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerActionDate(TDateTime value){
      _customerActionDate = value;
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
   public double investment(){
      return _investment;
   }

   //============================================================
   // <T>设置投资的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInvestment(double value){
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
   public double investmentTotal(){
      return _investmentTotal;
   }

   //============================================================
   // <T>设置投资总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInvestmentTotal(double value){
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
   public double redemption(){
      return _redemption;
   }

   //============================================================
   // <T>设置赎回的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRedemption(double value){
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
   public double redemptionTotal(){
      return _redemptionTotal;
   }

   //============================================================
   // <T>设置赎回总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRedemptionTotal(double value){
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
   public double netinvestment(){
      return _netinvestment;
   }

   //============================================================
   // <T>设置净投的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setNetinvestment(double value){
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
   public double netinvestmentTotal(){
      return _netinvestmentTotal;
   }

   //============================================================
   // <T>设置净投总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setNetinvestmentTotal(double value){
      _netinvestmentTotal = value;
   }

   //============================================================
   // <T>判断利息的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInterestChanged(){
      return __interest != _interest;
   }

   //============================================================
   // <T>获得利息的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double interest(){
      return _interest;
   }

   //============================================================
   // <T>设置利息的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInterest(double value){
      _interest = value;
   }

   //============================================================
   // <T>判断利息总计的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInterestTotalChanged(){
      return __interestTotal != _interestTotal;
   }

   //============================================================
   // <T>获得利息总计的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double interestTotal(){
      return _interestTotal;
   }

   //============================================================
   // <T>设置利息总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInterestTotal(double value){
      _interestTotal = value;
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
   public double performance(){
      return _performance;
   }

   //============================================================
   // <T>设置绩效的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPerformance(double value){
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
   public double performanceTotal(){
      return _performanceTotal;
   }

   //============================================================
   // <T>设置绩效总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPerformanceTotal(double value){
      _performanceTotal = value;
   }

   //============================================================
   // <T>判断投标改变的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isTenderChangedChanged(){
      return __tenderChanged != _tenderChanged;
   }

   //============================================================
   // <T>获得投标改变的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int tenderChanged(){
      return _tenderChanged;
   }

   //============================================================
   // <T>设置投标改变的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setTenderChanged(int value){
      _tenderChanged = value;
   }

   //============================================================
   // <T>判断前投标编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isTenderPriorIdChanged(){
      return __tenderPriorId != _tenderPriorId;
   }

   //============================================================
   // <T>获得前投标编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long tenderPriorId(){
      return _tenderPriorId;
   }

   //============================================================
   // <T>设置前投标编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setTenderPriorId(long value){
      _tenderPriorId = value;
   }

   //============================================================
   // <T>判断前投标模式的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isTenderPriorModelChanged(){
      return !RString.equals(__tenderPriorModel, _tenderPriorModel);
   }

   //============================================================
   // <T>获得前投标模式的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String tenderPriorModel(){
      return _tenderPriorModel;
   }

   //============================================================
   // <T>设置前投标模式的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setTenderPriorModel(String value){
      _tenderPriorModel = value;
   }

   //============================================================
   // <T>判断投标编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isTenderIdChanged(){
      return __tenderId != _tenderId;
   }

   //============================================================
   // <T>获得投标编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long tenderId(){
      return _tenderId;
   }

   //============================================================
   // <T>设置投标编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setTenderId(long value){
      _tenderId = value;
   }

   //============================================================
   // <T>判断投标模式的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isTenderModelChanged(){
      return !RString.equals(__tenderModel, _tenderModel);
   }

   //============================================================
   // <T>获得投标模式的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String tenderModel(){
      return _tenderModel;
   }

   //============================================================
   // <T>设置投标模式的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setTenderModel(String value){
      _tenderModel = value;
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
         case "department_id":
            return Long.toString(_departmentId);
         case "department_link_id":
            return Long.toString(_departmentLinkId);
         case "department_label":
            return _departmentLabel;
         case "department_level1_id":
            return Long.toString(_departmentLevel1Id);
         case "department_level1_link_id":
            return Long.toString(_departmentLevel1LinkId);
         case "department_level1_label":
            return _departmentLevel1Label;
         case "department_level2_id":
            return Long.toString(_departmentLevel2Id);
         case "department_level2_link_id":
            return Long.toString(_departmentLevel2LinkId);
         case "department_level2_label":
            return _departmentLevel2Label;
         case "department_level3_id":
            return Long.toString(_departmentLevel3Id);
         case "department_level3_link_id":
            return Long.toString(_departmentLevel3LinkId);
         case "department_level3_label":
            return _departmentLevel3Label;
         case "department_level4_id":
            return Long.toString(_departmentLevel4Id);
         case "department_level4_link_id":
            return Long.toString(_departmentLevel4LinkId);
         case "department_level4_label":
            return _departmentLevel4Label;
         case "department_level5_id":
            return Long.toString(_departmentLevel5Id);
         case "department_level5_link_id":
            return Long.toString(_departmentLevel5LinkId);
         case "department_level5_label":
            return _departmentLevel5Label;
         case "department_level6_id":
            return Long.toString(_departmentLevel6Id);
         case "department_level6_link_id":
            return Long.toString(_departmentLevel6LinkId);
         case "department_level6_label":
            return _departmentLevel6Label;
         case "department_level7_id":
            return Long.toString(_departmentLevel7Id);
         case "department_level7_link_id":
            return Long.toString(_departmentLevel7LinkId);
         case "department_level7_label":
            return _departmentLevel7Label;
         case "marketer_id":
            return Long.toString(_marketerId);
         case "marketer_link_id":
            return Long.toString(_marketerLinkId);
         case "marketer_label":
            return _marketerLabel;
         case "customer_id":
            return Long.toString(_customerId);
         case "customer_link_id":
            return Long.toString(_customerLinkId);
         case "customer_label":
            return _customerLabel;
         case "customer_card":
            return _customerCard;
         case "customer_area":
            return _customerArea;
         case "customer_birth":
            return _customerBirth;
         case "customer_gender":
            return RInteger.toString(_customerGender);
         case "customer_phone":
            return _customerPhone;
         case "customer_action_date":
            return _customerActionDate.toString();
         case "investment":
            return RDouble.toString(_investment);
         case "investment_total":
            return RDouble.toString(_investmentTotal);
         case "redemption":
            return RDouble.toString(_redemption);
         case "redemption_total":
            return RDouble.toString(_redemptionTotal);
         case "netinvestment":
            return RDouble.toString(_netinvestment);
         case "netinvestment_total":
            return RDouble.toString(_netinvestmentTotal);
         case "interest":
            return RDouble.toString(_interest);
         case "interest_total":
            return RDouble.toString(_interestTotal);
         case "performance":
            return RDouble.toString(_performance);
         case "performance_total":
            return RDouble.toString(_performanceTotal);
         case "tender_changed":
            return RInteger.toString(_tenderChanged);
         case "tender_prior_id":
            return Long.toString(_tenderPriorId);
         case "tender_prior_model":
            return _tenderPriorModel;
         case "tender_id":
            return Long.toString(_tenderId);
         case "tender_model":
            return _tenderModel;
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
         case "department_id":
            _departmentId = RLong.parse(value);
            break;
         case "department_link_id":
            _departmentLinkId = RLong.parse(value);
            break;
         case "department_label":
            _departmentLabel = value;
            break;
         case "department_level1_id":
            _departmentLevel1Id = RLong.parse(value);
            break;
         case "department_level1_link_id":
            _departmentLevel1LinkId = RLong.parse(value);
            break;
         case "department_level1_label":
            _departmentLevel1Label = value;
            break;
         case "department_level2_id":
            _departmentLevel2Id = RLong.parse(value);
            break;
         case "department_level2_link_id":
            _departmentLevel2LinkId = RLong.parse(value);
            break;
         case "department_level2_label":
            _departmentLevel2Label = value;
            break;
         case "department_level3_id":
            _departmentLevel3Id = RLong.parse(value);
            break;
         case "department_level3_link_id":
            _departmentLevel3LinkId = RLong.parse(value);
            break;
         case "department_level3_label":
            _departmentLevel3Label = value;
            break;
         case "department_level4_id":
            _departmentLevel4Id = RLong.parse(value);
            break;
         case "department_level4_link_id":
            _departmentLevel4LinkId = RLong.parse(value);
            break;
         case "department_level4_label":
            _departmentLevel4Label = value;
            break;
         case "department_level5_id":
            _departmentLevel5Id = RLong.parse(value);
            break;
         case "department_level5_link_id":
            _departmentLevel5LinkId = RLong.parse(value);
            break;
         case "department_level5_label":
            _departmentLevel5Label = value;
            break;
         case "department_level6_id":
            _departmentLevel6Id = RLong.parse(value);
            break;
         case "department_level6_link_id":
            _departmentLevel6LinkId = RLong.parse(value);
            break;
         case "department_level6_label":
            _departmentLevel6Label = value;
            break;
         case "department_level7_id":
            _departmentLevel7Id = RLong.parse(value);
            break;
         case "department_level7_link_id":
            _departmentLevel7LinkId = RLong.parse(value);
            break;
         case "department_level7_label":
            _departmentLevel7Label = value;
            break;
         case "marketer_id":
            _marketerId = RLong.parse(value);
            break;
         case "marketer_link_id":
            _marketerLinkId = RLong.parse(value);
            break;
         case "marketer_label":
            _marketerLabel = value;
            break;
         case "customer_id":
            _customerId = RLong.parse(value);
            break;
         case "customer_link_id":
            _customerLinkId = RLong.parse(value);
            break;
         case "customer_label":
            _customerLabel = value;
            break;
         case "customer_card":
            _customerCard = value;
            break;
         case "customer_area":
            _customerArea = value;
            break;
         case "customer_birth":
            _customerBirth = value;
            break;
         case "customer_gender":
            _customerGender = RInteger.parse(value);
            break;
         case "customer_phone":
            _customerPhone = value;
            break;
         case "customer_action_date":
            _customerActionDate.parse(value);
            break;
         case "investment":
            _investment = RDouble.parse(value);
            break;
         case "investment_total":
            _investmentTotal = RDouble.parse(value);
            break;
         case "redemption":
            _redemption = RDouble.parse(value);
            break;
         case "redemption_total":
            _redemptionTotal = RDouble.parse(value);
            break;
         case "netinvestment":
            _netinvestment = RDouble.parse(value);
            break;
         case "netinvestment_total":
            _netinvestmentTotal = RDouble.parse(value);
            break;
         case "interest":
            _interest = RDouble.parse(value);
            break;
         case "interest_total":
            _interestTotal = RDouble.parse(value);
            break;
         case "performance":
            _performance = RDouble.parse(value);
            break;
         case "performance_total":
            _performanceTotal = RDouble.parse(value);
            break;
         case "tender_changed":
            _tenderChanged = RInteger.parse(value);
            break;
         case "tender_prior_id":
            _tenderPriorId = RLong.parse(value);
            break;
         case "tender_prior_model":
            _tenderPriorModel = value;
            break;
         case "tender_id":
            _tenderId = RLong.parse(value);
            break;
         case "tender_model":
            _tenderModel = value;
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
            case "department_id":
               __departmentId = RLong.parse(value);
               _departmentId = __departmentId;
               break;
            case "department_link_id":
               __departmentLinkId = RLong.parse(value);
               _departmentLinkId = __departmentLinkId;
               break;
            case "department_label":
               __departmentLabel = value;
               _departmentLabel = __departmentLabel;
               break;
            case "department_level1_id":
               __departmentLevel1Id = RLong.parse(value);
               _departmentLevel1Id = __departmentLevel1Id;
               break;
            case "department_level1_link_id":
               __departmentLevel1LinkId = RLong.parse(value);
               _departmentLevel1LinkId = __departmentLevel1LinkId;
               break;
            case "department_level1_label":
               __departmentLevel1Label = value;
               _departmentLevel1Label = __departmentLevel1Label;
               break;
            case "department_level2_id":
               __departmentLevel2Id = RLong.parse(value);
               _departmentLevel2Id = __departmentLevel2Id;
               break;
            case "department_level2_link_id":
               __departmentLevel2LinkId = RLong.parse(value);
               _departmentLevel2LinkId = __departmentLevel2LinkId;
               break;
            case "department_level2_label":
               __departmentLevel2Label = value;
               _departmentLevel2Label = __departmentLevel2Label;
               break;
            case "department_level3_id":
               __departmentLevel3Id = RLong.parse(value);
               _departmentLevel3Id = __departmentLevel3Id;
               break;
            case "department_level3_link_id":
               __departmentLevel3LinkId = RLong.parse(value);
               _departmentLevel3LinkId = __departmentLevel3LinkId;
               break;
            case "department_level3_label":
               __departmentLevel3Label = value;
               _departmentLevel3Label = __departmentLevel3Label;
               break;
            case "department_level4_id":
               __departmentLevel4Id = RLong.parse(value);
               _departmentLevel4Id = __departmentLevel4Id;
               break;
            case "department_level4_link_id":
               __departmentLevel4LinkId = RLong.parse(value);
               _departmentLevel4LinkId = __departmentLevel4LinkId;
               break;
            case "department_level4_label":
               __departmentLevel4Label = value;
               _departmentLevel4Label = __departmentLevel4Label;
               break;
            case "department_level5_id":
               __departmentLevel5Id = RLong.parse(value);
               _departmentLevel5Id = __departmentLevel5Id;
               break;
            case "department_level5_link_id":
               __departmentLevel5LinkId = RLong.parse(value);
               _departmentLevel5LinkId = __departmentLevel5LinkId;
               break;
            case "department_level5_label":
               __departmentLevel5Label = value;
               _departmentLevel5Label = __departmentLevel5Label;
               break;
            case "department_level6_id":
               __departmentLevel6Id = RLong.parse(value);
               _departmentLevel6Id = __departmentLevel6Id;
               break;
            case "department_level6_link_id":
               __departmentLevel6LinkId = RLong.parse(value);
               _departmentLevel6LinkId = __departmentLevel6LinkId;
               break;
            case "department_level6_label":
               __departmentLevel6Label = value;
               _departmentLevel6Label = __departmentLevel6Label;
               break;
            case "department_level7_id":
               __departmentLevel7Id = RLong.parse(value);
               _departmentLevel7Id = __departmentLevel7Id;
               break;
            case "department_level7_link_id":
               __departmentLevel7LinkId = RLong.parse(value);
               _departmentLevel7LinkId = __departmentLevel7LinkId;
               break;
            case "department_level7_label":
               __departmentLevel7Label = value;
               _departmentLevel7Label = __departmentLevel7Label;
               break;
            case "marketer_id":
               __marketerId = RLong.parse(value);
               _marketerId = __marketerId;
               break;
            case "marketer_link_id":
               __marketerLinkId = RLong.parse(value);
               _marketerLinkId = __marketerLinkId;
               break;
            case "marketer_label":
               __marketerLabel = value;
               _marketerLabel = __marketerLabel;
               break;
            case "customer_id":
               __customerId = RLong.parse(value);
               _customerId = __customerId;
               break;
            case "customer_link_id":
               __customerLinkId = RLong.parse(value);
               _customerLinkId = __customerLinkId;
               break;
            case "customer_label":
               __customerLabel = value;
               _customerLabel = __customerLabel;
               break;
            case "customer_card":
               __customerCard = value;
               _customerCard = __customerCard;
               break;
            case "customer_area":
               __customerArea = value;
               _customerArea = __customerArea;
               break;
            case "customer_birth":
               __customerBirth = value;
               _customerBirth = __customerBirth;
               break;
            case "customer_gender":
               __customerGender = RInteger.parse(value);
               _customerGender = __customerGender;
               break;
            case "customer_phone":
               __customerPhone = value;
               _customerPhone = __customerPhone;
               break;
            case "customer_action_date":
               __customerActionDate.parse(value);
               _customerActionDate.assign(__customerActionDate);
               break;
            case "investment":
               __investment = RDouble.parse(value);
               _investment = __investment;
               break;
            case "investment_total":
               __investmentTotal = RDouble.parse(value);
               _investmentTotal = __investmentTotal;
               break;
            case "redemption":
               __redemption = RDouble.parse(value);
               _redemption = __redemption;
               break;
            case "redemption_total":
               __redemptionTotal = RDouble.parse(value);
               _redemptionTotal = __redemptionTotal;
               break;
            case "netinvestment":
               __netinvestment = RDouble.parse(value);
               _netinvestment = __netinvestment;
               break;
            case "netinvestment_total":
               __netinvestmentTotal = RDouble.parse(value);
               _netinvestmentTotal = __netinvestmentTotal;
               break;
            case "interest":
               __interest = RDouble.parse(value);
               _interest = __interest;
               break;
            case "interest_total":
               __interestTotal = RDouble.parse(value);
               _interestTotal = __interestTotal;
               break;
            case "performance":
               __performance = RDouble.parse(value);
               _performance = __performance;
               break;
            case "performance_total":
               __performanceTotal = RDouble.parse(value);
               _performanceTotal = __performanceTotal;
               break;
            case "tender_changed":
               __tenderChanged = RInteger.parse(value);
               _tenderChanged = __tenderChanged;
               break;
            case "tender_prior_id":
               __tenderPriorId = RLong.parse(value);
               _tenderPriorId = __tenderPriorId;
               break;
            case "tender_prior_model":
               __tenderPriorModel = value;
               _tenderPriorModel = __tenderPriorModel;
               break;
            case "tender_id":
               __tenderId = RLong.parse(value);
               _tenderId = __tenderId;
               break;
            case "tender_model":
               __tenderModel = value;
               _tenderModel = __tenderModel;
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
      row.set("departmentId", _departmentId);
      row.set("departmentLinkId", _departmentLinkId);
      row.set("departmentLabel", _departmentLabel);
      row.set("departmentLevel1Id", _departmentLevel1Id);
      row.set("departmentLevel1LinkId", _departmentLevel1LinkId);
      row.set("departmentLevel1Label", _departmentLevel1Label);
      row.set("departmentLevel2Id", _departmentLevel2Id);
      row.set("departmentLevel2LinkId", _departmentLevel2LinkId);
      row.set("departmentLevel2Label", _departmentLevel2Label);
      row.set("departmentLevel3Id", _departmentLevel3Id);
      row.set("departmentLevel3LinkId", _departmentLevel3LinkId);
      row.set("departmentLevel3Label", _departmentLevel3Label);
      row.set("departmentLevel4Id", _departmentLevel4Id);
      row.set("departmentLevel4LinkId", _departmentLevel4LinkId);
      row.set("departmentLevel4Label", _departmentLevel4Label);
      row.set("departmentLevel5Id", _departmentLevel5Id);
      row.set("departmentLevel5LinkId", _departmentLevel5LinkId);
      row.set("departmentLevel5Label", _departmentLevel5Label);
      row.set("departmentLevel6Id", _departmentLevel6Id);
      row.set("departmentLevel6LinkId", _departmentLevel6LinkId);
      row.set("departmentLevel6Label", _departmentLevel6Label);
      row.set("departmentLevel7Id", _departmentLevel7Id);
      row.set("departmentLevel7LinkId", _departmentLevel7LinkId);
      row.set("departmentLevel7Label", _departmentLevel7Label);
      row.set("marketerId", _marketerId);
      row.set("marketerLinkId", _marketerLinkId);
      row.set("marketerLabel", _marketerLabel);
      row.set("customerId", _customerId);
      row.set("customerLinkId", _customerLinkId);
      row.set("customerLabel", _customerLabel);
      row.set("customerCard", _customerCard);
      row.set("customerArea", _customerArea);
      row.set("customerBirth", _customerBirth);
      row.set("customerGender", _customerGender);
      row.set("customerPhone", _customerPhone);
      row.set("customerActionDate", _customerActionDate);
      row.set("investment", _investment);
      row.set("investmentTotal", _investmentTotal);
      row.set("redemption", _redemption);
      row.set("redemptionTotal", _redemptionTotal);
      row.set("netinvestment", _netinvestment);
      row.set("netinvestmentTotal", _netinvestmentTotal);
      row.set("interest", _interest);
      row.set("interestTotal", _interestTotal);
      row.set("performance", _performance);
      row.set("performanceTotal", _performanceTotal);
      row.set("tenderChanged", _tenderChanged);
      row.set("tenderPriorId", _tenderPriorId);
      row.set("tenderPriorModel", _tenderPriorModel);
      row.set("tenderId", _tenderId);
      row.set("tenderModel", _tenderModel);
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
      map.put("departmentId", RLong.toString(_departmentId));
      map.put("departmentLinkId", RLong.toString(_departmentLinkId));
      map.put("departmentLabel", _departmentLabel);
      map.put("departmentLevel1Id", RLong.toString(_departmentLevel1Id));
      map.put("departmentLevel1LinkId", RLong.toString(_departmentLevel1LinkId));
      map.put("departmentLevel1Label", _departmentLevel1Label);
      map.put("departmentLevel2Id", RLong.toString(_departmentLevel2Id));
      map.put("departmentLevel2LinkId", RLong.toString(_departmentLevel2LinkId));
      map.put("departmentLevel2Label", _departmentLevel2Label);
      map.put("departmentLevel3Id", RLong.toString(_departmentLevel3Id));
      map.put("departmentLevel3LinkId", RLong.toString(_departmentLevel3LinkId));
      map.put("departmentLevel3Label", _departmentLevel3Label);
      map.put("departmentLevel4Id", RLong.toString(_departmentLevel4Id));
      map.put("departmentLevel4LinkId", RLong.toString(_departmentLevel4LinkId));
      map.put("departmentLevel4Label", _departmentLevel4Label);
      map.put("departmentLevel5Id", RLong.toString(_departmentLevel5Id));
      map.put("departmentLevel5LinkId", RLong.toString(_departmentLevel5LinkId));
      map.put("departmentLevel5Label", _departmentLevel5Label);
      map.put("departmentLevel6Id", RLong.toString(_departmentLevel6Id));
      map.put("departmentLevel6LinkId", RLong.toString(_departmentLevel6LinkId));
      map.put("departmentLevel6Label", _departmentLevel6Label);
      map.put("departmentLevel7Id", RLong.toString(_departmentLevel7Id));
      map.put("departmentLevel7LinkId", RLong.toString(_departmentLevel7LinkId));
      map.put("departmentLevel7Label", _departmentLevel7Label);
      map.put("marketerId", RLong.toString(_marketerId));
      map.put("marketerLinkId", RLong.toString(_marketerLinkId));
      map.put("marketerLabel", _marketerLabel);
      map.put("customerId", RLong.toString(_customerId));
      map.put("customerLinkId", RLong.toString(_customerLinkId));
      map.put("customerLabel", _customerLabel);
      map.put("customerCard", _customerCard);
      map.put("customerArea", _customerArea);
      map.put("customerBirth", _customerBirth);
      map.put("customerGender", RInteger.toString(_customerGender));
      map.put("customerPhone", _customerPhone);
      map.put("customerActionDate", _customerActionDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("investment", RDouble.toString(_investment));
      map.put("investmentTotal", RDouble.toString(_investmentTotal));
      map.put("redemption", RDouble.toString(_redemption));
      map.put("redemptionTotal", RDouble.toString(_redemptionTotal));
      map.put("netinvestment", RDouble.toString(_netinvestment));
      map.put("netinvestmentTotal", RDouble.toString(_netinvestmentTotal));
      map.put("interest", RDouble.toString(_interest));
      map.put("interestTotal", RDouble.toString(_interestTotal));
      map.put("performance", RDouble.toString(_performance));
      map.put("performanceTotal", RDouble.toString(_performanceTotal));
      map.put("tenderChanged", RInteger.toString(_tenderChanged));
      map.put("tenderPriorId", RLong.toString(_tenderPriorId));
      map.put("tenderPriorModel", _tenderPriorModel);
      map.put("tenderId", RLong.toString(_tenderId));
      map.put("tenderModel", _tenderModel);
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
      _recordYear.set(input.readInt64());
      _recordMonth.set(input.readInt64());
      _recordWeek.set(input.readInt64());
      _recordDay.set(input.readInt64());
      _recordHour.set(input.readInt64());
      _recordDate.set(input.readInt64());
      _departmentId = input.readInt64();
      _departmentLinkId = input.readInt64();
      _departmentLabel = input.readString();
      _departmentLevel1Id = input.readInt64();
      _departmentLevel1LinkId = input.readInt64();
      _departmentLevel1Label = input.readString();
      _departmentLevel2Id = input.readInt64();
      _departmentLevel2LinkId = input.readInt64();
      _departmentLevel2Label = input.readString();
      _departmentLevel3Id = input.readInt64();
      _departmentLevel3LinkId = input.readInt64();
      _departmentLevel3Label = input.readString();
      _departmentLevel4Id = input.readInt64();
      _departmentLevel4LinkId = input.readInt64();
      _departmentLevel4Label = input.readString();
      _departmentLevel5Id = input.readInt64();
      _departmentLevel5LinkId = input.readInt64();
      _departmentLevel5Label = input.readString();
      _departmentLevel6Id = input.readInt64();
      _departmentLevel6LinkId = input.readInt64();
      _departmentLevel6Label = input.readString();
      _departmentLevel7Id = input.readInt64();
      _departmentLevel7LinkId = input.readInt64();
      _departmentLevel7Label = input.readString();
      _marketerId = input.readInt64();
      _marketerLinkId = input.readInt64();
      _marketerLabel = input.readString();
      _customerId = input.readInt64();
      _customerLinkId = input.readInt64();
      _customerLabel = input.readString();
      _customerCard = input.readString();
      _customerArea = input.readString();
      _customerBirth = input.readString();
      _customerGender = input.readInt32();
      _customerPhone = input.readString();
      _customerActionDate.set(input.readInt64());
      _tenderChanged = input.readInt32();
      _tenderPriorId = input.readInt64();
      _tenderPriorModel = input.readString();
      _tenderId = input.readInt64();
      _tenderModel = input.readString();
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
      output.writeInt64(_recordYear.get());
      output.writeInt64(_recordMonth.get());
      output.writeInt64(_recordWeek.get());
      output.writeInt64(_recordDay.get());
      output.writeInt64(_recordHour.get());
      output.writeInt64(_recordDate.get());
      output.writeInt64(_departmentId);
      output.writeInt64(_departmentLinkId);
      output.writeString(_departmentLabel);
      output.writeInt64(_departmentLevel1Id);
      output.writeInt64(_departmentLevel1LinkId);
      output.writeString(_departmentLevel1Label);
      output.writeInt64(_departmentLevel2Id);
      output.writeInt64(_departmentLevel2LinkId);
      output.writeString(_departmentLevel2Label);
      output.writeInt64(_departmentLevel3Id);
      output.writeInt64(_departmentLevel3LinkId);
      output.writeString(_departmentLevel3Label);
      output.writeInt64(_departmentLevel4Id);
      output.writeInt64(_departmentLevel4LinkId);
      output.writeString(_departmentLevel4Label);
      output.writeInt64(_departmentLevel5Id);
      output.writeInt64(_departmentLevel5LinkId);
      output.writeString(_departmentLevel5Label);
      output.writeInt64(_departmentLevel6Id);
      output.writeInt64(_departmentLevel6LinkId);
      output.writeString(_departmentLevel6Label);
      output.writeInt64(_departmentLevel7Id);
      output.writeInt64(_departmentLevel7LinkId);
      output.writeString(_departmentLevel7Label);
      output.writeInt64(_marketerId);
      output.writeInt64(_marketerLinkId);
      output.writeString(_marketerLabel);
      output.writeInt64(_customerId);
      output.writeInt64(_customerLinkId);
      output.writeString(_customerLabel);
      output.writeString(_customerCard);
      output.writeString(_customerArea);
      output.writeString(_customerBirth);
      output.writeInt32(_customerGender);
      output.writeString(_customerPhone);
      output.writeInt64(_customerActionDate.get());
      output.writeInt32(_tenderChanged);
      output.writeInt64(_tenderPriorId);
      output.writeString(_tenderPriorModel);
      output.writeInt64(_tenderId);
      output.writeString(_tenderModel);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }

   //============================================================
   // <T>复制当前对象。</T>
   //
   // @param unit 对象
   // @return 对象
   //============================================================
   @Override
   public void copy(FLogicUnit logicUnit){
      super.copy(logicUnit);
      FStatisticsFinancialCustomerPhaseUnit unit = (FStatisticsFinancialCustomerPhaseUnit)logicUnit;
      unit.setOuid(_ouid);
      unit.setOvld(_ovld);
      unit.setGuid(_guid);
      unit.recordYear().assign(_recordYear);
      unit.recordMonth().assign(_recordMonth);
      unit.recordWeek().assign(_recordWeek);
      unit.recordDay().assign(_recordDay);
      unit.recordHour().assign(_recordHour);
      unit.recordDate().assign(_recordDate);
      unit.setDepartmentId(_departmentId);
      unit.setDepartmentLinkId(_departmentLinkId);
      unit.setDepartmentLabel(_departmentLabel);
      unit.setDepartmentLevel1Id(_departmentLevel1Id);
      unit.setDepartmentLevel1LinkId(_departmentLevel1LinkId);
      unit.setDepartmentLevel1Label(_departmentLevel1Label);
      unit.setDepartmentLevel2Id(_departmentLevel2Id);
      unit.setDepartmentLevel2LinkId(_departmentLevel2LinkId);
      unit.setDepartmentLevel2Label(_departmentLevel2Label);
      unit.setDepartmentLevel3Id(_departmentLevel3Id);
      unit.setDepartmentLevel3LinkId(_departmentLevel3LinkId);
      unit.setDepartmentLevel3Label(_departmentLevel3Label);
      unit.setDepartmentLevel4Id(_departmentLevel4Id);
      unit.setDepartmentLevel4LinkId(_departmentLevel4LinkId);
      unit.setDepartmentLevel4Label(_departmentLevel4Label);
      unit.setDepartmentLevel5Id(_departmentLevel5Id);
      unit.setDepartmentLevel5LinkId(_departmentLevel5LinkId);
      unit.setDepartmentLevel5Label(_departmentLevel5Label);
      unit.setDepartmentLevel6Id(_departmentLevel6Id);
      unit.setDepartmentLevel6LinkId(_departmentLevel6LinkId);
      unit.setDepartmentLevel6Label(_departmentLevel6Label);
      unit.setDepartmentLevel7Id(_departmentLevel7Id);
      unit.setDepartmentLevel7LinkId(_departmentLevel7LinkId);
      unit.setDepartmentLevel7Label(_departmentLevel7Label);
      unit.setMarketerId(_marketerId);
      unit.setMarketerLinkId(_marketerLinkId);
      unit.setMarketerLabel(_marketerLabel);
      unit.setCustomerId(_customerId);
      unit.setCustomerLinkId(_customerLinkId);
      unit.setCustomerLabel(_customerLabel);
      unit.setCustomerCard(_customerCard);
      unit.setCustomerArea(_customerArea);
      unit.setCustomerBirth(_customerBirth);
      unit.setCustomerGender(_customerGender);
      unit.setCustomerPhone(_customerPhone);
      unit.customerActionDate().assign(_customerActionDate);
      unit.setInvestment(_investment);
      unit.setInvestmentTotal(_investmentTotal);
      unit.setRedemption(_redemption);
      unit.setRedemptionTotal(_redemptionTotal);
      unit.setNetinvestment(_netinvestment);
      unit.setNetinvestmentTotal(_netinvestmentTotal);
      unit.setInterest(_interest);
      unit.setInterestTotal(_interestTotal);
      unit.setPerformance(_performance);
      unit.setPerformanceTotal(_performanceTotal);
      unit.setTenderChanged(_tenderChanged);
      unit.setTenderPriorId(_tenderPriorId);
      unit.setTenderPriorModel(_tenderPriorModel);
      unit.setTenderId(_tenderId);
      unit.setTenderModel(_tenderModel);
      unit.setCreateUserId(_createUserId);
      unit.createDate().assign(_createDate);
      unit.setUpdateUserId(_updateUserId);
      unit.updateDate().assign(_updateDate);
   }

   //============================================================
   // <T>克隆当前对象。</T>
   //
   // @return 对象
   //============================================================
   @Override
   public FStatisticsFinancialCustomerPhaseUnit clone(){
      FStatisticsFinancialCustomerPhaseUnit unit = RClass.newInstance(FStatisticsFinancialCustomerPhaseUnit.class);
      copy(unit);
      return unit;
   }
}
