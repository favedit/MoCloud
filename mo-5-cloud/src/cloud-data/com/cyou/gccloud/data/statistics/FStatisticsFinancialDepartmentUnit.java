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
// <T>部门统计表逻辑单元。</T>
//============================================================
@ASourceMachine
public class FStatisticsFinancialDepartmentUnit
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

   // 存储字段关联父编号的定义。
   private long __linkParentId;

   // 字段关联父编号的定义。
   protected long _linkParentId;

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

   // 存储字段父编号的定义。
   private long __parentId;

   // 字段父编号的定义。
   protected long _parentId;

   // 存储字段代码的定义。
   private String __code;

   // 字段代码的定义。
   protected String _code;

   // 存储字段标签的定义。
   private String __label;

   // 字段标签的定义。
   protected String _label;

   // 存储字段当前级别的定义。
   private int __level;

   // 字段当前级别的定义。
   protected int _level;

   // 存储字段级别1编号的定义。
   private long __level1Id;

   // 字段级别1编号的定义。
   protected long _level1Id;

   // 存储字段级别1关联编号的定义。
   private long __level1LinkId;

   // 字段级别1关联编号的定义。
   protected long _level1LinkId;

   // 存储字段级别1标签的定义。
   private String __level1Label;

   // 字段级别1标签的定义。
   protected String _level1Label;

   // 存储字段级别2编号的定义。
   private long __level2Id;

   // 字段级别2编号的定义。
   protected long _level2Id;

   // 存储字段级别2关联编号的定义。
   private long __level2LinkId;

   // 字段级别2关联编号的定义。
   protected long _level2LinkId;

   // 存储字段级别2标签的定义。
   private String __level2Label;

   // 字段级别2标签的定义。
   protected String _level2Label;

   // 存储字段级别3编号的定义。
   private long __level3Id;

   // 字段级别3编号的定义。
   protected long _level3Id;

   // 存储字段级别3关联编号的定义。
   private long __level3LinkId;

   // 字段级别3关联编号的定义。
   protected long _level3LinkId;

   // 存储字段级别3标签的定义。
   private String __level3Label;

   // 字段级别3标签的定义。
   protected String _level3Label;

   // 存储字段级别4编号的定义。
   private long __level4Id;

   // 字段级别4编号的定义。
   protected long _level4Id;

   // 存储字段级别4关联编号的定义。
   private long __level4LinkId;

   // 字段级别4关联编号的定义。
   protected long _level4LinkId;

   // 存储字段级别4标签的定义。
   private String __level4Label;

   // 字段级别4标签的定义。
   protected String _level4Label;

   // 存储字段级别5编号的定义。
   private long __level5Id;

   // 字段级别5编号的定义。
   protected long _level5Id;

   // 存储字段级别5关联编号的定义。
   private long __level5LinkId;

   // 字段级别5关联编号的定义。
   protected long _level5LinkId;

   // 存储字段级别5标签的定义。
   private String __level5Label;

   // 字段级别5标签的定义。
   protected String _level5Label;

   // 存储字段级别6编号的定义。
   private long __level6Id;

   // 字段级别6编号的定义。
   protected long _level6Id;

   // 存储字段级别6关联编号的定义。
   private long __level6LinkId;

   // 字段级别6关联编号的定义。
   protected long _level6LinkId;

   // 存储字段级别6标签的定义。
   private String __level6Label;

   // 字段级别6标签的定义。
   protected String _level6Label;

   // 存储字段级别7编号的定义。
   private long __level7Id;

   // 字段级别7编号的定义。
   protected long _level7Id;

   // 存储字段级别7关联编号的定义。
   private long __level7LinkId;

   // 字段级别7关联编号的定义。
   protected long _level7LinkId;

   // 存储字段级别7标签的定义。
   private String __level7Label;

   // 字段级别7标签的定义。
   protected String _level7Label;

   // 存储字段投资总计的定义。
   private double __investmentTotal;

   // 字段投资总计的定义。
   protected double _investmentTotal;

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

   // 存储字段理财师总计的定义。
   private int __marketerTotal;

   // 字段理财师总计的定义。
   protected int _marketerTotal;

   // 存储字段客户总计的定义。
   private int __customerTotal;

   // 字段客户总计的定义。
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
   // <T>构造部门统计表逻辑单元。</T>
   //============================================================
   public FStatisticsFinancialDepartmentUnit(){
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
   // <T>判断关联父编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLinkParentIdChanged(){
      return __linkParentId != _linkParentId;
   }

   //============================================================
   // <T>获得关联父编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long linkParentId(){
      return _linkParentId;
   }

   //============================================================
   // <T>设置关联父编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLinkParentId(long value){
      _linkParentId = value;
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
   // <T>判断父编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isParentIdChanged(){
      return __parentId != _parentId;
   }

   //============================================================
   // <T>获得父编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long parentId(){
      return _parentId;
   }

   //============================================================
   // <T>设置父编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setParentId(long value){
      _parentId = value;
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
   // <T>判断当前级别的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevelChanged(){
      return __level != _level;
   }

   //============================================================
   // <T>获得当前级别的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int level(){
      return _level;
   }

   //============================================================
   // <T>设置当前级别的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel(int value){
      _level = value;
   }

   //============================================================
   // <T>判断级别1编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel1IdChanged(){
      return __level1Id != _level1Id;
   }

   //============================================================
   // <T>获得级别1编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long level1Id(){
      return _level1Id;
   }

   //============================================================
   // <T>设置级别1编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel1Id(long value){
      _level1Id = value;
   }

   //============================================================
   // <T>判断级别1关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel1LinkIdChanged(){
      return __level1LinkId != _level1LinkId;
   }

   //============================================================
   // <T>获得级别1关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long level1LinkId(){
      return _level1LinkId;
   }

   //============================================================
   // <T>设置级别1关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel1LinkId(long value){
      _level1LinkId = value;
   }

   //============================================================
   // <T>判断级别1标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel1LabelChanged(){
      return !RString.equals(__level1Label, _level1Label);
   }

   //============================================================
   // <T>获得级别1标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String level1Label(){
      return _level1Label;
   }

   //============================================================
   // <T>设置级别1标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel1Label(String value){
      _level1Label = value;
   }

   //============================================================
   // <T>判断级别2编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel2IdChanged(){
      return __level2Id != _level2Id;
   }

   //============================================================
   // <T>获得级别2编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long level2Id(){
      return _level2Id;
   }

   //============================================================
   // <T>设置级别2编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel2Id(long value){
      _level2Id = value;
   }

   //============================================================
   // <T>判断级别2关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel2LinkIdChanged(){
      return __level2LinkId != _level2LinkId;
   }

   //============================================================
   // <T>获得级别2关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long level2LinkId(){
      return _level2LinkId;
   }

   //============================================================
   // <T>设置级别2关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel2LinkId(long value){
      _level2LinkId = value;
   }

   //============================================================
   // <T>判断级别2标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel2LabelChanged(){
      return !RString.equals(__level2Label, _level2Label);
   }

   //============================================================
   // <T>获得级别2标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String level2Label(){
      return _level2Label;
   }

   //============================================================
   // <T>设置级别2标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel2Label(String value){
      _level2Label = value;
   }

   //============================================================
   // <T>判断级别3编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel3IdChanged(){
      return __level3Id != _level3Id;
   }

   //============================================================
   // <T>获得级别3编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long level3Id(){
      return _level3Id;
   }

   //============================================================
   // <T>设置级别3编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel3Id(long value){
      _level3Id = value;
   }

   //============================================================
   // <T>判断级别3关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel3LinkIdChanged(){
      return __level3LinkId != _level3LinkId;
   }

   //============================================================
   // <T>获得级别3关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long level3LinkId(){
      return _level3LinkId;
   }

   //============================================================
   // <T>设置级别3关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel3LinkId(long value){
      _level3LinkId = value;
   }

   //============================================================
   // <T>判断级别3标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel3LabelChanged(){
      return !RString.equals(__level3Label, _level3Label);
   }

   //============================================================
   // <T>获得级别3标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String level3Label(){
      return _level3Label;
   }

   //============================================================
   // <T>设置级别3标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel3Label(String value){
      _level3Label = value;
   }

   //============================================================
   // <T>判断级别4编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel4IdChanged(){
      return __level4Id != _level4Id;
   }

   //============================================================
   // <T>获得级别4编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long level4Id(){
      return _level4Id;
   }

   //============================================================
   // <T>设置级别4编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel4Id(long value){
      _level4Id = value;
   }

   //============================================================
   // <T>判断级别4关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel4LinkIdChanged(){
      return __level4LinkId != _level4LinkId;
   }

   //============================================================
   // <T>获得级别4关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long level4LinkId(){
      return _level4LinkId;
   }

   //============================================================
   // <T>设置级别4关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel4LinkId(long value){
      _level4LinkId = value;
   }

   //============================================================
   // <T>判断级别4标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel4LabelChanged(){
      return !RString.equals(__level4Label, _level4Label);
   }

   //============================================================
   // <T>获得级别4标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String level4Label(){
      return _level4Label;
   }

   //============================================================
   // <T>设置级别4标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel4Label(String value){
      _level4Label = value;
   }

   //============================================================
   // <T>判断级别5编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel5IdChanged(){
      return __level5Id != _level5Id;
   }

   //============================================================
   // <T>获得级别5编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long level5Id(){
      return _level5Id;
   }

   //============================================================
   // <T>设置级别5编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel5Id(long value){
      _level5Id = value;
   }

   //============================================================
   // <T>判断级别5关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel5LinkIdChanged(){
      return __level5LinkId != _level5LinkId;
   }

   //============================================================
   // <T>获得级别5关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long level5LinkId(){
      return _level5LinkId;
   }

   //============================================================
   // <T>设置级别5关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel5LinkId(long value){
      _level5LinkId = value;
   }

   //============================================================
   // <T>判断级别5标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel5LabelChanged(){
      return !RString.equals(__level5Label, _level5Label);
   }

   //============================================================
   // <T>获得级别5标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String level5Label(){
      return _level5Label;
   }

   //============================================================
   // <T>设置级别5标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel5Label(String value){
      _level5Label = value;
   }

   //============================================================
   // <T>判断级别6编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel6IdChanged(){
      return __level6Id != _level6Id;
   }

   //============================================================
   // <T>获得级别6编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long level6Id(){
      return _level6Id;
   }

   //============================================================
   // <T>设置级别6编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel6Id(long value){
      _level6Id = value;
   }

   //============================================================
   // <T>判断级别6关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel6LinkIdChanged(){
      return __level6LinkId != _level6LinkId;
   }

   //============================================================
   // <T>获得级别6关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long level6LinkId(){
      return _level6LinkId;
   }

   //============================================================
   // <T>设置级别6关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel6LinkId(long value){
      _level6LinkId = value;
   }

   //============================================================
   // <T>判断级别6标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel6LabelChanged(){
      return !RString.equals(__level6Label, _level6Label);
   }

   //============================================================
   // <T>获得级别6标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String level6Label(){
      return _level6Label;
   }

   //============================================================
   // <T>设置级别6标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel6Label(String value){
      _level6Label = value;
   }

   //============================================================
   // <T>判断级别7编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel7IdChanged(){
      return __level7Id != _level7Id;
   }

   //============================================================
   // <T>获得级别7编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long level7Id(){
      return _level7Id;
   }

   //============================================================
   // <T>设置级别7编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel7Id(long value){
      _level7Id = value;
   }

   //============================================================
   // <T>判断级别7关联编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel7LinkIdChanged(){
      return __level7LinkId != _level7LinkId;
   }

   //============================================================
   // <T>获得级别7关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long level7LinkId(){
      return _level7LinkId;
   }

   //============================================================
   // <T>设置级别7关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel7LinkId(long value){
      _level7LinkId = value;
   }

   //============================================================
   // <T>判断级别7标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevel7LabelChanged(){
      return !RString.equals(__level7Label, _level7Label);
   }

   //============================================================
   // <T>获得级别7标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String level7Label(){
      return _level7Label;
   }

   //============================================================
   // <T>设置级别7标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel7Label(String value){
      _level7Label = value;
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
   // <T>判断理财师总计的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarketerTotalChanged(){
      return __marketerTotal != _marketerTotal;
   }

   //============================================================
   // <T>获得理财师总计的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int marketerTotal(){
      return _marketerTotal;
   }

   //============================================================
   // <T>设置理财师总计的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerTotal(int value){
      _marketerTotal = value;
   }

   //============================================================
   // <T>判断客户总计的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerTotalChanged(){
      return __customerTotal != _customerTotal;
   }

   //============================================================
   // <T>获得客户总计的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int customerTotal(){
      return _customerTotal;
   }

   //============================================================
   // <T>设置客户总计的数据内容。</T>
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
         case "link_parent_id":
            return Long.toString(_linkParentId);
         case "link_id":
            return Long.toString(_linkId);
         case "link_date":
            return _linkDate.toString();
         case "link_cd":
            return RInteger.toString(_linkCd);
         case "data_id":
            return Long.toString(_dataId);
         case "parent_id":
            return Long.toString(_parentId);
         case "code":
            return _code;
         case "label":
            return _label;
         case "level":
            return RInteger.toString(_level);
         case "level1_id":
            return Long.toString(_level1Id);
         case "level1_link_id":
            return Long.toString(_level1LinkId);
         case "level1_label":
            return _level1Label;
         case "level2_id":
            return Long.toString(_level2Id);
         case "level2_link_id":
            return Long.toString(_level2LinkId);
         case "level2_label":
            return _level2Label;
         case "level3_id":
            return Long.toString(_level3Id);
         case "level3_link_id":
            return Long.toString(_level3LinkId);
         case "level3_label":
            return _level3Label;
         case "level4_id":
            return Long.toString(_level4Id);
         case "level4_link_id":
            return Long.toString(_level4LinkId);
         case "level4_label":
            return _level4Label;
         case "level5_id":
            return Long.toString(_level5Id);
         case "level5_link_id":
            return Long.toString(_level5LinkId);
         case "level5_label":
            return _level5Label;
         case "level6_id":
            return Long.toString(_level6Id);
         case "level6_link_id":
            return Long.toString(_level6LinkId);
         case "level6_label":
            return _level6Label;
         case "level7_id":
            return Long.toString(_level7Id);
         case "level7_link_id":
            return Long.toString(_level7LinkId);
         case "level7_label":
            return _level7Label;
         case "investment_total":
            return RDouble.toString(_investmentTotal);
         case "redemption_total":
            return RDouble.toString(_redemptionTotal);
         case "netinvestment_total":
            return RDouble.toString(_netinvestmentTotal);
         case "interest_total":
            return RDouble.toString(_interestTotal);
         case "performance_total":
            return RDouble.toString(_performanceTotal);
         case "marketer_total":
            return RInteger.toString(_marketerTotal);
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
         case "link_parent_id":
            _linkParentId = RLong.parse(value);
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
         case "parent_id":
            _parentId = RLong.parse(value);
            break;
         case "code":
            _code = value;
            break;
         case "label":
            _label = value;
            break;
         case "level":
            _level = RInteger.parse(value);
            break;
         case "level1_id":
            _level1Id = RLong.parse(value);
            break;
         case "level1_link_id":
            _level1LinkId = RLong.parse(value);
            break;
         case "level1_label":
            _level1Label = value;
            break;
         case "level2_id":
            _level2Id = RLong.parse(value);
            break;
         case "level2_link_id":
            _level2LinkId = RLong.parse(value);
            break;
         case "level2_label":
            _level2Label = value;
            break;
         case "level3_id":
            _level3Id = RLong.parse(value);
            break;
         case "level3_link_id":
            _level3LinkId = RLong.parse(value);
            break;
         case "level3_label":
            _level3Label = value;
            break;
         case "level4_id":
            _level4Id = RLong.parse(value);
            break;
         case "level4_link_id":
            _level4LinkId = RLong.parse(value);
            break;
         case "level4_label":
            _level4Label = value;
            break;
         case "level5_id":
            _level5Id = RLong.parse(value);
            break;
         case "level5_link_id":
            _level5LinkId = RLong.parse(value);
            break;
         case "level5_label":
            _level5Label = value;
            break;
         case "level6_id":
            _level6Id = RLong.parse(value);
            break;
         case "level6_link_id":
            _level6LinkId = RLong.parse(value);
            break;
         case "level6_label":
            _level6Label = value;
            break;
         case "level7_id":
            _level7Id = RLong.parse(value);
            break;
         case "level7_link_id":
            _level7LinkId = RLong.parse(value);
            break;
         case "level7_label":
            _level7Label = value;
            break;
         case "investment_total":
            _investmentTotal = RDouble.parse(value);
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
         case "marketer_total":
            _marketerTotal = RInteger.parse(value);
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
            case "link_parent_id":
               __linkParentId = RLong.parse(value);
               _linkParentId = __linkParentId;
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
            case "parent_id":
               __parentId = RLong.parse(value);
               _parentId = __parentId;
               break;
            case "code":
               __code = value;
               _code = __code;
               break;
            case "label":
               __label = value;
               _label = __label;
               break;
            case "level":
               __level = RInteger.parse(value);
               _level = __level;
               break;
            case "level1_id":
               __level1Id = RLong.parse(value);
               _level1Id = __level1Id;
               break;
            case "level1_link_id":
               __level1LinkId = RLong.parse(value);
               _level1LinkId = __level1LinkId;
               break;
            case "level1_label":
               __level1Label = value;
               _level1Label = __level1Label;
               break;
            case "level2_id":
               __level2Id = RLong.parse(value);
               _level2Id = __level2Id;
               break;
            case "level2_link_id":
               __level2LinkId = RLong.parse(value);
               _level2LinkId = __level2LinkId;
               break;
            case "level2_label":
               __level2Label = value;
               _level2Label = __level2Label;
               break;
            case "level3_id":
               __level3Id = RLong.parse(value);
               _level3Id = __level3Id;
               break;
            case "level3_link_id":
               __level3LinkId = RLong.parse(value);
               _level3LinkId = __level3LinkId;
               break;
            case "level3_label":
               __level3Label = value;
               _level3Label = __level3Label;
               break;
            case "level4_id":
               __level4Id = RLong.parse(value);
               _level4Id = __level4Id;
               break;
            case "level4_link_id":
               __level4LinkId = RLong.parse(value);
               _level4LinkId = __level4LinkId;
               break;
            case "level4_label":
               __level4Label = value;
               _level4Label = __level4Label;
               break;
            case "level5_id":
               __level5Id = RLong.parse(value);
               _level5Id = __level5Id;
               break;
            case "level5_link_id":
               __level5LinkId = RLong.parse(value);
               _level5LinkId = __level5LinkId;
               break;
            case "level5_label":
               __level5Label = value;
               _level5Label = __level5Label;
               break;
            case "level6_id":
               __level6Id = RLong.parse(value);
               _level6Id = __level6Id;
               break;
            case "level6_link_id":
               __level6LinkId = RLong.parse(value);
               _level6LinkId = __level6LinkId;
               break;
            case "level6_label":
               __level6Label = value;
               _level6Label = __level6Label;
               break;
            case "level7_id":
               __level7Id = RLong.parse(value);
               _level7Id = __level7Id;
               break;
            case "level7_link_id":
               __level7LinkId = RLong.parse(value);
               _level7LinkId = __level7LinkId;
               break;
            case "level7_label":
               __level7Label = value;
               _level7Label = __level7Label;
               break;
            case "investment_total":
               __investmentTotal = RDouble.parse(value);
               _investmentTotal = __investmentTotal;
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
            case "marketer_total":
               __marketerTotal = RInteger.parse(value);
               _marketerTotal = __marketerTotal;
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
      row.set("linkParentId", _linkParentId);
      row.set("linkId", _linkId);
      row.set("linkDate", _linkDate);
      row.set("linkCd", _linkCd);
      row.set("dataId", _dataId);
      row.set("parentId", _parentId);
      row.set("code", _code);
      row.set("label", _label);
      row.set("level", _level);
      row.set("level1Id", _level1Id);
      row.set("level1LinkId", _level1LinkId);
      row.set("level1Label", _level1Label);
      row.set("level2Id", _level2Id);
      row.set("level2LinkId", _level2LinkId);
      row.set("level2Label", _level2Label);
      row.set("level3Id", _level3Id);
      row.set("level3LinkId", _level3LinkId);
      row.set("level3Label", _level3Label);
      row.set("level4Id", _level4Id);
      row.set("level4LinkId", _level4LinkId);
      row.set("level4Label", _level4Label);
      row.set("level5Id", _level5Id);
      row.set("level5LinkId", _level5LinkId);
      row.set("level5Label", _level5Label);
      row.set("level6Id", _level6Id);
      row.set("level6LinkId", _level6LinkId);
      row.set("level6Label", _level6Label);
      row.set("level7Id", _level7Id);
      row.set("level7LinkId", _level7LinkId);
      row.set("level7Label", _level7Label);
      row.set("investmentTotal", _investmentTotal);
      row.set("redemptionTotal", _redemptionTotal);
      row.set("netinvestmentTotal", _netinvestmentTotal);
      row.set("interestTotal", _interestTotal);
      row.set("performanceTotal", _performanceTotal);
      row.set("marketerTotal", _marketerTotal);
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
      map.put("linkParentId", RLong.toString(_linkParentId));
      map.put("linkId", RLong.toString(_linkId));
      map.put("linkDate", _linkDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("linkCd", RInteger.toString(_linkCd));
      map.put("dataId", RLong.toString(_dataId));
      map.put("parentId", RLong.toString(_parentId));
      map.put("code", _code);
      map.put("label", _label);
      map.put("level", RInteger.toString(_level));
      map.put("level1Id", RLong.toString(_level1Id));
      map.put("level1LinkId", RLong.toString(_level1LinkId));
      map.put("level1Label", _level1Label);
      map.put("level2Id", RLong.toString(_level2Id));
      map.put("level2LinkId", RLong.toString(_level2LinkId));
      map.put("level2Label", _level2Label);
      map.put("level3Id", RLong.toString(_level3Id));
      map.put("level3LinkId", RLong.toString(_level3LinkId));
      map.put("level3Label", _level3Label);
      map.put("level4Id", RLong.toString(_level4Id));
      map.put("level4LinkId", RLong.toString(_level4LinkId));
      map.put("level4Label", _level4Label);
      map.put("level5Id", RLong.toString(_level5Id));
      map.put("level5LinkId", RLong.toString(_level5LinkId));
      map.put("level5Label", _level5Label);
      map.put("level6Id", RLong.toString(_level6Id));
      map.put("level6LinkId", RLong.toString(_level6LinkId));
      map.put("level6Label", _level6Label);
      map.put("level7Id", RLong.toString(_level7Id));
      map.put("level7LinkId", RLong.toString(_level7LinkId));
      map.put("level7Label", _level7Label);
      map.put("investmentTotal", RDouble.toString(_investmentTotal));
      map.put("redemptionTotal", RDouble.toString(_redemptionTotal));
      map.put("netinvestmentTotal", RDouble.toString(_netinvestmentTotal));
      map.put("interestTotal", RDouble.toString(_interestTotal));
      map.put("performanceTotal", RDouble.toString(_performanceTotal));
      map.put("marketerTotal", RInteger.toString(_marketerTotal));
      map.put("customerTotal", RInteger.toString(_customerTotal));
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
      _linkParentId = input.readInt64();
      _linkId = input.readInt64();
      _linkDate.set(input.readInt64());
      _linkCd = input.readInt32();
      _dataId = input.readInt64();
      _parentId = input.readInt64();
      _code = input.readString();
      _label = input.readString();
      _level = input.readInt32();
      _level1Id = input.readInt64();
      _level1LinkId = input.readInt64();
      _level1Label = input.readString();
      _level2Id = input.readInt64();
      _level2LinkId = input.readInt64();
      _level2Label = input.readString();
      _level3Id = input.readInt64();
      _level3LinkId = input.readInt64();
      _level3Label = input.readString();
      _level4Id = input.readInt64();
      _level4LinkId = input.readInt64();
      _level4Label = input.readString();
      _level5Id = input.readInt64();
      _level5LinkId = input.readInt64();
      _level5Label = input.readString();
      _level6Id = input.readInt64();
      _level6LinkId = input.readInt64();
      _level6Label = input.readString();
      _level7Id = input.readInt64();
      _level7LinkId = input.readInt64();
      _level7Label = input.readString();
      _marketerTotal = input.readInt32();
      _customerTotal = input.readInt32();
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
      output.writeInt64(_linkParentId);
      output.writeInt64(_linkId);
      output.writeInt64(_linkDate.get());
      output.writeInt32(_linkCd);
      output.writeInt64(_dataId);
      output.writeInt64(_parentId);
      output.writeString(_code);
      output.writeString(_label);
      output.writeInt32(_level);
      output.writeInt64(_level1Id);
      output.writeInt64(_level1LinkId);
      output.writeString(_level1Label);
      output.writeInt64(_level2Id);
      output.writeInt64(_level2LinkId);
      output.writeString(_level2Label);
      output.writeInt64(_level3Id);
      output.writeInt64(_level3LinkId);
      output.writeString(_level3Label);
      output.writeInt64(_level4Id);
      output.writeInt64(_level4LinkId);
      output.writeString(_level4Label);
      output.writeInt64(_level5Id);
      output.writeInt64(_level5LinkId);
      output.writeString(_level5Label);
      output.writeInt64(_level6Id);
      output.writeInt64(_level6LinkId);
      output.writeString(_level6Label);
      output.writeInt64(_level7Id);
      output.writeInt64(_level7LinkId);
      output.writeString(_level7Label);
      output.writeInt32(_marketerTotal);
      output.writeInt32(_customerTotal);
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
      FStatisticsFinancialDepartmentUnit unit = (FStatisticsFinancialDepartmentUnit)logicUnit;
      unit.setOuid(_ouid);
      unit.setOvld(_ovld);
      unit.setGuid(_guid);
      unit.setLinkParentId(_linkParentId);
      unit.setLinkId(_linkId);
      unit.linkDate().assign(_linkDate);
      unit.setLinkCd(_linkCd);
      unit.setDataId(_dataId);
      unit.setParentId(_parentId);
      unit.setCode(_code);
      unit.setLabel(_label);
      unit.setLevel(_level);
      unit.setLevel1Id(_level1Id);
      unit.setLevel1LinkId(_level1LinkId);
      unit.setLevel1Label(_level1Label);
      unit.setLevel2Id(_level2Id);
      unit.setLevel2LinkId(_level2LinkId);
      unit.setLevel2Label(_level2Label);
      unit.setLevel3Id(_level3Id);
      unit.setLevel3LinkId(_level3LinkId);
      unit.setLevel3Label(_level3Label);
      unit.setLevel4Id(_level4Id);
      unit.setLevel4LinkId(_level4LinkId);
      unit.setLevel4Label(_level4Label);
      unit.setLevel5Id(_level5Id);
      unit.setLevel5LinkId(_level5LinkId);
      unit.setLevel5Label(_level5Label);
      unit.setLevel6Id(_level6Id);
      unit.setLevel6LinkId(_level6LinkId);
      unit.setLevel6Label(_level6Label);
      unit.setLevel7Id(_level7Id);
      unit.setLevel7LinkId(_level7LinkId);
      unit.setLevel7Label(_level7Label);
      unit.setInvestmentTotal(_investmentTotal);
      unit.setRedemptionTotal(_redemptionTotal);
      unit.setNetinvestmentTotal(_netinvestmentTotal);
      unit.setInterestTotal(_interestTotal);
      unit.setPerformanceTotal(_performanceTotal);
      unit.setMarketerTotal(_marketerTotal);
      unit.setCustomerTotal(_customerTotal);
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
   public FStatisticsFinancialDepartmentUnit clone(){
      FStatisticsFinancialDepartmentUnit unit = RClass.newInstance(FStatisticsFinancialDepartmentUnit.class);
      copy(unit);
      return unit;
   }
}
