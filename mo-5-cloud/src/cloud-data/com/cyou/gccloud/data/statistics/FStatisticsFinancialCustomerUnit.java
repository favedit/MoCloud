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
// <T>客户统计表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FStatisticsFinancialCustomerUnit
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

   // 存储字段标签的定义。
   private String __label;

   // 字段标签的定义。
   protected String _label;

   // 存储字段身份证号的定义。
   private String __card;

   // 字段身份证号的定义。
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

   // 存储字段电话号码的定义。
   private String __phone;

   // 字段电话号码的定义。
   protected String _phone;

   // 存储字段电话城市编号的定义。
   private long __phoneCityId;

   // 字段电话城市编号的定义。
   protected long _phoneCityId;

   // 存储字段电话城市代码的定义。
   private String __phoneCityCode;

   // 字段电话城市代码的定义。
   protected String _phoneCityCode;

   // 存储字段注册时间的定义。
   private TDateTime __registerDate = new TDateTime();

   // 字段注册时间的定义。
   protected TDateTime _registerDate = new TDateTime();

   // 存储字段首次投资时间的定义。
   private TDateTime __investmentFirstDate = new TDateTime();

   // 字段首次投资时间的定义。
   protected TDateTime _investmentFirstDate = new TDateTime();

   // 存储字段投资最后日期的定义。
   private TDateTime __investmentLastDate = new TDateTime();

   // 字段投资最后日期的定义。
   protected TDateTime _investmentLastDate = new TDateTime();

   // 存储字段投资次数的定义。
   private int __investmentNumber;

   // 字段投资次数的定义。
   protected int _investmentNumber;

   // 存储字段投资总计的定义。
   private double __investmentTotal;

   // 字段投资总计的定义。
   protected double _investmentTotal;

   // 存储字段首次赎回时间的定义。
   private TDateTime __redemptionFirstDate = new TDateTime();

   // 字段首次赎回时间的定义。
   protected TDateTime _redemptionFirstDate = new TDateTime();

   // 存储字段赎回最后时间的定义。
   private TDateTime __redemptionLastDate = new TDateTime();

   // 字段赎回最后时间的定义。
   protected TDateTime _redemptionLastDate = new TDateTime();

   // 存储字段赎回次数的定义。
   private int __redemptionNumber;

   // 字段赎回次数的定义。
   protected int _redemptionNumber;

   // 存储字段赎回总计的定义。
   private double __redemptionTotal;

   // 字段赎回总计的定义。
   protected double _redemptionTotal;

   // 存储字段净投总计的定义。
   private double __netinvestmentTotal;

   // 字段净投总计的定义。
   protected double _netinvestmentTotal;

   // 存储字段利息总计的定义。
   private double __interestTotal;

   // 字段利息总计的定义。
   protected double _interestTotal;

   // 存储字段绩效总计的定义。
   private double __performanceTotal;

   // 字段绩效总计的定义。
   protected double _performanceTotal;

   // 存储字段投标编号的定义。
   private long __tenderId;

   // 字段投标编号的定义。
   protected long _tenderId;

   // 存储字段投标关联编号的定义。
   private long __tenderLinkId;

   // 字段投标关联编号的定义。
   protected long _tenderLinkId;

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
   // <T>构造客户统计表逻辑单元。</T>
   //============================================================
   public FStatisticsFinancialCustomerUnit(){
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
   // <T>判断首次投资时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInvestmentFirstDateChanged(){
      return !__investmentFirstDate.equals(_investmentFirstDate);
   }

   //============================================================
   // <T>获得首次投资时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime investmentFirstDate(){
      return _investmentFirstDate;
   }

   //============================================================
   // <T>设置首次投资时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInvestmentFirstDate(TDateTime value){
      _investmentFirstDate = value;
   }

   //============================================================
   // <T>判断投资最后日期的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInvestmentLastDateChanged(){
      return !__investmentLastDate.equals(_investmentLastDate);
   }

   //============================================================
   // <T>获得投资最后日期的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime investmentLastDate(){
      return _investmentLastDate;
   }

   //============================================================
   // <T>设置投资最后日期的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInvestmentLastDate(TDateTime value){
      _investmentLastDate = value;
   }

   //============================================================
   // <T>判断投资次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInvestmentNumberChanged(){
      return __investmentNumber != _investmentNumber;
   }

   //============================================================
   // <T>获得投资次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int investmentNumber(){
      return _investmentNumber;
   }

   //============================================================
   // <T>设置投资次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInvestmentNumber(int value){
      _investmentNumber = value;
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
   // <T>判断首次赎回时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRedemptionFirstDateChanged(){
      return !__redemptionFirstDate.equals(_redemptionFirstDate);
   }

   //============================================================
   // <T>获得首次赎回时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime redemptionFirstDate(){
      return _redemptionFirstDate;
   }

   //============================================================
   // <T>设置首次赎回时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRedemptionFirstDate(TDateTime value){
      _redemptionFirstDate = value;
   }

   //============================================================
   // <T>判断赎回最后时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRedemptionLastDateChanged(){
      return !__redemptionLastDate.equals(_redemptionLastDate);
   }

   //============================================================
   // <T>获得赎回最后时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime redemptionLastDate(){
      return _redemptionLastDate;
   }

   //============================================================
   // <T>设置赎回最后时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRedemptionLastDate(TDateTime value){
      _redemptionLastDate = value;
   }

   //============================================================
   // <T>判断赎回次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRedemptionNumberChanged(){
      return __redemptionNumber != _redemptionNumber;
   }

   //============================================================
   // <T>获得赎回次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int redemptionNumber(){
      return _redemptionNumber;
   }

   //============================================================
   // <T>设置赎回次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRedemptionNumber(int value){
      _redemptionNumber = value;
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
   // <T>判断投标关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isTenderLinkIdChanged(){
      return __tenderLinkId != _tenderLinkId;
   }

   //============================================================
   // <T>获得投标关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long tenderLinkId(){
      return _tenderLinkId;
   }

   //============================================================
   // <T>设置投标关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setTenderLinkId(long value){
      _tenderLinkId = value;
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
         case "link_id":
            return Long.toString(_linkId);
         case "link_date":
            return _linkDate.toString();
         case "link_cd":
            return RInteger.toString(_linkCd);
         case "data_id":
            return Long.toString(_dataId);
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
         case "register_date":
            return _registerDate.toString();
         case "investment_first_date":
            return _investmentFirstDate.toString();
         case "investment_last_date":
            return _investmentLastDate.toString();
         case "investment_number":
            return RInteger.toString(_investmentNumber);
         case "investment_total":
            return RDouble.toString(_investmentTotal);
         case "redemption_first_date":
            return _redemptionFirstDate.toString();
         case "redemption_last_date":
            return _redemptionLastDate.toString();
         case "redemption_number":
            return RInteger.toString(_redemptionNumber);
         case "redemption_total":
            return RDouble.toString(_redemptionTotal);
         case "netinvestment_total":
            return RDouble.toString(_netinvestmentTotal);
         case "interest_total":
            return RDouble.toString(_interestTotal);
         case "performance_total":
            return RDouble.toString(_performanceTotal);
         case "tender_id":
            return Long.toString(_tenderId);
         case "tender_link_id":
            return Long.toString(_tenderLinkId);
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
         case "register_date":
            _registerDate.parse(value);
            break;
         case "investment_first_date":
            _investmentFirstDate.parse(value);
            break;
         case "investment_last_date":
            _investmentLastDate.parse(value);
            break;
         case "investment_number":
            _investmentNumber = RInteger.parse(value);
            break;
         case "investment_total":
            _investmentTotal = RDouble.parse(value);
            break;
         case "redemption_first_date":
            _redemptionFirstDate.parse(value);
            break;
         case "redemption_last_date":
            _redemptionLastDate.parse(value);
            break;
         case "redemption_number":
            _redemptionNumber = RInteger.parse(value);
            break;
         case "redemption_total":
            _redemptionTotal = RDouble.parse(value);
            break;
         case "netinvestment_total":
            _netinvestmentTotal = RDouble.parse(value);
            break;
         case "interest_total":
            _interestTotal = RDouble.parse(value);
            break;
         case "performance_total":
            _performanceTotal = RDouble.parse(value);
            break;
         case "tender_id":
            _tenderId = RLong.parse(value);
            break;
         case "tender_link_id":
            _tenderLinkId = RLong.parse(value);
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
            case "register_date":
               __registerDate.parse(value);
               _registerDate.assign(__registerDate);
               break;
            case "investment_first_date":
               __investmentFirstDate.parse(value);
               _investmentFirstDate.assign(__investmentFirstDate);
               break;
            case "investment_last_date":
               __investmentLastDate.parse(value);
               _investmentLastDate.assign(__investmentLastDate);
               break;
            case "investment_number":
               __investmentNumber = RInteger.parse(value);
               _investmentNumber = __investmentNumber;
               break;
            case "investment_total":
               __investmentTotal = RDouble.parse(value);
               _investmentTotal = __investmentTotal;
               break;
            case "redemption_first_date":
               __redemptionFirstDate.parse(value);
               _redemptionFirstDate.assign(__redemptionFirstDate);
               break;
            case "redemption_last_date":
               __redemptionLastDate.parse(value);
               _redemptionLastDate.assign(__redemptionLastDate);
               break;
            case "redemption_number":
               __redemptionNumber = RInteger.parse(value);
               _redemptionNumber = __redemptionNumber;
               break;
            case "redemption_total":
               __redemptionTotal = RDouble.parse(value);
               _redemptionTotal = __redemptionTotal;
               break;
            case "netinvestment_total":
               __netinvestmentTotal = RDouble.parse(value);
               _netinvestmentTotal = __netinvestmentTotal;
               break;
            case "interest_total":
               __interestTotal = RDouble.parse(value);
               _interestTotal = __interestTotal;
               break;
            case "performance_total":
               __performanceTotal = RDouble.parse(value);
               _performanceTotal = __performanceTotal;
               break;
            case "tender_id":
               __tenderId = RLong.parse(value);
               _tenderId = __tenderId;
               break;
            case "tender_link_id":
               __tenderLinkId = RLong.parse(value);
               _tenderLinkId = __tenderLinkId;
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
      row.set("linkId", _linkId);
      row.set("linkDate", _linkDate);
      row.set("linkCd", _linkCd);
      row.set("dataId", _dataId);
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
      row.set("label", _label);
      row.set("card", _card);
      row.set("cardArea", _cardArea);
      row.set("cardBirth", _cardBirth);
      row.set("cardGender", _cardGender);
      row.set("phone", _phone);
      row.set("phoneCityId", _phoneCityId);
      row.set("phoneCityCode", _phoneCityCode);
      row.set("registerDate", _registerDate);
      row.set("investmentFirstDate", _investmentFirstDate);
      row.set("investmentLastDate", _investmentLastDate);
      row.set("investmentNumber", _investmentNumber);
      row.set("investmentTotal", _investmentTotal);
      row.set("redemptionFirstDate", _redemptionFirstDate);
      row.set("redemptionLastDate", _redemptionLastDate);
      row.set("redemptionNumber", _redemptionNumber);
      row.set("redemptionTotal", _redemptionTotal);
      row.set("netinvestmentTotal", _netinvestmentTotal);
      row.set("interestTotal", _interestTotal);
      row.set("performanceTotal", _performanceTotal);
      row.set("tenderId", _tenderId);
      row.set("tenderLinkId", _tenderLinkId);
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
      map.put("linkId", RLong.toString(_linkId));
      map.put("linkDate", _linkDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("linkCd", RInteger.toString(_linkCd));
      map.put("dataId", RLong.toString(_dataId));
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
      map.put("label", _label);
      map.put("card", _card);
      map.put("cardArea", _cardArea);
      map.put("cardBirth", _cardBirth);
      map.put("cardGender", RInteger.toString(_cardGender));
      map.put("phone", _phone);
      map.put("phoneCityId", RLong.toString(_phoneCityId));
      map.put("phoneCityCode", _phoneCityCode);
      map.put("registerDate", _registerDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("investmentFirstDate", _investmentFirstDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("investmentLastDate", _investmentLastDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("investmentNumber", RInteger.toString(_investmentNumber));
      map.put("investmentTotal", RDouble.toString(_investmentTotal));
      map.put("redemptionFirstDate", _redemptionFirstDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("redemptionLastDate", _redemptionLastDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("redemptionNumber", RInteger.toString(_redemptionNumber));
      map.put("redemptionTotal", RDouble.toString(_redemptionTotal));
      map.put("netinvestmentTotal", RDouble.toString(_netinvestmentTotal));
      map.put("interestTotal", RDouble.toString(_interestTotal));
      map.put("performanceTotal", RDouble.toString(_performanceTotal));
      map.put("tenderId", RLong.toString(_tenderId));
      map.put("tenderLinkId", RLong.toString(_tenderLinkId));
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
      _linkId = input.readInt64();
      _linkDate.set(input.readInt64());
      _linkCd = input.readInt32();
      _dataId = input.readInt64();
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
      _label = input.readString();
      _card = input.readString();
      _cardArea = input.readString();
      _cardBirth = input.readString();
      _cardGender = input.readInt32();
      _phone = input.readString();
      _phoneCityId = input.readInt64();
      _phoneCityCode = input.readString();
      _registerDate.set(input.readInt64());
      _investmentFirstDate.set(input.readInt64());
      _investmentLastDate.set(input.readInt64());
      _investmentNumber = input.readInt32();
      _redemptionFirstDate.set(input.readInt64());
      _redemptionLastDate.set(input.readInt64());
      _redemptionNumber = input.readInt32();
      _tenderId = input.readInt64();
      _tenderLinkId = input.readInt64();
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
      output.writeInt64(_linkId);
      output.writeInt64(_linkDate.get());
      output.writeInt32(_linkCd);
      output.writeInt64(_dataId);
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
      output.writeString(_label);
      output.writeString(_card);
      output.writeString(_cardArea);
      output.writeString(_cardBirth);
      output.writeInt32(_cardGender);
      output.writeString(_phone);
      output.writeInt64(_phoneCityId);
      output.writeString(_phoneCityCode);
      output.writeInt64(_registerDate.get());
      output.writeInt64(_investmentFirstDate.get());
      output.writeInt64(_investmentLastDate.get());
      output.writeInt32(_investmentNumber);
      output.writeInt64(_redemptionFirstDate.get());
      output.writeInt64(_redemptionLastDate.get());
      output.writeInt32(_redemptionNumber);
      output.writeInt64(_tenderId);
      output.writeInt64(_tenderLinkId);
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
      FStatisticsFinancialCustomerUnit unit = (FStatisticsFinancialCustomerUnit)logicUnit;
      unit.setOuid(_ouid);
      unit.setOvld(_ovld);
      unit.setGuid(_guid);
      unit.setLinkId(_linkId);
      unit.linkDate().assign(_linkDate);
      unit.setLinkCd(_linkCd);
      unit.setDataId(_dataId);
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
      unit.setLabel(_label);
      unit.setCard(_card);
      unit.setCardArea(_cardArea);
      unit.setCardBirth(_cardBirth);
      unit.setCardGender(_cardGender);
      unit.setPhone(_phone);
      unit.setPhoneCityId(_phoneCityId);
      unit.setPhoneCityCode(_phoneCityCode);
      unit.registerDate().assign(_registerDate);
      unit.investmentFirstDate().assign(_investmentFirstDate);
      unit.investmentLastDate().assign(_investmentLastDate);
      unit.setInvestmentNumber(_investmentNumber);
      unit.setInvestmentTotal(_investmentTotal);
      unit.redemptionFirstDate().assign(_redemptionFirstDate);
      unit.redemptionLastDate().assign(_redemptionLastDate);
      unit.setRedemptionNumber(_redemptionNumber);
      unit.setRedemptionTotal(_redemptionTotal);
      unit.setNetinvestmentTotal(_netinvestmentTotal);
      unit.setInterestTotal(_interestTotal);
      unit.setPerformanceTotal(_performanceTotal);
      unit.setTenderId(_tenderId);
      unit.setTenderLinkId(_tenderLinkId);
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
   public FStatisticsFinancialCustomerUnit clone(){
      FStatisticsFinancialCustomerUnit unit = RClass.newInstance(FStatisticsFinancialCustomerUnit.class);
      copy(unit);
      return unit;
   }
}
