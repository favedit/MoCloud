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
import org.mo.com.lang.type.TDateTime;
import org.mo.core.aop.face.ASourceMachine;
import org.mo.data.logic.FLogicUnit;

//============================================================
// <T>金融客户信息逻辑单元。</T>
//============================================================
@ASourceMachine
public class FDataFinancialCustomerUnit extends FLogicUnit
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

   // 存储字段理财师编号的定义。
   private long __marketerId;

   // 字段理财师编号的定义。
   protected long _marketerId;

   // 存储字段理财师关联编号的定义。
   private long __marketerLid;

   // 字段理财师关联编号的定义。
   protected long _marketerLid;

   // 存储字段关联编号的定义。
   private long __linkId;

   // 字段关联编号的定义。
   protected long _linkId;

   // 存储字段统计编号的定义。
   private int __statisticsId;

   // 字段统计编号的定义。
   protected int _statisticsId;

   // 存储字段婚姻状态的定义。
   private int __marryCd;

   // 字段婚姻状态的定义。
   protected int _marryCd;

   // 存储字段教育类型的定义。
   private int __educationCd;

   // 字段教育类型的定义。
   protected int _educationCd;

   // 存储字段收入类型的定义。
   private int __incomeCd;

   // 字段收入类型的定义。
   protected int _incomeCd;

   // 存储字段职业类型的定义。
   private int __businessCd;

   // 字段职业类型的定义。
   protected int _businessCd;

   // 存储字段最后发送短信的时间的定义。
   private TDateTime __lastMessageDate = new TDateTime();

   // 字段最后发送短信的时间的定义。
   protected TDateTime _lastMessageDate = new TDateTime();

   // 存储字段投资总额的定义。
   private double __investmentTotal;

   // 字段投资总额的定义。
   protected double _investmentTotal;

   // 存储字段投资次数的定义。
   private int __investmentCount;

   // 字段投资次数的定义。
   protected int _investmentCount;

   // 存储字段赎回总额的定义。
   private float __redemptionTotal;

   // 字段赎回总额的定义。
   protected float _redemptionTotal;

   // 存储字段赎回次数的定义。
   private int __redemptionCount;

   // 字段赎回次数的定义。
   protected int _redemptionCount;

   // 存储字段净投总额的定义。
   private float __netinvestment;

   // 字段净投总额的定义。
   protected float _netinvestment;

   // 存储字段利息总额的定义。
   private float __interestTotal;

   // 字段利息总额的定义。
   protected float _interestTotal;

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
   // <T>构造金融客户信息逻辑单元。</T>
   //============================================================
   public FDataFinancialCustomerUnit(){
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
   // <T>获得理财师编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataFinancialMarketerUnit marketer(){
      FDataFinancialMarketerLogic logic = _logicContext.findLogic(FDataFinancialMarketerLogic.class);
      FDataFinancialMarketerUnit unit = logic.find(_marketerId);
      return unit;
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
   public boolean isMarketerLidChanged(){
      return __marketerLid != _marketerLid;
   }

   //============================================================
   // <T>获得理财师关联编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long marketerLid(){
      return _marketerLid;
   }

   //============================================================
   // <T>设置理财师关联编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarketerLid(long value){
      _marketerLid = value;
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
   // <T>判断统计编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isStatisticsIdChanged(){
      return __statisticsId != _statisticsId;
   }

   //============================================================
   // <T>获得统计编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int statisticsId(){
      return _statisticsId;
   }

   //============================================================
   // <T>设置统计编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setStatisticsId(int value){
      _statisticsId = value;
   }

   //============================================================
   // <T>判断婚姻状态的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarryCdChanged(){
      return __marryCd != _marryCd;
   }

   //============================================================
   // <T>获得婚姻状态的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int marryCd(){
      return _marryCd;
   }

   //============================================================
   // <T>设置婚姻状态的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarryCd(int value){
      _marryCd = value;
   }

   //============================================================
   // <T>判断教育类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isEducationCdChanged(){
      return __educationCd != _educationCd;
   }

   //============================================================
   // <T>获得教育类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int educationCd(){
      return _educationCd;
   }

   //============================================================
   // <T>设置教育类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setEducationCd(int value){
      _educationCd = value;
   }

   //============================================================
   // <T>判断收入类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isIncomeCdChanged(){
      return __incomeCd != _incomeCd;
   }

   //============================================================
   // <T>获得收入类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int incomeCd(){
      return _incomeCd;
   }

   //============================================================
   // <T>设置收入类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setIncomeCd(int value){
      _incomeCd = value;
   }

   //============================================================
   // <T>判断职业类型的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isBusinessCdChanged(){
      return __businessCd != _businessCd;
   }

   //============================================================
   // <T>获得职业类型的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int businessCd(){
      return _businessCd;
   }

   //============================================================
   // <T>设置职业类型的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setBusinessCd(int value){
      _businessCd = value;
   }

   //============================================================
   // <T>判断最后发送短信的时间的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isLastMessageDateChanged(){
      return !__lastMessageDate.equals(_lastMessageDate);
   }

   //============================================================
   // <T>获得最后发送短信的时间的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public TDateTime lastMessageDate(){
      return _lastMessageDate;
   }

   //============================================================
   // <T>设置最后发送短信的时间的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setLastMessageDate(TDateTime value){
      _lastMessageDate = value;
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
   public float redemptionTotal(){
      return _redemptionTotal;
   }

   //============================================================
   // <T>设置赎回总额的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setRedemptionTotal(float value){
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
   // <T>判断净投总额的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isNetinvestmentChanged(){
      return __netinvestment != _netinvestment;
   }

   //============================================================
   // <T>获得净投总额的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public float netinvestment(){
      return _netinvestment;
   }

   //============================================================
   // <T>设置净投总额的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setNetinvestment(float value){
      _netinvestment = value;
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
   public float interestTotal(){
      return _interestTotal;
   }

   //============================================================
   // <T>设置利息总额的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setInterestTotal(float value){
      _interestTotal = value;
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
         case "marketer_id":
            return Long.toString(_marketerId);
         case "marketer_lid":
            return Long.toString(_marketerLid);
         case "link_id":
            return Long.toString(_linkId);
         case "statistics_id":
            return RInteger.toString(_statisticsId);
         case "marry_cd":
            return RInteger.toString(_marryCd);
         case "education_cd":
            return RInteger.toString(_educationCd);
         case "income_cd":
            return RInteger.toString(_incomeCd);
         case "business_cd":
            return RInteger.toString(_businessCd);
         case "last_message_date":
            return _lastMessageDate.toString();
         case "investment_total":
            return RDouble.toString(_investmentTotal);
         case "investment_count":
            return RInteger.toString(_investmentCount);
         case "redemption_total":
            return RFloat.toString(_redemptionTotal);
         case "redemption_count":
            return RInteger.toString(_redemptionCount);
         case "netinvestment":
            return RFloat.toString(_netinvestment);
         case "interest_total":
            return RFloat.toString(_interestTotal);
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
         case "marketer_id":
            _marketerId = RLong.parse(value);
            break;
         case "marketer_lid":
            _marketerLid = RLong.parse(value);
            break;
         case "link_id":
            _linkId = RLong.parse(value);
            break;
         case "statistics_id":
            _statisticsId = RInteger.parse(value);
            break;
         case "marry_cd":
            _marryCd = RInteger.parse(value);
            break;
         case "education_cd":
            _educationCd = RInteger.parse(value);
            break;
         case "income_cd":
            _incomeCd = RInteger.parse(value);
            break;
         case "business_cd":
            _businessCd = RInteger.parse(value);
            break;
         case "last_message_date":
            _lastMessageDate.parse(value);
            break;
         case "investment_total":
            _investmentTotal = RDouble.parse(value);
            break;
         case "investment_count":
            _investmentCount = RInteger.parse(value);
            break;
         case "redemption_total":
            _redemptionTotal = RFloat.parse(value);
            break;
         case "redemption_count":
            _redemptionCount = RInteger.parse(value);
            break;
         case "netinvestment":
            _netinvestment = RFloat.parse(value);
            break;
         case "interest_total":
            _interestTotal = RFloat.parse(value);
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
            case "marketer_id":
               __marketerId = RLong.parse(value);
               _marketerId = __marketerId;
               break;
            case "marketer_lid":
               __marketerLid = RLong.parse(value);
               _marketerLid = __marketerLid;
               break;
            case "link_id":
               __linkId = RLong.parse(value);
               _linkId = __linkId;
               break;
            case "statistics_id":
               __statisticsId = RInteger.parse(value);
               _statisticsId = __statisticsId;
               break;
            case "marry_cd":
               __marryCd = RInteger.parse(value);
               _marryCd = __marryCd;
               break;
            case "education_cd":
               __educationCd = RInteger.parse(value);
               _educationCd = __educationCd;
               break;
            case "income_cd":
               __incomeCd = RInteger.parse(value);
               _incomeCd = __incomeCd;
               break;
            case "business_cd":
               __businessCd = RInteger.parse(value);
               _businessCd = __businessCd;
               break;
            case "last_message_date":
               __lastMessageDate.parse(value);
               _lastMessageDate.assign(__lastMessageDate);
               break;
            case "investment_total":
               __investmentTotal = RDouble.parse(value);
               _investmentTotal = __investmentTotal;
               break;
            case "investment_count":
               __investmentCount = RInteger.parse(value);
               _investmentCount = __investmentCount;
               break;
            case "redemption_total":
               __redemptionTotal = RFloat.parse(value);
               _redemptionTotal = __redemptionTotal;
               break;
            case "redemption_count":
               __redemptionCount = RInteger.parse(value);
               _redemptionCount = __redemptionCount;
               break;
            case "netinvestment":
               __netinvestment = RFloat.parse(value);
               _netinvestment = __netinvestment;
               break;
            case "interest_total":
               __interestTotal = RFloat.parse(value);
               _interestTotal = __interestTotal;
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
      row.set("marketerId", _marketerId);
      row.set("marketerLid", _marketerLid);
      row.set("linkId", _linkId);
      row.set("statisticsId", _statisticsId);
      row.set("marryCd", _marryCd);
      row.set("educationCd", _educationCd);
      row.set("incomeCd", _incomeCd);
      row.set("businessCd", _businessCd);
      row.set("lastMessageDate", _lastMessageDate);
      row.set("investmentTotal", _investmentTotal);
      row.set("investmentCount", _investmentCount);
      row.set("redemptionTotal", _redemptionTotal);
      row.set("redemptionCount", _redemptionCount);
      row.set("netinvestment", _netinvestment);
      row.set("interestTotal", _interestTotal);
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
      map.put("marketerId", RLong.toString(_marketerId));
      map.put("marketerLid", RLong.toString(_marketerLid));
      map.put("linkId", RLong.toString(_linkId));
      map.put("statisticsId", RInteger.toString(_statisticsId));
      map.put("marryCd", RInteger.toString(_marryCd));
      map.put("educationCd", RInteger.toString(_educationCd));
      map.put("incomeCd", RInteger.toString(_incomeCd));
      map.put("businessCd", RInteger.toString(_businessCd));
      map.put("lastMessageDate", _lastMessageDate.format("YYYY-MM-DD HH24:MI:SS"));
      map.put("investmentTotal", RDouble.toString(_investmentTotal));
      map.put("investmentCount", RInteger.toString(_investmentCount));
      map.put("redemptionTotal", RFloat.toString(_redemptionTotal));
      map.put("redemptionCount", RInteger.toString(_redemptionCount));
      map.put("netinvestment", RFloat.toString(_netinvestment));
      map.put("interestTotal", RFloat.toString(_interestTotal));
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
      _marketerId = input.readInt64();
      _marketerLid = input.readInt64();
      _linkId = input.readInt64();
      _statisticsId = input.readInt32();
      _marryCd = input.readInt32();
      _educationCd = input.readInt32();
      _incomeCd = input.readInt32();
      _businessCd = input.readInt32();
      _lastMessageDate.set(input.readInt64());
      _investmentCount = input.readInt32();
      _redemptionCount = input.readInt32();
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
      output.writeInt64(_marketerId);
      output.writeInt64(_marketerLid);
      output.writeInt64(_linkId);
      output.writeInt32(_statisticsId);
      output.writeInt32(_marryCd);
      output.writeInt32(_educationCd);
      output.writeInt32(_incomeCd);
      output.writeInt32(_businessCd);
      output.writeInt64(_lastMessageDate.get());
      output.writeInt32(_investmentCount);
      output.writeInt32(_redemptionCount);
      output.writeString(_note);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }
}
