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
public class FDataFinancialCustomerUnit
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

   // 存储字段成员编号的定义。
   private long __memberId;

   // 字段成员编号的定义。
   protected long _memberId;

   // 存储字段婚姻状态的定义。
   private int __marriageStatus;

   // 字段婚姻状态的定义。
   protected int _marriageStatus;

   // 存储字段最高学历的定义。
   private int __highestEducation;

   // 字段最高学历的定义。
   protected int _highestEducation;

   // 存储字段月收入的定义。
   private int __monthlyIncome;

   // 字段月收入的定义。
   protected int _monthlyIncome;

   // 存储字段职业的定义。
   private int __profession;

   // 字段职业的定义。
   protected int _profession;

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
   // <T>判断成员编号的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMemberIdChanged(){
      return __memberId != _memberId;
   }

   //============================================================
   // <T>获得成员编号的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public long memberId(){
      return _memberId;
   }

   //============================================================
   // <T>获得成员编号的数据单元。</T>
   //
   // @return 数据内容
   //============================================================
   public FDataFinancialMemberUnit member(){
      FDataFinancialMemberLogic logic = _logicContext.findLogic(FDataFinancialMemberLogic.class);
      FDataFinancialMemberUnit unit = logic.find(_memberId);
      return unit;
   }

   //============================================================
   // <T>设置成员编号的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMemberId(long value){
      _memberId = value;
   }

   //============================================================
   // <T>判断婚姻状态的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMarriageStatusChanged(){
      return __marriageStatus != _marriageStatus;
   }

   //============================================================
   // <T>获得婚姻状态的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int marriageStatus(){
      return _marriageStatus;
   }

   //============================================================
   // <T>设置婚姻状态的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMarriageStatus(int value){
      _marriageStatus = value;
   }

   //============================================================
   // <T>判断最高学历的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isHighestEducationChanged(){
      return __highestEducation != _highestEducation;
   }

   //============================================================
   // <T>获得最高学历的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int highestEducation(){
      return _highestEducation;
   }

   //============================================================
   // <T>设置最高学历的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setHighestEducation(int value){
      _highestEducation = value;
   }

   //============================================================
   // <T>判断月收入的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isMonthlyIncomeChanged(){
      return __monthlyIncome != _monthlyIncome;
   }

   //============================================================
   // <T>获得月收入的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int monthlyIncome(){
      return _monthlyIncome;
   }

   //============================================================
   // <T>设置月收入的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setMonthlyIncome(int value){
      _monthlyIncome = value;
   }

   //============================================================
   // <T>判断职业的数据是否改变。</T>
   //
   // @return 数据内容
   //============================================================
   public boolean isProfessionChanged(){
      return __profession != _profession;
   }

   //============================================================
   // <T>获得职业的数据内容。</T>
   //
   // @return 数据内容
   //============================================================
   public int profession(){
      return _profession;
   }

   //============================================================
   // <T>设置职业的数据内容。</T>
   //
   // @param value 数据内容
   //============================================================
   public void setProfession(int value){
      _profession = value;
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
         case "member_id":
            return Long.toString(_memberId);
         case "marriage_status":
            return RInteger.toString(_marriageStatus);
         case "highest_education":
            return RInteger.toString(_highestEducation);
         case "monthly_income":
            return RInteger.toString(_monthlyIncome);
         case "profession":
            return RInteger.toString(_profession);
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
         case "member_id":
            _memberId = RLong.parse(value);
            break;
         case "marriage_status":
            _marriageStatus = RInteger.parse(value);
            break;
         case "highest_education":
            _highestEducation = RInteger.parse(value);
            break;
         case "monthly_income":
            _monthlyIncome = RInteger.parse(value);
            break;
         case "profession":
            _profession = RInteger.parse(value);
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
            case "member_id":
               __memberId = RLong.parse(value);
               _memberId = __memberId;
               break;
            case "marriage_status":
               __marriageStatus = RInteger.parse(value);
               _marriageStatus = __marriageStatus;
               break;
            case "highest_education":
               __highestEducation = RInteger.parse(value);
               _highestEducation = __highestEducation;
               break;
            case "monthly_income":
               __monthlyIncome = RInteger.parse(value);
               _monthlyIncome = __monthlyIncome;
               break;
            case "profession":
               __profession = RInteger.parse(value);
               _profession = __profession;
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
      row.set("memberId", _memberId);
      row.set("marriageStatus", _marriageStatus);
      row.set("highestEducation", _highestEducation);
      row.set("monthlyIncome", _monthlyIncome);
      row.set("profession", _profession);
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
      map.put("memberId", RLong.toString(_memberId));
      map.put("marriageStatus", RInteger.toString(_marriageStatus));
      map.put("highestEducation", RInteger.toString(_highestEducation));
      map.put("monthlyIncome", RInteger.toString(_monthlyIncome));
      map.put("profession", RInteger.toString(_profession));
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
      _memberId = input.readInt64();
      _marriageStatus = input.readInt32();
      _highestEducation = input.readInt32();
      _monthlyIncome = input.readInt32();
      _profession = input.readInt32();
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
      output.writeInt64(_memberId);
      output.writeInt32(_marriageStatus);
      output.writeInt32(_highestEducation);
      output.writeInt32(_monthlyIncome);
      output.writeInt32(_profession);
      output.writeInt32(_investmentCount);
      output.writeInt32(_redemptionCount);
      output.writeString(_note);
      output.writeInt64(_createUserId);
      output.writeInt64(_createDate.get());
      output.writeInt64(_updateUserId);
      output.writeInt64(_updateDate.get());
   }
}
