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

   // 存储字段关联顶层编号的定义。
   private long __linkTopId;

   // 字段关联顶层编号的定义。
   protected long _linkTopId;

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

   // 存储字段关联编号路径的定义。
   private String __linkIdPath;

   // 字段关联编号路径的定义。
   protected String _linkIdPath;

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

   // 存储字段顶层标签的定义。
   private String __topLabel;

   // 字段顶层标签的定义。
   protected String _topLabel;

   // 存储字段标签的定义。
   private String __label;

   // 字段标签的定义。
   protected String _label;

   // 存储字段标签路径的定义。
   private String __labelPath;

   // 字段标签路径的定义。
   protected String _labelPath;

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
   // <T>判断关联顶层编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLinkTopIdChanged(){
      return __linkTopId != _linkTopId;
   }

   //============================================================
   // <T>获得关联顶层编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long linkTopId(){
      return _linkTopId;
   }

   //============================================================
   // <T>设置关联顶层编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLinkTopId(long value){
      _linkTopId = value;
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
   // <T>判断关联编号路径的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLinkIdPathChanged(){
      return !RString.equals(__linkIdPath, _linkIdPath);
   }

   //============================================================
   // <T>获得关联编号路径的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String linkIdPath(){
      return _linkIdPath;
   }

   //============================================================
   // <T>设置关联编号路径的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLinkIdPath(String value){
      _linkIdPath = value;
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
   // <T>判断顶层标签的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isTopLabelChanged(){
      return !RString.equals(__topLabel, _topLabel);
   }

   //============================================================
   // <T>获得顶层标签的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String topLabel(){
      return _topLabel;
   }

   //============================================================
   // <T>设置顶层标签的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setTopLabel(String value){
      _topLabel = value;
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
   // <T>判断标签路径的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLabelPathChanged(){
      return !RString.equals(__labelPath, _labelPath);
   }

   //============================================================
   // <T>获得标签路径的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public String labelPath(){
      return _labelPath;
   }

   //============================================================
   // <T>设置标签路径的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLabelPath(String value){
      _labelPath = value;
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
         case "link_top_id":
            return Long.toString(_linkTopId);
         case "link_parent_id":
            return Long.toString(_linkParentId);
         case "link_id":
            return Long.toString(_linkId);
         case "link_date":
            return _linkDate.toString();
         case "link_id_path":
            return _linkIdPath;
         case "link_cd":
            return RInteger.toString(_linkCd);
         case "data_id":
            return Long.toString(_dataId);
         case "parent_id":
            return Long.toString(_parentId);
         case "code":
            return _code;
         case "top_label":
            return _topLabel;
         case "label":
            return _label;
         case "label_path":
            return _labelPath;
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
         case "link_top_id":
            _linkTopId = RLong.parse(value);
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
         case "link_id_path":
            _linkIdPath = value;
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
         case "top_label":
            _topLabel = value;
            break;
         case "label":
            _label = value;
            break;
         case "label_path":
            _labelPath = value;
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
            case "link_top_id":
               __linkTopId = RLong.parse(value);
               _linkTopId = __linkTopId;
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
            case "link_id_path":
               __linkIdPath = value;
               _linkIdPath = __linkIdPath;
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
            case "top_label":
               __topLabel = value;
               _topLabel = __topLabel;
               break;
            case "label":
               __label = value;
               _label = __label;
               break;
            case "label_path":
               __labelPath = value;
               _labelPath = __labelPath;
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
      row.set("linkTopId", _linkTopId);
      row.set("linkParentId", _linkParentId);
      row.set("linkId", _linkId);
      row.set("linkDate", _linkDate);
      row.set("linkIdPath", _linkIdPath);
      row.set("linkCd", _linkCd);
      row.set("dataId", _dataId);
      row.set("parentId", _parentId);
      row.set("code", _code);
      row.set("topLabel", _topLabel);
      row.set("label", _label);
      row.set("labelPath", _labelPath);
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
      map.put("linkTopId", RLong.toString(_linkTopId));
      map.put("linkParentId", RLong.toString(_linkParentId));
      map.put("linkId", RLong.toString(_linkId));
      map.put("linkDate", _linkDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("linkIdPath", _linkIdPath);
      map.put("linkCd", RInteger.toString(_linkCd));
      map.put("dataId", RLong.toString(_dataId));
      map.put("parentId", RLong.toString(_parentId));
      map.put("code", _code);
      map.put("topLabel", _topLabel);
      map.put("label", _label);
      map.put("labelPath", _labelPath);
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
      _linkTopId = input.readInt64();
      _linkParentId = input.readInt64();
      _linkId = input.readInt64();
      _linkDate.set(input.readInt64());
      _linkIdPath = input.readString();
      _linkCd = input.readInt32();
      _dataId = input.readInt64();
      _parentId = input.readInt64();
      _code = input.readString();
      _topLabel = input.readString();
      _label = input.readString();
      _labelPath = input.readString();
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
      output.writeInt64(_linkTopId);
      output.writeInt64(_linkParentId);
      output.writeInt64(_linkId);
      output.writeInt64(_linkDate.get());
      output.writeString(_linkIdPath);
      output.writeInt32(_linkCd);
      output.writeInt64(_dataId);
      output.writeInt64(_parentId);
      output.writeString(_code);
      output.writeString(_topLabel);
      output.writeString(_label);
      output.writeString(_labelPath);
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
      unit.setLinkTopId(_linkTopId);
      unit.setLinkParentId(_linkParentId);
      unit.setLinkId(_linkId);
      unit.linkDate().assign(_linkDate);
      unit.setLinkIdPath(_linkIdPath);
      unit.setLinkCd(_linkCd);
      unit.setDataId(_dataId);
      unit.setParentId(_parentId);
      unit.setCode(_code);
      unit.setTopLabel(_topLabel);
      unit.setLabel(_label);
      unit.setLabelPath(_labelPath);
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
