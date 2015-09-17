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
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>金融理财师信息逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataFinancialMarketerUnit
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

   // 存储字段名称的定义。
   private String __name;

   // 字段名称的定义。
   protected String _name;

   // 存储字段名称的定义。
   private String __label;

   // 字段名称的定义。
   protected String _label;

   // 存储字段登录名的定义。
   private String __passport;

   // 字段登录名的定义。
   protected String _passport;

   // 存储字段状态的定义。
   private int __statusCd;

   // 字段状态的定义。
   protected int _statusCd;

   // 存储字段电话号码的定义。
   private String __phone;

   // 字段电话号码的定义。
   protected String _phone;

   // 存储字段身份证的定义。
   private String __card;

   // 字段身份证的定义。
   protected String _card;

   // 存储字段职务标签的定义。
   private String __rankLabel;

   // 字段职务标签的定义。
   protected String _rankLabel;

   // 存储字段部门编号的定义。
   private long __departmentId;

   // 字段部门编号的定义。
   protected long _departmentId;

   // 存储字段直属部门标签的定义。
   private String __departmentLabel;

   // 字段直属部门标签的定义。
   protected String _departmentLabel;

   // 存储字段部门标签集合的定义。
   private String __departmentLabels;

   // 字段部门标签集合的定义。
   protected String _departmentLabels;

   // 存储字段客户投资总额的定义。
   private double __customerInvestmentTotal;

   // 字段客户投资总额的定义。
   protected double _customerInvestmentTotal;

   // 存储字段客户投资次数的定义。
   private int __customerInvestmentCount;

   // 字段客户投资次数的定义。
   protected int _customerInvestmentCount;

   // 存储字段投资时间的定义。
   private TDateTime __customerInvestmentDate = new TDateTime();

   // 字段投资时间的定义。
   protected TDateTime _customerInvestmentDate = new TDateTime();

   // 存储字段赎回总额的定义。
   private double __customerRedemptionTotal;

   // 字段赎回总额的定义。
   protected double _customerRedemptionTotal;

   // 存储字段赎回次数的定义。
   private int __customerRedemptionCount;

   // 字段赎回次数的定义。
   protected int _customerRedemptionCount;

   // 存储字段赎回时间的定义。
   private TDateTime __customerRedemptionDate = new TDateTime();

   // 字段赎回时间的定义。
   protected TDateTime _customerRedemptionDate = new TDateTime();

   // 存储字段净投总额的定义。
   private double __customerNetinvestmentTotal;

   // 字段净投总额的定义。
   protected double _customerNetinvestmentTotal;

   // 存储字段利息总额的定义。
   private double __customerInterestTotal;

   // 字段利息总额的定义。
   protected double _customerInterestTotal;

   // 存储字段业绩总额的定义。
   private double __customerPerformanceTotal;

   // 字段业绩总额的定义。
   protected double _customerPerformanceTotal;

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
   // <T>构造金融理财师信息逻辑单元。</T>
   //============================================================
   public FDataFinancialMarketerUnit(){
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
   // <T>判断登录名的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isPassportChanged(){
      return !RString.equals(__passport, _passport);
   }

   //============================================================
   // <T>获得登录名的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String passport(){
      return _passport;
   }

   //============================================================
   // <T>设置登录名的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setPassport(String value){
      _passport = value;
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
   // <T>判断职务标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRankLabelChanged(){
      return !RString.equals(__rankLabel, _rankLabel);
   }

   //============================================================
   // <T>获得职务标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String rankLabel(){
      return _rankLabel;
   }

   //============================================================
   // <T>设置职务标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRankLabel(String value){
      _rankLabel = value;
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
   // <T>判断直属部门标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isDepartmentLabelChanged(){
      return !RString.equals(__departmentLabel, _departmentLabel);
   }

   //============================================================
   // <T>获得直属部门标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String departmentLabel(){
      return _departmentLabel;
   }

   //============================================================
   // <T>设置直属部门标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setDepartmentLabel(String value){
      _departmentLabel = value;
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
   // <T>判断客户投资总额的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerInvestmentTotalChanged(){
      return __customerInvestmentTotal != _customerInvestmentTotal;
   }

   //============================================================
   // <T>获得客户投资总额的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double customerInvestmentTotal(){
      return _customerInvestmentTotal;
   }

   //============================================================
   // <T>设置客户投资总额的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerInvestmentTotal(double value){
      _customerInvestmentTotal = value;
   }

   //============================================================
   // <T>判断客户投资次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerInvestmentCountChanged(){
      return __customerInvestmentCount != _customerInvestmentCount;
   }

   //============================================================
   // <T>获得客户投资次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int customerInvestmentCount(){
      return _customerInvestmentCount;
   }

   //============================================================
   // <T>设置客户投资次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerInvestmentCount(int value){
      _customerInvestmentCount = value;
   }

   //============================================================
   // <T>判断投资时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerInvestmentDateChanged(){
      return !__customerInvestmentDate.equals(_customerInvestmentDate);
   }

   //============================================================
   // <T>获得投资时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime customerInvestmentDate(){
      return _customerInvestmentDate;
   }

   //============================================================
   // <T>设置投资时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerInvestmentDate(TDateTime value){
      _customerInvestmentDate = value;
   }

   //============================================================
   // <T>判断赎回总额的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerRedemptionTotalChanged(){
      return __customerRedemptionTotal != _customerRedemptionTotal;
   }

   //============================================================
   // <T>获得赎回总额的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double customerRedemptionTotal(){
      return _customerRedemptionTotal;
   }

   //============================================================
   // <T>设置赎回总额的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerRedemptionTotal(double value){
      _customerRedemptionTotal = value;
   }

   //============================================================
   // <T>判断赎回次数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerRedemptionCountChanged(){
      return __customerRedemptionCount != _customerRedemptionCount;
   }

   //============================================================
   // <T>获得赎回次数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int customerRedemptionCount(){
      return _customerRedemptionCount;
   }

   //============================================================
   // <T>设置赎回次数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerRedemptionCount(int value){
      _customerRedemptionCount = value;
   }

   //============================================================
   // <T>判断赎回时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerRedemptionDateChanged(){
      return !__customerRedemptionDate.equals(_customerRedemptionDate);
   }

   //============================================================
   // <T>获得赎回时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime customerRedemptionDate(){
      return _customerRedemptionDate;
   }

   //============================================================
   // <T>设置赎回时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerRedemptionDate(TDateTime value){
      _customerRedemptionDate = value;
   }

   //============================================================
   // <T>判断净投总额的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerNetinvestmentTotalChanged(){
      return __customerNetinvestmentTotal != _customerNetinvestmentTotal;
   }

   //============================================================
   // <T>获得净投总额的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double customerNetinvestmentTotal(){
      return _customerNetinvestmentTotal;
   }

   //============================================================
   // <T>设置净投总额的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerNetinvestmentTotal(double value){
      _customerNetinvestmentTotal = value;
   }

   //============================================================
   // <T>判断利息总额的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerInterestTotalChanged(){
      return __customerInterestTotal != _customerInterestTotal;
   }

   //============================================================
   // <T>获得利息总额的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double customerInterestTotal(){
      return _customerInterestTotal;
   }

   //============================================================
   // <T>设置利息总额的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerInterestTotal(double value){
      _customerInterestTotal = value;
   }

   //============================================================
   // <T>判断业绩总额的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isCustomerPerformanceTotalChanged(){
      return __customerPerformanceTotal != _customerPerformanceTotal;
   }

   //============================================================
   // <T>获得业绩总额的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double customerPerformanceTotal(){
      return _customerPerformanceTotal;
   }

   //============================================================
   // <T>设置业绩总额的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setCustomerPerformanceTotal(double value){
      _customerPerformanceTotal = value;
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
         case "user_id":
            return Long.toString(_userId);
         case "link_id":
            return Long.toString(_linkId);
         case "name":
            return _name;
         case "label":
            return _label;
         case "passport":
            return _passport;
         case "status_cd":
            return RInteger.toString(_statusCd);
         case "phone":
            return _phone;
         case "card":
            return _card;
         case "rank_label":
            return _rankLabel;
         case "department_id":
            return Long.toString(_departmentId);
         case "department_label":
            return _departmentLabel;
         case "department_labels":
            return _departmentLabels;
         case "customer_investment_total":
            return RDouble.toString(_customerInvestmentTotal);
         case "customer_investment_count":
            return RInteger.toString(_customerInvestmentCount);
         case "customer_investment_date":
            return _customerInvestmentDate.toString();
         case "customer_redemption_total":
            return RDouble.toString(_customerRedemptionTotal);
         case "customer_redemption_count":
            return RInteger.toString(_customerRedemptionCount);
         case "customer_redemption_date":
            return _customerRedemptionDate.toString();
         case "customer_netinvestment_total":
            return RDouble.toString(_customerNetinvestmentTotal);
         case "customer_interest_total":
            return RDouble.toString(_customerInterestTotal);
         case "customer_performance_total":
            return RDouble.toString(_customerPerformanceTotal);
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
         case "name":
            _name = value;
            break;
         case "label":
            _label = value;
            break;
         case "passport":
            _passport = value;
            break;
         case "status_cd":
            _statusCd = RInteger.parse(value);
            break;
         case "phone":
            _phone = value;
            break;
         case "card":
            _card = value;
            break;
         case "rank_label":
            _rankLabel = value;
            break;
         case "department_id":
            _departmentId = RLong.parse(value);
            break;
         case "department_label":
            _departmentLabel = value;
            break;
         case "department_labels":
            _departmentLabels = value;
            break;
         case "customer_investment_total":
            _customerInvestmentTotal = RDouble.parse(value);
            break;
         case "customer_investment_count":
            _customerInvestmentCount = RInteger.parse(value);
            break;
         case "customer_investment_date":
            _customerInvestmentDate.parse(value);
            break;
         case "customer_redemption_total":
            _customerRedemptionTotal = RDouble.parse(value);
            break;
         case "customer_redemption_count":
            _customerRedemptionCount = RInteger.parse(value);
            break;
         case "customer_redemption_date":
            _customerRedemptionDate.parse(value);
            break;
         case "customer_netinvestment_total":
            _customerNetinvestmentTotal = RDouble.parse(value);
            break;
         case "customer_interest_total":
            _customerInterestTotal = RDouble.parse(value);
            break;
         case "customer_performance_total":
            _customerPerformanceTotal = RDouble.parse(value);
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
            case "name":
               __name = value;
               _name = __name;
               break;
            case "label":
               __label = value;
               _label = __label;
               break;
            case "passport":
               __passport = value;
               _passport = __passport;
               break;
            case "status_cd":
               __statusCd = RInteger.parse(value);
               _statusCd = __statusCd;
               break;
            case "phone":
               __phone = value;
               _phone = __phone;
               break;
            case "card":
               __card = value;
               _card = __card;
               break;
            case "rank_label":
               __rankLabel = value;
               _rankLabel = __rankLabel;
               break;
            case "department_id":
               __departmentId = RLong.parse(value);
               _departmentId = __departmentId;
               break;
            case "department_label":
               __departmentLabel = value;
               _departmentLabel = __departmentLabel;
               break;
            case "department_labels":
               __departmentLabels = value;
               _departmentLabels = __departmentLabels;
               break;
            case "customer_investment_total":
               __customerInvestmentTotal = RDouble.parse(value);
               _customerInvestmentTotal = __customerInvestmentTotal;
               break;
            case "customer_investment_count":
               __customerInvestmentCount = RInteger.parse(value);
               _customerInvestmentCount = __customerInvestmentCount;
               break;
            case "customer_investment_date":
               __customerInvestmentDate.parse(value);
               _customerInvestmentDate.assign(__customerInvestmentDate);
               break;
            case "customer_redemption_total":
               __customerRedemptionTotal = RDouble.parse(value);
               _customerRedemptionTotal = __customerRedemptionTotal;
               break;
            case "customer_redemption_count":
               __customerRedemptionCount = RInteger.parse(value);
               _customerRedemptionCount = __customerRedemptionCount;
               break;
            case "customer_redemption_date":
               __customerRedemptionDate.parse(value);
               _customerRedemptionDate.assign(__customerRedemptionDate);
               break;
            case "customer_netinvestment_total":
               __customerNetinvestmentTotal = RDouble.parse(value);
               _customerNetinvestmentTotal = __customerNetinvestmentTotal;
               break;
            case "customer_interest_total":
               __customerInterestTotal = RDouble.parse(value);
               _customerInterestTotal = __customerInterestTotal;
               break;
            case "customer_performance_total":
               __customerPerformanceTotal = RDouble.parse(value);
               _customerPerformanceTotal = __customerPerformanceTotal;
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
      row.set("name", _name);
      row.set("label", _label);
      row.set("passport", _passport);
      row.set("statusCd", _statusCd);
      row.set("phone", _phone);
      row.set("card", _card);
      row.set("rankLabel", _rankLabel);
      row.set("departmentId", _departmentId);
      row.set("departmentLabel", _departmentLabel);
      row.set("departmentLabels", _departmentLabels);
      row.set("customerInvestmentTotal", _customerInvestmentTotal);
      row.set("customerInvestmentCount", _customerInvestmentCount);
      row.set("customerInvestmentDate", _customerInvestmentDate);
      row.set("customerRedemptionTotal", _customerRedemptionTotal);
      row.set("customerRedemptionCount", _customerRedemptionCount);
      row.set("customerRedemptionDate", _customerRedemptionDate);
      row.set("customerNetinvestmentTotal", _customerNetinvestmentTotal);
      row.set("customerInterestTotal", _customerInterestTotal);
      row.set("customerPerformanceTotal", _customerPerformanceTotal);
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
      map.put("name", _name);
      map.put("label", _label);
      map.put("passport", _passport);
      map.put("statusCd", RInteger.toString(_statusCd));
      map.put("phone", _phone);
      map.put("card", _card);
      map.put("rankLabel", _rankLabel);
      map.put("departmentId", RLong.toString(_departmentId));
      map.put("departmentLabel", _departmentLabel);
      map.put("departmentLabels", _departmentLabels);
      map.put("customerInvestmentTotal", RDouble.toString(_customerInvestmentTotal));
      map.put("customerInvestmentCount", RInteger.toString(_customerInvestmentCount));
      map.put("customerInvestmentDate", _customerInvestmentDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("customerRedemptionTotal", RDouble.toString(_customerRedemptionTotal));
      map.put("customerRedemptionCount", RInteger.toString(_customerRedemptionCount));
      map.put("customerRedemptionDate", _customerRedemptionDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("customerNetinvestmentTotal", RDouble.toString(_customerNetinvestmentTotal));
      map.put("customerInterestTotal", RDouble.toString(_customerInterestTotal));
      map.put("customerPerformanceTotal", RDouble.toString(_customerPerformanceTotal));
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
      _name = input.readString();
      _label = input.readString();
      _passport = input.readString();
      _statusCd = input.readInt32();
      _phone = input.readString();
      _card = input.readString();
      _rankLabel = input.readString();
      _departmentId = input.readInt64();
      _departmentLabel = input.readString();
      _departmentLabels = input.readString();
      _customerInvestmentCount = input.readInt32();
      _customerInvestmentDate.set(input.readInt64());
      _customerRedemptionCount = input.readInt32();
      _customerRedemptionDate.set(input.readInt64());
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
      output.writeString(_name);
      output.writeString(_label);
      output.writeString(_passport);
      output.writeInt32(_statusCd);
      output.writeString(_phone);
      output.writeString(_card);
      output.writeString(_rankLabel);
      output.writeInt64(_departmentId);
      output.writeString(_departmentLabel);
      output.writeString(_departmentLabels);
      output.writeInt32(_customerInvestmentCount);
      output.writeInt64(_customerInvestmentDate.get());
      output.writeInt32(_customerRedemptionCount);
      output.writeInt64(_customerRedemptionDate.get());
      output.writeString(_note);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }
}
