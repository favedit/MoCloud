package com.cyou.gccloud.data.data;

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
// <T>金融部门信息逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataFinancialDepartmentUnit
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

   // 存储字段代码的定义。
   private String __code;

   // 字段代码的定义。
   protected String _code;

   // 存储字段名称的定义。
   private String __name;

   // 字段名称的定义。
   protected String _name;

   // 存储字段名称的定义。
   private String __label;

   // 字段名称的定义。
   protected String _label;

   // 存储字段所属公司编号的定义。
   private int __departmentId;

   // 字段所属公司编号的定义。
   protected int _departmentId;

   // 存储字段所属公司名称的定义。
   private String __departmentLabel;

   // 字段所属公司名称的定义。
   protected String _departmentLabel;

   // 存储字段所属区域编号的定义。
   private int __regionId;

   // 字段所属区域编号的定义。
   protected int _regionId;

   // 存储字段区域名称的定义。
   private String __regionLabel;

   // 字段区域名称的定义。
   protected String _regionLabel;

   // 存储字段级别的定义。
   private int __level;

   // 字段级别的定义。
   protected int _level;

   // 存储字段负责人编号的定义。
   private long __leaderId;

   // 字段负责人编号的定义。
   protected long _leaderId;

   // 存储字段负责人标签的定义。
   private String __leaderLabel;

   // 字段负责人标签的定义。
   protected String _leaderLabel;

   // 存储字段负责人电话的定义。
   private String __leaderPhone;

   // 字段负责人电话的定义。
   protected String _leaderPhone;

   // 存储字段省份标签编号的定义。
   private int __provinceId;

   // 字段省份标签编号的定义。
   protected int _provinceId;

   // 存储字段省份标签的定义。
   private String __provinceLabel;

   // 字段省份标签的定义。
   protected String _provinceLabel;

   // 存储字段城市编号的定义。
   private int __cityId;

   // 字段城市编号的定义。
   protected int _cityId;

   // 存储字段城市标签的定义。
   private String __cityLabel;

   // 字段城市标签的定义。
   protected String _cityLabel;

   // 存储字段详细地址的定义。
   private String __detailAddress;

   // 字段详细地址的定义。
   protected String _detailAddress;

   // 存储字段位置经度的定义。
   private double __locationLongitude;

   // 字段位置经度的定义。
   protected double _locationLongitude;

   // 存储字段位置维度的定义。
   private double __locationLatitude;

   // 字段位置维度的定义。
   protected double _locationLatitude;

   // 存储字段部门电话的定义。
   private String __departmentPhone;

   // 字段部门电话的定义。
   protected String _departmentPhone;

   // 存储字段建立日期的定义。
   private TDateTime __buildDate = new TDateTime();

   // 字段建立日期的定义。
   protected TDateTime _buildDate = new TDateTime();

   // 存储字段投资总额的定义。
   private double __investmentTotal;

   // 字段投资总额的定义。
   protected double _investmentTotal;

   // 存储字段投资次数的定义。
   private int __investmentCount;

   // 字段投资次数的定义。
   protected int _investmentCount;

   // 存储字段投资时间的定义。
   private TDateTime __investmentDate = new TDateTime();

   // 字段投资时间的定义。
   protected TDateTime _investmentDate = new TDateTime();

   // 存储字段赎回总额的定义。
   private double __redemptionTotal;

   // 字段赎回总额的定义。
   protected double _redemptionTotal;

   // 存储字段赎回次数的定义。
   private int __redemptionCount;

   // 字段赎回次数的定义。
   protected int _redemptionCount;

   // 存储字段赎回时间的定义。
   private TDateTime __redemptionDate = new TDateTime();

   // 字段赎回时间的定义。
   protected TDateTime _redemptionDate = new TDateTime();

   // 存储字段净投总额的定义。
   private double __netinvestmentTotal;

   // 字段净投总额的定义。
   protected double _netinvestmentTotal;

   // 存储字段利息总额的定义。
   private double __interestTotal;

   // 字段利息总额的定义。
   protected double _interestTotal;

   // 存储字段业绩总额的定义。
   private double __performanceTotal;

   // 字段业绩总额的定义。
   protected double _performanceTotal;

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
   // <T>构造金融部门信息逻辑单元。</T>
   //============================================================
   public FDataFinancialDepartmentUnit(){
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
   // <T>判断所属公司编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentIdChanged(){
      return __departmentId != _departmentId;
   }

   //============================================================
   // <T>获得所属公司编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int departmentId(){
      return _departmentId;
   }

   //============================================================
   // <T>设置所属公司编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentId(int value){
      _departmentId = value;
   }

   //============================================================
   // <T>判断所属公司名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLabelChanged(){
      return !RString.equals(__departmentLabel, _departmentLabel);
   }

   //============================================================
   // <T>获得所属公司名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String departmentLabel(){
      return _departmentLabel;
   }

   //============================================================
   // <T>设置所属公司名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLabel(String value){
      _departmentLabel = value;
   }

   //============================================================
   // <T>判断所属区域编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRegionIdChanged(){
      return __regionId != _regionId;
   }

   //============================================================
   // <T>获得所属区域编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int regionId(){
      return _regionId;
   }

   //============================================================
   // <T>设置所属区域编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRegionId(int value){
      _regionId = value;
   }

   //============================================================
   // <T>判断区域名称的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRegionLabelChanged(){
      return !RString.equals(__regionLabel, _regionLabel);
   }

   //============================================================
   // <T>获得区域名称的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String regionLabel(){
      return _regionLabel;
   }

   //============================================================
   // <T>设置区域名称的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRegionLabel(String value){
      _regionLabel = value;
   }

   //============================================================
   // <T>判断级别的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLevelChanged(){
      return __level != _level;
   }

   //============================================================
   // <T>获得级别的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int level(){
      return _level;
   }

   //============================================================
   // <T>设置级别的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLevel(int value){
      _level = value;
   }

   //============================================================
   // <T>判断负责人编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLeaderIdChanged(){
      return __leaderId != _leaderId;
   }

   //============================================================
   // <T>获得负责人编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long leaderId(){
      return _leaderId;
   }

   //============================================================
   // <T>设置负责人编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLeaderId(long value){
      _leaderId = value;
   }

   //============================================================
   // <T>判断负责人标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLeaderLabelChanged(){
      return !RString.equals(__leaderLabel, _leaderLabel);
   }

   //============================================================
   // <T>获得负责人标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String leaderLabel(){
      return _leaderLabel;
   }

   //============================================================
   // <T>设置负责人标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLeaderLabel(String value){
      _leaderLabel = value;
   }

   //============================================================
   // <T>判断负责人电话的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLeaderPhoneChanged(){
      return !RString.equals(__leaderPhone, _leaderPhone);
   }

   //============================================================
   // <T>获得负责人电话的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String leaderPhone(){
      return _leaderPhone;
   }

   //============================================================
   // <T>设置负责人电话的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLeaderPhone(String value){
      _leaderPhone = value;
   }

   //============================================================
   // <T>判断省份标签编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProvinceIdChanged(){
      return __provinceId != _provinceId;
   }

   //============================================================
   // <T>获得省份标签编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int provinceId(){
      return _provinceId;
   }

   //============================================================
   // <T>设置省份标签编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProvinceId(int value){
      _provinceId = value;
   }

   //============================================================
   // <T>判断省份标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProvinceLabelChanged(){
      return !RString.equals(__provinceLabel, _provinceLabel);
   }

   //============================================================
   // <T>获得省份标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String provinceLabel(){
      return _provinceLabel;
   }

   //============================================================
   // <T>设置省份标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProvinceLabel(String value){
      _provinceLabel = value;
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
   public int cityId(){
      return _cityId;
   }

   //============================================================
   // <T>设置城市编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCityId(int value){
      _cityId = value;
   }

   //============================================================
   // <T>判断城市标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCityLabelChanged(){
      return !RString.equals(__cityLabel, _cityLabel);
   }

   //============================================================
   // <T>获得城市标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String cityLabel(){
      return _cityLabel;
   }

   //============================================================
   // <T>设置城市标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCityLabel(String value){
      _cityLabel = value;
   }

   //============================================================
   // <T>判断详细地址的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDetailAddressChanged(){
      return !RString.equals(__detailAddress, _detailAddress);
   }

   //============================================================
   // <T>获得详细地址的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String detailAddress(){
      return _detailAddress;
   }

   //============================================================
   // <T>设置详细地址的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDetailAddress(String value){
      _detailAddress = value;
   }

   //============================================================
   // <T>判断位置经度的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLocationLongitudeChanged(){
      return __locationLongitude != _locationLongitude;
   }

   //============================================================
   // <T>获得位置经度的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double locationLongitude(){
      return _locationLongitude;
   }

   //============================================================
   // <T>设置位置经度的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLocationLongitude(double value){
      _locationLongitude = value;
   }

   //============================================================
   // <T>判断位置维度的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLocationLatitudeChanged(){
      return __locationLatitude != _locationLatitude;
   }

   //============================================================
   // <T>获得位置维度的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double locationLatitude(){
      return _locationLatitude;
   }

   //============================================================
   // <T>设置位置维度的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLocationLatitude(double value){
      _locationLatitude = value;
   }

   //============================================================
   // <T>判断部门电话的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentPhoneChanged(){
      return !RString.equals(__departmentPhone, _departmentPhone);
   }

   //============================================================
   // <T>获得部门电话的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String departmentPhone(){
      return _departmentPhone;
   }

   //============================================================
   // <T>设置部门电话的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentPhone(String value){
      _departmentPhone = value;
   }

   //============================================================
   // <T>判断建立日期的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBuildDateChanged(){
      return !__buildDate.equals(_buildDate);
   }

   //============================================================
   // <T>获得建立日期的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime buildDate(){
      return _buildDate;
   }

   //============================================================
   // <T>设置建立日期的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBuildDate(TDateTime value){
      _buildDate = value;
   }

   //============================================================
   // <T>判断投资总额的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInvestmentTotalChanged(){
      return __investmentTotal != _investmentTotal;
   }

   //============================================================
   // <T>获得投资总额的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double investmentTotal(){
      return _investmentTotal;
   }

   //============================================================
   // <T>设置投资总额的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInvestmentTotal(double value){
      _investmentTotal = value;
   }

   //============================================================
   // <T>判断投资次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInvestmentCountChanged(){
      return __investmentCount != _investmentCount;
   }

   //============================================================
   // <T>获得投资次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int investmentCount(){
      return _investmentCount;
   }

   //============================================================
   // <T>设置投资次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInvestmentCount(int value){
      _investmentCount = value;
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
   // <T>判断赎回总额的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRedemptionTotalChanged(){
      return __redemptionTotal != _redemptionTotal;
   }

   //============================================================
   // <T>获得赎回总额的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double redemptionTotal(){
      return _redemptionTotal;
   }

   //============================================================
   // <T>设置赎回总额的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRedemptionTotal(double value){
      _redemptionTotal = value;
   }

   //============================================================
   // <T>判断赎回次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRedemptionCountChanged(){
      return __redemptionCount != _redemptionCount;
   }

   //============================================================
   // <T>获得赎回次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int redemptionCount(){
      return _redemptionCount;
   }

   //============================================================
   // <T>设置赎回次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRedemptionCount(int value){
      _redemptionCount = value;
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
   // <T>判断净投总额的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isNetinvestmentTotalChanged(){
      return __netinvestmentTotal != _netinvestmentTotal;
   }

   //============================================================
   // <T>获得净投总额的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double netinvestmentTotal(){
      return _netinvestmentTotal;
   }

   //============================================================
   // <T>设置净投总额的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setNetinvestmentTotal(double value){
      _netinvestmentTotal = value;
   }

   //============================================================
   // <T>判断利息总额的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInterestTotalChanged(){
      return __interestTotal != _interestTotal;
   }

   //============================================================
   // <T>获得利息总额的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double interestTotal(){
      return _interestTotal;
   }

   //============================================================
   // <T>设置利息总额的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInterestTotal(double value){
      _interestTotal = value;
   }

   //============================================================
   // <T>判断业绩总额的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPerformanceTotalChanged(){
      return __performanceTotal != _performanceTotal;
   }

   //============================================================
   // <T>获得业绩总额的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double performanceTotal(){
      return _performanceTotal;
   }

   //============================================================
   // <T>设置业绩总额的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPerformanceTotal(double value){
      _performanceTotal = value;
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
         case "link_parent_id":
            return Long.toString(_linkParentId);
         case "link_id":
            return Long.toString(_linkId);
         case "code":
            return _code;
         case "name":
            return _name;
         case "label":
            return _label;
         case "department_id":
            return RInteger.toString(_departmentId);
         case "department_label":
            return _departmentLabel;
         case "region_id":
            return RInteger.toString(_regionId);
         case "region_label":
            return _regionLabel;
         case "level":
            return RInteger.toString(_level);
         case "leader_id":
            return Long.toString(_leaderId);
         case "leader_label":
            return _leaderLabel;
         case "leader_phone":
            return _leaderPhone;
         case "province_id":
            return RInteger.toString(_provinceId);
         case "province_label":
            return _provinceLabel;
         case "city_id":
            return RInteger.toString(_cityId);
         case "city_label":
            return _cityLabel;
         case "detail_address":
            return _detailAddress;
         case "location_longitude":
            return RDouble.toString(_locationLongitude);
         case "location_latitude":
            return RDouble.toString(_locationLatitude);
         case "department_phone":
            return _departmentPhone;
         case "build_date":
            return _buildDate.toString();
         case "investment_total":
            return RDouble.toString(_investmentTotal);
         case "investment_count":
            return RInteger.toString(_investmentCount);
         case "investment_date":
            return _investmentDate.toString();
         case "redemption_total":
            return RDouble.toString(_redemptionTotal);
         case "redemption_count":
            return RInteger.toString(_redemptionCount);
         case "redemption_date":
            return _redemptionDate.toString();
         case "netinvestment_total":
            return RDouble.toString(_netinvestmentTotal);
         case "interest_total":
            return RDouble.toString(_interestTotal);
         case "performance_total":
            return RDouble.toString(_performanceTotal);
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
         case "link_parent_id":
            _linkParentId = RLong.parse(value);
            break;
         case "link_id":
            _linkId = RLong.parse(value);
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
         case "department_id":
            _departmentId = RInteger.parse(value);
            break;
         case "department_label":
            _departmentLabel = value;
            break;
         case "region_id":
            _regionId = RInteger.parse(value);
            break;
         case "region_label":
            _regionLabel = value;
            break;
         case "level":
            _level = RInteger.parse(value);
            break;
         case "leader_id":
            _leaderId = RLong.parse(value);
            break;
         case "leader_label":
            _leaderLabel = value;
            break;
         case "leader_phone":
            _leaderPhone = value;
            break;
         case "province_id":
            _provinceId = RInteger.parse(value);
            break;
         case "province_label":
            _provinceLabel = value;
            break;
         case "city_id":
            _cityId = RInteger.parse(value);
            break;
         case "city_label":
            _cityLabel = value;
            break;
         case "detail_address":
            _detailAddress = value;
            break;
         case "location_longitude":
            _locationLongitude = RDouble.parse(value);
            break;
         case "location_latitude":
            _locationLatitude = RDouble.parse(value);
            break;
         case "department_phone":
            _departmentPhone = value;
            break;
         case "build_date":
            _buildDate.parse(value);
            break;
         case "investment_total":
            _investmentTotal = RDouble.parse(value);
            break;
         case "investment_count":
            _investmentCount = RInteger.parse(value);
            break;
         case "investment_date":
            _investmentDate.parse(value);
            break;
         case "redemption_total":
            _redemptionTotal = RDouble.parse(value);
            break;
         case "redemption_count":
            _redemptionCount = RInteger.parse(value);
            break;
         case "redemption_date":
            _redemptionDate.parse(value);
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
            case "link_parent_id":
               __linkParentId = RLong.parse(value);
               _linkParentId = __linkParentId;
               break;
            case "link_id":
               __linkId = RLong.parse(value);
               _linkId = __linkId;
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
            case "department_id":
               __departmentId = RInteger.parse(value);
               _departmentId = __departmentId;
               break;
            case "department_label":
               __departmentLabel = value;
               _departmentLabel = __departmentLabel;
               break;
            case "region_id":
               __regionId = RInteger.parse(value);
               _regionId = __regionId;
               break;
            case "region_label":
               __regionLabel = value;
               _regionLabel = __regionLabel;
               break;
            case "level":
               __level = RInteger.parse(value);
               _level = __level;
               break;
            case "leader_id":
               __leaderId = RLong.parse(value);
               _leaderId = __leaderId;
               break;
            case "leader_label":
               __leaderLabel = value;
               _leaderLabel = __leaderLabel;
               break;
            case "leader_phone":
               __leaderPhone = value;
               _leaderPhone = __leaderPhone;
               break;
            case "province_id":
               __provinceId = RInteger.parse(value);
               _provinceId = __provinceId;
               break;
            case "province_label":
               __provinceLabel = value;
               _provinceLabel = __provinceLabel;
               break;
            case "city_id":
               __cityId = RInteger.parse(value);
               _cityId = __cityId;
               break;
            case "city_label":
               __cityLabel = value;
               _cityLabel = __cityLabel;
               break;
            case "detail_address":
               __detailAddress = value;
               _detailAddress = __detailAddress;
               break;
            case "location_longitude":
               __locationLongitude = RDouble.parse(value);
               _locationLongitude = __locationLongitude;
               break;
            case "location_latitude":
               __locationLatitude = RDouble.parse(value);
               _locationLatitude = __locationLatitude;
               break;
            case "department_phone":
               __departmentPhone = value;
               _departmentPhone = __departmentPhone;
               break;
            case "build_date":
               __buildDate.parse(value);
               _buildDate.assign(__buildDate);
               break;
            case "investment_total":
               __investmentTotal = RDouble.parse(value);
               _investmentTotal = __investmentTotal;
               break;
            case "investment_count":
               __investmentCount = RInteger.parse(value);
               _investmentCount = __investmentCount;
               break;
            case "investment_date":
               __investmentDate.parse(value);
               _investmentDate.assign(__investmentDate);
               break;
            case "redemption_total":
               __redemptionTotal = RDouble.parse(value);
               _redemptionTotal = __redemptionTotal;
               break;
            case "redemption_count":
               __redemptionCount = RInteger.parse(value);
               _redemptionCount = __redemptionCount;
               break;
            case "redemption_date":
               __redemptionDate.parse(value);
               _redemptionDate.assign(__redemptionDate);
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
      row.set("linkParentId", _linkParentId);
      row.set("linkId", _linkId);
      row.set("code", _code);
      row.set("name", _name);
      row.set("label", _label);
      row.set("departmentId", _departmentId);
      row.set("departmentLabel", _departmentLabel);
      row.set("regionId", _regionId);
      row.set("regionLabel", _regionLabel);
      row.set("level", _level);
      row.set("leaderId", _leaderId);
      row.set("leaderLabel", _leaderLabel);
      row.set("leaderPhone", _leaderPhone);
      row.set("provinceId", _provinceId);
      row.set("provinceLabel", _provinceLabel);
      row.set("cityId", _cityId);
      row.set("cityLabel", _cityLabel);
      row.set("detailAddress", _detailAddress);
      row.set("locationLongitude", _locationLongitude);
      row.set("locationLatitude", _locationLatitude);
      row.set("departmentPhone", _departmentPhone);
      row.set("buildDate", _buildDate);
      row.set("investmentTotal", _investmentTotal);
      row.set("investmentCount", _investmentCount);
      row.set("investmentDate", _investmentDate);
      row.set("redemptionTotal", _redemptionTotal);
      row.set("redemptionCount", _redemptionCount);
      row.set("redemptionDate", _redemptionDate);
      row.set("netinvestmentTotal", _netinvestmentTotal);
      row.set("interestTotal", _interestTotal);
      row.set("performanceTotal", _performanceTotal);
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
      map.put("linkParentId", RLong.toString(_linkParentId));
      map.put("linkId", RLong.toString(_linkId));
      map.put("code", _code);
      map.put("name", _name);
      map.put("label", _label);
      map.put("departmentId", RInteger.toString(_departmentId));
      map.put("departmentLabel", _departmentLabel);
      map.put("regionId", RInteger.toString(_regionId));
      map.put("regionLabel", _regionLabel);
      map.put("level", RInteger.toString(_level));
      map.put("leaderId", RLong.toString(_leaderId));
      map.put("leaderLabel", _leaderLabel);
      map.put("leaderPhone", _leaderPhone);
      map.put("provinceId", RInteger.toString(_provinceId));
      map.put("provinceLabel", _provinceLabel);
      map.put("cityId", RInteger.toString(_cityId));
      map.put("cityLabel", _cityLabel);
      map.put("detailAddress", _detailAddress);
      map.put("locationLongitude", RDouble.toString(_locationLongitude));
      map.put("locationLatitude", RDouble.toString(_locationLatitude));
      map.put("departmentPhone", _departmentPhone);
      map.put("buildDate", _buildDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("investmentTotal", RDouble.toString(_investmentTotal));
      map.put("investmentCount", RInteger.toString(_investmentCount));
      map.put("investmentDate", _investmentDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("redemptionTotal", RDouble.toString(_redemptionTotal));
      map.put("redemptionCount", RInteger.toString(_redemptionCount));
      map.put("redemptionDate", _redemptionDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("netinvestmentTotal", RDouble.toString(_netinvestmentTotal));
      map.put("interestTotal", RDouble.toString(_interestTotal));
      map.put("performanceTotal", RDouble.toString(_performanceTotal));
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
      _linkParentId = input.readInt64();
      _linkId = input.readInt64();
      _code = input.readString();
      _name = input.readString();
      _label = input.readString();
      _departmentId = input.readInt32();
      _departmentLabel = input.readString();
      _regionId = input.readInt32();
      _regionLabel = input.readString();
      _level = input.readInt32();
      _leaderId = input.readInt64();
      _leaderLabel = input.readString();
      _leaderPhone = input.readString();
      _provinceId = input.readInt32();
      _provinceLabel = input.readString();
      _cityId = input.readInt32();
      _cityLabel = input.readString();
      _detailAddress = input.readString();
      _departmentPhone = input.readString();
      _buildDate.set(input.readInt64());
      _investmentCount = input.readInt32();
      _investmentDate.set(input.readInt64());
      _redemptionCount = input.readInt32();
      _redemptionDate.set(input.readInt64());
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
      output.writeInt64(_linkParentId);
      output.writeInt64(_linkId);
      output.writeString(_code);
      output.writeString(_name);
      output.writeString(_label);
      output.writeInt32(_departmentId);
      output.writeString(_departmentLabel);
      output.writeInt32(_regionId);
      output.writeString(_regionLabel);
      output.writeInt32(_level);
      output.writeInt64(_leaderId);
      output.writeString(_leaderLabel);
      output.writeString(_leaderPhone);
      output.writeInt32(_provinceId);
      output.writeString(_provinceLabel);
      output.writeInt32(_cityId);
      output.writeString(_cityLabel);
      output.writeString(_detailAddress);
      output.writeString(_departmentPhone);
      output.writeInt64(_buildDate.get());
      output.writeInt32(_investmentCount);
      output.writeInt64(_investmentDate.get());
      output.writeInt32(_redemptionCount);
      output.writeInt64(_redemptionDate.get());
      output.writeString(_note);
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
      FDataFinancialDepartmentUnit unit = (FDataFinancialDepartmentUnit)logicUnit;
      unit.setOuid(_ouid);
      unit.setOvld(_ovld);
      unit.setGuid(_guid);
      unit.setLinkParentId(_linkParentId);
      unit.setLinkId(_linkId);
      unit.setCode(_code);
      unit.setName(_name);
      unit.setLabel(_label);
      unit.setDepartmentId(_departmentId);
      unit.setDepartmentLabel(_departmentLabel);
      unit.setRegionId(_regionId);
      unit.setRegionLabel(_regionLabel);
      unit.setLevel(_level);
      unit.setLeaderId(_leaderId);
      unit.setLeaderLabel(_leaderLabel);
      unit.setLeaderPhone(_leaderPhone);
      unit.setProvinceId(_provinceId);
      unit.setProvinceLabel(_provinceLabel);
      unit.setCityId(_cityId);
      unit.setCityLabel(_cityLabel);
      unit.setDetailAddress(_detailAddress);
      unit.setLocationLongitude(_locationLongitude);
      unit.setLocationLatitude(_locationLatitude);
      unit.setDepartmentPhone(_departmentPhone);
      unit.buildDate().assign(_buildDate);
      unit.setInvestmentTotal(_investmentTotal);
      unit.setInvestmentCount(_investmentCount);
      unit.investmentDate().assign(_investmentDate);
      unit.setRedemptionTotal(_redemptionTotal);
      unit.setRedemptionCount(_redemptionCount);
      unit.redemptionDate().assign(_redemptionDate);
      unit.setNetinvestmentTotal(_netinvestmentTotal);
      unit.setInterestTotal(_interestTotal);
      unit.setPerformanceTotal(_performanceTotal);
      unit.setNote(_note);
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
   public FDataFinancialDepartmentUnit clone(){
      FDataFinancialDepartmentUnit unit = RClass.newInstance(FDataFinancialDepartmentUnit.class);
      copy(unit);
      return unit;
   }
}
