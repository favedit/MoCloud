package com.cyou.gccloud.data.data;

import java.util.Map;
import org.mo.com.collections.FRow;
import org.mo.com.io.IDataInput;
import org.mo.com.io.IDataOutput;
import org.mo.com.lang.IStringPair;
import org.mo.com.lang.RBoolean;
import org.mo.com.lang.RDouble;
import org.mo.com.lang.RFloat;
import org.mo.com.lang.RInteger;
import org.mo.com.lang.RLong;
import org.mo.com.lang.RString;
import org.mo.com.lang.reflect.RClass;
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>金融投标信息逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataFinancialTenderUnit
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

   // 存储字段期次编号的定义。
   private long __linkId;

   // 字段期次编号的定义。
   protected long _linkId;

   // 存储字段产品编号的定义。
   private int __productId;

   // 字段产品编号的定义。
   protected int _productId;

   // 存储字段名称的定义。
   private String __label;

   // 字段名称的定义。
   protected String _label;

   // 存储字段预借钱数的定义。
   private double __borrowMoney;

   // 字段预借钱数的定义。
   protected double _borrowMoney;

   // 存储字段投资开始日期的定义。
   private TDateTime __investmentBeginDate = new TDateTime();

   // 字段投资开始日期的定义。
   protected TDateTime _investmentBeginDate = new TDateTime();

   // 存储字段投资结束日期的定义。
   private TDateTime __investmentEndDate = new TDateTime();

   // 字段投资结束日期的定义。
   protected TDateTime _investmentEndDate = new TDateTime();

   // 存储字段投资次数的定义。
   private int __investmentCount;

   // 字段投资次数的定义。
   protected int _investmentCount;

   // 存储字段投资用户数的定义。
   private int __investmentUserCount;

   // 字段投资用户数的定义。
   protected int _investmentUserCount;

   // 存储字段投资总额的定义。
   private double __investmentTotal;

   // 字段投资总额的定义。
   protected double _investmentTotal;

   // 存储字段赎回开时日期的定义。
   private TDateTime __redemptionBeginDate = new TDateTime();

   // 字段赎回开时日期的定义。
   protected TDateTime _redemptionBeginDate = new TDateTime();

   // 存储字段赎回结束日期的定义。
   private TDateTime __redemptionEndDate = new TDateTime();

   // 字段赎回结束日期的定义。
   protected TDateTime _redemptionEndDate = new TDateTime();

   // 存储字段赎回次数的定义。
   private int __redemptionCount;

   // 字段赎回次数的定义。
   protected int _redemptionCount;

   // 存储字段赎回用户数的定义。
   private int __redemptionUserCount;

   // 字段赎回用户数的定义。
   protected int _redemptionUserCount;

   // 存储字段赎回总额的定义。
   private double __redemptionTotal;

   // 字段赎回总额的定义。
   protected double _redemptionTotal;

   // 存储字段利息总额的定义。
   private double __interestTotal;

   // 字段利息总额的定义。
   protected double _interestTotal;

   // 存储字段净投总额的定义。
   private double __netinvestmentTotal;

   // 字段净投总额的定义。
   protected double _netinvestmentTotal;

   // 存储字段净投额的定义。
   private float __netinvestment;

   // 字段净投额的定义。
   protected float _netinvestment;

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
   // <T>构造金融投标信息逻辑单元。</T>
   //============================================================
   public FDataFinancialTenderUnit(){
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
   // <T>判断期次编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLinkIdChanged(){
      return __linkId != _linkId;
   }

   //============================================================
   // <T>获得期次编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long linkId(){
      return _linkId;
   }

   //============================================================
   // <T>设置期次编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLinkId(long value){
      _linkId = value;
   }

   //============================================================
   // <T>判断产品编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProductIdChanged(){
      return __productId != _productId;
   }

   //============================================================
   // <T>获得产品编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int productId(){
      return _productId;
   }

   //============================================================
   // <T>获得产品编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataFinancialProductUnit product(){
      FDataFinancialProductLogic logic = _logicContext.findLogic(FDataFinancialProductLogic.class);
      FDataFinancialProductUnit unit = logic.find(_productId);
      return unit;
   }

   //============================================================
   // <T>设置产品编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProductId(int value){
      _productId = value;
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
   // <T>判断预借钱数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBorrowMoneyChanged(){
      return __borrowMoney != _borrowMoney;
   }

   //============================================================
   // <T>获得预借钱数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public double borrowMoney(){
      return _borrowMoney;
   }

   //============================================================
   // <T>设置预借钱数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBorrowMoney(double value){
      _borrowMoney = value;
   }

   //============================================================
   // <T>判断投资开始日期的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInvestmentBeginDateChanged(){
      return !__investmentBeginDate.equals(_investmentBeginDate);
   }

   //============================================================
   // <T>获得投资开始日期的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime investmentBeginDate(){
      return _investmentBeginDate;
   }

   //============================================================
   // <T>设置投资开始日期的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInvestmentBeginDate(TDateTime value){
      _investmentBeginDate = value;
   }

   //============================================================
   // <T>判断投资结束日期的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInvestmentEndDateChanged(){
      return !__investmentEndDate.equals(_investmentEndDate);
   }

   //============================================================
   // <T>获得投资结束日期的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime investmentEndDate(){
      return _investmentEndDate;
   }

   //============================================================
   // <T>设置投资结束日期的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInvestmentEndDate(TDateTime value){
      _investmentEndDate = value;
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
   // <T>判断投资用户数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isInvestmentUserCountChanged(){
      return __investmentUserCount != _investmentUserCount;
   }

   //============================================================
   // <T>获得投资用户数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int investmentUserCount(){
      return _investmentUserCount;
   }

   //============================================================
   // <T>设置投资用户数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInvestmentUserCount(int value){
      _investmentUserCount = value;
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
   // <T>判断赎回开时日期的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRedemptionBeginDateChanged(){
      return !__redemptionBeginDate.equals(_redemptionBeginDate);
   }

   //============================================================
   // <T>获得赎回开时日期的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime redemptionBeginDate(){
      return _redemptionBeginDate;
   }

   //============================================================
   // <T>设置赎回开时日期的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRedemptionBeginDate(TDateTime value){
      _redemptionBeginDate = value;
   }

   //============================================================
   // <T>判断赎回结束日期的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRedemptionEndDateChanged(){
      return !__redemptionEndDate.equals(_redemptionEndDate);
   }

   //============================================================
   // <T>获得赎回结束日期的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime redemptionEndDate(){
      return _redemptionEndDate;
   }

   //============================================================
   // <T>设置赎回结束日期的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRedemptionEndDate(TDateTime value){
      _redemptionEndDate = value;
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
   // <T>判断赎回用户数的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isRedemptionUserCountChanged(){
      return __redemptionUserCount != _redemptionUserCount;
   }

   //============================================================
   // <T>获得赎回用户数的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int redemptionUserCount(){
      return _redemptionUserCount;
   }

   //============================================================
   // <T>设置赎回用户数的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRedemptionUserCount(int value){
      _redemptionUserCount = value;
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
   // <T>判断净投额的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isNetinvestmentChanged(){
      return __netinvestment != _netinvestment;
   }

   //============================================================
   // <T>获得净投额的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public float netinvestment(){
      return _netinvestment;
   }

   //============================================================
   // <T>设置净投额的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setNetinvestment(float value){
      _netinvestment = value;
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
         case "product_id":
            return RInteger.toString(_productId);
         case "label":
            return _label;
         case "borrow_money":
            return RDouble.toString(_borrowMoney);
         case "investment_begin_date":
            return _investmentBeginDate.toString();
         case "investment_end_date":
            return _investmentEndDate.toString();
         case "investment_count":
            return RInteger.toString(_investmentCount);
         case "investment_user_count":
            return RInteger.toString(_investmentUserCount);
         case "investment_total":
            return RDouble.toString(_investmentTotal);
         case "redemption_begin_date":
            return _redemptionBeginDate.toString();
         case "redemption_end_date":
            return _redemptionEndDate.toString();
         case "redemption_count":
            return RInteger.toString(_redemptionCount);
         case "redemption_user_count":
            return RInteger.toString(_redemptionUserCount);
         case "redemption_total":
            return RDouble.toString(_redemptionTotal);
         case "interest_total":
            return RDouble.toString(_interestTotal);
         case "netinvestment_total":
            return RDouble.toString(_netinvestmentTotal);
         case "netinvestment":
            return RFloat.toString(_netinvestment);
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
         case "product_id":
            _productId = RInteger.parse(value);
            break;
         case "label":
            _label = value;
            break;
         case "borrow_money":
            _borrowMoney = RDouble.parse(value);
            break;
         case "investment_begin_date":
            _investmentBeginDate.parse(value);
            break;
         case "investment_end_date":
            _investmentEndDate.parse(value);
            break;
         case "investment_count":
            _investmentCount = RInteger.parse(value);
            break;
         case "investment_user_count":
            _investmentUserCount = RInteger.parse(value);
            break;
         case "investment_total":
            _investmentTotal = RDouble.parse(value);
            break;
         case "redemption_begin_date":
            _redemptionBeginDate.parse(value);
            break;
         case "redemption_end_date":
            _redemptionEndDate.parse(value);
            break;
         case "redemption_count":
            _redemptionCount = RInteger.parse(value);
            break;
         case "redemption_user_count":
            _redemptionUserCount = RInteger.parse(value);
            break;
         case "redemption_total":
            _redemptionTotal = RDouble.parse(value);
            break;
         case "interest_total":
            _interestTotal = RDouble.parse(value);
            break;
         case "netinvestment_total":
            _netinvestmentTotal = RDouble.parse(value);
            break;
         case "netinvestment":
            _netinvestment = RFloat.parse(value);
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
            case "product_id":
               __productId = RInteger.parse(value);
               _productId = __productId;
               break;
            case "label":
               __label = value;
               _label = __label;
               break;
            case "borrow_money":
               __borrowMoney = RDouble.parse(value);
               _borrowMoney = __borrowMoney;
               break;
            case "investment_begin_date":
               __investmentBeginDate.parse(value);
               _investmentBeginDate.assign(__investmentBeginDate);
               break;
            case "investment_end_date":
               __investmentEndDate.parse(value);
               _investmentEndDate.assign(__investmentEndDate);
               break;
            case "investment_count":
               __investmentCount = RInteger.parse(value);
               _investmentCount = __investmentCount;
               break;
            case "investment_user_count":
               __investmentUserCount = RInteger.parse(value);
               _investmentUserCount = __investmentUserCount;
               break;
            case "investment_total":
               __investmentTotal = RDouble.parse(value);
               _investmentTotal = __investmentTotal;
               break;
            case "redemption_begin_date":
               __redemptionBeginDate.parse(value);
               _redemptionBeginDate.assign(__redemptionBeginDate);
               break;
            case "redemption_end_date":
               __redemptionEndDate.parse(value);
               _redemptionEndDate.assign(__redemptionEndDate);
               break;
            case "redemption_count":
               __redemptionCount = RInteger.parse(value);
               _redemptionCount = __redemptionCount;
               break;
            case "redemption_user_count":
               __redemptionUserCount = RInteger.parse(value);
               _redemptionUserCount = __redemptionUserCount;
               break;
            case "redemption_total":
               __redemptionTotal = RDouble.parse(value);
               _redemptionTotal = __redemptionTotal;
               break;
            case "interest_total":
               __interestTotal = RDouble.parse(value);
               _interestTotal = __interestTotal;
               break;
            case "netinvestment_total":
               __netinvestmentTotal = RDouble.parse(value);
               _netinvestmentTotal = __netinvestmentTotal;
               break;
            case "netinvestment":
               __netinvestment = RFloat.parse(value);
               _netinvestment = __netinvestment;
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
      row.set("productId", _productId);
      row.set("label", _label);
      row.set("borrowMoney", _borrowMoney);
      row.set("investmentBeginDate", _investmentBeginDate);
      row.set("investmentEndDate", _investmentEndDate);
      row.set("investmentCount", _investmentCount);
      row.set("investmentUserCount", _investmentUserCount);
      row.set("investmentTotal", _investmentTotal);
      row.set("redemptionBeginDate", _redemptionBeginDate);
      row.set("redemptionEndDate", _redemptionEndDate);
      row.set("redemptionCount", _redemptionCount);
      row.set("redemptionUserCount", _redemptionUserCount);
      row.set("redemptionTotal", _redemptionTotal);
      row.set("interestTotal", _interestTotal);
      row.set("netinvestmentTotal", _netinvestmentTotal);
      row.set("netinvestment", _netinvestment);
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
      map.put("productId", RInteger.toString(_productId));
      map.put("label", _label);
      map.put("borrowMoney", RDouble.toString(_borrowMoney));
      map.put("investmentBeginDate", _investmentBeginDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("investmentEndDate", _investmentEndDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("investmentCount", RInteger.toString(_investmentCount));
      map.put("investmentUserCount", RInteger.toString(_investmentUserCount));
      map.put("investmentTotal", RDouble.toString(_investmentTotal));
      map.put("redemptionBeginDate", _redemptionBeginDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("redemptionEndDate", _redemptionEndDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("redemptionCount", RInteger.toString(_redemptionCount));
      map.put("redemptionUserCount", RInteger.toString(_redemptionUserCount));
      map.put("redemptionTotal", RDouble.toString(_redemptionTotal));
      map.put("interestTotal", RDouble.toString(_interestTotal));
      map.put("netinvestmentTotal", RDouble.toString(_netinvestmentTotal));
      map.put("netinvestment", RFloat.toString(_netinvestment));
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
      _productId = input.readInt32();
      _label = input.readString();
      _investmentBeginDate.set(input.readInt64());
      _investmentEndDate.set(input.readInt64());
      _investmentCount = input.readInt32();
      _investmentUserCount = input.readInt32();
      _redemptionBeginDate.set(input.readInt64());
      _redemptionEndDate.set(input.readInt64());
      _redemptionCount = input.readInt32();
      _redemptionUserCount = input.readInt32();
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
      output.writeInt32(_productId);
      output.writeString(_label);
      output.writeInt64(_investmentBeginDate.get());
      output.writeInt64(_investmentEndDate.get());
      output.writeInt32(_investmentCount);
      output.writeInt32(_investmentUserCount);
      output.writeInt64(_redemptionBeginDate.get());
      output.writeInt64(_redemptionEndDate.get());
      output.writeInt32(_redemptionCount);
      output.writeInt32(_redemptionUserCount);
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
      FDataFinancialTenderUnit unit = (FDataFinancialTenderUnit)logicUnit;
      unit.setOuid(_ouid);
      unit.setOvld(_ovld);
      unit.setGuid(_guid);
      unit.setLinkId(_linkId);
      unit.setProductId(_productId);
      unit.setLabel(_label);
      unit.setBorrowMoney(_borrowMoney);
      unit.investmentBeginDate().assign(_investmentBeginDate);
      unit.investmentEndDate().assign(_investmentEndDate);
      unit.setInvestmentCount(_investmentCount);
      unit.setInvestmentUserCount(_investmentUserCount);
      unit.setInvestmentTotal(_investmentTotal);
      unit.redemptionBeginDate().assign(_redemptionBeginDate);
      unit.redemptionEndDate().assign(_redemptionEndDate);
      unit.setRedemptionCount(_redemptionCount);
      unit.setRedemptionUserCount(_redemptionUserCount);
      unit.setRedemptionTotal(_redemptionTotal);
      unit.setInterestTotal(_interestTotal);
      unit.setNetinvestmentTotal(_netinvestmentTotal);
      unit.setNetinvestment(_netinvestment);
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
   public FDataFinancialTenderUnit clone(){
      FDataFinancialTenderUnit unit = RClass.newInstance(FDataFinancialTenderUnit.class);
      copy(unit);
      return unit;
   }
}
